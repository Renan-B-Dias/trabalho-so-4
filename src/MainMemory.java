/**
 * Created by yellow-umbrella on 17/07/17.
 */
public class MainMemory {

    private int fifoPointer = 0;

    private Frame[] mainMemory;

    public MainMemory(int nFrames) {
        mainMemory = new Frame[nFrames];
    }

    public void put(Frame frame) {
        System.out.println("Putting in memory");

        if(mainMemory[fifoPointer] != null) {
            // Swap
            mainMemory[fifoPointer].valid = false;
            mainMemory[fifoPointer] = frame;
            fifoPointer++;
        } else {
            // Just put
            mainMemory[fifoPointer] = frame;
            fifoPointer++;
        }

    }

    private void checkPointer() {
        if(fifoPointer >= mainMemory.length)
            fifoPointer = 0;
    }

    public void remove(Frame frame) {

    }

    public void swap(Frame frame) {     // ??

    }

    public void printMainMemory() {
        for(Frame x: mainMemory)
            if(x != null)
                System.out.printf(" %d %b | ", x.id, x.valid);
        System.out.println();
    }

}
