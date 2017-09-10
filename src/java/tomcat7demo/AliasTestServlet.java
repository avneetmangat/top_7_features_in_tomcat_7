package tomcat7demo;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AliasTestServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        System.out.println("Request received by AliasTestServlet");

        System.out.println("Trying to read image from /static/bg.png ...");
        ByteArrayInputStream bais = (ByteArrayInputStream)getServletContext().getResourceAsStream("/static/bg.png");
        BufferedImage image = ImageIO.read(bais);
        System.out.println("Image height: " + image.getHeight() + ", width: " + image.getWidth());

        RequestDispatcher rd = request.getRequestDispatcher("/alias_test_response.jsp");
        rd.forward(request, response);
    }
}
