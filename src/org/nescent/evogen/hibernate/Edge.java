package org.nescent.evogen.hibernate;

import java.util.HashSet;
import java.util.Set;


/**
 * Edge generated by MyEclipse - Hibernate Tools
 */

public class Edge  implements java.io.Serializable {


    // Fields    

     private Integer edgeId;
     private Node nodeByChildNodeId;
     private Node nodeByParentNodeId;
     private Set edgeAttributeValues = new HashSet(0);


    // Constructors

    /** default constructor */
    public Edge() {
    }

	/** minimal constructor */
    public Edge(Node nodeByChildNodeId, Node nodeByParentNodeId) {
        this.nodeByChildNodeId = nodeByChildNodeId;
        this.nodeByParentNodeId = nodeByParentNodeId;
    }
    
    /** full constructor */
    public Edge(Node nodeByChildNodeId, Node nodeByParentNodeId, Set edgeAttributeValues) {
        this.nodeByChildNodeId = nodeByChildNodeId;
        this.nodeByParentNodeId = nodeByParentNodeId;
        this.edgeAttributeValues = edgeAttributeValues;
    }

   
    // Property accessors

    public Integer getEdgeId() {
        return this.edgeId;
    }
    
    public void setEdgeId(Integer edgeId) {
        this.edgeId = edgeId;
    }

    public Node getNodeByChildNodeId() {
        return this.nodeByChildNodeId;
    }
    
    public void setNodeByChildNodeId(Node nodeByChildNodeId) {
        this.nodeByChildNodeId = nodeByChildNodeId;
    }

    public Node getNodeByParentNodeId() {
        return this.nodeByParentNodeId;
    }
    
    public void setNodeByParentNodeId(Node nodeByParentNodeId) {
        this.nodeByParentNodeId = nodeByParentNodeId;
    }

    public Set getEdgeAttributeValues() {
        return this.edgeAttributeValues;
    }
    
    public void setEdgeAttributeValues(Set edgeAttributeValues) {
        this.edgeAttributeValues = edgeAttributeValues;
    }
   








}