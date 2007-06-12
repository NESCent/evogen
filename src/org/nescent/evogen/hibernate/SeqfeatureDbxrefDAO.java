package org.nescent.evogen.hibernate;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * Data access object (DAO) for domain model class SeqfeatureDbxref.
 * @see org.nescent.evogen.hibernate.SeqfeatureDbxref
 * @author MyEclipse - Hibernate Tools
 */
public class SeqfeatureDbxrefDAO extends BaseHibernateDAO {

    private static final Log log = LogFactory.getLog(SeqfeatureDbxrefDAO.class);

	//property constants
	public static final String RANK = "rank";

    
    public void save(SeqfeatureDbxref transientInstance) {
        log.debug("saving SeqfeatureDbxref instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(SeqfeatureDbxref persistentInstance) {
        log.debug("deleting SeqfeatureDbxref instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public SeqfeatureDbxref findById( org.nescent.evogen.hibernate.SeqfeatureDbxrefId id) {
        log.debug("getting SeqfeatureDbxref instance with id: " + id);
        try {
            SeqfeatureDbxref instance = (SeqfeatureDbxref) getSession()
                    .get("org.nescent.evogen.hibernate.SeqfeatureDbxref", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(SeqfeatureDbxref instance) {
        log.debug("finding SeqfeatureDbxref instance by example");
        try {
            List results = getSession()
                    .createCriteria("org.nescent.evogen.hibernate.SeqfeatureDbxref")
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
      log.debug("finding SeqfeatureDbxref instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from SeqfeatureDbxref as model where model." 
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
	
    public SeqfeatureDbxref merge(SeqfeatureDbxref detachedInstance) {
        log.debug("merging SeqfeatureDbxref instance");
        try {
            SeqfeatureDbxref result = (SeqfeatureDbxref) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(SeqfeatureDbxref instance) {
        log.debug("attaching dirty SeqfeatureDbxref instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(SeqfeatureDbxref instance) {
        log.debug("attaching clean SeqfeatureDbxref instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}