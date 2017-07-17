package br.com.springtest.daos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.springtest.models.Brother​;

@Repository
@Transactional
public class BrotherDAO {
	@PersistenceContext
	protected EntityManager em;

	public Brother​ save(final Brother​ brother) {
		this.em.persist(brother);
		return brother;
	}

	public Brother​ delete(Serializable id) {
		Brother​ brother = findById(id);
		if (brother != null) {
			em.remove(brother);
		}
		return brother;
	}

	public List<Brother​> findAll() {
		return em.createQuery("from Brother", Brother​.class).getResultList();
	}

	public Brother​ findById(Serializable id) {
		return em.find(Brother​.class, id);
	}

	public void update(Brother​ brother) {
		em.merge(brother);

	}

	public Brother​ findByBrother(String brother) {
		Query q = em.createQuery("select r from Brother r where r.brother = :brother", Brother​.class);
		q.setParameter("brother", brother);
		return (Brother​) q.getSingleResult();
	}

}
