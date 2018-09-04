package nl.sogyo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

import javax.servlet.*;
import javax.servlet.http.*;

import nl.sogyo.mancala.*;

public class MancalaServlet extends HttpServlet {
	
	int aantalBordInfoItems; 
	
   protected void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

	   HttpSession session = request.getSession();  
	   MancalaInfo mancala = new MancalaInfo(new Vakje());
	   
	   updateSession(session, mancala);
	   
       RequestDispatcher rd = request.getRequestDispatcher("mancalaApplicatie.jsp");
       rd.forward(request, response);
   }

   
   private void updateSession(HttpSession session, MancalaInfo mancala) {
	   Speler speler1 = mancala.getSpelerLijst().get(0);
	   Speler speler2 = mancala.getSpelerLijst().get(1);
	   ArrayList<BordItemInfo> speler1VakjeInfoLijst = mancala.getVakjeInfoLijst(speler1);
	   Collections.reverse(speler1VakjeInfoLijst);
	   
	   session.setAttribute("vakjeInfoLijst1", speler1VakjeInfoLijst);
	   session.setAttribute("vakjeInfoLijst2", mancala.getVakjeInfoLijst(speler2));
	   session.setAttribute("kalaha1",mancala.getKalahaInfo(speler1));
	   session.setAttribute("kalaha2",mancala.getKalahaInfo(speler2));  
	   session.setAttribute("message", mancala.getMessage());
	   session.setAttribute("mancalaInfo", mancala);
   }


protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	   HttpSession session = request.getSession();
	   MancalaInfo mancala = (MancalaInfo) session.getAttribute("mancalaInfo");

	   if(mancala == null) {
		   doGet(request,response);
	   }else {

		   int vakjeNrGeklikt = Integer.valueOf(request.getParameter("vakjeNr")); 
		   BordItem gekliktItem = mancala.geefBordItem(vakjeNrGeklikt);
				   
		   if(gekliktItem instanceof Vakje) {
			   ((Vakje) gekliktItem).doeZet();
			   mancala.updateInfo();
			   updateSession(session,mancala);
		   }
		   
		   RequestDispatcher rd = request.getRequestDispatcher("mancalaApplicatie.jsp");
	       rd.forward(request, response);
	   }
   }
   
   
}
