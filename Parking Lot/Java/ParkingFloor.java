import java.util.*;

class ParkingFloor {

    int floorNumber;
    List<ParkingSpot> spots = new ArrayList<>();

    ParkingFloor(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    void addSpot(ParkingSpot spot) {
        spots.add(spot);
    }

    ParkingSpot findSpot(Vehicle vehicle) {

        for (ParkingSpot spot : spots) {
            if (spot.canPark(vehicle)) {
                return spot;
            }
        }

        return null;
    }
}