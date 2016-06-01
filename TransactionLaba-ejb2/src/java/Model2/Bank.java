/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model2;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ceparator
 */
@Entity
@Table(name = "bank")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bank.findAll", query = "SELECT b FROM Bank b"),
    @NamedQuery(name = "Bank.findByIdBank", query = "SELECT b FROM Bank b WHERE b.idBank = :idBank"),
    @NamedQuery(name = "Bank.findByClientName", query = "SELECT b FROM Bank b WHERE b.clientName = :clientName"),
    @NamedQuery(name = "Bank.findByClientSchet", query = "SELECT b FROM Bank b WHERE b.clientSchet = :clientSchet")})
public class Bank implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idBank")
    private Integer idBank;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "clientName")
    private String clientName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "clientSchet")
    private int clientSchet;

    public Bank() {
    }

    public Bank(Integer idBank) {
        this.idBank = idBank;
    }

    public Bank(Integer idBank, String clientName, int clientSchet) {
        this.idBank = idBank;
        this.clientName = clientName;
        this.clientSchet = clientSchet;
    }

    public Integer getIdBank() {
        return idBank;
    }

    public void setIdBank(Integer idBank) {
        this.idBank = idBank;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getClientSchet() {
        return clientSchet;
    }

    public void setClientSchet(int clientSchet) {
        this.clientSchet = clientSchet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBank != null ? idBank.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bank)) {
            return false;
        }
        Bank other = (Bank) object;
        if ((this.idBank == null && other.idBank != null) || (this.idBank != null && !this.idBank.equals(other.idBank))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Bank[ idBank=" + idBank + " ]";
    }
    
}
