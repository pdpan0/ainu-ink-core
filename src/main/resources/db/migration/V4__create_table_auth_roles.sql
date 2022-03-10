CREATE TABLE IF NOT EXISTS tb_auth_roles (
    id SERIAL PRIMARY KEY,
    auth_id INTEGER NOT NULL,
    FOREIGN KEY (auth_id) REFERENCES tb_auth(id),
    role_id INTEGER NOT NULL,
    FOREIGN KEY (role_id) REFERENCES tb_roles(id)
)