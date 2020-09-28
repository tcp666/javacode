package os.bf;

//OSJob.java
public class OS1 {
    public static void main(String args[]) {
        Node process[] = new Node[20];
        process[0] = new Node(0, 20, false, 0);
        process[1] = new Node(20, 10, true, 1);
        process[2] = new Node(30, 30, false, 2);
        Link l = new Link();
        System.out.println("........................... 起始的内存 ...........................");
        for (int i = 0; i < Link.num; i++) {
            process[i].print();
        }
        System.out.println("..................... 增加第一个作业后的内存情况 .....................");
        l.addJob(4, 3, process);
        for (int i = 0; i < Link.num; i++) {
            process[i].print();
        }
        System.out.println("..................... 增加第二个作业后的内存情况 .....................");
        l.addJob(18, 4, process);
        for (int i = 0; i < Link.num; i++) {
            process[i].print();
        }
        System.out.println("..................... 增加第三个作业后的内存情况 .....................");
        l.addJob(10, 5, process);
        for (int i = 0; i < Link.num; i++) {
            process[i].print();
        }
        System.out.println("..................... 删除第四个作业后的内存情况 .....................");
        l.delete(process, 1);
        for (int i = 0; i < Link.num; i++) {
            process[i].print();
        }
    }
}