package main;

import java.util.Scanner;

public class Queue {
    private static class Node{
        private int data;
        private Node next;
        public Node(int data, Node next){
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }

        public void setData(int data) {
            this.data = data;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private int size = 0;
    private Node front = null;
    private Node rear = null;

    public static void main(String[] args) {
        Queue queue =  new Queue();
        System.out.println(queue);
        //Scanner sc = new Scanner(System.in);
        //int a = sc.nextInt();


       for (int i = 0; i < 5 ; i++) {
         queue.enqueue(i+1);
        }
        System.out.println(queue);
        queue.enqueue(6);
        System.out.println(queue);

        boolean n = queue.search(8);
        System.out.println(n);

        queue.dequeue();
        System.out.println(queue);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[");


        Node temp = this.front;


        while (temp != null) {

            result.append(temp.getData());


            if (temp.getNext() != null) {

                result.append(" --> ");
            }



            temp = temp.getNext();
        }


        result.append("]");
        return result.toString();
    }

    public void enqueue(int data){
        Node node = new Node(data, null);
        if(this.front == null && this.rear == null){
            this.front=this.rear=node;
        }
        this.rear.setNext(node);
        this.rear = node;
        this.size++;
    }

    public int dequeue(){
   int response = -1;

   if(this.front != null){
       response = this.front.getData();
       this.front = this.front.getNext();
       this.size--;
   }
   return response;
    }

    public boolean search(int data){
        boolean response = false;
        Node temp = this.front;
        while(temp!=null){
            if(temp.data == data){
                response = true;
                break;
            }
            temp = temp.next;
        }
        return response;
    }

}
