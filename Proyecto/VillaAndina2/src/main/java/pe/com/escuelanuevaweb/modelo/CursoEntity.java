
package pe.com.escuelanuevaweb.modelo;
//utilizamos la anotacion de Lombok

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//@Builder te permite generar la construccion de la clase
@Builder
//@AllArgsConstructor te permite generar el metodo constructo con parametros
@AllArgsConstructor
//@NoArgsConstructor te permite generar el metodo constructor sin parametros
@NoArgsConstructor
//@Data te permite generar los metodos get y set
@Data
//@Entity define la entidad con la que se va a trabajar
@Entity(name="CursoEntity")
//@Table define el nombre de la tabla con la cual se va a trabajar
@Table(name="Curso")
//se tiene que serializar la clase
public class CursoEntity implements Serializable {
    //agregamos el id de serializacion
    private static final long serialVersionUID=1L;
    //agregamos los atributos
    //@Id define la clave primaria
    @Id
    //define la columa de la tabla con la cual se va a relacionar
    @Column(name="codcur")
    //@GeneratedValue permite definir el modo de autoincremento
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    @Column(name="nomcur")
    private String nombre;
    @Column(name="horcur")
    private int hora;
    @Column(name="crecur")
    private double credito;
    @Column(name="estcur")
    private boolean estado;    
}
