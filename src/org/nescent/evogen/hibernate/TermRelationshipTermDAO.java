package org.nescent.evogen.hibernate;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * Data access object (DAO) for domain model class TermRelationshipTerm.
 * @see org.nescent.evogen.hibernate.TermRelationshipTerm
 * @author MyEclipse - Hibernate Tools
 */
public class TermRelationshipTermDAO extends BaseHibernateDAO {

    private static final Log log = LogFactory.getLog(TermRelationshipTermDAO.class);

	//property constants

    
    public void save(TermRelationshipTerm transientInstance) {
        log.debug("saving TermRelationshipTerm instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(TermRelationshipTerm persistentInstance) {
        log.debug("deleting TermRelationshipTerm instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public TermRelationshipTerm findById( java.lang.Integer id) {
        log.debug("getting TermRelationshipTerm instance with id: " + id);
        try {
            TermRelationshipTerm instance = (TermRelationshipTerm) getSession()
                    .get("org.nescent.evogen.hibernate.TermRelationshipTerm", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(TermRelationshipTerm instance) {
        log.debug("finding TermRelationshipTerm instance by example");
        try {
            List results = getSession()
                    .createCriteria("org.nescent.evogen.hibernate.TermRelationshipTerm")
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
      log.debug("finding TermRelationshipTerm instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from TermRelationshipTerm as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

    public TermRelationshipTerm merge(TermRelationshipTerm detachedInstance) {
        log.debug("merging TermRelationshipTerm instance");
        try {
            TermRelationshipTerm result = (TermRelationshipTerm) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(TermRelationshipTerm instance) {
        log.debug("attaching dirty TermRelationshipTerm instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(TermRelationshipTerm instance) {
        log.debug("attaching clean TermRelationshipTerm instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}