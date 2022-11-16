
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
@Entity(name="Detalle_EntradaEntity")
@Table(name="Detalle_Entrada")
public class Detalle_EntradaEntity implements Serializable{
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codDetalle_Entrada")
    @NotNull
    private long codigo;
    
    @Column(name="cantidad")
    @NotNull
    private String cantidad;
    
    @Column(name="estado")
    @NotNull
    private boolean estado;
    
    //@ManyToOne define la relacion de muchos a uno
    @ManyToOne
    
    //@JoinColumn define el campo que genera la clave foranea
    @JoinColumn(name="codEntrada" ,nullable = false)
    private Entrada_ProductoEntity entrada_producto;
    
    @JoinColumn(name="coddest" ,nullable = false)  
    @ManyToOne
    private DestinoEntity destino;
    
    @ManyToOne
    @JoinColumn(name="codProv" ,nullable = false)
    private ProveedoresEntity proveedores;
}