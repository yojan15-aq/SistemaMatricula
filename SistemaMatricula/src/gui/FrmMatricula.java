package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import Utils.Mensaje;
import clases.Alumno;
import clases.Matricula;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
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
	private JTable tblAlumnos;
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

		cboCodAlum = new JComboBox();
		cboCodAlum.setModel(new DefaultComboBoxModel(FrmMenu.arrAlumnos.getArrayCodAlumnos()));
		
		cboCodAlum.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboCodAlum.setBounds(10, 88, 189, 27);
		contentPane.add(cboCodAlum);

		cboCodCurso = new JComboBox();
		cboCodCurso.setModel(new DefaultComboBoxModel(FrmMenu.arrCursos.getArrayCodCursos()));
		cboCodCurso.setFont(new Font("Tahoma", Font.PLAIN, 12));
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

		btnModificar = new JToggleButton("Modificar");
		btnModificar.addItemListener(this);
		btnModificar.setBounds(440, 400, 130, 30);
		contentPane.add(btnModificar);

		txtNumMatricula.setText(Matricula.contadorMatricula + "");
		for (Matricula m : FrmMenu.listaMatriculas) {
			tmodel.addRow(new Object[] {
					m.getNumMatricula(),
					m.getCodAlumno(),
					m.getCodCurso(),
					m.getFecha(),
					m.getHora()
				});
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdicionar) actionPerformedBtnAdicionar(e);
		if (e.getSource() == btnConsultar) actionPerformedBtnConsultar(e);
		if (e.getSource() == btnEliminar) actionPerformedBtnEliminar(e);

	}

	protected void actionPerformedBtnAdicionar(ActionEvent e) {
		int codAlum = Integer.valueOf(cboCodAlum.getSelectedItem() + "");
		int codCurso = Integer.valueOf(cboCodCurso.getSelectedItem() + "");
//		String fecha = txtCreditos.getText().trim();
//		String hora = txtHora.getText().trim();

//		if (codAlum.isEmpty() || codCurso.isEmpty()) {
//			Mensaje.dialog(this, "Complete todos los campos");
//			return;
//		}
//		if (!codAlum.matches("\\d+") || !codCurso.matches("\\d+")) {
//			Mensaje.dialog(this, "Los códigos deben ser numéricos");
//			return;
//		}

		String num = Matricula.contadorMatricula + "";
		Matricula matricula = new Matricula(Integer.valueOf(num), codAlum, codCurso);
		FrmMenu.listaMatriculas.add(matricula);
		tmodel.addRow(new Object[] {
				matricula.getNumMatricula(),
				matricula.getCodAlumno(),
				matricula.getCodCurso(),
				matricula.getFecha(),
				matricula.getHora()
			});

		Matricula.contadorMatricula++;
		limpiarCampos();
		txtNumMatricula.setText(Matricula.contadorMatricula + "");
		Mensaje.dialog(this, "Matrícula registrada correctamente");
	}

	protected void actionPerformedBtnConsultar(ActionEvent e) {
	    if (FrmMenu.listaMatriculas.isEmpty()) {
	        Mensaje.dialog(this, "No hay matrículas registradas");
	        return;
	    }

	    // Crear combo con los números de matrícula
	    JComboBox cbo = new JComboBox();
	    FrmMenu.listaMatriculas.forEach(m -> cbo.addItem(m.getNumMatricula()));
//	    for (Matricula m : listaMatriculas) {
//	        cbo.addItem(m.getNumMatricula()); // número de matrícula
//	    }

	    int res = JOptionPane.showConfirmDialog(
	            this,
	            cbo,
	            "Selecciona una matrícula",
	            JOptionPane.OK_CANCEL_OPTION);

	    if (res != JOptionPane.OK_OPTION) return;

//	    String numSeleccionado = cbo.getSelectedItem().toString();
	    int numSeleccionado = (int) cbo.getSelectedItem();

	    // Buscar la matrícula
//	    listaMatriculas
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
		int rowIndex = tblAlumnos.getSelectedRow();
		if (rowIndex == -1) {
			Mensaje.dialog(this, "Primero selecciona una matrícula de la tabla");
			return;
		}

		if (Mensaje.confirmar(this, "¿Eliminar esta matrícula?")) {
			FrmMenu.listaMatriculas.remove(rowIndex);
			tmodel.removeRow(rowIndex);
			limpiarCampos();
		}
	}

	private void limpiarCampos() {

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
			txtNumMatricula.setEnabled(false);
//			txtDni.setEnabled(false);
			cboCodAlum.setEditable(false);
			cboCodAlum.setEnabled(false);
			txtNumMatricula.setText(tblAlumnos.getValueAt(rowIndex, 0) + "");
			cboCodAlum.setSelectedItem(tblAlumnos.getValueAt(rowIndex, 1) + "");
			cboCodCurso.setSelectedItem(tblAlumnos.getValueAt(rowIndex, 2) + "");
//			txtApellidos.setText(tblAlumnos.getValueAt(rowIndex, 2) + "");
//			txtDni.setText(tblAlumnos.getValueAt(rowIndex, 3) + "");
//			txtEdad.setText(tblAlumnos.getValueAt(rowIndex, 4) + "");
//			txtCelular.setText(tblAlumnos.getValueAt(rowIndex, 5) + "");
////			txtEstado.setText(tblAlumnos.getValueAt(rowIndex, 6) + "");
//			cboEstado.setSelectedIndex(
//					FrmMenu.arrAlumnos.TextToEstado(tblAlumnos.getValueAt(rowIndex, 6) + "")
//					);
			
		} else {
//			// actualizar num matricula
			System.out.println(txtNumMatricula.getText());
			int codNM = Integer.valueOf(txtNumMatricula.getText());
			int codAlum = Integer.valueOf(cboCodAlum.getSelectedItem() + "");
			int codCurso = Integer.valueOf(cboCodCurso.getSelectedItem() + "");
			
			FrmMenu.listaMatriculas.set(rowIndex, new Matricula(codNM, codAlum, codCurso));
			
			txtNumMatricula.setText(Matricula.contadorMatricula + "");
			
//			txtCodAlumno.setEnabled(true);
//			txtDni.setEnabled(true);
//			cboEstado.setEnabled(false);
//			cboEstado.setEditable(false);
//			FrmMenu.arrAlumnos.mostrarEnTabla(tmodel);
//			limpiarCampos(false);		
		}
		
//		cboCodAlum.setText("");
//		cboCodCurso.setText("");
	}
}