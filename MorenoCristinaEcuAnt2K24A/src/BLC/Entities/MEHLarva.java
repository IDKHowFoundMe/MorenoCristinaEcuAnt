package BLC.Entities;

public class MEHLarva extends MEHormiga{
    public MEHLarva(Integer MEIdHormiga) {
        super(MEIdHormiga, "Larva", "Asexual", "Insectivoro", "VIVA");
    }

    public MEHLarva(Integer MEIdHormiga, String METipo, String MESexo, String MEAlimentacion, String MEEstado) {
        super(MEIdHormiga, METipo, MESexo, MEAlimentacion, MEEstado);
    }

    @Override
    public MEHormiga comer(MEIngestaNativa ingestaNativa) {
        if (ingestaNativa == null || ingestaNativa.meGenoAlimento == null) {
            MEEstado = "MUERTA";
            return this;
        }
        if ("Insectivoro".equals(ingestaNativa.METipo) && "XX".equals(ingestaNativa.meGenoAlimento.meGenoAlimento)) {
            return new MEHReina(this);
        } else {
            MEEstado = "MUERTA";
            return this;
        }
    }
 


}  
