CREATE SEQUENCE IF NOT EXISTS item_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

CREATE TABLE item
(
    id INTEGER NOT NULL DEFAULT nextval('item_id_seq'::regclass),
    content varchar(1000) not null,
    CONSTRAINT item_pkey PRIMARY KEY (id)
);