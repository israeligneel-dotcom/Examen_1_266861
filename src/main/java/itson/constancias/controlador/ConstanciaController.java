package itson.constancias.controlador;

import itson.constancias.modelo.Alumno;
import itson.constancias.modelo.AlumnoDAO;
import itson.constancias.modelo.Constancia;
import itson.constancias.vista.PantallaConstanciaFrm;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.util.List;
import java.util.Random;

public class ConstanciaController {
    private AlumnoDAO alumnoDAO;
    private PantallaConstanciaFrm vista;
    private Alumno alumnoSeleccionado;

    public ConstanciaController(AlumnoDAO alumnoDAO, PantallaConstanciaFrm vista) {
        this.alumnoDAO = alumnoDAO;
        this.vista = vista;
        initController();
    }

    private void initController() {
        actualizarListaBusqueda("");

        vista.getTxtIdSearch().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) { filtrar(); }
            @Override
            public void removeUpdate(DocumentEvent e) { filtrar(); }
            @Override
            public void changedUpdate(DocumentEvent e) { filtrar(); }

            private void filtrar() {
                String subId = vista.getTxtIdSearch().getText();
                actualizarListaBusqueda(subId);
            }
        });

        vista.getLstAlumnos().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                Alumno sel = vista.getLstAlumnos().getSelectedValue();
                if (sel != null) {
                    this.alumnoSeleccionado = sel;
                    vista.mostrarDatosConfirmacion(sel);
                }
            }
        });

        vista.getBtnGenerarConstancia().addActionListener(e -> {
            if (alumnoSeleccionado != null) {
                generarConstancia(alumnoSeleccionado);
            }
        });

        vista.getBtnRegresar().addActionListener(e -> {
            if (alumnoSeleccionado != null) {
                vista.mostrarDatosConfirmacion(alumnoSeleccionado);
            }
        });
    }

    public void actualizarListaBusqueda(String subId) {
        List<Alumno> resultados = alumnoDAO.buscarPorSubId(subId);
        vista.actualizarListaAlumnos(resultados);
    }

    public void generarConstancia(Alumno alumno) {
        String folio = "ITS-" + (100000 + new Random().nextInt(900000));
        Constancia constancia = new Constancia(folio, alumno);
        vista.mostrarConstancia(constancia);
    }
}