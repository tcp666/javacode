package os.bf;

// Node.java
class  Node{ // 用 Node 来模拟内存的当前状态
int   start ;
int   size ;
boolean   state ;
int   jobNo ;
public  Node(){}
public  Node( int  start, int  size, boolean  state, int  jobNo){
  this . start  = start;
  this . size  = size;
  this . state  = state;
  this . jobNo  = jobNo;
 }
  public   void  print(){ // 打印 Node 类
    if  ( this != null ){
      if ( this . state == false )
 System. out . println ( " 起始位置 :" + this . start + "  大小 :" + this . size + "  状态 : 可用  " + "  工作号 :" + this . jobNo );
      if ( this . state == true )
       System. out . println ( " 起始位置 :" + this . start + "  大小 :" + this . size + "  状态 : 不可用  " + "  工作号 :" + this . jobNo );
   }
 }
};