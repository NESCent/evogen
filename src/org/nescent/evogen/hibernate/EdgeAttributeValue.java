package org.nescent.evogen.hibernate;



/**
 * EdgeAttributeValue generated by MyEclipse - Hibernate Tools
 */

public class EdgeAttributeValue  implements java.io.Serializable {


    // Fields    

     private EdgeAttributeValueId id;
     private Term term;
     private Edge edge;


    // Constructors

    /** default constructor */
    public EdgeAttributeValue() {
    }

    
    /** full constructor */
    public EdgeAttributeValue(Term term, Edge edge) {
        this.term = term;
        this.edge = edge;
    }

   
    // Property accessors

    public EdgeAttributeValueId getId() {
        return this.id;
    }
    
    public void setId(EdgeAttributeValueId id) {
        this.id = id;
    }

    public Term getTerm() {
        return this.term;
    }
    
    public void setTerm(Term term) {
        this.term = term;
    }

    public Edge getEdge() {
        return this.edge;
    }
    
    public void setEdge(Edge edge) {
        this.edge = edge;
    }
   








}