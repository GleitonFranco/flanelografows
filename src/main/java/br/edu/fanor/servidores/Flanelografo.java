package br.edu.fanor.servidores;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

public class Flanelografo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6186742489880036386L;
	private static Flanelografo instance;
	public List<Disciplina> lista;
	
	private Flanelografo() {
//		lista = new ArrayList<Disciplina>();
		carregar();
//		lista.add(new Disciplina("SI","Algoritmos","110","Gustavo","M","TER","1"));
//		lista.add(new Disciplina("ADS","Calculo","208","Everardo","N","SEG","2"));
//		lista.add(new Disciplina("Enfermagem","Anatomia","300","Frankstein","T","QUA","3"));
//		lista.add(new Disciplina("ADS","Programação Web","Lab.Inf-1","Patrick","N","QUI","4"));
//		lista.add(new Disciplina("ADS","Topicos ADS","200","Josenio","N","QUI","5"));
//		lista.add(new Disciplina("ADS","Estatística","250","Josenio","N","SEX","3"));
	}
	
	public static Flanelografo getInstance() {
		if (instance==null) {
//			instance = new Flanelografo();
			carregar();
		}
		return instance;
	}
	
	public String consultaSala(String nCurso) {
		String curso = "";
		String resposta = "";
		if (nCurso.equals("19")) curso="ADS";
		if (nCurso.equals("2")) curso="SI";
		if (nCurso.equals("3")) curso="Enfermagem";
		for (Disciplina d : lista) {
			if (d.curso.equals(curso)) resposta += d.nome+" "+d.sala+"\n";
		}
		return resposta;
	}
	
	public void ordenaLista() {
		Collections.sort(lista);
	}
	
	public static void carregar() {
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("quadro.ser"));
			instance = (Flanelografo) is.readObject();
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
	}

	public void salva() {
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("quadro.ser"));
			os.writeObject(instance);
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}

