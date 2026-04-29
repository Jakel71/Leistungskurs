package blatt26.A02;

import blatt11.BubbleSort;

public class Main {
    public static Computer[] sortComputer(Computer[] computer){
        for (int i = 0; i < computer.length; i++) {
            for (int j = 0; j < computer.length-i-1; j++) {
                if(computer[j].compareTo(computer[j+1]) > 0){
                    Computer temp = computer[j];
                    computer[j] = computer[j+1];
                    computer[j+1] = temp;
                }
            }
        }
        return computer;
    }

    public static void main(String[] args) {
        Computer[] c = {new Computer(new Prozessor(4, 3.5, 64), 16, 1024),
                new Computer(new Prozessor(8, 3.5, 64), 48, 512),
                new Computer(new Prozessor(4, 7, 8), 16, 512),
                new Computer(new Prozessor(4, 3.5, 16), 16, 512),
                new Computer(new Prozessor(16, 10, 8), 64, 512),
                new Computer(new Prozessor(4, 3.5, 8), 16, 512),
                new Computer(new Prozessor(4, 17, 8), 32, 512),
                new Computer(new Prozessor(32, 3.5, 8), 16, 1024)};

        for (Computer computer : c) {
            System.out.println(computer);
        }
        System.out.println("-----------------------------");
        c = sortComputer(c);
        for (Computer computer : c) {
            System.out.println(computer);
        }
    }
}
