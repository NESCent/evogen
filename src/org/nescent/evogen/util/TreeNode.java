package org.nescent.evogen.util;

import java.util.ArrayList;

public class TreeNode {
	int id;
	String label;
	String left_id;
	
	ArrayList children;
	TreeNode parent;
	
	public int getTipCount()
	{
		int num=0;
		if(getChildrenCount()==0)
			num= 1;
		else
		{
			for(int i=0;i<getChildrenCount();i++)
			{
				TreeNode n=getChild(i);
				num+=n.getTipCount();
			}
		}
		return num;
	}
	public int getChildrenCount()
	{
		return children.size();
	}
	public void simplify()
	{
		for(int i=0;i<getChildrenCount();i++)
		{
			TreeNode n=getChild(i);
			n.simplify();
		}
		if(getChildrenCount()==1)
		{
			TreeNode p=parent;
			if(p!=null)
			{
				TreeNode c=getChild(0);
				p.addChild(c);
				p.removeChild(this);
			}
		}
	}
	public String toStringNWK()
	{
		String str="(";
		if(label!=null) str+=label;
		for(int i=0;i<children.size();i++)
		{
			if(i>0)str+=",";
			TreeNode chd=getChild(i);
			str+=chd.toStringNWK();
		}
		str+=")";
		return str;
		
	}
	public TreeNode()
	{
		children=new ArrayList();
		parent=null;
	}
	public void setParent(TreeNode parent) {
		this.parent = parent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getLeft_id() {
		return left_id;
	}

	public void setLeft_id(String left_id) {
		this.left_id = left_id;
	}
	
	public TreeNode getChild(int index)
	{
		return (TreeNode)children.get(index);
	}
	
	public void addChild(TreeNode node)
	{
		children.add(node);
		node.setParent(this);
	}
	
	public void removeChild(TreeNode node)
	{
		children.remove(node);
	}
	
	public void remove()
	{
		if(parent!=null) parent.removeChild(this);
	}
	
	public TreeNode getParent()
	{
		return parent;
	}
	public TreeNode findNodeById(int id)
	{
		if(this.id==id)return this;
		for(int i=0;i<children.size();i++)
		{
			TreeNode chd=getChild(i);
			TreeNode node=chd.findNodeById(id);
			if(node!=null)return node;
		}
		
		return null;
	}
	
	public TreeNode findNodeByLeftId(String id)
	{
		if(this.left_id!=null && this.left_id.equals(id))return this;
		for(int i=0;i<children.size();i++)
		{
			TreeNode chd=getChild(i);
			TreeNode node=chd.findNodeByLeftId(id);
			if(node!=null)return node;
		}
		
		return null;
	}
}
