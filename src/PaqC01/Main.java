package PaqC01;

public class Main {
    public static void main(String[] args) {
        //DiseñoContenedores dis = new DiseñoContenedores();    //Creación de la ventana (lo dejamos de lado por ahora)

        // Crear contenedores
        Contenedor cont1 = new Contenedor(1, 1000, "España", false, 1, "Contenedor de alimentos", "Empresa1", "Empresa2");
        Contenedor cont2 = new Contenedor(2, 2500, "España", true, 2, "Contenedor de ropa", "Empresa3", "Empresa4");
        //Contenedor cont3 = new Contenedor(3, 3000, "Italia", false, 3, "Contenedor de electrónica", "Empresa5", "Empresa6");

        // Crear un HUB y agregar contenedores
        HUB hub1 = new HUB(new Contenedor[10][12]);

        // Mostrar la disposición actual de los contenedores en el HUB
        System.out.println(hub1.toStringHUB());

        hub1.apilaContenedor(cont1);
        hub1.apilaContenedor(cont2);
        //hub1.apilaContenedor(cont3);

        // Mostrar la disposición actual de los contenedores en el HUB
        System.out.println(hub1.toStringHUB());

        // Mostrar datos de un contenedor específico
        System.out.println(hub1.mostrarDatos(2));

        // Mostrar la cantidad de contenedores por país
        System.out.println("Cantidad de contenedores procedentes del pais: " + hub1.ContenedoresPorPais("España"));
        System.out.println();

        // Desapilar un contenedor de una columna específica
        hub1.desapilaContenedor(0);

        // Mostrar la disposición actual de los contenedores en el HUB
        System.out.println(hub1.toStringHUB());
    }
}
