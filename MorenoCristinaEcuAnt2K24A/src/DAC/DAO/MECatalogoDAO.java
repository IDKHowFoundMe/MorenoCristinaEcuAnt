package DAC.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import DAC.DataHelperSQLite;
import DAC.IDAO;
import DAC.DTO.MECatalogoDTO;
import Infra.AppException;

public class MECatalogoDAO extends DataHelperSQLite implements IDAO<MECatalogoDTO> {

    private static final String SELECT_QUERY = "SELECT "
    + "IdCatalogo, "
    + "IdCatalogoPadre, "
    + "Nombre, "
    + "Detalle, "
    + "Estado, "
    + "FechaCreacion, "
    + "FechaModificacion, "
    + " FROM MECatalogo WHERE Estado = 'A";

    @Override
    public MECatalogoDTO newDTO(ResultSet rs) {
        try{
            return new MECatalogoDTO(
                rs.getInt("idCatalogo"),
                rs.getInt("idCatalogoPadre"),
                rs.getString("Nombre"),
                rs.getString("Detalle"),
                rs.getString("Estado"),
                rs.getString("FechaCreacion"),
                rs.getString("FechaModificacion")
            );
        }catch (SQLException e){
            new AppException(e, getClass().getName(), "NewDTO()");
        }
        return null;
    }

    @Override
    public MECatalogoDTO readBy(Integer id) throws Exception {
        String query = SELECT_QUERY + " AND IdCatalogo = ?";
        return executeReadBy(query, rs -> newDTO(rs), id);
    }

    public List<MECatalogoDTO> readByPadre(Integer idPadre) throws Exception {
        String query = "SELECT   h.IdCatalogo, " + 
                                "h.IdCatalogoPadre, " +
                                "h.Nombre, " +     
                                "h.Detalle, " +       
                                "h.Estado, " +             
                                "h.FechaCreacion, " +          
                                "h.FechaModificacion " +
                        " FROM MECatalogo p " +
                        " JOIN MECatalogo h ON h.IdCatalogoPadre = p.IdCatalogo " +
                        " WHERE h.Estado = 'A' AND p.IdCatalogo = ?";

        return executeReadByPadre(query, rs -> newDTO(rs), idPadre);
    }

    @Override
    public List<MECatalogoDTO> readAll() throws Exception {
        String query = SELECT_QUERY;
        return executeReadAll(query, rs -> newDTO(rs));
    }

    @Override
    public boolean create(MECatalogoDTO dto) throws Exception {
       String query = "INSERT INTO Catalogo ("
                     + "IdCatalogoPadre, "
                     + "Nombre,"
                     + "Detalle,"
                     + "Estado,"
                     + "FechaCreacion"
                     + ") VALUES (?,?,?,?,?)";
                     return execute(query, dto.getIdCatalogoPadre(),
                                    dto.getNombre(),
                                    dto.getDetalle(),
                                    dto.getEstado(),
                                    dto.getFechaCreacion()); 

    }

    @Override
    public boolean update(MECatalogoDTO dto) throws Exception {
        String query = "UPDATE Catalogo SET "
                                    + "IdCatalogoPadre = ?, "
                                    + "Nombre = ?, "
                                    + "Detalle = ?, "
                                    + "FechaModificacion = ? "
                                    + "WHERE IdCatalogo = ?";
        return execute(query,    dto.getIdCatalogoPadre(),
                                 dto.getNombre(),
                                 dto.getDetalle(),
                                 getDateTimeNow(),
                                 dto.getIdCatalogo());
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = "UPDATE Catalogo SET Estado = ?, FechaModificacion = ? WHERE IdCatalogo = ?";
        return execute(query, "X", getDateTimeNow(), id);
    }

    @Override
    public Integer getMaxRow() throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'getMaxRow'");
    }
    
    
}
