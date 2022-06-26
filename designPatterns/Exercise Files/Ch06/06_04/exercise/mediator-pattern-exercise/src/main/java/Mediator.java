public class Mediator {

    private Plane plane;
    private PlanesInFlight planesInFlight;
    private PlanesOnGround planesOnGround;
    private Runway runway;

    public Mediator(int id){
        plane = new Plane(id);
        planesInFlight = new PlanesInFlight();
        planesOnGround = new PlanesOnGround();
        planesOnGround.addPlane(plane);
        runway = new Runway();

    }

    public void takeOff() {
        if(!plane.getIsInTheAir() && runway.getIsAvailable()) {
            System.out.println("Plane " + plane.getId() + " is taking off...");
            planesOnGround.removePlane(plane);
            planesInFlight.addPlane(plane);
            plane.setIsInTheAir(true);
            runway.setIsAvailable(false);
        }

    }

}
