package fr.polytech.info4.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A SystemePaiement.
 */
@Entity
@Table(name = "systeme_paiement")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class SystemePaiement implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "crediteur", nullable = false)
    private String crediteur;

    @NotNull
    @Column(name = "debiteur", nullable = false)
    private String debiteur;

    @NotNull
    @Column(name = "method", nullable = false)
    private String method;

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JoinTable(name = "systeme_paiement_compte",
               joinColumns = @JoinColumn(name = "systeme_paiement_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "compte_id", referencedColumnName = "id"))
    private Set<Compte> comptes = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCrediteur() {
        return crediteur;
    }

    public SystemePaiement crediteur(String crediteur) {
        this.crediteur = crediteur;
        return this;
    }

    public void setCrediteur(String crediteur) {
        this.crediteur = crediteur;
    }

    public String getDebiteur() {
        return debiteur;
    }

    public SystemePaiement debiteur(String debiteur) {
        this.debiteur = debiteur;
        return this;
    }

    public void setDebiteur(String debiteur) {
        this.debiteur = debiteur;
    }

    public String getMethod() {
        return method;
    }

    public SystemePaiement method(String method) {
        this.method = method;
        return this;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Set<Compte> getComptes() {
        return comptes;
    }

    public SystemePaiement comptes(Set<Compte> comptes) {
        this.comptes = comptes;
        return this;
    }

    public SystemePaiement addCompte(Compte compte) {
        this.comptes.add(compte);
        compte.getSystemePaiements().add(this);
        return this;
    }

    public SystemePaiement removeCompte(Compte compte) {
        this.comptes.remove(compte);
        compte.getSystemePaiements().remove(this);
        return this;
    }

    public void setComptes(Set<Compte> comptes) {
        this.comptes = comptes;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SystemePaiement)) {
            return false;
        }
        return id != null && id.equals(((SystemePaiement) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SystemePaiement{" +
            "id=" + getId() +
            ", crediteur='" + getCrediteur() + "'" +
            ", debiteur='" + getDebiteur() + "'" +
            ", method='" + getMethod() + "'" +
            "}";
    }
}
