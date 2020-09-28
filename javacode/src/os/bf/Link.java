package os.bf;

//Link.java
class  Link{
  static   int   num =3;
public   void  addJob( int  size, int  jobNo,Node a[]){
  int  i,j,count=0;
 Node b[]= new  Node[20];
  for (i=0;i<a. length ;i++){ 
    if (a[i]!= null ){
    if (size<a[i]. size &&a[i]. state == false ){ 
   b[count]=a[i];
   System. out . println ( " 可用分区大小： " +b[count]. size + "  工作号： " +b[count]. jobNo );
   count++;
   }
    else { System. out . println (a[i]. jobNo + " 号区无法分配任务，请等待！ " );}
   }
 }
  for  ( i = count; i >0; i--) { // 选择排序选出最小的空闲区  
    if (b[i]!= null )
      if  (b[0]. size  > b[i]. size  ) { 
     b[0]= b[i];
   } 
 }   
  for (i=0;i<a. length ;i++){ if (a[i]. jobNo ==b[0]. jobNo ){ break ;}}
 a[i]. size =a[i]. size -size;  // 当前内存分配大小给作业
 Node node= new  Node(a[i]. start ,size, true ,jobNo);
 a[i]. start =a[i]. start +size;
  for (j= num ;j>=i;j--){a[j+1]=a[j];}
 a[i]=node;
  num = num +1;
}
public   void  delete(Node a[], int  jobNo){ // 删除某一个进程，当该进程被删除后，进程所在内存的状态变为 false
  int  i,j;
  for (i=0;i<a. length ;i++){
    if (a[i]!= null ){
    if (a[i]. jobNo ==jobNo){
        //a[i].size=0;
       a[i]. state = false ;
       a[i]. jobNo =jobNo;
       System. out .print( " 将要释放： " );
       a[i].print();
      if (a[i-1]. state == false ){ 
         a[i-1]. size =a[i-1]. size +a[i]. size ;
        for (j=i;j< num ;j++){a[j]=a[j+1];} num = num -1;
         }
      else   if (a[i+1]. state == false ){
         a[i+1]. size =a[i+1]. size +a[i]. size ;
        for (j=i;j<= num ;j++){a[j]=a[j+1];} num = num -1;
         }
       }
     }
   }
 }
 }