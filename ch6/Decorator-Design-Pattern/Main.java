/**
*  Software Engineering: A Modern Approach (Ch. 6)
* Prof. Marco Tulio Valente
* 
* Example of the Decorator design pattern
*
*/

/* 
* Our decorators will implement the Channel interface
*/
interface Channel {
  void send(String msg); 
  String receive();
}


/**
* TCPChannel is a concrete communication channel (using the TCP protocol)
* Therefore, it is the final class in a chain of decorators
*/
class TCPChannel implements Channel {
  
  public void send(String m) {
    System.out.println("Concrete channel (TCP) sending > " + m);
  }
  
  public String receive() {
    System.out.println("Concrete channel (TCP) receiving...");
    return "Joseph";
  }

}


/**
* Decorators are also subclasses of ChannelDecorator
*/
class ChannelDecorator implements Channel {
  protected Channel channel;

  public ChannelDecorator(Channel channel) {
    this.channel = channel;
  }
  
  public void send(String m) {
    channel.send(m);
  }
  
  public String receive() {
    return channel.receive();
  }
  
}

/**
* Decorator that:
*  - compresses messages before sending
*  - decompresses messages after receiving
*/
class ZipChannel extends ChannelDecorator {
  
   public ZipChannel(Channel c) {
     super(c);
   }
   
   public void send(String m)  {
     System.out.println("Decorator compressing > " + m);
     super.send(m);
   }
   
   public String receive()  {
     String m = super.receive();
     System.out.println("Decorator decompressing < " + m);
     return m;
   }
  
}

public class Main {
  
  public static void main(String args[]) {
    Channel c = new ZipChannel(new TCPChannel());
    c.send("What’s your name?");
    String r = c.receive();
    System.out.println(r);
  }   

}
