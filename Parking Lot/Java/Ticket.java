class Ticket {

    int ticketId;
    Vehicle vehicle;
    ParkingSpot spot;
    ParkingFloor floor;

    Ticket(int ticketId, Vehicle vehicle, ParkingSpot spot, ParkingFloor floor) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.spot = spot;
        this.floor = floor;
    }
}