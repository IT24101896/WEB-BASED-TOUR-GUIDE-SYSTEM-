import React from 'react';
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
import { AuthProvider } from './contexts/AuthContext';
import { ToastProvider } from './contexts/ToastContext';
import { ConfirmProvider } from './contexts/ConfirmContext';
import { FavoritesProvider } from './contexts/FavoritesContext';
import Header from './components/common/Header';
import ChatbotIcon from './components/common/ChatbotIcon';
import HomeRoute from './components/HomeRoute';
import Dashboard from './pages/Dashboard';
import AdminDashboard from './pages/AdminDashboard';
import BookingsPage from './pages/BookingsPage';
import CreateBookingPage from './pages/CreateBookingPage';
import EditBookingPage from './pages/EditBookingPage';
import PaymentPage from './pages/PaymentPage';
import ProfilePage from './pages/ProfilePage';
import GuideSelectionPage from './pages/GuideSelectionPage';
import GuideApplicationPage from './pages/GuideApplicationPage';
import LoginPage from './pages/LoginPage';
import RegisterPage from './pages/RegisterPage';
import SocialMediaConnectionPage from './pages/SocialMediaConnectionPage';
import PreferenceQuestionnairePage from './pages/PreferenceQuestionnairePage';
import RecommendationResultsPage from './pages/RecommendationResultsPage';
import SelectedDestinationsPage from './pages/SelectedDestinationsPage';
import TourRoutePlanningPage from './pages/TourRoutePlanningPage';
import PackageCreationPage from './pages/PackageCreationPage';
import StatisticsPage from './pages/StatisticsPage';
import ChatbotPage from './pages/ChatbotPage';
import TourReviewPage from './pages/TourReviewPage';
import GuideRatingPage from './pages/GuideRatingPage';
import BookingDetailsPage from './pages/BookingDetailsPage';
import CalendarPage from './pages/CalendarPage';
import ProtectedRoute from './components/ProtectedRoute';
import AdminRoute from './components/AdminRoute';
import GuideRoute from './components/GuideRoute';
import GuideDashboard from './pages/GuideDashboard';
import ConfirmPayment from './pages/ConfirmPayment';
import PaymentSuccess from './pages/PaymentSuccess';
import PaymentFailed from './pages/PaymentFailed';
import './styles/global.css';

function App() {
  return (
    <ConfirmProvider>
      <ToastProvider>
        <AuthProvider>
          <FavoritesProvider>
            <Router>
              <div className="App">
                <ChatbotIcon />
                <Routes>
                {/* Public routes */}
                <Route path="/" element={
                  <>
                    <Header />
                    <main className="container main-content">
                      <HomeRoute />
                    </main>
                  </>
                } />
                <Route path="/login" element={<LoginPage />} />
                <Route path="/register" element={<RegisterPage />} />
                
                <Route path="/social-connect" element={
                  <>
                    <Header />
                    <main className="container main-content">
                      <SocialMediaConnectionPage />
                    </main>
                  </>
                } />
                
                <Route path="/preferences" element={
                  <>
                    <Header />
                    <main className="container main-content">
                      <PreferenceQuestionnairePage />
                    </main>
                  </>
                } />
                
                <Route path="/recommendations" element={
                  <>
                    <Header />
                    <main className="container main-content">
                      <RecommendationResultsPage />
                    </main>
                  </>
                } />
                
                <Route path="/selected-destinations" element={
                  <>
                    <Header />
                    <main className="container main-content">
                      <SelectedDestinationsPage />
                    </main>
                  </>
                } />
                
                <Route path="/bookings" element={
                  <ProtectedRoute>
                    <Header />
                    <main className="container main-content">
                      <BookingsPage />
                    </main>
                  </ProtectedRoute>
                } />
                
                <Route path="/bookings/new" element={
                  <ProtectedRoute>
                    <Header />
                    <main className="container main-content">
                      <CreateBookingPage />
                    </main>
                  </ProtectedRoute>
                } />
                
                <Route path="/bookings/:id/tour-review" element={
                  <ProtectedRoute>
                    <Header />
                    <main className="container main-content">
                      <TourReviewPage />
                    </main>
                  </ProtectedRoute>
                } />
                
                <Route path="/bookings/:id/guide-rating" element={
                  <ProtectedRoute>
                    <Header />
                    <main className="container main-content">
                      <GuideRatingPage />
                    </main>
                  </ProtectedRoute>
                } />
                
                <Route path="/bookings/:id/edit" element={
                  <ProtectedRoute>
                    <Header />
                    <main className="container main-content">
                      <EditBookingPage />
                    </main>
                  </ProtectedRoute>
                } />
                
                <Route path="/bookings/:id/payment" element={
                  <ProtectedRoute>
                    <Header />
                    <main className="container main-content">
                      <PaymentPage />
                    </main>
                  </ProtectedRoute>
                } />
                
                <Route path="/bookings/:id" element={
                  <ProtectedRoute>
                    <Header />
                    <main className="container main-content">
                      <BookingDetailsPage />
                    </main>
                  </ProtectedRoute>
                } />
                
                <Route path="/route-planning" element={
                  <ProtectedRoute>
                    <Header />
                    <main className="container main-content">
                      <TourRoutePlanningPage />
                    </main>
                  </ProtectedRoute>
                } />
                
                <Route path="/guide-selection" element={
                  <ProtectedRoute>
                    <Header />
                    <main className="container main-content">
                      <GuideSelectionPage />
                    </main>
                  </ProtectedRoute>
                } />
                
                <Route path="/package-creation" element={
                  <ProtectedRoute>
                    <Header />
                    <main className="container main-content">
                      <PackageCreationPage />
                    </main>
                  </ProtectedRoute>
                } />
                
                <Route path="/statistics" element={
                  <ProtectedRoute>
                    <Header />
                    <main className="container main-content">
                      <StatisticsPage />
                    </main>
                  </ProtectedRoute>
                } />
                
                <Route path="/profile" element={
                  <ProtectedRoute>
                    <Header />
                    <main className="container main-content">
                      <ProfilePage />
                    </main>
                  </ProtectedRoute>
                } />
                
                <Route path="/guide-application" element={
                  <ProtectedRoute>
                    <Header />
                    <main className="container main-content">
                      <GuideApplicationPage />
                    </main>
                  </ProtectedRoute>
                } />
                
                <Route path="/dashboard" element={
                  <ProtectedRoute>
                    <Header />
                    <main className="container main-content">
                      <Dashboard />
                    </main>
                  </ProtectedRoute>
                } />
                
                <Route path="/chatbot" element={
                  <ProtectedRoute>
                    <Header />
                    <main className="container main-content">
                      <ChatbotPage />
                    </main>
                  </ProtectedRoute>
                } />
                
                <Route path="/admin" element={
                  <AdminRoute>
                    <Header />
                    <main className="container main-content">
                      <AdminDashboard />
                    </main>
                  </AdminRoute>
                } />
                
                <Route path="/guide-dashboard" element={
                  <GuideRoute>
                    <GuideDashboard />
                  </GuideRoute>
                } />
                
                <Route path="/calendar" element={
                  <>
                    <Header />
                    <main className="container main-content">
                      <CalendarPage />
                    </main>
                  </>
                } />
                
                <Route path="/confirm-payment" element={<ConfirmPayment />} />
                <Route path="/payment-success" element={<PaymentSuccess />} />
                <Route path="/payment-failed" element={<PaymentFailed />} />
                              </Routes>
              </div>
            </Router>
          </FavoritesProvider>
        </AuthProvider>
      </ToastProvider>
    </ConfirmProvider>
  );
}

export default App;
