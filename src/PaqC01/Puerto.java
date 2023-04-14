package PaqC01;

import java.io.Serializable;

public class Puerto implements Serializable {
    private Hub[] puerto;

    public Puerto() {
        this.puerto = new Hub[3];
    }

    public Hub[] getPuerto() {
        return puerto;
    }

    public void setPuerto(Hub[] puerto) {
        this.puerto = puerto;
    }

    public boolean apilaContenedor(int hub_apilar, Contenedor c) {
        return puerto[hub_apilar].apilaContenedor(c);
    }

    public Contenedor desapilaContenedor(int hub_desapilar, int columna) {
        return puerto[hub_desapilar].desapilaContenedor(columna);
    }

    public Contenedor mostrarDatos(int hub_mostrar, int numIdentf) {
        return puerto[hub_mostrar].mostrarDatos(numIdentf);
    }

    public String toStringHUB(int hub_mostrar) {
        return puerto[hub_mostrar].toStringHUB();
    }

    public int contenedoresPorPais(String pais) {
        int total = 0;

        for(int i = 0; i < puerto.length; i++) {
            total += puerto[i].contenedoresPorPais(pais);
        }

        return total;
    }
}
