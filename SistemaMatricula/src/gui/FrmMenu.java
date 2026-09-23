package gui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FrmMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMenu frame = new FrmMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmMenu() {
		setTitle("Sistema de Matrícula");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 420);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("Sistema de Matrícula");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblTitulo.setBounds(130, 20, 280, 40);
		contentPane.add(lblTitulo);

		JButton btnAlumno = new JButton("Alumno");
		btnAlumno.setBounds(140, 80, 220, 40);
		contentPane.add(btnAlumno);

		JButton btnCurso = new JButton("Curso");
		btnCurso.setBounds(140, 130, 220, 40);
		contentPane.add(btnCurso);

		JButton btnMatricula = new JButton("Matrícula");
		btnMatricula.setBounds(140, 180, 220, 40);
		contentPane.add(btnMatricula);

		JButton btnRetiro = new JButton("Retiro");
		btnRetiro.setBounds(140, 230, 220, 40);
		contentPane.add(btnRetiro);

		JButton btnConsulta = new JButton("Consulta");
		btnConsulta.setBounds(140, 280, 220, 40);
		contentPane.add(btnConsulta);

		JButton btnReporte = new JButton("Reporte");
		btnReporte.setBounds(140, 330, 220, 40);
		contentPane.add(btnReporte);

		btnAlumno.addActionListener(e -> new FrmAlumno().setVisible(true));
		btnCurso.addActionListener(e -> new FrmCurso().setVisible(true));
		btnMatricula.addActionListener(e -> new FrmMatricula().setVisible(true));
		btnRetiro.addActionListener(e -> new FrmRetiro().setVisible(true));
		btnConsulta.addActionListener(e -> new FrmConsulta().setVisible(true));
		btnReporte.addActionListener(e -> new FrmReporte().setVisible(true));
	}
}
