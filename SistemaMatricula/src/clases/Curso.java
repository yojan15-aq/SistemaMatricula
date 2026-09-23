package clases;

public class Curso {
	
	//atributos
private int codCurso;
private String asignatura;
private int ciclo;
private  int creditos;
private int  horas;

//CONSTRUCCTOR
public Curso(int codCurso, String asignatura, int ciclo, int creditos, int horas) {
	super();
	this.codCurso = codCurso;
	this.asignatura = asignatura;
	this.ciclo = ciclo;
	this.creditos = creditos;
	this.horas = horas;
}

//GET Y SET

public int getCodCurso() {
	return codCurso;
}

public void setCodCurso(int codCurso) {
	this.codCurso = codCurso;
}

public String getAsignatura() {
	return asignatura;
}

public void setAsignatura(String asignatura) {
	this.asignatura = asignatura;
}

public int getCiclo() {
	return ciclo;
}

public void setCiclo(int ciclo) {
	this.ciclo = ciclo;
}

public int getCreditos() {
	return creditos;
}

public void setCreditos(int creditos) {
	this.creditos = creditos;
}

public int getHoras() {
	return horas;
}

public void setHoras(int horas) {
	this.horas = horas;
}






}

