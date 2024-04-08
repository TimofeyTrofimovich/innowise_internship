package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class HomeServletTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private RequestDispatcher requestDispatcher;

    @Test
    public void testDoGet() throws ServletException, IOException {

        when(request.getRequestDispatcher("/WEB-INF/jsp/home.jsp")).thenReturn(requestDispatcher);

        new HomeServlet().doGet(request, response);

        verify(request, times(1)).getRequestDispatcher("/WEB-INF/jsp/home.jsp");
        verify(requestDispatcher, times(1)).forward(request, response);
    }
}
