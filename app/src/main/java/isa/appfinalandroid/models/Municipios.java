package isa.appfinalandroid.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ASPIRE VX15 on 26/05/2018.
 */

public class Municipios
{
    @SerializedName("codigodanemunicipio")
    @Expose
    private String codigodanemunicipio;
    @SerializedName("correocontactenos")
    @Expose
    private String correocontactenos;
    @SerializedName("direccion")
    @Expose
    private String direccion;
    @SerializedName("nit")
    @Expose
    private String nit;
    @SerializedName("nombrealcalde")
    @Expose
    private String nombrealcalde;
    @SerializedName("nombremunicipio")
    @Expose
    private String nombremunicipio;
    @SerializedName("portalweb")
    @Expose
    private String portalweb;
    @SerializedName("telefonocontacto")
    @Expose
    private String telefonocontacto;

    public String getCodigodanemunicipio() {
        return codigodanemunicipio;
    }

    public void setCodigodanemunicipio(String codigodanemunicipio) {
        this.codigodanemunicipio = codigodanemunicipio;
    }

    public String getCorreocontactenos() {
        return correocontactenos;
    }

    public void setCorreocontactenos(String correocontactenos) {
        this.correocontactenos = correocontactenos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombrealcalde() {
        return nombrealcalde;
    }

    public void setNombrealcalde(String nombrealcalde) {
        this.nombrealcalde = nombrealcalde;
    }

    public String getNombremunicipio() {
        return nombremunicipio;
    }

    public void setNombremunicipio(String nombremunicipio) {
        this.nombremunicipio = nombremunicipio;
    }

    public String getPortalweb() {
        return portalweb;
    }

    public void setPortalweb(String portalweb) {
        this.portalweb = portalweb;
    }

    public String getTelefonocontacto() {
        return telefonocontacto;
    }

    public void setTelefonocontacto(String telefonocontacto) {
        this.telefonocontacto = telefonocontacto;
    }
}
