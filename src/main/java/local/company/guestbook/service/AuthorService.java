package local.company.guestbook.service;

import local.company.guestbook.model.Author;

import java.util.List;

/**
 * Service layer for Author repository.
 */
public interface AuthorService {

    long count();

    List<Author> getAuthors();

    Author getAuthor(Long userId);

    List<Author> getAuthorsByName(String name);

    void addAuthor(String username);

    void addAuthor(Author author);

    void addRandomAuthor();

    void deleteAuthor(long id);
}
