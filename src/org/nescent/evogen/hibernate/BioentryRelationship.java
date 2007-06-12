package org.nescent.evogen.hibernate;



/**
 * BioentryRelationship generated by MyEclipse - Hibernate Tools
 */

public class BioentryRelationship  implements java.io.Serializable {


    // Fields    

     private Integer bioentryRelationshipId;
     private Term term;
     private Bioentry bioentryByObjectBioentryId;
     private Bioentry bioentryBySubjectBioentryId;
     private Integer rank;


    // Constructors

    /** default constructor */
    public BioentryRelationship() {
    }

	/** minimal constructor */
    public BioentryRelationship(Term term, Bioentry bioentryByObjectBioentryId, Bioentry bioentryBySubjectBioentryId) {
        this.term = term;
        this.bioentryByObjectBioentryId = bioentryByObjectBioentryId;
        this.bioentryBySubjectBioentryId = bioentryBySubjectBioentryId;
    }
    
    /** full constructor */
    public BioentryRelationship(Term term, Bioentry bioentryByObjectBioentryId, Bioentry bioentryBySubjectBioentryId, Integer rank) {
        this.term = term;
        this.bioentryByObjectBioentryId = bioentryByObjectBioentryId;
        this.bioentryBySubjectBioentryId = bioentryBySubjectBioentryId;
        this.rank = rank;
    }

   
    // Property accessors

    public Integer getBioentryRelationshipId() {
        return this.bioentryRelationshipId;
    }
    
    public void setBioentryRelationshipId(Integer bioentryRelationshipId) {
        this.bioentryRelationshipId = bioentryRelationshipId;
    }

    public Term getTerm() {
        return this.term;
    }
    
    public void setTerm(Term term) {
        this.term = term;
    }

    public Bioentry getBioentryByObjectBioentryId() {
        return this.bioentryByObjectBioentryId;
    }
    
    public void setBioentryByObjectBioentryId(Bioentry bioentryByObjectBioentryId) {
        this.bioentryByObjectBioentryId = bioentryByObjectBioentryId;
    }

    public Bioentry getBioentryBySubjectBioentryId() {
        return this.bioentryBySubjectBioentryId;
    }
    
    public void setBioentryBySubjectBioentryId(Bioentry bioentryBySubjectBioentryId) {
        this.bioentryBySubjectBioentryId = bioentryBySubjectBioentryId;
    }

    public Integer getRank() {
        return this.rank;
    }
    
    public void setRank(Integer rank) {
        this.rank = rank;
    }
   








}