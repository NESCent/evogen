package org.nescent.evogen.hibernate;



/**
 * SeqfeaturePath generated by MyEclipse - Hibernate Tools
 */

public class SeqfeaturePath  implements java.io.Serializable {


    // Fields    

     private SeqfeaturePathId id;
     private Term term;
     private Seqfeature seqfeatureByObjectSeqfeatureId;
     private Seqfeature seqfeatureBySubjectSeqfeatureId;


    // Constructors

    /** default constructor */
    public SeqfeaturePath() {
    }

    
    /** full constructor */
    public SeqfeaturePath(Term term, Seqfeature seqfeatureByObjectSeqfeatureId, Seqfeature seqfeatureBySubjectSeqfeatureId) {
        this.term = term;
        this.seqfeatureByObjectSeqfeatureId = seqfeatureByObjectSeqfeatureId;
        this.seqfeatureBySubjectSeqfeatureId = seqfeatureBySubjectSeqfeatureId;
    }

   
    // Property accessors

    public SeqfeaturePathId getId() {
        return this.id;
    }
    
    public void setId(SeqfeaturePathId id) {
        this.id = id;
    }

    public Term getTerm() {
        return this.term;
    }
    
    public void setTerm(Term term) {
        this.term = term;
    }

    public Seqfeature getSeqfeatureByObjectSeqfeatureId() {
        return this.seqfeatureByObjectSeqfeatureId;
    }
    
    public void setSeqfeatureByObjectSeqfeatureId(Seqfeature seqfeatureByObjectSeqfeatureId) {
        this.seqfeatureByObjectSeqfeatureId = seqfeatureByObjectSeqfeatureId;
    }

    public Seqfeature getSeqfeatureBySubjectSeqfeatureId() {
        return this.seqfeatureBySubjectSeqfeatureId;
    }
    
    public void setSeqfeatureBySubjectSeqfeatureId(Seqfeature seqfeatureBySubjectSeqfeatureId) {
        this.seqfeatureBySubjectSeqfeatureId = seqfeatureBySubjectSeqfeatureId;
    }
   








}