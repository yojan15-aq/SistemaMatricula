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
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class FrmRetiro extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNumRetiro;
	private JTextField txtNumRetiro;
	private JLabel lblNumMatricula;
	private JTextField txtNumMatricula;
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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNumRetiro = new JLabel("Número de retiro");
		lblNumRetiro.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNumRetiro.setBounds(10, 0, 189, 37);
		contentPane.add(lblNumRetiro);

		txtNumRetiro = new JTextField();
		txtNumRetiro.setEditable(false);
		txtNumRetiro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNumRetiro.setBounds(10, 32, 189, 27);
		contentPane.add(txtNumRetiro);
		txtNumRetiro.setColumns(10);

		lblNumMatricula = new JLabel("Numero de matrícula");
		lblNumMatricula.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNumMatricula.setBounds(10, 60, 189, 27);
		contentPane.add(lblNumMatricula);

		txtNumMatricula = new JTextField();
		txtNumMatricula.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNumMatricula.setColumns(10);
		txtNumMatricula.setBounds(10, 88, 189, 27);
		contentPane.add(txtNumMatricula);

		lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFecha.setBounds(10, 113, 189, 27);
		contentPane.add(lblFecha);

		txtCreditos = new JTextField();
		txtCreditos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCreditos.setColumns(10);
		txtCreditos.setBounds(10, 137, 189, 27);
		contentPane.add(txtCreditos);

		lblHora = new JLabel("Hora");
		lblHora.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHora.setBounds(10, 164, 189, 27);
		contentPane.add(lblHora);

		txtHora = new JTextField();
		txtHora.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtHora.setColumns(10);
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
		String fecha = txtCreditos.getText().trim();
		String hora = txtHora.getText().trim();

		if (numMatricula.isEmpty() || fecha.isEmpty() || hora.isEmpty()) {
			Mensaje.dialog(this, "Complete todos los campos");
			return;
		}

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

		JComboBox cbo = new JComboBox();
		for (String[] r : listaRetiros) {
			cbo.addItem(r[0]);
		}

		int res = JOptionPane.showConfirmDialog(
				this,
				cbo,
				"Selecciona un retiro",
				JOptionPane.OK_CANCEL_OPTION);

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
		int rowIndex = tblAlumnos.getSelectedRow();
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
		txtCreditos.setText("");
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
