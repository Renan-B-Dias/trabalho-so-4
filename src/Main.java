/**
 * Created by yellow-umbrella on 17/07/17.
 */
public class Main {

    public static void main(String args[]) {

        int nProc = 3;
        int nFrames = 15;

        MyProcess.nProc = nProc;

        MyProcess p1 = new MyProcess(0, 12);
        MyProcess p2 = new MyProcess(1, 6);
        MyProcess p3 = new MyProcess(2, 7);

        MainMemory memory = new MainMemory(nFrames);

    }

}
