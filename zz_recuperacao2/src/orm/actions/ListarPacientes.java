package orm.actions;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import orm.modelo.Paciente;

public class ListarPacientes {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pacientes");
		EntityManager manager = factory.createEntityManager();

		Query query = manager.createQuery("select a from Paciente a");

		List<Paciente> lista = query.getResultList();

		System.out.printf("%-5s%-10s%-20s%-15s%-10s%-20s%-30s%-30s%n", "Id", "Nome", "E-mail", "CPF", "D. Nasc.",
				"Naturalidade", "Endereco", "Diagnóstico");
		System.out.println(
				"------------------------------------------------------------------------------------------------------------------------");

		for (Paciente a : lista) {
			System.out.printf("%-5s%-10s%-20s%-15s%-10s%-20s%-30s%-30s%n", a.getId(), a.getNome(), a.getEmail(), a.getCpf(),
					a.getDataDeNascimento(), a.getNaturalidade(), a.getEndereco(), a.getDiagnostico());
		}

		manager.close();
		factory.close();

	}

}