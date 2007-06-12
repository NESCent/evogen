package org.nescent.evogen.hibernate;



/**
 * TaxonNameId generated by MyEclipse - Hibernate Tools
 */

public class TaxonNameId  implements java.io.Serializable {


    // Fields    

     private Taxon taxon;
     private String name;
     private String nameClass;


    // Constructors

    /** default constructor */
    public TaxonNameId() {
    }

    
    /** full constructor */
    public TaxonNameId(Taxon taxon, String name, String nameClass) {
        this.taxon = taxon;
        this.name = name;
        this.nameClass = nameClass;
    }

   
    // Property accessors

    public Taxon getTaxon() {
        return this.taxon;
    }
    
    public void setTaxon(Taxon taxon) {
        this.taxon = taxon;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getNameClass() {
        return this.nameClass;
    }
    
    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof TaxonNameId) ) return false;
		 TaxonNameId castOther = ( TaxonNameId ) other; 
         
		 return ( (this.getTaxon()==castOther.getTaxon()) || ( this.getTaxon()!=null && castOther.getTaxon()!=null && this.getTaxon().equals(castOther.getTaxon()) ) )
 && ( (this.getName()==castOther.getName()) || ( this.getName()!=null && castOther.getName()!=null && this.getName().equals(castOther.getName()) ) )
 && ( (this.getNameClass()==castOther.getNameClass()) || ( this.getNameClass()!=null && castOther.getNameClass()!=null && this.getNameClass().equals(castOther.getNameClass()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getTaxon() == null ? 0 : this.getTaxon().hashCode() );
         result = 37 * result + ( getName() == null ? 0 : this.getName().hashCode() );
         result = 37 * result + ( getNameClass() == null ? 0 : this.getNameClass().hashCode() );
         return result;
   }   





}