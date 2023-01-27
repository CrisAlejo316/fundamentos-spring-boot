package com.fundamentosplatzi.springboot.fundamentos.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository; // este stereotype, lo utilizaremos para inyectar esta interfaz como dependencia 

import com.fundamentosplatzi.springboot.fundamentos.dto.UserDto;
import com.fundamentosplatzi.springboot.fundamentos.entity.User;

@Repository

public interface UserRepository extends JpaRepository<User, Long>{// con JpaRepository se crea herencia hacia la interfaz UserRepository
	
	
	@Query("Select u from User u WHERE u.email=?1") // se crea esta anotacion @Query("") que es una consulta, ,dentro de las comillas se le agrega la consulta JPQL, ya que se va a trabajar a partir de objetos, no apartir de tablas, u significa apodo, email=?1 significa que recibe un parametro que es el que esta en el optional
    // se crea un metodo y nos va a devolver un opcional, para hacer mejor uso de los null
	Optional<User> findByUserEmail(String email);
	
	@Query("Select u from User u WHERE u.nameUser like ?1%") // se utiliza like para buscar y ordenar de alguna manera un nombre de una lista de usuario
	// se crea un metodo y nos va a devolver una list, con Sort es para ordernar
	List<User> findAndSortUsers (String nameUser, Sort sort); // en este caso se crea un metodo list y se le asigna un nombre como es findAndSort (tipo de dato + variable de la clase user, Sort + nombre de ese objeto que es sort) 
	
	@Query("Select u from User u WHERE u.nameUser like ?1%")
	//Se crea un Query methods, donde se creara una lista y esta lista va a encontrar por el nombre
	List<User> findByName (String nameUser);
	
	@Query("Select u from User u WHERE u.email=?1")
	//Se crea un Query methods, donde se creara un opcional, y va a devolver un solo usuario como dato, tendra su nombre y su email
	Optional<User> findByEmailAndUser(String email, String nameUser);
	
	
	
	// Creación de los Query methods
	
	// creación del primer Query methods con otra sentencia
	//Se crea un Query methods, donde se creara una lista y esta lista se va a encontrar por el nombre
	List<User> findByNameUserLike (String nameUser);
	
	
	// creación del segundo Query methods con la sentencia And
	//Se crea un Query methods, donde se creara una lista y esta lista va a encontrar por el nombre y por el email
	List<User> findByNameUserAndEmail(String nameUser, String email);
	
	
	// creación del tercer Query methods con la sentencia Or
	//Se crea un Query methods, donde se creara una lista y esta lista va a encontrar por el nombre o por el email
	List<User> findByNameUserOrEmail(String nameUser,String email);
	
	
	//creación de la cuarta Query methods con la sentencia Between
	// Se crea un Query methods que encuentre informacion a partir de un intervalo de fecha, que es la fecha mapiada en la entidad
	List<User> findByBirthDateBetween(LocalDate begin, LocalDate end); // LocalDate bengin es la fecha desde que inicia hasta LocalDate end que es hasta que termine
	
	
	//creación de la quinta Query methods con la sentencia OrderBy
	//se crea un Query mthods que encuentre a apartir del nombre y vamos a ordenar el id de forma descendente 
	List<User>findByNameUserLikeOrderByIdDesc(String nameUser);
	
	
	//creacion de la sexta Query methods con la sentencia Containing
	//se crea un Query methods que encuentre a apartir del nombre y vamos a ordenar el id de forma descendente
	List<User>findByNameUserContainingOrderByIdDesc(String nameUser);
	
	
	//uso del named parameter
	@Query("Select new com.fundamentosplatzi.springboot.fundamentos.dto.UserDto(u.id, u.nameUser, u.birthDate)" + // en la sentencia vamos a utilizar nuesro Dto para representar los datos que vamos a retribuir de la base de datos, con u.id,u.nameUser,u.birthDate de esta forma se retribuye los registros en un los Dto  
	        " FROM User u" + // llamamos a la entidad de donde vamos a traer la información y se representa con una u, esta u traera los valores de la base de datos
			" where u.birthDate=:parametroFecha" + // se le asigna un nombre a birthDate
	        " and u.email=:parametroCorreo") //se le asigna un nombre a email
	//Devolvemos un optional de tipo UserDto que tiene como nombre getAllByBirthDateAndEmail 
	Optional<UserDto> getAllByBirthDateAndEmail(@Param("parametroFecha") LocalDate date, @Param("parametroCorreo") String email);
	
	
}
