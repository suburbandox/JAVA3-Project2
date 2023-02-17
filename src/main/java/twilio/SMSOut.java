package twilio;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "SMSOut", value = "/send-message")
public class SMSOut extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/message.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String phone = request.getParameter("phone");
        String message = request.getParameter("message");
        String choice = request.getParameter("tele");
        //String val = choice.
        Map<String, String> results = new HashMap<>();
        results.put("message2","");
        Twilio twilio = new Twilio();
        if (choice.equals("1"))
        {
           results.put("message2","Message sent");
            try {
                twilio.sendTextMessage(phone, message);
            } catch (IllegalArgumentException e) {
                results.put("messageError", e.getMessage());
            }
        }
        else if(choice.equals("2"))
        {
            results.put("message2","Call made");
            try {
                twilio.Call(phone, message);
            } catch (IllegalArgumentException e) {
                results.put("messageError", e.getMessage());
            }
        }
        results.put("phone", phone);
        results.put("message", message);

        request.setAttribute("results", results);

        request.getRequestDispatcher("WEB-INF/message.jsp").forward(request, response);
    }
}
