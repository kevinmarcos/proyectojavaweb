
package com.villandinaweb.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name="Salida_ProductoEntity")
@Table(name="Salida_Producto")
public class Salida_ProductoEntity implements Serializable{
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codSalida")
    @NotNull
    private long codigo;
    
    @Column(name="fechaSalida")
    @NotNull
    private String fecha;
    
    @Column(name="estado")
    @NotNull
    private boolean estado;
    
    @ManyToOne  
    @JoinColumn(name="codDestino" ,nullable = false)
    private DestinoEntity destino;
    
    @ManyToOne  
    @JoinColumn(name="codEmpleado" ,nullable = false)
    private EmpleadoEntity empleado;
}
