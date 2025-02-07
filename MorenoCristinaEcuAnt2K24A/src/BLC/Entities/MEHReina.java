package BLC.Entities;

public class MEHReina extends MEHormiga{
    
    public MEHReina(Integer meIdHormiga, String meTipo, String meSexo, String meAlimentacion, String meEstado) {
            super(meIdHormiga, meTipo, meSexo, meAlimentacion, meEstado);
        }
    
    public MEHReina(MEHLarva larva) {
            super(larva.MEIdHormiga, "Reina", "Femina", larva.MEAlimentacion, larva.MEEstado);
        }
    
    @Override
    public MEHormiga comer(MEIngestaNativa meingestaNativa) {
        if (meingestaNativa == null || meingestaNativa.meGenoAlimento == null) {
            MEEstado = "MUERTA";
            return this;
        }
        if ("Insectivoro".equals(meingestaNativa.METipo) && "XX".equals(meingestaNativa.meGenoAlimento.meGenoAlimento)) {
            return this;
        } else {
            MEEstado = "MUERTA";
            return this;
        }

    }
}


