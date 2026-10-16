package arreglos;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import clases.Alumno;
import clases.Curso;

public class ArrayAlumnos {
	private List<Alumno> alumnos = new ArrayList<>();
	public ArrayAlumnos() {
		
	}
	public void agregarAlumno(Alumno alumno) {
		alumnos.add(alumno);
	}
	public int cantidadAlumnos() {
		return alumnos.size();
	}
	public Alumno obtenerAlumno(int index) {
//		alumnos.get
		return alumnos.get(index);
	}
	public Alumno buscarAlumnoPorCodigo(int codAlumno) {
		for (Alumno alumno : alumnos) {
			if (alumno.getCodAlumno() == codAlumno) {
				return alumno;
			}
		}
		return null; // no se encuentra el alumno
	}
	
	public boolean verificarDniRepetido(String dni) {
		for (Alumno alumno : alumnos) {
			if (alumno.getDni().equals(dni)) {
				return true; // repetido
			}
		}
		return false; // no repetido
	}
	public void removerAlumno(int codigo) {
		alumnos.removeIf(alumno -> alumno.getCodAlumno() == codigo);
	
	}
	public void actualizar(Alumno alumno) {
		alumnos.set(
				alumnos.indexOf(buscarAlumnoPorCodigo(alumno.getCodAlumno())),
				alumno
				);
		
	}
	public String EstadoToText(int i) {
		switch (i) {
			case 0: return "Registrado";
			case 1: return "Matriculado";
			default: return "Retirado";
		}
	}
	public int TextToEstado(String ciclo) {
		switch (ciclo) {
			case "Registrado": return 0;
			case "Matriculado": return 1;
			default: return 2;
		}
	}
	public void mostrarEnTabla(DefaultTableModel t) {
		t.setRowCount(0);
		alumnos.forEach(a -> {
			t.addRow(new Object[] {
				a.getCodAlumno(),
				a.getNombres(),
				a.getApellidos(),
				a.getDni(),
				a.getEdad(),
				a.getCelular(),
				EstadoToText(a.getEstado()),
			});
		});
	}
	public String[] getArrayCodAlumnos() {
		String[] alumnos = new String[this.alumnos.size()];
		
		for (int i=0; i < this.alumnos.size(); i++) {
			alumnos[i] = this.alumnos.stream().map(a -> a.getCodAlumno()).toArray()[i] + "";
		}
		
		return alumnos;
	}
}
