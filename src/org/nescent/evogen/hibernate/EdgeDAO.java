package org.nescent.evogen.hibernate;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * Data access object (DAO) for domain model class Edge.
 * @see org.nescent.evogen.hibernate.Edge
 * @author MyEclipse - Hibernate Tools
 */
public class EdgeDAO extends BaseHibernateDAO {

    private static final Log log = LogFactory.getLog(EdgeDAO.class);

	//property constants

    
    public void save(Edge transientInstance) {
        log.debug("saving Edge instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Edge persistentInstance) {
        log.debug("deleting Edge instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Edge findById( java.lang.Integer id) {
        log.debug("getting Edge instance with id: " + id);
        try {
            Edge instance = (Edge) getSession()
                    .get("org.nescent.evogen.hibernate.Edge", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Edge instance) {
        log.debug("finding Edge instance by example");
        try {
            List results = getSession()
                    .createCriteria("org.nescent.evogen.hibernate.Edge")
                    .add(Example.create(instance))
            .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding Edge instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Edge as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

    public Edge merge(Edge detachedInstance) {
        log.debug("merging Edge instance");
        try {
            Edge result = (Edge) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Edge instance) {
        log.debug("attaching dirty Edge instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Edge instance) {
        log.debug("attaching clean Edge instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}