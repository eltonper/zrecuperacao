package orm.actions;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import orm.modelo.Paciente;

public class RemoverPaciente {
	public static void main(String[] args) {
		Paciente paciente1 = new Paciente();
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pacientes");
		EntityManager manager = factory.createEntityManager();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite o Id do paciente a ser excluído: ");
		long id = Long.parseLong(scanner.nextLine());
		scanner.close();

		paciente1 = manager.find(Paciente.class, id);
		

		
		manager.getTransaction().begin(); //inicializar a transação
		manager.remove(paciente1); //linha que faz o hibernate excluir um objeto no banco
		manager.getTransaction().commit(); //Encerramento da transação
		
		manager.close();
		factory.close();
	}

}
