const express = require('express');
const app = express();
const port = 5000; // Port on which the Node.js server will run

app.use(express.json());

// Define routes for your API
app.get('http://localhost:5000/api/data', (req, res) => {
  // Here, you can interact with your Java backend to fetch data
  // You can use Java's ProcessBuilder or make HTTP requests to Java services
  // Example: Use 'child_process' module to execute a Java program
  const { spawn } = require('child_process');
  const javaProcess = spawn('java', ['Main.class', arg1, arg2]);

  javaProcess.stdout.on('data', (data) => {
    // Handle the data returned from the Java process
    res.json({ result: data.toString() });
  });

  javaProcess.stderr.on('data', (error) => {
    // Handle errors if any
    console.error(`Java process error: ${error.toString()}`);
    res.status(500).json({ error: 'Internal Server Error' });
  });
});

// Start the Node.js server
app.listen(port, () => {
  console.log(`Node.js server is running on port ${port}`);
});
