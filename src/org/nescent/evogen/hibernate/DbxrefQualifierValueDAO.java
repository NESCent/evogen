package org.nescent.evogen.hibernate;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * Data access object (DAO) for domain model class DbxrefQualifierValue.
 * @see org.nescent.evogen.hibernate.DbxrefQualifierValue
 * @author MyEclipse - Hibernate Tools
 */
public class DbxrefQualifierValueDAO extends BaseHibernateDAO {

    private static final Log log = LogFactory.getLog(DbxrefQualifierValueDAO.class);

	//property constants
	public static final String VALUE = "value";

    
    public void save(DbxrefQualifierValue transientInstance) {
        log.debug("saving DbxrefQualifierValue instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(DbxrefQualifierValue persistentInstance) {
        log.debug("deleting DbxrefQualifierValue instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public DbxrefQualifierValue findById( org.nescent.evogen.hibernate.DbxrefQualifierValueId id) {
        log.debug("getting DbxrefQualifierValue instance with id: " + id);
        try {
            DbxrefQualifierValue instance = (DbxrefQualifierValue) getSession()
                    .get("org.nescent.evogen.hibernate.DbxrefQualifierValue", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(DbxrefQualifierValue instance) {
        log.debug("finding DbxrefQualifierValue instance by example");
        try {
            List results = getSession()
                    .createCriteria("org.nescent.evogen.hibernate.DbxrefQualifierValue")
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
      log.debug("finding DbxrefQualifierValue instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from DbxrefQualifierValue as model where model." 
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
	
    public DbxrefQualifierValue merge(DbxrefQualifierValue detachedInstance) {
        log.debug("merging DbxrefQualifierValue instance");
        try {
            DbxrefQualifierValue result = (DbxrefQualifierValue) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(DbxrefQualifierValue instance) {
        log.debug("attaching dirty DbxrefQualifierValue instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(DbxrefQualifierValue instance) {
        log.debug("attaching clean DbxrefQualifierValue instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}