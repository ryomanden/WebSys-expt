package bookmark;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(true);
		if (session.getAttribute("isLogin") == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("./login.jsp");
			request.setAttribute("current", "login");
			dispatcher.forward(request, response);			
		} else {
			toBool isLogin = new toBool(session.getAttribute("isLogin"));
			if (!isLogin.get()) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("./login.jsp");
				request.setAttribute("current", "login");
				dispatcher.forward(request, response);			
			} else {
				String target = (String)session.getAttribute("target");
				request.getRequestDispatcher((target != null) ? target : "./list").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");		
		HttpSession session = request.getSession(true);
		
		BookmarkDAO bookmarkDAO = new BookmarkDAO();
		
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		
		System.out.println("username : "+ user);
		System.out.println("password : "+ pass);

		session.setAttribute("userName", user);
		
		AuthModel auth = bookmarkDAO.Auth(user);
		if (auth != null) {
			System.out.println("username_db : "+ auth.getUserName());
			System.out.println("password_db : "+ auth.getPasswd());
		}
		if (auth != null && auth.getPasswd().equals(pass)) {
			session.setAttribute("isLogin", "true");
			session.setAttribute("userID", auth.getUserId());
			System.out.println("User ID = " + session.getAttribute("userID"));
			System.out.println("login success");
		} else {
			session.setAttribute("isLogin", "false");			
			System.out.println("login failre");
		}
		doGet(request, response);
	}
}
