/**
 * Created by yellow-umbrella on 17/07/17.
 */
public class Frame {

    private static int idCount = 0;

    protected int id;
    protected boolean valid;
//    protected byte reference;

    public Frame() {
        this.id = idCount++;
        this.valid = false;
//        this.reference =
    }

}
