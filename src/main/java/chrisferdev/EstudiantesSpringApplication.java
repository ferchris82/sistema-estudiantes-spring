package chrisferdev;

import chrisferdev.estudiantes.model.Estudiante;
import chrisferdev.estudiantes.service.EstudianteServicio;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class EstudiantesSpringApplication implements CommandLineRunner{

	@Autowired
	private EstudianteServicio estudianteServicio;

	private static final Logger logger = LoggerFactory.getLogger(EstudiantesSpringApplication.class);

	String nl = System.lineSeparator();

	public static void main(String[] args) {
		logger.info("Iniciando la aplicacion...");
		// Levantar la fabrica de Spring
		SpringApplication.run(EstudiantesSpringApplication.class, args);
		logger.info("Aplicacion finalizada!");
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info(nl + "Ejecutando metodo run de Spring..." + nl);
		var salir = false;
		var consola = new Scanner(System.in);
		while (!salir) {
			mostrarMenu();
			salir = ejecutarOpciones(consola);
			logger.info(nl);
		} // fin while
	}

	private void mostrarMenu(){
		logger.info(nl);
		logger.info("""
			*** Sistema de Estudiantes ***
			1. Listar Estudiantes
			2. Buscar Estudiante
			3. Agregar Estudiante
			4. Modificar Estudiante
			5. Eliminar Estudiante
			6. Salir
			Elige una opcion:""");
	}

	private boolean ejecutarOpciones(Scanner consola){
		var opcion = Integer.parseInt(consola.nextLine());
		var salir = false;
		switch(opcion){
			case 1->{ // Listar estudiantes
				logger.info(nl + "Listado de Estudiantes: " + nl);
				List<Estudiante> estudiantes = estudianteServicio.listarEstudiantes();
				estudiantes.forEach((estudiante -> logger.info(estudiante.toString() + nl)));
			}
		} // Fin switch
		return salir;
	}
}
