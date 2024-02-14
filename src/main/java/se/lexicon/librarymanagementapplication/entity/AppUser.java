package se.lexicon.librarymanagementapplication.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity(name = "app_user")
@Getter
public class AppUser {
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
