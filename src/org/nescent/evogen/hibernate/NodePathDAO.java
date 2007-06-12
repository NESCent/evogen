package org.nescent.evogen.hibernate;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * Data access object (DAO) for domain model class NodePath.
 * @see org.nescent.evogen.hibernate.NodePath
 * @author MyEclipse - Hibernate Tools
 */
public class NodePathDAO extends BaseHibernateDAO {

    private static final Log log = LogFactory.getLog(NodePathDAO.class);

	//property constants
	public static final String PATH = "path";

    
    public void save(NodePath transientInstance) {
        log.debug("saving NodePath instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(NodePath persistentInstance) {
        log.debug("deleting NodePath instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public NodePath findById( org.nescent.evogen.hibernate.NodePathId id) {
        log.debug("getting NodePath instance with id: " + id);
        try {
            NodePath instance = (NodePath) getSession()
                    .get("org.nescent.evogen.hibernate.NodePath", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(NodePath instance) {
        log.debug("finding NodePath instance by example");
        try {
            List results = getSession()
                    .createCriteria("org.nescent.evogen.hibernate.NodePath")
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
      log.debug("finding NodePath instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from NodePath as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByPath(Object path) {
		return findByProperty(PATH, path);
	}
	
    public NodePath merge(NodePath detachedInstance) {
        log.debug("merging NodePath instance");
        try {
            NodePath result = (NodePath) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(NodePath instance) {
        log.debug("attaching dirty NodePath instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(NodePath instance) {
        log.debug("attaching clean NodePath instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}