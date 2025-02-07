package DAC.DAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import DAC.DataHelperSQLite;
import DAC.IDAO;
import DAC.DTO.MEHormigaDTO;
import Infra.AppException;

public class MEHormigaDAO extends DataHelperSQLite implements IDAO<MEHormigaDTO> {

    private static final String SELECT_QUERY = "SELECT "
    + "IdHormiga, "
    + "IdCatalogoTipo, "
    + "IdCatalogoSexo, "
    + "IdCatalogoEstado, "
    + "IdCatalogoGenoAlimento, "
    + "IdCatalogoIngestaNativa, "
    + "Nombre, "
    + "Estado, "
    + "FechaCreacion, "
    + "FechaModificacion, "
    + " FROM MEHormiga WHERE Estado = 'A'";

    @Override
    public MEHormigaDTO newDTO(ResultSet rs) {
        try {
            return new MEHormigaDTO(
                    rs.getInt("IdHormiga"),
                    rs.getInt("IdCatalogoTipo"),
                    rs.getInt("IdCatalogoSexo"),
                    rs.getInt("IdCatalogoEstado"),
                    rs.getInt("IdCatalogoGenoAlimento"),
                    rs.getInt("IdCatalogoIngestaNativa"),
                    rs.getString("Nombre"),
                    rs.getString("Estado"),
                    rs.getString("FechaCreacion"),
                    rs.getString("FechaModificacion")
            );
        } catch (SQLException e) {
            new AppException(e, getClass().getName(), "newDTO()");
        }
        return null;
    }

    @Override
    public MEHormigaDTO readBy(Integer id) throws Exception {
        String query = SELECT_QUERY + " AND IdHormiga = ?";
        return executeReadBy(query, rs -> newDTO(rs), id);
    }

    
    public List<MEHormigaDTO> readByPadre(Integer idPadre) throws Exception {
        String query = "SELECT h.IdHormiga, " +
                "h.IdCatalogoTipo, " +
                "h.IdCatalogoSexo, " +
                "h.IdCatalogoEstado, " +
                "h.IdCatalogoGenoAlimento, " +
                "h.IdCatalogoIngestaNativa, " +
                "h.Nombre, " +
                "h.Estado, " +
                "h.FechaCreacion, " +
                "h.FechaModificacion " +
                " FROM MEHormiga h " +
                " JOIN MECatalogo c ON h.IdCatalogoTipo = c.IdCatalogo " +
                " WHERE c.Nombre = 'HormigaTipo' AND h.IdCatalogoTipo = ?";
        return executeReadByPadre(query, rs -> newDTO(rs), idPadre);
    }

    @Override
    public List<MEHormigaDTO> readAll() throws Exception {
        String query = SELECT_QUERY;
        return executeReadAll(query, rs -> newDTO(rs));
    }

    @Override
    public boolean create(MEHormigaDTO dto) throws Exception {
        String query = "INSERT INTO Hormiga ("
                        + "IdCatalogoTipo, "
                        + "IdCatalogoSexo, "
                        + "IdCatalogoEstado, "
                        + "IdCatalogoGenoAlimento, "
                        + "IdCatalogoIngestaNativa, "
                        + "Nombre, "
                        + "Estado, "
                        + "FechaCreacion"
                        + ") VALUES (?,?,?,?,?,?,?,?)";
        return execute(query,
                        dto.getIdCatalogoTipo(),
                        dto.getIdCatalogoSexo(),
                        dto.getIdCatalogoEstado(),
                        dto.getIdCataloGenoAlimento(),
                        dto.getIdCataloIngestaNativa(),
                        dto.getNombre(),
                        dto.getEstado(),
                        dto.getFechaCreacion());
    }

    @Override
    public boolean update(MEHormigaDTO dto) throws Exception {
        String query = "UPDATE Hormiga SET "
                        + "IdCatalogoTipo = ?, "
                        + "IdCatalogoSexo = ?, "
                        + "IdCatalogoEstado = ?, "
                        + "IdCatalogoGenoAlimento = ?, "
                        + "IdCatalogoIngestaNativa = ?, "
                        + "Nombre = ?, "
                        + "Estado = ?, "
                        + "FechaModificacion = ? "
                        + "WHERE IdHormiga = ?";
        return execute(query,
                        dto.getIdCatalogoTipo(),
                        dto.getIdCatalogoSexo(),
                        dto.getIdCatalogoEstado(),
                        dto.getIdCataloGenoAlimento(),
                        dto.getIdCataloIngestaNativa(),
                        dto.getNombre(),
                        dto.getEstado(),
                        getDateTimeNow(),
                        dto.getIdHormiga());
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = "UPDATE Hormiga SET Estado = ?, FechaModificacion = ? WHERE IdHormiga = ?";
        return execute(query, "X", getDateTimeNow(), id);
    }

    @Override
    public Integer getMaxRow() throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'getMaxRow'");
    }

}
