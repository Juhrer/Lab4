import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import lab4.*;

class ControleAlunosTeste {
	private ControleAlunos controle;
	
	@BeforeEach
	void criaControleAlunos() {
		controle = new ControleAlunos();
		controle.cadastraAluno("11111111", "Lucas", "Computação");
		controle.cadastraAluno("1234567", "Aeiou", "Elétrica");
		controle.cadastraAluno("555555555","Matheus", "Direito");
		controle.cadastrarGrupo("GrUpo1");
		controle.cadastrarGrupo("Grupo2");
		controle.alocaAluno("11111111", "GRUPO1");
		controle.alocaAluno("1234567", "GRUPO1");
		controle.registraAlunoRespondeu("11111111");
		controle.registraAlunoRespondeu("1234567");
		controle.registraAlunoRespondeu("11111111");
	}

	@Test
	void testCadastraAluno() {
		assertEquals("CADASTRO REALIZADO!\n", controle.cadastraAluno("9999999", "Aaaaa", "Letras"));
		assertEquals("MATRÍCULA JÁ CADASTRADA\n", controle.cadastraAluno("11111111", "Aeiou", "Elétrica"));
	}

	@Test
	void testExibiAluno() {
		assertEquals("\nAluno não cadastrado.\n", controle.exibiAluno("7654321"));
		assertEquals("\nAluno: 11111111 - Lucas - Computação\n", controle.exibiAluno("11111111"));
		assertEquals("\nAluno: 1234567 - Aeiou - Elétrica\n", controle.exibiAluno("1234567"));
	}

	@Test
	void testCadastrarGrupo() {
		assertEquals("GRUPO JÁ CADASTRADO!\n", controle.cadastrarGrupo("grupo1"));
		assertEquals("CADASTRO REALIZADO!\n", controle.cadastrarGrupo("Grupo3"));
	}

	@Test
	void testAlocaAluno() {
		assertEquals("Aluno e grupo não cadastrados.\n", controle.alocaAluno("00000000", "GRUPO4"));
		assertEquals("Aluno não cadastrado.\n", controle.alocaAluno("00000000","GRUPO1"));
		assertEquals("Grupo não cadastrado.\n", controle.alocaAluno("1234567", "GRUPO4"));
		assertEquals("ALUNO ALOCADO!\n", controle.alocaAluno("1234567", "GRUPO1"));
		assertEquals("ALUNO ALOCADO!\n", controle.alocaAluno("555555555", "GRUPO1"));
	}

	@Test
	void testImprimiGrupo() {
		assertEquals("Grupo não cadastrado.\n", controle.imprimiGrupo("GRUPO4"));
		assertEquals("\nAlunos do Grupo Grupo2:\n", controle.imprimiGrupo("GRUPO2"));
		assertEquals("\nAlunos do Grupo GrUpo1:\n* 1234567 - Aeiou - Elétrica\n* 11111111 - Lucas - Computação\n", controle.imprimiGrupo("GRUPO1"));
	}

	@Test
	void testRegistraAlunoRespondeu() {
		assertEquals("Aluno não cadastrado.\n", controle.registraAlunoRespondeu("2222222"));
		assertEquals("ALUNO REGISTRADO!\n", controle.registraAlunoRespondeu("11111111"));
	}

	@Test
	void testImprimiAlunosResponderam() {
		assertEquals("Alunos:\n1. 11111111 - Lucas - Computação\n2. 1234567 - Aeiou - Elétrica\n3. 11111111 - Lucas - Computação\n", controle.imprimiAlunosResponderam());
	}
}
