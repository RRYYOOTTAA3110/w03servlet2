package jp.webschool.javaweb.chapter03;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
* Servlet implementation class PasswordAuthentication
*/
public class PasswordAuthentication extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private String id = "webschool";
    private String password = "webschool";

    /**
     * @see HttpServlet#doPost(HttpServletRequest request,
     *                                                   HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
                                           throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String id = request.getParameter("id");
        String password = request.getParameter("password");

        String message = judge(id, password);

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(message);
    }

    private String judge(String id, String password) {
        String message;
        if (this.id.equals(id) && this.password.equals(password)) {
            message = "ログインされました。";
        } else {
            message = "ログインできません。";
        }
        return message;
    }

}