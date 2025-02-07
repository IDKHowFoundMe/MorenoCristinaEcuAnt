package BLC;

import java.util.HashMap;
import java.util.Map;

import DAC.DAO.MECatalogoDAO;
import DAC.DTO.MECatalogoDTO;

public class MECatalogo {
    protected MECatalogoDAO oCatalogoDAO = new MECatalogoDAO();


    public Map<Integer, String> getAllHormigaTipo() throws Exception{
        return getMap(1);
    }
    
    public Map<Integer, String> getAllHormigaTipoSexo() throws Exception{
        return getMap(2);
    }
    
    public Map<Integer, String> getAllHormigaTipoEstado() throws Exception{
        return getMap(3);
    }

    public Map<Integer, String> getAllHormigaTipoGeno() throws Exception{
        return getMap(4);
    }

    public Map<Integer, String> getAllHormigaTipoIngesta() throws Exception{
        return getMap(5);
    }

    private Map<Integer, String> getMap(Integer IdCatalogoPadre) throws Exception {
        Map<Integer, String> map = new HashMap<>();
        for (MECatalogoDTO pt : oCatalogoDAO.readByPadre(IdCatalogoPadre)) {
            map.put(pt.getIdCatalogoPadre(), pt.getNombre());
        }
        return map;
    }
    
}
