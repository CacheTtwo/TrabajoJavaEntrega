package PaqC01;

import java.io.Serializable;

public class Contenedor implements Serializable {
    private int numeroIdentf;
    private int pesoCont;
    private String pais;
    private boolean aduanas;
    private int prioridad;
    private String descripcion;
    private String nombreEmpresaEnvia;
    private String nombreEmpresaRecibe;

    public Contenedor(int numeroIdentf, int pesoCont, String pais, boolean aduanas, int prioridad, String descripcion, String nombreEmpresaEnvia, String nombreEmpresaRecibe) {
        this.numeroIdentf = numeroIdentf;
        this.pesoCont = pesoCont;
        this.pais = pais;
        this.aduanas = aduanas;
        this.prioridad = prioridad;
        if(descripcion.length() > 100) {
            this.descripcion = descripcion.substring(0, 100);
        } else {
            this.descripcion = descripcion;
        }
        if(nombreEmpresaEnvia.length() > 20) {
            this.nombreEmpresaEnvia = nombreEmpresaEnvia.substring(0, 20);
        } else {
            this.nombreEmpresaEnvia = nombreEmpresaEnvia;
        }
        if(nombreEmpresaRecibe.length() > 20) {
            this.nombreEmpresaRecibe = nombreEmpresaRecibe.substring(0, 20);
        } else {
            this.nombreEmpresaRecibe = nombreEmpresaRecibe;
        }
    }

    public int getNumeroIdentf() {
        return numeroIdentf;
    }

    public int getPesoCont() {
        return pesoCont;
    }

    public String getPais() {
        return pais;
    }

    public boolean isAduanas() {
        return aduanas;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNombreEmpresaEnvia() {
        return nombreEmpresaEnvia;
    }

    public String getNombreEmpresaRecibe() {
        return nombreEmpresaRecibe;
    }
}
