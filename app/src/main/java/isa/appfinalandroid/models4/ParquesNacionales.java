package isa.appfinalandroid.models4;

/**
 * Created by ASPIRE VX15 on 27/05/2018.
 */

public class ParquesNacionales
{
    private String barrio;
    private String cDigoDane;
    private String centroPoblado;
    private String departamento;
    private String direcciNDeLaBiblioteca;
    private String estadoDeLaBiblioteca;
    private String georeferencia;
    private String municipio;
    private String naturalezaDeLaBiblioteca;
    private String nombreDeLaBiblioteca;
    private String telFonosDeContacto;
    private String tipoDeBiblioteca;

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getCDigoDane() {
        return cDigoDane;
    }

    public void setCDigoDane(String cDigoDane) {
        this.cDigoDane = cDigoDane;
    }

    public String getCentroPoblado() {
        return centroPoblado;
    }

    public void setCentroPoblado(String centroPoblado) {
        this.centroPoblado = centroPoblado;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDirecciNDeLaBiblioteca() {
        return direcciNDeLaBiblioteca;
    }

    public void setDirecciNDeLaBiblioteca(String direcciNDeLaBiblioteca) {
        this.direcciNDeLaBiblioteca = direcciNDeLaBiblioteca;
    }

    public String getEstadoDeLaBiblioteca() {
        return estadoDeLaBiblioteca;
    }

    public void setEstadoDeLaBiblioteca(String estadoDeLaBiblioteca) {
        this.estadoDeLaBiblioteca = estadoDeLaBiblioteca;
    }

    public String getGeoreferencia() {
        return georeferencia;
    }

    public void setGeoreferencia(String georeferencia) {
        this.georeferencia = georeferencia;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getNaturalezaDeLaBiblioteca() {
        return naturalezaDeLaBiblioteca;
    }

    public void setNaturalezaDeLaBiblioteca(String naturalezaDeLaBiblioteca) {
        this.naturalezaDeLaBiblioteca = naturalezaDeLaBiblioteca;
    }

    public String getNombreDeLaBiblioteca() {
        return nombreDeLaBiblioteca;
    }

    public void setNombreDeLaBiblioteca(String nombreDeLaBiblioteca) {
        this.nombreDeLaBiblioteca = nombreDeLaBiblioteca;
    }

    public String getTelFonosDeContacto() {
        return telFonosDeContacto;
    }

    public void setTelFonosDeContacto(String telFonosDeContacto) {
        this.telFonosDeContacto = telFonosDeContacto;
    }

    public String getTipoDeBiblioteca() {
        return tipoDeBiblioteca;
    }

    public void setTipoDeBiblioteca(String tipoDeBiblioteca) {
        this.tipoDeBiblioteca = tipoDeBiblioteca;
    }

    public  int getidString(){
        return Integer.parseInt(cDigoDane);
    }
}
