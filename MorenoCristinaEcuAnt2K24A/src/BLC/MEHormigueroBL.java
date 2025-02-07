package BLC; 

import java.util.ArrayList;  
import BLC.Entities.MEGenoAlimento; 
import BLC.Entities.MEHLarva;   
import BLC.Entities.MEHormiga; 
import BLC.Entities.MEIngestaNativa; 
import BLC.Entities.MEInsectivoro;  
import BLC.Entities.MEX;   
import BLC.Entities.MEXX; 
import DAC.HormigueroDAC;    
import Infra.AppException; 
 
public class MEHormigueroBL { 
    public static ArrayList<MEHormiga> lstHormiguero = new ArrayList<>(); 
 
    public String crearLarva() throws AppException{    
        MEHormiga hormiga = new MEHLarva(lstHormiguero.size()+1); 
        lstHormiguero.add(hormiga); 
        return "HORMIGA LARVA, agregada al hormiguero"; 
    } 

    public String eliminarHormiga(int idHormiga) throws Exception {
        for (MEHormiga hormiga : lstHormiguero) {
            if (hormiga.getMEIdHormiga() == idHormiga) {
                hormiga.setMEEstado("MUERTA");
                return hormiga.getMETipo() + " marcada como MUERTA";
            }
        }
        return "HORMIGA no encontrada";
    }

    public String guardarHormiguero() throws AppException {
        StringBuilder fullDataHormiga = new StringBuilder();
        for (MEHormiga hormiga : lstHormiguero)
            fullDataHormiga.append(hormiga.toString()).append("\n");
        new HormigueroDAC().saveHorigueroToCSV(fullDataHormiga.toString());
        return "HORMIGUERO almacenado";
    }

    public String alimentarHormiga(int Idhormiga, String alimentoGeno, String alimentoNativo) throws AppException {
        int indexList = 0;
        MEGenoAlimento aGeno = null;
        MEIngestaNativa aNativo = null;
        MEHormiga hormiga = null;
        // creando GenoAlimento
        switch (alimentoGeno) {
            case "XX":
                aGeno = new MEXX();
                break;
            default:
                aGeno = new MEX();
                break;
        }

        // creando IngestaNativa
        switch (alimentoNativo) {

            case "Insectívoro":
                aNativo = new MEInsectivoro();
                break;

        }
        // buscar indexList y hormiga a alimentar
        for (; indexList < lstHormiguero.size(); indexList++)
            if (lstHormiguero.get(indexList).getMEIdHormiga() == Idhormiga) {
                hormiga = lstHormiguero.get(indexList);
                break;
            }
        // validamos
        if (aNativo == null || aGeno == null || hormiga == null || hormiga.getMEEstado() == "MUERTA") {
            lstHormiguero.set(indexList, hormiga.comer(aNativo));
            return "Ups...! alimento u hormiga no son válidos";
        }
        // inyectamos el genoAlimento a la ingestaNativa y se procede a alimenta a la
        // hormiga
        if (aNativo.MEInyectar(aGeno))
            lstHormiguero.set(indexList, hormiga.comer(aNativo));
        else
            return hormiga.getMETipo() + " NO alimentada";
        return lstHormiguero.get(indexList).getMETipo() + " Alimentada";
    }
    
}