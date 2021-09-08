import React from "react";
import { getBTCSpotPrice } from "./BTCGateway";

class BTCPriceComponent extends React.Component {

  /**
   * From React Docs:
   * If you don’t initialize state and you don’t bind methods, you don’t need to implement a constructor for your React component.
   * This is included for illustration purposes
   */
  constructor(props) {
    super(props);
    this.state = {
      btcSpotPrice: null
    }
  }

  async componentDidMount() {
    console.log('Component just rendered')
    await this.fetchBTCPrice()
  }

  componentDidUpdate(prevProps, prevState) {
    console.log('Component just updated')
    console.log('Previous component state and props', prevProps, prevState)
    console.log('Current component state and props', this.props, this.state)
  }

  componentWillUnmount() {
    console.log('Component is about to be unmounted')
  }

  async fetchBTCPrice() {
    console.log('Getting BTC Price')
    const btcSpotPrice = await getBTCSpotPrice()
    this.setState({ btcSpotPrice })
  }

  render() {
    const  { btcSpotPrice } = this.state
    const { textColor } = this.props
    return (
      <div>
        <h1>BTC Spot Price </h1>
        {
          btcSpotPrice && (
            <>
              <h2 style={{ color: textColor}}>
                {btcSpotPrice.amount} {btcSpotPrice.currency}
              </h2>
              <button
                onClick={async () => await this.fetchBTCPrice()}
              >Fetch again</button>
            </>
          )
        }
      </div>
    );
  }
}

BTCPriceComponent.defaultProps = {
  textColor: 'green'
}

export default BTCPriceComponent