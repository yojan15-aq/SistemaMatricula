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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import clases.Alumno;
import clases.Curso;


public class FrmConsulta extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextArea txtResultado;
	private JButton btnBuscar;
	private JButton btnCerrar;

	public FrmConsulta() {
		setTitle("Consulta");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 640, 420);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(40, 40, 45));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCodigo = new JLabel("Código");
		lblCodigo.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblCodigo.setForeground(Color.WHITE);
		lblCodigo.setBounds(20, 20, 80, 25);
		contentPane.add(lblCodigo);

		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtCodigo.setBackground(new Color(55, 55, 60));
		txtCodigo.setForeground(Color.WHITE);
		txtCodigo.setCaretColor(Color.WHITE);
		txtCodigo.setBorder(BorderFactory.createLineBorder(new Color(80, 80, 85)));
		txtCodigo.setBounds(100, 20, 280, 27);
		contentPane.add(txtCodigo);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(new Color(33, 150, 243));
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setFocusPainted(false);
		btnBuscar.setBorderPainted(false);
		btnBuscar.setBounds(400, 20, 100, 27);
		btnBuscar.addActionListener(this);
		contentPane.add(btnBuscar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 70, 580, 250);
		contentPane.add(scrollPane);

		txtResultado = new JTextArea();
		txtResultado.setEditable(false);
		txtResultado.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtResultado.setBackground(new Color(50, 50, 55));
		txtResultado.setForeground(Color.WHITE);
		scrollPane.setViewportView(txtResultado);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBackground(new Color(96, 125, 139));
		btnCerrar.setForeground(Color.WHITE);
		btnCerrar.setFocusPainted(false);
		btnCerrar.setBorderPainted(false);
		btnCerrar.setBounds(250, 340, 120, 32);
		btnCerrar.addActionListener(e -> dispose());
		contentPane.add(btnCerrar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscar) buscar();
	}

	private void buscar() {
		String codigoStr = txtCodigo.getText().trim();
		if (codigoStr.isEmpty()) {
			txtResultado.setText("Ingrese un código para buscar.");
			return;
		}

		try {
			int codigo = Integer.parseInt(codigoStr);

			// Buscar alumno
			Alumno alumno = FrmMenu.arrAlumnos.buscarAlumnoPorCodigo(codigo);
			if (alumno != null) {
				String estado = FrmMenu.arrAlumnos.EstadoToText(alumno.getEstado());
				txtResultado.setText(
					"=== ALUMNO ===\n" +
					"Código: " + alumno.getCodAlumno() + "\n" +
					"Nombres: " + alumno.getNombres() + "\n" +
					"Apellidos: " + alumno.getApellidos() + "\n" +
					"DNI: " + alumno.getDni() + "\n" +
					"Edad: " + alumno.getEdad() + "\n" +
					"Celular: " + alumno.getCelular() + "\n" +
					"Estado: " + estado
				);
				return;
			}

			// Buscar curso
			Curso curso = FrmMenu.arrCursos.buscarCursoPorCodigo(codigo);
			if (curso != null) {
				txtResultado.setText(
					"=== CURSO ===\n" +
					"Código: " + curso.getCodCurso() + "\n" +
					"Asignatura: " + curso.getAsignatura() + "\n" +
					"Ciclo: " + FrmMenu.arrCursos.cicloToText(curso.getCiclo()) + "\n" +
					"Créditos: " + curso.getCreditos() + "\n" +
					"Horas: " + curso.getHoras()
				);
				return;
			}

			txtResultado.setText("No se encontró información para el código: " + codigo);

		} catch (NumberFormatException ex) {
			txtResultado.setText("El código debe ser numérico.");
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> new FrmConsulta().setVisible(true));
	}
}