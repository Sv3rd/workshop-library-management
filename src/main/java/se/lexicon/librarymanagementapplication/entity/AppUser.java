package se.lexicon.librarymanagementapplication.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
public class AppUser {

    public AppUser(String username, String password, LocalDate regDate, Details details) {
        this.username = username;
        this.password = password;
        this.regDate = regDate;
        this.details = details;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appUserId;
    @Setter
    @Column(nullable = false, unique = true)
    private String username;
    @Setter
    @Column(nullable = false, length = 8)
    private String password;
    @Setter
    private LocalDate regDate;
    @Setter
    @OneToOne
    @JoinColumn(name = "detailsId")
    private Details details;
    
}
