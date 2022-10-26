
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
@Entity(name="EmpleadoEntity")
@Table(name="Empleado")
public class EmpleadoEntity implements Serializable{
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codemple")
    @NotNull
    private long codigo;
    
    @Column(name="dni")
    @NotNull
    private String dni;
    
    @Column(name="nomemple")
    @NotNull
    private String nombre;
    
    @Column(name="apellidPat")
    @NotNull
    private String apellidopaterno;
    
    @Column(name="apellidMat")
    @NotNull
    private String apellidomaterno;
    
    @Column(name="telfemple")
    @NotNull
    private String telefono;
    
    @Column(name="correoemple")
    @NotNull
    private String correo;
    
    @Column(name="sexemple")
    @NotNull
    private String sexo;
    
    @Column(name="direccion")
    @NotNull
    private String direccion;
    
    @Column(name="estado")
    @NotNull
    private boolean estado;
    
    //@ManyToOne define la relacion de muchos a uno
    @ManyToOne
    
    //@JoinColumn define el campo que genera la clave foranea
    @JoinColumn(name="coddistritoemple" ,nullable = false)
    private DistritoEntity distrito;
}
