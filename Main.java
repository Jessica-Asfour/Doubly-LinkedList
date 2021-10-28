public class Main {

    public static void main(String[] args){

        System.out.println("LinkedList Practice");

        LinkedList linkedlist = new LinkedList();

        int[] array = {6, 9, 1, 0, 14, 21};


        for(int i = 0; i < array.length; i++){
            linkedlist.addLast(array[i]);
        }

        System.out.println(linkedlist.toString());
    }

}