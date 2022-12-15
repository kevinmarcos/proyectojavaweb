
package com.villandinaweb.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//utilizamos la anotacion de Lombok

//@Builder permite generar la construccion de la clase
@Builder

//@AllArgsConstructor te permite generar el metodo constructor con parametros
@AllArgsConstructor

//@NoArgsConstructor te permite generar el metodo constructor sin parametros
@NoArgsConstructor

//@Data te permite generar los metodos get y set
@Data

//@Entity define la entodad con la que se va a trabajar
@Entity(name="CategoriaEntity")

@Table(name="Categoria")
public class CategoriaEntity implements Serializable{
    //Agregamos el id de la serializacion
    private static final long serialVersionUID=1L;
    //Agregando los atributos
    
    //@Id define la clave primaria
    @Id
    
    //@GeneratedValue permite definir el modo de autoincremento
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column define la columna de la tabla con la cual se va a relacionar
    @Column(name="codcat")
    private long codigo;
    @Column(name="nomcat")

    private String nombre;
    @Column(name="estado")

    private boolean estado;
}
