package local.company.guestbook.service;

import local.company.guestbook.model.Comment;
import local.company.guestbook.model.User;

import java.util.List;

public interface GuestbookService {

    List<User> getUsers();

    List<Comment> getComments();

}
