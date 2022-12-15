
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
@Entity(name="DestinoEntity")
@Table(name="Destino")
public class DestinoEntity implements Serializable{
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="coddestino")

    private long codigo;
    
    @Column(name="nomdestino")

    private String nombre;
    
    @Column(name="estado")
    
    private boolean estado;
    
    //@ManyToOne define la relacion de muchos a uno
    @ManyToOne
    
    //@JoinColumn define el campo que genera la clave foranea
    @JoinColumn(name="coddistrito" ,nullable = false)
    private DistritoEntity distrito;
}
