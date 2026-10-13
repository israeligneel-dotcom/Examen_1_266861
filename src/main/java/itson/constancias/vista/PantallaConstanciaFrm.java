package itson.constancias.vista;

import itson.constancias.modelo.Alumno;
import itson.constancias.modelo.Constancia;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.List;

public class PantallaConstanciaFrm extends JFrame {

    private JTextField txtIdSearch;
    private JList<Alumno> lstAlumnos;
    private DefaultListModel<Alumno> listModel;
    
    private JPanel panelConfirmacionYConstancia;
    private CardLayout cardLayout;
    
    private JPanel pnlConfirmacion;
    private JLabel lblNombreVal;
    private JLabel lblIdVal;
    private JLabel lblCarreraVal;
    private JLabel lblSemestreVal;
    private JLabel lblMateriasVal;
    private JLabel lblEstatusVal;
    private JButton btnGenerarConstancia;
    
    private JPanel pnlConstanciaDoc;
    private JTextArea txtAreaConstancia;
    private JButton btnRegresar;

    public PantallaConstanciaFrm() {
        initComponents();
    }

    private void initComponents() {
        setTitle("ITSON - Sistema de Generacion de Constancias (CU-02)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new BorderLayout(15, 15));

        JPanel pnlHeader = new JPanel(new BorderLayout());
        pnlHeader.setBackground(new Color(0, 51, 102));
        pnlHeader.setBorder(new EmptyBorder(15, 20, 15, 20));
        
        JLabel lblHeaderTitle = new JLabel("Generacion de Constancia de Alumno Inscrito");
        lblHeaderTitle.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblHeaderTitle.setForeground(Color.WHITE);
        
        JLabel lblHeaderSub = new JLabel("Modulo de Servicios Escolares - Caso de Uso #2");
        lblHeaderSub.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        lblHeaderSub.setForeground(new Color(200, 220, 240));
        
        pnlHeader.add(lblHeaderTitle, BorderLayout.NORTH);
        pnlHeader.add(lblHeaderSub, BorderLayout.SOUTH);
        add(pnlHeader, BorderLayout.NORTH);

        JPanel pnlMainContent = new JPanel(new GridLayout(1, 2, 15, 15));
        pnlMainContent.setBorder(new EmptyBorder(10, 15, 15, 15));

        JPanel pnlIzquierdo = new JPanel(new BorderLayout(10, 10));
        pnlIzquierdo.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Busqueda de Alumno por ID",
                TitledBorder.LEFT, TitledBorder.TOP, new Font("Segoe UI", Font.BOLD, 14), new Color(0, 51, 102)));

        JPanel pnlInput = new JPanel(new BorderLayout(5, 5));
        pnlInput.setBorder(new EmptyBorder(10, 10, 10, 10));
        JLabel lblPrompt = new JLabel("Ingrese ID del Alumno:");
        lblPrompt.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        
        txtIdSearch = new JTextField();
        txtIdSearch.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtIdSearch.setToolTipText("Escriba el ID para filtrar en tiempo real");
        
        pnlInput.add(lblPrompt, BorderLayout.NORTH);
        pnlInput.add(txtIdSearch, BorderLayout.CENTER);
        
        pnlIzquierdo.add(pnlInput, BorderLayout.NORTH);

