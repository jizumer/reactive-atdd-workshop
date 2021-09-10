import { useEffect } from 'react'
import { useQuery } from "react-query";

function Status() {

  const { isLoading, error, data, refetch: refetchStatus } = useQuery("repoData", () =>
    fetch("http://localhost:8080/status").then((res) => res.json())
  );

  if (isLoading) return "Loading...";

  if (error) return "An error has occurred: " + error.message;

  return (
    <div>
      <h1>
        Application status requests: <code>{data.numberOfStatusRequests}</code>
      </h1>
      <h2>
        Last time updated: <time>{data.startTimestamp}</time>
      </h2>

      <button
        onClick={async () => {
          await refetchStatus()
        }}>
        Update status
      </button>
    </div>
  );
}

export default Status