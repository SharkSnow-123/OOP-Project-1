public class Seat{
   
    private String seatNumber;
    private boolean isBooked;

    public Seat(String seatNumber){
        setseatNumber(seatNumber);
        setisBooked(false);
    }

    public void setseatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getSeatNumber(){
        return seatNumber;
    }

    public boolean isBooked(){
        return isBooked;
    }

    public void setisBooked(boolean isBooked){
        this.isBooked = isBooked;
    }

    public void bookSeat(){
        this.isBooked = true;
    }
}