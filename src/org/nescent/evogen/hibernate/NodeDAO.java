package org.nescent.evogen.hibernate;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * Data access object (DAO) for domain model class Node.
 * @see org.nescent.evogen.hibernate.Node
 * @author MyEclipse - Hibernate Tools
 */
public class NodeDAO extends BaseHibernateDAO {

    private static final Log log = LogFactory.getLog(NodeDAO.class);

	//property constants
	public static final String LABEL = "label";
	public static final String LEFT_IDX = "leftIdx";
	public static final String RIGHT_IDX = "rightIdx";

    
    public void save(Node transientInstance) {
        log.debug("saving Node instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Node persistentInstance) {
        log.debug("deleting Node instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Node findById( java.lang.Integer id) {
        log.debug("getting Node instance with id: " + id);
        try {
            Node instance = (Node) getSession()
                    .get("org.nescent.evogen.hibernate.Node", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Node instance) {
        log.debug("finding Node instance by example");
        try {
            List results = getSession()
                    .createCriteria("org.nescent.evogen.hibernate.Node")
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
      log.debug("finding Node instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Node as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByLabel(Object label) {
		return findByProperty(LABEL, label);
	}
	
	public List findByLeftIdx(Object leftIdx) {
		return findByProperty(LEFT_IDX, leftIdx);
	}
	
	public List findByRightIdx(Object rightIdx) {
		return findByProperty(RIGHT_IDX, rightIdx);
	}
	
    public Node merge(Node detachedInstance) {
        log.debug("merging Node instance");
        try {
            Node result = (Node) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Node instance) {
        log.debug("attaching dirty Node instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Node instance) {
        log.debug("attaching clean Node instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}