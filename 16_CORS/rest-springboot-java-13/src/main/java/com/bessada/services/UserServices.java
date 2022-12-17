package com.bessada.services;


import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.stereotype.Service;
import com.bessada.controllers.BookController;
import com.bessada.data.vo.v1.PersonVO;
import com.bessada.exceptions.RequiredObjectIsNullException;
import com.bessada.exceptions.ResourceNotFoundException;
import com.bessada.mapper.DozerMapper;
import com.bessada.repository.UserRepository;

@Service
public class UserServices implements UserDetailsService {
	
	private Logger logger = Logger.getLogger(UserServices.class.getName());
	
	@Autowired
	UserRepository repository;
	
	public UserServices (UserRepository repository) { 
		this.repository = repository;
		
	};
		
/*
 * //injeção através do construtor se torna required (aplicação só roda se a instancia existir) (desrespeita o SOLID)
 *  através de atributo a aplicação sobe e a dependencia só é injetada quando existe a necessidade (respeita o SOLID)
 *  (possivel nullpointerexception quando for chamado e não existir a instância)
 *  https://spring.io/blog/2007/07/11/setter-injection-versus-constructor-injection-and-the-use-of-required
 *  https://reflectoring.io/constructor-injection/
 */
		

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("Finding one user by name" + username + "!");
		var user = repository.findByUsername(username);
		if (user != null) return user; 
		else throw new UsernameNotFoundException("Username " + username + " not found");
	}
}
	
