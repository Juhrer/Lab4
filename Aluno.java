package lab4;

public class Aluno {
	private String nome, curso;
	public Aluno(String nome, String curso) {
		this.nome = nome;
		this.curso = curso;
	}
	public String toString() {
		return " - " + nome + " - " + curso;
	}
}