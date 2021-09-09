import react, { Component } from "react";
import logo from "./logo.svg";
import "./App.css";

function App() {
  const [status, setStatus] = react.useState(0);

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Application status: <code>{status}</code>
        </p>
        <button onClick={() => setStatus(status + 1)}>Update status</button>
      </header>
    </div>
  );
}

export default App;
