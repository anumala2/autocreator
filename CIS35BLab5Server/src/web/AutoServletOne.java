package web;

import model.*;
import adapter.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AutoServletOne extends HttpServlet
{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException;
	{
		PrintWriter out = new response.getWriter();
		out.println("<html>");
		
		out.println("<head>");
		out.println("<title>KBB</title>");
		out.println("</head>");
		
		out.println("<body>");
		out.println("<h2>Choose an Auto</h2>");
		out.println("<form>");
		out.println("<select name=make and model size=2>");
		out.println("<option> Ford Wagon ZTW");
		out.println("</select>");
		out.println("</form>");
		out.println("</body>");
		
		out.println("</html>");
	}
}
