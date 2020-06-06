import java.util.*;
import java.lang.*;
import java.io.FileWriter;
class  PersonInfo{
        String Fname;
        String Lname;
        String city;
        String state;
        int zip;
        long pnum;
        static PersonInfo Record(){
                PersonInfo pi1 = new PersonInfo();
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter the First Name");
                pi1.Fname = sc.nextLine();
                System.out.println("Enter the Last Name");
                pi1.Lname = sc.nextLine();
                ReuseRecord(pi1);
                return pi1;
        }
        static void ReuseRecord(PersonInfo pi1){
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter the City");
                pi1.city = sc.nextLine();
                System.out.println("Enter the State");
                pi1.state = sc.nextLine();
                System.out.println("Enter the 6 Digit Zip code");
                pi1.zip = sc.nextInt();
                int length = (int)(Math.log10(pi1.zip)+1);
                while(length != 6){
                System.out.println("enter 6 digit number");
                pi1.zip = sc.nextInt();
                length = (int)(Math.log10(pi1.zip)+1);
                        if(length==10){
                        pi1.zip=pi1.zip;
                        break;
                        }
                }
                System.out.println("Enter the 10 Digit Mobile Number");
                pi1.pnum = sc.nextLong();
                length = (int)(Math.log10(pi1.pnum)+1);
                while(length != 10){
                        System.out.println("enter 10 digit number");
                        pi1.pnum = sc.nextLong();
                        length = (int)(Math.log10(pi1.pnum)+1);
                        if(length==10){
                                pi1.pnum=pi1.pnum;
                                break;
                        }
                }

        }

        public static void main(String[] args)throws Exception{
           boolean check=true;
                ArrayList<PersonInfo> l = new ArrayList<PersonInfo>();
                while(check==true){
                        Scanner sc = new Scanner(System.in);
                        System.out.println("1)Add  2)Display 3)Delet 4)Update  5)SORT BY NAME 6)SORT BY ZIP 7)EXIT");
                        int select = sc.nextInt();
                        switch (select) {
                                case 1:
                                        PersonInfo pi = Record();
                                        l.add(pi);
                                        break;
                                case 2:
                                        System.out.println("PERSONS INFORMATION : ");
                                        System.out.println("==============");
                                        for ( PersonInfo p : l ) {
                                                System.out.println(p.Fname+"  "+p.Lname+"  "+p.city+"  "+p.state+"  "+p.zip+" "+p.pnum);
                                        }
                                        break;



                                case 3:
                                        boolean r=true;
                                        sc.nextLine();
                                        System.out.println("Enter name which you want to Delet");
                                        String DeletName = sc.nextLine();
                                        for ( PersonInfo ch : l ){
                                                if( ch.Fname.equals(DeletName) ){
                                                        r=false;
                                                        l.remove(ch);
                                                        break;

                                                }
                                        }
                                        if(r){
                                             System.out.println("Record not exist");
                                            }

                                        break;


                                case 4:
                                         r=true;
                                         sc.nextLine();
                                        System.out.println("Enter your name");
                                        String NamePresent = sc.nextLine();
                                        for ( PersonInfo ch : l ){
                                                if( ch.Fname.equals(NamePresent) ){
                                                        r=false;
                                                        ReuseRecord(ch);
                                                        break;
                                                }
                                        }
                                        if(r){
                                                System.out.println("Record not exist");
                                        }

                                        break;

                                case 5:

                                        Collections.sort(l, new Comparator<PersonInfo>(){

                                                public int compare(PersonInfo obj1,PersonInfo obj2){
                                                        return obj2.Fname.compareTo(obj1.Fname);
                                                }

                                        }.reversed());
                                        System.out.println("PERSONS Information SORT BY NAME: ");
                                        System.out.println("============================");
                                         for ( PersonInfo p : l ) {
                                                System.out.println(p.Fname+"  "+p.Lname+"  "+p.city+"  "+p.state+"  "+p.zip+" "+p.pnum);
                                        }

                                        break;


                                case 6:
                                       Collections.sort(l, new Comparator<PersonInfo>(){

                                                public int compare(PersonInfo obj1,PersonInfo obj2){
                                                        return obj2.zip-obj1.zip;
                                                }
                                        }.reversed());
                                         System.out.println("PERSONS INFORMATION SORT BY ZIP: ");
                                         System.out.println("============================");


                                         for ( PersonInfo p : l ) {
                                                System.out.println(p.Fname+"  "+p.Lname+"  "+p.city+"  "+p.state+"  "+p.zip+" "+p.pnum);
                                        }
                                        break;
                                case 7:
                                        check=false;
                                        break;
                                default:
                                        System.out.println("invalid input");
                                        break;
                        }
                        FileWriter writer = new FileWriter("AddressBook.txt");
                        for(PersonInfo ch : l) {
                                writer.write(String.valueOf(ch.Fname+ " " + ch.Lname + " " + ch.city + " " + ch.state +" "+ ch.zip +" "+ ch.pnum+"\n"));

                        }
                        writer.close();

                }
         }
}
