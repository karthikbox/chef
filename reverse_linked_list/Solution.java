import java.lang.*;
import java.io.*;
import java.math.*;

/*


Construct a Maximum Sum Linked List out of two Sorted Linked Lists having some Common nodes

Given two sorted linked lists, construct a linked list that contains maximum sum path from start to end. The result list may contain nodes from both input lists. When constructing the result list, we may switch to the other input list only at the point of intersection (which mean the two node with the same value in the lists). You are allowed to use O(1) extra space.

*/

class Solution{

    public static void main(String[] s){
	Solution n=new Solution();
	n.test();
	
    }

    void test(){
	Node head1=null,head2=null;
	head1=new Node(120);
	head1=LinkedList.push(head1,new Node(110));
	head1=LinkedList.push(head1,new Node(90));
	head1=LinkedList.push(head1,new Node(30));
	head1=LinkedList.push(head1,new Node(3));
	head1=LinkedList.push(head1,new Node(1));
	
	head2=new Node(130);
	head1=LinkedList.push(head1,new Node(120));
	head1=LinkedList.push(head1,new Node(100));
	head1=LinkedList.push(head1,new Node(90));
	head1=LinkedList.push(head1,new Node(32));
	head1=LinkedList.push(head1,new Node(12));
	head1=LinkedList.push(head1,new Node(3));
	head1=LinkedList.push(head1,new Node(0));

	solve(head1,head2);

    }
    
    static void solve(Node h1,Node h2){
	Node t1=h1,t2=h2;
	Node res;
	int sum1=0,sum2=0;
	while(h1!=null || h2!=null){
	    sum1=sum2=0;
	    while(h1!=null && h2!=null && h1.getData()!= h2.getData() ){
		if(h1.getData()<h2.getData()){
		    sum1+=h1.getData();
		    h1=h1.getNext();
		}
		else{
		    sum2+=h2.getData();
		    h2=h2.getNext();
		}
	    }
	    //h1 or h2 vould be null or h1.d==h2.d
	    if(h1.getData()!=h2.getData()){	    
		while(h1!=null){
		    sum1+=h1.getData();
		    h1=h1.getNext();
		}
	    }
	    if(res==null){
		if(sum1>sum2){
		    res=t1;
		}
		else{
		    res=t2;
		}
	    }
	    else{
		if(sum1>sum2){
		    t2.setNext(t1.getNext());
		    
		    }
		else
		    t1.setNext(t2.getNext());
	    }
	    t1=h1;t2=h2;
	    



	}
    }


    static class LinkedList{
	static Node push(Node h,Node t){
	    t.setNext(h);
	    h.setPrev(t);
	    return t;
	}

    }
    

    class Node{
	int data;
	Node next,prev;

	Node(int data){
	    this.data=data;
	}
	Node(int d,Node n,Node r){
	    data=d;
	    next=n;
	    prev=r;
	}
	void setData(int d){
	    data=d;
	}
	void setNext(Node t){
	    next=t;
	}
	void setPrev(Node t){
	    prev=t;
	}
	int getData(){
	    return data;
	}
	Node getNext(){
	    return next;
	}
	Node getPrev(){
	    return prev;
	}
	
    }

}
