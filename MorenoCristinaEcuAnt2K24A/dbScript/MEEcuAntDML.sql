-- database: ../database/MEdbEcuAnt.sqlite

INSERT INTO MECatalogo (IdCatalogoPadre, Nombre, Detalle) VALUES 
    (NULL, 'HormigaTipo', 'TipoHormiga'),
    (NULL, 'HormigaSexo', 'SexoHormiga'),
    (NULL, 'HormigaEstado', 'EstadoHormiga'),
    (NULL, 'GenoAlimento', 'GenoAlimentoHormiga'),
    (NULL, 'IngestaNativa', 'TipoIngestaNativa');

INSERT INTO MECatalogo (IdCatalogoPadre, Nombre, Detalle) VALUES 
    (1, 'Larva', ''),
    (1, 'Reina', '');

INSERT INTO MECatalogo (IdCatalogoPadre, Nombre, Detalle) VALUES 
    (2, 'Macho', 'Masculino'),
    (2, 'Femina', 'Femenino'),
    (2, 'Asexual', 'Asexual');

INSERT INTO MECatalogo (IdCatalogoPadre, Nombre, Detalle) VALUES 
    (3, 'VIVA', 'Hormiga VIVA'),
    (3, 'MUERTA', 'Hormiga MUERTA');

INSERT INTO MECatalogo (IdCatalogoPadre, Nombre, Detalle) VALUES 
    (4, 'X', 'Gen X'),
    (4, 'XX', 'Gen XX'),
    (4, 'XY', 'Gen XY');

INSERT INTO MECatalogo (IdCatalogoPadre, Nombre, Detalle) VALUES 
    (5, 'Carnívoro', 'Come carne'),
    (5, 'Herbívoro', 'Come plantas'),
    (5, 'Omnívoro', 'Come de todo'),
    (5, 'Insectívoro', 'Come insectos'),
    (5, 'Nectarívoro', 'Come nectar');

INSERT INTO MEHormiga (IdCatalogoTipo, IdCatalogoSexo, IdCatalogoEstado, IdCatalogoGenoAlimento, IdCatalogoIngestaNativa, Nombre) VALUES 
    (6, 10, 11, 13, 19, 'PaulaLarva'),        
    (7, 9, 11, 14, 19, 'PaulaReina');


SELECT 
 h.IdCatalogo, 
 h.IdCatalogoPadre,
 h.Nombre, 
 h.Detalle, 
 h.Estado, 
 h.FechaCreacion, 
 h.FechaModificacion
FROM MECatalogo p
JOIN MECatalogo h ON h.IdCatalogoPadre = p.IdCatalogo
WHERE p.Nombre = 'HormigaTipo';


SELECT h.IdCatalogo,
 h.IdCatalogoPadre,
 h.Nombre, 
 h.Detalle, 
 h.Estado, 
 h.FechaCreacion, 
 h.FechaModificacion
FROM MECatalogo p
JOIN MECatalogo h ON h.IdCatalogoPadre = p.IdCatalogo
WHERE p.Nombre = 'HormigaSexo';


SELECT h.IdCatalogo, 
    h.IdCatalogoPadre, 
    h.Nombre, 
    h.Detalle, 
    h.Estado, 
    h.FechaCreacion, 
    h.FechaModificacion
FROM MECatalogo p
JOIN MECatalogo h ON h.IdCatalogoPadre = p.IdCatalogo
WHERE p.Nombre = 'HormigaEstado';


SELECT h.IdCatalogo,
 h.IdCatalogoPadre, 
 h.Nombre, 
 h.Detalle, 
 h.Estado, 
 h.FechaCreacion, 
 h.FechaModificacion
FROM MECatalogo p
JOIN MECatalogo h ON h.IdCatalogoPadre = p.IdCatalogo
WHERE p.Nombre = 'GenoAlimento';


SELECT h.IdCatalogo, 
        h.IdCatalogoPadre, 
        h.Nombre, 
        h.Detalle, 
        h.Estado, 
        h.FechaCreacion, 
        h.FechaModificacion
FROM MECatalogo p
JOIN MECatalogo h ON h.IdCatalogoPadre = p.IdCatalogo
WHERE p.Nombre = 'IngestaNativa';

SELECT 
    h.IdHormiga,
    h.Nombre,
    t.Nombre AS Tipo,
    s.Nombre AS Sexo,
    e.Nombre AS Estado,
    ga.Nombre AS GenoAlimento,
    ig.Nombre AS IngestaNativa,
    h.Estado AS EstadoGeneral
FROM MEHormiga h
LEFT JOIN MECatalogo t ON h.IdCatalogoTipo = t.IdCatalogo
LEFT JOIN MECatalogo s ON h.IdCatalogoSexo = s.IdCatalogo
LEFT JOIN MECatalogo e ON h.IdCatalogoEstado = e.IdCatalogo
LEFT JOIN MECatalogo ga ON h.IdCatalogoGenoAlimento = ga.IdCatalogo
LEFT JOIN MECatalogo ig ON h.IdCatalogoIngestaNativa = ig.IdCatalogo
ORDER BY h.IdHormiga; 




