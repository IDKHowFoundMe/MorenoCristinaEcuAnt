package BLC.Entities;

public abstract class MEAlimento {
    public String METipo;
    public MEAlimento(String mETipo) {
        METipo = mETipo;
    }
    
    public void setMETipo(String mETipo) {
        METipo = mETipo;
    }
    public String getMETipo() {
        return METipo;
    }
}
