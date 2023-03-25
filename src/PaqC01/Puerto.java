package PaqC01;

public class Puerto {
    private HUB[] puerto;
    private boolean[] lleno;

    public Puerto() {
        this.puerto = new HUB[3];
        this.lleno = new boolean[3];
        for(int i = 0; i < 3; i++) {
            this.lleno[i] = false;
        }
    }

    public HUB[] getPuerto() {
        return puerto;
    }

    public void setPuerto(HUB[] puerto) {
        this.puerto = puerto;
    }

    public boolean[] getLleno() {
        return lleno;
    }

    public void setLleno(boolean[] lleno) {
        this.lleno = lleno;
    }

    public void apilaContenedor(Contenedor c) {
        /*
        for(int i = 0; i < puerto.length; i++) {
            if(lleno[i] == false) {
                puerto[i].apilaContenedor(c);
                if(puerto[i].getContenedores()[0][11] != null) {
                    lleno[i] = true;
                }
                break;
            }
        }
        */
        for (int i = 0; i < puerto.length; i++) {
            for (int j = 0; j < puerto[i].getContenedores().length; j++) {
                if (!lleno[i] || puerto[i].getContenedores()[j][0] == null) {
                    puerto[i].apilaContenedor(c);
                    if (puerto[i].getContenedores()[0][11] != null) {
                        lleno[i] = true;
                    }
                    return;
                } else if (c.getPrioridad() == puerto[i].getContenedores()[j][0].getPrioridad()) {
                    puerto[i].apilaContenedor(c);
                    return;
                }
            }
        }
    }

    //Para los otros 4 métodos tan solo pasamos como parámetro el hub sobre el que queremos hacer el método (y los otros atributos necesarios para ese método)
    //y lo cogemos directamente de la clase HUB
    public Contenedor desapilaContenedor(int hub_desapilar, int columna) {  //No sé si este método debe ser de tipo Contenedor
        return puerto[hub_desapilar].desapilaContenedor(columna);
    }

    public String mostrarDatos(int hub_mostrar, int numIdentf) {
        return puerto[hub_mostrar].mostrarDatos(numIdentf);
    }

    public String toStringHUB(int hub_mostrar) {
        return puerto[hub_mostrar].toStringHUB();
    }

    public int ContenedoresPorPais(int hub_pais, String pais) {
        return puerto[hub_pais].ContenedoresPorPais(pais);
    }
}
