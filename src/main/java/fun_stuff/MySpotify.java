package fun_stuff;

import com.neovisionaries.i18n.CountryCode;
import io.github.cdimascio.dotenv.Dotenv;
import org.apache.hc.core5.http.ParseException;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.credentials.ClientCredentials;
import se.michaelthelin.spotify.model_objects.specification.*;
import se.michaelthelin.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import se.michaelthelin.spotify.requests.data.albums.GetAlbumsTracksRequest;
import se.michaelthelin.spotify.requests.data.artists.GetArtistsAlbumsRequest;
import se.michaelthelin.spotify.requests.data.search.simplified.SearchArtistsRequest;
import se.michaelthelin.spotify.requests.data.tracks.GetTrackRequest;

import java.io.IOException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class MySpotify {
    private static String accessToken;
    public static String getAccessToken() {
        Dotenv dotenv = Dotenv.load();
        String clientId = dotenv.get("SPOTIFY_CLIENT_ID");
        String clientSecret = dotenv.get("SPOTIFY_CLIENT_SECRET");
        SpotifyApi spotifyApi = new SpotifyApi.Builder()
                .setClientId(clientId)
                .setClientSecret(clientSecret)
                .build();
        ClientCredentialsRequest clientCredentialsRequest = spotifyApi.clientCredentials()
                .build();
        ClientCredentials clientCredentials = null;
        try {
            clientCredentials = clientCredentialsRequest.execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SpotifyWebApiException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        accessToken = clientCredentials.getAccessToken();
        return accessToken;
    }

    public static Artist[] searchArtists(String q) {
        SpotifyApi spotifyApi = new SpotifyApi.Builder()
                .setAccessToken(getAccessToken())
                .build();
        SearchArtistsRequest searchArtistsRequest = spotifyApi.searchArtists(q)
                .market(CountryCode.US)
//          .limit(10)
//          .offset(0)
//          .includeExternal("audio")
                .build();
        Artist[] artists = null;
        try {
            final CompletableFuture<Paging<Artist>> pagingFuture = searchArtistsRequest.executeAsync();

            // Thread free to do other tasks...

            // Example Only. Never block in production code.
            final Paging<Artist> artistPaging = pagingFuture.join();
            artists = artistPaging.getItems();
        } catch (CompletionException e) {
            System.out.println("Error: " + e.getCause().getMessage());
        } catch (CancellationException e) {
            System.out.println("Async operation cancelled.");
        }
        return artists;
    }

    public static AlbumSimplified[] getAlbums(String artist) {
        SpotifyApi spotifyApi = new SpotifyApi.Builder()
                .setAccessToken(getAccessToken())
                .build();
        GetArtistsAlbumsRequest getArtistsAlbumsRequest = spotifyApi.getArtistsAlbums(artist)
//          .album_type("album")
          .limit(40)
//          .offset(0)
//          .market(CountryCode.SE)
                .build();
        AlbumSimplified[] albums = null;
        try {
            final CompletableFuture<Paging<AlbumSimplified>> pagingFuture = getArtistsAlbumsRequest.executeAsync();

            // Thread free to do other tasks...

            // Example Only. Never block in production code.
            final Paging<AlbumSimplified> albumSimplifiedPaging = pagingFuture.join();
            albums =albumSimplifiedPaging.getItems();
            System.out.println("Total: " + albumSimplifiedPaging.getItems());
        } catch (CompletionException e) {
            System.out.println("Error: " + e.getCause().getMessage());
        } catch (CancellationException e) {
            System.out.println("Async operation cancelled.");
        }
        return  albums;
    }

    public static TrackSimplified[] getTracks(String album) {
        SpotifyApi spotifyApi = new SpotifyApi.Builder()
                .setAccessToken(getAccessToken())
                .build();
        GetAlbumsTracksRequest getAlbumsTracksRequest = spotifyApi.getAlbumsTracks(album)
//          .limit(10)
//          .offset(0)
//          .market(CountryCode.SE)
                .build();
        TrackSimplified[] tracks = null;
        try {
            final CompletableFuture<Paging<TrackSimplified>> pagingFuture = getAlbumsTracksRequest.executeAsync();

            // Thread free to do other tasks...

            // Example Only. Never block in production code.
            final Paging<TrackSimplified> trackSimplifiedPaging = pagingFuture.join();
            tracks =trackSimplifiedPaging.getItems();
            System.out.println("Total: " + trackSimplifiedPaging.getTotal());
        } catch (CompletionException e) {
            System.out.println("Error: " + e.getCause().getMessage());
        } catch (CancellationException e) {
            System.out.println("Async operation cancelled.");
        }
        return  tracks;
    }

    public static String getData(String id) {
        SpotifyApi spotifyApi = new SpotifyApi.Builder()
                .setAccessToken(getAccessToken())
                .build();
        GetTrackRequest getTrackRequest = spotifyApi.getTrack(id)
//          .market(CountryCode.SE)
                .build();
        String data = null;
        try {
            final CompletableFuture<Track> trackFuture = getTrackRequest.executeAsync();

            // Thread free to do other tasks...

            // Example Only. Never block in production code.
            final Track track = trackFuture.join();
            data =track.getUri();
            System.out.println("Name: " + track.getName());
        } catch (CompletionException e) {
            System.out.println("Error: " + e.getCause().getMessage());
        } catch (CancellationException e) {
            System.out.println("Async operation cancelled.");
        }
        return  data;
    }

}
