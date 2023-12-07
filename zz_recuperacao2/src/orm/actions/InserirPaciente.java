package orm.actions;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import orm.modelo.Paciente;

public class InserirPaciente {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Digite o nome do paciente: ");
		String nome = scanner.nextLine();

		System.out.println("Digite o e-mail do paciente: ");
		String email = scanner.nextLine();

		System.out.println("Digite o cpf do paciente: ");
		String cpf = scanner.nextLine();

		System.out.println("Digite a data de nascimento do paciente: ");
		String dataDeNascimento = scanner.nextLine();

		System.out.println("Digite a naturalidade do paciente: ");
		String naturalidade = scanner.nextLine();

		System.out.println("Digite o endereço do paciente: ");
		String endereco = scanner.nextLine();
		
		System.out.println("Digite o diagnostico do paciente: ");
		String diagnostico = scanner.nextLine();

		scanner.close();
		
		Paciente paciente1 = new Paciente();
		paciente1.setNome(nome);
		paciente1.setEmail(email);
		paciente1.setCpf(cpf);
		paciente1.setDataDeNascimento(dataDeNascimento);
		paciente1.setNaturalidade(naturalidade);
		paciente1.setEndereco(endereco);
		paciente1.setDiagnostico(diagnostico);

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pacientes");
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();
		manager.persist(paciente1);
		manager.getTransaction().commit();

		manager.close();
		factory.close();
		
		scanner.close();
	}

}
