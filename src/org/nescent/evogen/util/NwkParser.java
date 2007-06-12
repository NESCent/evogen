package org.nescent.evogen.util;

public class NwkParser {
	public static String COMA=",";
	public static String LEFT_PARENTHESIS="(";
	public static String RIGHT_PARENTHESIS=")";
	public static String END=";";
	
	String nwk;
	int cur_pos=0;
	public NwkParser(String nwk)
	{
		this.nwk=nwk;
		cur_pos=0;
	}
	public String nextToken()
	{
		String str="";
		if(cur_pos>nwk.length()-1) return null;
		
		String temp=nwk.substring(cur_pos,cur_pos+1);
		if(temp.equals(NwkParser.END))
			return null;
		if(temp.equals(NwkParser.COMA))
		{
			cur_pos++;
			return NwkParser.COMA;
		}
		else if(temp.equals(NwkParser.RIGHT_PARENTHESIS))
		{
			cur_pos++;
			return NwkParser.RIGHT_PARENTHESIS;
		}
		else if(temp.equals(NwkParser.LEFT_PARENTHESIS))
		{
			cur_pos++;
			return NwkParser.LEFT_PARENTHESIS;
		}
		else
		{
			boolean found=false;
			
			while(!found && cur_pos<nwk.length())
			{
				if(temp.equals(NwkParser.COMA) || temp.equals(NwkParser.RIGHT_PARENTHESIS) || temp.equals(NwkParser.LEFT_PARENTHESIS))
				{
					found=true;
				}
				else
				{
					str+=temp;
					cur_pos++;
					temp=nwk.substring(cur_pos,cur_pos+1);
				}
				
				
			}
		}
		return str;
	}
}
