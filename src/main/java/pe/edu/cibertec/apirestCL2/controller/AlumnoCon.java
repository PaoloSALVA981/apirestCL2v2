package pe.edu.cibertec.apirestCL2.controller;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.apirestCL2.model.db.Alumno;
import pe.edu.cibertec.apirestCL2.repository.AlumnoRepo;
import pe.edu.cibertec.apirestCL2.service.AlumnoServ;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="api/v1/alumno")
public class AlumnoCon {

    @Autowired
    private AlumnoServ alumnoServ ;

    @GetMapping("")
    public ResponseEntity<List<Alumno>> listaralumnos(){
        List<Alumno> alumnoList = new ArrayList<>();
        alumnoServ.listarAlumno().forEach(alumnoList::add);
        if(alumnoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);


        }
        return new ResponseEntity<>(alumnoList,HttpStatus.OK);

    }
@GetMapping("/{id}")
public ResponseEntity<Alumno> obteneralumnoxid(@PathVariable("id")Integer id){

        return new ResponseEntity<>(alumnoServ.buscarAlumnoxId(id).get(),HttpStatus.OK);




}
@PostMapping ("")
    public  ResponseEntity<Alumno> crearealumno(@RequestBody Alumno alumno){
    Alumno newAlumno = new Alumno();
    newAlumno.setApealumno(alumno.getApealumno());
        return new ResponseEntity<>(alumnoServ.registar(newAlumno),HttpStatus.CREATED);


}
    @PutMapping ("/{id}")
    public  ResponseEntity<Alumno> actualizaralumno(@PathVariable("id") Integer id ,
                                                    @RequestBody Alumno alumno){
        Alumno oldAlumno = alumnoServ.buscarAlumnoxId(id).get();
        oldAlumno.setApealumno(alumno.getApealumno());
        return new ResponseEntity<>(alumnoServ.registar(oldAlumno),HttpStatus.CREATED);






    }
@DeleteMapping("/{id}")

public  ResponseEntity<?> eliminaralumno(@PathVariable("id")Integer id){


        return  ResponseEntity.status(HttpStatus.OK)
                .body(alumnoServ.eliminarxId(id));

}









}
