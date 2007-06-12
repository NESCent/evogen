package org.nescent.evogen.hibernate;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * Data access object (DAO) for domain model class BioentryQualifierValue.
 * @see org.nescent.evogen.hibernate.BioentryQualifierValue
 * @author MyEclipse - Hibernate Tools
 */
public class BioentryQualifierValueDAO extends BaseHibernateDAO {

    private static final Log log = LogFactory.getLog(BioentryQualifierValueDAO.class);

	//property constants

    
    public void save(BioentryQualifierValue transientInstance) {
        log.debug("saving BioentryQualifierValue instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(BioentryQualifierValue persistentInstance) {
        log.debug("deleting BioentryQualifierValue instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public BioentryQualifierValue findById( org.nescent.evogen.hibernate.BioentryQualifierValueId id) {
        log.debug("getting BioentryQualifierValue instance with id: " + id);
        try {
            BioentryQualifierValue instance = (BioentryQualifierValue) getSession()
                    .get("org.nescent.evogen.hibernate.BioentryQualifierValue", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(BioentryQualifierValue instance) {
        log.debug("finding BioentryQualifierValue instance by example");
        try {
            List results = getSession()
                    .createCriteria("org.nescent.evogen.hibernate.BioentryQualifierValue")
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
      log.debug("finding BioentryQualifierValue instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from BioentryQualifierValue as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

    public BioentryQualifierValue merge(BioentryQualifierValue detachedInstance) {
        log.debug("merging BioentryQualifierValue instance");
        try {
            BioentryQualifierValue result = (BioentryQualifierValue) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(BioentryQualifierValue instance) {
        log.debug("attaching dirty BioentryQualifierValue instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(BioentryQualifierValue instance) {
        log.debug("attaching clean BioentryQualifierValue instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}