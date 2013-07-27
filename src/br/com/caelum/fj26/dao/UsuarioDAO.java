package br.com.caelum.fj26.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.fj26.bean.Usuario;
import br.com.caelum.fj26.infra.JPAUtil;

public class UsuarioDAO {

	public boolean existe(Usuario usuario) {
		EntityManager em = JPAUtil.getEntityManager();
		
		Query query = em.createQuery("select u from Usuario u where u.login = :login and u.senha = :senha");
		query.setParameter("login", usuario.getLogin());
		query.setParameter("senha", usuario.getSenha());
		
		boolean encontrado = query.getResultList().isEmpty();
		em.close();
		
		return !encontrado;
	}
	
}
