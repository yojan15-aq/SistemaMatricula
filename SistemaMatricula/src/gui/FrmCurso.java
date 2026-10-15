package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Utils.Mensaje;
import arreglos.ArrayCursos;
import clases.Alumno;
import clases.Curso;

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

public class FrmCurso extends JFrame implements ActionListener, ItemListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblcodCurso;
	private JTextField txtCodCurso;
	private JLabel lblAsignatura;
	private JTextField txtAsignatura;
	private JLabel lblCiclo;
	private JComboBox cboCiclo;
	private JLabel lblCreditos;
	private JTextField txtCreditos;
	private JLabel lblHoras;
	private JTextField txtHoras;
	private JTable tblCursos;
	private JButton btnAdicionar;
	private JButton btnConsultar;
	private JToggleButton btnModificar;
	private JButton btnEliminar;
	
	private DefaultTableModel tmodel;
	private ArrayCursos cursos = new ArrayCursos();

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
		
		txtAsignatura = new JTextField();
		txtAsignatura.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtAsignatura.setColumns(10);
		txtAsignatura.setBounds(10, 88, 189, 27);
		contentPane.add(txtAsignatura);
		
		cboCiclo = new JComboBox();
		cboCiclo.setModel(new DefaultComboBoxModel(new String[] {"Primero", "Segundo", "Tercero", "Cuarto", "Quinto", "Sexto"}));
		cboCiclo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboCiclo.setBounds(10, 139, 189, 27);
		contentPane.add(cboCiclo);
		
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
		
		txtHoras =  new JTextField();
		txtHoras.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtHoras.setColumns(10);
		txtHoras.setBounds(10, 238, 189, 27);
		contentPane.add(txtHoras);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(220, 20, 520, 340);
		contentPane.add(scrollPane);

		
		String[] columnas = { "Código", "Asignatura", "Ciclo", "Créditos", "Horas" };
		tmodel = new DefaultTableModel();
		tmodel.setColumnIdentifiers(columnas);
		tblCursos = new JTable(tmodel);
		scrollPane.setViewportView(tblCursos);
//		tblAlumnos.setModel(new javax.swing.table.DefaultTableModel(
//			new Object[][] {},
//			new String[] { "Código", "Asignatura", "Ciclo", "Créditos", "Horas" }
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
		
		generarCursosPrueba();

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
		
		Curso curso = verificarCurso(true);
		
		if (curso == null) return;
		
		cursos.agregarCurso(curso);
		
		cursos.mostrarEnTabla(tmodel);
		
		limpiarCampos();
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		int rowIndex = tblCursos.getSelectedRow();
		if (rowIndex == -1) {
			Mensaje.dialog(this, "Primero selecciona un Curso de la tabla");
		}
		else if (Mensaje.confirmar(this, "Eliminar?")){
			int codigo = (int) tmodel.getValueAt(rowIndex, 0); // 0 es la columna de codigo
			cursos.removerCurso(codigo);
			cursos.mostrarEnTabla(tmodel);
		}
		else Mensaje.dialog(this, "Eliminación cancelada");
	}
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == btnModificar) {
			itemStateChangedBtnModificar(e);
		}
	}
	protected void itemStateChangedBtnModificar(ItemEvent e) {
		int rowIndex = tblCursos.getSelectedRow();
		
		if (rowIndex == -1) {
			Mensaje.dialog(this, "Primero selecciona un curso de la tabla");
			btnModificar.setSelected(false);
			return;
		}
		if (btnModificar.isSelected()) {
			txtCodCurso.setText(tblCursos.getValueAt(rowIndex, 0) + "");
			txtAsignatura.setText(tblCursos.getValueAt(rowIndex, 1) + "");
			cboCiclo.setSelectedIndex(
					cursos.TextToCiclo(tblCursos.getValueAt(rowIndex, 2) + "")
					);
			txtCreditos.setText(tblCursos.getValueAt(rowIndex, 3) + "");
			txtHoras.setText(tblCursos.getValueAt(rowIndex, 4) + "");
			
			
			txtCodCurso.setEnabled(false);
//			txtDni.setEnabled(false);
			
		} else {

			Curso curso = verificarCurso(false);
			
			if (curso == null) return;
			
			cursos.actualizar(curso);
			cursos.mostrarEnTabla(tmodel);
			limpiarCampos();		
		}
	}
	
	// setear campos a vacios
	public void limpiarCampos() {
		txtCodCurso.setText("");
		txtAsignatura.setText("");
		cboCiclo.setSelectedIndex(0);
		txtCreditos.setText("");
		txtHoras.setText("");
	}
	
	public Curso verificarCurso(boolean verificarCod) {
		int codCurso, ciclo, creditos, horas;
		String asignatura;
		try {
			codCurso = Integer.parseInt(txtCodCurso.getText());
			asignatura = txtAsignatura.getText();
			ciclo = cboCiclo.getSelectedIndex();
			creditos = Integer.parseInt(txtCreditos.getText());
			horas = Integer.parseInt(txtHoras.getText());
		} catch (Exception e2) {
			Mensaje.alerta(
					this, 
					"Debe completar CORRECTAMENTE todos los campos",
					"Error en los campos de texto"
					);
			return null;
			// TODO: handle exception
		}
		if (codCurso <= 1000 || codCurso >= 10000) {
			Mensaje.dialog(this, "El código debe ser de 4 dígitos");
			return null;
		}
		else if (verificarCod && cursos.verificarCodigoRepetido(codCurso)) {
			Mensaje.dialog(this, "El Código ya está registrado");
			return null;
		}
		
		return new Curso(codCurso, asignatura, ciclo, creditos, horas);
	}
	// generrar 5 cursos de prueba
	public void generarCursosPrueba() {
		cursos.agregarCurso(new Curso(1001, "Matemática", 0, 4, 60));
		cursos.agregarCurso(new Curso(1020, "Física", 1, 3, 45));
		cursos.agregarCurso(new Curso(1030, "Química", 2, 4, 60));
		cursos.agregarCurso(new Curso(1040, "Biología", 3, 3, 45));
		cursos.agregarCurso(new Curso(1005, "Historia", 4, 2, 30));
		
		cursos.mostrarEnTabla(tmodel);
	}
	protected void actionPerformedBtnConsultar(ActionEvent e) {

//		int codCurso;
//		try {
//			codCurso = Integer.parseInt(txtCodCurso.getText());
//		} catch (Exception e2) {
//			Mensaje.alerta(
//					this, 
//					"Debe ingresar un código válido",
//					"Error en el campo de texto"
//					);
//			return;
//		}
//		// mostrar el curso en los campos de texto
//		Curso curso = cursos.buscarCursoPorCodigo(codCurso);
//		
//		
//		
//		
//		
	}
}
