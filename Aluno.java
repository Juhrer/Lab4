package lab4;

/**
 * Representação de um aluno.
 * Todo aluno tem um nome, um curso e uma matrícula.
 * 
 * @author Lucas Alves Vigolvino
 */
public class Aluno {
	/**
	 * Nome, curso e matrícula do aluno.
	 */
	private String nome, curso, matricula;
	/**
	 * Constrói um aluno a partir de seu nome, curso e matricula.
	 * 
	 * @param nome o nome do aluno
	 * @param curso o curso que o aluno faz
	 * @param matricula a matrícula do aluno
	 */
	public Aluno(String nome, String curso, String matricula) {
		this.nome = nome;
		this.curso = curso;
		this.matricula = matricula;
	}
	/**
	 * Retorna a String que representa o aluno.
	 * 
	 * @return a representação em String de um aluno
	 */
	@Override
	public String toString() {
		return matricula + " - " + nome + " - " + curso;
	}
}
