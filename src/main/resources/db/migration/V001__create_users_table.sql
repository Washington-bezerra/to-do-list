CREATE TABLE IF NOT EXISTS users (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE, -- Adicione a restrição UNIQUE aqui
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);
