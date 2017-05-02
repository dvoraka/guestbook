package local.company.guestbook.service;

import local.company.guestbook.model.Author;

import java.util.List;
import java.util.Optional;

/**
 * Service layer for Author repository.
 */
public interface AuthorService {

    long count();

    List<Author> getAuthors();

    Optional<Author> findAuthor(String name);

    void addAuthor(String username);

    void addAuthor(Author author);

    Author addRandomAuthor();

    void deleteAuthor(long id);
}
