package orm.actions;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import orm.modelo.Paciente;

public class AtualizarPaciente {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite o id do paciente a ter o registro alterado: ");
		long id = Long.parseLong(scanner.nextLine());

		System.out.println("Digite o novo diagnóstico do paciente: ");
		String novoDiagnostico = scanner.nextLine();

		System.out.println("Digite o novo email do paciente: ");
		String novoEmail = scanner.nextLine();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pacientes");
		EntityManager manager = factory.createEntityManager();

		Paciente pacienteExistente = manager.find(Paciente.class, id);

		pacienteExistente.setDiagnostico(novoDiagnostico);
		pacienteExistente.setEmail(novoEmail);

		manager.getTransaction().begin();
		manager.merge(pacienteExistente);
		manager.getTransaction().commit();

		scanner.close();
		manager.close();
		factory.close();
	}
}
