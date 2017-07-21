/**
 * Created by yellow-umbrella on 17/07/17.
 */
public class Frame {

    protected int id;
    protected boolean valid;
    protected MyProcess process;
    protected byte reference;

    public Frame(int id, MyProcess process) {
        this.id = id;
        this.valid = false;
        this.process = process;
        this.reference = 0;
    }

    @Override
    public String toString() {
        return "Id: " + id + " validBit: " + valid;
    }
}
