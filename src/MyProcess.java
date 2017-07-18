/**
 * Created by yellow-umbrella on 17/07/17.
 */
public class MyProcess {

    public static int nProc;    // Quantity of process of simulation

    protected int id;
    protected PageTable pageTable;

    public MyProcess(int id, int pagesProc) throws RuntimeException {
        if(invalid(id))
            throw new RuntimeException("Id inválido");
        this.id = id;
        pageTable = new PageTable(pagesProc);
    }

    public void putFrame(int id) {

    }

    private boolean invalid(int id) {
        if(id < 0 && id > nProc)
            return false;
        return true;
    }
}
