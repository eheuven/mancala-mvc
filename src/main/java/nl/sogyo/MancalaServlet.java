package nl.sogyo;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

import nl.sogyo.mancala.Vakje;

public class MancalaServlet extends HttpServlet {
	
   protected void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	  
	   Vakje vakje1 = new Vakje();
      
	   Vakje vakje2 = (Vakje) vakje1.geefVolgende(1);
       
       
       request.setAttribute("vakje1", vakje1);
       request.setAttribute("vakje2", vakje2);
       
       RequestDispatcher rd = request.getRequestDispatcher("mancalaApplicatie.jsp");
       rd.forward(request, response);
   }
}
