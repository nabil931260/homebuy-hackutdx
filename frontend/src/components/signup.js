import React, { useEffect, useState } from "react";
import { auth, provider } from '../components/config';
import { signInWithPopup } from "firebase/auth";

function Signup() {
    const [value, setValue] = useState('');

    const handleClick = (event) => {
        signInWithPopup(auth, provider).then((data) => {
            setValue(data.user.email);
            localStorage.setItem('email', data.user.email);
        });
    }

    useEffect(() => {
        setValue(localStorage.getItem('email'));
    }, []); // Pass an empty dependency array

    return (
        <div>
            {value ? <helloworld /> :
                <button onClick={handleClick}>Sign in with Google</button>
            }
        </div>
    );
}

export default Signup;
