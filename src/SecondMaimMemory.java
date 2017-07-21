/**
 * Created by yellow-umbrella on 21/07/17.
 */
public class SecondMaimMemory implements Memory {

    private int fifoPointer = 0;

    public int fails = 0;

    private Frame[] mainMemory;

    public SecondMaimMemory(int nFrames) {
        mainMemory = new Frame[nFrames];
    }

    public void put(Frame frame) {
        checkPointer();

        if(mainMemory[fifoPointer] != null) {

            boolean notSwapped = true;

            do {
                checkPointer();

                if(mainMemory[fifoPointer].reference == 1) {
                    mainMemory[fifoPointer].reference = 0;
                }
                else {
                    Frame victim = mainMemory[fifoPointer];

                    victim.valid = false;
                    mainMemory[fifoPointer] = frame;

                    System.out.printf("Referencia %d.%d: no quadro %d saiu a vitima %d.%d e entrou %d.%d\n",
                            frame.process.id, frame.id, fifoPointer,
                            victim.process.id, victim.id,
                            frame.process.id, frame.id );
                    notSwapped = false;
                    frame.reference = 1;
                }

                fifoPointer++;
            }while(notSwapped);

        }
        else {
            mainMemory[fifoPointer] = frame;
            frame.reference = 1;
            System.out.printf("Referencia %d.%d: pagina inserida no quadro %d e referida\n", frame.process.id, frame.id, fifoPointer);
            fifoPointer++;
        }
        fails++;
    }

    private void checkPointer() {
        if(fifoPointer >= mainMemory.length)
            fifoPointer = 0;
    }

    public void printMainMemory() {
        for(Frame x: mainMemory)
            if(x != null)
                System.out.printf("%d.%d | ", x.process.id, x.id);
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
