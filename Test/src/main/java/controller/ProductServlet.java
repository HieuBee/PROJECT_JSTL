package controller;

import bean.Product;
import service.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/product")
public class ProductServlet extends HttpServlet {
    private ProductServiceImpl service = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "create":
                showCreate(request, response);
                break;
            case "delete":
                showDelete(request,response);
                break;
            case "update":
                showUpdate(request, response);
                break;
            default:
                showList(request, response);
        }
    }

    private void showUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = service.findById(id);
        request.setAttribute("product", product);
        request.getRequestDispatcher("view/update.jsp")
                .forward(request, response);
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = service.findAll();
        request.setAttribute("products", products);
        request.getRequestDispatcher("view/home.jsp")
                .forward(request, response);
    }

    private void showDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        service.delete(id);
        response.sendRedirect("/product");
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("view/create.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "create":
                doCreate(request, response);
                break;
            case "search":
                doSearch(request, response);
                break;
            case "update":
                doUpdate(request, response);
                break;
            default:
                response.sendRedirect("/product?action=list");
        }
    }

    private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        String categories = request.getParameter("categories");
        Product product = new Product(id, name, price, quantity, color, description,categories);
        service.update(product);
        response.sendRedirect("/product");
    }

    private void doSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("search");
        List<Product> products = service.search(search);
        request.setAttribute("products", products);
        request.getRequestDispatcher("view/home.jsp")
                .forward(request, response);
    }

    private void doCreate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        String categories = request.getParameter("categories");
        Product product = new Product(name, price, quantity, color, description,categories);
        service.create(product);
        response.sendRedirect("/product");
    }
}
