package itson.constancias.modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Constancia {
    private String folio;
    private Alumno alumno;
    private LocalDate fechaEmision;

    public Constancia(String folio, Alumno alumno) {
        this.folio = folio;
        this.alumno = alumno;
        this.fechaEmision = LocalDate.now();
    }

    public String getFolio() { return folio; }
    public Alumno getAlumno() { return alumno; }
    public LocalDate getFechaEmision() { return fechaEmision; }

    public String generarTextoOficial() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd 'de' MMMM 'de' yyyy");
        StringBuilder sb = new StringBuilder();
        sb.append("=====================================================================\n");
        sb.append("               INSTITUTO TECNOLOGICO DE SONORA (ITSON)               \n");
        sb.append("                    DIRECCION DE SERVICIOS ESCOLARES                 \n");
        sb.append("=====================================================================\n\n");
        sb.append(" FOLIO DE CONSTANCIA: ").append(folio).append("\n");
        sb.append(" FECHA DE EMISION: ").append(fechaEmision.format(fmt)).append("\n\n");
        sb.append(" A QUIEN CORRESPONDA:\n\n");
        sb.append(" Por medio de la presente se hace CONSTAR que el (la) estudiante:\n\n");
        sb.append("    * NOMBRE: ").append(alumno.getNombre().toUpperCase()).append("\n");
        sb.append("    * ID ALUMNO: ").append(alumno.getId()).append("\n");
        sb.append("    * CARRERA: ").append(alumno.getCarrera()).append("\n\n");
        sb.append(" Se encuentra debidamente INSCRITO(A) y CURSANDO en el presente ciclo escolar\n");
        sb.append(" con la siguiente informacion academica acreditada:\n\n");
        sb.append("    * SEMESTRE INSCRITO: ").append(alumno.getSemestre()).append(" Semestre\n");
        sb.append("    * CANTIDAD DE MATERIAS: ").append(alumno.getCantidadMaterias()).append(" Asignaturas\n");
        sb.append("    * ESTATUS DE MATRICULA: ").append(alumno.getEstatus()).append("\n\n");
        sb.append(" Se extiende la presente constancia oficial para los fines legales y\n");
        sb.append(" administrativos que al interesado convengan.\n\n");
        sb.append("                                ATENTAMENTE\n");
        sb.append("                   DIRECCION DE SERVICIOS ESCOLARES ITSON\n");
        sb.append("=====================================================================");
        return sb.toString();
    }
}