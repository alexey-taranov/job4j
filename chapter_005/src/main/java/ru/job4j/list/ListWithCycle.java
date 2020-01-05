package ru.job4j.list;

public class ListWithCycle {

    class Node<T> {
        T value;
        Node<T> next;
        public Node(T value) {
            this.value = value;
        }
    }

    Node first = new Node(1);
    Node two = new Node(2);
    Node third = new Node(3);
    Node four = new Node(4);



    boolean hasCycle(Node first) {

        while (first != first.next) {
            first = first.next;





        }


        return false;
    }
}
