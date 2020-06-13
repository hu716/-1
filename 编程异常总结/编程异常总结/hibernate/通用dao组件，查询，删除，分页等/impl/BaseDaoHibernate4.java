
package org.crazyit.common.dao.impl;

import java.io.Serializable;
import java.util.List;
import org.crazyit.common.dao.BaseDao;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class BaseDaoHibernate4<T> implements BaseDao<T> {
    private SessionFactory sessionFactory;

    public BaseDaoHibernate4() {
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }

    public T get(Class<T> entityClazz, Serializable id) {
        return this.getSessionFactory().getCurrentSession().get(entityClazz, id);
    }

    public Serializable save(T entity) {
        return this.getSessionFactory().getCurrentSession().save(entity);
    }

    public void update(T entity) {
        this.getSessionFactory().getCurrentSession().saveOrUpdate(entity);
    }

    public void delete(T entity) {
        this.getSessionFactory().getCurrentSession().delete(entity);
    }

    public void delete(Class<T> entityClazz, Serializable id) {
        delete(get(entityClazz, id));
    }

    public List<T> findAll(Class<T> entityClazz) {
        return this.find("select en from " + entityClazz.getSimpleName() + " en");
    }

    public long findCount(Class<T> entityClazz) {
        List l = this.find("select count(*) from " + entityClazz.getSimpleName());
        return l != null && l.size() == 1 ? (Long)l.get(0) : 0L;
    }
    //根据hql语句查询实体
    @SuppressWarnings("unchecked")
    protected List<T> find(String hql) {
        return this.getSessionFactory().getCurrentSession().createQuery(hql).list();
    }
    @SuppressWarnings("unchecked")
    protected List<T> find(String hql, Object... params) {
        Query query = this.getSessionFactory().getCurrentSession().createQuery(hql);
        int i = 0;

        for(int len = params.length; i < len; ++i) {
            query.setParameter(i + "", params[i]);
        }

        return query.list();
    }
    @SuppressWarnings("unchecked")
    protected List<T> findByPage(String hql, int pageNo, int pageSize) {
        return this.getSessionFactory().getCurrentSession().createQuery(hql).setFirstResult((pageNo - 1) * pageSize).setMaxResults(pageSize).list();
    }
    @SuppressWarnings("unchecked")
    protected List<T> findByPage(String hql, int pageNo, int pageSize, Object... params) {
        Query query = this.getSessionFactory().getCurrentSession().createQuery(hql);
        int i = 0;

        for(int len = params.length; i < len; ++i) {
            query.setParameter(i + "", params[i]);
        }

        return query.setFirstResult((pageNo - 1) * pageSize).setMaxResults(pageSize).list();
    }
}
