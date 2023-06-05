package controller;

import model.Customer;
import service.CustomerSvImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/home")
public class CustomerServlet extends HttpServlet {
    private CustomerSvImpl customerSv = new CustomerSvImpl();

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
            case "detail":
//                showDetail(request, response);
                break;
            case "delete":
                showDeleteCustomer(request,response);
                break;
            default:
                showList(request, response);
        }
    }

    private void showDeleteCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idDetail = Integer.parseInt(request.getParameter("id"));
        if (customerSv.delete(idDetail)){
            response.sendRedirect("/home");
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customers = customerSv.findAll();
        request.setAttribute("customers", customers);
        request.getRequestDispatcher("view/customer/home.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
