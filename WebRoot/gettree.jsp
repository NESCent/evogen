<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@ page import="org.nescent.evogen.util.*" %>
<%@ page import="java.io.*" %>
<%@ page import="com.eteks.awt.PJAImage" %>
<%@ page import="Acme.JPM.Encoders.GifEncoderNoCM" %>
<%@ page import="com.eteks.filter.Web216ColorsFilter" %>
<%@ page import="java.awt.image.FilteredImageSource" %>
<%

String names=request.getParameter("names");
String source=request.getParameter("source");

TreeUtil util=new TreeUtil();
String nms[]=names.split(",");
PJAImage img=util.getTreeAsImage(nms, source);
if(img!=null)
{
	OutputStream ost=response.getOutputStream();
	response.setContentType("image/png");
    new GifEncoderNoCM (new FilteredImageSource (img.getSource (),new Web216ColorsFilter ()), ost).encode ();
	
	ost.close();
	
}
else
{
	response.setContentType("text/html");
	response.getOutputStream().println("No tree found.");
	response.getOutputStream().close();
}

%>
