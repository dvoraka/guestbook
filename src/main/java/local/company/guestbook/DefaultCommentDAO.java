package local.company.guestbook;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class DefaultCommentDAO implements CommentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    @Override
    public void add(Comment comment) {

        Session session = sessionFactory.getCurrentSession();
        session.save(comment);

    }

    @Transactional
    @Override
    public Comment get(Long id) {

        Session session = sessionFactory.getCurrentSession();
        Query q = session.createQuery("FROM User U WHERE E.id = :id");
        q.setParameter("id", id);
        List<Comment> clist = q.list();

        if (clist.size() == 1) {

            return clist.get(0);

        } else {

            return null;

        }
    }
}
