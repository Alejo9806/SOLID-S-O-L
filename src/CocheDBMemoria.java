import java.util.ArrayList;

public class CocheDBMemoria implements CochesDB, CochesEstadisticas {

    public int totalInserciones = 0;
    public int totalEliminaciones = 0;
    ArrayList<Coche> coches = new ArrayList();

    @Override
    public ArrayList<Coche> obtener() {
        return coches;
    }

    @Override
    public Coche buscar(Coche coche) {
        for (Coche cocheActual : obtener()) {
            if (cocheActual.matricula.equalsIgnoreCase(coche.matricula)) {
                return coche;
            }
        }

        return null;
    }

    @Override
    public void insertar(Coche coche) {
        for (Coche usuarioActual : coches) {
            if (usuarioActual.matricula.toLowerCase().equals(coche.matricula.toLowerCase())) {
                return;
            }
        }

        coches.add(coche);
        incrementarInserciones();
    }

    @Override
    public void borrar(Coche coche) {
        for (int i = 0; i < coches.size(); i++) {
            if (coches.get(i).matricula.equalsIgnoreCase(coche.matricula)) {
                coches.remove(i);
            }
        }

        incrementarEliminaciones();
    }

    @Override
    public int getTotalInserciones() {
        return totalInserciones;
    }

    @Override
    public int getTotalEliminaciones() {
        return totalEliminaciones;
    }

    @Override
    public void incrementarInserciones() {
        totalInserciones++;
    }

    @Override
    public void incrementarEliminaciones() {
        totalEliminaciones++;
    }
}
