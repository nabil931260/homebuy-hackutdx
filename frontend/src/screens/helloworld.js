import React from "react";
/*import LogIn from "../components/login";*/
/*import SignUp from "../components/signup";*/
import "../index.css";


/*function clickMeLogin() {
  return(
    <div className="clickMeLogin">
      <LogIn />
    </div>
  );
}*/

function clickMeSignUp() {
  return(
    <div className="clickMeSignUp">
    </div>
  );
}

function helloWorld() {
  return(
    <div className="helloWorld">
      <img scr='./assets/fanniemae.png' alt="Fannie Mae Logo" />
      <h1>Welcome to Fannie Mae!</h1>
      <p className="ready?">Ready to buy a new home?</p>
      <p>Login or Sign Up below!</p>
      
      <button onClick={clickMeSignUp}>Sign Up!</button>
    </div>
  );
}

export default helloWorld;