package ch3and4;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.*;

@WebServlet(
        name = "AddServlet"
//        , value = "/add"
        , urlPatterns = {"/add", "/sum", "/addition"}
        , loadOnStartup = 1
)
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstNumber = request.getParameter("firstNumber");
        String secondNumber = request.getParameter("secondNumber");
        Map<String,String> results = add(firstNumber, secondNumber);

    }
    private Map<String, String> add(String num1, String num2) {
        Map<String, String> results = new HashMap<>();
        boolean num1Valid = isNumeric(num1);
        boolean num2Valid = isNumeric(num2);
        return results;
    }

    private boolean isNumeric(String num) {
        try {
            Double.parseDouble(num);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }

}
