package org.nescent.evogen.hibernate;

import java.util.HashSet;
import java.util.Set;


/**
 * Dbxref generated by MyEclipse - Hibernate Tools
 */

public class Dbxref  implements java.io.Serializable {


    // Fields    

     private Integer dbxrefId;
     private String dbname;
     private String accession;
     private Integer version;
     private Set termDbxrefs = new HashSet(0);
     private Set dbxrefQualifierValues = new HashSet(0);
     private Set bioentryDbxrefs = new HashSet(0);
     private Set seqfeatureDbxrefs = new HashSet(0);
     private Set references = new HashSet(0);
     private Set locations = new HashSet(0);


    // Constructors

    /** default constructor */
    public Dbxref() {
    }

	/** minimal constructor */
    public Dbxref(String dbname, String accession, Integer version) {
        this.dbname = dbname;
        this.accession = accession;
        this.version = version;
    }
    
    /** full constructor */
    public Dbxref(String dbname, String accession, Integer version, Set termDbxrefs, Set dbxrefQualifierValues, Set bioentryDbxrefs, Set seqfeatureDbxrefs, Set references, Set locations) {
        this.dbname = dbname;
        this.accession = accession;
        this.version = version;
        this.termDbxrefs = termDbxrefs;
        this.dbxrefQualifierValues = dbxrefQualifierValues;
        this.bioentryDbxrefs = bioentryDbxrefs;
        this.seqfeatureDbxrefs = seqfeatureDbxrefs;
        this.references = references;
        this.locations = locations;
    }

   
    // Property accessors

    public Integer getDbxrefId() {
        return this.dbxrefId;
    }
    
    public void setDbxrefId(Integer dbxrefId) {
        this.dbxrefId = dbxrefId;
    }

    public String getDbname() {
        return this.dbname;
    }
    
    public void setDbname(String dbname) {
        this.dbname = dbname;
    }

    public String getAccession() {
        return this.accession;
    }
    
    public void setAccession(String accession) {
        this.accession = accession;
    }

    public Integer getVersion() {
        return this.version;
    }
    
    public void setVersion(Integer version) {
        this.version = version;
    }

    public Set getTermDbxrefs() {
        return this.termDbxrefs;
    }
    
    public void setTermDbxrefs(Set termDbxrefs) {
        this.termDbxrefs = termDbxrefs;
    }

    public Set getDbxrefQualifierValues() {
        return this.dbxrefQualifierValues;
    }
    
    public void setDbxrefQualifierValues(Set dbxrefQualifierValues) {
        this.dbxrefQualifierValues = dbxrefQualifierValues;
    }

    public Set getBioentryDbxrefs() {
        return this.bioentryDbxrefs;
    }
    
    public void setBioentryDbxrefs(Set bioentryDbxrefs) {
        this.bioentryDbxrefs = bioentryDbxrefs;
    }

    public Set getSeqfeatureDbxrefs() {
        return this.seqfeatureDbxrefs;
    }
    
    public void setSeqfeatureDbxrefs(Set seqfeatureDbxrefs) {
        this.seqfeatureDbxrefs = seqfeatureDbxrefs;
    }

    public Set getReferences() {
        return this.references;
    }
    
    public void setReferences(Set references) {
        this.references = references;
    }

    public Set getLocations() {
        return this.locations;
    }
    
    public void setLocations(Set locations) {
        this.locations = locations;
    }
   








}