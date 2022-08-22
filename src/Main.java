public class Main {
    public static void main(String[] args) {
        Coche coche = new Coche();
        coche.matricula = "fas123";
        coche.marca = "Chvrolet";
        coche.modelo = "2022";
        coche.color = "rojo";
        coche.potencia = 121;
        coche.cilindrada = 250;
        coche.numeroRuedas = 4;

        Coche coche2 = new Coche();
        coche2.matricula = "fas113";
        coche2.marca = "Chvrolet";
        coche2.modelo = "2022";
        coche2.color = "rojo";
        coche2.potencia = 121;
        coche2.cilindrada = 250;
        coche2.numeroRuedas = 4;

        Coche coche3 = new Coche();
        coche3.matricula = "das123";
        coche3.marca = "Chvrolet";
        coche3.modelo = "2022";
        coche3.color = "rojo";
        coche3.potencia = 121;
        coche3.cilindrada = 250;
        coche3.numeroRuedas = 4;

        CochesDB cochesDB;

        String tipo = "memoria";
        if (tipo.equalsIgnoreCase("memoria")) {
            cochesDB = new CocheDBMemoria();
        } else {
            cochesDB = new CocheDBFichero();
        }

        Coches coches = new Coches(cochesDB);

        coches.crearCoche(coche);
        coches.crearCoche(coche2);
        coches.crearCoche(coche3);

        Coche cocheObtenido = coches.obtenerCoche("fas113");
        System.out.println("La marca del coche obtenido: " + cocheObtenido.marca);

        coches.borrarCoche("fas113");
        //usuarios.borrarUsuario("openbootcamp3");
        for (Coche a : coches.listarCoches()) {
            System.out.println("Usuario actual: " + a.matricula);
            System.out.println("----------------" + "-".repeat(a.matricula.length()));
            System.out.println(a);
            System.out.println();
        }

        System.out.println("Total de inserciones: " + cochesDB.getTotalInserciones());
        System.out.println("Total de eliminaciones: " + cochesDB.getTotalEliminaciones());
    }
}