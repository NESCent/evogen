package org.nescent.evogen.hibernate;



/**
 * TermDbxref generated by MyEclipse - Hibernate Tools
 */

public class TermDbxref  implements java.io.Serializable {


    // Fields    

     private TermDbxrefId id;
     private Integer rank;


    // Constructors

    /** default constructor */
    public TermDbxref() {
    }

    
    /** full constructor */
    public TermDbxref(Integer rank) {
        this.rank = rank;
    }

   
    // Property accessors

    public TermDbxrefId getId() {
        return this.id;
    }
    
    public void setId(TermDbxrefId id) {
        this.id = id;
    }

    public Integer getRank() {
        return this.rank;
    }
    
    public void setRank(Integer rank) {
        this.rank = rank;
    }
   








}