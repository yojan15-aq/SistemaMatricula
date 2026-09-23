package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class FrmMatricula extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNumMatricula;
	private JTextField txtNumMatricula;
	private JLabel lblCodAlum;
	private JTextField txtCodAlum;
	private JLabel lblCodCurso;
	private JTextField txtCodCurso;
	private JLabel lblFecha;
	private JTextField txtCreditos;
	private JLabel lblHora;
	private JTextField txtHora;
	private JTable tblAlumnos;
	private JButton btnAdicionar;
	private JButton btnConsultar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnLimpiar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMatricula frame = new FrmMatricula();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmMatricula() {
		setTitle("Registro - Matrícula}");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 780, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNumMatricula = new JLabel("Número de matricula");
		lblNumMatricula.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNumMatricula.setBounds(10, 0, 189, 37);
		contentPane.add(lblNumMatricula);
		
		txtNumMatricula = new JTextField();
		txtNumMatricula.setEditable(false);
		txtNumMatricula.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNumMatricula.setBounds(10, 32, 189, 27);
		contentPane.add(txtNumMatricula);
		txtNumMatricula.setColumns(10);
		
		lblCodAlum = new JLabel("Código alumno");
		lblCodAlum.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCodAlum.setBounds(10, 60, 189, 27);
		contentPane.add(lblCodAlum);
		
		lblCodCurso = new JLabel("Código curso");
		lblCodCurso.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCodCurso.setBounds(10, 115, 189, 27);
		contentPane.add(lblCodCurso);
		
		txtCodAlum = new JTextField();
		txtCodAlum.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCodAlum.setColumns(10);
		txtCodAlum.setBounds(10, 88, 189, 27);
		contentPane.add(txtCodAlum);
		
		txtCodCurso = new JTextField();
		txtCodCurso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCodCurso.setColumns(10);
		txtCodCurso.setBounds(10, 139, 189, 27);
		contentPane.add(txtCodCurso);
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFecha.setBounds(10, 165, 189, 27);
		contentPane.add(lblFecha);
		
		txtCreditos = new JTextField();
		txtCreditos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCreditos.setColumns(10);
		txtCreditos.setBounds(10, 187, 189, 27);
		contentPane.add(txtCreditos);
		
		lblHora = new JLabel("Hora");
		lblHora.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHora.setBounds(10, 214, 189, 27);
		contentPane.add(lblHora);
		
		txtHora = new JTextField();
		txtHora.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtHora.setColumns(10);
		txtHora.setBounds(10, 238, 189, 27);
		contentPane.add(txtHora);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(220, 20, 520, 340);
		contentPane.add(scrollPane);

		tblAlumnos = new JTable();
		scrollPane.setViewportView(tblAlumnos);
		tblAlumnos.setModel(new javax.swing.table.DefaultTableModel(
			new Object[][] {},
			new String[] { "N° matrícula", "Código alumno", "Código curso", "Fecha", "Hora" }
		));
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(20, 400, 130, 30);
		contentPane.add(btnAdicionar);

		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(160, 400, 130, 30);
		contentPane.add(btnConsultar);

		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(300, 400, 130, 30);
		contentPane.add(btnModificar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(440, 400, 130, 30);
		contentPane.add(btnEliminar);

		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(580, 400, 130, 30);
		contentPane.add(btnLimpiar);

	}
}
