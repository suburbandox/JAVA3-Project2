package fun_stuff;

import se.michaelthelin.spotify.model_objects.specification.Album;
import se.michaelthelin.spotify.model_objects.specification.AlbumSimplified;
import se.michaelthelin.spotify.model_objects.specification.Artist;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AlbumsServlet", value = "/albums")
public class AlbumsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String artist = request.getParameter("artist");
        request.setAttribute("artist", artist);
        AlbumSimplified[] albums = MySpotify.getAlbums(artist);
        request.setAttribute("albums", albums);
        request.getRequestDispatcher("WEB-INF/funstuff/albums.jsp").forward(request, response);
    }

}
