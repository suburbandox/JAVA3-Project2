package ch3and4;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(
        name = "TemperatureConverter"
        , urlPatterns = {"/temp", "/temp-converter"}
        , loadOnStartup = 1
)
public class TemperatureConverter extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/temp.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String temp = request.getParameter("btnradio");
        String degrees = request.getParameter("degrees");
        String equals = "";
        double equals2 = 32;
        String equals3 ="32";


        Map<String, String> results = new HashMap<>();

        try {
            Double.parseDouble(degrees);
            if (temp.equals("Fahrenheit")){
                equals2=(Double.parseDouble(degrees)-32)*5/9;
                equals3 = String.format("%.3f %n",equals2);
                equals = "("+degrees+"\u00B0F-32) x 5/9 = "+equals3+"\u00B0C";
                results.put("Fahrenheit","true");
                results.put("temp",equals);
                if(Double.parseDouble(degrees)<-459.67){
                    results.put("temp","Invalid temperature");
                }
            }else if (temp.equals("Celsius")){
                equals2 =Double.parseDouble(degrees)*1.8+32;
                equals3 = String.format("%.3f %n",equals2);
                equals = "("+degrees+"\u00B0C x 9/5) + 32  = "+equals3+"\u00B0F";
                results.put("Celsius","true");
                results.put("temp",equals);
                if(Double.parseDouble(degrees)<-273.15){
                    results.put("temp","Invalid temperature");
                }
            }
            results.put("degrees",degrees);
        } catch(NumberFormatException e) {
            results.put("temp","0");
        }catch (NullPointerException e){
            results.put("temp","choice is required.");
        }
        if(temp=="null"){
            results.put("temp","choice is required.");
        }
        request.setAttribute("results", results);
        request.getRequestDispatcher("WEB-INF/temp.jsp").forward(request, response);
    }
}