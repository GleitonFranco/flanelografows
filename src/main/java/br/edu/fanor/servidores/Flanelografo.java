package br.edu.fanor.servidores;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Calendar;
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
	public List<String> listaCursos;
	
	private Flanelografo() {
		listaCursos = new ArrayList<String>();
		listaCursos.add("");
        listaCursos.add("Análise e Des. de Sistemas");
		listaCursos.add("Design de Moda");
		listaCursos.add("Design Gráfico");
		listaCursos.add("Gastronomia");
		listaCursos.add("Gestão de TI");
		listaCursos.add("Redes de Computadores");
		listaCursos.add("Administração");
		listaCursos.add("Arquitetura e Urbanismo");
		listaCursos.add("Ciências Contábeis");
		listaCursos.add("Design");
		listaCursos.add("Direito");
		listaCursos.add("Educação Física");
		listaCursos.add("Enfermagem");
		listaCursos.add("Engenharia Ambiental e Sanitária");
		listaCursos.add("Engenharia Civil");
		listaCursos.add("Engenharia de Produção");
		listaCursos.add("Engenharia Elétrica");
		listaCursos.add("Engenharia Mecânica");
		listaCursos.add("Engenharia Química");
		listaCursos.add("Fisioterapia");
		listaCursos.add("Jornalismo");
		listaCursos.add("Nutrição");
		listaCursos.add("Psicologia");
		listaCursos.add("Publicidade e Propaganda");
		listaCursos.add("Rádio, TV e Internet");
		listaCursos.add("Sistemas de Informação");
		listaCursos.add("Turismo");
		
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
		String curso = listaCursos.get(Integer.parseInt(numeroCurso));
		
		Calendar calendario = Calendar.getInstance();
		int diaSemana = calendario.get(Calendar.DAY_OF_WEEK);
		int hora = calendario.get(Calendar.HOUR_OF_DAY);
		String diaAtual = "SEG";
		switch (diaSemana) {
			case 2 : diaAtual = "SEG";
			case 3 : diaAtual = "TER";
			case 4 : diaAtual = "QUA";
			case 5 : diaAtual = "QUI";
			case 6 : diaAtual = "SEX";
		}
		String turnoAtual = "T";
		if (hora < 12) {
			turnoAtual = "M";
		} else {
			if (hora > 18) {
				turnoAtual = "N";
			}
		}
		
		String resposta = "";
		for (Disciplina d : lista) {
			if (d.curso.equals(curso) && d.turno.equals(turnoAtual) && d.dia.equals(diaAtual)) {
				resposta += d.nome+" "+d.sala+"\n";
			}
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

