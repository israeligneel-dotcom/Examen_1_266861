package itson.constancias.modelo;

/**
 *
 * @author israe
 */

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AlumnoDAO {
    private List<Alumno> listaAlumnos;

    public AlumnoDAO() {
        listaAlumnos = new ArrayList<>();
        listaAlumnos.add(new Alumno("00000266861", "Israel Landeros Felix", "Ingenieria en Software", 5, 6, "INSCRITO"));
        listaAlumnos.add(new Alumno("00000245101", "Danna Paola Landeros", "Ingenieria Industrial", 3, 7, "INSCRITO"));
        listaAlumnos.add(new Alumno("00000269854", "Ramses Lopez Murrieta", "Ingenieria en Software", 5, 6, "INSCRITO"));
        listaAlumnos.add(new Alumno("00000270427", "Juan Pablo Lizarraga", "Ingenieria en Software", 5, 5, "INSCRITO"));
        listaAlumnos.add(new Alumno("00000245104", "Avit Antonio Merino", "Ingenieria en Software", 5, 6, "INSCRITO"));
        listaAlumnos.add(new Alumno("00000245105", "Jesus Orlando Barreras", "Ingenieria en Software", 5, 6, "INSCRITO"));
        listaAlumnos.add(new Alumno("00000267239", "Noe Josue Cruz Rodríguez", "Licenciatura en Administracion", 7, 5, "INSCRITO"));
        listaAlumnos.add(new Alumno("00000266404", "Ivan Emmanuel Landeros Felix", "Ingenieria Mecatronica", 8, 4, "INSCRITO"));
        listaAlumnos.add(new Alumno("00000269989 ", "Bannia Mercedes Miranda Lopez", "Ingenieria Civil", 4, 6, "BAJA TEMPORAL"));
    }

    public List<Alumno> buscarPorSubId(String subId) {
        if (subId == null || subId.trim().isEmpty()) {
            return new ArrayList<>(listaAlumnos);
        }
        String filtro = subId.trim().toLowerCase();
        return listaAlumnos.stream()
                .filter(a -> a.getId().toLowerCase().contains(filtro) || a.getNombre().toLowerCase().contains(filtro))
                .collect(Collectors.toList());
    }

    public List<Alumno> obtenerTodos() {
        return new ArrayList<>(listaAlumnos);
    }
}
