import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BankManagementSystem {

	private JFrame frame;
	private static JTextField firstname;
	private static JTextField lastname;
	private static JTextField age;
	private static JTextField gender;
	private static JTextField email;
	private static JTextField accnum;
	private static JTextField phnumber;
	private static JTextField acctype;
	private JTable table;

	static int num;
	int row;

	static Customer [] myList=new Customer[999]; ;
	DefaultTableModel dtm;
	String header[]=new String[] {"firstName","lastName","age","gender","email","accNO","PhoneNO","accType"};
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BankManagementSystem window = new BankManagementSystem();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static boolean isEmpty( ) {
		 if(num== 0)
		 return true;
		 else
		 return false;

		} //end inEmpty() method
		public static boolean isFull( ) {
		 if(num== myList.length)
		 return true;
		 else
		 return false;

		} //end inFull() method
		
		
	
	public void displayStudentDetails() {
		dtm.setRowCount(0);
		insertionSort ();
		for(int i=0;i<num;i++) {
			Object[]obj= {myList[i].getFirstName(),myList[i].getLastName(),myList[i].getAge(),myList[i].getGender(),myList[i].getEmail(),myList[i].getAccNum(),myList[i].getPhoneNum(),myList[i].getAccType()};
			dtm.addRow(obj);
			
		}
	}
	
	public void insertionSort ()
	   {
		for (int x=1; x < num; x++)
	       {
	         Customer tempList = myList[x];
	         int y=x;
	         for (;y>0 && Integer.parseInt(tempList.getAccNum())<Integer.parseInt(myList[y-1].getAccNum());y--) 
	        	 myList[y]=myList[y-1];  
	         myList[y]=tempList;
	         
	         }
	       }
	
	
	public void refresh() {
		firstname.setText("");
		lastname.setText("");
		age.setText("");
		gender.setText("");
		email.setText("");
		accnum.setText("");
		phnumber.setText("");
		acctype.setText("");
	}

	/**
	 * Create the application.
	 */
	public BankManagementSystem() {
		initialize();
		dtm=new DefaultTableModel(header,0);
		table.setModel(dtm);
		
		JLabel lblAcctype = new JLabel("accType");
		lblAcctype.setBounds(39, 272, 73, 14);
		frame.getContentPane().add(lblAcctype);
		
		acctype = new JTextField();
		acctype.setColumns(10);
		acctype.setBounds(122, 273, 86, 20);
		frame.getContentPane().add(acctype);
		
		JButton btnSearch = new JButton("search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = JOptionPane.showInputDialog(null,"Search Account No: ");
				 int first = 0, last = num - 1;
			        while (first <= last) {
			            int mid = first + (last - first) / 2;
			            if (myList[mid].getAccNum().equals(input)) {
			            	JOptionPane.showMessageDialog(null, "Found", "Search Information",2);
							firstname.setText(myList[mid].getFirstName());
							lastname.setText(myList[mid].getLastName());
							age.setText(myList[mid].getAge());
							gender.setText(myList[mid].getGender());
							email.setText(myList[mid].getEmail());
							accnum.setText(myList[mid].getAccNum());
							phnumber.setText(myList[mid].getPhoneNum());
							acctype.setText(myList[mid].getAccType()); 
							return;
			            }
			            else if (myList[mid].getAccNum().compareTo(input)<0) {
			                first = mid + 1;
			            }
			            else
			                last = mid - 1;
			        }  
			        JOptionPane.showMessageDialog(null, "Not Found");
			}
			
		});
		btnSearch.setBounds(122, 338, 89, 23);
		frame.getContentPane().add(btnSearch);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 846, 446);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(39, 32, 73, 14);
		frame.getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(39, 64, 73, 14);
		frame.getContentPane().add(lblLastName);
		
		JLabel lblAge = new JLabel("age");
		lblAge.setBounds(39, 98, 73, 14);
		frame.getContentPane().add(lblAge);
		
		JLabel lblGender = new JLabel("gender");
		lblGender.setBounds(39, 123, 73, 14);
		frame.getContentPane().add(lblGender);
		
		JLabel lblEmail = new JLabel("email");
		lblEmail.setBounds(39, 157, 73, 14);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblAccnum = new JLabel("accNum");
		lblAccnum.setBounds(39, 195, 73, 14);
		frame.getContentPane().add(lblAccnum);
		
		JLabel lblPhonenum = new JLabel("phoneNum");
		lblPhonenum.setBounds(39, 233, 73, 14);
		frame.getContentPane().add(lblPhonenum);
		
		firstname = new JTextField();
		firstname.setBounds(122, 29, 86, 20);
		frame.getContentPane().add(firstname);
		firstname.setColumns(10);
		
		lastname = new JTextField();
		lastname.setColumns(10);
		lastname.setBounds(122, 61, 86, 20);
		frame.getContentPane().add(lastname);
		
		age = new JTextField();
		age.setColumns(10);
		age.setBounds(122, 95, 86, 20);
		frame.getContentPane().add(age);
		
		gender = new JTextField();
		gender.setColumns(10);
		gender.setBounds(122, 130, 86, 20);
		frame.getContentPane().add(gender);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(122, 154, 86, 20);
		frame.getContentPane().add(email);
		
		accnum = new JTextField();
		accnum.setColumns(10);
		accnum.setBounds(122, 192, 86, 20);
		frame.getContentPane().add(accnum);
		
		phnumber = new JTextField();
		phnumber.setColumns(10);
		phnumber.setBounds(122, 230, 86, 20);
		frame.getContentPane().add(phnumber);
		
		JButton btnAdd = new JButton("add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (isEmpty( )) {
					 myList[0]=new Customer (firstname.getText(),lastname.getText(),age.getText(),gender.getText(),email.getText(),accnum.getText(),phnumber.getText(),acctype.getText());
					 num++;
					}
					 else if(isFull( )) {
					 System.out.println("List is full");
					 }
					 else {
					 myList[num]=new Customer (firstname.getText(),lastname.getText(),age.getText(),gender.getText(),email.getText(),accnum.getText(),phnumber.getText(),acctype.getText());
					 num++;
					 }
				JOptionPane.showMessageDialog(null, "Added Successfully");
				displayStudentDetails();
				refresh();
					} //end addLast() method
			
		});
		btnAdd.setBounds(10, 304, 89, 23);
		frame.getContentPane().add(btnAdd);
		
		JButton btnEdit = new JButton("edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice=JOptionPane.showConfirmDialog(null, "Update this data ?","Update",JOptionPane.YES_NO_OPTION);
				if(choice==0) {
					myList[row].setFirstName(firstname.getText());
					myList[row].setLastName(lastname.getText());
					myList[row].setAge(age.getText());
					myList[row].setGender(gender.getText());
					myList[row].setEmail(email.getText());
					myList[row].setAccNum(accnum.getText());
					myList[row].setPhoneNum(phnumber.getText());
					myList[row].setAccType(acctype.getText());
					displayStudentDetails();
					refresh();
				}
			}
		});
		btnEdit.setBounds(119, 304, 89, 23);
		frame.getContentPane().add(btnEdit);
		
		JButton btnDelete = new JButton("delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(num!=0) {
				int choice=JOptionPane.showConfirmDialog(null, "Delete this data ?","Delete",JOptionPane.YES_NO_OPTION);
				if(choice==0) {
					dtm.removeRow(row);
					if (isEmpty( ))                                                             	
						System.out.println("List is empty");         	
					else
						for(int i=row;i<num;i++) {
							myList[i]=myList[i+1];
						}
					num--;   
					displayStudentDetails();
					refresh();
					return;
				}
				}
				JOptionPane.showMessageDialog(null, "No Data");
			}
		});
		btnDelete.setBounds(10, 338, 89, 23);
		frame.getContentPane().add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(252, 32, 557, 340);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				row=table.getSelectedRow();
				
				firstname.setText(dtm.getValueAt(row, 0).toString());
				lastname.setText(dtm.getValueAt(row, 1).toString());
				age.setText(dtm.getValueAt(row, 2).toString());
				gender.setText(dtm.getValueAt(row, 3).toString());
				email.setText(dtm.getValueAt(row, 4).toString());
				accnum.setText(dtm.getValueAt(row, 5).toString());
				phnumber.setText(dtm.getValueAt(row, 6).toString());
				acctype.setText(dtm.getValueAt(row, 7).toString());
				
				
			}
		});
		scrollPane.setViewportView(table);
	}
}
