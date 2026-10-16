package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Utils.Mensaje;
import arreglos.ArrayAlumnos;
import clases.Alumno;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class FrmAlumno extends JFrame implements ActionListener, ItemListener {
//hola yojan 2
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
	private JComboBox cboEstado;
	private JTable tblAlumnos;
	private JButton btnAdicionar;
	private JButton btnConsultar;
	private JToggleButton btnModificar;
	private JButton btnEliminar;
	private DefaultTableModel tmodel;
	
	
	private ArrayAlumnos alumnos = new ArrayAlumnos();

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
		
		cboEstado = new JComboBox();
		cboEstado.setEnabled(false);
		cboEstado.setModel(new DefaultComboBoxModel(new String[] {"Registrado", "Matriculado", "Retirado"}));
		cboEstado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboEstado.setBounds(10, 339, 189, 27);
		contentPane.add(cboEstado);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(220, 20, 520, 340);
		contentPane.add(scrollPane);

		
		String[] cabeceras = {"Código", "Nombres", "Apellidos", "DNI", "Edad", "Celular", "Estado"};
		tmodel = new DefaultTableModel();
		tmodel.setColumnIdentifiers(cabeceras);
		tblAlumnos = new JTable(tmodel);
		scrollPane.setViewportView(tblAlumnos);
//		tblAlumnos.setModel(new javax.swing.table.DefaultTableModel(
//			new Object[][] {},
//			new String[] { "Código", "Nombres", "Apellidos", "DNI", "Edad", "Celular", "Estado" }
//		));
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(20, 400, 130, 30);
		contentPane.add(btnAdicionar);

		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(160, 400, 130, 30);
		contentPane.add(btnConsultar);

		btnModificar = new JToggleButton("Modificar");
		btnModificar.addItemListener(this);
		btnModificar.setBounds(300, 400, 130, 30);
		contentPane.add(btnModificar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(440, 400, 130, 30);
		contentPane.add(btnEliminar);

		txtCodAlumno.setText(Alumno.contadorAlumnos + "");
		generarAlumnosPrueba();
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(e);
		}
	}
	protected void actionPerformedBtnAdicionar(ActionEvent e) {
		Alumno a = verificarAlumno(true);
		
		if (a == null) return;
		
//		Alumno alumno = new Alumno(codAlumno, nombres, apellidos, dni, edad, celular, estado);
		alumnos.agregarAlumno(a);
		alumnos.mostrarEnTabla(tmodel);
		
		limpiarCampos(true);
		txtCodAlumno.setText(Alumno.contadorAlumnos + "");
		
		Mensaje.dialog(this, "Alumno agregado correctamente");
//		System.out.println(Mensaje.confirmar(this, "si o no?"));
	}
	
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		int rowIndex = tblAlumnos.getSelectedRow();
		if (rowIndex == -1) {
			Mensaje.dialog(this, "Primero selecciona un alumno de la tabla");
		}
		else if (alumnos.TextToEstado(tmodel.getValueAt(rowIndex, 6) + "") != 0)  {
			Mensaje.dialog(this, "No se puede eliminar, Ya esta " + tmodel.getValueAt(rowIndex, 6));
		}
		else if (Mensaje.confirmar(this, "Eliminar?")){
			int codigo = (int) tmodel.getValueAt(rowIndex, 0); // 0 es la columna de codigo
			alumnos.removerAlumno(codigo);
			alumnos.mostrarEnTabla(tmodel);
		}
		else Mensaje.dialog(this, "Eliminación cancelada");
	}
	
	
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == btnModificar) {
			itemStateChangedBtnModificar(e);
		}
	}
	protected void itemStateChangedBtnModificar(ItemEvent e) {
		int rowIndex = tblAlumnos.getSelectedRow();
		
		if (rowIndex == -1) {
			Mensaje.dialog(this, "Primero selecciona un alumno de la tabla");
			btnModificar.setSelected(false);
			return;
		}
		if (btnModificar.isSelected()) {
			txtCodAlumno.setEnabled(false);
			txtDni.setEnabled(false);
			cboEstado.setEditable(true);
			cboEstado.setEnabled(true);
			txtCodAlumno.setText(tblAlumnos.getValueAt(rowIndex, 0) + "");
			txtNombres.setText(tblAlumnos.getValueAt(rowIndex, 1) + "");
			txtApellidos.setText(tblAlumnos.getValueAt(rowIndex, 2) + "");
			txtDni.setText(tblAlumnos.getValueAt(rowIndex, 3) + "");
			txtEdad.setText(tblAlumnos.getValueAt(rowIndex, 4) + "");
			txtCelular.setText(tblAlumnos.getValueAt(rowIndex, 5) + "");
//			txtEstado.setText(tblAlumnos.getValueAt(rowIndex, 6) + "");
			cboEstado.setSelectedIndex(
					alumnos.TextToEstado(tblAlumnos.getValueAt(rowIndex, 6) + "")
					);
			
		} else {
			Alumno a = verificarAlumno(false);
			
			if (a == null) return;
			
			alumnos.actualizar(a);
			txtCodAlumno.setEnabled(true);
			txtDni.setEnabled(true);
			cboEstado.setEnabled(false);
			cboEstado.setEditable(false);
			alumnos.mostrarEnTabla(tmodel);
			limpiarCampos(false);		
		}
	}
	
	private Alumno verificarAlumno(boolean verificarDNI) {
		int codAlumno, edad, celular, estado;
		String nombres, apellidos, dni;
		try {
			codAlumno = Integer.parseInt(txtCodAlumno.getText());
			nombres = txtNombres.getText();
			apellidos = txtApellidos.getText();
			dni = txtDni.getText();
			edad = Integer.parseInt(txtEdad.getText());
			celular = Integer.parseInt(txtCelular.getText());
//			estado = Integer.parseInt(txtEstado.getText());
			estado = cboEstado.getSelectedIndex();
						
		} catch (Exception e2) {
			Mensaje.alerta(
					this, 
					"Debe completar CORRECTAMENTE todos los campos",
					"Error en los campos de texto"
					);
			return null;
			// TODO: handle exception
		}
		if (verificarDNI && alumnos.verificarDniRepetido(dni)) {
			Mensaje.dialog(this, "El DNI ya está registrado");
//			System.out.println("El DNI ya está registrado");
			return null;
		}
		if (Integer.parseInt(dni) < 10000000 || Integer.parseInt(dni) > 99999999) {
			Mensaje.dialog(this, "DNI no valido");
			return null;
		}
		if (edad < 10 || edad > 99) {
			Mensaje.dialog(this, "Edad No válida");
			return null;
		}
		if (celular < 900000000 || celular > 999999999) {
			Mensaje.dialog(this, "Numero de celular no válido, deben ser 9 dígitos");
			return null;
		}
		Alumno alumno = new Alumno(codAlumno, nombres, apellidos, dni, edad, celular, estado);
		return alumno;
	}
	
	private void limpiarCampos(boolean a) {
		txtCodAlumno.setText(a ? Alumno.generarCodigoAlumno() + "" : Alumno.contadorAlumnos + "");
		txtNombres.setText("");
		txtApellidos.setText("");
		txtDni.setText("");
		txtEdad.setText("");
		txtCelular.setText("");
		cboEstado.setSelectedIndex(0);;
	}
	// metodo que genero 5 alumnos de prueba
	public void generarAlumnosPrueba() {
		Alumno a1 = new Alumno(Alumno.generarCodigoAlumno(), "Juan", "Perez", "12345678", 20, 987654321, 0);
		Alumno a2 = new Alumno(Alumno.generarCodigoAlumno(), "Maria", "Gomez", "23456789", 22, 987654322, 1);
		Alumno a3 = new Alumno(Alumno.generarCodigoAlumno(), "Pedro", "Lopez", "34567890", 21, 987654323, 2);
		Alumno a4 = new Alumno(Alumno.generarCodigoAlumno(), "Ana", "Martinez", "45678901", 23, 987654324, 0);
		Alumno a5 = new Alumno(Alumno.generarCodigoAlumno(), "Luis", "Garcia", "56789012", 24, 987654325, 1);
		
		alumnos.agregarAlumno(a1);
		alumnos.agregarAlumno(a2);
		alumnos.agregarAlumno(a3);
		alumnos.agregarAlumno(a4);
		alumnos.agregarAlumno(a5);

		txtCodAlumno.setText(Alumno.contadorAlumnos + "");
		alumnos.mostrarEnTabla(tmodel);
	}
	
	protected void actionPerformedBtnConsultar(ActionEvent e) {
		JComboBox cbo = new JComboBox();
		cbo.setEnabled(true);
		cbo.setEditable(true);
//		cbo
		cbo.setModel(new DefaultComboBoxModel(alumnos.getArrayCodAlumnos()));
		cbo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		int cod = Mensaje.consultarAlumno(this, cbo);
		if (cod == -1) return;
		
		Alumno a = alumnos.buscarAlumnoPorCodigo(cod);
		Mensaje.dialog(this,
				"Codigo: " + a.getCodAlumno() +
				"\nNombres: " + a.getNombres() +
				"\nApellidos: " + a.getApellidos() +
				"\nDNI: " + a.getDni() +
				"\nEdad: " + a.getEdad() +
				"\nCelular: " + a.getCelular() +
				"\nEstado: " + a.getCelular());
	}
}
