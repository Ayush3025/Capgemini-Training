package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*************************************************************
 Developer Name : Ayush Tiwari
 Developer Contact : ayushtiwari3012004@gmail.com
 Created on : 10-02-2026 11:38
 Project Name : Capgemini
 *************************************************************/
class linkedlist {
    node head;
    node tail;
    int size;
    class node{
        int data;
        node next;
        node(int val){
            this.data=val;
            this.next=null;
        }
    }
    public void traverse(){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        node temp=head;
        while (temp!=null){
            System.out.print(temp.data+ " --> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }
    public void addFirst(int val){
        node nn= new node(val);
        if(head==null){
            head = nn;
            tail = nn;
            size++;
            return;
        }
        nn.next=head;
        head=nn;
        size++;
    }
    public void addLast(int val){
        node nn=new node(val);
        if(head == null){
            head=nn;
            tail=nn;
            return;
        }
        tail.next=nn;
        tail= nn;
        size++;
    }
    public void addAtIndex(int val, int pos){
        if(pos<1 || pos>size+1){
            System.out.println("Invalid Position");
            return;
        }
        if(pos==1){
            addFirst(val);
            return;
        }
        if(pos== size+1){
            addLast(val);
            return;
        }
        int k=1;
        node nn = new node(val);
        node temp=head;
        while(k<pos-1 && temp!=null){
            temp=temp.next;
            k++;
        }
        nn.next=temp.next;
        temp.next=nn;
        size++;
        return;
    }

    //**********Deletion*********
    public void delFirst(){
        if(head==null){
            System.out.println("Cannot delete List is empty");
            return;
        }
        if(head.next==null){
            head=null;
            tail=null;
            size--;
            return;
        }
        node t=head;
        head=head.next;
        t.next=null;
        size--;
        return;

    }
    public void delLast(){
        if(head==null){
            System.out.println("Cannot delete List is empty");
            return;
        }
        if(head.next==null){
            head=null;
            tail=null;
            size--;
            return;
        }
        node temp=head;
        while (temp.next.next != null) {
            temp = temp.next;

        }

        tail=temp;
        temp.next=null;
        size--;
        return;
    }
    public void delIndex(int pos){
        if(pos==1){
            delFirst();
            return;
        }
        if(pos== size){
            delLast();
            return;
        }
        int k=1;
        node temp= head;
        while(k<pos-1 && temp!=null){
            temp=temp.next;
            k++;
        }
        node t= temp.next;
        temp.next=t.next;
        t.next=null;
        size--;
        return;
    }
    public void delByValue(int val) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.data == val) {
            delFirst();
            return;
        }

        node temp = head;

        while (temp.next != null && temp.next.data != val) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Value not found");
            return;
        }

        if (temp.next == tail) {
            tail = temp;
        }

        temp.next = temp.next.next;
        size--;
    }
}

public class Linked {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        System.out.println(s);
//        linkedlist l1=new linkedlist();
//        l1.addFirst(1);
//        l1.addLast(5);
//        l1.addFirst(4);
//        l1.addAtIndex(6,2);
//        l1.addLast(9);

//        l1.traverse();
//        l1.delFirst();
//        l1.traverse();
//        l1.delLast();
//        l1.traverse();
//        l1.delByValue(1);
//        l1.traverse();
//        System.out.println("Size of Linked List : "+l1.size);

    }
}
