package chain_of_responsibility;

public class OddSupport extends Support {
    public OddSupport(String name) {
        super(name);
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        return (trouble.getNumber() & 1) == 1;
    }
}
