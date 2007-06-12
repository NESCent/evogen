package org.nescent.evogen.hibernate;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * Data access object (DAO) for domain model class Seqfeature.
 * @see org.nescent.evogen.hibernate.Seqfeature
 * @author MyEclipse - Hibernate Tools
 */
public class SeqfeatureDAO extends BaseHibernateDAO {

    private static final Log log = LogFactory.getLog(SeqfeatureDAO.class);

	//property constants
	public static final String DISPLAY_NAME = "displayName";
	public static final String RANK = "rank";

    
    public void save(Seqfeature transientInstance) {
        log.debug("saving Seqfeature instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Seqfeature persistentInstance) {
        log.debug("deleting Seqfeature instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Seqfeature findById( java.lang.Integer id) {
        log.debug("getting Seqfeature instance with id: " + id);
        try {
            Seqfeature instance = (Seqfeature) getSession()
                    .get("org.nescent.evogen.hibernate.Seqfeature", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Seqfeature instance) {
        log.debug("finding Seqfeature instance by example");
        try {
            List results = getSession()
                    .createCriteria("org.nescent.evogen.hibernate.Seqfeature")
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
      log.debug("finding Seqfeature instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Seqfeature as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByDisplayName(Object displayName) {
		return findByProperty(DISPLAY_NAME, displayName);
	}
	
	public List findByRank(Object rank) {
		return findByProperty(RANK, rank);
	}
	
    public Seqfeature merge(Seqfeature detachedInstance) {
        log.debug("merging Seqfeature instance");
        try {
            Seqfeature result = (Seqfeature) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Seqfeature instance) {
        log.debug("attaching dirty Seqfeature instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Seqfeature instance) {
        log.debug("attaching clean Seqfeature instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}