DROP TABLE IF EXISTS gmv, waste;

CREATE TABLE IF NOT EXISTS gmv (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    title VARCHAR,
    amount DECIMAL
);

CREATE TABLE IF NOT EXISTS waste (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    title VARCHAR,
    symbol CHAR,
    amount DECIMAL
);