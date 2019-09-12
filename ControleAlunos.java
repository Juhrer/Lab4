package lab4;

import java.util.*;

public class ControleAlunos {
	private HashMap<String, Aluno> alunos = new HashMap<>();
	private HashMap<String, Grupo> grupos = new HashMap<>();
	private ArrayList<Aluno> alunosResponderam = new ArrayList<>();
	public String cadastraAluno(String matricula, String nomeAluno, String curso) {
		if(alunos.containsKey(matricula)) {
			return "MATRÍCULA JÁ CADASTRADA";
		} else {
			alunos.put(matricula, new Aluno(nomeAluno, curso, matricula));
			return "CADASTRO REALIZADO!";
		}
	}
	public String consultaAluno(String matricula) {
		if(!alunos.containsKey(matricula)) {
			return "Aluno não cadastrado.";
		} else {
			return "Aluno: " + alunos.get(matricula).toString();
		}
	}
	public String cadastrarGrupo(String nomeGrupo) {
		if(grupos.containsKey(nomeGrupo.toUpperCase())) {
			return "GRUPO JÁ CADASTRADO!";
		} else {
			grupos.put(nomeGrupo.toUpperCase(), new Grupo(nomeGrupo));
			return "CADASTRO REALIZADO!";
		}
	}
	public String alocaAluno(String matricula, String nomeGrupoMaiusculo) {
		if(!alunos.containsKey(matricula) && !grupos.containsKey(nomeGrupoMaiusculo)) {
			return "Aluno e grupo não cadastrados.";
		} else if(!alunos.containsKey(matricula)) {
			return "Aluno não cadastrado.";
		} else if(!grupos.containsKey(nomeGrupoMaiusculo)) {
			return "Grupo não cadastrado.";
		} else {
			grupos.get(nomeGrupoMaiusculo).alocaAluno(alunos.get(matricula));
			return "ALUNO ALOCADO!";
		}
	}
	public String imprimiGrupo(String nomeGrupoMaiusculo) {
		if(!grupos.containsKey(nomeGrupoMaiusculo)) {
			return "Grupo não cadastrado.";
		} else {
			return grupos.get(nomeGrupoMaiusculo).toString();
		}
	}
	public String cadastrarAlunosResponderam(String matricula) {
		if(!alunos.containsKey(matricula)) {
			return "Aluno não cadastrado.";
		} else {
			alunosResponderam.add(alunos.get(matricula));
			return "ALUNO REGISTRADO!";
		}
	}
	public String imprimiAlunosResponderam() {
		String listaAlunosResponderam = "Alunos:\n";
		for(int i = 0; i < alunosResponderam.size(); i++) {
			listaAlunosResponderam += i + 1 + ". " + alunosResponderam.get(i).toString() + "\n";
		}
		return listaAlunosResponderam;
	}
}
