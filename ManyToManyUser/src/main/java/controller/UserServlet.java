package controller;

import bean.User;
import service.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/home")
public class UserServlet extends HttpServlet {
    private UserServiceImpl service = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "create":
//                showCreate(request, response);
                break;
            case "update":
//                showUpdate(request, response);
                break;
            case "delete":
                showDeleteCustomer(request,response);
                break;
            default:
                showList(request, response);
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = service.findAll();
        request.setAttribute("users", users);
        request.getRequestDispatcher("view/home.jsp")
                .forward(request, response);
    }

    private void showDeleteCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idDetail = Integer.parseInt(request.getParameter("id"));
        if (service.delete(idDetail)){
            response.sendRedirect("/home");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
