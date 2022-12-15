
package pe.com.escuelanuevaweb.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name="EmpleadoEntity")
@Table(name="Empleado")
public class EmpleadoEntity implements Serializable{
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codemple")
    
    private long codigo;
    
    @Column(name="dni")
    
    private String dni;
    
    @Column(name="nomemple")
    
    private String nombre;
    
    @Column(name="apellidpat")
    
    private String apellidopaterno;
    
    @Column(name="apellidmat")
    
    private String apellidomaterno;
    
    @Column(name="telfemple")
    
    private String telefono;
    
    @Column(name="correoemple")
    
    private String correo;
    
    @Column(name="sexemple")
    
    private String sexo;
    
    @Column(name="direccion")
    
    private String direccion;
    
    @Column(name="estado")
    
    private boolean estado;
    
    //@ManyToOne define la relacion de muchos a uno
    @ManyToOne
    
    //@JoinColumn define el campo que genera la clave foranea
    @JoinColumn(name="coddistritoemple" ,nullable = false)
    private DistritoEntity distrito;
}
