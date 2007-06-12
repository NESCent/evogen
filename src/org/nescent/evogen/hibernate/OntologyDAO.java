package org.nescent.evogen.hibernate;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * Data access object (DAO) for domain model class Ontology.
 * @see org.nescent.evogen.hibernate.Ontology
 * @author MyEclipse - Hibernate Tools
 */
public class OntologyDAO extends BaseHibernateDAO {

    private static final Log log = LogFactory.getLog(OntologyDAO.class);

	//property constants
	public static final String NAME = "name";
	public static final String DEFINITION = "definition";

    
    public void save(Ontology transientInstance) {
        log.debug("saving Ontology instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Ontology persistentInstance) {
        log.debug("deleting Ontology instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Ontology findById( java.lang.Integer id) {
        log.debug("getting Ontology instance with id: " + id);
        try {
            Ontology instance = (Ontology) getSession()
                    .get("org.nescent.evogen.hibernate.Ontology", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Ontology instance) {
        log.debug("finding Ontology instance by example");
        try {
            List results = getSession()
                    .createCriteria("org.nescent.evogen.hibernate.Ontology")
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
      log.debug("finding Ontology instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Ontology as model where model." 
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
	
    public Ontology merge(Ontology detachedInstance) {
        log.debug("merging Ontology instance");
        try {
            Ontology result = (Ontology) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Ontology instance) {
        log.debug("attaching dirty Ontology instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Ontology instance) {
        log.debug("attaching clean Ontology instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}