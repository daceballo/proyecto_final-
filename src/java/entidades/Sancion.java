/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marcela
 */
@Entity
@Table(name = "sancion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sancion.findAll", query = "SELECT s FROM Sancion s"),
    @NamedQuery(name = "Sancion.findByIdsancion", query = "SELECT s FROM Sancion s WHERE s.idsancion = :idsancion")})
public class Sancion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsancion")
    private Integer idsancion;
    @JoinColumn(name = "tipo_sancion", referencedColumnName = "idtipo_sancion")
    @ManyToOne(optional = false)
    private TipoSancion tipoSancion;
    @JoinColumn(name = "idpartido", referencedColumnName = "idpartido")
    @ManyToOne(optional = false)
    private Partido idpartido;
    @JoinColumn(name = "id_equipo_jugado", referencedColumnName = "id_equipo_jugador")
    @ManyToOne(optional = false)
    private EquipoJugador idEquipoJugado;

    public Sancion() {
    }

    public Sancion(Integer idsancion) {
        this.idsancion = idsancion;
    }

    public Integer getIdsancion() {
        return idsancion;
    }

    public void setIdsancion(Integer idsancion) {
        this.idsancion = idsancion;
    }

    public TipoSancion getTipoSancion() {
        return tipoSancion;
    }

    public void setTipoSancion(TipoSancion tipoSancion) {
        this.tipoSancion = tipoSancion;
    }

    public Partido getIdpartido() {
        return idpartido;
    }

    public void setIdpartido(Partido idpartido) {
        this.idpartido = idpartido;
    }

    public EquipoJugador getIdEquipoJugado() {
        return idEquipoJugado;
    }

    public void setIdEquipoJugado(EquipoJugador idEquipoJugado) {
        this.idEquipoJugado = idEquipoJugado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsancion != null ? idsancion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sancion)) {
            return false;
        }
        Sancion other = (Sancion) object;
        if ((this.idsancion == null && other.idsancion != null) || (this.idsancion != null && !this.idsancion.equals(other.idsancion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Sancion[ idsancion=" + idsancion + " ]";
    }
    
}
