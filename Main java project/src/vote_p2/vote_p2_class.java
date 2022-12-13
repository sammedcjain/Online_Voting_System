package vote_p2;
import project.Online_voting;
import project.Role_admin;

public class vote_p2_class extends Online_voting implements Runnable {              //10. Usage of classes in different packages.
	public int dummy,dummy2,th;                                                       
	public vote_p2_class(int dummy,int dummy2)
	{
		
	}
	public vote_p2_class()
	{
		
	}
	public vote_p2_class(Role_admin ob6,int role) 
	{
		System.out.println("You've chosen :"+role);
	}
	
	public void name()
	{
		System.out.println("Enter your name ...i know this wont be printed ...hahaha");
	}

	Thread t ;
	vote_p2_class(int th) 
	{
		t = new Thread(this, "child Thread");		
		t.start(); 
	}
	
	public void run()                               //13. Thread creation using Runnable or extending Threads.
	{
		try 
		{
			for(int i = 5; i > 0; i--) 
			{
				System.out.println(i);
				Thread.sleep(1000);
			}
		} 
		catch (InterruptedException e) 
		{
			System.out.println("Thread interrupted.");
		}
	}
}