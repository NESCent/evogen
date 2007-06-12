package org.nescent.evogen.server;

import java.io.*;
import java.net.*;

import org.nescent.evogen.util.TreeUtil;

/**
 * Title:        Sample Server
 * Description:  This utility will accept input from a socket, posting back to the socket before closing the link.
 * It is intended as a template for coders to base servers on. Please report bugs to brad at kieser.net
 * Copyright:    Copyright (c) 2002
 * Company:      Kieser.net
 * @author B. Kieser
 * @version 1.0
 */

public class PhyloTreeServer {

  private static int port=4444, maxConnections=0;
  // Listen for incoming connections and handle them
  public static void main(String[] args) {
    int i=0;

    try{
      ServerSocket listener = new ServerSocket(port);
      Socket server;

      while(true)
      {
    	  server = listener.accept();
    	  new Service(server);
      }
    } catch (IOException ioe) {
      System.out.println("IOException on socket listen: " + ioe);
      ioe.printStackTrace();
    }
  }
  
  static class Service extends Thread  {
	    private Socket server;
	    boolean stop=false;
	    String inputLine, outputLine;
	    
	    Service(Socket server) {
	      this.server=server;
	      stop=false;
	      start();
	    }

	    public void run () 
	    {
	    	PrintWriter outgoing =null;
			BufferedReader incoming = null;
			try {
				incoming = new BufferedReader(new InputStreamReader(server.getInputStream()));
				outgoing = new PrintWriter( server.getOutputStream() );
			}
			catch(Exception e)
			{
				System.out.println(e);
				stop=true;
			}
			String command ="";
			try
			{
				command = incoming.readLine();
			    String ss[]=command.split(" ");
			    
			    if (ss[0].toUpperCase().equals("GETTREE")) {
			    	
			    	int pos1=command.indexOf("names=");
			    	if(pos1==-1)
			    	{
			    		outgoing.println("No names specified.");
				       	outgoing.flush();
				       	outgoing.close();
			    	}
			    	else
			    	{
			    		int pos2=command.indexOf("source=");
			    		if(pos2==-1)
			    		{
			    			outgoing.println("No source specified.");
					       	outgoing.flush();
					       	outgoing.close();
			    		}
			    		else
			    		{
			    			String names=command.substring(pos1+6,pos2).trim();
			    			String source=command.substring(pos2+7).trim();
			    			if(names.length()==0)
			    			{
			    				outgoing.println("No names specified.");
						       	outgoing.flush();
						       	outgoing.close();
			    			}
			    			else
			    			{
			    				if(source.length()==0)
			    				{
			    					outgoing.println("No source specified.");
							       	outgoing.flush();
							       	outgoing.close();
			    				}
			    				else
			    				{
			    					String host="127.0.0.1";
			    					String ws="http://"+host+":8080/evogen/rest/tree?names="+names+"&source="+source; 
			    					String newws="";
			    					for(int i=0;i<ws.length();i++)
			    					{
			    						if(ws.charAt(i)==' ')
			    							newws+="%20";
			    						else
			    							newws+=ws.charAt(i);
			    					}
			    					//ws="http://127.0.0.1:8080/evogen/rest/tree?names=Stenanthium%20densum,Anticlea%20elegans,Zigadenus%20glaberrimus,Amianthium%20muscitoxicum&source=biosql_phylo";
			    					URL url = new URL(newws);
			    					
			    				    
			    					BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			    				    String resp="";
			    				    String str;
			    				    while ((str = in.readLine()) != null) 
			    				    {
			    				    	resp+=str;
			    				    }
			    				    in.close();
			    				    
			    				    String nwk="";
			    				    int p1=resp.indexOf("<Result ");
			    				    if(p1!=-1)
			    				    {
			    				    	p1=resp.indexOf(">", p1);
			    				    	int p2=resp.indexOf("</Result>", p1);
			    				    	if(p1!=-1 && p2!=-1)
			    				    		nwk=resp.substring(p1+1,p2);
			    				    }
			    				    
			    				    outgoing.println(nwk);
			    				    		
			    				    /*
			    					TreeUtil util=new TreeUtil();
			    					
			    					String nms[]=names.split(",");
			    					String nwk=util.getTreeAsNWK(nms,source);
			    					outgoing.println(nwk);
			    					*/
							       	outgoing.flush();
							       	outgoing.close();
			    				}
			    			}
			    			
			    		}
			    	}
			    	 
			    	
			    	
			    	outgoing.println(command);
			       	outgoing.flush();
			       	outgoing.close();
			    }   	
			    else {
			    	outgoing.println("unknown command: "+ss[0]);
			    	outgoing.flush();
			    	outgoing.close();
		        }
		    }
		    catch (Exception e) 
		    {
		    	String msg="ERROR " + server.getInetAddress() + " " + command + " " + e;
		    	outgoing.println(msg);
		    	outgoing.flush();
		    	outgoing.close();
		    	System.out.println("ERROR " + server.getInetAddress() + " " + command + " " + e);
		    }
			finally
			{
				try
				{
					server.close();
					outgoing.close();
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
	    }
  	}
}



  



