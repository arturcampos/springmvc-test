package br.com.springtest.services;

import java.util.List;

import br.com.springtest.models.User;


public interface UserService {
	public User findUserByUserName(String userName);
	public void saveUser(User user);
	public List<User> listUsers();
}
