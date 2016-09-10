/**
 * Created by Rafael on 3/25/2016.
 */
class RunnyStack<Base>{
  private class Run{
      private Base object;
      private int length;
      private Run next;
      private Run(Base element,int length,Run next){
          this.object = element;
          this.length = length;
          this.next = next;
      }
  }
    public Run top;
    public int depth;
    public int runs;
    public RunnyStack(){
        //depth=0;
        top = null;
    }
    public boolean isEmpty(){
        return top == null;
    }
    public void push(Base element){
        depth++;
        if (isEmpty()){
            top = new Run(element,1,top);
            runs++;
        }
        else if (isEqual(element,top.object)) {
            top.length++;
        }
        else{
            top = new Run(element,1,top);
            runs++;
        }

    }
    public void pop(){
        if (isEmpty()){
            throw new IllegalArgumentException("You're stack is empty");
        }
        else{
            depth--;
            top.length--;
            if (top.length==0) {
                top = top.next;
                runs--;
            }

        }
    }
    public Base peek(){
        if(isEmpty()){
            throw new IllegalArgumentException("You're stack is empty");
        }
        else
            return top.object;
    }
    public int depth(){
        return depth;
    }
    public int runs(){
        return runs;
    }
    private boolean isEqual(Base object,Base element){
        if (object == null || element==null)
            return object==element;
        else{
            return object.equals(element);
        }
    }
}

public class RunnyDriver
{
    public static void main(String[] args)
    {
        RunnyStack<String> s = new RunnyStack<String>();

        s.push("A");
        System.out.println(s.peek() + " " + s.depth() + " " + s.runs());  //  A 1 1

        s.push("B");
        System.out.println(s.peek() + " " + s.depth() + " " + s.runs());  //  B 2 2

        s.push("B");
        System.out.println(s.peek() + " " + s.depth() + " " + s.runs());  //  B 3 2

        s.pop();
        System.out.println(s.peek() + " " + s.depth() + " " + s.runs());  //  B 2 2

        s.pop();
        System.out.println(s.peek() + " " + s.depth() + " " + s.runs());  //  A 1 1
        s.push(null);
        System.out.println(s.peek() + " " + s.depth() + " " + s.runs()); // null 2 2
    }
}
