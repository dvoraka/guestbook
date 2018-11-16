package local.company.guestbook.service;

import local.company.guestbook.model.Author;

import java.util.List;
import java.util.Optional;

/**
 * Service layer for Author repository.
 */
public interface AuthorService {

    long count();

    List<Author> listAuthors();

    Optional<Author> findAuthor(String name);

    Author addAuthor(Author author);

    Author addRandomAuthor();

    Author genRandomAuthor();

    void deleteAuthor(long id);

    void deleteAuthor(String username);
}
