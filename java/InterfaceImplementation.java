public class InterfaceImplementation {
 interface Playable {void play();}
 static class Guitar implements Playable {public void play(){System.out.println("Guitar playing");}}
 static class Piano implements Playable {public void play(){System.out.println("Piano playing");}}
 public static void main(String[] args) {
  new Guitar().play();
  new Piano().play();
 }
}
