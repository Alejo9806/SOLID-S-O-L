import java.util.ArrayList;

abstract class CochesDB {
    private int totalInserciones = 0;
    private int totalEliminaciones = 0;

    public int getTotalInserciones() { return totalInserciones; }
    public int getTotalEliminaciones() { return totalEliminaciones; }

    protected void incrementarInserciones() { totalInserciones++; }
    protected void incrementarEliminaciones() { totalEliminaciones++; }

    abstract ArrayList<Coche> obtener();
    abstract Coche buscar(Coche coche);
    abstract void insertar(Coche coche);
    abstract void borrar(Coche coche);
}
