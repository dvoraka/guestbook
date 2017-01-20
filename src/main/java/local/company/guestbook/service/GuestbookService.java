package local.company.guestbook.service;

import local.company.guestbook.model.Author;
import local.company.guestbook.model.Comment;

import java.util.List;

public interface GuestbookService {

    List<Author> getUsers();

    List<Comment> getComments();
}
