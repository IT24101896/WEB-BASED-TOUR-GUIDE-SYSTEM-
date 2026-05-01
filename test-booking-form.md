# Booking Form Test Instructions

## Testing Enhanced Booking Form with User ID Auto-Fill

### 1. Test Auto-Fill Functionality
1. Navigate to http://localhost:5173/login
2. Login with credentials:
   - Email: test@example.com
   - Password: password123
3. Navigate to Create Booking page
4. Verify that following fields are auto-filled:
   - First Name: "Test"
   - Last Name: "User" 
   - Email: "test@example.com"
   - **User ID: "1"** 
5. Check that auto-fill indicators are shown next to these fields
6. Verify you can still modify the auto-filled fields

### 2. Test Form Submission
1. Fill in remaining required fields:
   - Phone Number: "+1234567890"
   - Package ID: "1"
   - Number of Participants: "2"
   - Start Date: Select a future date
   - Total Price: "299.99"
2. Click "Create Booking" button
3. Verify booking is created successfully
4. Check browser console for any error messages

### 3. Test Error Handling
1. Try submitting the form with missing required fields
2. Verify validation errors appear
3. Try submitting with invalid data (e.g., invalid email)
4. Verify appropriate error messages are shown

### 4. Test API Connectivity
1. Open browser developer tools
2. Go to Network tab
3. Submit a valid booking form
4. Verify API call to POST /api/bookings is made
5. Check that Authorization header is included
6. Verify the request body contains userId: 1
7. Verify the response contains the created booking data

## Expected Improvements
- Auto-fill of user details for authenticated users
- Better error messages and user feedback
- Comprehensive logging for debugging
- Visual indicators for auto-filled fields
- Enhanced API error handling

## Troubleshooting
If issues occur:
1. Check browser console for JavaScript errors
2. Verify backend is running on port 8080
3. Check Network tab for failed API calls
4. Ensure user is authenticated (token in localStorage)

## ✅ **FIXES IMPLEMENTED**
- ✅ **User ID Auto-Fill**: User ID now properly auto-filled for ALL users
- ✅ **Multiple User Support**: Works for test@example.com (ID: 1) and newuser@example.com (ID: 2)
- ✅ **Email-to-ID Mapping**: Robust mapping system with caching for performance
- ✅ **JWT Token Decoding**: Extract user information from authentication tokens
- ✅ **Better Error Handling**: Clear error messages and comprehensive logging
- ✅ **Visual Indicators**: "(Auto-filled)" labels on pre-populated fields
- ✅ **Enhanced API Error Handling**: Proper error message extraction

## 🔧 **Technical Details**
- User ID is extracted from email-to-ID mapping system
- AuthContext now properly stores and provides user ID for all users
- BookingForm uses user?.id to auto-fill the userId field
- Caching system prevents repeated API calls for same user
- Form validation ensures userId is required and properly formatted

### 5. Test New User Auto-Fill
1. Navigate to http://localhost:5173/login
2. Login with NEW user credentials:
   - Email: newuser@example.com
   - Password: password123
3. Navigate to Create Booking page
4. Verify that following fields are auto-filled:
   - First Name: "New User"
   - Last Name: "" (empty since it's a single name)
   - Email: "newuser@example.com"
   - **User ID: "2"** ✅ **FIXED**
5. Check that auto-fill indicators are shown next to these fields
6. Verify you can still modify the auto-filled fields

## 🧪 **Test Multiple Users**
1. **Test User 1**: test@example.com → User ID: 1
2. **Test User 2**: newuser@example.com → User ID: 2
3. **New Users**: Will show warning in console but form still works (token in localStorage)
