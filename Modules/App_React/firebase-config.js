// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
import { getFirestore } from 'firebase/firestore'

// Your web app's Firebase configuration
const firebaseConfig = {
    apiKey: "AIzaSyCP8qL8z9BorGF3NZJsGb4vSaWHYyCVfc8",
    authDomain: "todo-firebase-alan.firebaseapp.com",
    projectId: "todo-firebase-alan",
    storageBucket: "todo-firebase-alan.appspot.com",
    messagingSenderId: "892581913000",
    appId: "1:892581913000:web:dbe08ac753c3adaab87d9d"
};

// Initialize Firebase
export const app = initializeApp(firebaseConfig);
export const database = getFirestore(app);
