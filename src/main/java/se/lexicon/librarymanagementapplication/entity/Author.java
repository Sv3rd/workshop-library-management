package se.lexicon.librarymanagementapplication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

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
    public void addBook(Book book){
        this.writtenBooks.add(book);
        book.getAuthors().add(this);
    }
}
