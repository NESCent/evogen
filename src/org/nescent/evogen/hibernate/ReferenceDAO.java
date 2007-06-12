package org.nescent.evogen.hibernate;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * Data access object (DAO) for domain model class Reference.
 * @see org.nescent.evogen.hibernate.Reference
 * @author MyEclipse - Hibernate Tools
 */
public class ReferenceDAO extends BaseHibernateDAO {

    private static final Log log = LogFactory.getLog(ReferenceDAO.class);

	//property constants
	public static final String LOCATION = "location";
	public static final String TITLE = "title";
	public static final String AUTHORS = "authors";
	public static final String CRC = "crc";

    
    public void save(Reference transientInstance) {
        log.debug("saving Reference instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Reference persistentInstance) {
        log.debug("deleting Reference instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Reference findById( java.lang.Integer id) {
        log.debug("getting Reference instance with id: " + id);
        try {
            Reference instance = (Reference) getSession()
                    .get("org.nescent.evogen.hibernate.Reference", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Reference instance) {
        log.debug("finding Reference instance by example");
        try {
            List results = getSession()
                    .createCriteria("org.nescent.evogen.hibernate.Reference")
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
      log.debug("finding Reference instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Reference as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByLocation(Object location) {
		return findByProperty(LOCATION, location);
	}
	
	public List findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}
	
	public List findByAuthors(Object authors) {
		return findByProperty(AUTHORS, authors);
	}
	
	public List findByCrc(Object crc) {
		return findByProperty(CRC, crc);
	}
	
    public Reference merge(Reference detachedInstance) {
        log.debug("merging Reference instance");
        try {
            Reference result = (Reference) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Reference instance) {
        log.debug("attaching dirty Reference instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Reference instance) {
        log.debug("attaching clean Reference instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}