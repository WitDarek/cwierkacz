package controller;

import com.sun.deploy.si.SingleInstanceImpl;
import model.User;
import repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

@WebServlet(name = "loginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        User user = UserRepository.INSTANCE.getDAO().get(login);
        if (user == null) {
            beckToIndex(resp);

        }
        if (user.getPassword().equals(password)) {
            req.getSession().setAttribute("user", user);
            resp.getWriter().println("Użytkownik został pomyślnie zalogowany");
            return;
        }
        resp.getWriter().println("Niepoprawne dane logowania");
        beckToIndex(resp);
    }

    public static void beckToIndex(HttpServletResponse resp) throws IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        PrintWriter print = resp.getWriter();
        print.println("<p>Niepoprawne dane logowania</p>");
        print.println("<a href = 'index.jsp'>Wróć do indexu</a>");
    }
}

