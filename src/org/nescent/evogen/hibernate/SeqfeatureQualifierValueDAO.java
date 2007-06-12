package org.nescent.evogen.hibernate;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * Data access object (DAO) for domain model class SeqfeatureQualifierValue.
 * @see org.nescent.evogen.hibernate.SeqfeatureQualifierValue
 * @author MyEclipse - Hibernate Tools
 */
public class SeqfeatureQualifierValueDAO extends BaseHibernateDAO {

    private static final Log log = LogFactory.getLog(SeqfeatureQualifierValueDAO.class);

	//property constants
	public static final String VALUE = "value";

    
    public void save(SeqfeatureQualifierValue transientInstance) {
        log.debug("saving SeqfeatureQualifierValue instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(SeqfeatureQualifierValue persistentInstance) {
        log.debug("deleting SeqfeatureQualifierValue instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public SeqfeatureQualifierValue findById( org.nescent.evogen.hibernate.SeqfeatureQualifierValueId id) {
        log.debug("getting SeqfeatureQualifierValue instance with id: " + id);
        try {
            SeqfeatureQualifierValue instance = (SeqfeatureQualifierValue) getSession()
                    .get("org.nescent.evogen.hibernate.SeqfeatureQualifierValue", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(SeqfeatureQualifierValue instance) {
        log.debug("finding SeqfeatureQualifierValue instance by example");
        try {
            List results = getSession()
                    .createCriteria("org.nescent.evogen.hibernate.SeqfeatureQualifierValue")
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
      log.debug("finding SeqfeatureQualifierValue instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from SeqfeatureQualifierValue as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByValue(Object value) {
		return findByProperty(VALUE, value);
	}
	
    public SeqfeatureQualifierValue merge(SeqfeatureQualifierValue detachedInstance) {
        log.debug("merging SeqfeatureQualifierValue instance");
        try {
            SeqfeatureQualifierValue result = (SeqfeatureQualifierValue) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(SeqfeatureQualifierValue instance) {
        log.debug("attaching dirty SeqfeatureQualifierValue instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(SeqfeatureQualifierValue instance) {
        log.debug("attaching clean SeqfeatureQualifierValue instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}