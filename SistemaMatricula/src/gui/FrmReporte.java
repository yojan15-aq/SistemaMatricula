package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import clases.Alumno;
import clases.Matricula;

public class FrmReporte extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea txtListado;
	private JButton btnPendiente;
	private JButton btnVigente;
	private JButton btnPorCurso;
	private JButton btnRetirados;

	public FrmReporte() {
		setTitle("Reportes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 760, 440);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(40, 40, 45));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnPendiente = new JButton("Alumnos con matrícula pendiente");
		btnPendiente.setBackground(new Color(33, 150, 243));
		btnPendiente.setForeground(Color.WHITE);
		btnPendiente.setFocusPainted(false);
		btnPendiente.setBorderPainted(false);
		btnPendiente.setBounds(20, 20, 280, 40);
		btnPendiente.addActionListener(this);
		contentPane.add(btnPendiente);

		btnVigente = new JButton("Alumnos con matrícula vigente");
		btnVigente.setBackground(new Color(46, 125, 50));
		btnVigente.setForeground(Color.WHITE);
		btnVigente.setFocusPainted(false);
		btnVigente.setBorderPainted(false);
		btnVigente.setBounds(20, 75, 280, 40);
		btnVigente.addActionListener(this);
		contentPane.add(btnVigente);

		btnPorCurso = new JButton("Alumnos matriculados por curso");
		btnPorCurso.setBackground(new Color(255, 152, 0));
		btnPorCurso.setForeground(Color.WHITE);
		btnPorCurso.setFocusPainted(false);
		btnPorCurso.setBorderPainted(false);
		btnPorCurso.setBounds(20, 130, 280, 40);
		btnPorCurso.addActionListener(this);
		contentPane.add(btnPorCurso);

		btnRetirados = new JButton("Alumnos retirados");
		btnRetirados.setBackground(new Color(198, 40, 40));
		btnRetirados.setForeground(Color.WHITE);
		btnRetirados.setFocusPainted(false);
		btnRetirados.setBorderPainted(false);
		btnRetirados.setBounds(20, 185, 280, 40);
		btnRetirados.addActionListener(this);
		contentPane.add(btnRetirados);

		JLabel lblListado = new JLabel("Listado");
		lblListado.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblListado.setForeground(Color.WHITE);
		lblListado.setBounds(330, 20, 120, 25);
		contentPane.add(lblListado);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(330, 50, 390, 320);
		contentPane.add(scrollPane);

		txtListado = new JTextArea();
		txtListado.setEditable(false);
		txtListado.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtListado.setBackground(new Color(50, 50, 55));
		txtListado.setForeground(Color.WHITE);
		scrollPane.setViewportView(txtListado);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnPendiente) mostrarPendientes();
		if (e.getSource() == btnVigente) mostrarVigentes();
		if (e.getSource() == btnPorCurso) mostrarPorCurso();
		if (e.getSource() == btnRetirados) mostrarRetirados();
	}

	private void mostrarPendientes() {
		StringBuilder sb = new StringBuilder("ALUMNOS CON MATRÍCULA PENDIENTE\n\n");
		for (int i = 0; i < FrmMenu.arrAlumnos.cantidadAlumnos(); i++) {
			Alumno a = FrmMenu.arrAlumnos.obtenerAlumno(i);
			if (a.getEstado() == 0) {
				sb.append("Código: ").append(a.getCodAlumno())
				  .append(" - ").append(a.getNombres()).append(" ").append(a.getApellidos()).append("\n");
			}
		}
		txtListado.setText(sb.toString());
	}

	private void mostrarVigentes() {
		StringBuilder sb = new StringBuilder("ALUMNOS CON MATRÍCULA VIGENTE\n\n");
		for (int i = 0; i < FrmMenu.arrAlumnos.cantidadAlumnos(); i++) {
			Alumno a = FrmMenu.arrAlumnos.obtenerAlumno(i);
			if (a.getEstado() == 1) {
				sb.append("Código: ").append(a.getCodAlumno())
				  .append(" - ").append(a.getNombres()).append(" ").append(a.getApellidos()).append("\n");
			}
		}
		txtListado.setText(sb.toString());
	}

	private void mostrarPorCurso() {
		StringBuilder sb = new StringBuilder("ALUMNOS MATRICULADOS POR CURSO\n\n");
		for (Matricula m : FrmMenu.listaMatriculas) {
			Alumno a = FrmMenu.arrAlumnos.buscarAlumnoPorCodigo(m.getCodAlumno());
			if (a != null) {
				sb.append("Curso ").append(m.getCodCurso())
				  .append(" → ").append(a.getNombres()).append(" ").append(a.getApellidos()).append("\n");
			}
		}
		txtListado.setText(sb.toString());
	}

	private void mostrarRetirados() {
		StringBuilder sb = new StringBuilder("ALUMNOS RETIRADOS\n\n");
		for (int i = 0; i < FrmMenu.arrAlumnos.cantidadAlumnos(); i++) {
			Alumno a = FrmMenu.arrAlumnos.obtenerAlumno(i);
			if (a.getEstado() == 2) {
				sb.append("Código: ").append(a.getCodAlumno())
				  .append(" - ").append(a.getNombres()).append(" ").append(a.getApellidos()).append("\n");
			}
		}
		txtListado.setText(sb.toString());
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> new FrmReporte().setVisible(true));
	}
}