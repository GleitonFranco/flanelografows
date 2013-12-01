package br.edu.fanor.servidores;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Disciplina implements Serializable,Comparable<Disciplina> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1391546017691213414L;
	public static final List<String> listaTurnos = Arrays.asList(new String[]{"M","T","N"});
	public static final List<String> listaDias = Arrays.asList(new String[]{"SEG","TER","QUA","QUI","SEX"});

	String nome;
	String curso;
	String sala;
	String prof;
	String turno;
	String dia;
	String semestre;
	
	public Disciplina(String curso, String nome, String sala, String prof, String turno, String diaSemana, String semestre) {
		super();
		this.curso = curso;
		this.nome = nome;
		this.sala = sala;
		this.prof = prof;
		this.turno = turno;
		this.dia = diaSemana;
		this.semestre = semestre;
	}

//	@Override
	public int compareTo(Disciplina d) {
		// As disciplinas serão ordenadas seguindo as ordens crescentes: TURNO , DIA DA SEMANA , CURSO
		int retorno = (int)Math.signum( (listaTurnos.indexOf(this.turno) - listaTurnos.indexOf(d.turno)) );
		if (retorno ==0) {
			retorno = (int)Math.signum( listaDias.indexOf(this.dia) - listaDias.indexOf(d.dia) );
			if (retorno ==0) {
				retorno = this.curso.compareTo(d.curso);
			}
		}
		return retorno;
	}
	
	
}
