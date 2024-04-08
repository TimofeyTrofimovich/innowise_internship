package servlet;


import dto.Item;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.ItemCreator;
import util.PriceHelper;

import java.io.IOException;

@WebServlet("/cheque")
public class ChequeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Item[] items = ItemCreator.getItemsFromNames(req.getParameterValues("items"));
        req.setAttribute("items", items);
        req.setAttribute("sum", PriceHelper.getSumPrice(items));
        req.getRequestDispatcher("/WEB-INF/jsp/cheque.jsp").forward(req, resp);
    }
}
