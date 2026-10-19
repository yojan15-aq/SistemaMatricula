package gui;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import Utils.Mensaje;
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
import javax.swing.BorderFactory;

public class FrmCurso extends JFrame implements ActionListener, ItemListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblcodCurso;
	private JTextField txtCodCurso;
	private JLabel lblAsignatura;
	private JTextField txtAsignatura;
	private JLabel lblCiclo;
	private JComboBox<String> cboCiclo;
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

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				new FrmCurso().setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public FrmCurso() {
		setTitle("Mantenimiento - Curso");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 780, 480);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(40, 40, 45));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblcodCurso = new JLabel("Código");
		lblcodCurso.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblcodCurso.setForeground(Color.WHITE);
		lblcodCurso.setBounds(10, 0, 189, 37);
		contentPane.add(lblcodCurso);

		txtCodCurso = new JTextField();
		txtCodCurso.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtCodCurso.setBackground(new Color(55, 55, 60));
		txtCodCurso.setForeground(Color.WHITE);
		txtCodCurso.setCaretColor(Color.WHITE);
		txtCodCurso.setBorder(BorderFactory.createLineBorder(new Color(80, 80, 85)));
		txtCodCurso.setBounds(10, 32, 189, 27);
		contentPane.add(txtCodCurso);

		lblAsignatura = new JLabel("Asignatura");
		lblAsignatura.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblAsignatura.setForeground(Color.WHITE);
		lblAsignatura.setBounds(10, 60, 189, 27);
		contentPane.add(lblAsignatura);

		txtAsignatura = new JTextField();
		txtAsignatura.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtAsignatura.setBackground(new Color(55, 55, 60));
		txtAsignatura.setForeground(Color.WHITE);
		txtAsignatura.setCaretColor(Color.WHITE);
		txtAsignatura.setBorder(BorderFactory.createLineBorder(new Color(80, 80, 85)));
		txtAsignatura.setBounds(10, 88, 189, 27);
		contentPane.add(txtAsignatura);

		lblCiclo = new JLabel("Ciclo");
		lblCiclo.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblCiclo.setForeground(Color.WHITE);
		lblCiclo.setBounds(10, 115, 189, 27);
		contentPane.add(lblCiclo);

		cboCiclo = new JComboBox<>();
		cboCiclo.setModel(new DefaultComboBoxModel<>(new String[] {"Primero", "Segundo", "Tercero", "Cuarto", "Quinto", "Sexto"}));
		cboCiclo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		cboCiclo.setBackground(new Color(55, 55, 60));
		cboCiclo.setForeground(Color.WHITE);
		cboCiclo.setBounds(10, 139, 189, 27);
		contentPane.add(cboCiclo);

		lblCreditos = new JLabel("Créditos");
		lblCreditos.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblCreditos.setForeground(Color.WHITE);
		lblCreditos.setBounds(10, 165, 189, 27);
		contentPane.add(lblCreditos);

		txtCreditos = new JTextField();
		txtCreditos.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtCreditos.setBackground(new Color(55, 55, 60));
		txtCreditos.setForeground(Color.WHITE);
		txtCreditos.setCaretColor(Color.WHITE);
		txtCreditos.setBorder(BorderFactory.createLineBorder(new Color(80, 80, 85)));
		txtCreditos.setBounds(10, 187, 189, 27);
		contentPane.add(txtCreditos);

		lblHoras = new JLabel("Horas");
		lblHoras.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblHoras.setForeground(Color.WHITE);
		lblHoras.setBounds(10, 214, 189, 27);
		contentPane.add(lblHoras);

		txtHoras = new JTextField();
		txtHoras.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtHoras.setBackground(new Color(55, 55, 60));
		txtHoras.setForeground(Color.WHITE);
		txtHoras.setCaretColor(Color.WHITE);
		txtHoras.setBorder(BorderFactory.createLineBorder(new Color(80, 80, 85)));
		txtHoras.setBounds(10, 238, 189, 27);
		contentPane.add(txtHoras);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(220, 20, 520, 340);
		contentPane.add(scrollPane);

		String[] columnas = {"Código", "Asignatura", "Ciclo", "Créditos", "Horas"};
		tmodel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tmodel.setColumnIdentifiers(columnas);
		tblCursos = new JTable(tmodel);
		tblCursos.setBackground(new Color(50, 50, 55));
		tblCursos.setForeground(Color.WHITE);
		tblCursos.setGridColor(new Color(70, 70, 75));
		tblCursos.setSelectionBackground(new Color(33, 150, 243));
		tblCursos.setSelectionForeground(Color.WHITE);
		tblCursos.getTableHeader().setBackground(new Color(60, 60, 65));
		tblCursos.getTableHeader().setForeground(Color.WHITE);
		scrollPane.setViewportView(tblCursos);

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

		FrmMenu.arrCursos.mostrarEnTabla(tmodel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdicionar) actionPerformedBtnAdicionar(e);
		if (e.getSource() == btnConsultar) actionPerformedBtnConsultar(e);
		if (e.getSource() == btnEliminar) actionPerformedBtnEliminar(e);
	}

	protected void actionPerformedBtnAdicionar(ActionEvent e) {
		Curso curso = verificarCurso(true);
		if (curso == null) return;

		FrmMenu.arrCursos.agregarCurso(curso);
		FrmMenu.arrCursos.mostrarEnTabla(tmodel);
		limpiarCampos();
		FrmMenu.guardarDatos();
		Mensaje.dialog(this, "Curso agregado correctamente");
	}

	protected void actionPerformedBtnEliminar(ActionEvent e) {
		int rowIndex = tblCursos.getSelectedRow();
		if (rowIndex == -1) {
			Mensaje.dialog(this, "Primero selecciona un Curso de la tabla");
			return;
		}
		if (Mensaje.confirmar(this, "¿Eliminar este curso?")) {
			int codigo = Integer.parseInt(tblCursos.getValueAt(rowIndex, 0) + "");
			FrmMenu.arrCursos.removerCurso(codigo);
			FrmMenu.arrCursos.mostrarEnTabla(tmodel);
			FrmMenu.guardarDatos();
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == btnModificar) itemStateChangedBtnModificar(e);
	}

	protected void itemStateChangedBtnModificar(ItemEvent e) {
		int rowIndex = tblCursos.getSelectedRow();
		if (rowIndex == -1) {
			Mensaje.dialog(this, "Primero selecciona un curso de la tabla");
			btnModificar.setSelected(false);
			return;
		}
		if (btnModificar.isSelected()) {
			txtCodCurso.setEnabled(false);
			txtCodCurso.setText(tblCursos.getValueAt(rowIndex, 0) + "");
			txtAsignatura.setText(tblCursos.getValueAt(rowIndex, 1) + "");
			cboCiclo.setSelectedIndex(FrmMenu.arrCursos.TextToCiclo(tblCursos.getValueAt(rowIndex, 2) + ""));
			txtCreditos.setText(tblCursos.getValueAt(rowIndex, 3) + "");
			txtHoras.setText(tblCursos.getValueAt(rowIndex, 4) + "");
		} else {
			Curso curso = verificarCurso(false);
			if (curso == null) return;
			FrmMenu.arrCursos.actualizar(curso);
			txtCodCurso.setEnabled(true);
			FrmMenu.arrCursos.mostrarEnTabla(tmodel);
			limpiarCampos();
			FrmMenu.guardarDatos();
		}
	}

	private Curso verificarCurso(boolean verificarCod) {
		try {
			int codCurso = Integer.parseInt(txtCodCurso.getText());
			String asignatura = txtAsignatura.getText().trim();
			int ciclo = cboCiclo.getSelectedIndex();
			int creditos = Integer.parseInt(txtCreditos.getText());
			int horas = Integer.parseInt(txtHoras.getText());

			if (asignatura.isEmpty()) {
				Mensaje.dialog(this, "Ingrese el nombre de la asignatura");
				return null;
			}
			if (codCurso < 1000 || codCurso > 9999) {
				Mensaje.dialog(this, "El código debe ser de 4 dígitos");
				return null;
			}
			if (verificarCod && FrmMenu.arrCursos.verificarCodigoRepetido(codCurso)) {
				Mensaje.dialog(this, "El código ya está registrado");
				return null;
			}
			return new Curso(codCurso, asignatura, ciclo, creditos, horas);
		} catch (Exception ex) {
			Mensaje.alerta(this, "Complete correctamente todos los campos", "Error");
			return null;
		}
	}

	private void limpiarCampos() {
		txtCodCurso.setText("");
		txtAsignatura.setText("");
		cboCiclo.setSelectedIndex(0);
		txtCreditos.setText("");
		txtHoras.setText("");
	}

	protected void actionPerformedBtnConsultar(ActionEvent e) {
		JComboBox<String> cbo = new JComboBox<>();
		cbo.setModel(new DefaultComboBoxModel<>(FrmMenu.arrCursos.getArrayCodCursos()));
		int cod = Mensaje.consultarAlumno(this, cbo);
		if (cod == -1) return;

		Curso c = FrmMenu.arrCursos.buscarCursoPorCodigo(cod);
		if (c != null) {
			Mensaje.dialog(this,
				"Código: " + c.getCodCurso() +
				"\nAsignatura: " + c.getAsignatura() +
				"\nCiclo: " + FrmMenu.arrCursos.cicloToText(c.getCiclo()) +
				"\nCréditos: " + c.getCreditos() +
				"\nHoras: " + c.getHoras());
		}
	}
}