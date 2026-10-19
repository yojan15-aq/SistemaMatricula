package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import arreglos.ArrayAlumnos;
import arreglos.ArrayCursos;
import clases.Alumno;
import clases.Curso;
import clases.Matricula;
import clases.Retiro;

@SuppressWarnings("serial")
public class FrmMenu extends JFrame {
	public static ArrayAlumnos arrAlumnos = new ArrayAlumnos();
	public static ArrayCursos arrCursos = new ArrayCursos();
	public static List<Matricula> listaMatriculas = new ArrayList<>();
	public static List<Retiro> listaRetiros = new ArrayList<>();
	List<String[]> sdfsdf= new ArrayList<>();

    public FrmMenu() {
        setTitle("Sistema de Matrícula");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(620, 480);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel content = new JPanel();
        content.setBackground(new Color(30, 30, 35));
        content.setBorder(new EmptyBorder(30, 40, 30, 40));
        content.setLayout(null);
        setContentPane(content);

        // Título
        JLabel titulo = new JLabel("Sistema de Matrícula", SwingConstants.CENTER);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 28));
        titulo.setForeground(Color.WHITE);
        titulo.setBounds(50, 20, 500, 40);
        content.add(titulo);

        // Panel de botones (2 columnas)
        JPanel panelBotones = new JPanel(new GridLayout(3, 2, 15, 15));
        panelBotones.setOpaque(false);
        panelBotones.setBounds(60, 90, 480, 300);

        // Crear botones (sin íconos)
        JButton btnAlumno = crearBoton("Alumno", new Color(33, 150, 243));
        JButton btnCurso = crearBoton("Curso", new Color(0, 150, 136));
        JButton btnMatricula = crearBoton("Matrícula", new Color(46, 125, 50));
        JButton btnRetiro = crearBoton("Retiro", new Color(255, 152, 0));
        JButton btnConsulta = crearBoton("Consulta", new Color(156, 39, 176));
        JButton btnReporte = crearBoton("Reporte", new Color(96, 125, 139));

        // Agregar al panel
        panelBotones.add(btnAlumno);
        panelBotones.add(btnCurso);
        panelBotones.add(btnMatricula);
        panelBotones.add(btnRetiro);
        panelBotones.add(btnConsulta);
        panelBotones.add(btnReporte);

        content.add(panelBotones);

        // Eventos
        btnAlumno.addActionListener(e -> new FrmAlumno().setVisible(true));
        btnCurso.addActionListener(e -> new FrmCurso().setVisible(true));
        btnMatricula.addActionListener(e -> new FrmMatricula().setVisible(true));
        btnRetiro.addActionListener(e -> new FrmRetiro().setVisible(true));
        btnConsulta.addActionListener(e -> new FrmConsulta().setVisible(true));
        btnReporte.addActionListener(e -> new FrmReporte().setVisible(true));
        
        generarAlumnosPrueba();
        generarCursosPrueba();
        generarMatriculasPrueba();
        generarRetirosPrueba();
    }

    private JButton crearBoton(String texto, Color color) {
        JButton btn = new JButton(texto) {
            @Override
            protected void paintComponent(java.awt.Graphics g) {
                java.awt.Graphics2D g2 = (java.awt.Graphics2D) g.create();
                g2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);

                // Color más claro si el mouse está encima
                if (getModel().isRollover()) {
                    g2.setColor(color.brighter());
                } else {
                    g2.setColor(color);
                }

                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
                g2.dispose();

                super.paintComponent(g);
            }
        };

        btn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btn.setForeground(Color.WHITE);
        btn.setContentAreaFilled(false);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        return btn;
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> new FrmMenu().setVisible(true));
    }
    public void generarAlumnosPrueba() {
		Alumno a1 = new Alumno(Alumno.generarCodigoAlumno(), "Juan", "Perez", "12345678", 20, 987654321, 0);
		Alumno a2 = new Alumno(Alumno.generarCodigoAlumno(), "Maria", "Gomez", "23456789", 22, 987654322, 0);
		Alumno a3 = new Alumno(Alumno.generarCodigoAlumno(), "Pedro", "Lopez", "34567890", 21, 987654323, 0);
		Alumno a4 = new Alumno(Alumno.generarCodigoAlumno(), "Ana", "Martinez", "45678901", 23, 987654324, 0);
		Alumno a5 = new Alumno(Alumno.generarCodigoAlumno(), "Luis", "Garcia", "56789012", 24, 987654325, 0);
		
		FrmMenu.arrAlumnos.agregarAlumno(a1);
		FrmMenu.arrAlumnos.agregarAlumno(a2);
		FrmMenu.arrAlumnos.agregarAlumno(a3);
		FrmMenu.arrAlumnos.agregarAlumno(a4);
		FrmMenu.arrAlumnos.agregarAlumno(a5);
	}
    public void generarCursosPrueba() {
		arrCursos.agregarCurso(new Curso(1001, "Matemática", 0, 4, 60));
		arrCursos.agregarCurso(new Curso(1020, "Física", 1, 3, 45));
		arrCursos.agregarCurso(new Curso(1030, "Química", 2, 4, 60));
		arrCursos.agregarCurso(new Curso(1040, "Biología", 3, 3, 45));
		arrCursos.agregarCurso(new Curso(1005, "Historia", 4, 2, 30));
		
//		cursos.mostrarEnTabla(tmodel);
	}
    private void generarMatriculasPrueba() {
//		FrmMenu.listaMatriculas.add(new Matricula(1001, 202610001, 1001, "15/10/2026", "08:00"));
//		FrmMenu.listaMatriculas.add(new Matricula(1002, 202610002, 1020, "15/10/2026", "10:00"));
//		FrmMenu.listaMatriculas.add(new Matricula(1003, 202610003, 1030, "16/10/2026", "14:00"));
//
//		Matricula.contadorMatricula = 1004;
	}
    private void generarRetirosPrueba() {
//		listaRetiros.add(new Retiro(2001, 1001, "16/10/2026", "09:00"));
//		listaRetiros.add(new Retiro(2002, 1002, "17/10/2026", "11:30"));
//		listaRetiros.add(new Retiro(2003, 1003, "18/10/2026", "15:00"));

		
	}
}