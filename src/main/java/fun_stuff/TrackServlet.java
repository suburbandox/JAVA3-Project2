package fun_stuff;

import se.michaelthelin.spotify.model_objects.specification.AlbumSimplified;
import se.michaelthelin.spotify.model_objects.specification.TrackSimplified;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TrackServlet", value = "/tracks")
public class TrackServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String album = request.getParameter("album");
        request.setAttribute("album", album);
        TrackSimplified[] tracks = MySpotify.getTracks(album);
        request.setAttribute("tracks", tracks);
        request.getRequestDispatcher("WEB-INF/funstuff/tracks.jsp").forward(request, response);

    }
}
