CREATE TABLE IF NOT EXISTS tb_roles (
	id SERIAL PRIMARY KEY,
	name VARCHAR NOT NULL UNIQUE,
	is_active BOOL DEFAULT TRUE
);

insert into tb_roles values (1, 'admin');