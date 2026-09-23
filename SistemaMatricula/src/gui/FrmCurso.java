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

public class FrmCurso extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblcodCurso;
	private JTextField txtCodCurso;
	private JLabel lblAsignatura;
	private JTextField txtNombres;
	private JLabel lblCiclo;
	private JTextField txtCiclo;
	private JLabel lblCreditos;
	private JTextField txtCreditos;
	private JLabel lblHoras;
	private JTextField txtHoras;
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
					FrmCurso frame = new FrmCurso();
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
	public FrmCurso() {
		setTitle("Mantenimiento - Curso");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 780, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblcodCurso = new JLabel("Código");
		lblcodCurso.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblcodCurso.setBounds(10, 0, 189, 37);
		contentPane.add(lblcodCurso);
		
		txtCodCurso = new JTextField();
		txtCodCurso.setEditable(false);
		txtCodCurso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCodCurso.setBounds(10, 32, 189, 27);
		contentPane.add(txtCodCurso);
		txtCodCurso.setColumns(10);
		
		lblAsignatura = new JLabel("Asignatura");
		lblAsignatura.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAsignatura.setBounds(10, 60, 189, 27);
		contentPane.add(lblAsignatura);
		
		lblCiclo = new JLabel("Ciclo");
		lblCiclo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCiclo.setBounds(10, 115, 189, 27);
		contentPane.add(lblCiclo);
		
		txtNombres = new JTextField();
		txtNombres.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNombres.setColumns(10);
		txtNombres.setBounds(10, 88, 189, 27);
		contentPane.add(txtNombres);
		
		txtCiclo = new JTextField();
		txtCiclo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCiclo.setColumns(10);
		txtCiclo.setBounds(10, 139, 189, 27);
		contentPane.add(txtCiclo);
		
		lblCreditos = new JLabel("Créditos");
		lblCreditos.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCreditos.setBounds(10, 165, 189, 27);
		contentPane.add(lblCreditos);
		
		txtCreditos = new JTextField();
		txtCreditos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCreditos.setColumns(10);
		txtCreditos.setBounds(10, 187, 189, 27);
		contentPane.add(txtCreditos);
		
		lblHoras = new JLabel("Horas");
		lblHoras.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHoras.setBounds(10, 214, 189, 27);
		contentPane.add(lblHoras);
		
		txtHoras = new JTextField();
		txtHoras.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtHoras.setColumns(10);
		txtHoras.setBounds(10, 238, 189, 27);
		contentPane.add(txtHoras);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(220, 20, 520, 340);
		contentPane.add(scrollPane);

		tblAlumnos = new JTable();
		scrollPane.setViewportView(tblAlumnos);
		tblAlumnos.setModel(new javax.swing.table.DefaultTableModel(
			new Object[][] {},
			new String[] { "Código", "Asignatura", "Ciclo", "Créditos", "Horas" }
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
