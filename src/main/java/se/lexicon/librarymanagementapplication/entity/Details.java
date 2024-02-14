package se.lexicon.librarymanagementapplication.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
public class Details {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int detailsId;
    @Setter
    @Column(nullable = false, unique = true)
    private String email;
    @Setter
    private String name;
    @Setter
    private LocalDate birthDate;
}
