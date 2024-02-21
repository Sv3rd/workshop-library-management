package se.lexicon.librarymanagementapplication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int authorId;

    @Column(nullable = false)
    private String firstName;

    @Column
    private String lastName;

    @ManyToMany
    @JoinTable(
            name = "Authors_Books",
            joinColumns = @JoinColumn(name = "authorId"),
            inverseJoinColumns = @JoinColumn(name = "bookId")
    )
    private Set<Book> writtenBooks = new HashSet<>();
}