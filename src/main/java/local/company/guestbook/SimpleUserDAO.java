package local.company.guestbook;

import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class SimpleUserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public long count() {

        Session session = sessionFactory.getCurrentSession();
        List<Long> counts = session.createQuery("SELECT count(*) from User").list();

        return counts.get(0);
    }
}
