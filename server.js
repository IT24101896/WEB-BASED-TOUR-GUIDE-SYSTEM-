const express = require('express');
const cors = require('cors');
const crypto = require('crypto');
require('dotenv').config();

const app = express();
app.use(cors({ origin: ['http://localhost:5173', 'http://localhost:3000'] }));
app.use(express.json());
app.use(express.urlencoded({ extended: true }));

const MERCHANT_ID = '1235290';
const MERCHANT_SECRET = process.env.MERCHANT_SECRET;

function md5Upper(str) {
  return crypto.createHash('md5').update(str).digest('hex').toUpperCase();
}

app.post('/generate-hash', (req, res) => {
  const { order_id, amount, currency } = req.body;
  const amountFormatted = parseFloat(amount).toFixed(2);
  const hashedSecret = md5Upper(MERCHANT_SECRET);
  const hash = md5Upper(
    MERCHANT_ID + order_id + amountFormatted + currency + hashedSecret
  );
  console.log('=== /generate-hash ===');
  console.log('Order ID :', order_id);
  console.log('Amount   :', amountFormatted);
  console.log('Hash     :', hash);
  res.json({ hash, merchant_id: MERCHANT_ID });
});

app.post('/payment-notify', (req, res) => {
  console.log('=== PAYHERE NOTIFICATION ===');
  console.log('Order ID    :', req.body.order_id);
  console.log('Status Code :', req.body.status_code);
  console.log('Amount      :', req.body.payhere_amount);
  console.log('Full body   :', req.body);
  res.sendStatus(200);
});

app.listen(5001, () => {
  console.log('Backend running on http://localhost:5001');
});
