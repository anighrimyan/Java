import java.util.Scanner;
class Node<T> {
    T value;
    Node<T> next;
    Node(T data) {
        value = data;
        next = null;
    }
}
class List<T> {
    Node<T> head;
    private int length = 0;
    List() {
        head = null;
    }
    //Method list_length(): This method count the length of list.
    int list_length() {
        if (empty()) {
            return 0;
        }
        Node<T> temp = head;
        while (temp.next != null) {
            temp = temp.next;
            ++length;
        }
        return length;
    }
    // Method add_Node(T data): This method add a new element at the end
    void add_Node(T data) {
        Node<T> temp = new Node<>(data);
           if (empty()) {
               head = temp;
               System.out.println("The list has created.");
               ++length;
           } else {
               Node<T> ref = head;
               while (ref.next != null) {
                   ref = ref.next;
               }
               ref.next = temp;
               ++length;
           }
    }
    // Method add_Node(int pos,T data): It will add a new element at a particular position
    void add_Node(int pos, T data) {
        if (!empty()) {
            return;
        }
        if (pos > list_length() + 1) {
            System.out.println("Error: Position unavailable in LinkedList.");
            return;
        }
        if (pos == 1) {
            Node<T> temp = head;
            head = new Node<>(data);
            head.next = temp;
            return;
        }
        Node<T> temp = head;
        Node<T> prev = head;
        while (pos - 1 > 0) {
            prev = temp;
            temp = temp.next;
            --pos;
        }
        prev.next = new Node<>(data);
        prev.next.next = temp;
    }
    //Method remove_Node(T key): It will remove a node from the LinkedList
    void remove_Node(T key) {
        if (!empty()){
            return;
        }
        if (key == head.value) {
            head = head.next;
            return;
        }
        Node<T> temp = head.next;
        Node<T> prev = head;
        while (temp.next != null) {
            if (temp.value == key) {
                prev.next = temp.next;
            }
        }
    }
    //Method clear(): This method clear the list.
    void clear() {
        head = null;
        length = 0;
    }
    //Method empty(): This method check is list empty or not.
    boolean empty() {
        if (head == null) {
            System.out.println("Linked list is empty.");
            return true;
        }
        return false;
    }
    //Method empty(): This method create Node.
    void list_create(T data) {
           add_Node(data);
    }
}
public class LinkedList {
    public static void main(String[] args) {
        List<Integer> list = new List<>();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (list.empty()) {
            list.list_create(num);
            System.out.println(list.list_length());
        } else {
            System.out.println("Enter a position where you want to add a element.");
            System.out.print("pos = ");
            int pos = sc.nextInt();
            list.add_Node(pos, num);
        }
        System.out.println("Enter a number which equal element you want to delete from list.");
        System.out.print("delete_number = ");
        int del_num = sc.nextInt();
        list.remove_Node(del_num);
        list.clear();
    }
}
