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
import java.awt.Color;
import javax.swing.border.MatteBorder;
import java.awt.Font;
import javax.swing.ImageIcon;

public class BankManagementSystem {

	private JFrame frmBankingManagementSystem;
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
	String header[]=new String[] {"FirstName","LastName","Age","Gender","Email","AccNO.","PhoneNO.","AccType"};
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BankManagementSystem window = new BankManagementSystem();
					window.frmBankingManagementSystem.setVisible(true);
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
		
		JLabel lblAcctype = new JLabel("Acc Type");
		lblAcctype.setFont(new Font("Poor Richard", Font.BOLD, 12));
		lblAcctype.setBounds(39, 275, 73, 14);
		frmBankingManagementSystem.getContentPane().add(lblAcctype);
		
		acctype = new JTextField();
		acctype.setFont(new Font("Adobe Fan Heiti Std B", Font.BOLD, 12));
		acctype.setForeground(new Color(255, 255, 255));
		acctype.setBackground(new Color(221, 160, 221));
		acctype.setColumns(10);
		acctype.setBounds(122, 274, 121, 20);
		frmBankingManagementSystem.getContentPane().add(acctype);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.setFont(new Font("Letter Gothic Std", Font.BOLD, 15));
		btnSearch.setBackground(new Color(255, 160, 122));
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
		btnSearch.setBounds(154, 354, 89, 23);
		frmBankingManagementSystem.getContentPane().add(btnSearch);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				refresh();
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Ivy Ng\\Pictures\\CaptureFSDF.PNG"));
		btnNewButton.setBounds(253, 29, 19, 20);
		frmBankingManagementSystem.getContentPane().add(btnNewButton);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBankingManagementSystem = new JFrame();
		frmBankingManagementSystem.setForeground(new Color(255, 255, 255));
		frmBankingManagementSystem.setBackground(new Color(255, 255, 255));
		frmBankingManagementSystem.getContentPane().setBackground(new Color(255, 192, 203));
		frmBankingManagementSystem.setTitle("Banking Management System");
		frmBankingManagementSystem.setBounds(100, 100, 938, 438);
		frmBankingManagementSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBankingManagementSystem.getContentPane().setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Poor Richard", Font.BOLD, 12));
		lblFirstName.setBounds(39, 30, 73, 14);
		frmBankingManagementSystem.getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Poor Richard", Font.BOLD, 12));
		lblLastName.setBounds(39, 65, 73, 14);
		frmBankingManagementSystem.getContentPane().add(lblLastName);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Poor Richard", Font.BOLD, 12));
		lblAge.setBounds(39, 99, 73, 14);
		frmBankingManagementSystem.getContentPane().add(lblAge);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Poor Richard", Font.BOLD, 12));
		lblGender.setBounds(39, 135, 73, 14);
		frmBankingManagementSystem.getContentPane().add(lblGender);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Poor Richard", Font.BOLD, 12));
		lblEmail.setBounds(39, 170, 73, 14);
		frmBankingManagementSystem.getContentPane().add(lblEmail);
		
		JLabel lblAccnum = new JLabel("Acc NO.");
		lblAccnum.setFont(new Font("Poor Richard", Font.BOLD, 12));
		lblAccnum.setBounds(39, 205, 73, 14);
		frmBankingManagementSystem.getContentPane().add(lblAccnum);
		
		JLabel lblPhonenum = new JLabel("Phone NO.");
		lblPhonenum.setFont(new Font("Poor Richard", Font.BOLD, 12));
		lblPhonenum.setBounds(39, 240, 73, 14);
		frmBankingManagementSystem.getContentPane().add(lblPhonenum);
		
		firstname = new JTextField();
		firstname.setFont(new Font("Adobe Fan Heiti Std B", Font.BOLD, 12));
		firstname.setForeground(new Color(255, 255, 255));
		firstname.setBackground(new Color(221, 160, 221));
		firstname.setBounds(122, 29, 121, 20);
		frmBankingManagementSystem.getContentPane().add(firstname);
		firstname.setColumns(10);
		
		lastname = new JTextField();
		lastname.setFont(new Font("Adobe Fan Heiti Std B", Font.BOLD, 12));
		lastname.setForeground(new Color(255, 255, 255));
		lastname.setBackground(new Color(221, 160, 221));
		lastname.setColumns(10);
		lastname.setBounds(122, 64, 121, 20);
		frmBankingManagementSystem.getContentPane().add(lastname);
		
		age = new JTextField();
		age.setFont(new Font("Adobe Fan Heiti Std B", Font.BOLD, 12));
		age.setForeground(new Color(255, 255, 255));
		age.setBackground(new Color(221, 160, 221));
		age.setColumns(10);
		age.setBounds(122, 99, 121, 20);
		frmBankingManagementSystem.getContentPane().add(age);
		
		gender = new JTextField();
		gender.setFont(new Font("Adobe Fan Heiti Std B", Font.BOLD, 12));
		gender.setForeground(new Color(255, 255, 255));
		gender.setBackground(new Color(221, 160, 221));
		gender.setColumns(10);
		gender.setBounds(122, 134, 121, 20);
		frmBankingManagementSystem.getContentPane().add(gender);
		
		email = new JTextField();
		email.setFont(new Font("Adobe Fan Heiti Std B", Font.BOLD, 12));
		email.setForeground(new Color(255, 255, 255));
		email.setBackground(new Color(221, 160, 221));
		email.setColumns(10);
		email.setBounds(122, 169, 121, 20);
		frmBankingManagementSystem.getContentPane().add(email);
		
		accnum = new JTextField();
		accnum.setFont(new Font("Adobe Fan Heiti Std B", Font.BOLD, 12));
		accnum.setForeground(new Color(255, 255, 255));
		accnum.setBackground(new Color(221, 160, 221));
		accnum.setColumns(10);
		accnum.setBounds(122, 204, 121, 20);
		frmBankingManagementSystem.getContentPane().add(accnum);
		
		phnumber = new JTextField();
		phnumber.setFont(new Font("Adobe Fan Heiti Std B", Font.BOLD, 12));
		phnumber.setForeground(new Color(255, 255, 255));
		phnumber.setBackground(new Color(221, 160, 221));
		phnumber.setColumns(10);
		phnumber.setBounds(122, 239, 121, 20);
		frmBankingManagementSystem.getContentPane().add(phnumber);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setFont(new Font("Letter Gothic Std", Font.BOLD, 15));
		btnAdd.setBackground(new Color(127, 255, 212));
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
		btnAdd.setBounds(39, 320, 89, 23);
		frmBankingManagementSystem.getContentPane().add(btnAdd);
		
		JButton btnEdit = new JButton("EDIT");
		btnEdit.setFont(new Font("Letter Gothic Std", Font.BOLD, 15));
		btnEdit.setBackground(new Color(144, 238, 144));
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
		btnEdit.setBounds(154, 320, 89, 23);
		frmBankingManagementSystem.getContentPane().add(btnEdit);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setFont(new Font("Letter Gothic Std", Font.BOLD, 15));
		btnDelete.setBackground(new Color(240, 230, 140));
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
		btnDelete.setBounds(39, 354, 89, 23);
		frmBankingManagementSystem.getContentPane().add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(274, 25, 625, 340);
		frmBankingManagementSystem.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBorder(null);
		table.setBackground(new Color(127, 255, 212));
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
