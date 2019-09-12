package lab4;

import java.util.*;

public class ControleAlunos {
	private HashMap<String, Aluno> alunos = new HashMap<>();
	private HashSet<Grupo> grupos = new HashSet<>();
	public String cadastraAluno(String matricula, String nomeAluno, String curso) {
		if(alunos.containsKey(matricula)) {
			return "MATRÍCULA JÁ CADASTRADA";
		} else {
			alunos.put(matricula, new Aluno(nomeAluno, curso));
			return "CADASTRO REALIZADO!";
		}
	}
	public String consultaAluno(String matricula) {
		if(!alunos.containsKey(matricula)) {
			return "Aluno não cadastrado";
		} else {
			return "Aluno: " + matricula + alunos.get(matricula).toString();
		}
	}
	public String cadastrarGrupo(String nomeGrupo) {
		if(grupos.contains(new Grupo(nomeGrupo.toUpperCase()))) {
			return "GRUPO JÁ CADASTRADO!";
		} else {
			grupos.add(new Grupo(nomeGrupo.toUpperCase()));
			return "CADASTRO REALIZADO!";
		}
	}
	public String alocaAluno(String matricula, String nomeGrupo) {
		if(!alunos.containsKey(matricula) && !grupos.contains(nomeGrupo.toUpperCase())) {
			return "
		}
	}
}