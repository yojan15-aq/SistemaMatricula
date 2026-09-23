package gui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class FrmReporte extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea txtListado;
	private JButton btnPendiente;
	private JButton btnVigente;
	private JButton btnPorCurso;
	private JButton btnRetirados;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmReporte frame = new FrmReporte();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmReporte() {
		setTitle("Reportes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 760, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnPendiente = new JButton("Alumnos con matrícula pendiente");
		btnPendiente.setBounds(20, 20, 280, 40);
		contentPane.add(btnPendiente);

		btnVigente = new JButton("Alumnos con matrícula vigente");
		btnVigente.setBounds(20, 75, 280, 40);
		contentPane.add(btnVigente);

		btnPorCurso = new JButton("Alumnos matriculados por curso");
		btnPorCurso.setBounds(20, 130, 280, 40);
		contentPane.add(btnPorCurso);

		btnRetirados = new JButton("Alumnos retirados");
		btnRetirados.setBounds(20, 185, 280, 40);
		contentPane.add(btnRetirados);

		JLabel lblListado = new JLabel("Listado");
		lblListado.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblListado.setBounds(330, 20, 120, 25);
		contentPane.add(lblListado);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(330, 50, 390, 320);
		contentPane.add(scrollPane);

		txtListado = new JTextArea();
		txtListado.setEditable(false);
		txtListado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		scrollPane.setViewportView(txtListado);
	}
}
