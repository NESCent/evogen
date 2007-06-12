package org.nescent.evogen.hibernate;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * Data access object (DAO) for domain model class LocationQualifierValue.
 * @see org.nescent.evogen.hibernate.LocationQualifierValue
 * @author MyEclipse - Hibernate Tools
 */
public class LocationQualifierValueDAO extends BaseHibernateDAO {

    private static final Log log = LogFactory.getLog(LocationQualifierValueDAO.class);

	//property constants
	public static final String VALUE = "value";
	public static final String INT_VALUE = "intValue";

    
    public void save(LocationQualifierValue transientInstance) {
        log.debug("saving LocationQualifierValue instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(LocationQualifierValue persistentInstance) {
        log.debug("deleting LocationQualifierValue instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public LocationQualifierValue findById( org.nescent.evogen.hibernate.LocationQualifierValueId id) {
        log.debug("getting LocationQualifierValue instance with id: " + id);
        try {
            LocationQualifierValue instance = (LocationQualifierValue) getSession()
                    .get("org.nescent.evogen.hibernate.LocationQualifierValue", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(LocationQualifierValue instance) {
        log.debug("finding LocationQualifierValue instance by example");
        try {
            List results = getSession()
                    .createCriteria("org.nescent.evogen.hibernate.LocationQualifierValue")
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
      log.debug("finding LocationQualifierValue instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from LocationQualifierValue as model where model." 
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
	
	public List findByIntValue(Object intValue) {
		return findByProperty(INT_VALUE, intValue);
	}
	
    public LocationQualifierValue merge(LocationQualifierValue detachedInstance) {
        log.debug("merging LocationQualifierValue instance");
        try {
            LocationQualifierValue result = (LocationQualifierValue) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(LocationQualifierValue instance) {
        log.debug("attaching dirty LocationQualifierValue instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(LocationQualifierValue instance) {
        log.debug("attaching clean LocationQualifierValue instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}