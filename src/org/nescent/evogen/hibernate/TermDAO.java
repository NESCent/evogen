package org.nescent.evogen.hibernate;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * Data access object (DAO) for domain model class Term.
 * @see org.nescent.evogen.hibernate.Term
 * @author MyEclipse - Hibernate Tools
 */
public class TermDAO extends BaseHibernateDAO {

    private static final Log log = LogFactory.getLog(TermDAO.class);

	//property constants
	public static final String NAME = "name";
	public static final String DEFINITION = "definition";
	public static final String IDENTIFIER = "identifier";
	public static final String IS_OBSOLETE = "isObsolete";

    
    public void save(Term transientInstance) {
        log.debug("saving Term instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Term persistentInstance) {
        log.debug("deleting Term instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Term findById( java.lang.Integer id) {
        log.debug("getting Term instance with id: " + id);
        try {
            Term instance = (Term) getSession()
                    .get("org.nescent.evogen.hibernate.Term", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Term instance) {
        log.debug("finding Term instance by example");
        try {
            List results = getSession()
                    .createCriteria("org.nescent.evogen.hibernate.Term")
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
      log.debug("finding Term instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Term as model where model." 
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
	
	public List findByDefinition(Object definition) {
		return findByProperty(DEFINITION, definition);
	}
	
	public List findByIdentifier(Object identifier) {
		return findByProperty(IDENTIFIER, identifier);
	}
	
	public List findByIsObsolete(Object isObsolete) {
		return findByProperty(IS_OBSOLETE, isObsolete);
	}
	
    public Term merge(Term detachedInstance) {
        log.debug("merging Term instance");
        try {
            Term result = (Term) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Term instance) {
        log.debug("attaching dirty Term instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Term instance) {
        log.debug("attaching clean Term instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}