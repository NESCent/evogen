package org.nescent.evogen.hibernate;



/**
 * LocationQualifierValueId generated by MyEclipse - Hibernate Tools
 */

public class LocationQualifierValueId  implements java.io.Serializable {


    // Fields    

     private Location location;
     private Term term;


    // Constructors

    /** default constructor */
    public LocationQualifierValueId() {
    }

    
    /** full constructor */
    public LocationQualifierValueId(Location location, Term term) {
        this.location = location;
        this.term = term;
    }

   
    // Property accessors

    public Location getLocation() {
        return this.location;
    }
    
    public void setLocation(Location location) {
        this.location = location;
    }

    public Term getTerm() {
        return this.term;
    }
    
    public void setTerm(Term term) {
        this.term = term;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof LocationQualifierValueId) ) return false;
		 LocationQualifierValueId castOther = ( LocationQualifierValueId ) other; 
         
		 return ( (this.getLocation()==castOther.getLocation()) || ( this.getLocation()!=null && castOther.getLocation()!=null && this.getLocation().equals(castOther.getLocation()) ) )
 && ( (this.getTerm()==castOther.getTerm()) || ( this.getTerm()!=null && castOther.getTerm()!=null && this.getTerm().equals(castOther.getTerm()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getLocation() == null ? 0 : this.getLocation().hashCode() );
         result = 37 * result + ( getTerm() == null ? 0 : this.getTerm().hashCode() );
         return result;
   }   





}