package arreglos;

import java.util.ArrayList;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import clases.Curso;

public class ArrayCursos {
	private List<Curso> cursos = new ArrayList<>();
	public void agregarCurso(Curso curso) {
		cursos.add(curso);
	}
	public int cantidadCurso() {
		return cursos.size();
	}
	public Curso obtenerCurso(int index) {
		return cursos.get(index);
	}
	public Curso buscarCursoPorCodigo(int codCurso) {
		for (Curso curso: cursos) {
			if (curso.getCodCurso() == codCurso) {
				return curso;
			}
		}
		return null; // no se encuentra el curso
	}
	public boolean verificarCodigoRepetido(int codigo) {
		for (Curso curso : cursos) {
			if (curso.getCodCurso() == codigo) {
				return true; // repetido
			}
		}
		return false; // no repetido
	}
	public void removerCurso(int codigo) {
		cursos.removeIf(curso -> curso.getCodCurso() == codigo);
	}
	public void actualizar(Curso curso) {
		cursos.set(
				cursos.indexOf(buscarCursoPorCodigo(curso.getCodCurso())),
				curso
				);
		
	}
	public String cicloToText(int i) {
		switch (i) {
			case 0: return "Primero";
			case 1: return "Segundo";
			case 2: return "Tercero";
			case 3: return "Cuarto";
			case 4: return "Quinto";
			default: return "Sexto";
		}
	}
	public int TextToCiclo(String ciclo) {
		switch (ciclo) {
			case "Primero": return 0;
			case "Segundo": return 1;
			case "Tercero": return 2;
			case "Cuarto": return 3;
			case "Quinto": return 4;
			default: return 5;
		}
	}
	public void mostrarEnTabla(DefaultTableModel t) {
//		t.s
		t.setRowCount(0);
		cursos.stream()
			.map(c -> c.getCodCurso())
			.sorted()
			.forEach(c -> {
				Curso cur = buscarCursoPorCodigo(c);
				t.addRow(new Object[] {
					cur.getCodCurso(),
					cur.getAsignatura(),
					cicloToText(cur.getCiclo()),
					cur.getCreditos(),
					cur.getHoras(),
				});
			});

	}
	public String[] getArrayCodCursos() {
		String[] cursos = new String[this.cursos.size()];
		
		
		for (int i=0; i < this.cursos.size(); i++) {
			cursos[i] = this.cursos.stream().map(a -> a.getCodCurso()).toArray()[i] + "";
		}
		
		return cursos;
	}

}
