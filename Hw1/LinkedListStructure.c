

#include <stdio.h>
#include <string.h>
#include <limits.h>



////////////////////////  QUESTON 1 ///////////////////////////////////////////


//Linked list is a set of allocated nodes which contains a value and pointer. The pointer indicates next node.



////////////////////// QUESTION 2 //////////////////////////////////////////////
 struct Node{  // I defined Node structure whose properties are value and pointer of the next node.
  int value;
  struct Node *nextNode;
};


struct LinkedList {    // I defined LinkedList structure whose property is struct Node * head. I used pointer because
                       // when you make head=head.nextNode you can't use directly like that. 
   struct Node *head;
};

//////////////////////// QUESTION 3 //////////////////////////////////////////

void removeNode(struct Node *newsted,struct LinkedList *L){ // I defined removeNode method which takes  Node *newsted and linkedlist *L pointer, it removes newsted elements from list.
                                             // Newsted is the element,we want to remove.
                                            // I used pointer *newsted to make this operation lastone->nextNode=newsted.Also I used  *L pointer because,
                                            // when I make the change on linkedlist L, I want this change will be permanent
struct Node *lastone;                       // lastone pointer holds head of Linked List L
   if((L->head)==newsted){                 // If we want to remove first element of the list. We update L->head= nextNode of the first element. And iterate lastone with while loop
       (L->head)=(L->head)->nextNode;
     }
         lastone=(L->head);
 while(4>3){                              // In this while loop, 
                                         
    
                                         
     if(lastone->nextNode==newsted){     //  if current's node nextNode is newsted.
         if(newsted->nextNode==NULL){     // And if newsted-> nextNode=NULL, it means newsted is the last element.So we define last element is the previous one from newsted and break the loop.
             lastone->nextNode=NULL;
             break;
         }
         lastone->nextNode=newsted->nextNode;  // We link current node's nextNode with newsted's nextNode it means we link current node's with the the element after the newsted element.
         newsted->nextNode=NULL;      // And we break off newsted element from List by newsted->nextNode=NULL. So, newsted element is removed from list.
         
     }
     if(lastone->nextNode==NULL){    // If current node's nextNode is not newsted. We iterate lastone with lastone=lastone->nextNode until we reach end of  the list and we break the loop.
             break;
         }
     lastone=lastone->nextNode;
}
}

void addNode(struct Node *jason,struct LinkedList *L){ // I defined addNode method which takes Node *jason and *LinkedList *L,it adds jason element to end of the L list.
                                                      // Jason is the element, we want to add.
                                                      // I used pointer *jason because make this operation lastone->nextNode=jason;Also I used  *L pointer because,
                                                     // when I make change on linkedlist L, I want this change will be permanent.
   struct Node *lastone=(L->head);                   //  lastone holds first element of Linked List L..
                                                     
                                                    
 while(4>3){                                         // In this while loop, 
    if(lastone->nextNode ==NULL){                    // if lastone->nextNode=NULL, it means lastone is the first and last element of the list and break the loop.
  
      break;
    }
    else{
      lastone=lastone->nextNode;                    // we iterate lastone with using lastone=lastone->nextNode until we reach end of list.
}
} 
    lastone->nextNode=jason;                        // When we reach end of array, we take the last element and we define it's nextNode to jason element.    
}

void printList(struct LinkedList *L){  // I defined printList  method to print L list. 
                                       //I used  *L pointer because it takes, the List which is changed after making addNode,removeNode operation.
                                      
    struct Node *lastone=L->head;      //lastone holds the first element of Linked List L.
                            
     while(4>3){                      // In this while loop, we iterate with lastone=lastone->nextNode and for each lastone we check its' nextNode=Null or not
                                     
    if(lastone->nextNode ==NULL){     // If a lastone's nextNode is Null.We print this element and break the loop, because we reach end of the loop.
        printf("%d\n",lastone->value);
      break;
    }
    else{                             // If a lastone's nextNode is not Null.We print this element and iterate with lastone=lastone -> nextNode. 
     printf("%d\n",lastone->value);
 
      lastone = (lastone->nextNode); 
} 
} 

}


int main(){
struct Node n6={12,NULL};    
struct Node n5={89,NULL};    
struct Node n4={8,NULL};
struct Node n3={7,NULL};
struct Node n2={6,&n3};            // I created n2 node whose value is 6, and next node is n3.
struct Node n1= {5,&n2};           // I created n1 node whose value is 5, and next node is n2.

struct LinkedList l1={&n1};

addNode(&n4,&l1);
addNode(&n5,&l1);
addNode(&n6,&l1);
printList(&l1);


removeNode(&n1,&l1);
removeNode(&n2,&l1);
removeNode(&n3,&l1);
printf("Removing Part\n");
printList(&l1);



} 

