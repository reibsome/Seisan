import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.sql.*;
import com.microsoft.sqlserver.jdbc.*;

class ContactUs {
	JTextField firstName;
	JTextField lastName;
	JTextField email;
	JTextField zip;
	JTextField comments;
	JRadioButton zero, one, two, three, four, five, six, seven, eight, nine, ten;
	JButton ok, cancel;
	JFrame frame;
	
	//let's make our action listener
	//when ok button is clicked, we collect info of the user
	class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			if(ev.getSource()==ok) {
			//let's collect information and put them into a string
			String info;
			info = "First Name= " + firstName.getText() + "\n";
			info += "Last Name= " + lastName.getText() + "\n";
			info += "Email= " + email.getText() + "\n";
			info += "Zip Code= " + zip.getText() + "\n";
			info += "Comments= " + comments.getText() + "\n";
			
			info += "Satisfaction= ";
			if(zero.isSelected()) {
				info += "Zero \n";
			} else if(one.isSelected()) {
				info += "One \n";
			} else if(two.isSelected()) {
				info += "two \n";
			} else if(three.isSelected()) {
				info += "three \n";
			} else if(four.isSelected()) {
				info += "four \n";
			} else if(five.isSelected()) {
				info += "five \n";
			} else if(six.isSelected()) {
				info += "six \n";
			} else if(seven.isSelected()) {
				info += "seven \n";
			} else if(eight.isSelected()) {
				info += "eight \n";
			} else if(nine.isSelected()) {
				info += "nine \n";
			} else if(ten.isSelected()) {
				info += "ten \n";
			} else {
				info += "Unknown \n";
			}
						
			//System.out.println(info);
			
			int resp = JOptionPane.showConfirmDialog(frame, 
				"Is this information correct?\n" + info,
				"User info confirmation",
				JOptionPane.YES_NO_OPTION);
			
			if(resp == JOptionPane.YES_OPTION) {
				frame.dispose();
			} else {
				//do nothing. go back to the user info entry
			}
			
			} else if(ev.getSource()==cancel) {
				frame.dispose(); //exit the app
			}
		}
	}

	
	ContactUs() {
		frame = new JFrame("User Information");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(8, 1));
		
		JPanel[] panels = new JPanel[8];
		for(int i=0; i<8; ++i) {
			panels[i] = new JPanel();
			frame.add(panels[i]); //add each frame from top to bottom
		}
	
	
		JLabel label1 = new JLabel ("Contact Us");
		panels[0].add(label1);
	
		JLabel label2 = new JLabel ("First Name");
		firstName = new JTextField(18);  //18 is the width
		panels[1].add(label2);
		panels[1].add(firstName);
		
	
		JLabel label3 = new JLabel("Last Name");
		lastName = new JTextField(18);
		panels[2].add(label3);
		panels[2].add(lastName);
		

		JLabel label4 = new JLabel("Email");
		email = new JTextField(18);
		panels[3].add(label4);
		panels[3].add(email);
		
		JLabel label5 = new JLabel ("Zip Code");
		zip = new JTextField(18);  //18 is the width
		panels[4].add(label5);
		panels[4].add(zip);
		
	
		JLabel label6 = new JLabel ("Satisfaction");
		one = new JRadioButton("1");
		two = new JRadioButton("2");
		three = new JRadioButton("3");
		four = new JRadioButton("4");
		five = new JRadioButton("5");
		six = new JRadioButton("6");
		seven = new JRadioButton("7");
		eight = new JRadioButton("8");
		nine = new JRadioButton("9");
		ten = new JRadioButton("10");
		panels[5].add(label6);
		panels[5].add(one);
		panels[5].add(two);
		panels[5].add(three);
		panels[5].add(four);
		panels[5].add(five);
		panels[5].add(six);
		panels[5].add(seven);
		panels[5].add(eight);
		panels[5].add(nine);
		panels[5].add(ten);
		
		
		//put these radio buttons into the same group
		ButtonGroup group = new ButtonGroup();
		group.add(one);
		group.add(two);
		group.add(three);
		group.add(four);
		group.add(five);
		group.add(six);
		group.add(seven);
		group.add(eight);
		group.add(nine);
		group.add(ten);
		
		JLabel label7 = new JLabel ("Comments");
		comments = new JTextField(18);  //18 is the width
		panels[6].add(label7);
		panels[6].add(comments);
		
		
		//panel 8 with Ok and Cancel buttons
		ok = new JButton("OK");
		cancel = new JButton("Cancel");
		panels[7].add(ok);
		panels[7].add(cancel);
		
		MyActionListener listener = new MyActionListener();
		ok.addActionListener(listener);
		cancel.addActionListener(listener);
		
		frame.setSize(500,700);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		
		try {
		String connectionString = "jdbc:sqlserver://reibsome.database.windows.net:1433;database=contacts" + ";" + "user=reibsome@reibsome" + ";" +
			"password={jAer121314*}" + ";" + "encrypt=true" + ";" + "trustServerCertificate=false" + ";" +
			"hostNameInCertificate=*.database.windows.net" + ";" + "loginTimeout=30";
	
		}
		
		catch (SQLException err) {
		System.out.println(err.getMessage()); }
		
		new ContactUs();
	}
}