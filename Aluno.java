package lab4;

public class Aluno {
	private String nome, curso, matricula;
	public Aluno(String nome, String curso, String matricula) {
		this.nome = nome;
		this.curso = curso;
		this.matricula = matricula;
	}
	@Override
	public String toString() {
		return matricula + " - " + nome + " - " + curso;
	}
}
