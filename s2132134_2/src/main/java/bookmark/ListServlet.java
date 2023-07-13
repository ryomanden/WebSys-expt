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

@WebServlet("/list")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(true);
		RequestDispatcher dispatcher = request.getRequestDispatcher("./booklist.jsp");
		Booklist(request,response);
		request.setAttribute("current", "list");
		if (session.getAttribute("isLogin") == null) {
			request.setAttribute("isLogin", false);			
		} else {
			toBool isLogin = new toBool(session.getAttribute("isLogin"));
			request.setAttribute("isLogin", isLogin.get());			
		}
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	void Booklist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		BookmarkDAO bookmarkDAO = new BookmarkDAO();
		List<Booklist> list = bookmarkDAO.Booklist();
		request.setAttribute("list", list);
	}

}
