package org.nescent.evogen.util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


public class DrawImage {
	int wu=50;
	int hu=50;
	
    public void drawNode(Graphics2D g,TreeNode node, int x, int y) throws Exception
    {
    	if(node.getChildrenCount()==0)
    	{
    		int width = 10*wu;
    		g.drawLine(x, y, width, y);
    		g.drawString(node.getLabel(), width+5, y);
    	}
    	else
    	{
    		int num=node.getChildrenCount();
    		int tip_nums;
    		int total_tips=node.getTipCount();
    		int h=total_tips*hu;
    		
    		g.drawLine(x, y, x+wu, y);
    		
    		int y0=y-h/2;
    		int y1=y0;
    		for(int i=0;i<num;i++)
    		{
    			TreeNode n=node.getChild(i);
    			tip_nums=n.getTipCount();
    			float bili=(float)tip_nums/total_tips;
    			y1=y1+(int)(bili*h/2);
    			g.drawLine(x+wu, y, x+wu, y1);
    			drawNode(g,n,x+wu,y1);
    			y1=y1+(int)(bili*h/2);
    		}
    	}
    }
	public BufferedImage createImage(TreeNode node) throws Exception
	{
		int width = 10*wu+50*5;
		int height=hu*node.getTipCount();
	    // Create buffered image that does not support transparency
	    BufferedImage bimage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	    Graphics2D g2d = bimage.createGraphics();
	    
	    // Draw on the image
	    g2d.setColor(Color.white);
	    g2d.setBackground(Color.blue);
	    drawNode(g2d,node,0,height/2);
	   
		
		//ImageIO.write(bimage, "jpg",new File("test.jpg"));
	    g2d.dispose();
	    
	    return bimage;  
	    
	}
	
	
}
