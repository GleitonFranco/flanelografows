package br.edu.fanor.servidores;

import java.io.Serializable;

public class Disciplina implements Serializable,Comparable<Disciplina> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1391546017691213414L;
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
		if (turno.compareTo(d.turno)!=0)
			return turno.compareTo(d.turno);
		if (dia.compareTo(d.dia)!=0)
			return dia.compareTo(d.dia);
		return curso.compareTo(d.curso);
	}
	
	
}
