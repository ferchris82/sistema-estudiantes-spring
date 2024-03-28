package chrisferdev.estudiantes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import chrisferdev.estudiantes.model.Estudiante;

public interface EstudianteRepositorio extends JpaRepository<Estudiante, Integer>{
    
}