        JPanel pnlDerechaLista = new JPanel(new BorderLayout());
        pnlDerechaLista.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Coincidencias",
                TitledBorder.LEFT, TitledBorder.TOP, new Font("Segoe UI", Font.BOLD, 12)));

        listModel = new DefaultListModel<>();
        lstAlumnos = new JList<>(listModel);
        lstAlumnos.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        lstAlumnos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollList = new JScrollPane(lstAlumnos);
        pnlDerechaLista.add(scrollList, BorderLayout.CENTER);

        pnlIzquierdo.add(pnlDerechaLista, BorderLayout.CENTER);
        pnlMainContent.add(pnlIzquierdo);

        cardLayout = new CardLayout();
        panelConfirmacionYConstancia = new JPanel(cardLayout);

        pnlConfirmacion = new JPanel(new BorderLayout(10, 10));
        pnlConfirmacion.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Datos de Confirmacion del Alumno",
                TitledBorder.LEFT, TitledBorder.TOP, new Font("Segoe UI", Font.BOLD, 14), new Color(0, 51, 102)));

        JPanel pnlGridFields = new JPanel(new GridLayout(6, 2, 10, 10));
        pnlGridFields.setBorder(new EmptyBorder(15, 15, 15, 15));

        pnlGridFields.add(new JLabel("ID Alumno:"));
        lblIdVal = new JLabel("-");
        lblIdVal.setFont(new Font("Segoe UI", Font.BOLD, 13));
        pnlGridFields.add(lblIdVal);

        pnlGridFields.add(new JLabel("Nombre Completo:"));
        lblNombreVal = new JLabel("-");
        lblNombreVal.setFont(new Font("Segoe UI", Font.BOLD, 13));
        pnlGridFields.add(lblNombreVal);

        pnlGridFields.add(new JLabel("Carrera / Programa:"));
        lblCarreraVal = new JLabel("-");
        lblCarreraVal.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        pnlGridFields.add(lblCarreraVal);

        pnlGridFields.add(new JLabel("Semestre Inscrito:"));
        lblSemestreVal = new JLabel("-");
        lblSemestreVal.setFont(new Font("Segoe UI", Font.BOLD, 13));
        pnlGridFields.add(lblSemestreVal);

        pnlGridFields.add(new JLabel("Cantidad de Materias:"));
        lblMateriasVal = new JLabel("-");
        lblMateriasVal.setFont(new Font("Segoe UI", Font.BOLD, 13));
        pnlGridFields.add(lblMateriasVal);

        pnlGridFields.add(new JLabel("Estatus Inscripcion:"));
        lblEstatusVal = new JLabel("-");
        lblEstatusVal.setFont(new Font("Segoe UI", Font.BOLD, 13));
        pnlGridFields.add(lblEstatusVal);

        pnlConfirmacion.add(pnlGridFields, BorderLayout.CENTER);

        btnGenerarConstancia = new JButton("Generar Constancia");
        btnGenerarConstancia.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnGenerarConstancia.setBackground(new Color(0, 102, 204));
        btnGenerarConstancia.setForeground(Color.WHITE);
        btnGenerarConstancia.setEnabled(false);
        
        JPanel pnlBtnContainer = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pnlBtnContainer.add(btnGenerarConstancia);
        pnlConfirmacion.add(pnlBtnContainer, BorderLayout.SOUTH);

        pnlConstanciaDoc = new JPanel(new BorderLayout(10, 10));
        pnlConstanciaDoc.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Constancia de Alumno Inscrito",
                TitledBorder.LEFT, TitledBorder.TOP, new Font("Segoe UI", Font.BOLD, 14), new Color(0, 102, 51)));

        txtAreaConstancia = new JTextArea();
        txtAreaConstancia.setFont(new Font("Monospaced", Font.PLAIN, 13));
        txtAreaConstancia.setEditable(false);
        txtAreaConstancia.setMargin(new Insets(10, 10, 10, 10));
        JScrollPane scrollDoc = new JScrollPane(txtAreaConstancia);
        pnlConstanciaDoc.add(scrollDoc, BorderLayout.CENTER);

        btnRegresar = new JButton("Volver a Datos de Confirmacion");
        btnRegresar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        JPanel pnlRegresarContainer = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlRegresarContainer.add(btnRegresar);
        pnlConstanciaDoc.add(pnlRegresarContainer, BorderLayout.SOUTH);

        panelConfirmacionYConstancia.add(pnlConfirmacion, "CONFIRMACION");
        panelConfirmacionYConstancia.add(pnlConstanciaDoc, "CONSTANCIA");

        pnlMainContent.add(panelConfirmacionYConstancia);
        add(pnlMainContent, BorderLayout.CENTER);
    }

    public JTextField getTxtIdSearch() { return txtIdSearch; }
    public JList<Alumno> getLstAlumnos() { return lstAlumnos; }
    public JButton getBtnGenerarConstancia() { return btnGenerarConstancia; }
    public JButton getBtnRegresar() { return btnRegresar; }

    public void actualizarListaAlumnos(List<Alumno> alumnos) {
        listModel.clear();
        for (Alumno a : alumnos) {
            listModel.addElement(a);
        }
    }

    public void mostrarDatosConfirmacion(Alumno alumno) {
        if (alumno != null) {
            lblIdVal.setText(alumno.getId());
            lblNombreVal.setText(alumno.getNombre());
            lblCarreraVal.setText(alumno.getCarrera());
            lblSemestreVal.setText(alumno.getSemestre() + " Semestre");
            lblMateriasVal.setText(alumno.getCantidadMaterias() + " Materias Cursando");
            lblEstatusVal.setText(alumno.getEstatus());
            
            if ("INSCRITO".equalsIgnoreCase(alumno.getEstatus())) {
                lblEstatusVal.setForeground(new Color(0, 128, 0));
                btnGenerarConstancia.setEnabled(true);
            } else {
                lblEstatusVal.setForeground(Color.RED);
                btnGenerarConstancia.setEnabled(false);
            }
            cardLayout.show(panelConfirmacionYConstancia, "CONFIRMACION");
        }
    }

    public void mostrarConstancia(Constancia constancia) {
        txtAreaConstancia.setText(constancia.generarTextoOficial());
        txtAreaConstancia.setCaretPosition(0);
        cardLayout.show(panelConfirmacionYConstancia, "CONSTANCIA");
    }
}
