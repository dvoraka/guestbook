package local.company.guestbook.service;

import local.company.guestbook.model.Author;
import local.company.guestbook.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AuthorRepository authorRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Author author = authorRepository.findByName(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));

        return new User(
                author.getName(),
                author.getPassword(),
                Stream.of(new SimpleGrantedAuthority("USER"))
                        .collect(Collectors.toList())
        );
    }
}
