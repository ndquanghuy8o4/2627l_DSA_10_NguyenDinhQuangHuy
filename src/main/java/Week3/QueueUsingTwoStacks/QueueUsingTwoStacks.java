package Week3.QueueUsingTwoStacks;

import java.util.NoSuchElementException;

public class QueueUsingTwoStacks {
    private int[] stack_in = new int[50];
    private int[] stack_out = new int[50];
    private int top_in = -1;
    private int top_out = -1;

    public void enqueue(int n) {
        top_in++;
        stack_in[top_in] = n;
    }

    public int dequeue() {
        if (top_out == -1) {
            if (top_in == -1) {
                throw new NoSuchElementException("Queue rỗng!");
            } else {
                while (top_in != -1) {
                    top_out++;
                    stack_out[top_out] = stack_in[top_in];
                    top_in --;
              }
            }
        }
        int result = stack_out[top_out];
        top_out--;
        return result;
    }
}

