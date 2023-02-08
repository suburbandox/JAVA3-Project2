package twilio;


import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
//import com.twilio.rest.lookups.v1.PhoneNumber;
import com.twilio.type.PhoneNumber;
import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvEntry;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "SMSout", value = "/SMSout")
public class SMSout extends HttpServlet {
    private String TWILIO_PHONE;
    private String TWILIO_SID;
    private String TWILIO_KEY;

    @Override
    public void init() throws ServletException {
        Dotenv dotenv = Dotenv.configure().load();
        TWILIO_PHONE = dotenv.get("TWILIO_PHONE");
        TWILIO_SID = dotenv.get("TWILIO_SID");
        TWILIO_KEY = dotenv.get("TWILIO_KEY");
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Twilio.init(TWILIO_SID, TWILIO_KEY);

        Message message = Message.creator(new PhoneNumber("+15558675309"),
                new PhoneNumber(TWILIO_PHONE),
                "This is the ship that made the Kessel Run in fourteen parsecs?").create();

        System.out.println(message.getSid());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
