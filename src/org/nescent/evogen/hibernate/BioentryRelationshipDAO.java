package org.nescent.evogen.hibernate;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * Data access object (DAO) for domain model class BioentryRelationship.
 * @see org.nescent.evogen.hibernate.BioentryRelationship
 * @author MyEclipse - Hibernate Tools
 */
public class BioentryRelationshipDAO extends BaseHibernateDAO {

    private static final Log log = LogFactory.getLog(BioentryRelationshipDAO.class);

	//property constants
	public static final String RANK = "rank";

    
    public void save(BioentryRelationship transientInstance) {
        log.debug("saving BioentryRelationship instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(BioentryRelationship persistentInstance) {
        log.debug("deleting BioentryRelationship instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public BioentryRelationship findById( java.lang.Integer id) {
        log.debug("getting BioentryRelationship instance with id: " + id);
        try {
            BioentryRelationship instance = (BioentryRelationship) getSession()
                    .get("org.nescent.evogen.hibernate.BioentryRelationship", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(BioentryRelationship instance) {
        log.debug("finding BioentryRelationship instance by example");
        try {
            List results = getSession()
                    .createCriteria("org.nescent.evogen.hibernate.BioentryRelationship")
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
      log.debug("finding BioentryRelationship instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from BioentryRelationship as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByRank(Object rank) {
		return findByProperty(RANK, rank);
	}
	
    public BioentryRelationship merge(BioentryRelationship detachedInstance) {
        log.debug("merging BioentryRelationship instance");
        try {
            BioentryRelationship result = (BioentryRelationship) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(BioentryRelationship instance) {
        log.debug("attaching dirty BioentryRelationship instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(BioentryRelationship instance) {
        log.debug("attaching clean BioentryRelationship instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}