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
@Entity(name="Detalle_SalidaEntity")
@Table(name="Detalle_Salida")

public class Detalle_SalidaEntity implements Serializable{
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name="codDetalle_Salida")
    @NotNull
    private long codigo;
    
    @Column(name="cantidad")
    @NotNull
    private int cantidad;
    
    @Column(name="estado")
    @NotNull
    private boolean estado;
    

    @ManyToOne
    @JoinColumn(name="codProd" ,nullable = false)
    private ProductosEntity productos;
    
    @ManyToOne
    @JoinColumn(name="codSalida" ,nullable = false)
    private Salida_ProductoEntity salida_producto;
}
