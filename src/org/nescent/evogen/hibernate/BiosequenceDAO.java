package org.nescent.evogen.hibernate;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * Data access object (DAO) for domain model class Biosequence.
 * @see org.nescent.evogen.hibernate.Biosequence
 * @author MyEclipse - Hibernate Tools
 */
public class BiosequenceDAO extends BaseHibernateDAO {

    private static final Log log = LogFactory.getLog(BiosequenceDAO.class);

	//property constants
	public static final String VERSION = "version";
	public static final String LENGTH = "length";
	public static final String ALPHABET = "alphabet";
	public static final String SEQ = "seq";

    
    public void save(Biosequence transientInstance) {
        log.debug("saving Biosequence instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Biosequence persistentInstance) {
        log.debug("deleting Biosequence instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Biosequence findById( java.lang.Integer id) {
        log.debug("getting Biosequence instance with id: " + id);
        try {
            Biosequence instance = (Biosequence) getSession()
                    .get("org.nescent.evogen.hibernate.Biosequence", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Biosequence instance) {
        log.debug("finding Biosequence instance by example");
        try {
            List results = getSession()
                    .createCriteria("org.nescent.evogen.hibernate.Biosequence")
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
      log.debug("finding Biosequence instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Biosequence as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByVersion(Object version) {
		return findByProperty(VERSION, version);
	}
	
	public List findByLength(Object length) {
		return findByProperty(LENGTH, length);
	}
	
	public List findByAlphabet(Object alphabet) {
		return findByProperty(ALPHABET, alphabet);
	}
	
	public List findBySeq(Object seq) {
		return findByProperty(SEQ, seq);
	}
	
    public Biosequence merge(Biosequence detachedInstance) {
        log.debug("merging Biosequence instance");
        try {
            Biosequence result = (Biosequence) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Biosequence instance) {
        log.debug("attaching dirty Biosequence instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Biosequence instance) {
        log.debug("attaching clean Biosequence instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}