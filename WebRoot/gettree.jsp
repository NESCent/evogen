<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ page import="org.nescent.evogen.util.*" %>
<%@ page import="javax.imageio.ImageIO" %>
<%@ page import="java.awt.image.BufferedImage" %>
<%@ page import="java.io.*" %>

<%
String names=request.getParameter("names");
String source=request.getParameter("source");
TreeUtil util=new TreeUtil();
String nms[]=names.split(",");
BufferedImage img=util.getTreeAsImage(nms, source);
if(img!=null)
{
	OutputStream os=response.getOutputStream();
	response.setContentType("image/png");
	ImageIO.write(img,"png",os);
	os.close();
}
else
{
	response.setContentType("text/html");
	response.getOutputStream().println("No tree found.");
	response.getOutputStream().close();
}

%>
