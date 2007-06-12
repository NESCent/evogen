package org.nescent.evogen.hibernate;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * Data access object (DAO) for domain model class TaxonName.
 * @see org.nescent.evogen.hibernate.TaxonName
 * @author MyEclipse - Hibernate Tools
 */
public class TaxonNameDAO extends BaseHibernateDAO {

    private static final Log log = LogFactory.getLog(TaxonNameDAO.class);

	//property constants

    
    public void save(TaxonName transientInstance) {
        log.debug("saving TaxonName instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(TaxonName persistentInstance) {
        log.debug("deleting TaxonName instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public TaxonName findById( org.nescent.evogen.hibernate.TaxonNameId id) {
        log.debug("getting TaxonName instance with id: " + id);
        try {
            TaxonName instance = (TaxonName) getSession()
                    .get("org.nescent.evogen.hibernate.TaxonName", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(TaxonName instance) {
        log.debug("finding TaxonName instance by example");
        try {
            List results = getSession()
                    .createCriteria("org.nescent.evogen.hibernate.TaxonName")
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
      log.debug("finding TaxonName instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from TaxonName as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

    public TaxonName merge(TaxonName detachedInstance) {
        log.debug("merging TaxonName instance");
        try {
            TaxonName result = (TaxonName) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(TaxonName instance) {
        log.debug("attaching dirty TaxonName instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(TaxonName instance) {
        log.debug("attaching clean TaxonName instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}