CREATE TABLE IF NOT EXISTS tb_auth_roles (
    id SERIAL PRIMARY KEY,
    auth_id INTEGER,
    FOREIGN KEY (auth_id) REFERENCES tb_auth(id),
    role_id INTEGER,
    FOREIGN KEY (role_id) REFERENCES tb_roles(id)
)

insert into tb_auth_roles values (1, 1, 1);