/**
 * Created by yellow-umbrella on 17/07/17.
 */
public class MyProcess {

    public static int nProc;    // Quantity of process of simulation
    public static MainMemory memory;

    protected int id;
    protected PageTable pageTable;

    public MyProcess(int id, int pagesProc) throws RuntimeException {
        if(invalid(id))
            throw new RuntimeException("Id inválido");
        this.id = id;
        pageTable = new PageTable(pagesProc);
    }

    public void useFrame(int id) throws RuntimeException {
        if(invalid(id))
            throw new RuntimeException("Wrong id");

        int pageIndex = pageTable.inMemory(id);

        if(pageIndex > 0)
            throw new RuntimeException("Already in memory");

        if(pageIndex < 0) { // bit is false
            memory.put(pageTable.getFrame(id));
            pageTable.setBit(id, true);
        }
    }

    private boolean invalid(int id) {
        if(id < 0 || id > nProc)
            return true;
        return false;
    }
}
