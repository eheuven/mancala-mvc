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
	
	int aantalBordInfoItems; 
	
   protected void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

	   HttpSession session = request.getSession();
	   
	   Vakje beginVakje = new Vakje(); // remove later
	   
	   MancalaInfo mancala = new MancalaInfo(beginVakje);

	   maakBord(session, beginVakje);// change
	   
	   
	   session.setAttribute("mancalaInfo", mancala);
	   session.setAttribute("message", mancala.getMessage());

       RequestDispatcher rd = request.getRequestDispatcher("mancalaApplicatie.jsp");
       rd.forward(request, response);
   }
  


   private ArrayList<BordItemInfo> maakVakjeInfoLijst(BordItem loopVakje){
	   ArrayList<BordItemInfo> vakjeLijst = new ArrayList<>();
	   for(int i = 0; loopVakje instanceof Vakje; i++) {
		   vakjeLijst.add(maakBordItemInfo(loopVakje));
		   loopVakje = loopVakje.geefVolgende();  
	   }
	   return vakjeLijst;
   }
    
   private BordItemInfo maakBordItemInfo(BordItem bordItem) {
	   BordItemInfo item = new BordItemInfo();
	   item.setAantalStenen(bordItem.getAantalStenen());
	   item.setItemNr(aantalBordInfoItems);
	   aantalBordInfoItems ++;
	   return item;
   }
   
   
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	   HttpSession session = request.getSession();
	   Vakje beginVakje = (Vakje) session.getAttribute("beginVakje");
	   
	   Enumeration<String> parameterNames = request.getParameterNames();
	   int vakjeNrGeklikt = Integer.valueOf(parameterNames.nextElement()); // naam van button in input = BordItem object
	   BordItem gekliktItem = beginVakje.geefVolgende(vakjeNrGeklikt);
			   
	   if(gekliktItem instanceof Vakje) {
		   ((Vakje) gekliktItem).doeZet();
	   }
	   
	   maakBord(session,beginVakje);
	   
	   session.setAttribute("message", mancala.getMessage());
	   
	   RequestDispatcher rd = request.getRequestDispatcher("mancalaApplicatie.jsp");
       rd.forward(request, response);
   }
   
   private void maakBord(HttpSession session, Vakje beginVakje) {
	   aantalBordInfoItems = 0;
	   Vakje vakje2 = (Vakje) beginVakje.vindKalaha().geefVolgende();

	   ArrayList<BordItemInfo> vakjeInfoLijst1 = maakVakjeInfoLijst(beginVakje); 
	   Collections.reverse(vakjeInfoLijst1); // bovenkant tegen de klok in
	   BordItemInfo kalaha1 = maakBordItemInfo(beginVakje.vindKalaha());
	   ArrayList<BordItemInfo> vakjeInfoLijst2 = maakVakjeInfoLijst(vakje2);
	   BordItemInfo kalaha2 = maakBordItemInfo(vakje2.vindKalaha());
	 
	   session.setAttribute("vakjeInfoLijst1", vakjeInfoLijst1);
	   session.setAttribute("kalaha1",kalaha1);
	   session.setAttribute("vakjeInfoLijst2", vakjeInfoLijst2);
	   session.setAttribute("kalaha2",kalaha2);   
}


int vindIndex(String referenceName, ArrayList<Vakje> vakjeLijst) {
	   for(Vakje vakje: vakjeLijst) {
		   if(vakje.toString().equals(referenceName)) {
			   return vakjeLijst.indexOf(vakje);
		   }
	   }
	   return -1;
   }
   
}
