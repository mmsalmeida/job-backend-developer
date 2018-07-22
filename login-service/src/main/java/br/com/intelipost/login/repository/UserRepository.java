package br.com.intelipost.login.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.intelipost.login.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	Optional<User> findById(Long Id);
	
	Optional<User> findByLoginAndPassword(String login,String password);
}
