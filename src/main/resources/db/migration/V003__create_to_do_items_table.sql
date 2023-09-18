CREATE TABLE IF NOT EXISTS to_do_items (
    id UUID PRIMARY KEY,
    list_id UUID REFERENCES to_do_list(id),
    due_date DATE,
    description TEXT,
    priority VARCHAR(50),
    status VARCHAR(50) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);
