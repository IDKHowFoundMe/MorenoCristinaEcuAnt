package BLC.Entities;

public abstract class MEHormiga implements IMEHormiga {
    public Integer MEIdHormiga;
    public String METipo;
    public String MESexo;
    public String MEAlimentacion;
    public String MEEstado;
    
    public MEHormiga(Integer meIdHormiga, String meTipo, String meSexo, String meAlimentacion, String meEstado) {
        this.MEIdHormiga = meIdHormiga;
        this.METipo = meTipo;
        this.MESexo = meSexo;
        this.MEAlimentacion = meAlimentacion;
        this.MEEstado = meEstado;
    }

    @Override
    public String toString() {
        
        return MEIdHormiga + "," + METipo + "," + MESexo + "," + MEAlimentacion + "," + MEEstado + "\n";
    }
    public Integer getMEIdHormiga() {
        return MEIdHormiga;
    }

    public void setMEIdHormiga(Integer mEIdHormiga) {
        MEIdHormiga = mEIdHormiga;
    }

    public String getMETipo() {
        return METipo;
    }

    public void setMETipo(String mETipo) {
        METipo = mETipo;
    }

    public String getMESexo() {
        return MESexo;
    }

    public void setMESexo(String mESexo) {
        MESexo = mESexo;
    }

    public String getMEAlimentacion() {
        return MEAlimentacion;
    }

    public void setMEAlimentacion(String mEAlimentacion) {
        MEAlimentacion = mEAlimentacion;
    }

    public String getMEEstado() {
        return MEEstado;
    }

    public void setMEEstado(String mEEstado) {
        MEEstado = mEEstado;
    }


       
}