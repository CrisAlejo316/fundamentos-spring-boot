package com.fundamentosplatzi.springboot.fundamentos;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
//import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.annotation.UserConfigurations;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Sort;

import com.fundamentosplatzi.springboot.fundamentos.bean.MyBean;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithDependency;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentosplatzi.springboot.fundamentos.component.ComponentDependency;
import com.fundamentosplatzi.springboot.fundamentos.entity.User;
import com.fundamentosplatzi.springboot.fundamentos.pojo.UserPojo;
import com.fundamentosplatzi.springboot.fundamentos.repository.UserRepository;
import com.fundamentosplatzi.springboot.fundamentos.service.UserService;



@SpringBootApplication
//@ComponentScan({"com.fundamentosplatzi.springboot.fundamentos"})

public class FundamentosApplication implements CommandLineRunner // utiliza la interfaz de CommandLineRunner
{

	
	// llamar a la clase log para hacer uso del level error:
	private final Log LOGGER =LogFactory.getLog(FundamentosApplication.class);
	
	// llamaremos a nuestra dependencia u objeto en este caso es la interfaz ComponentDependency para inyectarla 
	private ComponentDependency componentDependency; // se le coloca el nombre del objeto componentDependency pero la primera letra en minuscula
	// llamaremos a nuestra dependencia u objeto en este caso es la interfaz MyBean para inyectarla
	private MyBean myBean; // se le coloca el nombre del objeto myBean pero la primera letra en minuscula
	// llamaremos a nuestra dependencia u objeto en este caso es la interfaz MyBeanWithDependency para inyectarla
	private MyBeanWithDependency myBeanWithDependency; // se le coloca el nombre del objeto myBeanWithDependency pero la primera letra en minuscula
	// llamaremos a nuestra dependencia u objeto en este caso es la interfaz MyBeanWithProperties para inyectarla
	private MyBeanWithProperties myBeanWithProperties; // se le coloca el nombre del objeto myBeanWithProperties pero la primera letra en minuscula
	// llamaremos a nuestra dependencia u objeto en este caso es la class UserPojo para inyectarla
	private UserPojo userPojo; // se le coloca el nombre del objeto userPojo pero la primera letra en minuscula
	// llamamos a nuestro Repository en este caso es la dependencia UserRepository 
	private UserRepository userRepository;
	// llamamos a nuestra Service en este caso es la dependencia UserService
	private UserService userService;

	
	
