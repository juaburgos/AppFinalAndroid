package isa.appfinalandroid.models5;

/**
 * Created by ASPIRE VX15 on 27/05/2018.
 */

public class Lugares {

    private String nombre;
    private String descri;
    private int ima;

    public Lugares(String nombre, String descri, int ima) {
        this.nombre = nombre;
        this.descri = descri;
        this.ima = ima;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescri() {
        return descri;
    }

    public void setDescri(String descri) {
        this.descri = descri;
    }

    public int getIma() {
        return ima;
    }

    public void setIma(int ima) {
        this.ima = ima;
    }
}
