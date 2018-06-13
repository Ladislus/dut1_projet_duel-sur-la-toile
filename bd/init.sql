-- CREATE DATABASE IF NOT EXISTS serveurDeJeux DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
-- USE serveurDeJeux;
USE dbmirloup;
CREATE TABLE ROLE (
  nomRole varchar(10),
  PRIMARY KEY (nomRole)
);

CREATE TABLE UTILISATEUR (
  idUt decimal(6,0),
  pseudoUt varchar(10) unique,
  emailUt varchar(100),
  mdpUt varchar(100),
  activeUt char(1),
  nomRole varchar(10),
  PRIMARY KEY (idUt)
);

CREATE TABLE ETREAMI (
  idUt decimal(6,0),
  idUt1 decimal(6,0),
  PRIMARY KEY (idUt, idUt1)
);

CREATE TABLE MESSAGE (
  idMsg decimal(6,0),
  dateMsg datetime,
  contenuMsg text,
  luMsg char(1),
  idUt decimal(6,0),
  idUt1 decimal(6,0),
  PRIMARY KEY (idMsg)
);


CREATE TABLE INVITATION (
  idInv decimal(6,0),
  dateInv datetime,
  etatInv char(1),
  idUt decimal(6,0),
  idUt1 decimal(6,0),
  PRIMARY KEY (idInv)
);

CREATE TABLE PARTIE (
  idPa decimal(6,0),
  debutPa datetime,
  numEtape char(1),
  etatPartie text,
  idJeu decimal(6,0),
  idUt1 decimal(6,0),
  score1 VARCHAR(42),
  idUt2 decimal(6,0),
  score2 VARCHAR(42),
  PRIMARY KEY (idPa)
);

CREATE TABLE JEU (
  idJeu decimal(6,0),
  nomJeu varchar(20),
  regleJeu text,
  jarJeu blob,
  activeJeu char(1),
  idTy decimal(6,0),
  PRIMARY KEY (idJeu)
);

CREATE TABLE TYPEJEU (
  idTy decimal(6,0),
  nomTy varchar(20),
  PRIMARY KEY (idTy)
);

ALTER TABLE UTILISATEUR ADD FOREIGN KEY (nomRole) REFERENCES ROLE (nomRole);
ALTER TABLE ETREAMI ADD FOREIGN KEY (idUt1) REFERENCES UTILISATEUR (idUt);
ALTER TABLE ETREAMI ADD FOREIGN KEY (idUt) REFERENCES UTILISATEUR (idUt);
ALTER TABLE MESSAGE ADD FOREIGN KEY (idUt1) REFERENCES UTILISATEUR (idUt);
ALTER TABLE MESSAGE ADD FOREIGN KEY (idUt) REFERENCES UTILISATEUR (idUt);
ALTER TABLE PARTIE ADD FOREIGN KEY (idUt1) REFERENCES UTILISATEUR (idUt);
ALTER TABLE PARTIE ADD FOREIGN KEY (idUt2) REFERENCES UTILISATEUR (idUt);
ALTER TABLE PARTIE ADD FOREIGN KEY (idJeu) REFERENCES JEU (idJeu);
ALTER TABLE INVITATION ADD FOREIGN KEY (idUt1) REFERENCES UTILISATEUR (idUt);
ALTER TABLE INVITATION ADD FOREIGN KEY (idUt) REFERENCES UTILISATEUR (idUt);
ALTER TABLE JEU ADD FOREIGN KEY (idTy) REFERENCES TYPEJEU (idTy);

