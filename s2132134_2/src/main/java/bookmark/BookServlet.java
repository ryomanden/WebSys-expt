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
		int bookID = Integer.parseInt(request.getParameter("bookID"));
		if (session.getAttribute("isLogin") == null) {
			session.setAttribute("target", "./book?bookID="+String.valueOf(bookID));
			request.getRequestDispatcher("./login").forward(request,response);
		} else {
			toBool isLogin = new toBool(session.getAttribute("isLogin"));
			if (!isLogin.get()) {		
				session.setAttribute("target", "./book?bookID="+String.valueOf(bookID));
				request.getRequestDispatcher("./login").forward(request,response);
			} else {
				int userID = (int)session.getAttribute("userID");
				RequestDispatcher dispatcher = request.getRequestDispatcher("./book.jsp");
				Book(request,response,bookID);
				Review(request,response,userID,bookID);
				FavoriteModel fav = getFav(userID,bookID);
				Boolean isFav = (fav != null) ? true : false;
				request.setAttribute("isFav", isFav);
				dispatcher.forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");		
		HttpSession session = request.getSession(true);
		int bookID = Integer.parseInt(request.getParameter("bookID"));
		int userID = (int)session.getAttribute("userID");
		Boolean isSuccess = false;
		if (request.getParameter("reviewTitle") != null && request.getParameter("review") != null) {
			isSuccess = updateReview(userID,bookID,request.getParameter("reviewTitle"),request.getParameter("review"));			
		}
		if (request.getParameter("fav") != null) {
			isSuccess = setFav(userID,bookID);
		}
		request.setAttribute("isSuccess", isSuccess);
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

	boolean updateReview(int userID, int bookID, String title, String review) {
		BookmarkDAO bookmarkDAO = new BookmarkDAO();
		return bookmarkDAO.updateReview(userID, bookID, title, review);
	}
	
	FavoriteModel getFav(int userID, int bookID) {
		BookmarkDAO bookmarkDAO = new BookmarkDAO();
		return bookmarkDAO.getFav(userID, bookID);
	}
	boolean setFav(int userID, int bookID) {
		BookmarkDAO bookmarkDAO = new BookmarkDAO();
		return bookmarkDAO.setFav(userID, bookID);
	}
}
