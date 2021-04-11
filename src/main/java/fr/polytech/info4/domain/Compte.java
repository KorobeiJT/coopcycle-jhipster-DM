package fr.polytech.info4.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Compte.
 */
@Entity
@Table(name = "compte")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Compte implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "surname", nullable = false)
    private String surname;

    @Min(value = 0)
    @Max(value = 120)
    @Column(name = "age")
    private Integer age;

    @NotNull
    @Size(max = 16)
    @Column(name = "accountid", length = 16, nullable = false)
    private String accountid;

    @NotNull
    @Column(name = "adress", nullable = false)
    private String adress;

    @NotNull
    @Column(name = "role", nullable = false)
    private String role;

    @OneToOne
    @JoinColumn(unique = true)
    private Course course;

    @OneToMany(mappedBy = "compte")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<Panier> paniers = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = "comptes", allowSetters = true)
    private Roles roles;

    @ManyToOne
    @JsonIgnoreProperties(value = "comptes", allowSetters = true)
    private Cooperative cooperative;

    @ManyToMany(mappedBy = "comptes")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnore
    private Set<Restaurant> restaurants = new HashSet<>();

    @ManyToMany(mappedBy = "comptes")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnore
    private Set<SystemePaiement> systemePaiements = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Compte name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public Compte surname(String surname) {
        this.surname = surname;
        return this;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public Compte age(Integer age) {
        this.age = age;
        return this;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAccountid() {
        return accountid;
    }

    public Compte accountid(String accountid) {
        this.accountid = accountid;
        return this;
    }

    public void setAccountid(String accountid) {
        this.accountid = accountid;
    }

    public String getAdress() {
        return adress;
    }

    public Compte adress(String adress) {
        this.adress = adress;
        return this;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getRole() {
        return role;
    }

    public Compte role(String role) {
        this.role = role;
        return this;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Course getCourse() {
        return course;
    }

    public Compte course(Course course) {
        this.course = course;
        return this;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Set<Panier> getPaniers() {
        return paniers;
    }

    public Compte paniers(Set<Panier> paniers) {
        this.paniers = paniers;
        return this;
    }

    public Compte addPanier(Panier panier) {
        this.paniers.add(panier);
        panier.setCompte(this);
        return this;
    }

    public Compte removePanier(Panier panier) {
        this.paniers.remove(panier);
        panier.setCompte(null);
        return this;
    }

    public void setPaniers(Set<Panier> paniers) {
        this.paniers = paniers;
    }

    public Roles getRoles() {
        return roles;
    }

    public Compte roles(Roles roles) {
        this.roles = roles;
        return this;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public Cooperative getCooperative() {
        return cooperative;
    }

    public Compte cooperative(Cooperative cooperative) {
        this.cooperative = cooperative;
        return this;
    }

    public void setCooperative(Cooperative cooperative) {
        this.cooperative = cooperative;
    }

    public Set<Restaurant> getRestaurants() {
        return restaurants;
    }

    public Compte restaurants(Set<Restaurant> restaurants) {
        this.restaurants = restaurants;
        return this;
    }

    public Compte addRestaurant(Restaurant restaurant) {
        this.restaurants.add(restaurant);
        restaurant.getComptes().add(this);
        return this;
    }

    public Compte removeRestaurant(Restaurant restaurant) {
        this.restaurants.remove(restaurant);
        restaurant.getComptes().remove(this);
        return this;
    }

    public void setRestaurants(Set<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public Set<SystemePaiement> getSystemePaiements() {
        return systemePaiements;
    }

    public Compte systemePaiements(Set<SystemePaiement> systemePaiements) {
        this.systemePaiements = systemePaiements;
        return this;
    }

    public Compte addSystemePaiement(SystemePaiement systemePaiement) {
        this.systemePaiements.add(systemePaiement);
        systemePaiement.getComptes().add(this);
        return this;
    }

    public Compte removeSystemePaiement(SystemePaiement systemePaiement) {
        this.systemePaiements.remove(systemePaiement);
        systemePaiement.getComptes().remove(this);
        return this;
    }

    public void setSystemePaiements(Set<SystemePaiement> systemePaiements) {
        this.systemePaiements = systemePaiements;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Compte)) {
            return false;
        }
        return id != null && id.equals(((Compte) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Compte{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", surname='" + getSurname() + "'" +
            ", age=" + getAge() +
            ", accountid='" + getAccountid() + "'" +
            ", adress='" + getAdress() + "'" +
            ", role='" + getRole() + "'" +
            "}";
    }
}
