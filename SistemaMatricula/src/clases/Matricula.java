package clases;

import java.time.LocalDateTime;

public class Matricula {

	//ATRIBUTOS
	private int numMatricula;
	private int codAlumno;
	private int codCurso;
	private String fecha;
	private  String hora;
	public static int contador = 2001;
	
	//CONSTRUCTOR
	public Matricula(int numMatricula, int codAlumno, int codCurso, String fecha, String hora) {
		this(numMatricula, codAlumno, codCurso);
		this.fecha = fecha;
		this.hora = hora;
	}
	public Matricula(int numMatricula, int codAlumno, int codCurso) {
		this.numMatricula = numMatricula;
		this.codAlumno = codAlumno;
		this.codCurso = codCurso;
		this.fecha = String.join("/",
				LocalDateTime.now().getDayOfMonth() + "",
				LocalDateTime.now().getMonthValue() + "",
				LocalDateTime.now().getYear() + ""
				);
		this.hora = String.join(":",
				LocalDateTime.now().getHour() + "",
				LocalDateTime.now().getMinute() + ""
				);
	}
	
	//GET Y SET

	public int getNumMatricula() {
		return numMatricula;
	}

	public void setNumMatricula(int numMatricula) {
		this.numMatricula = numMatricula;
	}

	public int getCodAlumno() {
		return codAlumno;
	}

	public void setCodAlumno(int codAlumno) {
		this.codAlumno = codAlumno;
	}

	public int getCodCurso() {
		return codCurso;
	}

	public void setCodCurso(int codCurso) {
		this.codCurso = codCurso;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}
	
	
	
}
