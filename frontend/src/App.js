import { useState } from "react";
import { QueryClient, QueryClientProvider, useQuery } from "react-query";
import logo from "./logo.svg";
import "./App.css";

const queryClient = new QueryClient();
import BTCPriceComponent from "./components/BTCPriceComponent";

function App() {
  const [showClassComponent,setShowClassComponent] = useState(true)

  const toggleClassComponent = () => {
    setShowClassComponent(!showClassComponent)
  }

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />

        <QueryClientProvider client={queryClient}>
          <Status />
        </QueryClientProvider>
      </header>
      <h1>Class component</h1>

      {showClassComponent && <BTCPriceComponent textColor="red" />}

      <button onClick={toggleClassComponent}>Toggle class component</button>

    </div>
  );
}

function Status() {
  const [numberOfStatusRequests, setNumberOfStatusRequests] = react.useState(0);
  const [startTimestamp, setStartTimestamp] = react.useState("Init");

  const { isLoading, error, data } = useQuery("repoData", () =>
    fetch("http://localhost:8081/status").then((res) => res.json())
  );

  if (isLoading) return "Loading...";

  if (error) return "An error has occurred: " + error.message;

  return (
    <div>
      <h1>
        Application status requests: <code>{numberOfStatusRequests}</code>
      </h1>
      <h2>
        Last time updated: <time>{startTimestamp}</time>
      </h2>

      <button
        onClick={() => {
          setNumberOfStatusRequests(data.numberOfStatusRequests);
          setStartTimestamp(data.startTimestamp);
        }}>
        Update status
      </button>
    </div>
  );
}

export default App;
