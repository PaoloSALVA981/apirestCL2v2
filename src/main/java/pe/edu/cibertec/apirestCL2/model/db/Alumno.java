package pe.edu.cibertec.apirestCL2.model.db;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "alumno")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idalumno;
    @Column(name = "apealumno")
    private String apealumno;
    @Column(name = "nomalumno")
    private String nomalumno;
    @Column(name = "idesp")
    private Integer idesp;
    @Column(name = "proce")
    private Integer proce;

    @ManyToOne
    @JoinColumn(name = "idesp")
    private Especialidad especialidad;
}
