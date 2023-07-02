package bookmark;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/favorite")
public class BookmarkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BookmarkServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(true);
		if (session.getAttribute("isLogin") == null) {
			session.setAttribute("target", "/favorite");
			request.getRequestDispatcher("/login").forward(request,response);
		} else {
			toBool isLogin = new toBool(session.getAttribute("isLogin"));
			if (!isLogin.get()) {		
				session.setAttribute("target", "/favorite");
				request.getRequestDispatcher("/login").forward(request,response);
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/bookmark.jsp");
				int userID = (int)session.getAttribute("userID");
				Booklist(request,response,userID);
				dispatcher.forward(request, response);
			}
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	void Booklist(HttpServletRequest request, HttpServletResponse response, int userID)
			throws ServletException {
		BookmarkDAO bookmarkDAO = new BookmarkDAO();
		List<Booklist> list = bookmarkDAO.Booklist(userID);
		request.setAttribute("list", list);
	}

}
