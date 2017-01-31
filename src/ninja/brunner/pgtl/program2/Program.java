package ninja.brunner.pgtl.program2;

public class Program {
    static char[] instructions = {
            //Program 1: abc
            'i', 1, 'a',
            '#', '+', '#', '+', '#',

            //Program 2: Hello World
            'i', 10, 'a',                                                             //Initialize RAM with 10 bytes in size filled with character a
            'S', 'H', '#', '>',                                                       //Set value to H and inc ptr
            'S', 'e', '#', '>',                                                       //Set value to e and inc ptr
            '+', '+', '+', '+', '+', '+', '+', '+', '+', '+', '+', '#', '>',          //Inc until char l is reached and inc ptr
            '+', '+', '+', '+', '+', '+', '+', '+', '+', '+', '+', '#', '>',          //Inc until char l is reached and inc ptr
            '+', '+', '+', '+', '+', '+', '+', '+', '+', '+', '+', '+', '+', '+', '#', //Inc until char o is reached and inc ptr
            '<', '<', '<', '<', '<', '<', '<', '<', '<', '<', '>',
            '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '#', '>',
            '+', '+', '+', '+', '+', '+', '+', '+', '+', '+', '+', '+', '+', '+', '#', '>',
            '+', '+', '+', '+', '+', '+', '+', '+', '+', '+', '+', '+', '+', '+', '+', '+', '+', '#', '>',
            '+', '+', '+', '+', '+', '+', '+', '+', '+', '+', '+', '#', '>',
            '+', '+', '+', '#', '>',
            '-', '-', '-', '-', '-', '-', '-', '-', '-', '-',
            '-', '-', '-', '-', '-', '-', '-', '-', '-', '-',
            '-', '-', '-', '-', '-', '-', '-', '-', '-', '-',
            '-', '-', '-', '-', '-', '-', '-', '-', '-', '#',
            's',                                                                      //Sleep 1 second
            'n',
            'j', 8                                                                   //Jump to instr offset 8 (Program 2)
    };

    public static void main(String[] args) throws InterruptedException {
        char[] memory = null;
        int currMemIndex = 0;
        int currInstrIndex = 0;

        hui:
        while (true) {
            switch (instructions[currInstrIndex++]) {
                case 'i':
                    memory = new char[instructions[currInstrIndex]];
                    for (int i = 0; i < memory.length; i++)
                        memory[i] = instructions[currInstrIndex + 1];
                    currInstrIndex += 2;
                    break;
                case '#':
                    System.out.print(memory[currMemIndex]);
                    break;
                case 'S': //set memory cell to following byte
                    memory[currMemIndex] = instructions[currInstrIndex];
                    currInstrIndex++;
                    break;
                case 's':
                    Thread.sleep(1000);
                    break;
                case 'r':
                    currInstrIndex = 0;
                    currMemIndex = 0;
                    memory = null;
                    break;
                case 'j':
                    currInstrIndex = instructions[currInstrIndex];
                    break;
                case 'X':
                    break hui;
                case '-':
                    memory[currMemIndex]--;
                    break;
                case '+':
                    memory[currMemIndex]++;
                    break;
                case '<':
                    if (currMemIndex == 0)
                        currMemIndex = memory.length - 1;
                    else
                        currMemIndex--;
                    break;
                case '>':
                    if (currMemIndex == memory.length - 1)
                        currMemIndex = 0;
                    else
                        currMemIndex++;
                    break;
                case 'n':
                    System.out.println();
                    break;
            }
        }
    }
}