-- database: ../database/MEdbEcuAnt.sqlite

DROP TABLE IF EXISTS MEHormiga;
DROP TABLE IF EXISTS MECatalogo;


CREATE TABLE MECatalogo (
     IdCatalogo         INTEGER PRIMARY KEY AUTOINCREMENT,
     IdCatalogoPadre    INTEGER,
     Nombre             VARCHAR(20) NOT NULL UNIQUE,
     Detalle            VARCHAR(20),
     Estado             VARCHAR(1) NOT NULL DEFAULT ('A'),
     FechaCreacion      DATETIME NOT NULL DEFAULT (datetime('now', 'localtime')),
     FechaModificacion      DATETIME,
     FOREIGN KEY (IdCatalogoPadre) REFERENCES MECatalogo(IdCatalogo)
);

CREATE TABLE MEHormiga (
    IdHormiga               INTEGER PRIMARY KEY AUTOINCREMENT,
    IdCatalogoTipo          INTEGER NOT NULL REFERENCES MECatalogo(IdCatalogo),
    IdCatalogoSexo          INTEGER NOT NULL REFERENCES MECatalogo(IdCatalogo),
    IdCatalogoEstado        INTEGER NOT NULL REFERENCES MECatalogo(IdCatalogo),
    IdCatalogoGenoAlimento  INTEGER REFERENCES MECatalogo(IdCatalogo),
    IdCatalogoIngestaNativa INTEGER REFERENCES MECatalogo(IdCatalogo),
    Nombre                  VARCHAR(20),
    Estado                  VARCHAR(1) NOT NULL DEFAULT ('A'),
    FechaCreacion           DATETIME NOT NULL DEFAULT (datetime('now', 'localtime')),
    FechaModificacion       DATETIME
); 