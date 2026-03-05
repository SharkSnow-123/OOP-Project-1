class Cinema {
    private String cinemaName;
    private String roomName; 
    private int capacity;
    private Showtime[] showtimes;
    private int showtimeCount;
    private static final int MAX_SHOWTIMES = 6;
    
    public Cinema(String cinemaName, String roomName, int capacity) {
        this.cinemaName = cinemaName;
        this.roomName = roomName;
        this.capacity = capacity;
        this.showtimes = new Showtime[MAX_SHOWTIMES];
        this.showtimeCount = 0;
    }
    
    public void addShowtime(Showtime showtime) {
        if (showtimeCount < MAX_SHOWTIMES) {
            showtimes[showtimeCount] = showtime;
            showtimeCount++;
        }
    }
    
    public Showtime[] getShowtimes() {
        Showtime[] copy = new Showtime[showtimeCount];
        for (int i = 0; i < showtimeCount; i++) {
            copy[i] = showtimes[i];
        }
        return copy;
    }
    
    public String getName() { 
        return cinemaName + " - " + roomName; 
    
    } 
    public int getCapacity() { 
        return capacity;  
    }
}
