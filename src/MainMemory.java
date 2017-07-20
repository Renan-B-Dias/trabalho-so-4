import java.util.Arrays;

/**
 * Created by yellow-umbrella on 17/07/17.
 */
public class MainMemory {

    private int fifoPointer = 0;

    public int fails = 0;

    private Frame[] mainMemory;

    public MainMemory(int nFrames) {
        mainMemory = new Frame[nFrames];
    }

    public void put(Frame frame) {
        checkPointer();

        if(mainMemory[fifoPointer] != null) {
            Frame victim = mainMemory[fifoPointer];
            // Swap
            mainMemory[fifoPointer].valid = false;
            mainMemory[fifoPointer] = frame;

            System.out.printf("Referencia %d.%d: no quadro %d saiu a vitima %d.%d e entrou %d.%d\n",
                    frame.process.id, frame.id, fifoPointer,
                    victim.process.id, victim.process.id,
                    frame.process.id, frame.id );
        }
        else {
            mainMemory[fifoPointer] = frame;
        }
        System.out.printf("Referencia %d.%d: pagina inserida no quadro %d e referida\n", frame.process.id, frame.id, fifoPointer);
        fifoPointer++;
        fails++;
    }

    private void checkPointer() {
        if(fifoPointer >= mainMemory.length)
            fifoPointer = 0;
    }

    public void printMainMemory() {
        for(Frame x: mainMemory)
            if(x != null)
                System.out.printf("Proc: %d frame: %d valid: %b | ", x.process.id, x.id, x.valid);
        System.out.println();
    }

    public int getIndex(Frame frame) {
        for(int i = 0; i < mainMemory.length; i++)
            if(mainMemory[i] != null)
                if(mainMemory[i].id == frame.id)
                    return i;
        return -1;
    }

}
