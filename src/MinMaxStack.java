/**
 * An implementation of a stack with both max and min APIs.
 * This stack supports the push, pop, max, peek, min, and max operations.
 *
 * The min operation returns the minimum element currently stored in the stack.
 * The max operation returns the maximum element currently stored in the stack.
 *
 * @author Mark Chen, chenmark33@gmail.com
 */

import java.util.*;

public class MinMaxStack {
    Stack<int[]> stack; // [value, minInStack, maxInStack]

    public MinMaxStack() {
        this.stack = new Stack<>();
    }

    public void push(int e) {
        int[] newItem;
        if (stack.isEmpty()) {
            newItem = new int[]{e, e, e};
        }
        else {
            int newMin = Math.min(e, stack.peek()[1]);
            int newMax = Math.max(e, stack.peek()[2]);
            newItem = new int[]{e, newMin, newMax};
        }
        stack.add(newItem);
    }

    public int pop() {
        if (!stack.isEmpty()) {
            return stack.pop()[0];
        }
        throw new NoSuchElementException("Empty Stack");
    }

    public int peek() {
        if (!stack.isEmpty()) {
            return stack.peek()[0];
        }
        throw new NoSuchElementException("Empty Stack");
    }

    public int getMin() {
        if (!stack.isEmpty()) {
            return stack.peek()[1];
        }
        throw new NoSuchElementException("Empty Stack");
    }

    public int getMax() {
        if (!stack.isEmpty()) {
            return stack.peek()[2];
        }
        throw new NoSuchElementException("Empty Stack");
    }
}
