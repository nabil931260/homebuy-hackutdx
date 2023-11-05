/*export default function handleLoginFormSubmit() {
  // Select the form element from the DOM
  const loginForm = document.querySelector('#login-form');

  // Add an event listener to the form for when it is submitted
  loginForm.addEventListener('submit', (event) => {
    // Prevent the default form submission behavior
    event.preventDefault();

    // Get the values of the email and password fields
    const email = document.querySelector('#email').value;
    const password = document.querySelector('#password').value;

    // Send a request to the server to authenticate the user
    fetch('/api/login', {
      method: 'POST',
      body: JSON.stringify({ email, password }),
      headers: {
        'Content-Type': 'application/json'
      }
    })
    .then(response => {
      if (response.ok) {
        // Redirect the user to the dashboard page if authentication is successful
        window.location.href = '/dashboard';
      } else {
        // Display an error message if authentication fails
        const errorMessage = document.querySelector('#error-message');
        errorMessage.textContent = 'Invalid email or password';
      }
    })
    .catch(error => {
      console.error('Error:', error);
    });
  });
}*/
