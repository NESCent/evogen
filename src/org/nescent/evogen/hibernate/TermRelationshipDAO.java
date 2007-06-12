package org.nescent.evogen.hibernate;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * Data access object (DAO) for domain model class TermRelationship.
 * @see org.nescent.evogen.hibernate.TermRelationship
 * @author MyEclipse - Hibernate Tools
 */
public class TermRelationshipDAO extends BaseHibernateDAO {

    private static final Log log = LogFactory.getLog(TermRelationshipDAO.class);

	//property constants

    
    public void save(TermRelationship transientInstance) {
        log.debug("saving TermRelationship instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(TermRelationship persistentInstance) {
        log.debug("deleting TermRelationship instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public TermRelationship findById( java.lang.Integer id) {
        log.debug("getting TermRelationship instance with id: " + id);
        try {
            TermRelationship instance = (TermRelationship) getSession()
                    .get("org.nescent.evogen.hibernate.TermRelationship", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(TermRelationship instance) {
        log.debug("finding TermRelationship instance by example");
        try {
            List results = getSession()
                    .createCriteria("org.nescent.evogen.hibernate.TermRelationship")
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
      log.debug("finding TermRelationship instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from TermRelationship as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

    public TermRelationship merge(TermRelationship detachedInstance) {
        log.debug("merging TermRelationship instance");
        try {
            TermRelationship result = (TermRelationship) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(TermRelationship instance) {
        log.debug("attaching dirty TermRelationship instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(TermRelationship instance) {
        log.debug("attaching clean TermRelationship instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}