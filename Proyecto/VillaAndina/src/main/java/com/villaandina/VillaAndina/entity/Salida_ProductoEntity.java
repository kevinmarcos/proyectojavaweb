
package com.villaandina.VillaAndina.entity;

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
@Entity(name="Salida_ProductoEntity")
@Table(name="Salida_Producto")
public class Salida_ProductoEntity {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codEntrada")
    private long entrada;
    @Column(name="cantprod")
    private int cantidad;
    @Column(name="fechaSalida")
    private String fecha;
    @Column(name="estSalida_Prod")
    private boolean estado;
    
    //@ManyToOne define la relacion de muchos a uno
    @ManyToOne
    
    //@JoinColumn define el campo que genera la clave foranea
    @JoinColumn(name="codprod" ,nullable = false)
    private ProductosEntity prodcutos;
}
