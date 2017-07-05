package br.com.springtest.daos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.springtest.models.User;

@Repository
@Transactional
public class UserDAO{

	@PersistenceContext
	protected EntityManager em;

	public User save(final User user) {
		this.em.persist(user);
		return user;
	}

	public User delete(Serializable id) {
		User user = findById(id);
		if (user != null) {
			em.remove(user);
		}
		return user;
	}

	public List<User> findAll() {
		List resultList = em.createQuery("from User").getResultList();
		return resultList;
	}

	public User findById(Serializable id) {
		User obj = (User) em.find(User.class, id);
		return obj;
	}

	public void update(User user) {
		em.merge(user);

	}
	
	public User findByUserName(String userName){
		Query q = em.createQuery("select u from User u where u.userName = :username", User.class);
		q.setParameter("username", userName);
		return (User) q.getSingleResult();
	}
		
}
