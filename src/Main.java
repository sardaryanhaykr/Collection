public class Main {

    public static void main(String[] args) {
//        MyArrayList<String> myArrayList=new MyArrayList<>();
//        myArrayList.add("tt");
//        myArrayList.add("yy");
//        myArrayList.add("uu");
//        myArrayList.add("ii");
//
//        for (String s:myArrayList) {
//            System.out.println(s);
//        }
//        myArrayList.delete(2);
//        for (String s:myArrayList) {
//            System.out.println(s);
//        }

        MyLinkedList<String> linkedList=new MyLinkedList<>();
        linkedList.add("11");
        linkedList.add("22");
        linkedList.add("33");
        linkedList.add("44");
        for (String s:linkedList) {
            System.out.println(s);
        }
        System.out.println(linkedList.size());
    }
}
