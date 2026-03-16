class ParkingSpot {

    int id;
    VehicleType type;
    boolean occupied;
    Vehicle vehicle;

    ParkingSpot(int id, VehicleType type) {
        this.id = id;
        this.type = type;
        this.occupied = false;
    }

    boolean canPark(Vehicle vehicle) {
        return !occupied && vehicle.type == type;
    }

    boolean park(Vehicle vehicle) {

        if (!canPark(vehicle)) {
            return false;
        }

        this.vehicle = vehicle;
        this.occupied = true;
        return true;
    }

    void removeVehicle() {
        vehicle = null;
        occupied = false;
    }
}