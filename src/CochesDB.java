import java.util.ArrayList;

public interface CochesDB {

    abstract ArrayList<Coche> obtener();
    abstract Coche buscar(Coche coche);
    abstract void insertar(Coche coche);
    abstract void borrar(Coche coche);
}
