package br.com.springtest.daos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.springtest.models.Role;

@Repository
@Transactional
public class RoleDAO {
	@PersistenceContext
	protected EntityManager em;

	public Role save(final Role role) {
		this.em.persist(role);
		return role;
	}

	public Role delete(Serializable id) {
		Role role = findById(id);
		if (role != null) {
			em.remove(role);
		}
		return role;
	}

	public List<Role> findAll() {
		List resultList = em.createQuery("from Role").getResultList();
		return resultList;
	}

	public Role findById(Serializable id) {
		Role obj = (Role) em.find(Role.class, id);
		return obj;
	}

	public void update(Role role) {
		em.merge(role);

	}

	public Role findByRole(String role) {
		Query q = em.createQuery("select r from Role r where r.role = :role", Role.class);
		q.setParameter("role", role);
		return (Role) q.getSingleResult();
	}

}
