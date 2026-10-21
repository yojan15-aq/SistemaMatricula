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
import clases.Matricula;
import clases.Retiro;


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
		        StringBuilder resultado = new StringBuilder();

		        // 1. Buscar Alumno
		        Alumno alumno = FrmMenu.arrAlumnos.buscarAlumnoPorCodigo(codigo);
		        if (alumno != null) {
		            resultado.append("=== ALUMNO ===\n");
		            resultado.append("Código    : ").append(alumno.getCodAlumno()).append("\n");
		            resultado.append("Nombres   : ").append(alumno.getNombres()).append("\n");
		            resultado.append("Apellidos : ").append(alumno.getApellidos()).append("\n");
		            resultado.append("DNI       : ").append(alumno.getDni()).append("\n");
		            resultado.append("Edad      : ").append(alumno.getEdad()).append("\n");
		            resultado.append("Celular   : ").append(alumno.getCelular()).append("\n");
		            resultado.append("Estado    : ").append(FrmMenu.arrAlumnos.EstadoToText(alumno.getEstado())).append("\n\n");
		        }

		        // 2. Buscar Curso
		        Curso curso = FrmMenu.arrCursos.buscarCursoPorCodigo(codigo);
		        if (curso != null) {
		            resultado.append("=== CURSO ===\n");
		            resultado.append("Código     : ").append(curso.getCodCurso()).append("\n");
		            resultado.append("Asignatura : ").append(curso.getAsignatura()).append("\n");
		            resultado.append("Ciclo      : ").append(FrmMenu.arrCursos.cicloToText(curso.getCiclo())).append("\n");
		            resultado.append("Créditos   : ").append(curso.getCreditos()).append("\n");
		            resultado.append("Horas      : ").append(curso.getHoras()).append("\n\n");
		        }

		        // 3. Buscar Matrícula
		        for (Matricula m : FrmMenu.listaMatriculas) {
		            if (m.getNumMatricula() == codigo) {
		                resultado.append("=== MATRÍCULA ===\n");
		                resultado.append("N° Matrícula  : ").append(m.getNumMatricula()).append("\n");
		                resultado.append("Código Alumno : ").append(m.getCodAlumno()).append("\n");
		                resultado.append("Código Curso  : ").append(m.getCodCurso()).append("\n");
		                resultado.append("Fecha         : ").append(m.getFecha()).append("\n");
		                resultado.append("Hora          : ").append(m.getHora()).append("\n\n");
		                break;
		            }
		        }

		        // 4. Buscar Retiro
		        if (FrmMenu.listaRetiros != null) {
		            for (Retiro r : FrmMenu.listaRetiros) {
		                if (r.getNumRetiro() == codigo) {
		                    resultado.append("=== RETIRO ===\n");
		                    resultado.append("N° Retiro    : ").append(r.getNumRetiro()).append("\n");
		                    resultado.append("N° Matrícula : ").append(r.getNumMatricula()).append("\n");
		                    resultado.append("Fecha        : ").append(r.getFecha()).append("\n");
		                    resultado.append("Hora         : ").append(r.getHora()).append("\n\n");
		                    break;
		                }
		            }
		        }

		        if (resultado.length() == 0) {
		            txtResultado.setText("No se encontró información para el código: " + codigo);
		        } else {
		            txtResultado.setText(resultado.toString());
		        }

		    } catch (NumberFormatException ex) {
		        txtResultado.setText("El código debe ser numérico.");
		    }
		}
	

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> new FrmConsulta().setVisible(true));
	}
}