package lab4;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ControleAlunos controle = new ControleAlunos();
		String comando, matricula, nome, curso;
		while(true) {
			System.out.print("(C)adastrar Aluno\n"
					+ "(E)xibir Aluno\n"
					+ "(N)ovo Grupo\n"
					+ "(A)locar Aluno no Grupo e Imprimir Grupos\n"
					+ "(R)egistrar Aluno que Respondeu\n"
					+ "(I)mprimir Alunos que Responderam\n"
					+ "(O)ra, vamos fechar o programa!\n"
					+ "\n"
					+ "Op��o> ");
			comando = sc.nextLine();
			if(!comando.equalsIgnoreCase("C") && !comando.equalsIgnoreCase("E") && !comando.equalsIgnoreCase("N") && !comando.equalsIgnoreCase("A") && !comando.equalsIgnoreCase("R") && !comando.equalsIgnoreCase("I") && !comando.equalsIgnoreCase("O")) {
				System.out.println("COMANDO INV�LIDO!\n");
			} else if(comando.equalsIgnoreCase("C")) {
				System.out.print("Matricula: ");
				matricula = sc.nextLine();
				System.out.print("Nome: ");
				nome = sc.nextLine();
				System.out.print("Curso: ");
				curso = sc.nextLine();
				System.out.println(controle.cadastraAluno(matricula, nome, curso));
			} else if(comando.equalsIgnoreCase("E")) {
				System.out.print("Matricula: ");
				matricula = sc.nextLine();
				System.out.println(controle.exibiAluno(matricula));
			} else if(comando.equalsIgnoreCase("N")) {
				System.out.print("Grupo: ");
				nome = sc.nextLine();
				System.out.println(controle.cadastrarGrupo(nome));
			} else if(comando.equalsIgnoreCase("A")) {
				System.out.print("(A)locar Aluno ou (I)mprimir Grupo? ");
				comando = sc.nextLine();
				if(!comando.equalsIgnoreCase("A") && !comando.equalsIgnoreCase("I")) {
					System.out.println("COMANDO INV�LIDO!\n");
				} else if(comando.equalsIgnoreCase("A")) {
					System.out.print("Matricula: ");
					matricula = sc.nextLine();
					System.out.print("Grupo: ");
					nome = sc.nextLine().toUpperCase();
					System.out.println(controle.alocaAluno(matricula, nome));
				} else {
					System.out.print("Grupo: ");
					nome = sc.nextLine().toUpperCase();
					System.out.println(controle.imprimiGrupo(nome));
				}
			} else if(comando.equalsIgnoreCase("R")) {
				System.out.print("Matricula: ");
				matricula = sc.nextLine();
				System.out.println(controle.registraAlunoRespondeu(matricula));
			} else if(comando.equalsIgnoreCase("I")) {
				System.out.println(controle.imprimiAlunosResponderam());
			} else {
				sc.close();
				break;
			}
		}
	}
}
