package PaqC01;

public class Main {
    public static void main(String[] args) {
        //Crear contenedores
        Contenedor cont1 = new Contenedor(1, 1000, "España", false, 1, "Contenedor de alimentos", "Empresa1", "Empresa2");
        Contenedor cont2 = new Contenedor(2, 2500, "España", true, 3, "Contenedor de ropa", "Empresa3", "Empresa4");
        Contenedor cont3 = new Contenedor(3, 3000, "Italia", false, 3, "Contenedor de electrónica", "Empresa5", "Empresa6");

        //Crear un HUB y agregar contenedores
        HUB hub1 = new HUB(new Contenedor[10][12]);
        HUB hub2 = new HUB(new Contenedor[10][12]);
        HUB hub3 = new HUB(new Contenedor[10][12]);

        //Crear un puerto y rellenarlo con 3 hubs
        Puerto p1 = new Puerto();
        p1.setPuerto(new HUB[] {hub1, hub2, hub3});

        //Prueba de métodos de la clase Puerto
        System.out.println("Hub 1 (inicialmente):");
        System.out.println(p1.toStringHUB(0));

        p1.apilaContenedor(cont1);
        p1.apilaContenedor(cont2);
        System.out.println("Hub 1 (apilo 2 contenedores):");
        System.out.println(p1.toStringHUB(0));

        System.out.println("Hub 2 (inicialmente):");
        System.out.println(p1.toStringHUB(1));

        p1.desapilaContenedor(0, 0);
        System.out.println("Hub 1 (desapilo 1 contenedor):");
        System.out.println(p1.toStringHUB(0));

        System.out.println("Datos del contenedor con númer de identificación 2:");
        System.out.println(p1.mostrarDatos(0, 2));
        System.out.println();

        System.out.println("Cantidad de contenedores procedentes de España:");
        System.out.println(p1.ContenedoresPorPais(0, "España"));
    }
}
