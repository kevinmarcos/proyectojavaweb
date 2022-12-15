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
@Entity(name = "CarreraEntity")
@Table(name = "Carrera")
public class CarreraEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "codcar")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    @Column(name = "nomcar")
    private String nombre;
    @Column(name = "durcar")
    private String duracion;
    @Column(name = "ciccar")
    private String ciclo;
    @Column(name = "turcar")
    private String turno;
    @Column(name = "estcar")
    private boolean estado;
    //@ManyToOne define la relacion de muchos a uni
    @ManyToOne
    //@JoinColumn define el campo que genera la clave foranea
    @JoinColumn(name = "codcur", nullable = false)
    private CursoEntity curso;
}
