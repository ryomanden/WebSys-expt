package bookmark;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/favorite")
public class BookmarkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BookmarkServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/bookmark.jsp");
		String userID = request.getParameter("userID");
		Booklist(request,response,Integer.parseInt(userID));
		dispatcher.forward(request, response);
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
