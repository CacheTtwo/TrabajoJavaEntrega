package PaqC01;

public class Puerto {
    private HUB[] puerto;
    private boolean[] lleno;

    public Puerto() {
        this.puerto = new HUB[3];
        this.lleno = new boolean[3];
        for(int i = 0; i < this.puerto.length; i++) {
            this.lleno[i] = false;
        }
    }

    public HUB[] getHubs() {
        return puerto;
    }

    public void setHubs(HUB[] hubs) {
        this.puerto = hubs;
    }

    public void apilaContenedor(Contenedor c) {
        for(int i = 0; i < puerto.length; i++) {
            if(lleno[i] == false) {
                puerto[i].apilaContenedor(c);
                if(puerto[i].getContenedores()[9][11] != null) {
                    lleno[i] = true;
                }
                break;
            }
        }
    }

    public Contenedor desapilaContenedor(int hub_desapilar, int columna) {
        return puerto[hub_desapilar].desapilaContenedor(columna);
    }
}
