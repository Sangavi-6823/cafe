import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class LalaServlet
 */
public class RegisterServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
response.getWriter().append("Served at: ").append(request.getContextPath());
}

/**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
*/
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
String name=request.getParameter("name");
String pass=request.getParameter("pass");
String email=request.getParameter("email");
String phone=request.getParameter("phone");
        RegisterDoa db=new RegisterDoa(name,pass,email,phone);
        if(db.store()) {
        RequestDispatcher req=request.getRequestDispatcher("index1.jsp");
            req.forward(request, response);
        }
        else {
      RequestDispatcher req=request.getRequestDispatcher("category.html");
      req.forward(request, response);
        }
        doGet(request,response);
}
}
