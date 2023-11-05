import React, { useState, useEffect } from 'react';

function EvalPotentialHomeBuyer() {
  const [data, setData] = useState([]);

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
}

export default EvalPotentialHomeBuyer;
