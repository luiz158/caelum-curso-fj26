package br.com.caelum.fj26.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.caelum.fj26.infra.JPAUtil;

public class DAO<T> {

	private Class<T> classe;

	public DAO(Class<T> classe) {
		this.classe = classe;
	}
	
	public void adiciona(T t) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		em.close();
	}
	
	public void remove(T t) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(t));
		em.getTransaction().commit();
		em.close();
	}
	
	public void atualiza(T t) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();
		em.close();	
	}
	
	public T buscaPorId(Long id) {
		EntityManager em = JPAUtil.getEntityManager();
		T t = em.find(classe, id);
		em.close();
		
		return t;
	}
	
	@SuppressWarnings("unchecked")
	public List<T> buscaTodos() {
		EntityManager em = JPAUtil.getEntityManager();
		Query query = em.createQuery("select t from " + classe.getName() + " t");
		
		return query.getResultList();
	}

	public List<T> listaTodosPaginada(int inicio, int quantidade) {
		EntityManager em = JPAUtil.getEntityManager();
		TypedQuery<T> query = em.createQuery("select n from " + classe.getName() + " n", classe).setFirstResult(inicio).setMaxResults(quantidade);
		
		return query.getResultList();
	}

	public int contaTodos() {
		EntityManager em = JPAUtil.getEntityManager();
		TypedQuery<T> query = em.createQuery("select t from " + classe.getName() + " t", classe);
		
		return query.getResultList().size();
	}
}
