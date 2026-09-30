package week3;

import java.util.Stack;

public class QueueUsingTwoStacks {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void enqueue(int val) {
        stack1.push(val);
    }

    private void transfer(){
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
    }

    public int dequeue(){

        transfer();

        return stack2.pop();
    }

    public int peek(){

        transfer();

        return stack2.peek();
    }

    public void print(){

        if (!stack2.isEmpty()) {

            for (int i = stack2.size() - 1; i >= 0; i--) {
                System.out.print(stack2.get(i) + " ");
            }

            for (int i = 0; i < stack1.size(); i++) {
                System.out.print(stack1.get(i) + " ");
            }

        } else {

            for (int i = 0; i < stack1.size(); i++) {
                System.out.print(stack1.get(i) + " ");
            }
        }

        System.out.println();
    }

    static void main(String[] args) {
        QueueUsingTwoStacks queue = new QueueUsingTwoStacks();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        queue.print();

        System.out.println("Dequeue: " + queue.dequeue());

        queue.print();

        queue.enqueue(40);
        queue.enqueue(50);

        queue.print();

        System.out.println("Front: " + queue.peek());

        queue.print();
    }
}
