package local.company.guestbook.service;

import local.company.guestbook.model.Author;
import local.company.guestbook.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.SecureRandom;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DefaultAuthorService implements AuthorService {

    private static final int RANDOM_USERNAME_LENGTH = 10;

    private final AuthorRepository authorRepository;


    @Autowired
    public DefaultAuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public long count() {
        return authorRepository.count();
    }

    @Override
    public List<Author> getUsers() {
        return authorRepository.findAll();
    }

    @Override
    public void addRandomUser() {
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        for (int i = 0; i < RANDOM_USERNAME_LENGTH; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String randStr = sb.toString();

        authorRepository.save(createUser(randStr));
    }

    @Override
    public Author getUser(Long userId) {
        return authorRepository.findOne(userId);
    }

    @Override
    public List<Author> getUsersByName(String name) {
        return authorRepository.findByUsername(name).collect(Collectors.toList());
    }

    @Override
    public void deleteUser(long id) {
        authorRepository.delete(id);
    }

    @Override
    public void addUser(String username) {
        authorRepository.save(createUser(username));
    }

    @Override
    public void addUser(Author author) {
        authorRepository.save(author);
    }

    private Author createUser(String username) {
        Author author = new Author();
        author.setUsername(username);
        author.setCreated(new Date());

        return author;
    }
}
