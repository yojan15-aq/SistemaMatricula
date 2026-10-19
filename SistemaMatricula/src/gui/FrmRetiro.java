package gui;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import Utils.Mensaje;
import clases.Matricula;
import clases.Retiro;

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
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;

public class FrmRetiro extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNumRetiro;
	private JTextField txtNumRetiro;
	private JLabel lblNumMatricula;
	private JComboBox cboNumMatricula;
	private JTable tblRetiros;
	private JButton btnAdicionar;
	private JButton btnConsultar;
	private JButton btnEliminar;
	private JButton btnLimpiar;
	private DefaultTableModel tmodel;

//	private int contador = 2001;
	

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

	public FrmRetiro() {
		setTitle("Registro - Retiro");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 780, 480);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(40, 40, 45));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNumRetiro = new JLabel("Número de retiro");
		lblNumRetiro.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNumRetiro.setForeground(Color.WHITE);
		lblNumRetiro.setBounds(10, 0, 189, 37);
		contentPane.add(lblNumRetiro);

		txtNumRetiro = new JTextField();
		txtNumRetiro.setEditable(false);
		txtNumRetiro.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtNumRetiro.setBackground(new Color(55, 55, 60));
		txtNumRetiro.setForeground(Color.WHITE);
		txtNumRetiro.setCaretColor(Color.WHITE);
		txtNumRetiro.setBorder(BorderFactory.createLineBorder(new Color(80, 80, 85)));
		txtNumRetiro.setBounds(10, 32, 189, 27);
		contentPane.add(txtNumRetiro);

		lblNumMatricula = new JLabel("Número de matrícula");
		lblNumMatricula.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNumMatricula.setForeground(Color.WHITE);
		lblNumMatricula.setBounds(10, 60, 189, 27);
		contentPane.add(lblNumMatricula);

		cboNumMatricula = new JComboBox();
		cboNumMatricula.setModel(new DefaultComboBoxModel(
				FrmMenu.listaMatriculas.stream()
				.map(m -> m.getNumMatricula())
				.toArray()
				));
		cboNumMatricula.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		cboNumMatricula.setBackground(new Color(55, 55, 60));
		cboNumMatricula.setForeground(Color.WHITE);
		cboNumMatricula.setBorder(BorderFactory.createLineBorder(new Color(80, 80, 85)));
		cboNumMatricula.setBounds(10, 88, 189, 27);
		contentPane.add(cboNumMatricula);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(220, 20, 520, 340);
		contentPane.add(scrollPane);

		tmodel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tmodel.setColumnIdentifiers(new String[] {"N° retiro", "N° matrícula", "Fecha", "Hora"});
		tblRetiros = new JTable(tmodel);
		tblRetiros.setBackground(new Color(50, 50, 55));
		tblRetiros.setForeground(Color.WHITE);
		tblRetiros.setGridColor(new Color(70, 70, 75));
		tblRetiros.setSelectionBackground(new Color(33, 150, 243));
		tblRetiros.setSelectionForeground(Color.WHITE);
		tblRetiros.getTableHeader().setBackground(new Color(60, 60, 65));
		tblRetiros.getTableHeader().setForeground(Color.WHITE);
		scrollPane.setViewportView(tblRetiros);

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

		txtNumRetiro.setText(Retiro.contador + "");

		
		for (Retiro r : FrmMenu.listaRetiros) {
			tmodel.addRow(new Object[] {r.getNumRetiro(), r.getNumMatricula(), r.getFecha(), r.getHora()});
		}
//		Retiro.contador = 2004;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdicionar) actionPerformedBtnAdicionar(e);
		if (e.getSource() == btnConsultar) actionPerformedBtnConsultar(e);
		if (e.getSource() == btnEliminar) actionPerformedBtnEliminar(e);
		if (e.getSource() == btnLimpiar) limpiarCampos();
	}

	protected void actionPerformedBtnAdicionar(ActionEvent e) {
		int numMatricula = Integer.valueOf(cboNumMatricula.getSelectedItem() + "");

		// Registrar el retiro
		int num = Retiro.contador;
		
		Matricula matchMatricula = FrmMenu.listaMatriculas.stream()
			.filter(m -> m.getNumMatricula() == numMatricula)
			.findFirst()
			.orElse(null);
		
		if (matchMatricula == null) {
			Mensaje.dialog(this, "La matricula no existe");
			return;
		}
		if (FrmMenu.arrAlumnos.buscarAlumnoPorCodigo(matchMatricula.getCodAlumno()).getEstado() == 2) {
			Mensaje.dialog(this, "Ya esta retirado");
			return;
		}
		
		FrmMenu.arrAlumnos
			.buscarAlumnoPorCodigo(matchMatricula.getCodAlumno())
			.setEstado(2);
		
		Retiro r = new Retiro(num, numMatricula);
		FrmMenu.listaRetiros.add(r);
		tmodel.addRow(new Object[]{num, numMatricula, r.getFecha(), r.getHora()});

		Retiro.contador++;
		limpiarCampos();
		Mensaje.dialog(this, "Retiro registrado correctamente");
	}

	protected void actionPerformedBtnConsultar(ActionEvent e) {
		if (FrmMenu.listaRetiros.isEmpty()) {
			Mensaje.dialog(this, "No hay retiros registrados");
			return;
		}

		JComboBox<String> cbo = new JComboBox<>();
		for (Retiro r : FrmMenu.listaRetiros) {
			cbo.addItem(r.getNumRetiro() + "");
		}

		int res = JOptionPane.showConfirmDialog(this, cbo, "Selecciona un retiro", JOptionPane.OK_CANCEL_OPTION);
		if (res != JOptionPane.OK_OPTION) return;

		int numSeleccionado = Integer.valueOf(cbo.getSelectedItem() + "");
		for (Retiro r : FrmMenu.listaRetiros) {
			if (r.getNumRetiro() == numSeleccionado) {
				Mensaje.dialog(this,
					"N° Retiro: " + r.getNumRetiro() +
					"\nN° Matrícula: " + r.getNumMatricula() +
					"\nFecha: " + r.getFecha() +
					"\nHora: " + r.getHora());
				return;
			}
		}
	}

	protected void actionPerformedBtnEliminar(ActionEvent e) {
		int rowIndex = tblRetiros.getSelectedRow();
		if (rowIndex == -1) {
			Mensaje.dialog(this, "Primero selecciona un retiro de la tabla");
			return;
		}

		if (Mensaje.confirmar(this, "¿Eliminar este retiro?")) {
			FrmMenu.arrAlumnos
			.buscarAlumnoPorCodigo(FrmMenu.listaMatriculas.get(rowIndex).getCodAlumno())
			.setEstado(1);
			FrmMenu.listaRetiros.remove(rowIndex);
			
			
			
			tmodel.removeRow(rowIndex);
			limpiarCampos();
		}
	}

	private void limpiarCampos() {
		txtNumRetiro.setText(Retiro.contador + "");
	}

	
}