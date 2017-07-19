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

        try {
            p0.useFrame(1);
            p0.useFrame(1);
        } catch(RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }

}
