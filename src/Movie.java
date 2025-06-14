import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents a movie entity with various metadata fields such as title,
 * release year, genres, crew, and vote count.
 * Provides accessor and mutator methods, as well as utility for comparison by popularity.
 *
 * @author Jianing Yin
 * @author Vera Zhang
 */
public class Movie {
    private String id;
    private String title;
    private int releaseYear;
    private int voteCount;
    private Set<String> genres;
    private Set<String> actors;
    private Set<String> directors;
    private Set<String> composers;
    private Set<String> writers;
    private Set<String> cinematographers;

    /**
     * Default constructor.
     */
    public Movie() {
    }

    /**
     * Constructs a Movie with a title and release year.
     *
     * @param title       Title of the movie
     * @param releaseYear Year the movie was released
     */
    public Movie(String title, int releaseYear) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.voteCount = 0;
        genres = new HashSet<>();
        actors = new HashSet<>();
        directors = new HashSet<>();
        composers = new HashSet<>();
        writers = new HashSet<>();
        cinematographers = new HashSet<>();
    }

    /**
     * Comparator to sort movies in descending order of vote count.
     *
     * @return A comparator for Movie objects
     */
    public static Comparator<Movie> byReverseWeightOrder() {
        return Comparator.comparingLong(Movie::getVoteCount).reversed();
    }

    // Getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public Set<String> getGenres() {
        return genres;
    }

    public Set<String> getActors() {
        return actors;
    }

    public Set<String> getDirectors() {
        return directors;
    }

    public Set<String> getComposers() {
        return composers;
    }

    public Set<String> getWriters() {
        return writers;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public Set<String> getCinematographers() {
        return cinematographers;
    }

    // Adders

    public void addGenre(String genre) {
        genres.add(genre);
    }

    public void addActor(String actor) {
        actors.add(actor);
    }

    public void addDirector(String director) {
        directors.add(director);
    }

    public void addComposer(String composer) {
        composers.add(composer);
    }

    public void addWriter(String writer) {
        writers.add(writer);
    }

    public void addCinematographer(String cinematographer) {
        cinematographers.add(cinematographer);
    }

    // Setters

    public void setTitle(String title) {
        this.title = title;
    }

    public void setActors(Collection<String> actors) {
        this.actors = new HashSet<>(actors);
    }

    public void setCinematographers(Set<String> cinematographers) {
        this.cinematographers = cinematographers;
    }

    public void setComposers(Set<String> composers) {
        this.composers = composers;
    }

    public void setDirectors(Set<String> directors) {
        this.directors = directors;
    }

    public void setGenres(java.util.Collection<String> genres) {
        this.genres = new HashSet<>(genres);
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setWriters(Set<String> writers) {
        this.writers = writers;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }
}
