import { useState } from "react";
import { QueryClient, QueryClientProvider } from "react-query";
import BTCPriceComponent from "./components/BTCPriceComponent";
import Status from "./components/StatusComponent";
import "./App.css";

const queryClient = new QueryClient();

function App() {
  const [showClassComponent,setShowClassComponent] = useState(false)
  const [showFunctionComponent, setShowFunctionCompoent] = useState(false)

  const toggleClassComponent = () => {
    setShowClassComponent(!showClassComponent)
  }

  const toggleFunctionComponent = () => {
    setShowFunctionCompoent(!showFunctionComponent)
  }

  return (
    <div className="App">
      <h1>Class component</h1>

      {showClassComponent && <BTCPriceComponent />}

      <button onClick={toggleClassComponent}>Toggle class component</button>

      <h1>Function component</h1>

      <QueryClientProvider client={queryClient}>
        {showFunctionComponent && <Status />}
      </QueryClientProvider>

      <button onClick={toggleFunctionComponent}>Toggle function component</button>
    </div>
  );
}



export default App;
