
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
@Entity(name="ProveedoresEntity")
@Table(name="Proveedores")
public class ProveedoresEntity implements Serializable{
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codprov")
    @NotNull
    private long codigo;
    
    @Column(name="rucprov")
    @NotNull
    private String ruc;
    
    @Column(name="nombprov")
    @NotNull
    private String nombre;
    
    @Column(name="direccionProv")
    @NotNull
    private String direccion;
    
    @Column(name="correoprov")
    @NotNull
    private String correo;
    
    @Column(name="telefprov")
    @NotNull
    private int telefono;
    
    @Column(name="estprove")
    @NotNull
    private boolean estado;

}
