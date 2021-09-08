
export const getBTCSpotPrice = async () => {
  try{
    return (await fetch('http://localhost:8080/price/btc')).json()
  }catch(error){
    throw error;
  }
}

