package lab4;

import java.util.*;

public class Grupo {
	public String nome;
	private HashSet<Aluno> alunos = new HashSet<>();
	public Grupo(String nome) {
		this.nome = nome;
	}
	public void alocaAluno(Aluno aluno) {
		alunos.add(aluno);
	}
	@Override
	public String toString() {
		String listaAlunos = "Alunos do Grupo " + nome + ":\n";
		for(Aluno aluno : alunos) {
			listaAlunos += "* " + aluno.toString() + "\n";
		}
		return  listaAlunos;
	}
}
