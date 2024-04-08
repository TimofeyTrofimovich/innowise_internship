package servlet;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;


import java.io.IOException;

import static org.mockito.Mockito.*;

public class ChequeServletTest {

    @Test
    public void testDoPost() throws ServletException, IOException {

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);


        String[] items = {"Book", "Laptop"};
        when(request.getParameterValues("items")).thenReturn(items);

        when(request.getRequestDispatcher("/WEB-INF/jsp/cheque.jsp")).thenReturn(dispatcher);

        new ChequeServlet().doPost(request, response);

       //0 verify(request).setAttribute(eq("items"), an);
        verify(request).setAttribute("sum", 835.5);
        verify(dispatcher).forward(request, response);
    }
}
