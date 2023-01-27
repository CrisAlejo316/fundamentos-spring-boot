package com.fundamentosplatzi.springboot.fundamentos.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.fundamentosplatzi.springboot.fundamentos.entity.User;
import com.fundamentosplatzi.springboot.fundamentos.repository.UserRepository;

@Service // se le agrega la anotación @service
public class UserService {
	private final Log LOG = LogFactory.getLog(UserService.class);
	
	//se inyecta la dependencia de UserRepository para hacer registros y obtener información de base de Datos 
	private UserRepository userRepository;
	
	// generamos constructor a nivel de la dependencia
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Transactional 
	// se crea un metodo para guardar información
	public void saveTransactional(List<User>users) {// dentro de los parentesis va a recibir una lista de tipo user
		//esta lista que tiene como nombre users 
		users.stream() // por cada stream se hace un peek
		.peek(User ->LOG.info("Usuario insertado" + User)) // este peek sirve para mostrar en pantalla lo que vengo registrando
		.forEach(userRepository::save); // con los :: estamos llamando a la entity que viene siendo User en pocas palabras, es la clase que contiene las propiedades de una tabla de bases de datos
		//.forEach(User -> userRepository.save(User))
	}
	
	//este metodo va a devolver una lista de usuarios
	public List<User> getAllUsers(){
		//se llamara esta lista a nivel de userRepository
		return userRepository.findAll();// la dependencia userRepository tiene un metodo que se llama findAll y este metodo va a retribuir todos los usuarios en una lista
	}

	
	//se crea metodo con el nombre save que dentro de los parentesis recibira un usuarios de tipo User osea la entity
	public User save(User newUser1) {
		
		return userRepository.save(newUser1);// con esto registramos en base de datos
	}

	//se crea metodo con el nombre delete que dentro de los parentesis recibira un id de tipo Long 
	public void delete(Long id) { 
		
		/*Si este metodo tuviera en ves de void un User lo que se hara es retornar un id por la entity User, que es lo que se haria en la linea 54 y 55*/
		//Optional<User> usuario = userRepository.findById(id); //se crea un optional con el nombre de la entity, se le coloca un nombre = se llama a la dependencia y se coloca el metodo de findById(id)
		//User usuarioEntity = usuario.get(); // se coloca la entity User se le asgina un nombre = se llama al optional y se obtiene por medio del get()
		
		userRepository.deleteById(id); //llamamos a la dependencia y colocamos elmetodo deleteById(id)
		
	}
	
    //se crea metodo con el nombre update que dentro de los parentesis recibira un newUser1 de tipo User y un id de tipo Long
	public User update(User newUser1, Long id) {
		
		return userRepository.findById(id) // utilizamos el metodo findById y dentro de los () enviamos como parametro el id, en caso de que se encuentre se hace un Map
		
		//este map se utiliza para mapear el usuario encontrado, con ese user encontrado se va a stear u obtener el email, birthdate y name y eso se hacw con el newUser1 que se recibe como parametro
		.map(
				 user -> {
					 user.setEmail(newUser1.getEmail());
					 user.setBirthDate(newUser1.getBirthDate());
					 user.setNameUser(newUser1.getNameUser());
					 //retornamos de userRepository y vamos  a guardar con save lo que ya se tiene mapeada
					 return userRepository.save(user);
				 }
				).orElseThrow(()->new RuntimeException("Usuario no encontrado")); // este orElseThrow se utiliza para uan exception en un .map
		
		
	}
	
	
}
