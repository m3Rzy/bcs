DROP TABLE gmv;

CREATE TABLE IF NOT EXISTS gmv (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    title VARCHAR,
    amount DECIMAL
);