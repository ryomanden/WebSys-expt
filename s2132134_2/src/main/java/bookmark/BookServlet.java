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

@WebServlet("/book")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

    public BookServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(true);
		RequestDispatcher dispatcher = request.getRequestDispatcher("./book.jsp");
		int bookID = IntegeCDr.parseInt(request.getParameter("bookID"));
		int userID = (int)session.getAttribute("userID");
		Book(request,response,bookID);
		Review(request,response,userID,bookID);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");		
		HttpSession session = request.getSession(true);
		int userID = (int)session.getAttribute("userID");
		int bookID = Integer.parseInt(request.getParameter("bookID"));
		updateReview(request,response,userID,bookID,request.getParameter("title"),request.getParameter("review"));
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
	
	void Review(HttpServletRequest request, HttpServletResponse response,int userID, int bookID)
			throws ServletException {
		BookmarkDAO bookmarkDAO = new BookmarkDAO();
		ReviewModel review =  bookmarkDAO.Review(userID, bookID);
		request.setAttribute("myReview", review);
	}

	void updateReview(HttpServletRequest request, HttpServletResponse response, int userID, int bookID, String title, String review)
			throws ServletException {
		BookmarkDAO bookmarkDAO = new BookmarkDAO();
		bookmarkDAO.updateReview(userID, bookID, title, review);
	}
}
