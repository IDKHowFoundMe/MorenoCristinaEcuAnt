package DAC.DTO;

public class MECatalogoDTO {
    private Integer  IdCatalogo;          
    private Integer  IdCatalogoPadre;   
    private String   Nombre;             
    private String   Detalle;           
    private String   Estado;             
    private String   FechaCreacion;         
    private String   FechaModificacion;

    public MECatalogoDTO(Integer idCatalogo, String nombre) {
        IdCatalogo = idCatalogo;
        Nombre = nombre;
    }
    public MECatalogoDTO() {
    }
    public MECatalogoDTO(Integer idCatalogo, Integer idCatalogoPadre, String nombre, String detalle, String estado,
            String fechaCreacion, String fechaModificacion) {
        IdCatalogo = idCatalogo;
        IdCatalogoPadre = idCatalogoPadre;
        Nombre = nombre;
        Detalle = detalle;
        Estado = estado;
        FechaCreacion = fechaCreacion;
        FechaModificacion = fechaModificacion;
    }
    public Integer getIdCatalogo() {
        return IdCatalogo;
    }
    public void setIdCatalogo(Integer idCatalogo) {
        IdCatalogo = idCatalogo;
    }
    public Integer getIdCatalogoPadre() {
        return IdCatalogoPadre;
    }
    public void setIdCatalogoPadre(Integer idCatalogoPadre) {
        IdCatalogoPadre = idCatalogoPadre;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public String getDetalle() {
        return Detalle;
    }
    public void setDetalle(String detalle) {
        Detalle = detalle;
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
        + "\n IdCatalogo      :" + getIdCatalogo()
        + "\n IdCatalogoPadre :" + getIdCatalogoPadre()
        + "\n Nombre          :" + getNombre()
        + "\n Detalle         :" + getDetalle()
        + "\n Estado          :" + getEstado()
        + "\n FechaCrea       :" + getFechaCreacion()
        + "\n FechaModifica   :" + getFechaModificacion();
    }
}
