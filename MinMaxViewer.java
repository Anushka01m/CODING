import java.util.*;

class StackMinMax {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            stack.push(sc.nextInt());
        }

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        Stack<Integer> tmp = new Stack<>();
        while (!stack.isEmpty()) {
            int val = stack.pop();
            if (val < min) min = val;
            if (val > max) max = val;
            tmp.push(val);
        }
        // Restore stack if needed
        while (!tmp.isEmpty())
            stack.push(tmp.pop());

        System.out.println("Minimum: " + min);
        System.out.println("Maximum: " + max);
    }
}
