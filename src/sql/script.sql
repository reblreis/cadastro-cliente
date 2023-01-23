create table cliente(
	idCliente		serial			primary key,
	nome			varchar(150)	not null,
	email			varchar(100)	not null
);

// varchar = limite de até 150 