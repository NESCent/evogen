package org.nescent.evogen.hibernate;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * Data access object (DAO) for domain model class Tree.
 * @see org.nescent.evogen.hibernate.Tree
 * @author MyEclipse - Hibernate Tools
 */
public class TreeDAO extends BaseHibernateDAO {

    private static final Log log = LogFactory.getLog(TreeDAO.class);

	//property constants
	public static final String NAME = "name";
	public static final String IDENTIFIER = "identifier";
	public static final String IS_ROOTED = "isRooted";

    
    public void save(Tree transientInstance) {
        log.debug("saving Tree instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Tree persistentInstance) {
        log.debug("deleting Tree instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Tree findById( java.lang.Integer id) {
        log.debug("getting Tree instance with id: " + id);
        try {
            Tree instance = (Tree) getSession()
                    .get("org.nescent.evogen.hibernate.Tree", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Tree instance) {
        log.debug("finding Tree instance by example");
        try {
            List results = getSession()
                    .createCriteria("org.nescent.evogen.hibernate.Tree")
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
      log.debug("finding Tree instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Tree as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}
	
	public List findByIdentifier(Object identifier) {
		return findByProperty(IDENTIFIER, identifier);
	}
	
	public List findByIsRooted(Object isRooted) {
		return findByProperty(IS_ROOTED, isRooted);
	}
	
    public Tree merge(Tree detachedInstance) {
        log.debug("merging Tree instance");
        try {
            Tree result = (Tree) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Tree instance) {
        log.debug("attaching dirty Tree instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Tree instance) {
        log.debug("attaching clean Tree instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}