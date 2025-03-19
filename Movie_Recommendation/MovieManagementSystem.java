import java.util.*;

public class MovieManagementSystem {
    private List<Movie> movies;
    private Map<String, Movie> movieDatabase; // HashMap to store preloaded movies

    public MovieManagementSystem() {
        this.movies = new ArrayList<>();
        this.movieDatabase = new HashMap<>();
        preloadMovies(); // Populate initial movie database
    }

    // Preload movies into the HashMap
    private void preloadMovies() {
        // Hollywood Movies
        addMovieToDatabase(new Movie("Inception", "Sci-Fi", 2010, 8.8, 148));
        addMovieToDatabase(new Movie("The Dark Knight", "Action", 2008, 9.0, 152));
        addMovieToDatabase(new Movie("Interstellar", "Sci-Fi", 2014, 8.6, 169));
        addMovieToDatabase(new Movie("Parasite", "Thriller", 2019, 8.6, 132));
        addMovieToDatabase(new Movie("Joker", "Drama", 2019, 8.4, 122));
        addMovieToDatabase(new Movie("Forrest Gump", "Drama", 1994, 8.8, 142));
        addMovieToDatabase(new Movie("The Shawshank Redemption", "Drama", 1994, 9.3, 142));
        addMovieToDatabase(new Movie("Pulp Fiction", "Crime", 1994, 8.9, 154));
        addMovieToDatabase(new Movie("The Godfather", "Crime", 1972, 9.2, 175));
        addMovieToDatabase(new Movie("The Matrix", "Sci-Fi", 1999, 8.7, 136));
        addMovieToDatabase(new Movie("Fight Club", "Drama", 1999, 8.8, 139));
        addMovieToDatabase(new Movie("The Avengers", "Action", 2012, 8.0, 143));
        addMovieToDatabase(new Movie("Avengers: Endgame", "Action", 2019, 8.4, 181));
        addMovieToDatabase(new Movie("Gladiator", "Action", 2000, 8.5, 155));
        addMovieToDatabase(new Movie("The Lion King", "Animation", 1994, 8.5, 88));
        addMovieToDatabase(new Movie("Titanic", "Romance", 1997, 7.9, 195));
        addMovieToDatabase(new Movie("Schindler's List", "Drama", 1993, 9.0, 195));
        addMovieToDatabase(new Movie("Saving Private Ryan", "Action", 1998, 8.6, 169));
        addMovieToDatabase(new Movie("The Silence of the Lambs", "Thriller", 1991, 8.6, 118));
        addMovieToDatabase(new Movie("The Prestige", "Mystery", 2006, 8.5, 130));
        addMovieToDatabase(new Movie("Django Unchained", "Western", 2012, 8.4, 165));
        addMovieToDatabase(new Movie("The Wolf of Wall Street", "Biography", 2013, 8.2, 180));
        addMovieToDatabase(new Movie("Mad Max: Fury Road", "Action", 2015, 8.1, 120));
        addMovieToDatabase(new Movie("Black Panther", "Action", 2018, 7.3, 134));
        addMovieToDatabase(new Movie("Shutter Island", "Thriller", 2010, 8.2, 138));
    
        // Bollywood Movies
        addMovieToDatabase(new Movie("3 Idiots", "Comedy", 2009, 8.4, 170));
        addMovieToDatabase(new Movie("Dangal", "Biography", 2016, 8.4, 161));
        addMovieToDatabase(new Movie("Lagaan", "Drama", 2001, 8.1, 224));
        addMovieToDatabase(new Movie("Gully Boy", "Drama", 2019, 8.0, 154));
        addMovieToDatabase(new Movie("Queen", "Drama", 2013, 8.2, 146));
        addMovieToDatabase(new Movie("Zindagi Na Milegi Dobara", "Drama", 2011, 8.2, 155));
        addMovieToDatabase(new Movie("Andhadhun", "Thriller", 2018, 8.3, 139));
        addMovieToDatabase(new Movie("Tumbbad", "Horror", 2018, 8.3, 104));
        addMovieToDatabase(new Movie("Drishyam", "Thriller", 2015, 8.2, 163));
        addMovieToDatabase(new Movie("Black", "Drama", 2005, 8.2, 122));
        addMovieToDatabase(new Movie("PK", "Comedy", 2014, 8.1, 152));
        addMovieToDatabase(new Movie("Swades", "Drama", 2004, 8.2, 189));
        addMovieToDatabase(new Movie("Barfi!", "Drama", 2012, 8.1, 151));
        addMovieToDatabase(new Movie("Taare Zameen Par", "Drama", 2007, 8.4, 165));
        addMovieToDatabase(new Movie("Bajrangi Bhaijaan", "Drama", 2015, 8.0, 163));
        addMovieToDatabase(new Movie("Jab We Met", "Romance", 2007, 7.9, 138));
        addMovieToDatabase(new Movie("Dil Chahta Hai", "Drama", 2001, 8.1, 183));
        addMovieToDatabase(new Movie("Chhichhore", "Comedy", 2019, 8.0, 143));
        addMovieToDatabase(new Movie("Kahaani", "Thriller", 2012, 8.1, 122));
        addMovieToDatabase(new Movie("Rang De Basanti", "Drama", 2006, 8.1, 167));
        addMovieToDatabase(new Movie("Udaan", "Drama", 2010, 8.1, 134));
        addMovieToDatabase(new Movie("Haider", "Drama", 2014, 8.0, 160));
        addMovieToDatabase(new Movie("Rock On!!", "Drama", 2008, 7.7, 145));
    
        System.out.println("Preloaded movies added successfully!");
    }
    

