package se.lexicon.librarymanagementapplication.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
public class Details {

    public Details(String email, String name, LocalDate birthDate) {
        this.email = email;
        this.name = name;
        this.birthDate = birthDate;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int detailsId;

    @Column(nullable = false, unique = true)
    @Setter
    private String email;
    @Setter
    private String name;
    @Setter
    private LocalDate birthDate;

}
