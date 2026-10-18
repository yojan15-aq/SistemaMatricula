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

public class FrmMatricula extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNumMatricula;
	private JTextField txtNumMatricula;
	private JLabel lblCodAlum;
	private JTextField txtCodAlum;
	private JLabel lblCodCurso;
	private JTextField txtCodCurso;
	private JLabel lblFecha;
	private JTextField txtFecha;
	private JLabel lblHora;
	private JTextField txtHora;
	private JTable tblMatriculas;
	private JButton btnAdicionar;
	private JButton btnConsultar;
	private JButton btnEliminar;
	private JButton btnLimpiar;
	private DefaultTableModel tmodel;

	private int contador = 1001;

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

		txtCodAlum = new JTextField();
		txtCodAlum.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtCodAlum.setBackground(new Color(55, 55, 60));
		txtCodAlum.setForeground(Color.WHITE);
		txtCodAlum.setCaretColor(Color.WHITE);
		txtCodAlum.setBorder(BorderFactory.createLineBorder(new Color(80, 80, 85)));
		txtCodAlum.setBounds(10, 88, 189, 27);
		contentPane.add(txtCodAlum);

		lblCodCurso = new JLabel("Código curso");
		lblCodCurso.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblCodCurso.setForeground(Color.WHITE);
		lblCodCurso.setBounds(10, 115, 189, 27);
		contentPane.add(lblCodCurso);

		txtCodCurso = new JTextField();
		txtCodCurso.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtCodCurso.setBackground(new Color(55, 55, 60));
		txtCodCurso.setForeground(Color.WHITE);
		txtCodCurso.setCaretColor(Color.WHITE);
		txtCodCurso.setBorder(BorderFactory.createLineBorder(new Color(80, 80, 85)));
		txtCodCurso.setBounds(10, 139, 189, 27);
		contentPane.add(txtCodCurso);

		lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblFecha.setForeground(Color.WHITE);
		lblFecha.setBounds(10, 165, 189, 27);
		contentPane.add(lblFecha);

		txtFecha = new JTextField();
		txtFecha.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtFecha.setBackground(new Color(55, 55, 60));
		txtFecha.setForeground(Color.WHITE);
		txtFecha.setCaretColor(Color.WHITE);
		txtFecha.setBorder(BorderFactory.createLineBorder(new Color(80, 80, 85)));
		txtFecha.setBounds(10, 187, 189, 27);
		contentPane.add(txtFecha);

		lblHora = new JLabel("Hora");
		lblHora.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblHora.setForeground(Color.WHITE);
		lblHora.setBounds(10, 214, 189, 27);
		contentPane.add(lblHora);

		txtHora = new JTextField();
		txtHora.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtHora.setBackground(new Color(55, 55, 60));
		txtHora.setForeground(Color.WHITE);
		txtHora.setCaretColor(Color.WHITE);
		txtHora.setBorder(BorderFactory.createLineBorder(new Color(80, 80, 85)));
		txtHora.setBounds(10, 238, 189, 27);
		contentPane.add(txtHora);

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

		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBackground(new Color(96, 125, 139));
		btnLimpiar.setForeground(Color.WHITE);
		btnLimpiar.setFocusPainted(false);
		btnLimpiar.setBorderPainted(false);
		btnLimpiar.addActionListener(this);
		btnLimpiar.setBounds(440, 400, 130, 32);
		contentPane.add(btnLimpiar);

		txtNumMatricula.setText(contador + "");
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
			contador = FrmMenu.listaMatriculas.get(FrmMenu.listaMatriculas.size() - 1).getNumMatricula() + 1;
		}
		txtNumMatricula.setText(contador + "");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdicionar) actionPerformedBtnAdicionar(e);
		if (e.getSource() == btnConsultar) actionPerformedBtnConsultar(e);
		if (e.getSource() == btnEliminar) actionPerformedBtnEliminar(e);
		if (e.getSource() == btnLimpiar) limpiarCampos();
	}

	protected void actionPerformedBtnAdicionar(ActionEvent e) {
		String codAlumStr = txtCodAlum.getText().trim();
		String codCursoStr = txtCodCurso.getText().trim();
		String fecha = txtFecha.getText().trim();
		String hora = txtHora.getText().trim();

		if (codAlumStr.isEmpty() || codCursoStr.isEmpty() || fecha.isEmpty() || hora.isEmpty()) {
			Mensaje.dialog(this, "Complete todos los campos");
			return;
		}

		int codAlum, codCurso;
		try {
			codAlum = Integer.parseInt(codAlumStr);
			codCurso = Integer.parseInt(codCursoStr);
		} catch (Exception ex) {
			Mensaje.dialog(this, "Los códigos deben ser números");
			return;
		}

		if (FrmMenu.arrAlumnos.buscarAlumnoPorCodigo(codAlum) == null) {
			Mensaje.dialog(this, "El código de alumno no existe");
			return;
		}

		if (FrmMenu.arrCursos.buscarCursoPorCodigo(codCurso) == null) {
			Mensaje.dialog(this, "El código de curso no existe");
			return;
		}

		Matricula nueva = new Matricula(contador, codAlum, codCurso, fecha, hora);
		FrmMenu.listaMatriculas.add(nueva);

		tmodel.addRow(new Object[]{contador, codAlum, codCurso, fecha, hora});
		contador++;
		limpiarCampos();
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

		if (Mensaje.confirmar(this, "¿Eliminar esta matrícula?")) {
			int num = (int) tmodel.getValueAt(rowIndex, 0);
			FrmMenu.listaMatriculas.removeIf(m -> m.getNumMatricula() == num);
			tmodel.removeRow(rowIndex);
			limpiarCampos();
		}
	}

	private void limpiarCampos() {
		txtNumMatricula.setText(contador + "");
		txtCodAlum.setText("");
		txtCodCurso.setText("");
		txtFecha.setText("");
		txtHora.setText("");
	}
}