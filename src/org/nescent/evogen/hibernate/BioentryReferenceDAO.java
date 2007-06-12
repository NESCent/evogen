package org.nescent.evogen.hibernate;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * Data access object (DAO) for domain model class BioentryReference.
 * @see org.nescent.evogen.hibernate.BioentryReference
 * @author MyEclipse - Hibernate Tools
 */
public class BioentryReferenceDAO extends BaseHibernateDAO {

    private static final Log log = LogFactory.getLog(BioentryReferenceDAO.class);

	//property constants
	public static final String START_POS = "startPos";
	public static final String END_POS = "endPos";

    
    public void save(BioentryReference transientInstance) {
        log.debug("saving BioentryReference instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(BioentryReference persistentInstance) {
        log.debug("deleting BioentryReference instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public BioentryReference findById( org.nescent.evogen.hibernate.BioentryReferenceId id) {
        log.debug("getting BioentryReference instance with id: " + id);
        try {
            BioentryReference instance = (BioentryReference) getSession()
                    .get("org.nescent.evogen.hibernate.BioentryReference", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(BioentryReference instance) {
        log.debug("finding BioentryReference instance by example");
        try {
            List results = getSession()
                    .createCriteria("org.nescent.evogen.hibernate.BioentryReference")
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
      log.debug("finding BioentryReference instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from BioentryReference as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByStartPos(Object startPos) {
		return findByProperty(START_POS, startPos);
	}
	
	public List findByEndPos(Object endPos) {
		return findByProperty(END_POS, endPos);
	}
	
    public BioentryReference merge(BioentryReference detachedInstance) {
        log.debug("merging BioentryReference instance");
        try {
            BioentryReference result = (BioentryReference) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(BioentryReference instance) {
        log.debug("attaching dirty BioentryReference instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(BioentryReference instance) {
        log.debug("attaching clean BioentryReference instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}