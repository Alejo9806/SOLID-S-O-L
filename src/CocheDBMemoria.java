import java.util.ArrayList;

public class CocheDBMemoria extends CochesDB{

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
}
