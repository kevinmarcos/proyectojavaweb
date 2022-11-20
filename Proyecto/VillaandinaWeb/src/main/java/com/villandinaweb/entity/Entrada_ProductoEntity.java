/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
@Entity(name="Entrada_ProductoEntity")
@Table(name="Entrada_Producto")
public class Entrada_ProductoEntity implements Serializable{
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codentrada")
    @NotNull
    private long codigo;
    
    @Column(name="fechaentrada")
    @NotNull
    private String fecha;
    
    @Column(name="estado")
    @NotNull
    private boolean estado;

   
    @ManyToOne  
    @JoinColumn(name="codempleado" ,nullable = false)
    private EmpleadoEntity empleado;
}
