package se.lexicon.librarymanagementapplication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "detailsId")
    private Details details;

    @OneToMany(mappedBy = "loanId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<BookLoan> loans = new ArrayList<>();

    public void addBookLoan(BookLoan bookLoan) {
        this.loans.add(bookLoan);
    }
}
