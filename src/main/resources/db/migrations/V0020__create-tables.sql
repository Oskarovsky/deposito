CREATE TABLE guest
(
    id INTEGER not null generated always as identity primary key,
    email varchar(255) not null,
    password varchar(255) default null,
    timezone varchar(30) not null,
    created_at timestamp with time zone not null,
    updated_at timestamp with time zone not null
);

CREATE SEQUENCE IF NOT EXISTS artist_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

CREATE TABLE artist
(
    id INTEGER NOT NULL DEFAULT nextval('artist_id_seq'::regclass),
    name varchar(255) not null,
    CONSTRAINT artist_pkey PRIMARY KEY (id)
);

CREATE SEQUENCE IF NOT EXISTS track_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

CREATE TABLE track
(
    id INTEGER NOT NULL DEFAULT nextval('track_id_seq'::regclass),
    title VARCHAR(500) not null,
    version VARCHAR(255),
    genre SMALLINT,
    length INTEGER,
    tempo DOUBLE PRECISION,
    size DOUBLE PRECISION,
    CONSTRAINT track_pkey PRIMARY KEY (id)
);

CREATE TABLE artist_track
(
    artist_id INTEGER NOT NULL,
    track_id INTEGER NOT NULL,
    CONSTRAINT artist_track_pkey
        PRIMARY KEY (artist_id, track_id),
    CONSTRAINT artist_track_fk_1
        FOREIGN KEY (artist_id) REFERENCES artist (id),
    CONSTRAINT artist_track_fk_2
        FOREIGN KEY (track_id) REFERENCES track (id)
);
--
-- GRANT
-- SELECT,
-- INSERT,
-- UPDATE,
-- DELETE,
--   TRUNCATE
-- ON ALL TABLES IN SCHEMA dev
-- TO "${dbUsername}";