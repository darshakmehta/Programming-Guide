public static Node removeDuplicates(Node head) {
  //Write your code here
    if(head == null)
        return head;
    Node temp = head.next;
    Node prev = head;
    while(temp != null) {
        if(prev.data == temp.data) {
            prev.next = temp.next;
            temp = temp.next;
        } else {
            prev = temp;
            temp = temp.next;   
        }
    }
    return head;
}