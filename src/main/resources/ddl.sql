DROP TABLE IF EXISTS assets ;
CREATE TABLE assets ( id VARCHAR GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY, name VARCHAR(50) NOT NULL, amount decimal);