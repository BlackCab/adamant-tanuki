CREATE DATABASE IF NOT EXISTS calculationengine;

USE calculationengine;

CREATE TABLE IF NOT EXISTS members (
  id BIGINT NOT NULL AUTO_INCREMENT,
  member_value BIGINT NOT NULL,
  UNIQUE (member_value),
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS results (
  id BIGINT NOT NULL AUTO_INCREMENT,
  member_1_id BIGINT NOT NULL,
  member_2_id BIGINT NOT NULL,
  operation varchar(3) NOT NULL,
  result double(10, 4) NOT NULL,
  calculation_date date,
  PRIMARY KEY (id),
  FOREIGN KEY (member_1_id) REFERENCES members (id),
  FOREIGN KEY (member_2_id) REFERENCES members (id),
  INDEX result_index (member_1_id, member_2_id, operation)
); 