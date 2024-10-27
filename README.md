# Crypto Trading System

## Description
This project is a simple crypto trading system built with the Spring Boot framework and an in-memory H2 database. It allows users to trade between USDT and two supported cryptocurrencies: Ethereum (ETH) and Bitcoin (BTC). The system provides APIs for buying and selling, viewing wallet balances, checking trade history, and retrieving the latest aggregated prices from Binance and Huobi exchanges.

## Functional Scope
The system provides the following features:

1. **Crypto Trading (Buy/Sell)**: Users can buy and sell the supported crypto trading pairs.
2. **Trading History**: Users can view a list of all their trading transactions.
3. **Wallet Balance**: Users can view their wallet balance for supported cryptocurrencies and USDT.

## API Endpoints

### Price Aggregation API
- Aggregates pricing data every 10 seconds from Binance and Huobi.
- Stores the best bid and ask prices in the database.
- **GET** `/api/price/latest`: Retrieves the latest best aggregated price.

### Trading API
- Allows users to trade based on the latest aggregated price.
- **POST** `/api/trade/execute`: Executes a buy or sell trade for the user. Requires request parameters such as:
    -  `userId` id of user
    - `currencyPair` (e.g., ETH/USD or BTC/USD)
    - `amount` number
    - `price` number
    - `type` (BUY or SELL)

### Wallet Balance API
- **GET** `/api/wallets/info/{userId}`: Returns the current crypto and USDT balance for the user.

### Trading History API
- **GET** `/api/trade/history`: Retrieves a list of the user’s past trading transactions.
- 
### Get Latest Prices API
- **GET** `/api/prices/latest`: Retrieves a list of the latest prices.
