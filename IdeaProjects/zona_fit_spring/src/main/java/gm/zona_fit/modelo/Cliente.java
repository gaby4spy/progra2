package gm.zona_fit.modelo;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jdk.jfr.Name;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private  String apellido;
    private Integer membresia;

    /*la razon de por que usamos Integer y no el primitivo
    * int es porque si hay ausencia de valor este atributo sera
    * igual a null por lo que sera mas facil trabajar */


}
