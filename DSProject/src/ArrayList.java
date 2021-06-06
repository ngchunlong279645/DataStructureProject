

public class ArrayList {
	private Customer [] myList;
	private int num;
	private int size;

	public ArrayList(int size){
		myList = new Customer[size];
		this.size=size;
		num = 0;
	}
	
	public boolean isEmpty( ) {
    	if(num== 0)
        	return true;
       else
       		return false;
	}
	
	public boolean isFull( ) {
	   if(num== myList.length)
	        return true;
	   else
	        return false;
	}
	
	public void add(String newFirstName, String newLastName, String newAge, String newGender, String newEmail, String newAccNum, String newPhoneNum, String newAccType) {
		 if (isEmpty( )) {
	       	 myList[0]=new Customer(newFirstName,newLastName,newAge,newGender,newEmail,newAccNum,newPhoneNum,newAccType);                                                                              
	       	 num++;
		 }  	 
	     else if(isFull( )) {                                    
	    	  System.out.println("List is full");
	     }
	     else {	
	    	  myList[num]=new Customer(newFirstName,newLastName,newAge,newGender,newEmail,newAccNum,newPhoneNum,newAccType);                                  
	  	      num++;
	     }     
	}	

	public void removeBtw(int index) {
		if (isEmpty( ))                                                             	
			System.out.println("List is empty");         	
		else
	        //System.out.println(myList[0]);
			for(int i=index;i<num;i++) {
				myList[i]=myList[i+1];
			}
		num--;         
	} 
	
	public void search(int index){
		  System.out.println("\nFirst Name ="+myList[index].getFirstName());
		  System.out.println("Last Name ="+myList[index].getLastName());
		  System.out.println("Age = "+myList[index].getAge());
		  System.out.println("Gender = "+myList[index].getGender());
		  System.out.println("Email ="+myList[index].getEmail());
		  System.out.println("Account Number ="+myList[index].getAccNum());
		  System.out.println("Phone Number ="+myList[index].getPhoneNum());
		  System.out.println("Account Type ="+myList[index].getAccType());
	}
	public void sequantialSearch() {
		/*for(int i=0;i<num;i++) {
			if(myList[i].getAccNum().equals(input)) {
			JOptionPane.showMessageDialog(btnSearch, "Found", "Search Information",2);
			firstname.setText(myList[i].getFirstName());
			lastname.setText(myList[i].getLastName());
			age.setText(myList[i].getAge());
			gender.setText(myList[i].getGender());
			email.setText(myList[i].getEmail());
			accnum.setText(myList[i].getAccNum());
			phnumber.setText(myList[i].getPhoneNum());
			acctype.setText(myList[i].getAccType());
	
			return;
		}	
		}*/
	}
	
	public void edit(int index,String newFirstName, String newLastName, String newAge, String newGender, String newEmail, String newAccNum, String newPhoneNum, String newAccType) {
		if (isEmpty( ))                                                             	
			System.out.println("List is empty");      
		else
			myList[index]=new Customer(newFirstName,newLastName,newAge,newGender,newEmail,newAccNum,newPhoneNum,newAccType);  
	}

    public void displayRecord(){
    if(num!=0) {	
    	for (int i= 0; i< num; i++){
    		System.out.println("\nNO : "+i);
    		System.out.println("First Name ="+myList[i].getFirstName());
    		System.out.println("Last Name ="+myList[i].getLastName());
    		System.out.println("Age = "+myList[i].getAge());
    		System.out.println("Gender = "+myList[i].getGender());
    		System.out.println("Email = "+myList[i].getEmail());
    		System.out.println("Account Number = "+myList[i].getAccNum());
    		System.out.println("Phone Number = "+myList[i].getPhoneNum());
    		System.out.println("Account Type = "+myList[i].getAccType());
    		
    	}
    }
    else {
    	System.out.println("Empty list");
    	}
	}
    
    public int size() {
		return size;
}
    
    }

	


