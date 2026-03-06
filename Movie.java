class Movie {
    private String title;
    private String genre;
    private int duration;  
    private double ticketPrice;
    
    public Movie(String title, String genre, int duration, double ticketPrice) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.ticketPrice = ticketPrice;
    }
    
    public String getTitle() { return title; }
    public String getGenre() { return genre; }
    public int getDuration() { return duration; }  
    public double getTicketPrice() { return ticketPrice; }
    
    public String toString() {
        int hours = duration / 60; 
        int minutes = duration % 60; 
        return title + " (" + genre + ") - Duration: " + hours + "h " + minutes + "m";
    }
}