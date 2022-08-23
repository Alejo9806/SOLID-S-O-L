import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class CocheDBFichero implements CochesDB{
    public String ficheroDatos = "coches.txt";

    @Override
    public ArrayList<Coche> obtener() {
        ArrayList<Coche> coches = new ArrayList();

        try {
            Scanner scanner = new Scanner(new File(ficheroDatos));

            while (scanner.hasNext()) {
                String usuarioActual = scanner.next();
                String []partes = usuarioActual.split(",");

                Coche coche = new Coche();
                coche.matricula = partes[0];
                coche.marca = partes[1];
                coche.color = partes[2];
                coche.modelo = partes[3];
                coche.cilindrada = Integer.parseInt(partes[4]);
                coche.numeroRuedas = Integer.parseInt(partes[5]);
                coche.potencia = Integer.parseInt(partes[6]);

                coches.add(coche);
            }

            scanner.close();
        } catch (Exception e) {
        }

        return coches;
    }

    @Override
    public Coche buscar(Coche usuario) {
        ArrayList<Coche> usuarios = obtener();

        for (Coche usuarioActual : usuarios) {
            if (usuarioActual.matricula.equalsIgnoreCase(usuario.matricula)) {
                return usuarioActual;
            }
        }

        return null;
    }

    @Override
    public void insertar(Coche coche) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(ficheroDatos, true);
            PrintStream printStream = new PrintStream(fileOutputStream);
            printStream.println(separarUsuarioPorComas(coche));
            printStream.flush();
            printStream.close();
        } catch (Exception e) {
        }
    }

    @Override
    public void borrar(Coche coche) {
        ArrayList<Coche> coches = obtener();

        for (int i = 0; i < coches.size(); i++) {
            if (coches.get(i).matricula.equalsIgnoreCase(coche.matricula)) {
                coches.remove(i);
            }
        }

        try {
            PrintStream printStream = new PrintStream(ficheroDatos);

            for (Coche cocheActual : coches) {
                String cocheComas = separarUsuarioPorComas(cocheActual);
                printStream.println(cocheComas);
            }

            printStream.close();
        } catch (Exception e) {
        }
    }

    private String separarUsuarioPorComas(Coche coche) {
        return coche.matricula + ","
                + coche.color + ","
                + coche.modelo + ","
                + coche.marca + ","
                + coche.potencia;
    }
}
