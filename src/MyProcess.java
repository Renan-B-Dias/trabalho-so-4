/**
 * Created by yellow-umbrella on 17/07/17.
 */
public class MyProcess {

    public static int nProc;    // Quantity of process of simulation
    public static Memory memory;

    protected int id;
    protected PageTable pageTable;

    public MyProcess(int id, int pagesProc) throws RuntimeException {
        if(invalid(id))
            throw new RuntimeException("Id invalido");
        this.id = id;
        pageTable = new PageTable(pagesProc, this);
    }

    public void useFrame(int id) {
        if(invalid(id))
            System.out.println("Wrong id");
        else {

            int pageIndex = pageTable.inMemory(id);

            if (pageIndex >= 0) {
                Frame frame = pageTable.getByIndex(pageIndex);
                int memoryIndex = memory.getIndex(frame);

                if(memoryIndex < 0) {
                    System.out.println("Fatal error!!!");
                    System.exit(1);
                }
                System.out.printf("Referencia %d.%d: pagina no quadro %d e referida\n", this.id, frame.id, memoryIndex);
                frame.reference = 1;
            }
            else {
                // bit is false
                memory.put(pageTable.getFrame(id));
                pageTable.setBit(id, true);
            }
        }
    }

    private boolean invalid(int id) {
        if(id < 0 || id > nProc)
            return true;
        return false;
    }

    public void printPageTable() {
        pageTable.printFrameTable();
    }

}
