package project;
import java.util.*;
import vote_p2.multi_lvl;
import vote_p2.vote_p2_class;

class customexp extends Exception                             //9. Custom exceptions
{
	public customexp(String s)
	{
		super(s);
	}
}

class Sync
{  
	 synchronized void printSync(int n)                                //14.Thread synchronisation.
	 { 
	   for(int i=1;i>=1;i--)
	   {  
	     System.out.println("round "+n*i+" of counting over");  
	     try
	     {  
	      Thread.sleep(750);  
	     }
	     catch(Exception e)
	     {
	    	 System.out.println(e);
	     }  
	   }  
	  
	 }  
}  
	  
class Sync_thread1 extends Thread
{  
	Sync t;  
	Sync_thread1(Sync t)                             
	{  
	this.t=t;  
	}  
	public void run()
	{  
	t.printSync(1);  
	}  
	  
}  

class Sync_thread2 extends Thread
{  
	Sync t;  
	Sync_thread2(Sync t)
	{  
	this.t=t;  
	}  
	public void run()
	{  
	t.printSync(2);  
	}  
}  
	  
	 
	
public class Online_voting {                           // 1. class declaration
	
	public static int num_of_classes;
	public static int num_of_candidates[];
	public static String candidate_name[][];
	public Online_voting() 
	{
		
	}
	public Online_voting(int num_of_classes)             
	{
		this.num_of_classes=num_of_classes;
	}
	
	public Online_voting(int num_of_candidates[]) 
	{
		this.num_of_candidates=num_of_candidates;	
	}
	
    public Online_voting(String candidate_name[][]) 
    {
		this.candidate_name=candidate_name;	                              //4. Usage of 'this' keyword.
	}
	
	public void print_classnum()
	{
		for(int i=0;i<1;i++)
		{
			System.out.println("Class - "+(i+0));
		}
	}
	
	public void print_candidates(int class_no)
	{
		for(int i=0;i<num_of_classes;i++)
		{
			for(int j=0;j<num_of_candidates[i];j++)
			System.out.println(candidate_name[i][j]);
		}
	}
	
	Online_voting ret_obj()                           //3. Returning objects from method.
	{
		Online_voting object=new Online_voting();
		return object;
	}
	void intro_print()
	{
		System.out.println("Hey there ! Welcome to online voting System");
		System.out.println("choose your role --");
		System.out.println("1 : admin"); 
		System.out.println("2: Voter");
	}
	
	public static void main(String[] args) throws customexp 
	{
		Scanner sc=new Scanner(System.in);             //7. using scanner class
		Online_voting ob5=new Online_voting();
		Online_voting intro=new Online_voting();
		Role_admin ob2=new Role_admin();
		intro=ob5.ret_obj();
		intro.intro_print();
		int role=sc.nextInt();                         //7. Reading console input nextInt() using Scanner class.
		vote_p2_class ob6=new vote_p2_class(ob2,role);              //2. Passing object and basic datatypes as parameters to constructors.
		int no_of_classes;
		int candidates_no=0;
		int total_voters=0;
		String Cand_name[][];
		Cand_name=new String[5][5];
		int class_count[];
		class_count=new int[candidates_no];
		if(role==1)
		{	
			no_of_classes=1;
			multi_lvl name_obj=new multi_lvl();     //6. Overriding methods and associated object creation.
			name_obj.name();               
			String ad_name=sc.next();              //7. Reading console input next() using Scanner class.
			System.out.print(ad_name+" ");
			inter_face inter_ob=new Role_admin();    //11. Implementing interfaces with default methods.
			inter_ob.admin();     
			inter_ob.dummy_intr(role);                //12. Interfaces with variables.
			Online_voting ob=new Online_voting(no_of_classes);        
			candidates_no=0;
			for(int i=0;i<num_of_classes;i++)
			{
				System.out.println("");
				System.out.println("Enter the number of candidates in the class");
				candidates_no=sc.nextInt();
			}
			class_count=new int[candidates_no];
			System.out.println("Enter total number of voters in the class");
			total_voters=sc.nextInt();
			Online_voting ob3=new Online_voting(candidates_no);
			for(int i=0;i<no_of_classes;i++)
			{
				int j=0;
				System.out.println("Enter the name of all candidates in the class");
				while(j<candidates_no)
				{
				Cand_name[i][j]=sc.next();                  
				j++;
				}
			}
			Online_voting ob4=new Online_voting(Cand_name);	
			System.out.println("Thank you for enterting the data..."+ad_name+" Admin");
			System.out.println("Press 2 to cast your vote or 0 to exit");
			role=0;
			role=sc.nextInt();
		}
		if(role==2)
		{
			if(candidates_no==0)
			{
				System.out.println("Admin has not entered the values properly...run the program again");
				System.exit(candidates_no);	
			}
			int i=0;
			int k=0;
			System.out.println("Now you are entering the voting system");
			for(int j=0;j<candidates_no;j++)	
            {
		    class_count[j]=0;
			}
			while(k!=total_voters)
			{
            for(i=0;i<50;i++)
            {
            	System.out.println("");
            }
            int class_no=0;
            System.out.println("Voter"+(k+1));
			System.out.println("Candidates present in the class:");
			String votedb[][]=new String [num_of_classes][candidates_no];
			String vote=new String();
			for( i=0;i<1;i++)
			{
                for(int j=0;j<candidates_no;j++)	
                {
				System.out.println(Cand_name[class_no][j]+" ");
				votedb[i][j]=Cand_name[class_no][j];
                }   
			}
			System.out.println("Enter the candidate name to vote -- ");
			vote=sc.next();                                          			
			for(int j=0;j<candidates_no;j++)	
            {
				i=0;
			if(votedb[i][j].equals(vote))                 // 8. string handling function1.
			{
				class_count[j]=class_count[j]+1;
			}
            }
			/*
			 for(i=0;i<candidates_no;i++)
			{
				System.out.println(class_count[i]);
			}
			*/
			k++;
			}
		}
		if(role==0)
		{
			System.out.println("Thank u ..visit again!:)");
			System.exit(total_voters);
		}
			int loc_max=0;
			int max=0;
			for(int i=0;i<candidates_no;i++)
			{
				if(class_count[i]>max)
				{
					max=class_count[i];
				    loc_max=i;
				}
			}
			Thread t=Thread.currentThread();
			for(int i=0;i<50;i++)
            {
            	System.out.println("");
            }
			System.out.println("Counting in progress:");
			Sync obj = new Sync();                                   //14. thread synchronization
			Sync_thread1 t1=new Sync_thread1(obj);  
			Sync_thread2 t2=new Sync_thread2(obj);  
			t1.start();  
			t2.start(); 
			try {
			Thread.sleep(2000);
			}
			catch(InterruptedException e)
			{
				System.out.println("Don't worry this section won't be printed");
			}
			System.out.println("Result in :");
			ob6.run();
			System.out.println(candidate_name[0][loc_max].toUpperCase()+" IS THE WINNER !!! WITH "+max+" VOTES");       //8. string handling function 2
			sc.close();
			try
			{
				throw new customexp("Custom exception thrown here");	
			}
			catch(customexp e)
			{
				System.out.println("Run the program again to start the voting system");
			}
			finally
			{
				System.out.println("");
			}
	}
}