package itson.constancias.main;

import itson.constancias.controlador.ConstanciaController;
import itson.constancias.modelo.AlumnoDAO;
import itson.constancias.vista.PantallaConstanciaFrm;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        SwingUtilities.invokeLater(() -> {
            AlumnoDAO dao = new AlumnoDAO();
            PantallaConstanciaFrm vista = new PantallaConstanciaFrm();
            new ConstanciaController(dao, vista);
            vista.setVisible(true);
        });
    }
}