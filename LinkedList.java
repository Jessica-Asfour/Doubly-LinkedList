public class LinkedList {

    Node head = null;
    Node tail = null;

    LinkedList(){


    }

    public class Node {

        int data;
        Node next = null;
        Node previous = null;

        Node(int data) {
            this.data = data;
        }
    }

    @Override
    public String toString() {
        String currentData = "";
        Node currentNode = this.head;
        String data = ""; //Final string that is returned
        while (currentNode != null){
            currentData = Integer.toString(currentNode.data);
            data = data.concat(currentData);
            currentNode = currentNode.next;

            if(currentNode != null){
                data = data.concat(", ");
            }
        }
        return "{"  + data + "}";
    }

    public void addLast(int newData){
        Node newNode = new Node(newData); //New node created and takes in new data

        //When the linked list is empty
        if(this.head == null){
            this.head = newNode;
            this.tail = newNode;
        }
        else{
            this.tail.next = newNode; //Gives the old tail a next node which is the new node
            newNode.previous = this.tail; //Before the new node is set to being the tail node the new nodes previous is set to the current tail node
            this.tail = newNode; //The tail now takes the values of the new node
        }
    }

    public void removeLast(){
        if(this.head == null && this.tail == null){
            return;
        }
        if(this.head == this.tail){
            this.head = null;
            this.tail = null;
            return;
        }
        this.tail = this.tail.previous;
        this.tail.next = null;
    }

    public void addFirst(int newData){
        Node newNode = new Node(newData);

        //When the linked list is empty
        if(this.head == null){
            this.head = newNode;
            this.tail = newNode;
        }
        else {
            this.head.previous = newNode; //The current head nodes previous is now the new node
            newNode.next = this.head; //Before making the new node the head node we define the new nodes next node
            this.head = newNode; //The new node added at the beginning becomes the new head
        }

    }

    public void removeFirst(){
        if(this.head == null && this.tail == null){
            return;
        }
        if(this.head == this.tail){
            this.head = null;
            this.tail = null;
            return;
        }
        this.head = this.head.next;
        this.head.previous = null;
    }

    //This is a slow method. A better way would be to have an instance variable that is incremented and decremented accordingly.
    public int size(){
        Node trackerNode = this.head;
        int counter = 0;

        while(trackerNode != null){
            counter++;
            trackerNode = trackerNode.next;
        }
        return counter;
    }

    public void checkIndex(int index) throws ArrayIndexOutOfBoundsException{
        if(index >= this.size() || index < 0){
            throw new ArrayIndexOutOfBoundsException("Index doesn't exist");
        }
    }

    public int getAt(int index){

        checkIndex(index);

        Node currentNode = this.head;
        int counter = 0;
        while(counter != index){
            currentNode = currentNode.next;
            counter++;
        }

        return currentNode.data;
    }

    public void updateAt(int index, int updatedData){

        checkIndex(index);

        Node currentNode = this.head;
        int counter = 0;
        while(counter != index){
            currentNode = currentNode.next;
            counter++;
        }
        currentNode.data = updatedData;
    }


    public void insertAt(int index, int newData) throws IndexOutOfBoundsException{
        if(index > this.size()){
            throw new IndexOutOfBoundsException("Index doesn't exist");
        }

        if(index == 0){
            addFirst(newData);
            return;
        }

        if(index == size()){
            addLast(newData);
            return;
        }

        Node newNode = new Node(newData);
        Node currentNode = this.head;
        int counter = 0;

        while(counter != index){
            currentNode = currentNode.next;
            counter ++;
        }

        newNode.previous = currentNode.previous;
        currentNode.previous.next = newNode;
        currentNode.previous = newNode;
        newNode.next = currentNode;
    }

    public void removeAt(int index){

        checkIndex(index);

        if(index == 0){
            removeFirst();
            return;
        }
        if(index == size()-1){
            removeLast();
            return;
        }

        Node currentNode = this.head;
        int counter = 0;

        while(counter != index){
            currentNode = currentNode.next;
            counter ++;
        }

        currentNode.previous.next = currentNode.next;
        currentNode.next.previous = currentNode.previous;

    }
}