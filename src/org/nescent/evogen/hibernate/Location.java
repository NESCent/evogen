package org.nescent.evogen.hibernate;

import java.util.HashSet;
import java.util.Set;


/**
 * Location generated by MyEclipse - Hibernate Tools
 */

public class Location  implements java.io.Serializable {


    // Fields    

     private Integer locationId;
     private Term term;
     private Seqfeature seqfeature;
     private Dbxref dbxref;
     private Integer startPos;
     private Integer endPos;
     private Integer strand;
     private Integer rank;
     private Set locationQualifierValues = new HashSet(0);


    // Constructors

    /** default constructor */
    public Location() {
    }

	/** minimal constructor */
    public Location(Seqfeature seqfeature, Integer strand, Integer rank) {
        this.seqfeature = seqfeature;
        this.strand = strand;
        this.rank = rank;
    }
    
    /** full constructor */
    public Location(Term term, Seqfeature seqfeature, Dbxref dbxref, Integer startPos, Integer endPos, Integer strand, Integer rank, Set locationQualifierValues) {
        this.term = term;
        this.seqfeature = seqfeature;
        this.dbxref = dbxref;
        this.startPos = startPos;
        this.endPos = endPos;
        this.strand = strand;
        this.rank = rank;
        this.locationQualifierValues = locationQualifierValues;
    }

   
    // Property accessors

    public Integer getLocationId() {
        return this.locationId;
    }
    
    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public Term getTerm() {
        return this.term;
    }
    
    public void setTerm(Term term) {
        this.term = term;
    }

    public Seqfeature getSeqfeature() {
        return this.seqfeature;
    }
    
    public void setSeqfeature(Seqfeature seqfeature) {
        this.seqfeature = seqfeature;
    }

    public Dbxref getDbxref() {
        return this.dbxref;
    }
    
    public void setDbxref(Dbxref dbxref) {
        this.dbxref = dbxref;
    }

    public Integer getStartPos() {
        return this.startPos;
    }
    
    public void setStartPos(Integer startPos) {
        this.startPos = startPos;
    }

    public Integer getEndPos() {
        return this.endPos;
    }
    
    public void setEndPos(Integer endPos) {
        this.endPos = endPos;
    }

    public Integer getStrand() {
        return this.strand;
    }
    
    public void setStrand(Integer strand) {
        this.strand = strand;
    }

    public Integer getRank() {
        return this.rank;
    }
    
    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Set getLocationQualifierValues() {
        return this.locationQualifierValues;
    }
    
    public void setLocationQualifierValues(Set locationQualifierValues) {
        this.locationQualifierValues = locationQualifierValues;
    }
   








}