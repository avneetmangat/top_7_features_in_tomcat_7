package tomcat7demo;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CsrfTestServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        System.out.println("Request received by CsrfTestServlet");
        Enumeration<String> e = request.getSession().getAttributeNames();
        while( e.hasMoreElements() ){
            String key = e.nextElement();
            System.out.println(key + " - " + request.getSession().getAttribute(key) );
        }
        System.out.println("CsrfTestServlet finished processing the request");

        RequestDispatcher rd = request.getRequestDispatcher("/csrf_response.jsp");
        rd.forward(request, response);
    }
}
