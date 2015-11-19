/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marcela
 */
@Entity
@Table(name = "partido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Partido.findAll", query = "SELECT p FROM Partido p"),
    @NamedQuery(name = "Partido.findByIdpartido", query = "SELECT p FROM Partido p WHERE p.idpartido = :idpartido"),
    @NamedQuery(name = "Partido.findByFechaHora", query = "SELECT p FROM Partido p WHERE p.fechaHora = :fechaHora")})
public class Partido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpartido")
    private Integer idpartido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpartido")
    private List<Gol> golList;
    @JoinColumn(name = "equipo_local", referencedColumnName = "idequipo")
    @ManyToOne(optional = false)
    private Equipo equipoLocal;
    @JoinColumn(name = "equipo_visitante", referencedColumnName = "idequipo")
    @ManyToOne(optional = false)
    private Equipo equipoVisitante;
    @JoinColumn(name = "idcancha", referencedColumnName = "idcancha")
    @ManyToOne(optional = false)
    private Cancha idcancha;
    @JoinColumn(name = "idarbritro3", referencedColumnName = "idarbritro")
    @ManyToOne(optional = false)
    private Arbritro idarbritro3;
    @JoinColumn(name = "idarbritro2", referencedColumnName = "idarbritro")
    @ManyToOne(optional = false)
    private Arbritro idarbritro2;
    @JoinColumn(name = "idarbritro1", referencedColumnName = "idarbritro")
    @ManyToOne(optional = false)
    private Arbritro idarbritro1;
    @JoinColumn(name = "arbritro_central", referencedColumnName = "idarbritro")
    @ManyToOne(optional = false)
    private Arbritro arbritroCentral;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpartido")
    private List<Sancion> sancionList;

    public Partido() {
    }

    public Partido(Integer idpartido) {
        this.idpartido = idpartido;
    }

    public Partido(Integer idpartido, Date fechaHora) {
        this.idpartido = idpartido;
        this.fechaHora = fechaHora;
    }

    public Integer getIdpartido() {
        return idpartido;
    }

    public void setIdpartido(Integer idpartido) {
        this.idpartido = idpartido;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    @XmlTransient
    public List<Gol> getGolList() {
        return golList;
    }

    public void setGolList(List<Gol> golList) {
        this.golList = golList;
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(Equipo equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public Cancha getIdcancha() {
        return idcancha;
    }

    public void setIdcancha(Cancha idcancha) {
        this.idcancha = idcancha;
    }

    public Arbritro getIdarbritro3() {
        return idarbritro3;
    }

    public void setIdarbritro3(Arbritro idarbritro3) {
        this.idarbritro3 = idarbritro3;
    }

    public Arbritro getIdarbritro2() {
        return idarbritro2;
    }

    public void setIdarbritro2(Arbritro idarbritro2) {
        this.idarbritro2 = idarbritro2;
    }

    public Arbritro getIdarbritro1() {
        return idarbritro1;
    }

    public void setIdarbritro1(Arbritro idarbritro1) {
        this.idarbritro1 = idarbritro1;
    }

    public Arbritro getArbritroCentral() {
        return arbritroCentral;
    }

    public void setArbritroCentral(Arbritro arbritroCentral) {
        this.arbritroCentral = arbritroCentral;
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
        hash += (idpartido != null ? idpartido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Partido)) {
            return false;
        }
        Partido other = (Partido) object;
        if ((this.idpartido == null && other.idpartido != null) || (this.idpartido != null && !this.idpartido.equals(other.idpartido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Partido[ idpartido=" + idpartido + " ]";
    }
    
}
