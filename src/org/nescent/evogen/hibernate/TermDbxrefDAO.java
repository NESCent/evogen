package org.nescent.evogen.hibernate;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * Data access object (DAO) for domain model class TermDbxref.
 * @see org.nescent.evogen.hibernate.TermDbxref
 * @author MyEclipse - Hibernate Tools
 */
public class TermDbxrefDAO extends BaseHibernateDAO {

    private static final Log log = LogFactory.getLog(TermDbxrefDAO.class);

	//property constants
	public static final String RANK = "rank";

    
    public void save(TermDbxref transientInstance) {
        log.debug("saving TermDbxref instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(TermDbxref persistentInstance) {
        log.debug("deleting TermDbxref instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public TermDbxref findById( org.nescent.evogen.hibernate.TermDbxrefId id) {
        log.debug("getting TermDbxref instance with id: " + id);
        try {
            TermDbxref instance = (TermDbxref) getSession()
                    .get("org.nescent.evogen.hibernate.TermDbxref", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(TermDbxref instance) {
        log.debug("finding TermDbxref instance by example");
        try {
            List results = getSession()
                    .createCriteria("org.nescent.evogen.hibernate.TermDbxref")
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
      log.debug("finding TermDbxref instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from TermDbxref as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByRank(Object rank) {
		return findByProperty(RANK, rank);
	}
	
    public TermDbxref merge(TermDbxref detachedInstance) {
        log.debug("merging TermDbxref instance");
        try {
            TermDbxref result = (TermDbxref) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(TermDbxref instance) {
        log.debug("attaching dirty TermDbxref instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(TermDbxref instance) {
        log.debug("attaching clean TermDbxref instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}