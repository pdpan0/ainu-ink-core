CREATE TABLE IF NOT EXISTS tb_user (
	id SERIAL PRIMARY KEY,
	name VARCHAR NOT NULL,
	birth TIMESTAMP NOT NULL,
	email VARCHAR NOT NULL UNIQUE,
	cpf VARCHAR NOT NULL UNIQUE,
	created_at TIMESTAMP DEFAULT NOW()
);

insert into tb_user(name, birth, email, cpf) values('Lucas Martins', '16-02-2001', 'lucas@ainu.com.br', '12312312342');
insert into tb_user(name, birth, email, cpf) values('Bruno Paneli', '16-12-1987', 'bruno@ainu.com.br', '12312312341');