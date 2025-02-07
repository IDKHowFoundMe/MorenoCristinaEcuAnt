package BLC.Entities;

public abstract class MEIngestaNativa extends MEAlimento implements IMEIngestaNativa{
    public MEGenoAlimento meGenoAlimento;
    public String meIngestaNativa;
    public MEGenoAlimento getMeGenoAlimento() {
        return meGenoAlimento;
    }


    public MEIngestaNativa(String tipo) {
        super(tipo);
        meIngestaNativa=tipo;
    }
     
    @Override
    public boolean MEInyectar(MEGenoAlimento megenoAlimento){
        if(megenoAlimento.equals(" " ) ){
            return false;
        }else{
            meGenoAlimento=megenoAlimento;
            super.setMETipo(super.getMETipo()+meGenoAlimento);
            return true;
 
       }
       
}
}
