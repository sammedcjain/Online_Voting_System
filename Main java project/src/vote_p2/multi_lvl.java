package vote_p2;

public class multi_lvl extends vote_p2_class        // 5. Multilevel inheritance - Passing objects as parameters in constructors in super().
{
	int dummy3;
	multi_lvl(int dummy3,int dummy1)
	{
		super(dummy1,dummy3);
	}
	
	public multi_lvl() {
		
	}

	public void name()
	{
		System.out.println("Enter your name ...");     //6. Overriding methods 
	}	
}

