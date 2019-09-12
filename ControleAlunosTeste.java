import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import lab4.*;

class ControleAlunosTeste {
	private ControleAlunos controle;
	
	@BeforeEach
	void criaControleAlunos() {
		controle = new ControleAlunos();
		controle.cadastraAluno("11111111", "Lucas", "Computa��o");
		controle.cadastraAluno("1234567", "Aeiou", "El�trica");
		controle.cadastraAluno("555555555","Matheus", "Direito");
		controle.cadastrarGrupo("GrUpo1");
		controle.cadastrarGrupo("Grupo2");
		controle.alocaAluno("11111111", "GRUPO1");
		controle.alocaAluno("1234567", "GRUPO1");
		controle.cadastrarAlunosResponderam("11111111");
		controle.cadastrarAlunosResponderam("1234567");
	}

	@Test
	void testCadastraAluno() {
		assertEquals("CADASTRO REALIZADO!", controle.cadastraAluno("9999999", "Aaaaa", "Letras"));
		assertEquals("MATR�CULA J� CADASTRADA", controle.cadastraAluno("11111111", "Aeiou", "El�trica"));
	}

	@Test
	void testConsultaAluno() {
		assertEquals("Aluno n�o cadastrado.", controle.consultaAluno("7654321"));
		assertEquals("Aluno: 11111111 - Lucas - Computa��o", controle.consultaAluno("11111111"));
		assertEquals("Aluno: 1234567 - Aeiou - El�trica", controle.consultaAluno("1234567"));
	}

	@Test
	void testCadastrarGrupo() {
		assertEquals("GRUPO J� CADASTRADO!", controle.cadastrarGrupo("grupo1"));
		assertEquals("CADASTRO REALIZADO!", controle.cadastrarGrupo("Grupo3"));
	}

	@Test
	void testAlocaAluno() {
		assertEquals("Aluno e grupo n�o cadastrados.", controle.alocaAluno("00000000", "GRUPO4"));
		assertEquals("Aluno n�o cadastrado.", controle.alocaAluno("00000000","GRUPO1"));
		assertEquals("Grupo n�o cadastrado.", controle.alocaAluno("1234567", "GRUPO4"));
		assertEquals("ALUNO ALOCADO!", controle.alocaAluno("1234567", "GRUPO1"));
		assertEquals("ALUNO ALOCADO!", controle.alocaAluno("555555555", "GRUPO1"));
	}

	@Test
	void testImprimiGrupo() {
		assertEquals("Grupo n�o cadastrado.", controle.imprimiGrupo("GRUPO4"));
		assertEquals("Alunos do Grupo Grupo2:\n", controle.imprimiGrupo("GRUPO2"));
		assertEquals("Alunos do Grupo GrUpo1:\n* 1234567 - Aeiou - El�trica\n* 11111111 - Lucas - Computa��o\n", controle.imprimiGrupo("GRUPO1"));
	}

	@Test
	void testCadastrarAlunosResponderam() {
		assertEquals("Aluno n�o cadastrado.", controle.cadastrarAlunosResponderam("2222222"));
		assertEquals("ALUNO REGISTRADO!", controle.cadastrarAlunosResponderam("11111111"));
	}

	@Test
	void testImprimiAlunosResponderam() {
		assertEquals("Alunos:\n1. 11111111 - Lucas - Computa��o\n2. 1234567 - Aeiou - El�trica\n", controle.imprimiAlunosResponderam());
	}
}
