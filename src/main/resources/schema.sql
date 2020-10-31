DROP TABLE IF EXISTS person CASCADE;
DROP SEQUENCE IF EXISTS global_seq;
CREATE SEQUENCE global_seq START WITH 1;
CREATE TABLE person(
                        id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
                        name        VARCHAR         NOT NULL,
                        department       VARCHAR         NOT NULL,
                        room       INTEGER         NOT NULL,
                        callnumber    INTEGER         NOT NULL
);