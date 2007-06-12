package org.nescent.evogen.hibernate;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * Data access object (DAO) for domain model class Taxon.
 * @see org.nescent.evogen.hibernate.Taxon
 * @author MyEclipse - Hibernate Tools
 */
public class TaxonDAO extends BaseHibernateDAO {

    private static final Log log = LogFactory.getLog(TaxonDAO.class);

	//property constants
	public static final String NCBI_TAXON_ID = "ncbiTaxonId";
	public static final String PARENT_TAXON_ID = "parentTaxonId";
	public static final String NODE_RANK = "nodeRank";
	public static final String GENETIC_CODE = "geneticCode";
	public static final String MITO_GENETIC_CODE = "mitoGeneticCode";
	public static final String LEFT_VALUE = "leftValue";
	public static final String RIGHT_VALUE = "rightValue";

    
    public void save(Taxon transientInstance) {
        log.debug("saving Taxon instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Taxon persistentInstance) {
        log.debug("deleting Taxon instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Taxon findById( java.lang.Integer id) {
        log.debug("getting Taxon instance with id: " + id);
        try {
            Taxon instance = (Taxon) getSession()
                    .get("org.nescent.evogen.hibernate.Taxon", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Taxon instance) {
        log.debug("finding Taxon instance by example");
        try {
            List results = getSession()
                    .createCriteria("org.nescent.evogen.hibernate.Taxon")
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
      log.debug("finding Taxon instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Taxon as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByNcbiTaxonId(Object ncbiTaxonId) {
		return findByProperty(NCBI_TAXON_ID, ncbiTaxonId);
	}
	
	public List findByParentTaxonId(Object parentTaxonId) {
		return findByProperty(PARENT_TAXON_ID, parentTaxonId);
	}
	
	public List findByNodeRank(Object nodeRank) {
		return findByProperty(NODE_RANK, nodeRank);
	}
	
	public List findByGeneticCode(Object geneticCode) {
		return findByProperty(GENETIC_CODE, geneticCode);
	}
	
	public List findByMitoGeneticCode(Object mitoGeneticCode) {
		return findByProperty(MITO_GENETIC_CODE, mitoGeneticCode);
	}
	
	public List findByLeftValue(Object leftValue) {
		return findByProperty(LEFT_VALUE, leftValue);
	}
	
	public List findByRightValue(Object rightValue) {
		return findByProperty(RIGHT_VALUE, rightValue);
	}
	
    public Taxon merge(Taxon detachedInstance) {
        log.debug("merging Taxon instance");
        try {
            Taxon result = (Taxon) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Taxon instance) {
        log.debug("attaching dirty Taxon instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Taxon instance) {
        log.debug("attaching clean Taxon instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}