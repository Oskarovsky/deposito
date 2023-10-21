-- CREATE USER "${dbUsername}" WITH PASSWORD '${dbPassword}';
CREATE SCHEMA IF NOT EXISTS dev
    AUTHORIZATION "${dbUsername}";

GRANT
CONNECT,
TEMPORARY
ON DATABASE "deposito_db"
TO "${dbUsername}";