package control;

import model.*;

public class CheckLogin {

	@SuppressWarnings("finally")
	public static boolean ceckLogin(String username, String password) {
		try{
			UserModelDS daoUser = new UserModelDS();
			UserBean user = (UserBean) daoUser.doRetrieveByKey(username);
			if(user != null){		
	           if(user.getPassword().equals(password)) {
	        	   return true;
	           }
	           else {
	        	   return false;
	           }
			}
		}catch(Exception e){
			 System.out.println(e);
		}
		return false;
	}
	
	public static boolean ceckAdministrator(String username, String password) {
		
		if((username.equals("Domenico") && password.equals("8426")) || (username.equals("Fabio") && password.equals("8426")))
			return true;
		else
			return false;
	}

}
