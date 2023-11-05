import { initializeApp } from "firebase/app";
import {getAuth, GoogleAuthProvider} from 'firebase/auth';
const firebaseConfig = {
  apiKey: "AIzaSyBBTe3VqJ6EZu71QLkLqoQksEXnEjfI8V4",
  authDomain: "fanniemae-70dde.firebaseapp.com",
  projectId: "fanniemae-70dde",
  storageBucket: "fanniemae-70dde.appspot.com",
  messagingSenderId: "1070665513716",
  appId: "1:1070665513716:web:16b2120c55c2480c7fbca1"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
const auth = getAuth(app);
const provider = new GoogleAuthProvider();
export {auth, provider};