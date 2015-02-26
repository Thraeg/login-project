package acctMan;

import java.util.HashMap;

public class AccountManager {
	private HashMap<String, String> users;
	

	/**foo
	 * Initializes with default users. foo
	 */
	public AccountManager(){
		users = new HashMap<String, String>();
		users.put("Patrick", "1234");
		users.put("Molly", "FloPup");
	}

	/**
	 * Tries to log in with the specified name and password.
	 * @param name
	 * @param password
	 * @return true if name is valid and the password matches the one saved for it, false otherwise.
	 */
	public boolean tryLogin(String name, String password){
		if(users.containsKey(name) && password.equals(users.get(name))) return true;
		else return false;
	}
	
	/**
	 * Checks whether a name is found in the users map.
	 * @param name
	 * @return true if name exists, false otherwise.
	 */
	public boolean checkName(String name){
		return users.containsKey(name);
	}
	
	/**
	 * Adds a new user to users map.
	 * @param name
	 * @param password
	 * @return true if successful, false if name already exists.
	 */
	
	public boolean addUser(String name, String password){
		if(users.containsKey(name)) return false;
		else {
			users.put(name, password);
			return true;
		}
	}

	//Comment testing git
}
