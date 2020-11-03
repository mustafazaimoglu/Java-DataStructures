// MKZ
public class Main
{
    public static void main(String[] args)
    {
         Queue q = new Queue(5);
         
         q.pop();
         q.print();
         q.push(2);
         q.print();
         q.push(8);
         q.print();
         System.out.println(q.pop()  +  " pop");
         q.push(5);
         q.print();
         System.out.println(q.pop() +  " pop");  
         q.push(7);
         q.print();
         q.push(6);
         q.print();
         q.push(9);
         q.print();
         System.out.println(q.peek() + " peek");
         q.push(4);
         q.print();
         System.out.println(q.pop() + " pop");
         q.print();
         q.push(10);
         q.print();
        
        
//        Stack s = new Stack(5);
//
//        s.push(15);
//        s.print();
//        s.push(16);
//        s.print();
//        System.out.println("Popped element is :" + s.pop());
//        s.print();
//        s.push(18);
//        s.print();
//        s.push(11);
//        s.print();
//        s.push(13);
//        s.print();
//        s.push(158);
//        s.print();
//        System.out.println("Popped element is :" + s.pop());
//        s.push(178);
//        
//        System.out.println("peek : " + s.peek());
//        s.print();
    }
}
