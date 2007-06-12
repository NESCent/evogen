package org.nescent.evogen.ws.rest;
import java.io.ByteArrayInputStream;
import java.util.StringTokenizer;

import javax.annotation.Resource;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.BindingType;
import javax.xml.ws.Provider;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.WebServiceProvider;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.http.HTTPBinding;
import javax.xml.ws.http.HTTPException;

import org.nescent.evogen.util.TreeUtil;

@WebServiceProvider
@BindingType(value=HTTPBinding.HTTP_BINDING)
public class Tree implements Provider<Source> {
	@Resource(type=Object.class)
    protected WebServiceContext wsContext;
	
	/* (non-Javadoc)
	 * @see javax.xml.ws.Provider#invoke(java.lang.Object)
	 */
	public Source invoke(Source arg0) {
		try {
            
			MessageContext mc = wsContext.getMessageContext();
            String query = (String)mc.get(MessageContext.QUERY_STRING);
            String names="";
            String treesource="";
            
            System.out.println(query);
            if (query != null)
            {
            	
            	StringTokenizer st = new StringTokenizer(query, "&");
            	
            	if(st.hasMoreTokens())
            	
            	
            	while(st.hasMoreTokens())
            	{
            		String token=st.nextToken();
            		String ss[]=token.split("=");
            		if(ss.length==2)
            		{
            			if(ss[0].equals("names"))
            			{
            				names= ss[1];
            			}
            			else if(ss[0].equals("name"))
            			{
            				names= ss[1];
            			}
	            		else if(ss[0].equals("source"))
	            		{
	            			treesource = ss[1];
	            		} 
            		}
            	}
            }
            return createSource(names,treesource);	
            
			
        } catch(Exception e) {
            e.printStackTrace();
            throw new HTTPException(500);
        }
	
	}
	
	/**
	 * @param names
	 * @param treesource
	 * @return
	 */
	private Source createSource(String names,String treesource) {
                
		names=names.replaceAll("%20"," ");
		
		String [] list=names.split(",");
		
		String result="<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
		result+="<Response command=\"Tree\">";
		result+="	<Parameters>";
		result+="		<Parameter name=\"names\">"+names+"</Parameter>";
		result+="		<Parameter name=\"treesource\">"+treesource+"</Parameter>";
		result+="	</Parameters>";
		
		if(!names.equals("") && ! treesource.equals(""))
		{
			try
			{
				TreeUtil util=new TreeUtil();
				String str=util.getTreeAsNWK(list, treesource);
				if(str.equals(""))
					result+="	<Result type=\"message\">no tree found</Result>";
				else
					result+="	<Result type=\"nwk\">" + str+"</Result>";
				
			}
			catch(Exception e)
			{
				result+="	<Result type=\"error\">" + e.getMessage() +"</Result>";
			}
		}
		else
		{
			result+="	<Result type=\"error\">No name or source specified</Result>";
		}
		result+="</Response>";
		
        Source source = new StreamSource(
            new ByteArrayInputStream(result.getBytes()));
        return source;
    }
}
