
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
@Entity(name="ProductosEntity")
@Table(name="Productos")
public class ProductosEntity implements Serializable{
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codprod")
    
    private long codigo;
    
    @Column(name="nomprod")
    
    private String nombre;
    
    @Column(name="duraprod")
    
    private String duracion;
    
    @Column(name="cantidad")
    
    private int cantidad;
    
    @Column(name="estprod")
    
    private boolean estado;

    @ManyToOne  
    @JoinColumn(name="catprod" ,nullable = false)
    private CategoriaEntity categoria;

}
