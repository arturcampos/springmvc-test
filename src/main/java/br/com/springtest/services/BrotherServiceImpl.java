package br.com.springtest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.springtest.daos.BrotherDAO;
import br.com.springtest.models.Brother​;

@Service("brotherService")
public class BrotherServiceImpl implements BrotherService {
	
	@Autowired
	private BrotherDAO brotherDao;
	
	public List<Brother​> listBrothers() {
		return brotherDao.findAll();
	}

}
