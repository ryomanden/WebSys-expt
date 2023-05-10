package poker;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/PokerServlet")
public class PokerServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
PokerModel model;
public PokerServlet() {
super();
model = new PokerModel();
}
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
model.reset();
model.nextgame();
request.setAttribute("model", model);
RequestDispatcher dispatcher = request.getRequestDispatcher("/poker.jsp");
dispatcher.forward(request, response);
}
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
model.nextgame();
request.setAttribute("model", model);
RequestDispatcher dispatcher = request.getRequestDispatcher("/poker.jsp");
dispatcher.forward(request, response);
}
}