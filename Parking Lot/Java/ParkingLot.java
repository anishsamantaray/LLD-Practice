import java.util.*;

class ParkingLot {

    List<ParkingFloor> floors = new ArrayList<>();
    Map<Integer, Ticket> tickets = new HashMap<>();
    int ticketCounter = 1;

    void addFloor(ParkingFloor floor) {
        floors.add(floor);
    }

    Ticket parkVehicle(Vehicle vehicle) {

        for (ParkingFloor floor : floors) {

            ParkingSpot spot = floor.findSpot(vehicle);

            if (spot != null) {

                spot.park(vehicle);

                Ticket ticket = new Ticket(ticketCounter++, vehicle, spot, floor);

                tickets.put(ticket.ticketId, ticket);

                System.out.println(
                        "Vehicle parked at Floor " + floor.floorNumber +
                        " Spot " + spot.id
                );

                return ticket;
            }
        }

        System.out.println("Parking Full");
        return null;
    }

    void exitVehicle(int ticketId) {

        Ticket ticket = tickets.get(ticketId);

        if (ticket == null) {
            System.out.println("Invalid ticket");
            return;
        }

        ticket.spot.removeVehicle();

        tickets.remove(ticketId);

        System.out.println(
                "Vehicle exited from Floor " +
                ticket.floor.floorNumber +
                " Spot " + ticket.spot.id
        );
    }
}