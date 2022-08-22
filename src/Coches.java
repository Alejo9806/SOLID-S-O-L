import java.util.ArrayList;

public class Coches {
    CochesDB cochesDB;

    public Coches(CochesDB cochesDB) {
        this.cochesDB = cochesDB;
    }

    protected Coches() {}

    public ArrayList<Coche> listarCoches() {
        return cochesDB.obtener();
    }

    public Coche obtenerCoche(String matricula) {
        Coche coche = new Coche();
        coche.matricula = matricula;

        return cochesDB.buscar(coche);
    }

    public void crearCoche(Coche coche) {
        if (cochesDB.buscar(coche) != null) {
            return;
        }

        cochesDB.insertar(coche);
    }

    public void borrarCoche(String matricula) {
        Coche coche = new Coche();
        coche.matricula = matricula;

        cochesDB.borrar(coche);
    }
}
