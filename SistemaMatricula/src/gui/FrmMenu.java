package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class FrmMenu extends JFrame {

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
    }

    private JButton crearBoton(String texto, Color color) {
        JButton btn = new JButton(texto);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btn.setBackground(color);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        return btn;
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> new FrmMenu().setVisible(true));
    }
}