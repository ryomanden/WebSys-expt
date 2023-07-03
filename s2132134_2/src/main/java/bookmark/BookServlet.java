package bookmark;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/book")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

    public BookServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/book.jsp");
		String bookID = request.getParameter("bookID");
		Book(request,response,Integer.parseInt(bookID));
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	void Book(HttpServletRequest request, HttpServletResponse response, int bookID)
			throws ServletException {
		BookmarkDAO bookmarkDAO = new BookmarkDAO();
		Booklist book = bookmarkDAO.Book(bookID);
		List<ReviewModel> review = bookmarkDAO.Reviewlist(bookID);
		request.setAttribute("book", book);
		request.setAttribute("review", review);
	}

}
