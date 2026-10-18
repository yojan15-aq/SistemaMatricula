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
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;

public class FrmRetiro extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNumRetiro;
	private JTextField txtNumRetiro;
	private JLabel lblNumMatricula;
	private JTextField txtNumMatricula;
	private JLabel lblFecha;
	private JTextField txtFecha;
	private JLabel lblHora;
	private JTextField txtHora;
	private JTable tblRetiros;
	private JButton btnAdicionar;
	private JButton btnConsultar;
	private JButton btnEliminar;
	private JButton btnLimpiar;
	private DefaultTableModel tmodel;

	private List<String[]> listaRetiros = new ArrayList<>();
	private int contador = 2001;

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

		txtNumMatricula = new JTextField();
		txtNumMatricula.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtNumMatricula.setBackground(new Color(55, 55, 60));
		txtNumMatricula.setForeground(Color.WHITE);
		txtNumMatricula.setCaretColor(Color.WHITE);
		txtNumMatricula.setBorder(BorderFactory.createLineBorder(new Color(80, 80, 85)));
		txtNumMatricula.setBounds(10, 88, 189, 27);
		contentPane.add(txtNumMatricula);

		lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblFecha.setForeground(Color.WHITE);
		lblFecha.setBounds(10, 113, 189, 27);
		contentPane.add(lblFecha);

		txtFecha = new JTextField();
		txtFecha.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtFecha.setBackground(new Color(55, 55, 60));
		txtFecha.setForeground(Color.WHITE);
		txtFecha.setCaretColor(Color.WHITE);
		txtFecha.setBorder(BorderFactory.createLineBorder(new Color(80, 80, 85)));
		txtFecha.setBounds(10, 137, 189, 27);
		contentPane.add(txtFecha);

		lblHora = new JLabel("Hora");
		lblHora.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblHora.setForeground(Color.WHITE);
		lblHora.setBounds(10, 164, 189, 27);
		contentPane.add(lblHora);

		txtHora = new JTextField();
		txtHora.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtHora.setBackground(new Color(55, 55, 60));
		txtHora.setForeground(Color.WHITE);
		txtHora.setCaretColor(Color.WHITE);
		txtHora.setBorder(BorderFactory.createLineBorder(new Color(80, 80, 85)));
		txtHora.setBounds(10, 187, 189, 27);
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

		txtNumRetiro.setText(contador + "");
		generarRetirosPrueba();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdicionar) actionPerformedBtnAdicionar(e);
		if (e.getSource() == btnConsultar) actionPerformedBtnConsultar(e);
		if (e.getSource() == btnEliminar) actionPerformedBtnEliminar(e);
		if (e.getSource() == btnLimpiar) limpiarCampos();
	}

	protected void actionPerformedBtnAdicionar(ActionEvent e) {
		String numMatricula = txtNumMatricula.getText().trim();
		String fecha = txtFecha.getText().trim();
		String hora = txtHora.getText().trim();

		if (numMatricula.isEmpty() || fecha.isEmpty() || hora.isEmpty()) {
			Mensaje.dialog(this, "Complete todos los campos");
			return;
		}

		// Verificar que la matrícula exista en FrmMenu
		boolean existeMatricula = false;
		for (Matricula m : FrmMenu.listaMatriculas) {
			if (String.valueOf(m.getNumMatricula()).equals(numMatricula)) {
				existeMatricula = true;
				break;
			}
		}

		if (!existeMatricula) {
			Mensaje.dialog(this, "El número de matrícula no existe");
			return;
		}

		// Registrar el retiro
		String num = contador + "";
		listaRetiros.add(new String[]{num, numMatricula, fecha, hora});
		tmodel.addRow(new Object[]{num, numMatricula, fecha, hora});

		contador++;
		limpiarCampos();
		Mensaje.dialog(this, "Retiro registrado correctamente");
	}

	protected void actionPerformedBtnConsultar(ActionEvent e) {
		if (listaRetiros.isEmpty()) {
			Mensaje.dialog(this, "No hay retiros registrados");
			return;
		}

		JComboBox<String> cbo = new JComboBox<>();
		for (String[] r : listaRetiros) {
			cbo.addItem(r[0]);
		}

		int res = JOptionPane.showConfirmDialog(this, cbo, "Selecciona un retiro", JOptionPane.OK_CANCEL_OPTION);
		if (res != JOptionPane.OK_OPTION) return;

		String numSeleccionado = cbo.getSelectedItem().toString();
		for (String[] r : listaRetiros) {
			if (r[0].equals(numSeleccionado)) {
				Mensaje.dialog(this,
					"N° Retiro: " + r[0] +
					"\nN° Matrícula: " + r[1] +
					"\nFecha: " + r[2] +
					"\nHora: " + r[3]);
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
			listaRetiros.remove(rowIndex);
			tmodel.removeRow(rowIndex);
			limpiarCampos();
		}
	}

	private void limpiarCampos() {
		txtNumRetiro.setText(contador + "");
		txtNumMatricula.setText("");
		txtFecha.setText("");
		txtHora.setText("");
	}

	private void generarRetirosPrueba() {
		listaRetiros.add(new String[]{"2001", "1001", "16/10/2026", "09:00"});
		listaRetiros.add(new String[]{"2002", "1002", "17/10/2026", "11:30"});
		listaRetiros.add(new String[]{"2003", "1003", "18/10/2026", "15:00"});

		for (String[] r : listaRetiros) {
			tmodel.addRow(r);
		}
		contador = 2004;
		txtNumRetiro.setText(contador + "");
	}
}