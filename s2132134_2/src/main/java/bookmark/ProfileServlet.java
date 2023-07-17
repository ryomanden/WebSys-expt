package bookmark;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ProfileServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(true);
		if (session.getAttribute("isLogin") == null) {
			session.setAttribute("target", "./profile");
			request.getRequestDispatcher("./login").forward(request,response);
		} else {
			toBool isLogin = new toBool(session.getAttribute("isLogin"));
			if (!isLogin.get()) {
				session.setAttribute("target", "./profile");
				request.getRequestDispatcher("./login").forward(request,response);
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("./profile.jsp");
				int userID = (int)session.getAttribute("userID");
				User(request, response, userID);
				request.setAttribute("current", "profile");
				request.setAttribute("isLogin", isLogin.get());
				dispatcher.forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");		
		HttpSession session = request.getSession(true);
		int userID = (int)session.getAttribute("userID");
		boolean isSuccess = updateBio(request,response,userID,request.getParameter("bio"));
		request.setAttribute("isSuccess", isSuccess);
		doGet(request, response);
	}
	
	boolean updateBio(HttpServletRequest request, HttpServletResponse response, int userID, String bio)
			throws ServletException {
		BookmarkDAO bookmarkDAO = new BookmarkDAO();
		return bookmarkDAO.updateBio(userID,bio);
	}
	
	void User(HttpServletRequest request, HttpServletResponse response, int userID)
			throws ServletException {
		BookmarkDAO bookmarkDAO = new BookmarkDAO();
		UserModel user = bookmarkDAO.User(userID);
		request.setAttribute("user",user);
	}
}
