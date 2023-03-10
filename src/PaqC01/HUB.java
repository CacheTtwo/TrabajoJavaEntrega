package PaqC01;

import java.util.Objects;

public class HUB {
    private Contenedor[][] contenedores;

    public HUB(Contenedor[][] contenedores) {
        this.contenedores = new Contenedor[10][12];
    }

    public Contenedor[][] getContenedores() {
        return contenedores;
    }

    public void setContenedores(Contenedor[][] contenedores) {
        this.contenedores = contenedores;
    }

    public String toStringHUB() {
        String result = "";
        for (int i = 0; i < contenedores.length; i++) {
            for (int j = 0; j < contenedores[i].length; j++) {
                if (contenedores[i][j] != null) {
                    result += "O";  //O significa ocupado
                } else {
                    result += "V";  //V significa vacío
                }
                result += "\t";
            }
            result += "\n";
        }
        return result;
    }

    public void apilaContenedor(Contenedor contenedor) {
        int prioridad = contenedor.getPrioridad();

        if (prioridad == 1) {
            for (int i = 9; i >= 0; i--) {
                if (contenedores[i][0] == null) contenedores[i][0] = contenedor;
            }
        }

        if (prioridad == 2) {
            for (int i = 9; i >= 0; i--) {
                if (contenedores[i][1] == null) contenedores[i][1] = contenedor;
            }
        }

        if (prioridad == 3) {
            for (int i = 9; i >= 0; i--) {
                for (int j = 2; j < 12; j++) {
                    if (contenedores[i][j] == null) contenedores[i][j] = contenedor;
                }
            }
        }
    }

    public void desapilaContenedor(int columna) {
        for (int i = 0; i < 10; i++) {
            if (contenedores[i][columna] != null) {
                contenedores[i][columna] = null;
                break;
            }
        }
    }

    public String mostrarDatos(int numeroIdentf) {
        String conf;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 12; j++) {
                if (numeroIdentf == contenedores[i][j].getNumeroIdentf()) {

                    if (contenedores[i][j].isAduanas() == true) {
                        conf = "Sí";
                    } else conf = "No";

                    return "Peso: " + contenedores[i][j].getPesoCont() + "\n" +
                            "País: " + contenedores[i][j].getPais() + "\n" +
                            "Inspección en aduanas: " + conf + "\n" +
                            "Prioridad: " + contenedores[i][j].getPrioridad() + "\n" +
                            "Descripción: " + contenedores[i][j].getDescripcion() + "\n" +
                            "Empresa emisora: " + contenedores[i][j].getNombreEmpresaEnvia() + "\n" +
                            "Empresa receptora: " + contenedores[i][j].getNombreEmpresaRecibe() + "\n";
                }
            }
        }
        return "No hay ningún contenedor almacenado con ese número de identificación";
    }

    public int ContenedoresPorPais(String pais) {
        int cantidad = 0;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 12; j++) {
                if (contenedores[i][j].getPais() == pais) {
                    cantidad += 1;
                }
            }
        }
        return cantidad / 10;
    }
}
