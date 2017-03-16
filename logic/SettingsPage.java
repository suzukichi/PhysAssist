package logic;
/*
 * SettingsPage.java
 * 
 * 
 * 
 * @author Kyle Ringler
 * Created Feb 13, 2017
 */

public class SettingsPage extends Page {
	private guis.Settings page;
	public HomePage homeController;
	
	public SettingsPage(guis.MainWindow view) {
		initView(view);
	}
  
	public void display() {
    
	}
  
	public void updateSettings() {
		page.updateText(user.username, user.email);
	}
  
	public void initView(guis.MainWindow view){
		page = new guis.Settings();
	}

	public int editEmail(String email) {
		if(User.emailExists(email))
			return -1;//GUI checks if not changed
		else {
			user.email = email;
			save();
		}
		return 0;
	}

	public void editName(String fName, String lName) {
		user.firstName = fName;
		user.lastName = lName;
		save();
	}

	public int editPassword(String password) {
		if(User.verify(user.username, password) >= 0) {
			user.password = User.encrypt(password);
			save();
			return 0;
		}
		else
			return 1;
	}

	public int editUsername(String username) {
		if(User.nameExists(username)){
			return -1; //GUI checks if not changed
		}
		else {
			user.username = username;
			save();
			return 0;
		}
	}
	
	private void save()
	{
		user.save();
		homeController.user = user;
		homeController.passUser();
	}
}
