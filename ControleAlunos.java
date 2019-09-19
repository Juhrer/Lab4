package lab4;

import java.util.*;

/**
 * Representação de um controle de alunos.
 * 
 * @author Lucas Alves Vigolvino
 */
public class ControleAlunos {
	/**
	 * Mapa de alunos cadastrados.
	 */
	private HashMap<String, Aluno> alunos = new HashMap<>();
	/**
	 * Mapa de grupos cadastrados.
	 */
	private HashMap<String, Grupo> grupos = new HashMap<>();
	/**
	 * Lista de alunos que responderam questões no quadro.
	 */
	private ArrayList<Aluno> alunosResponderam = new ArrayList<>();
	/**
	 * Cadastra um aluno no controle de alunos.
	 * 
	 * @param matricula a matrícula do aluno
	 * @param nomeAluno o nome do aluno
	 * @param curso o curso que o aluno faz
	 * @return uma String que diz se o cadastro foi um sucesso ou não
	 */
	public String cadastraAluno(String matricula, String nomeAluno, String curso) {
		if(alunos.containsKey(matricula)) {
			return "MATRÍCULA JÁ CADASTRADA\n";
		} else {
			alunos.put(matricula, new Aluno(nomeAluno, curso, matricula));
			return "CADASTRO REALIZADO!\n";
		}
	}
	/**
	 * Exibi a representação em String de um aluno.
	 * 
	 * @param matricula a matrícula do aluno
	 * @return a String que representa um aluno ou o aviso de que o aluno não foi cadastrado
	 */
	public String exibiAluno(String matricula) {
		if(!alunos.containsKey(matricula)) {
			return "\nAluno não cadastrado.\n";
		} else {
			return "\nAluno: " + alunos.get(matricula).toString() + "\n";
		}
	}
	/**
	 * Cadastra um grupo no controle de alunos.
	 * 
	 * @param nomeGrupo o nome do grupo
	 * @return uma String que diz se o cadastro foi um sucesso ou não
	 */
	public String cadastrarGrupo(String nomeGrupo) {
		if(grupos.containsKey(nomeGrupo.toUpperCase())) {
			return "GRUPO JÁ CADASTRADO!\n";
		} else {
			grupos.put(nomeGrupo.toUpperCase(), new Grupo(nomeGrupo));
			return "CADASTRO REALIZADO!\n";
		}
	}
	/**
	 * Aloca um aluno em um grupo
	 * 
	 * @param matricula a matrícula do aluno que está sendo alocado
	 * @param nomeGrupoMaiusculo o nome do grupo em maiúsculo
	 * @return uma String dizendo se foi um sucesso ou não, e se não, dizendo qual foi o respectivo problema
	 */
	public String alocaAluno(String matricula, String nomeGrupoMaiusculo) {
		if(!alunos.containsKey(matricula) && !grupos.containsKey(nomeGrupoMaiusculo)) {
			return "Aluno e grupo não cadastrados.\n";
		} else if(!alunos.containsKey(matricula)) {
			return "Aluno não cadastrado.\n";
		} else if(!grupos.containsKey(nomeGrupoMaiusculo)) {
			return "Grupo não cadastrado.\n";
		} else {
			grupos.get(nomeGrupoMaiusculo).alocaAluno(alunos.get(matricula));
			return "ALUNO ALOCADO!\n";
		}
	}
	/**
	 * Exibi a representação em String de um grupo
	 * 
	 * @param nomeGrupoMaiusculo o nome grupo em maiúsculo
	 * @return a String que representa o grupo ou o aviso de que o grupo não foi cadastrado
	 */
	public String imprimiGrupo(String nomeGrupoMaiusculo) {
		if(!grupos.containsKey(nomeGrupoMaiusculo)) {
			return "Grupo não cadastrado.\n";
		} else {
			return grupos.get(nomeGrupoMaiusculo).toString();
		}
	}
	/**
	 * Registra que um aluno respondeu uma questão no quadro.
	 * 
	 * @param matricula a matrícula do aluno que respondeu
	 * @return uma String que diz se o registro foi um sucesso ou não
	 */
	public String registraAlunoRespondeu(String matricula) {
		if(!alunos.containsKey(matricula)) {
			return "Aluno não cadastrado.\n";
		} else {
			alunosResponderam.add(alunos.get(matricula));
			return "ALUNO REGISTRADO!\n";
		}
	}
	/**
	 * Exibi a a lista dos alunos que responderam questões no quadro.
	 * 
	 * @return a lista dos alunos que responderam questões no quadro
	 */
	public String imprimiAlunosResponderam() {
		String listaAlunosResponderam = "Alunos:\n";
		for(int i = 0; i < alunosResponderam.size(); i++) {
			listaAlunosResponderam += i + 1 + ". " + alunosResponderam.get(i).toString() + "\n";
		}
		return listaAlunosResponderam;
	}
}
