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
	public List<String> lista_cursos;
	
	private Flanelografo() {
		lista_cursos = new ArrayList<String>();
		lista_cursos.add("");
        lista_cursos.add("Análise e Des. de Sistemas");
		lista_cursos.add("Design de Moda");
		lista_cursos.add("Design Gráfico");
		lista_cursos.add("Gastronomia");
		lista_cursos.add("Gestão de TI");
		lista_cursos.add("Redes de Computadores");
		lista_cursos.add("Administração");
		lista_cursos.add("Arquitetura e Urbanismo");
		lista_cursos.add("Ciências Contábeis");
		lista_cursos.add("Design");
		lista_cursos.add("Direito");
		lista_cursos.add("Educação Física");
		lista_cursos.add("Enfermagem");
		lista_cursos.add("Engenharia Ambiental e Sanitária");
		lista_cursos.add("Engenharia Civil");
		lista_cursos.add("Engenharia de Produção");
		lista_cursos.add("Engenharia Elétrica");
		lista_cursos.add("Engenharia Mecânica");
		lista_cursos.add("Engenharia Química");
		lista_cursos.add("Fisioterapia");
		lista_cursos.add("Jornalismo");
		lista_cursos.add("Nutrição");
		lista_cursos.add("Psicologia");
		lista_cursos.add("Publicidade e Propaganda");
		lista_cursos.add("Rádio, TV e Internet");
		lista_cursos.add("Sistemas de Informação");
		lista_cursos.add("Turismo");
		
		lista = new ArrayList<Disciplina>();
		lista.add(new Disciplina("Sistemas de Informação","Algoritmos","110","Gustavo","M","TER","1"));
		lista.add(new Disciplina("Análise e Des. de Sistemas","Calculo","208","Newton","N","SEG","2"));
		lista.add(new Disciplina("Enfermagem","Anatomia","300","Girafales","T","QUA","3"));
		lista.add(new Disciplina("Análise e Des. de Sistemas","Programação Web","Lab.Inf-1","Patrick","N","QUI","4"));
		lista.add(new Disciplina("Análise e Des. de Sistemas","Topicos ADS","200","Josenio","N","QUI","5"));
		lista.add(new Disciplina("Análise e Des. de Sistemas","Estatística","250","Pardal","N","SEX","3"));

	}
	
	public static Flanelografo getInstance() {
		if (Flanelografo.instance==null) {
//			Flanelografo.instance = new Flanelografo();
			carregar();
		}
		return Flanelografo.instance;
	}
	
	public String consultaSala(String numeroCurso) {
		String curso = lista_cursos.get(Integer.parseInt(numeroCurso));
		String resposta = "";
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
			criarDoNada();
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
	
	public static void criarDoNada() {
		instance = new Flanelografo();
	}

	
}

