public class PrintOut
{
  public static void main(String[] args)
  {
		System.out.println("<html>");

		System.out.out.println("<head>");
		System.out.out.println("<title>KBB</title>");
		System.out.out.println("</head>");

		System.out.out.println("<body>");
		System.out.out.println("<h2>Configure your Auto</h2>");
		System.out.out.println("<form>");

		ProxyAutomotive p = new BuildAuto();
		//loop
		Automotive auto = p.find("Ford Wagon ZTW");
		for(int i=0; i < auto.getSize(); i++)
		{
			System.out.out.println("<select name=" + auto.getOptionSet(i).getName() + "size=2>");
			for(int j=0; j < auto.getOptionSet(i).getSize(); j++)
			{
				System.out.out.println("<option>" + auto.getOption(new int[]{i,j}).getName());
			}
		}

		//request.setAttribute("auto", auto);
		//RequestDispatcher dispatcher = new RequestDispatcher("Report.jsp");
		//dispatcher.forward(request, response);

		System.out.out.println("</select>");
		System.out.out.println("</form>");
		System.out.out.println("</body>");

		System.out.out.println("</html>");
  }
}
