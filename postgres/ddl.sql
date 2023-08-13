CREATE SEQUENCE public.sq_tb_desafio
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

CREATE TABLE public.tb_desafio (
	id_desafio int4 NOT NULL DEFAULT nextval('sq_tb_desafio'::regclass),
	ds_pergunta varchar(200) NOT NULL,
	ds_resposta varchar(100) NOT NULL,
	ds_chaves varchar(100) NULL,
	CONSTRAINT tb_desafio_pkey PRIMARY KEY (id_desafio)	
);
CREATE INDEX idx_tb_desafio_ds_chaves ON public.tb_desafio USING btree (ds_chaves);
CREATE INDEX idx_tb_desafio_ds_pergunta ON public.tb_desafio USING btree (ds_pergunta);