package gui;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import Utils.Mensaje;
import clases.Matricula;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JToggleButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class FrmMatricula extends JFrame implements ActionListener, ItemListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNumMatricula;
	private JTextField txtNumMatricula;
	private JLabel lblCodAlum;
	private JComboBox cboCodAlum;
	private JLabel lblCodCurso;
	private JComboBox cboCodCurso;
	private JTable tblMatriculas;
	private JButton btnAdicionar;
	private JButton btnConsultar;
	private JButton btnEliminar;
	private JToggleButton btnModificar;
	private DefaultTableModel tmodel;

//	private int contador = 1001;

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

	public FrmMatricula() {
		setTitle("Registro - Matrícula");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 780, 480);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(40, 40, 45));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNumMatricula = new JLabel("Número de matrícula");
		lblNumMatricula.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNumMatricula.setForeground(Color.WHITE);
		lblNumMatricula.setBounds(10, 0, 189, 37);
		contentPane.add(lblNumMatricula);

		txtNumMatricula = new JTextField();
		txtNumMatricula.setEnabled(false);
		txtNumMatricula.setEditable(false);
		txtNumMatricula.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtNumMatricula.setBackground(new Color(55, 55, 60));
		txtNumMatricula.setForeground(Color.WHITE);
		txtNumMatricula.setCaretColor(Color.WHITE);
		txtNumMatricula.setBorder(BorderFactory.createLineBorder(new Color(80, 80, 85)));
		txtNumMatricula.setBounds(10, 32, 189, 27);
		contentPane.add(txtNumMatricula);

		lblCodAlum = new JLabel("Código alumno");
		lblCodAlum.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblCodAlum.setForeground(Color.WHITE);
		lblCodAlum.setBounds(10, 60, 189, 27);
		contentPane.add(lblCodAlum);

		cboCodAlum = new JComboBox();
		cboCodAlum.setModel(new DefaultComboBoxModel(FrmMenu.arrAlumnos.getArrayCodAlumnos()));
		cboCodAlum.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		cboCodAlum.setBackground(new Color(55, 55, 60));
		cboCodAlum.setForeground(Color.WHITE);
		cboCodAlum.setBorder(BorderFactory.createLineBorder(new Color(80, 80, 85)));
		cboCodAlum.setBounds(10, 88, 189, 27);
		contentPane.add(cboCodAlum);

		lblCodCurso = new JLabel("Código curso");
		lblCodCurso.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblCodCurso.setForeground(Color.WHITE);
		lblCodCurso.setBounds(10, 115, 189, 27);
		contentPane.add(lblCodCurso);

		cboCodCurso = new JComboBox();
		cboCodCurso.setModel(new DefaultComboBoxModel(FrmMenu.arrCursos.getArrayCodCursos()));
		cboCodCurso.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		cboCodCurso.setBackground(new Color(55, 55, 60));
		cboCodCurso.setForeground(Color.WHITE);
		cboCodCurso.setBorder(BorderFactory.createLineBorder(new Color(80, 80, 85)));
		cboCodCurso.setBounds(10, 139, 189, 27);
		contentPane.add(cboCodCurso);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(220, 20, 520, 340);
		contentPane.add(scrollPane);

		tmodel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tmodel.setColumnIdentifiers(new String[] {"N° matrícula", "Código alumno", "Código curso", "Fecha", "Hora"});
		tblMatriculas = new JTable(tmodel);
		tblMatriculas.setBackground(new Color(50, 50, 55));
		tblMatriculas.setForeground(Color.WHITE);
		tblMatriculas.setGridColor(new Color(70, 70, 75));
		tblMatriculas.setSelectionBackground(new Color(33, 150, 243));
		tblMatriculas.setSelectionForeground(Color.WHITE);
		tblMatriculas.getTableHeader().setBackground(new Color(60, 60, 65));
		tblMatriculas.getTableHeader().setForeground(Color.WHITE);
		scrollPane.setViewportView(tblMatriculas);

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

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBackground(new Color(198, 40, 40));
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFocusPainted(false);
		btnEliminar.setBorderPainted(false);
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(300, 400, 130, 32);
		contentPane.add(btnEliminar);

		btnModificar = new JToggleButton("Modificar");
		btnModificar.addItemListener(this);
		
		btnModificar.setBackground(new Color(96, 125, 139));
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setFocusPainted(false);
		btnModificar.setBorderPainted(false);
		btnModificar.setBounds(440, 400, 130, 32);
		contentPane.add(btnModificar);

		txtNumMatricula.setText(Matricula.contador + "");
		cargarMatriculas();
	}

	private void cargarMatriculas() {
		tmodel.setRowCount(0);
		for (Matricula m : FrmMenu.listaMatriculas) {
			tmodel.addRow(new Object[]{
				m.getNumMatricula(),
				m.getCodAlumno(),
				m.getCodCurso(),
				m.getFecha(),
				m.getHora()
			});
		}
		if (!FrmMenu.listaMatriculas.isEmpty()) {
			Matricula.contador = FrmMenu.listaMatriculas.get(FrmMenu.listaMatriculas.size() - 1).getNumMatricula() + 1;
		}
		txtNumMatricula.setText(Matricula.contador + "");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdicionar) actionPerformedBtnAdicionar(e);
		if (e.getSource() == btnConsultar) actionPerformedBtnConsultar(e);
		if (e.getSource() == btnEliminar) actionPerformedBtnEliminar(e);
