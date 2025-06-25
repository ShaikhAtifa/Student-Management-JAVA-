import java.util.ArrayList;
import java.util.Scanner;
class Student{
    int id;
    String name; 
    float marks;
    public Student(int id, String name,float marks)
    {
        this.id=id;
        this.name=name;
        this.marks=marks;
    }
      void display()
        {
            System.out.println("ID od student:"+this.id+"Name of student:"+this.name+"\nMarks of student:"+this.marks);
        }
}
class Task2_StudManagement
{
    ArrayList<Student> student=new ArrayList<>();
    Scanner sc=new Scanner(System.in);
    void addRecord(){
        System.out.println("Enter Student records");
        System.err.println("-----------------------");
        System.out.println("Enter ID of student:");
        int sid=sc.nextInt();
        System.out.println("Enter Name of student:");
        String sname=sc.next();
        System.err.println("Enter Marks of student");
        float smarks=sc.nextFloat();
        student.add(new Student(sid,sname,smarks));
        System.out.println("Students Record Added SuccessFully");

    }
    void updateRecord()
    {
        System.out.println("Enter Student ID to update:");
        int updid=sc.nextInt();
        for (int i=0;i<student.size();i++) {
            if(updid==student.get(i).id)
            {
                System.out.println("ID found");
                System.out.println("Enter name to update:");
                String newname=sc.next();
                System.out.println("Enter Marks to update");
                float newmarks=sc.nextFloat();
                student.set(i,new Student(updid,newname,newmarks));
                System.out.println("Record updated Successfully");
            }
            else{
        System.out.println("Student ID not Found!");

            }
        }
    }
    void deleteRecord()
    {
        System.out.println("Enter ID to delete Record:");
        int id=sc.nextInt();
       
            if(student.removeIf(s-> s.id==id))
            {
                System.out.println("Student Record Deleted Successfully");
            }
            else{
                System.out.println("ID not found");
            }
 

    }
       void displayRecord()
    {
        System.err.println("List of all Available Students:");
        System.out.println("----------------------------");
        for (Student std : student) {
            std.display();
        }
    }
    public static void main(String[] args) {
        Task2_StudManagement sm=new Task2_StudManagement();
        int choice;
        Scanner sc=new Scanner(System.in);
                do{
        System.out.println("________________________________________");
        System.out.println("Select operation to perform");
        System.out.println("1.Add Student Record");
        System.out.println("2.Update Student Record");
        System.out.println("3.Delete Student Record");
        System.out.println("4.Display Student Record");
        System.out.println("6.Exit");
        choice=sc.nextInt();
            switch(choice)
            {
                case 1:
                    sm.addRecord();
                    break;
                case 2:
                    sm.updateRecord();
                    break;
                case 3:
                    sm.deleteRecord();
                    break;
                case 4:
                    sm.displayRecord();
                    break;
                case 5:
                    System.out.println("closing operation \nEND:)");
                    break;
                default:
                    System.err.println("Enter valid input as per given instruction and try again!");
            }
        }while(choice !=5);
    }
}