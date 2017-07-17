package br.com.springtest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.springtest.daos.RoleDAO;
import br.com.springtest.models.Role;

@Service("roleService")
public class RoleServiceImpl implements RoleService{

	
	@Autowired
    private RoleDAO roleDao;
	
	public List<Role> listRoles() {
		return roleDao.findAll();
	}
}
