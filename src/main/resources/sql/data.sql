-- Insert sample users
INSERT INTO USER_ACCOUNT (id, username, email, created_at) VALUES
  (1, 'john_doe', 'john.doe@example.com', CURRENT_TIMESTAMP),
  (2, 'alice_jones', 'alice.jones@example.com', CURRENT_TIMESTAMP),
  (3, 'jane_smith', 'jane.smth@example.com', CURRENT_TIMESTAMP);

-- Insert sample wallets
INSERT INTO WALLET (id, user_id, currency, balance, created_at, updated_at) VALUES
  (1, (SELECT id FROM USER_ACCOUNT WHERE username = 'john_doe'), 'USD', 5000.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
  (2, (SELECT id FROM USER_ACCOUNT WHERE username = 'jane_smith'), 'USD', 5000.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
  (3, (SELECT id FROM USER_ACCOUNT WHERE username = 'alice_jones'), 'JPY', 5000.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Insert sample transactions
--INSERT INTO Transaction (id, user_id, currency_pair, transaction_type, amount, price, created_at) VALUES
--  (1, (SELECT id FROM USER_ACCOUNT WHERE username = 'john_doe'), 'BTC/USD', 'BUY', 0.5, 30000.00, CURRENT_TIMESTAMP),
--  (2, (SELECT id FROM USER_ACCOUNT WHERE username = 'jane_smith'), 'ETH/USD', 'SELL', 1.0, 2000.00, CURRENT_TIMESTAMP),
--  (3, (SELECT id FROM USER_ACCOUNT WHERE username = 'alice_jones'), 'LTC/JPY', 'BUY', 10.0, 8000.00, CURRENT_TIMESTAMP);