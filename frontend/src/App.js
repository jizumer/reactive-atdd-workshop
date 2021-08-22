import logo from './logo.svg';
import './App.css';
import { getStatus } from './api';

function App() {
  let status = 'Loading';
  getStatus().then(data => {status = data.body});
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Application status: <code>{status}</code>.
        </p>
      </header>
    </div>
  );
}

export default App;
