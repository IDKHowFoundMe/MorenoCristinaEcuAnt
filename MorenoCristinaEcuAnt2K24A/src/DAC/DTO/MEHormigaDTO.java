package DAC.DTO;

public class MEHormigaDTO {
    private Integer IdHormiga;
    private Integer IdCatalogoTipo;
    private Integer IdCatalogoSexo;
    private Integer IdCatalogoEstado;
    private Integer IdCataloGenoAlimento;
    private Integer IdCataloIngestaNativa;
    private String Nombre;
    private String Estado;
    private String FechaCreacion;
    private String FechaModificacion;

    public MEHormigaDTO(Integer idHormiga, Integer idCatalogoTipo, Integer idCatalogoSexo, Integer idCatalogoEstado,
            Integer idCataloGenoAlimento, Integer idCataloIngestaNativa, String nombre) {
        IdHormiga = idHormiga;
        IdCatalogoTipo = idCatalogoTipo;
        IdCatalogoSexo = idCatalogoSexo;
        IdCatalogoEstado = idCatalogoEstado;
        IdCataloGenoAlimento = idCataloGenoAlimento;
        IdCataloIngestaNativa = idCataloIngestaNativa;
        Nombre = nombre;
    }
    
    public MEHormigaDTO() {
    }
    public MEHormigaDTO(Integer idHormiga, Integer idCatalogoTipo, Integer idCatalogoSexo, Integer idCatalogoEstado,
            Integer idCataloGenoAlimento, Integer idCataloIngestaNativa, String nombre, String estado,
            String fechaCreacion, String fechaModificacion) {
        IdHormiga = idHormiga;
        IdCatalogoTipo = idCatalogoTipo;
        IdCatalogoSexo = idCatalogoSexo;
        IdCatalogoEstado = idCatalogoEstado;
        IdCataloGenoAlimento = idCataloGenoAlimento;
        IdCataloIngestaNativa = idCataloIngestaNativa;
        Nombre = nombre;
        Estado = estado;
        FechaCreacion = fechaCreacion;
        FechaModificacion = fechaModificacion;
    }
    public Integer getIdHormiga() {
        return IdHormiga;
    }
    public void setIdHormiga(Integer idHormiga) {
        IdHormiga = idHormiga;
    }
    public Integer getIdCatalogoTipo() {
        return IdCatalogoTipo;
    }
    public void setIdCatalogoTipo(Integer idCatalogoTipo) {
        IdCatalogoTipo = idCatalogoTipo;
    }
    public Integer getIdCatalogoSexo() {
        return IdCatalogoSexo;
    }
    public void setIdCatalogoSexo(Integer idCatalogoSexo) {
        IdCatalogoSexo = idCatalogoSexo;
    }
    public Integer getIdCatalogoEstado() {
        return IdCatalogoEstado;
    }
    public void setIdCatalogoEstado(Integer idCatalogoEstado) {
        IdCatalogoEstado = idCatalogoEstado;
    }
    public Integer getIdCataloGenoAlimento() {
        return IdCataloGenoAlimento;
    }
    public void setIdCataloGenoAlimento(Integer idCataloGenoAlimento) {
        IdCataloGenoAlimento = idCataloGenoAlimento;
    }
    public Integer getIdCataloIngestaNativa() {
        return IdCataloIngestaNativa;
    }
    public void setIdCataloIngestaNativa(Integer idCataloIngestaNativa) {
        IdCataloIngestaNativa = idCataloIngestaNativa;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public String getEstado() {
        return Estado;
    }
    public void setEstado(String estado) {
        Estado = estado;
    }
    public String getFechaCreacion() {
        return FechaCreacion;
    }
    public void setFechaCreacion(String fechaCreacion) {
        FechaCreacion = fechaCreacion;
    }
    public String getFechaModificacion() {
        return FechaModificacion;
    }
    public void setFechaModificacion(String fechaModificacion) {
        FechaModificacion = fechaModificacion;
    }

    @Override
    public String toString(){
        return getClass().getName()
        + "\n IdHormiga                 : " + getIdHormiga()
        + "\n IdCatalogoTipo            : " + getIdCatalogoTipo()
        + "\n IdCatalogoSexo            : " + getIdCatalogoSexo()
        + "\n IdCatalogoEstado          : " + getIdCatalogoEstado()
        + "\n IdCatalogoGenoAlimento    : " + getIdCataloGenoAlimento()
        + "\n IdCatalogoIngestaNativa   : " + getIdCataloIngestaNativa()
        + "\n Nombre                    : " + getNombre()
        + "\n Estado                    : " + getEstado()
        + "\n FechaCrea                 : " + getFechaCreacion()
        + "\n FechaModifica             : " + getFechaModificacion();

}
}
