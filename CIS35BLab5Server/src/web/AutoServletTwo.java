package web;

import model.*;
import adapter.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AutoServletTwo extends HttpServlet
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
		out.println("<h2>Configure your Auto</h2>");
		out.println("<form>");
		
		ProxyAutomotive p = new BuildAuto();
		//loop
		Automotive auto = p.find("Ford Wagon ZTW");
		for(int i=0; i < auto.getSize(); i++)
		{
			out.println("<select name=" + auto.getOptionSet(i).getName() + "size=2>");
			for(int j=0; j < auto.getOptionSet(i).getSize(); j++)
			{
				out.println("<option>" + auto.getOption(new int[]{i,j}).getName());
			}
			out.println("</select>");
		}
		
		request.setAttribute("auto", auto);
		RequestDispatcher dispatcher = new RequestDispatcher("Report.jsp");
		dispatcher.forward(request, response);
		
		out.println("</form>");
		out.println("</body>");
		
		out.println("</html>");
	}
}