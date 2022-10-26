
package com.villaandina.VillaAndina.entity;

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
@Entity(name="ProveedoresEntity")
@Table(name="Proveedores")
public class ProveedoresEntity implements Serializable{
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codprov")
    private long codigo;
    @Column(name="nombprov")
    private String nombre;
    @Column(name="correoprov")
    private String correo;
    @Column(name="telefprov")
    private int telefono;
    @Column(name="estprove")
    private boolean estado;
    
    //@ManyToOne define la relacion de muchos a uno
    @ManyToOne
    
    //@JoinColumn define el campo que genera la clave foranea
    @JoinColumn(name="codubicprov" ,nullable = false)
    private DistritoEntity distrito;
}
