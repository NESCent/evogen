package org.nescent.evogen.hibernate;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * Data access object (DAO) for domain model class TermSynonym.
 * @see org.nescent.evogen.hibernate.TermSynonym
 * @author MyEclipse - Hibernate Tools
 */
public class TermSynonymDAO extends BaseHibernateDAO {

    private static final Log log = LogFactory.getLog(TermSynonymDAO.class);

	//property constants

    
    public void save(TermSynonym transientInstance) {
        log.debug("saving TermSynonym instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(TermSynonym persistentInstance) {
        log.debug("deleting TermSynonym instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public TermSynonym findById( org.nescent.evogen.hibernate.TermSynonymId id) {
        log.debug("getting TermSynonym instance with id: " + id);
        try {
            TermSynonym instance = (TermSynonym) getSession()
                    .get("org.nescent.evogen.hibernate.TermSynonym", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(TermSynonym instance) {
        log.debug("finding TermSynonym instance by example");
        try {
            List results = getSession()
                    .createCriteria("org.nescent.evogen.hibernate.TermSynonym")
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
      log.debug("finding TermSynonym instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from TermSynonym as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

    public TermSynonym merge(TermSynonym detachedInstance) {
        log.debug("merging TermSynonym instance");
        try {
            TermSynonym result = (TermSynonym) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(TermSynonym instance) {
        log.debug("attaching dirty TermSynonym instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(TermSynonym instance) {
        log.debug("attaching clean TermSynonym instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}