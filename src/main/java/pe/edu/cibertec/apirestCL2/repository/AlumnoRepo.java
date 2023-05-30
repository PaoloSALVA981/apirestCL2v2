package pe.edu.cibertec.apirestCL2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.apirestCL2.model.db.Alumno;

@Repository
public interface AlumnoRepo extends JpaRepository
    <Alumno,Integer>{
}
