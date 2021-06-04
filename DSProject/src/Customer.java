
public class Customer {
	private String firstName;
	private String lastName;
	private String age;
	private String gender;
	private String email;
	private String accNum;
	private String phoneNum;
	private String accType;
	
	public Customer(String newFirstName, String newLastName, String newAge, String newGender, String newEmail, String newAccNum, String newPhoneNum, String newAccType){
		firstName = newFirstName;
		lastName = newLastName;
		age = newAge;
		gender = newGender;
		email = newEmail;
		accNum = newAccNum;
		phoneNum = newPhoneNum;
		accType = newAccType;
	}
	
	public String getFirstName(){
		return firstName;
	} 
	
	public String getLastName() {
		return lastName;
	}

	public String getAge(){
		return age;
	}
	
	public String getGender(){
		return gender;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getAccNum() {
		return accNum;
	}
	
	public String getPhoneNum() {
		return phoneNum;
	}
	
	public String getAccType() {
		return accType;
	}

	public void setFirstName(String name){
		this.firstName=name;
	} 
	
	public void setLastName(String name) {
		this.lastName=name;
	}

	public void setAge(String age){
		this.age=age;
	}
	
	public void setGender(String gender){
		this.gender=gender;
	}
	
	public void setEmail(String email) {
		this.email=email;
	}
	
	public void setAccNum(String acc) {
		this.accNum=acc;
	}
	
	public void setPhoneNum(String phone) {
		this.phoneNum=phone;
	}
	
	public void setAccType(String type) {
		this.accType=type;
	}
}
