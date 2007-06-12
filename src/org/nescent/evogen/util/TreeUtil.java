package org.nescent.evogen.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import javax.imageio.ImageIO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.nescent.evogen.hibernate.Edge;
import org.nescent.evogen.hibernate.HibernateSessionFactory;
import org.nescent.evogen.hibernate.Node;
import org.nescent.evogen.hibernate.NodeDAO;
import org.nescent.evogen.hibernate.Tree;
import org.nescent.evogen.hibernate.TreeDAO;

/**
 * @author xianhua
 *
 */
public class TreeUtil {
	public static int TREE_DEPTH_ALL = -1;
	
	
	public int getLcaNode(String [] names)
	{
		int id=-1;
		
		return id;
	}
	
	
	public int getLcaNode(int [] ids)
	{
		int id=-1;
		
		if(ids.length==0) return -1;
		if(ids.length==1) return ids[0];
		
		int id_1=ids[0];
		int id_2;
		for(int i=1;i<ids.length;i++)
		{
			id_2=ids[i];
			id=getLcaNode(id_1,id_2);
			if(id==-1)return -1;
			id_1=id;
		}
		return id;
	}
	
	
	public List getTrees(String name_1, String name_2)
	{
		Session session =HibernateSessionFactory.getSession();
		   
		String sql="SELECT node_a.node_id as node_id1, node_b.node_id as node_id2, node_a.tree_id as tree_id " +
    		" FROM node node_a, node node_b "+
    		" WHERE node_a.tree_id = node_b.tree_id "+ 
    		" AND   node_a.label = :name_1"+
    		" AND   node_b.label = :name_2";
    
		
		Query query = session.createSQLQuery(sql);
		query.setString("name_1",name_1);
		query.setString("name_2",name_2);
     	
	    List results= query.list();
	    session.close();
	    
	    return results;
	    
	}
	public BufferedImage getTreeAsImage(String [] names, String treeSource) throws Exception
	{
		String nwk="";
		
		List trees=getTrees(names, treeSource);
		if(trees.size()>0)
		{
			Object [] objs=(Object [])trees.get(0);  
			int num=names.length;
	    	int ids[]=new int[num];
	    	
	    	for(int j=0;j<objs.length-3;j++)
	    	{
	    		String id=String.valueOf(objs[j]);
	    		ids[j]=Integer.parseInt(id);
	    	}
	    	
	    	String tree_id=String.valueOf(objs.length-2);
			
			int lcaid=getLcaNode(ids);
			if(lcaid!=-1)
			{
							
				TreeNode node= getMinimiumTree(lcaid,ids,names);
				DrawImage di=new DrawImage();
				BufferedImage img=di.createImage(node);
				
				return img;
			}
		}
		return null;
	}
	
