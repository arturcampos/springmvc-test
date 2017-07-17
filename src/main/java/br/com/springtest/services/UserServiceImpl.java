package br.com.springtest.services;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.springtest.daos.RoleDAO;
import br.com.springtest.daos.UserDAO;
import br.com.springtest.models.Role;
import br.com.springtest.models.User;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDao;
	@Autowired
    private RoleDAO roleDao;
    /*@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	*/
	@Override
	public User findUserByUserName(String userName) {
		return ((UserDAO) userDao).findByUserName(userName);
	}

	@Override
	public void saveUser(User user) {
		//user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleDao.findByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		userDao.save(user);
	}

	@Override
	public List<User> listUsers() {
		return userDao.findAll();
	}
	
	@Override
	public User find(int id){
		return userDao.findById(id);
	}

}