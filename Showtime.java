class Showtime {
    private Movie movie;
    private Cinema cinema;
    private String movieStart;
    private int totalSeats;
    private Seat[] bookedSeats;
    private int bookedCount;

    public Showtime() {
        this.movieStart = "TBA";
        this.totalSeats = 40; 
        this.bookedSeats = new Seat[40];
        this.bookedCount = 0;
    }

    public Showtime(Movie movie, Cinema cinema, String movieStart, int totalSeats) {
        this.movie = movie;
        this.cinema = cinema;
        this.movieStart = movieStart;
        this.totalSeats = totalSeats;
        this.bookedSeats = new Seat[totalSeats];
        this.bookedCount = 0;
    }

    public boolean bookSeat() {
        if (bookedCount < totalSeats) {
            String assignedNumber = String.valueOf(bookedCount + 1);
            Seat newSeat = new Seat(assignedNumber);
            newSeat.bookSeat();
            bookedSeats[bookedCount] = newSeat;
            bookedCount++;
            return true;
        }
        return false;
    }

    public void displaySeats() {
        System.out.println("\n--- Seat Availability ---");
        
        for (int i = 1; i <= totalSeats; i++) {
            if (i <= bookedCount) {
                System.out.print("[X]\t");
            } else {
                System.out.print("[" + i + "]\t");
            }
            
            if (i % 10 == 0) {
                System.out.println();
            }
        }
        
        int available = totalSeats - bookedCount;
        System.out.println("\nAvailable Seats: " + available + " out of " + totalSeats);
    }

        public Seat[] getBookedSeats(){

            return bookedSeats;
        }

        public int getBookedCount(){

            return bookedCount;
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

    @Override
    public String toString() {
        return "->" + movieStart + " - " + (cinema != null ? cinema.getName() : "TBA") + " (" +
                availableSeats() + " seats left)";
    }
}