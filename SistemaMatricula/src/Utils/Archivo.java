package Utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import clases.Alumno;
import clases.Curso;
import clases.Matricula;
import clases.Retiro;

public class Archivo {

    // ========== ALUMNOS ==========
    public static void guardarAlumnos(List<Alumno> lista, String ruta) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ruta))) {
            for (Alumno a : lista) {
                pw.println(a.getCodAlumno() + ";" + a.getNombres() + ";" + a.getApellidos() + ";" +
                           a.getDni() + ";" + a.getEdad() + ";" + a.getCelular() + ";" + a.getEstado());
            }
        } catch (IOException e) {
            System.out.println("Error al guardar alumnos: " + e.getMessage());
        }
    }

    public static List<Alumno> cargarAlumnos(String ruta) {
        List<Alumno> lista = new ArrayList<>();
        File f = new File(ruta);
        if (!f.exists()) return lista;

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] d = linea.split(";");
                if (d.length == 7) {
                    lista.add(new Alumno(
                        Integer.parseInt(d[0]), d[1], d[2], d[3],
                        Integer.parseInt(d[4]), Integer.parseInt(d[5]), Integer.parseInt(d[6])
                    ));
                }
            }
        } catch (Exception e) {
            System.out.println("Error al cargar alumnos: " + e.getMessage());
        }
        return lista;
    }

    // ========== CURSOS ==========
    public static void guardarCursos(List<Curso> lista, String ruta) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ruta))) {
            for (Curso c : lista) {
                pw.println(c.getCodCurso() + ";" + c.getAsignatura() + ";" + c.getCiclo() + ";" +
                           c.getCreditos() + ";" + c.getHoras());
            }
        } catch (IOException e) {
            System.out.println("Error al guardar cursos: " + e.getMessage());
        }
    }

    public static List<Curso> cargarCursos(String ruta) {
        List<Curso> lista = new ArrayList<>();
        File f = new File(ruta);
        if (!f.exists()) return lista;

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] d = linea.split(";");
                if (d.length == 5) {
                    lista.add(new Curso(
                        Integer.parseInt(d[0]), d[1],
                        Integer.parseInt(d[2]), Integer.parseInt(d[3]), Integer.parseInt(d[4])
                    ));
                }
            }
        } catch (Exception e) {
            System.out.println("Error al cargar cursos: " + e.getMessage());
        }
        return lista;
    }

    // ========== MATRÍCULAS ==========
    public static void guardarMatriculas(List<Matricula> lista, String ruta) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ruta))) {
            for (Matricula m : lista) {
                pw.println(m.getNumMatricula() + ";" + m.getCodAlumno() + ";" + m.getCodCurso() + ";" +
                           m.getFecha() + ";" + m.getHora());
            }
        } catch (IOException e) {
            System.out.println("Error al guardar matrículas: " + e.getMessage());
        }
    }

    public static List<Matricula> cargarMatriculas(String ruta) {
        List<Matricula> lista = new ArrayList<>();
        File f = new File(ruta);
        if (!f.exists()) return lista;

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] d = linea.split(";");
                if (d.length == 5) {
                    lista.add(new Matricula(
                        Integer.parseInt(d[0]),
                        Integer.parseInt(d[1]),
                        Integer.parseInt(d[2]),
                        d[3], d[4]
                    ));
                }
            }
        } catch (Exception e) {
            System.out.println("Error al cargar matrículas: " + e.getMessage());
        }
        return lista;
    }

    // ========== RETIROS ==========
    public static void guardarRetiros(List<Retiro> lista, String ruta) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ruta))) {
            for (Retiro r : lista) {
                pw.println(r.getNumRetiro() + ";" + r.getNumMatricula() + ";" + r.getFecha() + ";" + r.getHora());
            }
        } catch (IOException e) {
            System.out.println("Error al guardar retiros: " + e.getMessage());
        }
    }

    public static List<Retiro> cargarRetiros(String ruta) {
        List<Retiro> lista = new ArrayList<>();
        File f = new File(ruta);
        if (!f.exists()) return lista;

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] d = linea.split(";");
                if (d.length == 4) {
                    lista.add(new Retiro(
                        Integer.parseInt(d[0]),
                        Integer.parseInt(d[1]),
                        d[2], d[3]
                    ));
                }
            }
        } catch (Exception e) {
            System.out.println("Error al cargar retiros: " + e.getMessage());
        }
        return lista;
    }
}