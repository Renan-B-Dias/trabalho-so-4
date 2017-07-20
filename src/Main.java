/**
 * Created by yellow-umbrella on 17/07/17.
 */
public class Main {

    public static void main(String args[]) {

        System.out.println("Inıcio da simulacao com a substituicao FIFO");

        int nProc = 3;
        int nFrames = 6;

        MainMemory memory = new MainMemory(nFrames);

        MyProcess.nProc = nProc;
        MyProcess.memory = memory;

        MyProcess p1 = new MyProcess(0, 4);
        MyProcess p2 = new MyProcess(1, 4);
        MyProcess p3 = new MyProcess(2, 4);

        p1.useFrame(0);
        p1.useFrame(1);
        p1.useFrame(2);
        p1.useFrame(3);

        // Reduntant
        p1.useFrame(0);
        p1.useFrame(1);
        p1.useFrame(2);
        p1.useFrame(3);

        p2.useFrame(0);
        p2.useFrame(1);
        p2.useFrame(2);
//        p2.useFrame(3);

        memory.printMainMemory();
        System.out.printf("O numero de falhas de pagina foi %d\n", memory.fails);

        System.out.println("P1");
        p1.printPageTable();

        System.out.println("P2");
        p2.printPageTable();

        System.out.println("Fim da simulacao com a substituicao");
    }

}
