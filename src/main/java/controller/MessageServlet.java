package controller;

import model.Message;
import model.User;
import repository.MessageRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/*
        /messages?action=all - wszystkie wiadomości
        /messages?action=userMessages&user=login - wiadomości od danego użytkownika
 */
@WebServlet(name = "MessageServlet", urlPatterns = "/messages")
public class MessageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action =req.getParameter("action");
        if(action.equals("all")){
            List<Message> messages = MessageRepository.INSTANCE.getDAO().getAll();
            req.setAttribute("lista",messages);
            req.getRequestDispatcher("messages.jsp").forward(req,resp);
        }
        if(action.equals("userMessages")){
            String user = req.getParameter("user");
        }
        if(action.equals("add")){
            User user = (User) req.getSession().getAttribute("user");
            if(user == null){
                resp.getWriter().println("Zaloguj się aby dodać artykuł");
                return;
            }
            resp.sendRedirect("add_message.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        User user =(User) req.getSession().getAttribute("user");
        MessageRepository.INSTANCE.getDAO().save(new Message(title,content,user));
        resp.sendRedirect("messages?action=all");
    }

    @Override
    public void init() throws ServletException {

    }
}
