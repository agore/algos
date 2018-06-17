public class DivingBoard {
    public static void main(String[] args) {
        new DivingBoard().compute(Integer.parseInt(args[0]));
    }

    private void compute(int k) {
        int possibilities = (int) Math.pow(2, k);
        for (int i = 0; i < possibilities; i++) {
            printCombination(i, k);
        }
    }

    private void printCombination(int n, int k) {
        //int bitMask = (int) Math.pow(2, k);
        int bitMask = 1;
        bitMask <<= (k - 1);
        while (bitMask > 0) {
            if ((n & bitMask) == 0) {
                System.out.print("shorter ");
            } else {
                System.out.print("longer ");
            }
            bitMask >>>= 1;
        }

        System.out.println("\n");

    }
}
