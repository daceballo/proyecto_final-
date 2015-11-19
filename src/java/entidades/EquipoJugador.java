/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marcela
 */
@Entity
@Table(name = "equipo_jugador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EquipoJugador.findAll", query = "SELECT e FROM EquipoJugador e"),
    @NamedQuery(name = "EquipoJugador.findByIdEquipoJugador", query = "SELECT e FROM EquipoJugador e WHERE e.idEquipoJugador = :idEquipoJugador")})
public class EquipoJugador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_equipo_jugador")
    private Integer idEquipoJugador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipoJugador")
    private List<Gol> golList;
    @JoinColumn(name = "idjugador", referencedColumnName = "idjugador")
    @ManyToOne(optional = false)
    private Jugador idjugador;
    @JoinColumn(name = "idequipo", referencedColumnName = "idequipo")
    @ManyToOne(optional = false)
    private Equipo idequipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEquipoJugado")
    private List<Sancion> sancionList;

    public EquipoJugador() {
    }

    public EquipoJugador(Integer idEquipoJugador) {
        this.idEquipoJugador = idEquipoJugador;
    }

    public Integer getIdEquipoJugador() {
        return idEquipoJugador;
    }

    public void setIdEquipoJugador(Integer idEquipoJugador) {
        this.idEquipoJugador = idEquipoJugador;
    }

    @XmlTransient
    public List<Gol> getGolList() {
        return golList;
    }

    public void setGolList(List<Gol> golList) {
        this.golList = golList;
    }

    public Jugador getIdjugador() {
        return idjugador;
    }

    public void setIdjugador(Jugador idjugador) {
        this.idjugador = idjugador;
    }

    public Equipo getIdequipo() {
        return idequipo;
    }

    public void setIdequipo(Equipo idequipo) {
        this.idequipo = idequipo;
    }

    @XmlTransient
    public List<Sancion> getSancionList() {
        return sancionList;
    }

    public void setSancionList(List<Sancion> sancionList) {
        this.sancionList = sancionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEquipoJugador != null ? idEquipoJugador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EquipoJugador)) {
            return false;
        }
        EquipoJugador other = (EquipoJugador) object;
        if ((this.idEquipoJugador == null && other.idEquipoJugador != null) || (this.idEquipoJugador != null && !this.idEquipoJugador.equals(other.idEquipoJugador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.EquipoJugador[ idEquipoJugador=" + idEquipoJugador + " ]";
    }
    
}
