package bookmark;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/user.jsp");
		String userID = request.getParameter("userID");
		Book(request,response,Integer.parseInt(userID));
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	void Book(HttpServletRequest request, HttpServletResponse response, int userID)
			throws ServletException {
		BookmarkDAO bookmarkDAO = new BookmarkDAO();
		UserModel user = bookmarkDAO.User(userID);
		List<ReviewModel> review = bookmarkDAO.UserReviewlist(userID);
		request.setAttribute("user", user);
		request.setAttribute("review", review);
	}

}
