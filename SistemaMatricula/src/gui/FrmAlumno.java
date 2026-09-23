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

public class FrmAlumno extends JFrame {
//hola
	//lol
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblcodigo;
	private JTextField txtCodAlumno;
	private JLabel lblNombres;
	private JTextField txtNombres;
	private JLabel lblApellidos;
	private JTextField txtApellidos;
	private JLabel lblDni;
	private JTextField txtDni;
	private JLabel lblEdad;
	private JTextField txtEdad;
	private JLabel lblCelular;
	private JTextField txtCelular;
	private JLabel lblEstado;
	private JTextField txtEstado;
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
					FrmAlumno frame = new FrmAlumno();
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
	public FrmAlumno() {
		setTitle("Mantenimiento - Alumno");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 780, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblcodigo = new JLabel("Código");
		lblcodigo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblcodigo.setBounds(10, 0, 189, 37);
		contentPane.add(lblcodigo);
		
		txtCodAlumno = new JTextField();
		txtCodAlumno.setEditable(false);
		txtCodAlumno.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCodAlumno.setBounds(10, 32, 189, 27);
		contentPane.add(txtCodAlumno);
		txtCodAlumno.setColumns(10);
		
		lblNombres = new JLabel("Nombres");
		lblNombres.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNombres.setBounds(10, 60, 189, 27);
		contentPane.add(lblNombres);
		
		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblApellidos.setBounds(10, 115, 189, 27);
		contentPane.add(lblApellidos);
		
		txtNombres = new JTextField();
		txtNombres.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNombres.setColumns(10);
		txtNombres.setBounds(10, 88, 189, 27);
		contentPane.add(txtNombres);
		
		txtApellidos = new JTextField();
		txtApellidos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(10, 139, 189, 27);
		contentPane.add(txtApellidos);
		
		lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDni.setBounds(10, 165, 189, 27);
		contentPane.add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDni.setColumns(10);
		txtDni.setBounds(10, 187, 189, 27);
		contentPane.add(txtDni);
		
		lblEdad = new JLabel("Edad");
		lblEdad.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEdad.setBounds(10, 214, 189, 27);
		contentPane.add(lblEdad);
		
		txtEdad = new JTextField();
		txtEdad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEdad.setColumns(10);
		txtEdad.setBounds(10, 238, 189, 27);
		contentPane.add(txtEdad);
		
		lblCelular = new JLabel("Celular");
		lblCelular.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCelular.setBounds(10, 265, 189, 27);
		contentPane.add(lblCelular);
		
		txtCelular = new JTextField();
		txtCelular.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCelular.setColumns(10);
		txtCelular.setBounds(10, 287, 189, 27);
		contentPane.add(txtCelular);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEstado.setBounds(10, 316, 189, 27);
		contentPane.add(lblEstado);
		
		txtEstado = new JTextField();
		txtEstado.setEditable(false);
		txtEstado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEstado.setColumns(10);
		txtEstado.setBounds(10, 339, 189, 27);
		contentPane.add(txtEstado);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(220, 20, 520, 340);
		contentPane.add(scrollPane);

		tblAlumnos = new JTable();
		scrollPane.setViewportView(tblAlumnos);
		tblAlumnos.setModel(new javax.swing.table.DefaultTableModel(
			new Object[][] {},
			new String[] { "Código", "Nombres", "Apellidos", "DNI", "Edad", "Celular", "Estado" }
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
