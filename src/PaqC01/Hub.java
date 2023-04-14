package PaqC01;

import java.io.Serializable;

public class Hub implements Serializable {
    private Contenedor[][] contenedores;

    public Hub() {
        this.contenedores = new Contenedor[10][12];
    }

    public Contenedor[][] getContenedores() {
        return contenedores;
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
                result += "    ";
            }
            result += "\n";
        }
        return result;
    }

    public boolean apilaContenedor(Contenedor contenedor) {
        int prioridad = contenedor.getPrioridad();
        boolean apila = false;

        if (prioridad == 1) {
            for (int i = 9; i >= 0; i--) {
                if (contenedores[i][0] == null) {
                    contenedores[i][0] = contenedor;
                    apila = true;
                }
                if(apila == true) break;
            }
        }

        if (prioridad == 2) {
            for (int i = 9; i >= 0; i--) {
                if (contenedores[i][1] == null) {
                    contenedores[i][1] = contenedor;
                    apila = true;
                }
                if(apila == true) break;
            }
        }

        if (prioridad == 3) {
            for (int i = 9; i >= 0; i--) {
                for (int j = 2; j < 12; j++) {
                    if (contenedores[i][j] == null) {
                        contenedores[i][j] = contenedor;
                        apila = true;
                    }
                    if(apila == true) break;
                }
                if(apila == true) break;
            }
        }

        if(apila == true) {
            return true;
        } else return false;
    }

    public Contenedor desapilaContenedor(int columna) {
        Contenedor c = null;

        for (int i = 0; i < 10; i++) {
            if (contenedores[i][columna] != null) {
                c = contenedores[i][columna];
                contenedores[i][columna] = null;
                break;
            }
        }
        return c;
    }

    public Contenedor mostrarDatos(int numeroIdentf) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 12; j++) {
                if (contenedores[i][j] != null && numeroIdentf == contenedores[i][j].getNumeroIdentf()) {
                    return contenedores[i][j];
                }
            }
        }
        return null;
    }

    public int contenedoresPorPais(String pais) {
        int cantidad = 0;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 12; j++) {
                if (contenedores[i][j] != null && contenedores[i][j].getPais().equals(pais)) {
                    cantidad += 1;
                }
            }
        }
        return cantidad;
    }
}