	//@Autowired // inyeccion de dependencia en este caso es el nombre de la interfaz
	// @Qualifier es una anotación que sirve para especificar el tipo de dependencia que se esta inyectando, en este caso si queremos ver lo que tiene la depedencia de la clase ComponentTwoImplement se utiliza @Qualifier ("nombre de la clase pero la primera letra en minuscula"), o en este caso si queremos ver lo que tiene la depedencia de la clase ComponentImplement se utiliza @Qualifier ("nombre de la clase pero la primera letra en minuscula"), o en este caso si queremos ver lo que tiene la depedencia de la clase ComponentTwoImplement se utiliza @Qualifier ("nombre de la clase pero la primera letra en minuscula"), o en otro caso si queremos ver lo que tiene la depedencia de la clase ComponentTwoImplement se utiliza @Qualifier ("nombre de la clase pero la primera letra en minuscula") y por ultimopara ver la otra dependencia en este caso si queremos ver lo que tiene la depedencia de la clase ComponentTwoImplement se utiliza @Qualifier ("nombre de la clase pero la primera letra en minuscula"), o en este caso si queremos ver lo que tiene la depedencia de la clase MyBeanImplement se utiliza @Qualifier ("nombre de la clase pero la primera letra en minuscula")
	//Creacion del constructor de la clase  FundamentosApplication
	public FundamentosApplication(@Qualifier ("componentImplement") ComponentDependency componentDependency, @Qualifier("myBeanImplement") MyBean myBean, MyBeanWithDependency myBeanWithDependency, MyBeanWithProperties myBeanWithProperties, UserPojo userPojo, UserRepository userRepository, UserService userService) // recibe como parametro mi Dependencia para poder inyectar y tambien recibe el parametro MyBean para inyectar 
	{
		this.componentDependency=componentDependency; // se le asigna un valor al nombre del objeto
		this.myBean=myBean; // se le asigna un valor al nombre del objeto
		this.myBeanWithDependency=myBeanWithDependency; // se le asigna un valor al nombre del objeto
		this.myBeanWithProperties=myBeanWithProperties; // se le asgina un valor al nombre del objeto
		this.userPojo=userPojo; // se le asgina un valor al nombre del objeto
		this.userRepository=userRepository; // se le asigna un valor al nombre del objeto
		this.userService=userService;// se le asigna un valor al nombre del objeto
	}
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	
	}
	
	// implementa el metodo run de la interfaz CommandLineRunner 
	@Override
	public void run(String... args) throws Exception // este metodo lo que hara es ejecutar en la aplicación todo lo que nosotros queramos, en este caso de nuestra dependecia 
	{
		// en este metodo run llamamos al metodo ejemploAnteriores, saveUsersInDataBase(), getInformationJpqlFromUser()
		//ejemploAnteriores();
		saveUsersInDataBase();
		getInformationJpqlFromUser();
		saveWithErrorTransactional();
	
		
	}
	
	// se crea un metodo que contenga la información de los ejemplos anteriores
	private void ejemploAnteriores()

	{
		componentDependency.saludar(); // llamamos a nuestra dependencia y luego implementa a nuestro metodo void saludar();
		myBean.print(); // llamamos a nuestra dependencia y luego implementa a nuestro metodo void print();
		myBeanWithDependency.printWithDependency(); // llamamos a nuestra dependencia y luego implementa a nuestro metodo void printWithDependency()
		System.out.println(myBeanWithProperties.function()); // llamamos a nuestra dependencia y luego implementa a nuestro metodo void function(), se utilizamos un sysout para imprimir lo que devuelve que es tipo String
		System.out.println(userPojo.getEmail() + "-" + "-" + userPojo.getPassword());
		try {
			//ocurrir un error
			int value=10/0; // error relacionado con la division entre 0
			LOGGER.debug("Mi valor es: " + value);//muestra un info en caso a este debug no se llega ya que value muestra un error y es que no se puede dividir entre cero
		}catch(Exception e) // dentro de los parentesis se captura el error, en este caso el error a capturar es el de la variable value
		{
			//muestra el error
			LOGGER.error("Esto es un error al dividir por 0" + e.getMessage()); // llamamos al objeto creado LOGGER y luego al level que es en este caso error ("mensaje de parametro" + e.getMessage()); lo que hace esa e, es el nombre de la excepcion y luego se le agrega el (get.Message) mensaje de la exception 
		}
		LOGGER.error("Esto es un error del aplicativo"); // llamamos al objeto creado LOGGER y luego al level que es en este caso error ("mensaje de parametro");

	}
	
	
	
	//se crea un metodo tipo transactional este metodo guardara los transactional de la clase UserService
	private void saveWithErrorTransactional() {
		/*se inicializaran unos objetos de tipo User*/
		User test1= new User("TestTransactiona1", "TestTransactional1@domain.com", LocalDate.now());
		User test2= new User("TestTransactiona2", "TestTransactional2@domain.com", LocalDate.now());
		User test3= new User("TestTransactiona3", "TestTransactional3@domain.com", LocalDate.now());
		User test4= new User("TestTransactiona4", "TestTransactional4@domain.com", LocalDate.now());
		User test5= new User("TestTransactiona5", "TestTransactional5@domain.com", LocalDate.now());
		
		//creamos una lista con la clase User y le colocamos de nombre a la lista usuarios
		List<User> usuarios = Arrays.asList(test1,test2,test3,test4,test5);
		
		try
		{
			//registar a nuestros usuarios con el metodo transactional
			userService.saveTransactional(usuarios);// con esta sentencia registra usuario por usuario del metodo saveWithErrorTransactional, hasta encontrar un error y hay ya los demas usuarios que habian sido registrados no se muestran en la base de datos de la consola porque ocurrio un error 
			
		}catch(Exception e) {
			
			LOGGER.error("Esto es una exception dentro del metodo transactional" + e);
		}
		
		
		//llamamos a nuestro metodo de getAllUsers, y con ese metodo retribuimos todos nuestros usuarios
		userService.getAllUsers()
		.stream()
		.forEach(User -> LOGGER.info("Este es el usuario dentro del metodo transaccional" +User));
	}
   
	
	// se crea un metodo que contendra los query que estan creado en la dependencia UserRepository
	private void getInformationJpqlFromUser()
	{
		
		// se llama al objeto de la interfaz o dependencia userRepository y llamamos al metodo  findByUserEmail
		LOGGER.info(" El usuario con el metodo findByUserEmail" 
		+ userRepository.findByUserEmail("Zamira9@gmail.com") // dentro de las comillas se coloca el email a encontrar que esta dentro del metodo saveUsersInDataBase(), y se va a impirmir dentro de un logger info
		.orElseThrow(()-> new RuntimeException("No se encontro el usuario"))); // se utiliza este parametro cuando no se encuentra, dentro de los () se utiliza una excepccion
		
		// me muestra los usuarios con el nombre user y además por el id comienza a descender
		userRepository.findAndSortUsers("Valen", Sort.by("id").descending()) // dentro de las comillas se va a colocar un nombre de usuario sin ser alguno en especifico, por ende se colocar find y con sort es para ordenar, en este caso se ordena por id pero descendiente
		.stream()
		.forEach(User -> LOGGER.info("El usuario con metodo sort"+User));
		
		//se llama al Query methods y encuentra el nombre del usuario 
		userRepository.findByName("Fabian") // dentro de las comillas dobles se coloca el nombre a encontrar
		.stream()
		.forEach(User-> LOGGER.info("El usuario con query methods"+User));
		
		//se llama al Query methods y encuentra el nombre del usuario y el correo 
		LOGGER.info("El usuario con query methods findByEmailAndUser"
		+ userRepository.findByEmailAndUser("Manuela6@gmail.com", "Manuela")
		.orElseThrow(()-> new RuntimeException("Usuario no encontrado")));
		
		
		//se llama el primer Query methods y encuentra el nombre del usuario
		userRepository.findByNameUserLike("%m%") // encontramos a los usuarios con esas iniciales 
		.stream()
		.forEach(User -> LOGGER.info("El usuario findByNameUserLike del primer Query methods"+User));
		
		//se llama la segunda Query methods y encontrar por el nombre del usuario y correo
		userRepository.findByNameUserAndEmail("Nathalia", "Nathalia5@gmail.com") //primero vamos a colocar un null en el nombre para que solo lo busque por el correo
		.stream()
		.forEach(User -> LOGGER.info("El usuario findByNameUserAndEmail del segundo query methods" + User));
		
		//se llama la tercera Query methods y encontrar o por el nombre del usuario o correo
		userRepository.findByNameUserOrEmail(null,"FabianYU3@gmail.com")
		.stream()
		.forEach(User -> LOGGER.info("El usuario con findByNameUserOrEmail del tercero query methods"+ User));
		
		
		//se llama la cuarta Query methods y encontrar por fecha desde inicio hasta el final
		userRepository.findByBirthDateBetween(LocalDate.of(2021, 2, 7), LocalDate.of(2021, 12, 20))
		.stream()
		.forEach(User -> LOGGER.info("Usuario con intervalo de fecha:"+User));
		
		//se llama la quinta Query methods y encontrar por el nombre, sea una letra o una vocal
		userRepository.findByNameUserLikeOrderByIdDesc("%e%")
		.stream()
		.forEach(User -> LOGGER.info("Usuario encontrado con like y ordenado"+User));
		
		//se llama la sexta Query methods y encontrar por el nombre
		userRepository.findByNameUserContainingOrderByIdDesc("Cami")
		.stream()
		.forEach(User -> LOGGER.info("Usuario encontrado con findByNameUserContainingOrderByIdDesc y ordenado descendiente" + User));
		
		
		//se llama al metodo getAllByBirthDateAndEmail de la interfaz UserRepository
		LOGGER.info("El usuario a partir del named parameter" +  userRepository.getAllByBirthDateAndEmail(LocalDate.of(2022, 4, 26),"Zamira9@gmail.com")// se utilizara como ejemplo un correo y una fecha de la base de datos saveUsersInDataBase
		.orElseThrow(()-> new RuntimeException("No se encontro el usuario a partir del named parameter")));
		
	}
	
	
	
	// crearemos un metodo para persistir la información
	private void saveUsersInDataBase(){
		
		// en este metodo vamos a registrar la información
		
		// se crea el objeto de la clase User y se le hace una instancia a partir de la constructor
		User user1 = new User("Valentina", "Valentina1@gmail.com", LocalDate.of(2023, 01, 12)); 
		User user2 = new User("Camilo", "Camilotr2@gmail.com", LocalDate.of(2021, 02, 10)); 
		User user3 = new User("Fabian", "FabianYU3@gmail.com", LocalDate.of(2020, 03, 11));
		User user4 = new User("Camila", "Camila4@gmail.com", LocalDate.of(2021, 11, 06));
		User user5 = new User("Nathalia", "Nathalia5@gmail.com", LocalDate.of(2020, 05, 15)); 
		User user6 = new User("Manuela", "Manuela6@gmail.com", LocalDate.of(2022, 8, 22)); 
		User user7 = new User("Lorena", "lorena.7@gmail.com", LocalDate.of(2021, 07, 21)); 
		User user8 = new User("Salome", "Salome8@gmail.com", LocalDate.of(2023, 9, 24)); 
		User user9 = new User("Zamira", "Zamira9@gmail.com", LocalDate.of(2022, 4, 26)); 
		User user10 = new User("Daniela", "Daniela10@gmail.com", LocalDate.of(2021, 11, 28)); 
		User user11 = new User("Valentino", "Valentino11@gmail.com", LocalDate.of(2022, 10, 31)); 
		User user12 = new User("Pastor", "Pastor12@gmail.com", LocalDate.of(2023, 11, 30));
		
		// se creara una lista de los usuarios para poder hacer el registro rapidamente
		java.util.List<User> listUsers = Arrays.asList(user1,user2,user3,user4,user5,user6,user7,user8,user9,user10,user11,user12);
		// de la siguiente manera se registra la información
		listUsers.stream().forEach(userRepository :: save); // se utiliza el nombre de la lista y se utiliza el metodo stream y se llama a un forEach(nombre del objeto de la dependencia o intrfaz :: save=guardar)
		
	}
	
	
	
}
