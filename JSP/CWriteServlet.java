package JSP;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/CWrite")
public class CWriteServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
 		doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {

	  PrintWriter out = response.getWriter ();

	  Cookie c = new Cookie("TestCookie","0");
	  response.addCookie(c);
	  out.println("Cookie set");
    }
}
