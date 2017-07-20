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


        checkPointer();

        if(mainMemory[fifoPointer] != null) {
            System.out.println("Frame is used");
            // Swap
            mainMemory[fifoPointer].valid = false;
            mainMemory[fifoPointer] = frame;
            fifoPointer++;
        } else {
            // Just put
            mainMemory[fifoPointer] = frame;
            fifoPointer++;
        }
        System.out.println("Putting in memory");
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
                System.out.printf("Proc: %d frame: %d valid: %b | ", x.process.id, x.id, x.valid);
        System.out.println();
    }

}
