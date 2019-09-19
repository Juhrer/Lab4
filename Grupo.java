package lab4;

import java.util.*;

/**
 * Representação de um grupo de estudantes.
 * Todo grupo tem um nome.
 * 
 * @author Lucas Alves Vigolvino
 */
public class Grupo {
	/**
	 * Nome do grupo.
	 */
	public String nome;
	/**
	 * Conjunto de alunos alocados no grupo.
	 */
	private HashSet<Aluno> alunos = new HashSet<>();
	/**
	 * Constrói um grupo a partir do seu nome.
	 * 
	 * @param nome o nome do grupo
	 */
	public Grupo(String nome) {
		this.nome = nome;
	}
	/**
	 * Aloca o aluno no grupo.
	 * 
	 * @param aluno o aluno que está sendo alocado
	 */
	public void alocaAluno(Aluno aluno) {
		alunos.add(aluno);
	}
	/**
	 * Retorna a String que representa o grupo.
	 * 
	 * @return a representação em String de um grupo
	 */
	@Override
	public String toString() {
		String listaAlunos = "\nAlunos do Grupo " + nome + ":\n";
		for(Aluno aluno : alunos) {
			listaAlunos += "* " + aluno.toString() + "\n";
		}
		return  listaAlunos;
	}
}
