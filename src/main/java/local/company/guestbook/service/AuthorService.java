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

    Author addAuthor(String username);

    Author addAuthor(Author author);

    void addAuthors(Iterable<Author> authors);

    Author addRandomAuthor();

    Author genRandomAuthor();

    void deleteAuthor(long id);
}
