package main;

import dao.CursoDAO;
import entidades.Curso;

public class CursoMain {
	public static void main(String[] args) {
		CursoDAO cDao = new CursoDAO();
//		Curso c = new Curso("para", "lpr", 1997);
//		System.out.println(cDao.crearCurso(c));
//		System.out.println(cDao.listaCurso());
		
		cDao.asignarProfeACurso(1, 4);
		
		
	}
}
