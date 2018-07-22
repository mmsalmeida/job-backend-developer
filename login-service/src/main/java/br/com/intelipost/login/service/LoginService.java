package br.com.intelipost.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.intelipost.login.repository.UserRepository;
@Service
public class LoginService {

	@Autowired
	private UserRepository repositoryLogin;
	
	public boolean validaLogin(String login,String password) {
		
	return	repositoryLogin.findByLoginAndPassword(login, password).isPresent();
		
	}
}
