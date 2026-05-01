# Tour Guide Booking System - Frontend

A React 18.2.0 frontend application for managing tour guide bookings, built with Vite and integrated with a Spring Boot backend.

## 🚀 Getting Started

### Prerequisites
- Node.js 18+ installed
- Spring Boot backend running on port 8080

### Installation

1. Navigate to the frontend directory:
```bash
cd frontend
```

2. Install dependencies:
```bash
npm install
```

3. Start the development server:
```bash
npm run dev
```

The application will be available at `http://localhost:5173/`

## 🛠️ Technology Stack

- **React 18.2.0** - UI framework
- **Vite 4.4.5** - Build tool and dev server
- **React Router DOM 6.20.0** - Client-side routing
- **Axios 1.6.2** - HTTP client for API calls
- **ESLint** - Code linting

## 📁 Project Structure

```
frontend/
├── src/
│   ├── components/
│   │   ├── common/
│   │   │   ├── Header.jsx - Navigation header
│   │   │   └── LoadingSpinner.jsx - Loading component
│   │   └── booking/
│   │       ├── BookingList.jsx - List of all bookings
│   │       ├── BookingCard.jsx - Individual booking card
│   │       ├── BookingForm.jsx - Create/edit booking form
│   │       └── BookingDetails.jsx - Detailed booking view
│   ├── pages/
│   │   ├── Home.jsx - Landing page
│   │   ├── BookingsPage.jsx - Main booking management page
│   │   ├── CreateBookingPage.jsx - Create new booking
│   │   ├── BookingDetailsPage.jsx - View booking details
│   │   └── EditBookingPage.jsx - Edit existing booking
│   ├── services/
│   │   ├── api.js - Axios configuration
│   │   └── bookingService.js - Booking API service
│   ├── hooks/
│   │   └── useBookings.js - Custom booking hook
│   ├── utils/
│   │   └── dateUtils.js - Utility functions
│   ├── styles/
│   │   └── global.css - Global styles
│   ├── App.jsx - Main app component with routing
│   └── main.jsx - App entry point
├── package.json
└── vite.config.js - Vite configuration with proxy
```

## 🔧 Features

### Booking Management
- **Create**: Add new bookings with user, package, and guide information
- **Read**: View all bookings with filtering by status
- **Update**: Edit booking details, dates, and assigned guides
- **Delete**: Remove bookings with confirmation
- **Cancel**: Cancel bookings (changes status to CANCELLED)

### User Interface
- **Responsive Design**: Works on desktop and mobile devices
- **Real-time Updates**: Instant UI updates after booking changes
- **Status Management**: Visual indicators for booking statuses
- **Form Validation**: Input validation for all booking forms
- **Error Handling**: User-friendly error messages and loading states

### Booking Statuses
- **PENDING**: Initial booking status
- **CONFIRMED**: Booking confirmed by system
- **CANCELLED**: Booking cancelled by user
- **COMPLETED**: Booking successfully completed

## 🌐 API Integration

The frontend communicates with the Spring Boot backend through these endpoints:

- `GET /api/bookings` - Get all bookings
- `GET /api/bookings/{id}` - Get booking by ID
- `POST /api/bookings` - Create new booking
- `PUT /api/bookings/{id}` - Update booking
- `DELETE /api/bookings/{id}` - Delete booking
- `PUT /api/bookings/{id}/cancel` - Cancel booking

## 🎨 Styling

The application uses custom CSS with a utility-first approach:
- Clean, modern design with card-based layouts
- Consistent color scheme for status indicators
- Responsive grid system for different screen sizes
- Hover effects and transitions for better UX

## 🔧 Development

### Available Scripts
- `npm run dev` - Start development server
- `npm run build` - Build for production
- `npm run preview` - Preview production build
- `npm run lint` - Run ESLint

### Proxy Configuration
The Vite configuration includes a proxy to forward API requests to the Spring Boot backend running on `http://localhost:8080`.

## 📱 Usage

1. **Navigate to Home**: View the landing page with feature overview
2. **Create Booking**: Click "Create New Booking" to add a new booking
3. **View Bookings**: Browse all bookings with status filtering
4. **Manage Bookings**: View details, edit, cancel, or delete bookings
5. **Real-time Updates**: All changes are reflected immediately in the UI

## 🚨 Important Notes

- Ensure the Spring Boot backend is running on port 8080 before starting the frontend
- The frontend uses a proxy to handle CORS between development server and backend
- All date/times are handled in ISO format and displayed in user's local timezone
- Form validation ensures required fields are completed before submission

## 🔄 Backend Integration

The frontend is designed to work seamlessly with the Spring Boot booking management system. Make sure your backend includes:

- Booking entity with all required fields
- REST endpoints for CRUD operations
- CORS configuration for frontend access
- Proper error handling and validation
