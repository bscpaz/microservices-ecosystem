DO $$
DECLARE
BEGIN
    IF NOT EXISTS (
        SELECT 1 FROM information_schema.sequences
		WHERE sequence_schema = 'desafio' AND sequence_name = 'sq_tb_desafio') THEN

        CREATE SEQUENCE desafio.sq_tb_desafio
            INCREMENT BY 1
            MINVALUE 1
            MAXVALUE 9223372036854775807
            START 1
            CACHE 1
            NO CYCLE;

    END IF;
END
$$;

