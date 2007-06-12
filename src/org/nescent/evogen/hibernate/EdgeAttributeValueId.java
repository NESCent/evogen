package org.nescent.evogen.hibernate;



/**
 * EdgeAttributeValueId generated by MyEclipse - Hibernate Tools
 */

public class EdgeAttributeValueId  implements java.io.Serializable {


    // Fields    

     private String value;
     private Edge edge;
     private Term term;


    // Constructors

    /** default constructor */
    public EdgeAttributeValueId() {
    }

	/** minimal constructor */
    public EdgeAttributeValueId(Edge edge, Term term) {
        this.edge = edge;
        this.term = term;
    }
    
    /** full constructor */
    public EdgeAttributeValueId(String value, Edge edge, Term term) {
        this.value = value;
        this.edge = edge;
        this.term = term;
    }

   
    // Property accessors

    public String getValue() {
        return this.value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }

    public Edge getEdge() {
        return this.edge;
    }
    
    public void setEdge(Edge edge) {
        this.edge = edge;
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
		 if ( !(other instanceof EdgeAttributeValueId) ) return false;
		 EdgeAttributeValueId castOther = ( EdgeAttributeValueId ) other; 
         
		 return ( (this.getValue()==castOther.getValue()) || ( this.getValue()!=null && castOther.getValue()!=null && this.getValue().equals(castOther.getValue()) ) )
 && ( (this.getEdge()==castOther.getEdge()) || ( this.getEdge()!=null && castOther.getEdge()!=null && this.getEdge().equals(castOther.getEdge()) ) )
 && ( (this.getTerm()==castOther.getTerm()) || ( this.getTerm()!=null && castOther.getTerm()!=null && this.getTerm().equals(castOther.getTerm()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getValue() == null ? 0 : this.getValue().hashCode() );
         result = 37 * result + ( getEdge() == null ? 0 : this.getEdge().hashCode() );
         result = 37 * result + ( getTerm() == null ? 0 : this.getTerm().hashCode() );
         return result;
   }   





}