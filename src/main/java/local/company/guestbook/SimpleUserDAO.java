package local.company.guestbook;

import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public void addUser(String name) {
        
        User user = new User();
        user.setUsername(name);
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
        
    }
}
