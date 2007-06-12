package org.nescent.evogen.hibernate;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * Data access object (DAO) for domain model class Biodatabase.
 * @see org.nescent.evogen.hibernate.Biodatabase
 * @author MyEclipse - Hibernate Tools
 */
public class BiodatabaseDAO extends BaseHibernateDAO {

    private static final Log log = LogFactory.getLog(BiodatabaseDAO.class);

	//property constants
	public static final String NAME = "name";
	public static final String AUTHORITY = "authority";
	public static final String DESCRIPTION = "description";

    
    public void save(Biodatabase transientInstance) {
        log.debug("saving Biodatabase instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Biodatabase persistentInstance) {
        log.debug("deleting Biodatabase instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Biodatabase findById( java.lang.Integer id) {
        log.debug("getting Biodatabase instance with id: " + id);
        try {
            Biodatabase instance = (Biodatabase) getSession()
                    .get("org.nescent.evogen.hibernate.Biodatabase", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Biodatabase instance) {
        log.debug("finding Biodatabase instance by example");
        try {
            List results = getSession()
                    .createCriteria("org.nescent.evogen.hibernate.Biodatabase")
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
      log.debug("finding Biodatabase instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Biodatabase as model where model." 
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
	
	public List findByAuthority(Object authority) {
		return findByProperty(AUTHORITY, authority);
	}
	
	public List findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}
	
    public Biodatabase merge(Biodatabase detachedInstance) {
        log.debug("merging Biodatabase instance");
        try {
            Biodatabase result = (Biodatabase) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Biodatabase instance) {
        log.debug("attaching dirty Biodatabase instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Biodatabase instance) {
        log.debug("attaching clean Biodatabase instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}