    // Add a movie to the database
    private void addMovieToDatabase(Movie movie) {
        movieDatabase.put(movie.getTitle().toLowerCase(), movie);
        movies.add(movie);
    }

    // Add a movie (manually by user)
    public void addMovie(String title, String genre, int releaseYear, double rating, int runtime) {
        Movie movie = new Movie(title, genre, releaseYear, rating, runtime);
        addMovieToDatabase(movie);
        System.out.println("Movie added successfully!");
    }

    // Delete a movie by title
    public void deleteMovie(String title) {
        boolean removed = movies.removeIf(movie -> movie.getTitle().equalsIgnoreCase(title));
        if (removed) {
            movieDatabase.remove(title.toLowerCase());
            System.out.println("Movie deleted successfully!");
        } else {
            System.out.println("Movie not found!");
        }
    }

    // Search movies by genre
    public void searchMoviesByGenre(String genre) {
        boolean found = false;
        for (Movie movie : movies) {
            if (movie.getGenre().equalsIgnoreCase(genre)) {
                System.out.println(movie);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No movies found for the genre: " + genre);
        }
    }

    // Sort movies by title
    public void sortMoviesByTitle() {
        movies.sort(Comparator.comparing(Movie::getTitle));
        System.out.println("Movies sorted by title:");
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    // View all movies in the database
    public void viewAllMovies() {
        if (movies.isEmpty()) {
            System.out.println("No movies in the database.");
        } else {
            for (Movie movie : movies) {
                System.out.println(movie);
            }
        }
    }

    // View all preloaded movies
    public void viewPreloadedMovies() {
        System.out.println("Preloaded Movies:");
        for (Movie movie : movieDatabase.values()) {
            System.out.println(movie);
        }
    }

    // Recommend movies by rating and genre
    public void recommendMovies(String genre, double minRating, int minYear) {
        System.out.println("Recommended movies in genre '" + genre + "' with a rating of at least " + minRating + " and released after " + minYear + ":");
        boolean found = false;
    
        for (Movie movie : movies) {
            if (movie.getGenre().equalsIgnoreCase(genre) && movie.getRating() >= minRating && movie.getReleaseYear() >= minYear) {
                System.out.println(movie);
                found = true;
            }
        }
    
        if (!found) {
            System.out.println("No movies found matching the criteria.");
        }
    }
    
}

class Movie {
    private String title;
    private String genre;
    private int releaseYear;
    private double rating; // New attribute
    private int runtime;   // New attribute in minutes

    public Movie(String title, String genre, int releaseYear, double rating, int runtime) {
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.runtime = runtime;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public double getRating() {
        return rating;
    }

    public int getRuntime() {
        return runtime;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Genre: " + genre + ", Release Year: " + releaseYear +
               ", Rating: " + rating + ", Runtime: " + runtime + " mins";
    }
}
