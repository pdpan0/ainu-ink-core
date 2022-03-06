CREATE TABLE IF NOT EXISTS tb_auth (
	id SERIAL PRIMARY KEY,
	username VARCHAR NOT NULL UNIQUE,
	password VARCHAR NOT NULL,
	user_id INTEGER,
	last_login TIMESTAMP,
	is_active BOOL DEFAULT TRUE,
	FOREIGN KEY (user_id) REFERENCES tb_user(id)
);

insert into tb_auth values (1, 'lucas.martins', 'teste123', 1, null);