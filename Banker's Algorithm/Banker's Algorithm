#include <stdio.h>
#include <stdbool.h>

int main()
{   
     // In the begining, we have (R0,R1,R2)={10,5,7} total resources.
    
    int pnumber=5;                      // I initialize number of proces which is equal to 5
    int rnumber=3;                      // I initialize number of resource types which is equal to 3.
    
   bool process[5]={false,false,false,false,false};   /* I created the process array which holds information about 
    allocation should be allowed or not. In the begining, all of them are false because we haven't test all of them yet */
    
    
   // I created Max matrix which shows the maximum number of resources for each process 
    int Max[5][3] = { {10, 5, 7 },  { 3, 2, 2 },  { 7, 5, 3 },  { 2, 2, 2 }, { 4, 3, 3 } }; 
                       /* P0           P1            P2             P3           P4 */
      
   // I created allocation matrix which shows the number of each type of resources that each process holds      
   int Allocation[5][3] = { { 3, 0, 2 }, { 2, 0, 0 },  { 0, 1, 0 },  { 2, 1, 1 },  { 0, 0, 2 } };  
                           /* P0           P1            P2             P3           P4 */
                           
                    
                           
   /* I created available matrix which shows the number of available resources of each type.
   In the begining, we have (R0,R1,R2)={10,5,7} but, after the allocation it means 
   available= total-allocated 
   available= {10,5,7}- { 3, 0, 2 } + { 2, 0, 0 },  { 0, 1, 0 },  { 2, 1, 1 },  { 0, 0, 2 } }
   available={3,3,2}. */
   int available[3]={3,3,2};
                  /*R0 R1 R2 */
    
    /* I created Need matrix which shows the remaining resource requirement for each process,*/
   int Need[5][3];
   
   for(int i=0;i<pnumber;i++){
       for(int j=0; j<rnumber;j++){
           Need[i][j]=Max[i][j]-Allocation[i][j];
       }
   }
   /* Need=Max-Allocation={ {7,5,5}, {1,2,2} , {7,4,3}, {0,1,1}, {4,3,1}
                              P0      P1        P2       P3        P4
     */
   bool adding;
   adding=false;
   int wehavefalse;
   wehavefalse=0;
   int firstwehavefalse=-1;
   bool dave=true;
   bool jason=false;
   int flag=0;
   
  do{
   for(int a=0;a<pnumber;a++){
       
       for(int b=0; b<rnumber;b++){
       if(process[a]==false && Need[a][b]<=available[b]){/* In here, algorithm search the process whose remaining resource requirement is not 
                                                   bigger than available resources by looking the number of each type of resources. */
                                                   
         if(wehavefalse==firstwehavefalse){  /*This condition exists because, firstly the algorithm find the number of false situation's in the end of first loop.
                                               firstwehavefalse holds this information then it is fixed. Wehavefalse holds that  the current false number.
                                               For example in the end of first loop, algorithm run p1->p2->p4. It means that we have firstwehavefalse=2, also wehavefalse=2.
                                               Algorithm starts to search again, the process which is available to run. For example, we find the P0 to process.
                                                So, we are in this condition, we have to substract 1 from the wehavefalse and we have to say the system can get 
                                                back this process's allocation resources*/
          wehavefalse--;
         }                                  
           adding=true;                         /*In here, algorithm can allow to system that get back the process's allocation resources*/
        }
           else if(process[a]==true){          /* If process is true.It means that we have already run this algortihm, so we don't have to look 
                                                the number of each type of resource. So, we must skip this algorithm and breaking loop. */
            adding=false;
            break;
        
        }
        else{                    
               if(!dave){                    /* When algorithm in this condition, if algorithm works for the firstt time, firstly it wants to find number of false
                                                situations.Then,it stops the counting false situation,because in the begining, we find all false situations.It means that number of false situation cannot increment anymore but it can only be reduced."Flag" counter measures how many times,the process' come here.If flag==pnumber+2 stop the algorithm because, algorithm can't find the
                                                enough resources the process. For example; in the first loop, algorithm process just P1.It means that wehavefalse=4
                                                so, we don't have to count wehavefalse anymore.So, algorithm has enough resources to run P4. It means that flag=3 because of po,p2,p3.Then, algorithm has enough resources to run P3. It means that flag=5 because of po,p2.
                                                Then, algorithm has enough resources to run P2. It means that flag=6 because of po.Then, algorithm has enough resources to run P0.As you can see, in the worst case, flag==pnumber+1. So, if flag>=pnumber+2, it means that
                                                the process' or process can't find the enough resources,so it creates infinite loop to get rid of infinite loop.
                                                flag counter is used.*/

                 adding=false;
                 if(flag==pnumber+2){
                 wehavefalse=0; break;    
                 }
                 else{
                     flag++;break;
                 }}
               
               else{
                adding=false;
                wehavefalse++;
                break;
            }
        }
        
                       
        }
        if(adding){                      /* If adding is true it means that we can run this algorithm with using our current resources, so 
                                        process[a]=true.Besides, we can take back allocated resources of this algorithm.
                                        available=available+allocation resources of this process. */ 
    for(int b=0; b<rnumber;b++){
           process[a]=true;
          available[b]=available[b]+Allocation[a][b];
          if(a==0 && b==0){
          printf("P%d Current:(%d,",a,available[b]);
          }
        else  if(b==0){
          printf("P%d Current:(%d,",a,available[b]);
          }
         else if(b==rnumber-1){
           printf("%d)",available[b]);
       }
       else{
           printf("%d,",available[b]);
       
       }
     }
     printf("-->");  // printf("Wehavefalse %d\n firstwehavefalse %d\n",wehavefalse,firstwehavefalse);
     }
    
     }

 
if(dave){                        //In order to count, number of false situations, in the begining i created if condition like this.
firstwehavefalse=wehavefalse;
// printf("hello");
} 
  
if(wehavefalse==firstwehavefalse && !dave){  /* If, firstwehavefalse is equal to wehavefalse and if algorithm is not in the first loop.It means                                                     that our current number of false situations is equal to initial number of false situations that
                                                  means. System can't run the process' or process, so, we do not have enough resources because,if system has enough resources, wehavefalse should be different than firstwehavefalse. */
wehavefalse=0;
}

 if(wehavefalse%firstwehavefalse!=0 && !dave){  /*If, firstwehavefalse isn't equal to wehavefalse and if algorithm is not in the first loop.
                                                System should be continue to process.And new false number situations must be equal to modulo of 
                                                 firstwehavefalse*/
    wehavefalse=wehavefalse%firstwehavefalse;
 
}
dave=false;                               // This boolean provides finding initial number of false situations and it helps to fix this number.

for(int i=0;i<pnumber;i++){               /*In here, algorithm checks the process array which holds information about situations about processs.
                                            If all of them is true finish the algorithm.*/
  if(process[i]==true){
  jason=true;
  }
  else{
    jason=false;                         /*If one of them is false, that means system is not safe.*/
    break;
  }
}
if(jason){
  wehavefalse=0;
  printf("System is safe");
}
if(wehavefalse==0){                       /*in the end of the loop of algorithm, all of the situations of process' is not true.It means our                                                   system is not safe*/
  if(!jason){
  printf("System is not safe");
  }
}
} while(wehavefalse>0);
     
   
}
