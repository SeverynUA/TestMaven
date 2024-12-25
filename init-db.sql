CREATE TABLE notice (
        id SERIAL PRIMARY KEY,
        message TEXT NOT NULL,
        type VARCHAR(255) NOT NULL,
        processed BOOLEAN DEFAULT FALSE
);
