import java.util.Scanner;

import com.foodapp.DAOimpl.UserDAOimpl;
import com.foodapp.models.User;

public class Launch {


	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	
	System.out.println("Enter the id");
	int id = scan.nextInt();
	
	UserDAOimpl udao = new UserDAOimpl();
	
	User u = udao.getUserByid(id);
	System.out.println(u);
	
	u.setPassword("5678");
	u.setAddress("Rajaji Nagar");
	udao.updateUser(u);
	



    
    
    
 
    
	}

}
