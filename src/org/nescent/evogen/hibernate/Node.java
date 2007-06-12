package org.nescent.evogen.hibernate;

import java.util.HashSet;
import java.util.Set;


/**
 * Node generated by MyEclipse - Hibernate Tools
 */

public class Node  implements java.io.Serializable {


    // Fields    

     private Integer nodeId;
     private Taxon taxon;
     private Bioentry bioentry;
     private Tree tree;
     private String label;
     private Integer leftIdx;
     private Integer rightIdx;
     private Set nodePathsForChildNodeId = new HashSet(0);
     private Set edgesForChildNodeId = new HashSet(0);
     private Set nodeAttributeValues = new HashSet(0);
     private Set edgesForParentNodeId = new HashSet(0);
     private Set trees = new HashSet(0);
     private Set nodePathsForParentNodeId = new HashSet(0);


    // Constructors

    /** default constructor */
    public Node() {
    }

	/** minimal constructor */
    public Node(Tree tree) {
        this.tree = tree;
    }
    
    /** full constructor */
    public Node(Taxon taxon, Bioentry bioentry, Tree tree, String label, Integer leftIdx, Integer rightIdx, Set nodePathsForChildNodeId, Set edgesForChildNodeId, Set nodeAttributeValues, Set edgesForParentNodeId, Set trees, Set nodePathsForParentNodeId) {
        this.taxon = taxon;
        this.bioentry = bioentry;
        this.tree = tree;
        this.label = label;
        this.leftIdx = leftIdx;
        this.rightIdx = rightIdx;
        this.nodePathsForChildNodeId = nodePathsForChildNodeId;
        this.edgesForChildNodeId = edgesForChildNodeId;
        this.nodeAttributeValues = nodeAttributeValues;
        this.edgesForParentNodeId = edgesForParentNodeId;
        this.trees = trees;
        this.nodePathsForParentNodeId = nodePathsForParentNodeId;
    }

   
    // Property accessors

    public Integer getNodeId() {
        return this.nodeId;
    }
    
    public void setNodeId(Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Taxon getTaxon() {
        return this.taxon;
    }
    
    public void setTaxon(Taxon taxon) {
        this.taxon = taxon;
    }

    public Bioentry getBioentry() {
        return this.bioentry;
    }
    
    public void setBioentry(Bioentry bioentry) {
        this.bioentry = bioentry;
    }

    public Tree getTree() {
        return this.tree;
    }
    
    public void setTree(Tree tree) {
        this.tree = tree;
    }

    public String getLabel() {
        return this.label;
    }
    
    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getLeftIdx() {
        return this.leftIdx;
    }
    
    public void setLeftIdx(Integer leftIdx) {
        this.leftIdx = leftIdx;
    }

    public Integer getRightIdx() {
        return this.rightIdx;
    }
    
    public void setRightIdx(Integer rightIdx) {
        this.rightIdx = rightIdx;
    }

    public Set getNodePathsForChildNodeId() {
        return this.nodePathsForChildNodeId;
    }
    
    public void setNodePathsForChildNodeId(Set nodePathsForChildNodeId) {
        this.nodePathsForChildNodeId = nodePathsForChildNodeId;
    }

    public Set getEdgesForChildNodeId() {
        return this.edgesForChildNodeId;
    }
    
    public void setEdgesForChildNodeId(Set edgesForChildNodeId) {
        this.edgesForChildNodeId = edgesForChildNodeId;
    }

    public Set getNodeAttributeValues() {
        return this.nodeAttributeValues;
    }
    
    public void setNodeAttributeValues(Set nodeAttributeValues) {
        this.nodeAttributeValues = nodeAttributeValues;
    }

    public Set getEdgesForParentNodeId() {
        return this.edgesForParentNodeId;
    }
    
    public void setEdgesForParentNodeId(Set edgesForParentNodeId) {
        this.edgesForParentNodeId = edgesForParentNodeId;
    }

    public Set getTrees() {
        return this.trees;
    }
    
    public void setTrees(Set trees) {
        this.trees = trees;
    }

    public Set getNodePathsForParentNodeId() {
        return this.nodePathsForParentNodeId;
    }
    
    public void setNodePathsForParentNodeId(Set nodePathsForParentNodeId) {
        this.nodePathsForParentNodeId = nodePathsForParentNodeId;
    }
   








}