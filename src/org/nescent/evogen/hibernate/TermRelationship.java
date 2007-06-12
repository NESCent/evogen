package org.nescent.evogen.hibernate;

import java.util.HashSet;
import java.util.Set;


/**
 * TermRelationship generated by MyEclipse - Hibernate Tools
 */

public class TermRelationship  implements java.io.Serializable {


    // Fields    

     private Integer termRelationshipId;
     private Term termBySubjectTermId;
     private Term termByObjectTermId;
     private Term termByPredicateTermId;
     private Ontology ontology;
     private Set termRelationshipTerms = new HashSet(0);


    // Constructors

    /** default constructor */
    public TermRelationship() {
    }

	/** minimal constructor */
    public TermRelationship(Term termBySubjectTermId, Term termByObjectTermId, Term termByPredicateTermId, Ontology ontology) {
        this.termBySubjectTermId = termBySubjectTermId;
        this.termByObjectTermId = termByObjectTermId;
        this.termByPredicateTermId = termByPredicateTermId;
        this.ontology = ontology;
    }
    
    /** full constructor */
    public TermRelationship(Term termBySubjectTermId, Term termByObjectTermId, Term termByPredicateTermId, Ontology ontology, Set termRelationshipTerms) {
        this.termBySubjectTermId = termBySubjectTermId;
        this.termByObjectTermId = termByObjectTermId;
        this.termByPredicateTermId = termByPredicateTermId;
        this.ontology = ontology;
        this.termRelationshipTerms = termRelationshipTerms;
    }

   
    // Property accessors

    public Integer getTermRelationshipId() {
        return this.termRelationshipId;
    }
    
    public void setTermRelationshipId(Integer termRelationshipId) {
        this.termRelationshipId = termRelationshipId;
    }

    public Term getTermBySubjectTermId() {
        return this.termBySubjectTermId;
    }
    
    public void setTermBySubjectTermId(Term termBySubjectTermId) {
        this.termBySubjectTermId = termBySubjectTermId;
    }

    public Term getTermByObjectTermId() {
        return this.termByObjectTermId;
    }
    
    public void setTermByObjectTermId(Term termByObjectTermId) {
        this.termByObjectTermId = termByObjectTermId;
    }

    public Term getTermByPredicateTermId() {
        return this.termByPredicateTermId;
    }
    
    public void setTermByPredicateTermId(Term termByPredicateTermId) {
        this.termByPredicateTermId = termByPredicateTermId;
    }

    public Ontology getOntology() {
        return this.ontology;
    }
    
    public void setOntology(Ontology ontology) {
        this.ontology = ontology;
    }

    public Set getTermRelationshipTerms() {
        return this.termRelationshipTerms;
    }
    
    public void setTermRelationshipTerms(Set termRelationshipTerms) {
        this.termRelationshipTerms = termRelationshipTerms;
    }
   








}