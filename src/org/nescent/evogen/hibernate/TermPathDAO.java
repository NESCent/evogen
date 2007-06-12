package org.nescent.evogen.hibernate;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * Data access object (DAO) for domain model class TermPath.
 * @see org.nescent.evogen.hibernate.TermPath
 * @author MyEclipse - Hibernate Tools
 */
public class TermPathDAO extends BaseHibernateDAO {

    private static final Log log = LogFactory.getLog(TermPathDAO.class);

	//property constants
	public static final String DISTANCE = "distance";

    
    public void save(TermPath transientInstance) {
        log.debug("saving TermPath instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(TermPath persistentInstance) {
        log.debug("deleting TermPath instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public TermPath findById( java.lang.Integer id) {
        log.debug("getting TermPath instance with id: " + id);
        try {
            TermPath instance = (TermPath) getSession()
                    .get("org.nescent.evogen.hibernate.TermPath", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(TermPath instance) {
        log.debug("finding TermPath instance by example");
        try {
            List results = getSession()
                    .createCriteria("org.nescent.evogen.hibernate.TermPath")
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
      log.debug("finding TermPath instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from TermPath as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByDistance(Object distance) {
		return findByProperty(DISTANCE, distance);
	}
	
    public TermPath merge(TermPath detachedInstance) {
        log.debug("merging TermPath instance");
        try {
            TermPath result = (TermPath) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(TermPath instance) {
        log.debug("attaching dirty TermPath instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(TermPath instance) {
        log.debug("attaching clean TermPath instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}