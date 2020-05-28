package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class AlteraContaSaldoLeonardo {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Conta conta = em.find(Conta.class, 2L);
		System.out.println("Titular: " + conta.getTitular());
		em.getTransaction().begin();
		
		conta.setSaldo(20.0);
		
		em.getTransaction().commit();
		
		emf.close();
	}
}