public class Ticket {
    private String ticketId;
    private String movieName;
    private Showtime showtime;
    private Seat seat;
    private double price;

    public Ticket(String ticketId, String movieName, Showtime showtime, Seat seat, double price) {
        this.ticketId = ticketId;
        this.movieName = movieName;
        this.showtime = showtime;
        this.seat = seat;
        this.price = price;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Showtime getShowtime() {
        return showtime;
    }

    public void setShowtime(Showtime showtime) {
        this.showtime = showtime;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void printTicket() {
        System.out.println("Ticket ID: " + ticketId);
        System.out.println("Movie: " + movieName);
        System.out.println("Time: " + showtime.getMovieStart());
        System.out.println("Seat: " + seat.getSeatNumber());
        System.out.println("Price: " + price);
    }
}