import java.util.Random;

/**
 * 
 * 
 * @author Renan Bennati Dias
 * @author Jonathan Heidy Kinjo
 *
 * Para compilar o trabalho rode "javac Main.java" no root do trabalho
 * Para rodar o trabalho rode "java Main 1000 200 15 3 0 12 1 6 2 7"
 */
public class Main {

    public static void main(String args[]) {

		/**
		 * Caso nao haja argumentos suficiente uma mensagem de erro e mostrada
		 * para o usuario.
		 */
		if (args.length < 4) {
			System.out.println("Quantidade de argumentos faltando.");
			System.exit(1);
		}

		/**
		 * Pega o valor do seed.
		 */
		int seed = Integer.parseInt(args[0]);

		/**
		 * Pega a quantidade de referencias
		 */
		int nref = Integer.parseInt(args[1]);

		/**
		 * Pega quantidade de frames
		 */
		int nframes = Integer.parseInt(args[2]);

		/**
		 * Pega quantidade de processos
		 */
		int nproc = Integer.parseInt(args[3]);


		MyProcess process[] = new MyProcess[nproc];
		
		 MainMemory memory = new MainMemory(nframes);

	     MyProcess.nProc = nproc;
	     MyProcess.memory = memory;


		int f = 0;
		int argsIndex = 4;
		do {
			int proId = Integer.parseInt(args[argsIndex++]);
			int proSize = Integer.parseInt(args[argsIndex++]);

			process[f++] = new MyProcess(proId, proSize);
		} while (argsIndex < args.length);


		Random rng = new Random(seed);

        System.out.println("Inicio da simulacao com a substituicao FIFO");

        for (int i = 0; i < nref; i++) {
        	  MyProcess aux = process[rng.nextInt(nproc)];
        	  aux.useFrame(rng.nextInt(nproc));
        	
        }
        
        memory.printMainMemory();
        System.out.printf("O numero de falhas de pagina foi %d\n", memory.fails);

        System.out.println("Fim da simulacao com a substituicao FIFO");

        System.out.println("\n\n\n");

        System.out.println("Inicio da simulacao com a substituicao Segunda chance");

        SecondMaimMemory second = new SecondMaimMemory(nframes);

        MyProcess.memory = second;
        
    	f = 0;
		argsIndex = 4;
		do {
			int proId = Integer.parseInt(args[argsIndex++]);
			int proSize = Integer.parseInt(args[argsIndex++]);

			process[f++] = new MyProcess(proId, proSize);
		} while (argsIndex < args.length);

        for (int i = 0; i < nref; i++) {
      	  MyProcess aux = process[rng.nextInt(nproc)];
      	  aux.useFrame(rng.nextInt(nproc));
      	
      }
        second.printMainMemory();
        System.out.printf("O numero de falhas de pagina foi %d\n", second.fails);

        System.out.println("Fim da simulacao com a substituicao Segunda chance");

    }

}
