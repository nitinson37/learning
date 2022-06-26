public class PlaceOrder implements Command {
    Jacket jacket;

    public PlaceOrder(Jacket jacket) {
        this.jacket = jacket;
    }

    @Override
    public void execute() {

        jacket.placeOrder();

    }
}
