package br.com.intelipost.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.intelipost.login.dto.LoginDTO;
import br.com.intelipost.login.model.User;
import br.com.intelipost.login.repository.UserRepository;
import br.com.intelipost.login.service.LoginService;

@RestController
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	/*
	@GetMapping(value="/login/user/{Id}")
	public String login(@PathVariable String Id) {
		return repositoryLogin.findById(Long.valueOf(Id)).get().toString();
	}
	*/
	
	@PostMapping(value="/login")
	public String valida(@RequestBody LoginDTO loginInfo) {
		if (loginService.validaLogin(loginInfo.getLogin(),loginInfo.getPassword())) {
			return "Usuario Logado com Sucesso";
		} 
		else
		{	
			return " Usuario Invalido";
		}
		
	
		
	}
	
	
	
}
