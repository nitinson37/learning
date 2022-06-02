public class ReturnOrder implements Command {

    public Jacket jacket;

    public ReturnOrder(Jacket jacket) {
        this.jacket = jacket;
    }

    @Override
    public void execute() {

        jacket.returnOrder();

    }
}
