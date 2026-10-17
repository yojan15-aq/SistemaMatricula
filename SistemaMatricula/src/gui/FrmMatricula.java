package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import Utils.Mensaje;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

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
	private JTextField txtCreditos;
	private JLabel lblHora;
	private JTextField txtHora;
	private JTable tblAlumnos;
	private JButton btnAdicionar;
	private JButton btnConsultar;
	private JButton btnEliminar;
	private JButton btnLimpiar;
	private DefaultTableModel tmodel;

	private List<String[]> listaMatriculas = new ArrayList<>();
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

		tmodel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tmodel.setColumnIdentifiers(new String[] {"N° matrícula", "Código alumno", "Código curso", "Fecha", "Hora"});
		tblAlumnos = new JTable(tmodel);
		scrollPane.setViewportView(tblAlumnos);

		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(20, 400, 130, 30);
		btnAdicionar.addActionListener(this);
		contentPane.add(btnAdicionar);

		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(160, 400, 130, 30);
		btnConsultar.addActionListener(this);
		contentPane.add(btnConsultar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(300, 400, 130, 30);
		btnEliminar.addActionListener(this);
		contentPane.add(btnEliminar);

		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(440, 400, 130, 30);
		btnLimpiar.addActionListener(this);
		contentPane.add(btnLimpiar);

		txtNumMatricula.setText(contador + "");
		generarMatriculasPrueba();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdicionar) actionPerformedBtnAdicionar(e);
		if (e.getSource() == btnConsultar) actionPerformedBtnConsultar(e);
		if (e.getSource() == btnEliminar) actionPerformedBtnEliminar(e);
		if (e.getSource() == btnLimpiar) limpiarCampos();
	}

	protected void actionPerformedBtnAdicionar(ActionEvent e) {
		String codAlum = txtCodAlum.getText().trim();
		String codCurso = txtCodCurso.getText().trim();
		String fecha = txtCreditos.getText().trim();
		String hora = txtHora.getText().trim();

		if (codAlum.isEmpty() || codCurso.isEmpty() || fecha.isEmpty() || hora.isEmpty()) {
			Mensaje.dialog(this, "Complete todos los campos");
			return;
		}

		String num = contador + "";
		listaMatriculas.add(new String[]{num, codAlum, codCurso, fecha, hora});
		tmodel.addRow(new Object[]{num, codAlum, codCurso, fecha, hora});

		contador++;
		limpiarCampos();
		Mensaje.dialog(this, "Matrícula registrada correctamente");
	}

	protected void actionPerformedBtnConsultar(ActionEvent e) {
	    if (listaMatriculas.isEmpty()) {
	        Mensaje.dialog(this, "No hay matrículas registradas");
	        return;
	    }

	    // Crear combo con los números de matrícula
	    JComboBox cbo = new JComboBox();
	    for (String[] m : listaMatriculas) {
	        cbo.addItem(m[0]); // número de matrícula
	    }

	    int res = JOptionPane.showConfirmDialog(
	            this,
	            cbo,
	            "Selecciona una matrícula",
	            JOptionPane.OK_CANCEL_OPTION);

	    if (res != JOptionPane.OK_OPTION) return;

	    String numSeleccionado = cbo.getSelectedItem().toString();

	    // Buscar la matrícula
	    for (String[] m : listaMatriculas) {
	        if (m[0].equals(numSeleccionado)) {
	            Mensaje.dialog(this,
	                "N° Matrícula: " + m[0] +
	                "\nCódigo Alumno: " + m[1] +
	                "\nCódigo Curso: " + m[2] +
	                "\nFecha: " + m[3] +
	                "\nHora: " + m[4]);
	            return;
	        }
	    }
	}

	protected void actionPerformedBtnEliminar(ActionEvent e) {
		int rowIndex = tblAlumnos.getSelectedRow();
		if (rowIndex == -1) {
			Mensaje.dialog(this, "Primero selecciona una matrícula de la tabla");
			return;
		}

		if (Mensaje.confirmar(this, "¿Eliminar esta matrícula?")) {
			listaMatriculas.remove(rowIndex);
			tmodel.removeRow(rowIndex);
			limpiarCampos();
		}
	}

	private void limpiarCampos() {
		txtNumMatricula.setText(contador + "");
		txtCodAlum.setText("");
		txtCodCurso.setText("");
		txtCreditos.setText("");
		txtHora.setText("");
	}

	private void generarMatriculasPrueba() {
		listaMatriculas.add(new String[]{"1001", "202610001", "1001", "15/10/2026", "08:00"});
		listaMatriculas.add(new String[]{"1002", "202610002", "1020", "15/10/2026", "10:00"});
		listaMatriculas.add(new String[]{"1003", "202610003", "1030", "16/10/2026", "14:00"});

		for (String[] m : listaMatriculas) {
			tmodel.addRow(m);
		}
		contador = 1004;
		txtNumMatricula.setText(contador + "");
	}
}