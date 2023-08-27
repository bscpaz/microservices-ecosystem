DO $$
DECLARE
BEGIN
    IF NOT EXISTS (
        SELECT 1 FROM information_schema.tables
		WHERE table_schema = 'desafio' AND table_name = 'sq_tb_desafio') THEN

        CREATE TABLE desafio.tb_desafio (
            id_desafio int4 NOT NULL DEFAULT nextval('desafio.sq_tb_desafio'::regclass),
            ds_pergunta varchar(200) NOT NULL,
            ds_resposta varchar(100) NOT NULL,
            ds_chaves varchar(100) NULL,
            CONSTRAINT tb_desafio_pkey PRIMARY KEY (id_desafio)
        );

        CREATE INDEX idx_tb_desafio_ds_chaves ON desafio.tb_desafio USING btree (ds_chaves);
        CREATE INDEX idx_tb_desafio_ds_pergunta ON desafio.tb_desafio USING btree (ds_pergunta);
    END IF;
END
$$;

