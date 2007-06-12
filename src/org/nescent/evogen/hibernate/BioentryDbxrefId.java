package org.nescent.evogen.hibernate;



/**
 * BioentryDbxrefId generated by MyEclipse - Hibernate Tools
 */

public class BioentryDbxrefId  implements java.io.Serializable {


    // Fields    

     private Bioentry bioentry;
     private Dbxref dbxref;


    // Constructors

    /** default constructor */
    public BioentryDbxrefId() {
    }

    
    /** full constructor */
    public BioentryDbxrefId(Bioentry bioentry, Dbxref dbxref) {
        this.bioentry = bioentry;
        this.dbxref = dbxref;
    }

   
    // Property accessors

    public Bioentry getBioentry() {
        return this.bioentry;
    }
    
    public void setBioentry(Bioentry bioentry) {
        this.bioentry = bioentry;
    }

    public Dbxref getDbxref() {
        return this.dbxref;
    }
    
    public void setDbxref(Dbxref dbxref) {
        this.dbxref = dbxref;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof BioentryDbxrefId) ) return false;
		 BioentryDbxrefId castOther = ( BioentryDbxrefId ) other; 
         
		 return ( (this.getBioentry()==castOther.getBioentry()) || ( this.getBioentry()!=null && castOther.getBioentry()!=null && this.getBioentry().equals(castOther.getBioentry()) ) )
 && ( (this.getDbxref()==castOther.getDbxref()) || ( this.getDbxref()!=null && castOther.getDbxref()!=null && this.getDbxref().equals(castOther.getDbxref()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getBioentry() == null ? 0 : this.getBioentry().hashCode() );
         result = 37 * result + ( getDbxref() == null ? 0 : this.getDbxref().hashCode() );
         return result;
   }   





}