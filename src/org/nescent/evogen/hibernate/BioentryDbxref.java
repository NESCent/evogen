package org.nescent.evogen.hibernate;



/**
 * BioentryDbxref generated by MyEclipse - Hibernate Tools
 */

public class BioentryDbxref  implements java.io.Serializable {


    // Fields    

     private BioentryDbxrefId id;
     private Integer rank;


    // Constructors

    /** default constructor */
    public BioentryDbxref() {
    }

    
    /** full constructor */
    public BioentryDbxref(Integer rank) {
        this.rank = rank;
    }

   
    // Property accessors

    public BioentryDbxrefId getId() {
        return this.id;
    }
    
    public void setId(BioentryDbxrefId id) {
        this.id = id;
    }

    public Integer getRank() {
        return this.rank;
    }
    
    public void setRank(Integer rank) {
        this.rank = rank;
    }
   








}