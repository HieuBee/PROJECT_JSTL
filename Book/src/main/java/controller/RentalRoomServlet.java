package controller;

import bean.RentalRoom;
import service.impl.RentalRoomServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "RentalRoomServlet", value = "/RentalRoom")
public class RentalRoomServlet extends HttpServlet {
    private RentalRoomServiceImpl service = new RentalRoomServiceImpl();

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
            default:
                showList(request, response);
        }
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

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<RentalRoom> rentalRoom = service.findAll();
        request.setAttribute("rentalRoom", rentalRoom);
        request.getRequestDispatcher("view/home.jsp")
                .forward(request, response);
    }

    private void showDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        if (service.delete(id)){
            response.sendRedirect("/RentalRoom");
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
            case "deleteALot":
                doDeleteALot(request, response);
                break;
            default:
                response.sendRedirect("/RentalRoom?action=list");
        }
    }

    private void doDeleteALot(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String[] arrDelete = request.getParameterValues("choose");
        for (String item : arrDelete) {
            service.delete(Integer.parseInt(item));
        }
        response.sendRedirect("/RentalRoom");
    }

    private void doSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("search");
        List<RentalRoom> rentalRoomList = service.search(search);
        request.setAttribute("rentalRoom", rentalRoomList);
        request.getRequestDispatcher("view/home.jsp")
                .forward(request, response);
    }

    private void doCreate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        int phone = Integer.parseInt(request.getParameter("phone"));
        String borrowDate = request.getParameter("borrowDate");
        String payment = request.getParameter("payment");
        String note = request.getParameter("note");
        RentalRoom rentalRoom = new RentalRoom(name, phone, borrowDate, payment, note);
        service.create(rentalRoom);
        response.sendRedirect("/RentalRoom");
    }
}
