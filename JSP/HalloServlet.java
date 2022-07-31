package JSP;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/Hallo")
public class HalloServlet extends HttpServlet {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<HTML>\n" +
                "<HEAD><TITLE>Hallo</TITLE></HEAD>\n" +
                "<BODY>\n" +
                "<H1>Hallo Servletnutzer</H1>\n" +
                "</BODY></HTML>");
  }
}
