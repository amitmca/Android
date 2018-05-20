package web.com;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Prashant
 */
@WebServlet(name="AndroidResponse", urlPatterns={"/androidres.do"})
public class AndroidResponse extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        String un,pw;
        un=request.getParameter("username");
        pw=request.getParameter("password");
        if(un.equalsIgnoreCase("prashant") && pw.equals("sharma"))
            out.print(1);
        else
            out.print(0);
    }
}