//		if (e.getSource() == btnModificar) limpiarCampos();
	}

	protected void actionPerformedBtnAdicionar(ActionEvent e) {
		int codAlum = Integer.valueOf(cboCodAlum.getSelectedItem() + "");
		int codCurso = Integer.valueOf(cboCodCurso.getSelectedItem() + "");
		
//		if (!FrmMenu.listaMatriculas.stream()
//			.map(m -> m.getCodAlumno())
//			.filter(c -> c == codAlum)
//			.toList().isEmpty()) {
//			Mensaje.dialog(this, "El alumno ya se encuentra matriculado");
//			return;
//		}
		if (FrmMenu.arrAlumnos.buscarAlumnoPorCodigo(codAlum).getEstado() == 2) {
			Mensaje.dialog(this, "El alumno esta retirado");
			return;
		}
		if (FrmMenu.arrAlumnos.buscarAlumnoPorCodigo(codAlum).getEstado() == 1) {
			Mensaje.dialog(this, "El alumno ya se encuentra Matriculado");
			return;
		}
		
		FrmMenu.arrAlumnos.buscarAlumnoPorCodigo(codAlum).setEstado(1);
		
		Matricula nueva = new Matricula(Matricula.contador, codAlum, codCurso);
		FrmMenu.listaMatriculas.add(nueva);

		tmodel.addRow(new Object[]{Matricula.contador, codAlum, codCurso, nueva.getFecha(), nueva.getHora()});
		
		Matricula.contador++;
		txtNumMatricula.setText(Matricula.contador + "");
		Mensaje.dialog(this, "Matrícula registrada correctamente");
	}

	protected void actionPerformedBtnConsultar(ActionEvent e) {
		if (FrmMenu.listaMatriculas.isEmpty()) {
			Mensaje.dialog(this, "No hay matrículas registradas");
			return;
		}

		JComboBox<Integer> cbo = new JComboBox<>();
		for (Matricula m : FrmMenu.listaMatriculas) {
			cbo.addItem(m.getNumMatricula());
		}

		int res = JOptionPane.showConfirmDialog(this, cbo, "Selecciona una matrícula", JOptionPane.OK_CANCEL_OPTION);
		if (res != JOptionPane.OK_OPTION) return;

		int numSeleccionado = (int) cbo.getSelectedItem();
		for (Matricula m : FrmMenu.listaMatriculas) {
			if (m.getNumMatricula() == numSeleccionado) {
				Mensaje.dialog(this,
					"N° Matrícula: " + m.getNumMatricula() +
					"\nCódigo Alumno: " + m.getCodAlumno() +
					"\nCódigo Curso: " + m.getCodCurso() +
					"\nFecha: " + m.getFecha() +
					"\nHora: " + m.getHora());
				return;
			}
		}
	}

	protected void actionPerformedBtnEliminar(ActionEvent e) {
		int rowIndex = tblMatriculas.getSelectedRow();
		if (rowIndex == -1) {
			Mensaje.dialog(this, "Primero selecciona una matrícula de la tabla");
			return;
		}
		int num = Integer.valueOf(tmodel.getValueAt(rowIndex, 0) + "");
		int codAlumn = Integer.valueOf(tmodel.getValueAt(rowIndex, 1) + "");
		if (FrmMenu.arrAlumnos.buscarAlumnoPorCodigo(codAlumn).getEstado() == 2) {
			Mensaje.dialog(this, "No se puede eliminar el alumno está retirado");
			return;
		}

		if (Mensaje.confirmar(this, "¿Eliminar esta matrícula?")) {
			FrmMenu.listaMatriculas.removeIf(m -> m.getNumMatricula() == num);
			FrmMenu.arrAlumnos.buscarAlumnoPorCodigo(codAlumn).setEstado(0);
			tmodel.removeRow(rowIndex);
			limpiarCampos();
		}
	}

	private void limpiarCampos() {
		txtNumMatricula.setText(Matricula.contador + "");

	}
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == btnModificar) {
			itemStateChangedBtnModificar(e);
		}
	}
	protected void itemStateChangedBtnModificar(ItemEvent e) {
		System.out.println("hola");
		int rowIndex = tblMatriculas.getSelectedRow();
		
		if (rowIndex == -1) {
			Mensaje.dialog(this, "Primero selecciona un alumno de la tabla");
			btnModificar.setSelected(false);
			return;
		}
		if (btnModificar.isSelected()) {
			txtNumMatricula.setEnabled(false);
			cboCodAlum.setEnabled(false);
			cboCodAlum.setEnabled(false);
			txtNumMatricula.setText(tblMatriculas.getValueAt(rowIndex, 0) + "");
			cboCodAlum.setSelectedItem(tblMatriculas.getValueAt(rowIndex, 1) + "");
			cboCodCurso.setSelectedItem(tblMatriculas.getValueAt(rowIndex, 2) + "");	
		} else {
			System.out.println(txtNumMatricula.getText());
			int codNM = Integer.valueOf(txtNumMatricula.getText());
			int codAlum = Integer.valueOf(cboCodAlum.getSelectedItem() + "");
			int codCurso = Integer.valueOf(cboCodCurso.getSelectedItem() + "");
			
			FrmMenu.listaMatriculas.set(rowIndex, new Matricula(codNM, codAlum, codCurso));
			mostrarEnTabla();
			
			txtNumMatricula.setText(Matricula.contador + "");
			txtNumMatricula.setEnabled(true);
			cboCodAlum.setEnabled(true);
			cboCodAlum.setEnabled(true);
			
//					
		}
	}
	private void mostrarEnTabla() {
		tmodel.setRowCount(0);
		FrmMenu.listaMatriculas.forEach(m -> {
			tmodel.addRow(new Object[] {
					m.getNumMatricula(),
					m.getCodAlumno(),
					m.getCodCurso(),
					m.getFecha(),
					m.getHora()
			});
		});
	}
}