class Showtime {
    private Movie movie;
    private Cinema cinema;
    private String movieStart;
    private int totalSeats;
    private Seat[] bookedSeats;
    private int bookedCount;

    public Showtime(Movie movie, Cinema cinema, String movieStart, int totalSeats) {
        this.movie = movie;
        this.cinema = cinema;
        this.movieStart = movieStart;
        this.totalSeats = totalSeats;
        this.bookedSeats = new Seat[totalSeats];
        this.bookedCount = 0;
    }

    public boolean bookSeat(Seat seat) {
        if (bookedCount < totalSeats) {
            bookedSeats[bookedCount] = seat;
            bookedCount++;
            return true;
        }
        return false;
    }

    public int availableSeats() {
        return totalSeats - bookedCount;
    }

    public Movie getMovie() {
        return movie;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public String getMovieStart() {
        return movieStart;
    }

    public String toString() {
        return "->" + movieStart + " - " + cinema.getName() + " (" +
                availableSeats() + " seats lef)";
    }
}
