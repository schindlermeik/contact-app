package de.meida.themes.jpa;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "users")
@NamedQuery(name ="User.findByName",
query = "select u from UserEntity u where u.name = :name")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    @Column(nullable = false)
    private String name;
    @Email
    @NotBlank
    @Column(nullable = false, unique = true)
    private String email;
    private Instant createdAt;
    /*@OneToMany
    private List<AdressEntity> adress;*/
    public UserEntity(){}
    public UserEntity(String name, String email) {
        this.name = name;
        this.email = email;
    }
    @PrePersist
    protected void onCreate() {
        this.createdAt = Instant.now();
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
