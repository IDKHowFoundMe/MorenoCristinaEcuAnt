package DAC;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import Infra.Config;
import Infra.AppException;

public class HormigueroDAC {
    public void saveHorigueroToCSV(String fullDataHormiga) throws AppException{
        try (PrintWriter writer = new PrintWriter(new FileWriter(Config.DATEFILE))) {
            writer.println("id,tipo,sexo,estado,aComido");
            writer.println(fullDataHormiga);
        } catch (IOException e){
            throw new AppException(e, this.getClass().toString(), "saveHormigueroToCSV(...)");
        }
    }
}
