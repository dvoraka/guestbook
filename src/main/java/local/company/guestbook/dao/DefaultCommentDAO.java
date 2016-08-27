package local.company.guestbook.dao;

import local.company.guestbook.model.Comment;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        Comment comment = (Comment) session.get(Comment.class, id);

        return comment;
    }

    @SuppressWarnings("unchecked")
    @Transactional
    @Override
    public List<Comment> getComments() {

        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Comment C";
        Query q = session.createQuery(hql);

        List<Comment> clist = q.list();

        return clist;
    }

    @SuppressWarnings("unchecked")
    @Override
    public long count() {

        Session session = sessionFactory.getCurrentSession();
        List<Long> counts = session.createQuery("SELECT count(*) from Comment").list();

        return counts.get(0);
    }
}
