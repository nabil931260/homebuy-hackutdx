import React from 'react'
import ReactDOM from 'react-dom'
import { axios } from 'axios';


export default function evalpotentialhomebuyer() {
    axios.get('http://localhost:8080/api/v1/users')
    .then((response) => {
      console.log(response.data);
    })
    .catch((error) => {
      console.log(error);
    })
    return (
        <div>
          <h1>My React Frontend Application</h1>
          <ul>
            {users.map((user) => (
              <li key={user.id}>{user.name}</li>
            ))}
          </ul>
        </div>
      );      
}
