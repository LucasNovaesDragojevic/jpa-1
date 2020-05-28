package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriaContaComSaldo {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Conta conta = new Conta();
		conta.setTitular("Rubens");
		conta.setNumero(73425);
		conta.setAgencia(6798);
		conta.setSaldo(500.00);
		
		em.getTransaction().begin();
		
		em.persist(conta);
		
		conta.setSaldo(8000.00);
		
		em.getTransaction().commit();
		em.close();
		
		EntityManager em2 = emf.createEntityManager();
		
		conta.setSaldo(913131231.01);
		
		em2.getTransaction().begin();
		
		em2.merge(conta);
		
		em2.getTransaction().commit();
		
		System.out.println("id: " + conta.getId());
		
		emf.close();
	}
}