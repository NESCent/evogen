package org.nescent.evogen.hibernate;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * Data access object (DAO) for domain model class BioentryDbxref.
 * @see org.nescent.evogen.hibernate.BioentryDbxref
 * @author MyEclipse - Hibernate Tools
 */
public class BioentryDbxrefDAO extends BaseHibernateDAO {

    private static final Log log = LogFactory.getLog(BioentryDbxrefDAO.class);

	//property constants
	public static final String RANK = "rank";

    
    public void save(BioentryDbxref transientInstance) {
        log.debug("saving BioentryDbxref instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(BioentryDbxref persistentInstance) {
        log.debug("deleting BioentryDbxref instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public BioentryDbxref findById( org.nescent.evogen.hibernate.BioentryDbxrefId id) {
        log.debug("getting BioentryDbxref instance with id: " + id);
        try {
            BioentryDbxref instance = (BioentryDbxref) getSession()
                    .get("org.nescent.evogen.hibernate.BioentryDbxref", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(BioentryDbxref instance) {
        log.debug("finding BioentryDbxref instance by example");
        try {
            List results = getSession()
                    .createCriteria("org.nescent.evogen.hibernate.BioentryDbxref")
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
      log.debug("finding BioentryDbxref instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from BioentryDbxref as model where model." 
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
	
    public BioentryDbxref merge(BioentryDbxref detachedInstance) {
        log.debug("merging BioentryDbxref instance");
        try {
            BioentryDbxref result = (BioentryDbxref) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(BioentryDbxref instance) {
        log.debug("attaching dirty BioentryDbxref instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(BioentryDbxref instance) {
        log.debug("attaching clean BioentryDbxref instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}