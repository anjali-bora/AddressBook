import javax.swing.*;
import java.util.*;

public class TestClass{

public static void main(String args[]){
AddressBook add = new AddressBook();
int ch;
 String name;

while(true){
 name = JOptionPane.showInputDialog("Enter 1 to add\n Enter 2 to search\n Enter 3 to remove\n");
     ch = Integer.parseInt(name);  //converting String to character
      switch(ch){
         case 1:
                add.addPerson();
                break;
         case 2:
                name = JOptionPane.showInputDialog("Enter The Name");
                add.search(name);
                break;
         case 3:
                name = JOptionPane.showInputDialog("Enter The Name");
                add.remove(name);
                break;
         case 4:
                 System.exit(0);
       }//statment
      }//while
   }
 }
/*Making class PersonInfo for using as a data type in arraylist*/

class PersonInfo {  //follow namming conventiaon fo class name

  String name;
    String address;
   String phoneNum;

//Constructor

   public PersonInfo(String n, String add, String phone){

    name = n;
    address = add;
    phoneNum = phone;
  //follow namming conventiaon fo variable names
  }  // PersonInfo constructor

public void print(){

    JOptionPane.showMessageDialog(null, "Name:" +name+"Address:" +address+ "Phone No.:"+ phoneNum);
  }

}
class AddressBook {
ArrayList<PersonInfo> persons;

//constructor
      public AddressBook ( ) {
            persons = new ArrayList<PersonInfo>();
}

//add new person record to arraylist after taking input
        public void addPerson( ) {

String name = JOptionPane.showInputDialog("Enter name");
String add = JOptionPane.showInputDialog("Enter address");
String pNum = JOptionPane.showInputDialog("Enter phone no");





          //construct new person object
          PersonInfo p = new PersonInfo(name, add, pNum);

      //add the above PersonInfo object to arraylist
      persons.add(p);
       }

            public void search(String name){

            for(int i = 0; i < persons.size(); i++){
               PersonInfo p = (PersonInfo)persons.get(i);
               if(name.equals(p.name)){
                p.print();

             }//if statment
      } //for loop

   }//function search

              public void remove(String name){
             for(int i = 0; i < persons.size(); i++){
             PersonInfo p = (PersonInfo)persons.get(i);
               if(name.equals(p.name)){
                persons.remove(i); }
                }

      }//remove function

}
