import React from 'react'
import ReactDOM from 'react-dom'
import { axios } from 'axios';


<<<<<<< HEAD
  useEffect(() => {
    fetch('http://localhost:5000/api/data')
      .then((response) => {
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        return response.json();
      })
      .then((data) => setData(data.result))
      .catch((error) => console.error('Fetch error:', error));
  }, []); 
  

  return (
    <div>
      <h1>Data Display</h1>
      <ul>
        {data.map((item, index) => (
          <li key={index}>{item}</li>
        ))}
      </ul>
    </div>
  );
=======
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