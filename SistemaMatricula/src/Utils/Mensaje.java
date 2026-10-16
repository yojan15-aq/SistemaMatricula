package Utils;

import java.awt.Component;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class Mensaje {
	public static void dialog(Component c, String mensaje) {
		JOptionPane.showMessageDialog(c, mensaje);
	}
	public static boolean confirmar(Component c, String mensaje) {
		int respuesta = JOptionPane.showConfirmDialog(c, mensaje);
		
		// 0 si, 1 no, 2 cancelar
		return respuesta == JOptionPane.YES_OPTION;
	}
	public static void alerta(Component c, String mensaje, String titulo) {
		JOptionPane.showMessageDialog(c, mensaje, titulo, JOptionPane.WARNING_MESSAGE);
	}
	public static int consultarAlumno(Component c, JComboBox cbo) {
		 int res = JOptionPane.showConfirmDialog(
				c,
				cbo,
				"Selecciona un alumno",
				JOptionPane.OK_CANCEL_OPTION);
		System.out.println(res);
		System.out.println(cbo.getSelectedItem());
		if (res == JOptionPane.OK_OPTION) {
			return Integer.parseInt(cbo.getSelectedItem() + "");
		}
		return -1;
	}
}
