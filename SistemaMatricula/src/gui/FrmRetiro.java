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

public class FrmRetiro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNumRetiro;
	private JTextField txtNumRetiro;
	private JLabel lblNumMatricula;
	private JTextField txtNumMatricula;
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
					FrmRetiro frame = new FrmRetiro();
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
	public FrmRetiro() {
		setTitle("Registro - Retiro");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 780, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNumRetiro = new JLabel("Número de retiro");
		lblNumRetiro.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNumRetiro.setBounds(10, 0, 189, 37);
		contentPane.add(lblNumRetiro);
		
		txtNumRetiro = new JTextField();
		txtNumRetiro.setEditable(false);
		txtNumRetiro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNumRetiro.setBounds(10, 32, 189, 27);
		contentPane.add(txtNumRetiro);
		txtNumRetiro.setColumns(10);
		
		lblNumMatricula = new JLabel("Numero de matrícula");
		lblNumMatricula.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNumMatricula.setBounds(10, 60, 189, 27);
		contentPane.add(lblNumMatricula);
		
		txtNumMatricula = new JTextField();
		txtNumMatricula.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNumMatricula.setColumns(10);
		txtNumMatricula.setBounds(10, 88, 189, 27);
		contentPane.add(txtNumMatricula);
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFecha.setBounds(10, 113, 189, 27);
		contentPane.add(lblFecha);
		
		txtCreditos = new JTextField();
		txtCreditos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCreditos.setColumns(10);
		txtCreditos.setBounds(10, 137, 189, 27);
		contentPane.add(txtCreditos);
		
		lblHora = new JLabel("Hora");
		lblHora.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHora.setBounds(10, 164, 189, 27);
		contentPane.add(lblHora);
		
		txtHora = new JTextField();
		txtHora.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtHora.setColumns(10);
		txtHora.setBounds(10, 187, 189, 27);
		contentPane.add(txtHora);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(220, 20, 520, 340);
		contentPane.add(scrollPane);

		tblAlumnos = new JTable();
		scrollPane.setViewportView(tblAlumnos);
		tblAlumnos.setModel(new javax.swing.table.DefaultTableModel(
			new Object[][] {},
			new String[] { "N° retiro", "N° matrícula", "Fecha", "Hora" }
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
