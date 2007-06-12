package org.nescent.evogen.hibernate;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * Data access object (DAO) for domain model class EdgeAttributeValue.
 * @see org.nescent.evogen.hibernate.EdgeAttributeValue
 * @author MyEclipse - Hibernate Tools
 */
public class EdgeAttributeValueDAO extends BaseHibernateDAO {

    private static final Log log = LogFactory.getLog(EdgeAttributeValueDAO.class);

	//property constants

    
    public void save(EdgeAttributeValue transientInstance) {
        log.debug("saving EdgeAttributeValue instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(EdgeAttributeValue persistentInstance) {
        log.debug("deleting EdgeAttributeValue instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public EdgeAttributeValue findById( org.nescent.evogen.hibernate.EdgeAttributeValueId id) {
        log.debug("getting EdgeAttributeValue instance with id: " + id);
        try {
            EdgeAttributeValue instance = (EdgeAttributeValue) getSession()
                    .get("org.nescent.evogen.hibernate.EdgeAttributeValue", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(EdgeAttributeValue instance) {
        log.debug("finding EdgeAttributeValue instance by example");
        try {
            List results = getSession()
                    .createCriteria("org.nescent.evogen.hibernate.EdgeAttributeValue")
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
      log.debug("finding EdgeAttributeValue instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from EdgeAttributeValue as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

    public EdgeAttributeValue merge(EdgeAttributeValue detachedInstance) {
        log.debug("merging EdgeAttributeValue instance");
        try {
            EdgeAttributeValue result = (EdgeAttributeValue) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(EdgeAttributeValue instance) {
        log.debug("attaching dirty EdgeAttributeValue instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(EdgeAttributeValue instance) {
        log.debug("attaching clean EdgeAttributeValue instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}