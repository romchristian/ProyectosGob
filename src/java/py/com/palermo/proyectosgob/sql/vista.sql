-- Agregado el 25-06-2015




ALTER TABLE comision ADD COLUMN presidente character varying(255);
ALTER TABLE comision ADD COLUMN secretario character varying(255);
ALTER TABLE comision ADD COLUMN vicepresidente character varying(255);



CREATE TABLE miembro
(
  id serial NOT NULL,
  comision_id bigint,
  nombre character varying(255),
  CONSTRAINT miembro_pkey PRIMARY KEY (id),
  CONSTRAINT fk_miembro_comision_id FOREIGN KEY (comision_id)
      REFERENCES comision (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
  
)
WITH (
  OIDS=FALSE
);


ALTER TABLE  comision add column estado character varying(255);
ALTER SEQUENCE comision_id_seq  RESTART WITH 57;