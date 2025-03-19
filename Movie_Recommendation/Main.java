import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MovieManagementSystem movieManagement = new MovieManagementSystem();

        while (true) {
            System.out.println("\nMovie Management System:");
            System.out.println("1. Add Movie");
            System.out.println("2. Delete Movie");
            System.out.println("3. Search Movies by Genre");
            System.out.println("4. Sort Movies by Title");
            System.out.println("5. View All Movies");
            System.out.println("6. Recommend Movies by Rating and Genre");
            System.out.println("7. View Preloaded Movies");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter movie title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter movie genre: ");
                    String genre = scanner.nextLine();
                    System.out.print("Enter release year: ");
                    int releaseYear = scanner.nextInt();
                    System.out.print("Enter movie rating (0.0 to 10.0): ");
                    double rating = scanner.nextDouble();
                    System.out.print("Enter runtime in minutes: ");
                    int runtime = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    movieManagement.addMovie(title, genre, releaseYear, rating, runtime);
                    break;

                case 2:
                    System.out.print("Enter movie title to delete: ");
                    String titleToDelete = scanner.nextLine();
                    movieManagement.deleteMovie(titleToDelete);
                    break;

                case 3:
                    System.out.print("Enter genre to search for: ");
                    String genreToSearch = scanner.nextLine();
                    movieManagement.searchMoviesByGenre(genreToSearch);
                    break;

                case 4:
                    movieManagement.sortMoviesByTitle();
                    break;

                case 5:
                    movieManagement.viewAllMovies();
                    break;

                case 6:
                System.out.print("Enter genre: ");
                String genreForRecommendation = scanner.nextLine();
                System.out.print("Enter minimum rating (0.0 to 10.0): ");
                double minRating = scanner.nextDouble();
                System.out.print("Enter minimum release year: ");
                int minYear = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                movieManagement.recommendMovies(genreForRecommendation, minRating, minYear);
                break;
                
                case 7:
                    movieManagement.viewPreloadedMovies();
                    break;

                case 8:
                    System.out.println("Exiting system.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}

