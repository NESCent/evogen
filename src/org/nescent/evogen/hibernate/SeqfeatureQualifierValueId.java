package org.nescent.evogen.hibernate;



/**
 * SeqfeatureQualifierValueId generated by MyEclipse - Hibernate Tools
 */

public class SeqfeatureQualifierValueId  implements java.io.Serializable {


    // Fields    

     private Seqfeature seqfeature;
     private Term term;
     private Integer rank;


    // Constructors

    /** default constructor */
    public SeqfeatureQualifierValueId() {
    }

    
    /** full constructor */
    public SeqfeatureQualifierValueId(Seqfeature seqfeature, Term term, Integer rank) {
        this.seqfeature = seqfeature;
        this.term = term;
        this.rank = rank;
    }

   
    // Property accessors

    public Seqfeature getSeqfeature() {
        return this.seqfeature;
    }
    
    public void setSeqfeature(Seqfeature seqfeature) {
        this.seqfeature = seqfeature;
    }

    public Term getTerm() {
        return this.term;
    }
    
    public void setTerm(Term term) {
        this.term = term;
    }

    public Integer getRank() {
        return this.rank;
    }
    
    public void setRank(Integer rank) {
        this.rank = rank;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof SeqfeatureQualifierValueId) ) return false;
		 SeqfeatureQualifierValueId castOther = ( SeqfeatureQualifierValueId ) other; 
         
		 return ( (this.getSeqfeature()==castOther.getSeqfeature()) || ( this.getSeqfeature()!=null && castOther.getSeqfeature()!=null && this.getSeqfeature().equals(castOther.getSeqfeature()) ) )
 && ( (this.getTerm()==castOther.getTerm()) || ( this.getTerm()!=null && castOther.getTerm()!=null && this.getTerm().equals(castOther.getTerm()) ) )
 && ( (this.getRank()==castOther.getRank()) || ( this.getRank()!=null && castOther.getRank()!=null && this.getRank().equals(castOther.getRank()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getSeqfeature() == null ? 0 : this.getSeqfeature().hashCode() );
         result = 37 * result + ( getTerm() == null ? 0 : this.getTerm().hashCode() );
         result = 37 * result + ( getRank() == null ? 0 : this.getRank().hashCode() );
         return result;
   }   





}