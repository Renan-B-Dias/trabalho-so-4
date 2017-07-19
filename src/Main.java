/**
 * Created by yellow-umbrella on 17/07/17.
 */
public class Main {

    public static void main(String args[]) {

        int nProc = 3;
        int nFrames = 15;

        MainMemory memory = new MainMemory(nFrames);

        MyProcess.nProc = nProc;
        MyProcess.memory = memory;

        MyProcess p0 = new MyProcess(0, 12);
        MyProcess p1 = new MyProcess(1, 6);
        MyProcess p2 = new MyProcess(2, 7);

        p0.useFrame(0);     // Putting Frame 1 from Proc 0
        p0.useFrame(0);     // Putting Frame 1 from Proc 0
        p0.useFrame(1);     // Putting Frame 0 from Proc 0
        p0.useFrame(0);     // Putting Frame 1 from Proc 0
        p1.useFrame(1);     // Putting Frame 1 from Proc 1
        p2.useFrame(2);     // Putting Frame 2 from Proc 2

        memory.printMainMemory();

    }

}
