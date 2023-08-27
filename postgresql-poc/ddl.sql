CREATE SEQUENCE public.sq_tb_churrasqueira
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

CREATE TABLE public.tb_churrasqueira (
	id_churrasqueira int4 NOT NULL DEFAULT nextval('sq_tb_churrasqueira'::regclass),
	ds_setor varchar(20) NOT NULL,
	id_ultima_reserva int4 NULL,
	CONSTRAINT tb_sq_tb_churrasqueira_pkey PRIMARY KEY (id_churrasqueira)
);

CREATE SEQUENCE public.sq_tb_reserva
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

CREATE TABLE public.tb_reserva (
	id_reserva int4 NOT NULL DEFAULT nextval('sq_tb_reserva'::regclass),
	id_churrasqueira int4 NOT NULL,
	dh_reserva timestamp NOT NULL DEFAULT now()::TIMESTAMP WITHOUT TIME ZONE,
	CONSTRAINT tb_sq_tb_reserva_pkey PRIMARY KEY (id_reserva),
	CONSTRAINT fk_tb_churrasqueira FOREIGN KEY(id_churrasqueira)
		REFERENCES public.tb_churrasqueira(id_churrasqueira)
);

ALTER TABLE public.tb_churrasqueira ADD CONSTRAINT fk_tb_reserva FOREIGN KEY(id_ultima_reserva)
	REFERENCES public.tb_reserva(id_reserva);