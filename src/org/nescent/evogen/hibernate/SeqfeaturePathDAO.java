package org.nescent.evogen.hibernate;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * Data access object (DAO) for domain model class SeqfeaturePath.
 * @see org.nescent.evogen.hibernate.SeqfeaturePath
 * @author MyEclipse - Hibernate Tools
 */
public class SeqfeaturePathDAO extends BaseHibernateDAO {

    private static final Log log = LogFactory.getLog(SeqfeaturePathDAO.class);

	//property constants

    
    public void save(SeqfeaturePath transientInstance) {
        log.debug("saving SeqfeaturePath instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(SeqfeaturePath persistentInstance) {
        log.debug("deleting SeqfeaturePath instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public SeqfeaturePath findById( org.nescent.evogen.hibernate.SeqfeaturePathId id) {
        log.debug("getting SeqfeaturePath instance with id: " + id);
        try {
            SeqfeaturePath instance = (SeqfeaturePath) getSession()
                    .get("org.nescent.evogen.hibernate.SeqfeaturePath", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(SeqfeaturePath instance) {
        log.debug("finding SeqfeaturePath instance by example");
        try {
            List results = getSession()
                    .createCriteria("org.nescent.evogen.hibernate.SeqfeaturePath")
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
      log.debug("finding SeqfeaturePath instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from SeqfeaturePath as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

    public SeqfeaturePath merge(SeqfeaturePath detachedInstance) {
        log.debug("merging SeqfeaturePath instance");
        try {
            SeqfeaturePath result = (SeqfeaturePath) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(SeqfeaturePath instance) {
        log.debug("attaching dirty SeqfeaturePath instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(SeqfeaturePath instance) {
        log.debug("attaching clean SeqfeaturePath instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}