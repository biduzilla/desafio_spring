use desafio_db;

create table tab_marca (
	marca_id varchar(255) not null,
	marca_ativo boolean,
    marca_cod_denatran varchar(255),
    marca_nome varchar(255),
	primary key (marca_id)
	);

create table tab_modelo (
	modelo_id varchar(255) not null,
	modelo_ano integer,
	modelo_ativo boolean,
	modelo_nome varchar(255),
	ref_marca varchar(255),
    primary key (modelo_id),
	constraint fk_tab_modelo_marca foreign key(ref_marca) references tab_marca(marca_id)
	);