require('dotenv').config({ path: '/Users/kasunathauda/Downloads/Tour_Guide/Tour-Guide-booking/.env' });

const express = require('express');
const cors = require('cors');
const crypto = require('crypto');

const app = express();
app.use(cors({ origin: true, credentials: true }));
app.use(express.json());
app.use(express.urlencoded({ extended: true }));

const MERCHANT_ID = '1234702';
const MERCHANT_SECRET = process.env.MERCHANT_SECRET || 'ODMwODY1OTExNDA4ODcwMzk0Nzk5MzczNjAyMzc0NTg5Njg2NQ==';

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
  console.log('=== PAYHERE PAYMENT NOTIFICATION ===');
  console.log('Order ID     :', req.body.order_id);
  console.log('Status Code  :', req.body.status_code);
  console.log('Amount       :', req.body.payhere_amount);
  console.log('Method       :', req.body.method);
  console.log('Full body    :', req.body);
  res.sendStatus(200);
});

app.get('/health', (req, res) => res.json({ status: 'ok' }));

app.listen(5000, () => {
  console.log('✅ PayHere backend running on http://localhost:5000');
});
