package local.company.guestbook.service;

import local.company.guestbook.model.Author;
import local.company.guestbook.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.SecureRandom;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

/**
 * Default Author service implementation.
 */
@Service
@Transactional
public class DefaultAuthorService implements AuthorService {

    private final AuthorRepository authorRepository;

    private static final int RANDOM_USERNAME_LENGTH = 10;

    private final SecureRandom random;


    @Autowired
    public DefaultAuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
        random = new SecureRandom();
    }

    @Override
    public long count() {
        return authorRepository.count();
    }

    @Override
    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author addRandomAuthor() {
        return authorRepository.save(genRandomAuthor());
    }

    @Override
    public Author genRandomAuthor() {
        StringBuilder sb = new StringBuilder();
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        for (int i = 0; i < RANDOM_USERNAME_LENGTH; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String randStr = sb.toString();

        return createUser(randStr);
    }

    @Override
    public Optional<Author> findAuthor(String name) {
        return authorRepository.findByName(name);
    }

    @Override
    public void deleteAuthor(long id) {
        authorRepository.delete(id);
    }

    @Override
    public void addAuthor(String username) {
        authorRepository.save(createUser(username));
    }

    @Override
    public void addAuthor(Author author) {
        authorRepository.save(author);
    }

    @Override
    public void addAuthors(Iterable<Author> authors) {
        authorRepository.save(authors);
    }

    private Author createUser(String username) {
        Author author = new Author();
        author.setName(username);
        author.setPassword("");
        author.setCreated(Instant.now());

        return author;
    }
}
