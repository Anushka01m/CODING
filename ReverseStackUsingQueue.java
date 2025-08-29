import java.util.Stack;

import java.util.Queue;

import java.util.LinkedList;



public class ReverseStackUsingQueue {

    public static void reverseStack(Stack<Integer> stack) {

        Queue<Integer> queue = new LinkedList<>();

        

        // Step 1: Pop all elements from the stack and enqueue them into the queue

        while (!stack.isEmpty()) {

            queue.add(stack.pop());

        }

        

        // Step 2: Dequeue all elements from the queue and push them back into the stack

        while (!queue.isEmpty()) {

            stack.push(queue.poll());

        }

    }



    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        stack.push(10);

        stack.push(20);

        stack.push(30);

        stack.push(40);



        System.out.println("Original Stack: " + stack);

        reverseStack(stack);

        System.out.println("Reversed Stack: " + stack);

    }

}
