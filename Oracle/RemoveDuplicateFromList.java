/* package whatever; // don't place package name! */
import java.util.*;
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
class Remove_Duplicate_From_LL
{
    Node head;  
    Node tail;
	public void addToTheLast(Node node) 
	{
	  if (head == null) 
	  {
	   head = node;
	   tail = node;
	  } 
	  else 
	  {
	   tail.next = node;
	   tail = node;
	  }
	}
      void printList()
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
	/* Drier program to test above functions */
	public static void main(String args[])
    {
         Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 while(t>0)
         {
			int n = sc.nextInt();
			Remove_Duplicate_From_LL llist = new Remove_Duplicate_From_LL(); 
			int a1=sc.nextInt();
			Node head= new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) 
			{
				int a = sc.nextInt(); 
				llist.addToTheLast(new Node(a));
			}
			
        GfG g = new GfG();
		llist.head = g.removeDuplicates(llist.head);
		llist.printList();
		
        t--;		
        }
    }}// } Driver Code Ends


/*
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/

class GfG
{
    //Function to remove duplicates from sorted linked list.
    Node removeDuplicates(Node head){
	    // Your code here	
	    if(head == null){
	        return head;
	    }
	    while(head.next != null && head.data == head.next.data){
	        head = head.next;
	    }
	    Node current = head;
	    while(current != null && current.next != null){
	        if(current.data == current.next.data){
	            current.next = current.next.next;
	        } else {
	            current = current.next;
	        }
	    }
	    return head;
	   // Node sentinial = new Node(-1);
	   // sentinial.next = head;
	   // Node current = sentinial;
	   // while(head != null){
	   //    if(head.next != null && head.data == head.next.data){
	   //         while(head.next != null && head.data == head.next.data){
    // 	            head = head.next;
    // 	        }
    // 	        current.next = head;
	   //    } else {
	   //        current = current.next;
	   //    }
	   //    head = head.next;
	   // }
	   // return sentinial.next;
    }
}
