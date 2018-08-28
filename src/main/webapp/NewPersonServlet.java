public class NewPersonServlet extends HttpServlet {
   protected void doGet (HttpServletRequest request, HttpServletResponse response) 
throws IOException, ServletException {
       Person person = new Person();
       person.setLastName("Bond");
       person.setFirstName("James");
      
       request.setAttribute("currentPerson", person);
       RequestDispatcher rd = request.getRequestDispatcher("showCurrentPerson.jsp");
       rd.forward(request, response);
   }
}
