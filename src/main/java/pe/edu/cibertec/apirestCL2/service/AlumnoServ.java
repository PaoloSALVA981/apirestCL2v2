package pe.edu.cibertec.apirestCL2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.apirestCL2.model.db.Alumno;
import pe.edu.cibertec.apirestCL2.repository.AlumnoRepo;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class AlumnoServ {

    @Autowired
    private AlumnoRepo alumnoRepo;

    public List<Alumno> listarAlumno() {
        return alumnoRepo.findAll();

    }


    public Optional<Alumno> buscarAlumnoxId(Integer id) {

        Optional<Alumno> alumno = alumnoRepo.findById(id);

        if (alumno.isEmpty()) {
            return Optional.empty();


        } else {
            return alumno;
        }


    }

public Alumno registar(Alumno alumno){
        return alumnoRepo.save(alumno);

}


    public HashMap<String,String> eliminarxId(Integer id){
HashMap<String,String>respuesta=
        new HashMap<String,String>();
alumnoRepo.deleteById(id);
respuesta.put("mensaje","Elemento elimindado");
return respuesta;
    }
}