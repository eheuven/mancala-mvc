package nl.sogyo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

import javax.servlet.*;
import javax.servlet.http.*;

import nl.sogyo.mancala.*;

public class MancalaServlet extends HttpServlet {
	
   protected void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

	   Vakje vakje1 = new Vakje();
	   ArrayList<Vakje> vakjeLijst1 = maakVakjeLijst(vakje1);
	   
	   Kalaha kalaha1 = vakje1.vindKalaha();
	   
	   Vakje vakje2 = (Vakje) kalaha1.geefVolgende();
	   ArrayList<Vakje> vakjeLijst2 = maakVakjeLijst(vakje2);
	   Kalaha kalaha2 = vakje2.vindKalaha();
	   
	   vakjeLijst1.get(4).doeZet();
	   
	   Collections.reverse(vakjeLijst1);
       request.setAttribute("vakjeLijst1", vakjeLijst1);
       request.setAttribute("kalaha1",kalaha1);
 
       request.setAttribute("vakjeLijst2", vakjeLijst2);
       request.setAttribute("kalaha2",kalaha2);

       /*HttpSession session = request.getSession();
	   session.setAttribute("vakjeLijst1", vakjeLijst1);
	   session.setAttribute("kalaha1",kalaha1);
	   session.setAttribute("vakjeLijst2", vakjeLijst2);
	   session.setAttribute("kalaha2",kalaha2);*/
       
       RequestDispatcher rd = request.getRequestDispatcher("mancalaApplicatie.jsp");
       rd.forward(request, response);
   }
   
   
   ArrayList<Vakje> maakVakjeLijst(BordItem loopVakje){
	   ArrayList<Vakje> vakjeLijst = new ArrayList<>();
	   while(loopVakje instanceof Vakje) {
		   vakjeLijst.add((Vakje) loopVakje);
		   loopVakje = loopVakje.geefVolgende();  
	   }
	   return vakjeLijst;
   }
    
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	   Enumeration<String> parameterNames = request.getParameterNames();
	   String paramName = parameterNames.nextElement(); // naam van button in input = BordItem object
	   
	   PrintWriter out = response.getWriter();
	   response.setContentType("text/plain");
	   out.write(paramName);

	   
	   out.close();

   }
   
}
