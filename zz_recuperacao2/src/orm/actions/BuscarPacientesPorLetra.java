package orm.actions;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import orm.modelo.Paciente;

public class BuscarPacientesPorLetra {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite a letra inicial do paciente para localizar: ");
		String letra = scanner.nextLine();
		scanner.close();
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pacientes");
		EntityManager manager = factory.createEntityManager();

		Query query = manager.createQuery("select a from Paciente as a where a.nome LIKE :letraBuscada");
		query.setParameter("letraBuscada", letra + "%");

		List<Paciente> lista = query.getResultList();

			
//		System.out.printf("%-5s%-20s%-30s%-15s%-20s%-20s%-30s%n", "Id", "Nome", "E-mail", "CPF", "Data de Nascimento",
//				"Naturalidade", "Endereco");
		System.out.printf("%-5s%-10s%-20s%-15s%-10s%-20s%-30s%-30s%n", "Id", "Nome", "E-mail", "CPF", "D. Nasc.",
				"Naturalidade", "Endereco", "Diagnóstico");
		System.out.println(
				"------------------------------------------------------------------------------------------------------------------------");

		for (Paciente a : lista) {
			
			System.out.printf("%-5s%-10s%-20s%-15s%-10s%-20s%-30s%-30s%n", a.getId(), a.getNome(), a.getEmail(), a.getCpf(),
					a.getDataDeNascimento(), a.getNaturalidade(), a.getEndereco(), a.getDiagnostico());
//			System.out.printf("%-5s%-20s%-30s%-15s%-20s%-20s%-30s%n", a.getId(), a.getNome(), a.getEmail(), a.getCpf(),
//					a.getDataDeNascimento(), a.getNaturalidade(), a.getEndereco());
		}
		

		manager.close();
		factory.close();

	}

}
