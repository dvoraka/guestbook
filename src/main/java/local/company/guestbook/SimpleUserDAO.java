package local.company.guestbook;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class SimpleUserDAO implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    @Override
    public long count() {

        Session session = sessionFactory.getCurrentSession();
        List<Long> counts = session.createQuery("SELECT count(*) from User").list();

        return counts.get(0);
    }

    @Transactional
    @Override
    public List<User> getUsers() {

        Session session = sessionFactory.getCurrentSession();
        List<User> users = session.createQuery("FROM User").list();

        return users;
    }

    @Transactional
    @Override
    public Long addUser(String name) {

        User user = new User();
        user.setUsername(name);
        Session session = sessionFactory.getCurrentSession();
        Long id = (Long) session.save(user);

        return id;
    }

    @Transactional
    @Override
    public User get(Long id) {

        Session session = sessionFactory.getCurrentSession();
        User user = (User) session.get(User.class, id);

        return user;
    }

    @Transactional
    @Override
    public List<User> getByName(String name) {

        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM User U where U.username = :username";
        Query query = session.createQuery(hql);
        query.setParameter("username", name);
        List<User> users = query.list();

        return users;
    }
}
