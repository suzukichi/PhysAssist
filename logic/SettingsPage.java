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
  
	@Override
	public void display() {
		// empty
	}
  
	public void updateSettings() {
		page.updateText(user.getUsername(), user.getEmail());
	}
  
	public void initView(guis.MainWindow view){
		page = new guis.Settings();
		view.add(page, "settings");
	}

	public int editEmail(String email) {
		if(User.emailExists(email))
			return -1;//GUI checks if not changed
		else {
			user.setEmail(email);
			save();
		}
		return 0;
	}

	public void editName(String fName, String lName) {
		user.setFirstName(fName);
		user.setLastName(lName);
		save();
	}

	public int editPassword(String password) {
		if(User.verify(user.getUsername(), password) >= 0) {
			user.setPassword(User.encrypt(password));
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
			user.setUsername(username);
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
