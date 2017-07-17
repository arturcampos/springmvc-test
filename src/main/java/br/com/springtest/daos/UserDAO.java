package br.com.springtest.daos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
		return em.createQuery("select u from User u", User.class).getResultList();
	}

	public User findById(Serializable id) {
		User obj = (User) em.find(User.class, id);
		return obj;
	}

	public void update(User user) {
		em.merge(user);

	}
	
	public User findByUserName(String userName){
		return em.createQuery("select distinct(u) from User u "
				+ "join fetch u.roles role where u.userName = :userName", User.class)
				.setParameter("userName", userName).getSingleResult();
	}
		
}
