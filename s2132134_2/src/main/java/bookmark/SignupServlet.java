package bookmark;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SignupServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher dispatcher = request.getRequestDispatcher("./signup.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession(true);
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		session.setAttribute("signUpStatus",signUp(request,response,user,pass));
		doGet(request, response);
	}
	String signUp(HttpServletRequest request, HttpServletResponse response, String userName, String Pass) throws ServletException, IOException {
		BookmarkDAO bookmarkDAO = new BookmarkDAO();
		return bookmarkDAO.signUp(userName,Pass);
	}
}
