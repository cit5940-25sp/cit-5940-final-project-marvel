import java.util.*;

public class MovieIndex {
    private Map<String, Set<Movie>> actorMap;
    private Map<String, Set<Movie>> directorMap;
    private Map<String, Set<Movie>> composerMap;
    private Map<String, Set<Movie>> writerMap;
    private Map<String, Set<Movie>> cinematographerMap;
    //private MovieTrie movieTrie;

    public MovieIndex() {
        // Initialize the maps
        actorMap = new HashMap<>();
        directorMap = new HashMap<>();
        composerMap = new HashMap<>();
        writerMap = new HashMap<>();
        cinematographerMap = new HashMap<>();
        //movieTrie = new MovieTrie();
    }

    private void addToMap(Map<String, Set<Movie>> map, String key, Movie movie) {
        map.computeIfAbsent(key, k -> new HashSet<>()).add(movie);
    }

    public void addMovie(Movie movie) {
        // Add to actor map
        for (String actor : movie.getActors()) {
            addToMap(actorMap, actor, movie);
        }

        // Add to director map
        for (String director : movie.getDirectors()) {
            addToMap(directorMap, director, movie);
        }

        // Add to composer map
        for (String composer : movie.getComposers()) {
            addToMap(composerMap, composer, movie);
        }

        // Add to writer map
        for (String writer : movie.getWriters()) {
            addToMap(writerMap, writer, movie);
        }

        // Add to cinematographer map
        for (String cinematographer : movie.getCinematographers()) {
            addToMap(cinematographerMap, cinematographer, movie);
        }
    }

    public Set<Movie> getConnectedMovies(Movie movie) {
        Set<Movie> connectedMovies = new HashSet<>();
        for (String actor : movie.getActors()) {
            connectedMovies.addAll(actorMap.getOrDefault(actor, new HashSet<>()));
        }
        for (String director : movie.getDirectors()) {
            connectedMovies.addAll(directorMap.getOrDefault(director, new HashSet<>()));
        }
        for (String composer : movie.getComposers()) {
            connectedMovies.addAll(composerMap.getOrDefault(composer, new HashSet<>()));
        }
        for (String writer : movie.getWriters()) {
            connectedMovies.addAll(writerMap.getOrDefault(writer, new HashSet<>()));
        }
        for (String cinematographer : movie.getCinematographers()) {
            connectedMovies.addAll(
                    cinematographerMap.getOrDefault(cinematographer, new HashSet<>()));
        }
        // Remove the movie itself from the connected movies
        connectedMovies.remove(movie);

        return connectedMovies;
    }

    public List<String> getSuggestions(String partialTitle) {
        List<String> suggestions = new ArrayList<>();
        // Use the movieTrie to get suggestions based on the partial title
        // suggestions = movieTrie.getSuggestions(partialTitle);
        return suggestions;
    }

}
