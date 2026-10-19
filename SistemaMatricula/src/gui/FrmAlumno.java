package gui;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import Utils.Mensaje;
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
import javax.swing.BorderFactory;

public class FrmAlumno extends JFrame implements ActionListener, ItemListener {

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
	private JComboBox<String> cboEstado;
	private JTable tblAlumnos;
	private JButton btnAdicionar;
	private JButton btnConsultar;
	private JToggleButton btnModificar;
	private JButton btnEliminar;
	private DefaultTableModel tmodel;

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

	public FrmAlumno() {
		setTitle("Mantenimiento - Alumno");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 780, 480);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(40, 40, 45));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblcodigo = new JLabel("Código");
		lblcodigo.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblcodigo.setForeground(Color.WHITE);
		lblcodigo.setBounds(10, 0, 189, 37);
		contentPane.add(lblcodigo);

		txtCodAlumno = new JTextField();
		txtCodAlumno.setEditable(false);
		txtCodAlumno.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtCodAlumno.setBackground(new Color(55, 55, 60));
		txtCodAlumno.setForeground(Color.WHITE);
		txtCodAlumno.setCaretColor(Color.WHITE);
		txtCodAlumno.setBorder(BorderFactory.createLineBorder(new Color(80, 80, 85)));
		txtCodAlumno.setBounds(10, 32, 189, 27);
		contentPane.add(txtCodAlumno);

		lblNombres = new JLabel("Nombres");
		lblNombres.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNombres.setForeground(Color.WHITE);
		lblNombres.setBounds(10, 60, 189, 27);
		contentPane.add(lblNombres);

		txtNombres = new JTextField();
		txtNombres.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtNombres.setBackground(new Color(55, 55, 60));
		txtNombres.setForeground(Color.WHITE);
		txtNombres.setCaretColor(Color.WHITE);
		txtNombres.setBorder(BorderFactory.createLineBorder(new Color(80, 80, 85)));
		txtNombres.setBounds(10, 88, 189, 27);
		contentPane.add(txtNombres);

		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblApellidos.setForeground(Color.WHITE);
		lblApellidos.setBounds(10, 115, 189, 27);
		contentPane.add(lblApellidos);

		txtApellidos = new JTextField();
		txtApellidos.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtApellidos.setBackground(new Color(55, 55, 60));
		txtApellidos.setForeground(Color.WHITE);
		txtApellidos.setCaretColor(Color.WHITE);
		txtApellidos.setBorder(BorderFactory.createLineBorder(new Color(80, 80, 85)));
		txtApellidos.setBounds(10, 139, 189, 27);
		contentPane.add(txtApellidos);

		lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblDni.setForeground(Color.WHITE);
		lblDni.setBounds(10, 165, 189, 27);
		contentPane.add(lblDni);

		txtDni = new JTextField();
		txtDni.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtDni.setBackground(new Color(55, 55, 60));
		txtDni.setForeground(Color.WHITE);
		txtDni.setCaretColor(Color.WHITE);
		txtDni.setBorder(BorderFactory.createLineBorder(new Color(80, 80, 85)));
		txtDni.setBounds(10, 187, 189, 27);
		contentPane.add(txtDni);

		lblEdad = new JLabel("Edad");
		lblEdad.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblEdad.setForeground(Color.WHITE);
		lblEdad.setBounds(10, 214, 189, 27);
		contentPane.add(lblEdad);

		txtEdad = new JTextField();
		txtEdad.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtEdad.setBackground(new Color(55, 55, 60));
		txtEdad.setForeground(Color.WHITE);
		txtEdad.setCaretColor(Color.WHITE);
		txtEdad.setBorder(BorderFactory.createLineBorder(new Color(80, 80, 85)));
		txtEdad.setBounds(10, 238, 189, 27);
		contentPane.add(txtEdad);

		lblCelular = new JLabel("Celular");
		lblCelular.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblCelular.setForeground(Color.WHITE);
		lblCelular.setBounds(10, 265, 189, 27);
		contentPane.add(lblCelular);

		txtCelular = new JTextField();
		txtCelular.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtCelular.setBackground(new Color(55, 55, 60));
		txtCelular.setForeground(Color.WHITE);
		txtCelular.setCaretColor(Color.WHITE);
		txtCelular.setBorder(BorderFactory.createLineBorder(new Color(80, 80, 85)));
		txtCelular.setBounds(10, 287, 189, 27);
		contentPane.add(txtCelular);

		lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblEstado.setForeground(Color.WHITE);
		lblEstado.setBounds(10, 316, 189, 27);
		contentPane.add(lblEstado);

		cboEstado = new JComboBox<>();
		cboEstado.setEnabled(false);
		cboEstado.setModel(new DefaultComboBoxModel<>(new String[] {"Registrado", "Matriculado", "Retirado"}));
		cboEstado.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		cboEstado.setBackground(new Color(55, 55, 60));
		cboEstado.setForeground(Color.WHITE);
		cboEstado.setBounds(10, 339, 189, 27);
		contentPane.add(cboEstado);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(220, 20, 520, 340);
		contentPane.add(scrollPane);

		String[] cabeceras = {"Código", "Nombres", "Apellidos", "DNI", "Edad", "Celular", "Estado"};
		tmodel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tmodel.setColumnIdentifiers(cabeceras);
		tblAlumnos = new JTable(tmodel);
		tblAlumnos.setBackground(new Color(50, 50, 55));
		tblAlumnos.setForeground(Color.WHITE);
		tblAlumnos.setGridColor(new Color(70, 70, 75));
		tblAlumnos.setSelectionBackground(new Color(33, 150, 243));
		tblAlumnos.setSelectionForeground(Color.WHITE);
		tblAlumnos.getTableHeader().setBackground(new Color(60, 60, 65));
		tblAlumnos.getTableHeader().setForeground(Color.WHITE);
		scrollPane.setViewportView(tblAlumnos);

		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBackground(new Color(46, 125, 50));
		btnAdicionar.setForeground(Color.WHITE);
		btnAdicionar.setFocusPainted(false);
		btnAdicionar.setBorderPainted(false);
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(20, 400, 130, 32);
		contentPane.add(btnAdicionar);

		btnConsultar = new JButton("Consultar");
		btnConsultar.setBackground(new Color(33, 150, 243));
		btnConsultar.setForeground(Color.WHITE);
		btnConsultar.setFocusPainted(false);
		btnConsultar.setBorderPainted(false);
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(160, 400, 130, 32);
		contentPane.add(btnConsultar);

		btnModificar = new JToggleButton("Modificar");
		btnModificar.setBackground(new Color(255, 152, 0));
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setFocusPainted(false);
		btnModificar.setBorderPainted(false);
		btnModificar.addItemListener(this);
		btnModificar.setBounds(300, 400, 130, 32);
		contentPane.add(btnModificar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBackground(new Color(198, 40, 40));
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFocusPainted(false);
		btnEliminar.setBorderPainted(false);
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(440, 400, 130, 32);
		contentPane.add(btnEliminar);

		txtCodAlumno.setText(Alumno.contadorAlumnos + "");
		FrmMenu.arrAlumnos.mostrarEnTabla(tmodel);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConsultar) actionPerformedBtnConsultar(e);
		if (e.getSource() == btnEliminar) actionPerformedBtnEliminar(e);
		if (e.getSource() == btnAdicionar) actionPerformedBtnAdicionar(e);
	}

	protected void actionPerformedBtnAdicionar(ActionEvent e) {
		Alumno a = verificarAlumno(true);
		if (a == null) return;

		FrmMenu.arrAlumnos.agregarAlumno(a);
		FrmMenu.arrAlumnos.mostrarEnTabla(tmodel);
		limpiarCampos(true);
		txtCodAlumno.setText(Alumno.contadorAlumnos + "");
		FrmMenu.guardarDatos();
		Mensaje.dialog(this, "Alumno agregado correctamente");
	}

	protected void actionPerformedBtnEliminar(ActionEvent e) {
		int rowIndex = tblAlumnos.getSelectedRow();
		if (rowIndex == -1) {
			Mensaje.dialog(this, "Primero selecciona un alumno de la tabla");
		}
		else if (FrmMenu.arrAlumnos.TextToEstado(tmodel.getValueAt(rowIndex, 6) + "") != 0) {
			Mensaje.dialog(this, "No se puede eliminar, Ya esta " + tmodel.getValueAt(rowIndex, 6));
		}
		else if (Mensaje.confirmar(this, "Eliminar?")) {
			int codigo = (int) tmodel.getValueAt(rowIndex, 0);
			FrmMenu.arrAlumnos.removerAlumno(codigo);
			FrmMenu.arrAlumnos.mostrarEnTabla(tmodel);
			FrmMenu.guardarDatos();
		}
		else Mensaje.dialog(this, "Eliminación cancelada");
	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == btnModificar) itemStateChangedBtnModificar(e);
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
			cboEstado.setEnabled(false);
			txtCodAlumno.setText(tblAlumnos.getValueAt(rowIndex, 0) + "");
			txtNombres.setText(tblAlumnos.getValueAt(rowIndex, 1) + "");
			txtApellidos.setText(tblAlumnos.getValueAt(rowIndex, 2) + "");
			txtDni.setText(tblAlumnos.getValueAt(rowIndex, 3) + "");
			txtEdad.setText(tblAlumnos.getValueAt(rowIndex, 4) + "");
			txtCelular.setText(tblAlumnos.getValueAt(rowIndex, 5) + "");
			cboEstado.setSelectedIndex(FrmMenu.arrAlumnos.TextToEstado(tblAlumnos.getValueAt(rowIndex, 6) + ""));
		} else {
			Alumno a = verificarAlumno(false);
			if (a == null) return;
			FrmMenu.arrAlumnos.actualizar(a);
			txtCodAlumno.setEnabled(true);
			txtDni.setEnabled(true);
			cboEstado.setEnabled(false);
			FrmMenu.arrAlumnos.mostrarEnTabla(tmodel);
			limpiarCampos(false);
			FrmMenu.guardarDatos();
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
			estado = cboEstado.getSelectedIndex();
		} catch (Exception e2) {
			Mensaje.alerta(this, "Debe completar CORRECTAMENTE todos los campos", "Error en los campos de texto");
			return null;
		}
		if (verificarDNI && FrmMenu.arrAlumnos.verificarDniRepetido(dni)) {
			Mensaje.dialog(this, "El DNI ya está registrado");
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
		return new Alumno(codAlumno, nombres, apellidos, dni, edad, celular, estado);
	}

	private void limpiarCampos(boolean a) {
		txtCodAlumno.setText(a ? Alumno.generarCodigoAlumno() + "" : Alumno.contadorAlumnos + "");
		txtNombres.setText("");
		txtApellidos.setText("");
		txtDni.setText("");
		txtEdad.setText("");
		txtCelular.setText("");
		cboEstado.setSelectedIndex(0);
	}

	protected void actionPerformedBtnConsultar(ActionEvent e) {
		JComboBox<String> cbo = new JComboBox<>();
		cbo.setEnabled(true);
		cbo.setEditable(true);
		cbo.setModel(new DefaultComboBoxModel<>(FrmMenu.arrAlumnos.getArrayCodAlumnos()));
		cbo.setFont(new Font("Segoe UI", Font.PLAIN, 12));

		int cod = Mensaje.consultarAlumno(this, cbo);
		if (cod == -1) return;

		Alumno a = FrmMenu.arrAlumnos.buscarAlumnoPorCodigo(cod);
		Mensaje.dialog(this,
				"Codigo: " + a.getCodAlumno() +
				"\nNombres: " + a.getNombres() +
				"\nApellidos: " + a.getApellidos() +
				"\nDNI: " + a.getDni() +
				"\nEdad: " + a.getEdad() +
				"\nCelular: " + a.getCelular() +
				"\nEstado: " + FrmMenu.arrAlumnos.EstadoToText(a.getEstado()));
	}
}