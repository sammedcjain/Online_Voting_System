package project;

interface inter_face
{
	void admin ();                        
    void dummy_intr(int para);            //12. Interfaces with variables.
    default void default_wala()               //11. Implementing interfaces with default methods.
	{
		System.out.println("This is Default Interface Method - Samosa")	;
	}
}
public class Role_admin extends Online_voting implements inter_face 
{
	public String admin_name;
	
	public void admin()
	{
		System.out.print("you are now an admin!!");	
	}
	
	public void dummy_intr(int para)
	{
		System.out.print("");
	}
	
	public Role_admin() 
	{
		
	}
}