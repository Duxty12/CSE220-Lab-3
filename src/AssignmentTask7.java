public class AssignmentTask7 {

    //SUBMIT ONLY THIS METHOD
    public static void rangeMove(DNode dh, int start, int end) {
        // TO DO

        DNode present = dh;
        DNode last = dh.prev;

        while (present != last) {
//            System.out.println(present.next.elem);   // To check
            int num = (int) present.next.elem;
            if (num >= start && num <= end) {

                DNode temp = present.next;

                present.next = temp.next;
                temp.next.prev = present;

                dh.prev.next = temp;
                temp.prev = dh.prev;
                temp.next = dh;
                dh.prev = temp;
            } else {                    // Not shifting present to next node right away cuz there could be two consecutive elems within the range. So after removing first num node re-enter the loop to check again.
                present = present.next;
            }

        }
    }

    //DO NOT SUBMIT THE DRIVER CODE BELOW
    //SUBMITTING IT WILL INCREASE YOUR PLAG % FOR NO REASON
    public static void main(String[] args) {
        Object[] values = {5, 3, 7, 1, 9, 6, 2, 4};
        DNode dh = LinkedListHelpers.createDummyHeadedDoublyLL(values, true);

        System.out.println("Given Linked List:");
        LinkedListHelpers.printDummyHeadedDoublyCircularLL(dh);

        System.out.println("\nExpected Output:");
        Object[] expected = {3, 1, 9, 2, 4, 5, 7, 6};
        DNode expectedHead = LinkedListHelpers.createDummyHeadedDoublyLL(expected, true);
        LinkedListHelpers.printDummyHeadedDoublyCircularLL(expectedHead);
        
        //Running the Range Move with [5,7] range 
        rangeMove(dh, 5, 7);
        //Printing after Range Move
        System.out.println("\nYour Output:");
        LinkedListHelpers.printDummyHeadedDoublyCircularLL(dh);
    }
}
