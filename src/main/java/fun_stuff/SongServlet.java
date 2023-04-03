package fun_stuff;

import se.michaelthelin.spotify.model_objects.specification.AlbumSimplified;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SongServlet", value = "/data")
public class SongServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String q = request.getParameter("q");
        String track = request.getParameter("track");
        if(q == null) {
            q = " ";
        }
        request.setAttribute("song", q);
        request.setAttribute("track", track);
        String data = MySpotify.getData(track);
        request.setAttribute("data", data);
        request.getRequestDispatcher("WEB-INF/funstuff/data.jsp").forward(request, response);
    }

}
