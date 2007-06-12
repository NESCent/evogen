package org.nescent.evogen.hibernate;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * Data access object (DAO) for domain model class SeqfeatureRelationship.
 * @see org.nescent.evogen.hibernate.SeqfeatureRelationship
 * @author MyEclipse - Hibernate Tools
 */
public class SeqfeatureRelationshipDAO extends BaseHibernateDAO {

    private static final Log log = LogFactory.getLog(SeqfeatureRelationshipDAO.class);

	//property constants
	public static final String RANK = "rank";

    
    public void save(SeqfeatureRelationship transientInstance) {
        log.debug("saving SeqfeatureRelationship instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(SeqfeatureRelationship persistentInstance) {
        log.debug("deleting SeqfeatureRelationship instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public SeqfeatureRelationship findById( java.lang.Integer id) {
        log.debug("getting SeqfeatureRelationship instance with id: " + id);
        try {
            SeqfeatureRelationship instance = (SeqfeatureRelationship) getSession()
                    .get("org.nescent.evogen.hibernate.SeqfeatureRelationship", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(SeqfeatureRelationship instance) {
        log.debug("finding SeqfeatureRelationship instance by example");
        try {
            List results = getSession()
                    .createCriteria("org.nescent.evogen.hibernate.SeqfeatureRelationship")
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
      log.debug("finding SeqfeatureRelationship instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from SeqfeatureRelationship as model where model." 
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
	
    public SeqfeatureRelationship merge(SeqfeatureRelationship detachedInstance) {
        log.debug("merging SeqfeatureRelationship instance");
        try {
            SeqfeatureRelationship result = (SeqfeatureRelationship) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(SeqfeatureRelationship instance) {
        log.debug("attaching dirty SeqfeatureRelationship instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(SeqfeatureRelationship instance) {
        log.debug("attaching clean SeqfeatureRelationship instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}