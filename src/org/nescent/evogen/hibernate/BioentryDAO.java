package org.nescent.evogen.hibernate;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * Data access object (DAO) for domain model class Bioentry.
 * @see org.nescent.evogen.hibernate.Bioentry
 * @author MyEclipse - Hibernate Tools
 */
public class BioentryDAO extends BaseHibernateDAO {

    private static final Log log = LogFactory.getLog(BioentryDAO.class);

	//property constants
	public static final String NAME = "name";
	public static final String ACCESSION = "accession";
	public static final String IDENTIFIER = "identifier";
	public static final String DIVISION = "division";
	public static final String DESCRIPTION = "description";
	public static final String VERSION = "version";

    
    public void save(Bioentry transientInstance) {
        log.debug("saving Bioentry instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Bioentry persistentInstance) {
        log.debug("deleting Bioentry instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Bioentry findById( java.lang.Integer id) {
        log.debug("getting Bioentry instance with id: " + id);
        try {
            Bioentry instance = (Bioentry) getSession()
                    .get("org.nescent.evogen.hibernate.Bioentry", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Bioentry instance) {
        log.debug("finding Bioentry instance by example");
        try {
            List results = getSession()
                    .createCriteria("org.nescent.evogen.hibernate.Bioentry")
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
      log.debug("finding Bioentry instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Bioentry as model where model." 
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
	
	public List findByAccession(Object accession) {
		return findByProperty(ACCESSION, accession);
	}
	
	public List findByIdentifier(Object identifier) {
		return findByProperty(IDENTIFIER, identifier);
	}
	
	public List findByDivision(Object division) {
		return findByProperty(DIVISION, division);
	}
	
	public List findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}
	
	public List findByVersion(Object version) {
		return findByProperty(VERSION, version);
	}
	
    public Bioentry merge(Bioentry detachedInstance) {
        log.debug("merging Bioentry instance");
        try {
            Bioentry result = (Bioentry) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Bioentry instance) {
        log.debug("attaching dirty Bioentry instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Bioentry instance) {
        log.debug("attaching clean Bioentry instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}