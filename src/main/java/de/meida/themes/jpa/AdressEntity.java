package de.meida.themes.jpa;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class AdressEntity {

    @Id
    private Long id;
    private String ort;
    private String plz;

   /* @ManyToOne
    private UserEntity user;*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }
}
