package org.nescent.evogen.hibernate;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * Data access object (DAO) for domain model class BioentryPath.
 * @see org.nescent.evogen.hibernate.BioentryPath
 * @author MyEclipse - Hibernate Tools
 */
public class BioentryPathDAO extends BaseHibernateDAO {

    private static final Log log = LogFactory.getLog(BioentryPathDAO.class);

	//property constants

    
    public void save(BioentryPath transientInstance) {
        log.debug("saving BioentryPath instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(BioentryPath persistentInstance) {
        log.debug("deleting BioentryPath instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public BioentryPath findById( org.nescent.evogen.hibernate.BioentryPathId id) {
        log.debug("getting BioentryPath instance with id: " + id);
        try {
            BioentryPath instance = (BioentryPath) getSession()
                    .get("org.nescent.evogen.hibernate.BioentryPath", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(BioentryPath instance) {
        log.debug("finding BioentryPath instance by example");
        try {
            List results = getSession()
                    .createCriteria("org.nescent.evogen.hibernate.BioentryPath")
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
      log.debug("finding BioentryPath instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from BioentryPath as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

    public BioentryPath merge(BioentryPath detachedInstance) {
        log.debug("merging BioentryPath instance");
        try {
            BioentryPath result = (BioentryPath) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(BioentryPath instance) {
        log.debug("attaching dirty BioentryPath instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(BioentryPath instance) {
        log.debug("attaching clean BioentryPath instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}