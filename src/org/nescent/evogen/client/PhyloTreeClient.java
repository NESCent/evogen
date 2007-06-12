package org.nescent.evogen.client;
import java.io.*;
import java.net.*;

public class PhyloTreeClient {
    
	boolean stop=false;
	String prompt="PhyloTree>";
	String host="eryops.nescent.org/tree";
	int port=4444;
	
	public static void main(String[] args) 
	{
		
		try
		{
			PhyloTreeClient client=new PhyloTreeClient();
			if(args.length ==2)
			{
				client.setHost(args[0]);
				client.setPort(Integer.parseInt(args[1]));
			}
			
			client.startClicent();
		}catch (Exception e) {
			System.err.println(e);
			System.exit(1);
		}
		
    }
	
	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getPrompt() {
		return prompt;
	}

	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}
	public void printUsage()
	{
		System.out.println("\nUsage:");
		System.out.println("\n1. getTree file source\n");
		System.out.println("get the minimium tree in NWK string that contains and only contains the species in the file specified in the fist parameter\n");
		System.out.println("\tfile: local file that contains the list of species names (binominals).\n");
		System.out.println("\tsource: data source of trees, such as ITIS.\n\n");
		System.out.println("Example: getTree exmaple1.txt biosql_phylo\n\n");
		System.out.println("2. quit\n");
		System.out.println("Quit the client.\n");
		
	}
	
	public void startClicent() throws Exception
	{
		
		while(!stop)
		{
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
	        
	        String command="";
	        
	        while(!stop)
	        {
	        	System.out.print(prompt);
	        	command = stdIn.readLine();
	            if (command != null) 
	            {
	            	if(command.equals("quit"))
                		stop=true;
	            	else
	            		handleCommand(command);
	            }
	        }
		}
	}
	
	public void handleCommand(String command) 
	{
		command=command.trim();
    	String ss[]=command.split(" ");
    	if(ss.length!=3)
    	{
    		System.out.println(prompt + "Invalid command or parameters");
    		printUsage();
    		return;
    	}
    	
		
        try
        {
        	
        	String func=ss[0].trim();
        	String file=ss[1].trim();
        	String source=ss[2].trim();
        	
        	BufferedReader r=new BufferedReader(new FileReader(new File(file)));
        	String str=r.readLine();
        	boolean found=false;
        	String names="";
        	while(str!=null)
        	{
        		 if(str.indexOf("Species=")!=-1)
        		 {
        			 str=str.substring(8).trim();
        			 
        	         names=str;
        	         found=true;
        		 }
        		 else
        			 str=r.readLine();
        	}
        	r.close();
        	
        	if(!found)
        	{
        		System.out.println("> Invalid species list in the file: " + file);
        	}
        	else
        	{
        		System.out.println("> wait ... ");
        		System.out.println("> " + getTree(names,source));
   			 	System.out.println("> Finished!\n ");
        	}
        	
        	
        }
        catch(Exception e)
        {
        	System.out.println(e);
        }
       
        
	}
	
	public String getTree(String names, String source) throws Exception
	{
		String host="eryops.nescent.org/tree";
		String ws="http://"+host+"/evogen/rest/tree?names="+names+"&source="+source; 
		System.out.println("> URL: "+ws);
	 
		 
		String newws="";
		for(int i=0;i<ws.length();i++)
		{
			if(ws.charAt(i)==' ')
				newws+="%20";
			else
				newws+=ws.charAt(i);
		}
		
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
	    
	    return nwk;
	}

}