	public String getTreeAsNWK(String [] names, String treeSource) throws Exception
	{
		String nwk="";
		
		List trees=getTrees(names, treeSource);
		if(trees.size()>0)
		{
			Object [] objs=(Object [])trees.get(0);  
			int num=names.length;
	    	int ids[]=new int[num];
	    	
	    	for(int j=0;j<objs.length-3;j++)
	    	{
	    		String id=String.valueOf(objs[j]);
	    		ids[j]=Integer.parseInt(id);
	    	}
	    	
	    	String tree_id=String.valueOf(objs.length-2);
			
			int lcaid=getLcaNode(ids);
			if(lcaid!=-1)
			{
							
				TreeNode node= getMinimiumTree(lcaid,ids,names);
				nwk= node.toStringNWK();
				//System.out.println(nwk);
				nwk=cleanString(nwk);
				if(!nwk.startsWith("("))
					nwk="("+nwk+")";
				if(!nwk.endsWith(";"))
					nwk+=";";
				
			}
		}
		return nwk;
	}
	/**
	 * getTrees
	 * 
	 * @param names list of species names (bi-nominals) 
	 * @param treeSource tree source name, such as TreeBASE, NCBI 
	 * @return list of trees and node ids of the corresponding names in the trees. These information can be used
	 *         to retrieve the LCA by calling getLcaNode(int [] ids) function  
	 */
	public List getTrees(String [] names, String treeSource)
	{
		if(names.length==0)
			return new ArrayList();
		
		Session session =HibernateSessionFactory.getSession();
		   
		String sql="SELECT ";
		
		for(int i=0;i<names.length;i++)
		{
			if(i>0) sql+=",";
			sql+="node_" + i+".node_id as node_id"+i;
		}
		sql+=",node_0.tree_id as treeid,tree.name as treename, treesource.name as treesourcename FROM ";
		
		for(int i=0;i<names.length;i++)
		{
			if(i>0) sql+=",";
			sql+="node node_" + i;
		}
    	sql+=", tree tree, biodatabase treesource ";
		sql+=" WHERE ";
		for(int i=1;i<names.length;i++)
		{
			if(i>1) sql+=" AND ";
			sql+="node_" + i+".tree_id=node_0.tree_id";
		}
		sql+=" AND ";
		for(int i=0;i<names.length;i++)
		{
			if(i>0) sql+=" AND ";
			sql+="node_" + i+".label=:name_" +i;
		}
		sql+=" AND tree.tree_id=node_0.tree_id ";
		sql+=" AND tree.biodatabase_id =treesource.biodatabase_id ";
		//System.out.println(sql);
		Query query = session.createSQLQuery(sql);
		for(int i=0;i<names.length;i++)
		{
			query.setString("name_"+i,names[i]);
		}
		
	    List results= query.list();
	    session.close();
	    
	    return results;
	    
	}
	public int getLcaNode(int id_1, int id_2)
	{
		int id=-1;
		
		Session session =HibernateSessionFactory.getSession();
	   /*
		String sql="SELECT parent_node_id, distance "+
    	" FROM node_path"+
    	" WHERE (parent_node_id = :id_1 AND child_node_id = :id_2) OR "+ 
    	"  (parent_node_id = :id_2 AND child_node_id = :id_1)" ; 
    	Query query = session.createSQLQuery(sql);
	    query.setInteger("id_1",id_1);
	    query.setInteger("id_2",id_2);
	     	
	    query.setMaxResults(1);

	    List results=query.list(); 
	    if(results.size()==1)
	    {
	    	 Object [] objs=(Object [])results.get(0);  
	    	 id=Integer.parseInt(String.valueOf(objs[0]));
	    }
	    else
	    {
		 */
		String sql="SELECT lca.node_id, " +
		    	" pA.distance AS distance_a, pB.distance AS distance_b" +
		    	" FROM node lca, node_path pA, node_path pB "+
		    	" WHERE pA.parent_node_id = pB.parent_node_id "+ 
		    	" AND   lca.node_id = pA.parent_node_id " +
		    	" AND   pA.child_node_id = :id_1"+
		    	" AND   pB.child_node_id = :id_2" +
		    	" ORDER BY pA.distance";
		Query query = session.createSQLQuery(sql);
		query.setInteger("id_1",id_1);
		query.setInteger("id_2",id_2);
		     	
		query.setMaxResults(1);
	
		List results=query.list(); 
		if(results.size()==1)
		{
		    	   
		    Object [] objs=(Object [])results.get(0);  
		    id=Integer.parseInt(String.valueOf(objs[0]));
		} 
		else
		{
		   	 System.out.println("No LCA found");
		
	    }
		session.close();
		
		return id;
	}
	
	public String getTreeByName(String name, int depth)
	{
		String result="<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
		result+="<Response command=\"getTreeByName\">";
		result+="	<Parameters>";
		result+="		<Parameter name=\"name\">"+name+"</Parameter>";
		result+="	<Parameters>";
		
		try
		{
			String str="";
			TreeDAO treeDao=new TreeDAO();
			List treeList=treeDao.findByName(name);
			if(treeList.size()>0)
			{
				Tree tree=(Tree)treeList.get(0);
				Node root=tree.getNode();
				Set edges=root.getEdgesForParentNodeId();
				if(edges.size()>0)
				{
					Edge edge=(Edge)edges.toArray()[0];
					Node chd=edge.getNodeByChildNodeId();
					str+=getChildren(chd, depth);
				}
				
				result+="	<Result type=\"NWK\">" + str+"</Result>";
			}
			else
			{
				result+="	<Result type=\"message\">no tree found</Result>";
			
			}
		}
		catch(Exception e)
		{
			result+="	<Result type=\"error\">" + e.getMessage() +"</Result>";
		}
		
		result+="</Response>";
		
		
		
		return result;
	}
	
