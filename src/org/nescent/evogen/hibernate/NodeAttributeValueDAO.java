package org.nescent.evogen.hibernate;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * Data access object (DAO) for domain model class NodeAttributeValue.
 * @see org.nescent.evogen.hibernate.NodeAttributeValue
 * @author MyEclipse - Hibernate Tools
 */
public class NodeAttributeValueDAO extends BaseHibernateDAO {

    private static final Log log = LogFactory.getLog(NodeAttributeValueDAO.class);

	//property constants

    
    public void save(NodeAttributeValue transientInstance) {
        log.debug("saving NodeAttributeValue instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(NodeAttributeValue persistentInstance) {
        log.debug("deleting NodeAttributeValue instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public NodeAttributeValue findById( org.nescent.evogen.hibernate.NodeAttributeValueId id) {
        log.debug("getting NodeAttributeValue instance with id: " + id);
        try {
            NodeAttributeValue instance = (NodeAttributeValue) getSession()
                    .get("org.nescent.evogen.hibernate.NodeAttributeValue", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(NodeAttributeValue instance) {
        log.debug("finding NodeAttributeValue instance by example");
        try {
            List results = getSession()
                    .createCriteria("org.nescent.evogen.hibernate.NodeAttributeValue")
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
      log.debug("finding NodeAttributeValue instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from NodeAttributeValue as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

    public NodeAttributeValue merge(NodeAttributeValue detachedInstance) {
        log.debug("merging NodeAttributeValue instance");
        try {
            NodeAttributeValue result = (NodeAttributeValue) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(NodeAttributeValue instance) {
        log.debug("attaching dirty NodeAttributeValue instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(NodeAttributeValue instance) {
        log.debug("attaching clean NodeAttributeValue instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}