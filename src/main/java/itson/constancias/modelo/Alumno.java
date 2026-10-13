package itson.constancias.modelo;

public class Alumno {
    private String id;
    private String nombre;
    private String carrera;
    private int semestre;
    private int cantidadMaterias;
    private String estatus;

    public Alumno(String id, String nombre, String carrera, int semestre, int cantidadMaterias, String estatus) {
        this.id = id;
        this.nombre = nombre;
        this.carrera = carrera;
        this.semestre = semestre;
        this.cantidadMaterias = cantidadMaterias;
        this.estatus = estatus;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getCarrera() { return carrera; }
    public int getSemestre() { return semestre; }
    public int getCantidadMaterias() { return cantidadMaterias; }
    public String getEstatus() { return estatus; }

    @Override
    public String toString() {
        return id + " - " + nombre;
    }
}