	public String getTreeById(String id, int depth)
	{
		String result="<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
		result+="<Response command=\"getTreeById\">";
		result+="	<Parameters>";
		result+="		<Parameter name=\"name\">"+id+"</Parameter>";
		result+="		<Parameter name=\"depth\">"+depth+"</Parameter>";
		result+="	<Parameters>";
		
		try
		{
			String str="";
			NodeDAO nodeDao=new NodeDAO();
			Node node=nodeDao.findById(Integer.valueOf(id));
			if(node!=null)
			{
				str+=getChildren(node, depth);
				result+="	<Result type=\"NWK\">" + str+"</Result>";
			}
			else
			{
				result+="	<Result type=\"message\">no tree found</Result>";
			
			}
		}
		catch(Exception e)
		{
			result+="	<Result type=\"error\">" + e.getMessage() +"</Result>";
		}
		
		result+="</Response>";
		
		
		
		return result;
	}
	public TreeNode getMinimiumTree(int lcaid, int [] ids, String [] names) throws Exception
	{
		TreeNode root=new TreeNode();
		root.setId(lcaid);
		
		Connection conn=getConnection();
		String sql="";
		
		for(int i=0;i<ids.length;i++)
		{
			TreeNode node=new TreeNode();
			node.setId(ids[i]);
			//root.addChild(node);
			node.setLabel(names[i]);
			String path=getPath(lcaid, ids[i]);
			if(path!=null)
			{
				TreeNode n=root;
				String lids[]=path.split("\\.");
				for(int j=0;j<lids.length-1;j++)
				{
					TreeNode n1=root.findNodeByLeftId(lids[j].trim());
					if(n1==null)
					{
						n1=new TreeNode();
						n1.setLeft_id(lids[j].trim());
						n.addChild(n1);
						
					}
					n=n1;
				}
				n.addChild(node);
				node.setLeft_id(lids[lids.length-1]);
			}
		}
		root.simplify();
		
		return root;
		
	}
	
	
	public String getPath(int fromid, int toid) throws Exception
	{
		Statement s = null;
		Connection conn;
		String ret="";
		conn=getConnection();
		String sql="select path from node_path where parent_node_id=" +fromid +
				" AND child_node_id=" + toid;
		s = conn.createStatement();
		ResultSet rs = null;
		rs=s.executeQuery(sql);
		if(rs.next()) {
		      ret=rs.getString(1);
		}
		s.close();
		conn.close();

		return ret;

	}
	public Connection getConnection()
	{
		try {
		    Class.forName("org.postgresql.Driver");
		  } catch (ClassNotFoundException cnfe) {
		    System.out.println("Couldn't find the driver!");
		    System.out.println("Let's print a stack trace, and exit.");
		    cnfe.printStackTrace();
		    System.exit(1);
		    
		  }
		  
		  //System.out.println("Registered the driver ok, so let's make a connection.");
		  
		  Connection c = null;
		  
		  try {
		    // The second and third arguments are the username and password,
		    // respectively. They should be whatever is necessary to connect
		    // to the database.
		    String host="darwin.nescent.org";
		    String user="xl24";
		    String password="lxh72325";
		    c = DriverManager.getConnection("jdbc:postgresql://"+host+"/biosql_dev",user, password);
		    return c;
		  } catch (Exception se) {
		    System.out.println("Couldn't connect: print out a stack trace and exit.");
		    se.printStackTrace();
		    System.exit(1);
		  }
		  return null;
	}
	public String getMinimiumTree(Node node, Hashtable names)
	{
		if(node==null)
			return "";
		String str="";
		Set edges=node.getEdgesForParentNodeId();
		if(edges.size()>0)
			str+="(";
		
		if(node.getLabel()!=null && names.containsKey(node.getLabel()))
		{
			str+=node.getLabel();
		}
		
		for(int i=0;i<edges.size();i++)
		{
			Edge edge=(Edge)edges.toArray()[i];
			Node chd=edge.getNodeByChildNodeId();
			if(i!=0) str+=",";
			{
				str+=getMinimiumTree(chd, names);
			}
		}
		if(edges.size()>0)
			str+=")";
		
		
		if(str.matches("[,|)|(]*"))
			str="";
		/*
		if(str.endsWith(",)"))
		{
			str=str.substring(1,str.length()-2);	
		}
		if(str.startsWith("(,"))
		{
			str=str.substring(2,str.length()-1);	
		}
		*/
		return str;
	}
	public String cleanString(String str)
	{
		Stack tokens=new Stack();
		NwkParser parser=new NwkParser(str);
		String token=parser.nextToken();
		while(token!=null)
		{
			if(token.equals(NwkParser.COMA))
			{
				String ptoken=(String)tokens.pop();
				if(! ptoken.equals(NwkParser.LEFT_PARENTHESIS) && ! ptoken.equals(NwkParser.COMA))
				{
					tokens.push(ptoken);
					tokens.push(token);
				}
				else
					tokens.push(ptoken);
					
			}
			else if(token.equals(NwkParser.RIGHT_PARENTHESIS))
			{
				Stack names=new Stack();
				String tmp=(String)tokens.pop();
				
				while(!tmp.equals(NwkParser.LEFT_PARENTHESIS)  && !tmp.equals(NwkParser.RIGHT_PARENTHESIS))
				{
					if(!tmp.equals(NwkParser.COMA))
						names.push(tmp);
					tmp=(String)tokens.pop();
				}
				
				if(tmp.equals(NwkParser.RIGHT_PARENTHESIS))
				{
					tokens.push(NwkParser.RIGHT_PARENTHESIS);
					if(names.size()>0)
						tokens.push(NwkParser.COMA);
				}
				else
				{
					if(names.size()>1)tokens.push(NwkParser.LEFT_PARENTHESIS);
				}
				
				int i=0;
				while(!names.empty())
				{
					String ptoken=(String)names.pop();
					if(i>0)tokens.push(NwkParser.COMA);
					tokens.push(ptoken);
					i++;
				}
				if(i>1 || tmp.equals(NwkParser.RIGHT_PARENTHESIS))
					tokens.push(NwkParser.RIGHT_PARENTHESIS);
				
			}
			else
				tokens.push(token);
			token=parser.nextToken();
		}
		String ret="";
		
		while(!tokens.empty())
		{
			token=(String)tokens.pop();
			ret=token+ret;
		}
		
		parser=new NwkParser(ret);
		char [] symbols=ret.toCharArray();
		
		for(int i=0;i<symbols.length-1;i++)
		{
			if(symbols[i]==symbols[i+1]&& symbols[i]=='(')
			{
				int pos1=getPairedParenthesis(i,ret);
				int pos2=getPairedParenthesis(i+1,ret);
				if(pos1==pos2+1)
				{
					symbols[i]='@';
					symbols[pos1]='@';
				}
			}
		}
		
		ret="";
		for(int i=0;i<symbols.length;i++)
		{
			if(symbols[i]!='@')
				ret+=symbols[i];
		}
		return ret;
		
	}
	public int getPairedParenthesis(int pos,String str)
	{
		int p=-1;
		int num=1;
		for(int i=pos+1;i<str.length();i++)
		{
			if(str.charAt(i)=='(')
				num++;
			else if(str.charAt(i)==')')
				num--;
			if(num==0)
				return i;
				
		}
		return p;
	}
	public String getChildren(Node node, int depth)
	{
		if(node==null)
			return "";
		String str="";
		Set edges=node.getEdgesForParentNodeId();
		if(edges.size()>0)
			str+="(";
		if(node.getLabel()!=null)
			str+=node.getLabel();
		if(depth==TREE_DEPTH_ALL || depth>0)
		{
			
			for(int i=0;i<edges.size();i++)
			{
				Edge edge=(Edge)edges.toArray()[i];
				Node chd=edge.getNodeByChildNodeId();
				if(i!=0) str+=", ";
				{
					if(depth==TREE_DEPTH_ALL)
						str+=getChildren(chd, TREE_DEPTH_ALL);
					else
						str+=getChildren(chd, depth-1);
				}
			}
		}
		if(edges.size()>0)
		{
			if(! str.equals("("))
				str+=")";
			else
				str="";
		}
		return str;
	}
	public static void main(String [] agrs)
	{
		TreeUtil util=new TreeUtil();
		//String names[] ={"Graphis scripta", "Coniosporium apollinis","Siphula ceratites"};
		String names[] ={"Carya alba", "Acer rubrum","Galactia regularis"};
		//String names[] ={"Stenanthium densum", "Anticlea elegans","Amianthium muscitoxicum"};
		//int [] ids={6287,6126,6494};
		//int [] ids={11,11};
		
		try
		{
			//System.out.println(util.getTreeAsNWK(names, "ITIS"));
			BufferedImage img=util.getTreeAsImage(names, "ITIS");
			ImageIO.write(img,"jpg",new File("test.jpg"));
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		/*
		
		List result=util.getTrees(names,"biosql_phylo");
		for(int i=0;i<result.size();i++)
		{
			Object [] objs=(Object [])result.get(i);  
	    	String temp="";
			for(int j=0;j<objs.length;j++)
	    	{
	    		String id=String.valueOf(objs[j]);
	    		temp+=id+",";
	    	}
			
			System.out.println(temp);	
		}
		*/
	}
}


