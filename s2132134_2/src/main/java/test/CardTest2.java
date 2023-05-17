package test;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@WebServlet("/CardTest2")
public class CardTest2 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public CardTest2() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String suit = request.getParameter("suit");
        String number[] = request.getParameterValues("number");
        String color = request.getParameter("color");
        String query = request.getParameter("query");

        System.out.println("--------");
        List<String> numberlist = null;
        if (number == null) {
            numberlist = new ArrayList<>();
        } else {
            numberlist = Arrays.asList(number);
        }
        System.out.println(numberlist);
        System.out.println("color=" + color);
        System.out.println("query=" + query);

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println(suit);
        out.println("<hr>");
        out.println(numberlist);
        out.println("<hr>");
        out.println(color);
        out.println("<hr>");
        out.println(query);

        out.println(query);
        out.println("<hr>");
        boolean[] suitFlag = new boolean[53];
        boolean[] numberFlag = new boolean[53];

        switch (suit) {
            case "all":
                for (int i=0; i<=52; i++) {
                    suitFlag[i] = true;
                }
                break;
            case "spade":
                for (int i=0; i<=12; i++) {
                    suitFlag[i] = true;
                }
                break;
            case "heart":
                for (int i=13; i<=25; i++) {
                    suitFlag[i] = true;
                }
                break;
            case "dia":
                for (int i=26; i<=38; i++) {
                    suitFlag[i] = true;
                }
                break;
            case "club":
                for (int i=39; i<=52; i++) {
                    suitFlag[i] = true;
                }
                break;
        }
        switch (color) {
            default:
                break;
            case "red":
                for (int i=0; i<=12; i++) {
                    suitFlag[i] = false;
                }
                for (int i=39; i<=52; i++) {
                    suitFlag[i] = false;
                }
                break;
            case "black":
                for (int i=13; i<=38; i++) {
                    suitFlag[i] = false;
                }
                break;

        }

        if (Objects.equals(numberlist.get(numberlist.size() - 1), "0")) {
            int i = 0;
            for (boolean s: suitFlag) {
                numberFlag[i] = s;
                i += 1;
            }
        } else {
            int i = 1;
            for (boolean s: suitFlag) {
                for (String num: numberlist) {
                    int n = Integer.parseInt(num);
                    if (n == (i % 13)) {
                        numberFlag[i - 1] = s;
                    }
                }

                i += 1;
            }
        }
        System.out.println(numberFlag[0]);
        out.println(numberlist.contains("1"));
        out.println("<br>");
        for (int i=1; i<=52; i++) {
            if (numberFlag[i - 1]) {
                String filename = "cards/" + i + ".png";
                out.printf("<img src=\"%s\" width=\"100\" height=\"150\">\n", filename);
            }
        }

        out.println("</html>");
    }
}