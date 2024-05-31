import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RentalSystem implements ActionListener{
	ArrayList<Furniture> arr_fur = new ArrayList<Furniture>();
	ArrayList<Member> arr_mem = new ArrayList<Member>();
	int ID = 0;
	private JLabel label;
	JPanel cardPanel;
    CardLayout layout;
    JPasswordField pass = new JPasswordField(20);
    JTextField id = new JTextField(5);
    JTextField fur_name = new JTextField(20);
    JTextField fur_num = new JTextField(10);
    JTextField fur_cost = new JTextField(10);
    JTextField mem_name = new JTextField(20);
    JTextField fur_name1 = new JTextField(20);
    JTextField id1 = new JTextField(5);
    JTextField fur_name2 = new JTextField(20);
    JTextField all_num = new JTextField(20);
    JTextField fur_name3 = new JTextField(20);
    JTextField id2 = new JTextField(5);
    JTextField fur_name4 = new JTextField(20);
    JTextField fur_num1 = new JTextField(10);
    JTextField fur_name5 = new JTextField(20);
    JTextField fur_num2 = new JTextField(10);
    String pass_answer = "abcd";
    int identification;
	
	public Component createComponents() {
		label = new JLabel("Members enter your ID and clerks enter your password.");
		
		//clerk or member 
		JButton Clerk = new JButton("Clerk");
		Clerk.addActionListener(this);
		Clerk.setActionCommand("Clerk");
		
		JButton Member = new JButton("Member");
		Member.addActionListener(this);
		Member.setActionCommand("Member");
	    
		//clerk's button
		JButton Add_fur = new JButton("Add Furniture");
		Add_fur.addActionListener(this);
		Add_fur.setActionCommand("Add_fur");
		
		JButton Add_mem = new JButton("Add Member");
		Add_mem.addActionListener(this);
		Add_mem.setActionCommand("Add_mem");
		
		JButton Remove_fur = new JButton("Remove Furniture");
		Remove_fur.addActionListener(this);
		Remove_fur.setActionCommand("Remove_fur");
		
		JButton Remove_mem = new JButton("Remove Member");
		Remove_mem.addActionListener(this);
		Remove_mem.setActionCommand("Remove_mem");
		
		JButton Modify_fur = new JButton("Modify Furniture");
		Modify_fur.addActionListener(this);
		Modify_fur.setActionCommand("Modify_fur");
		
		JButton Show_fur = new JButton("Show Furniture");
		Show_fur.addActionListener(this);
		Show_fur.setActionCommand("Show_fur");
		
		JButton Show_mem = new JButton("Show Member");
		Show_mem.addActionListener(this);
		Show_mem.setActionCommand("Show_mem");
		
		//member's button
		JButton Rent = new JButton("Rental");
		Rent.addActionListener(this);
		Rent.setActionCommand("Rent");
		
		JButton Return = new JButton("Return");
		Return.addActionListener(this);
		Return.setActionCommand("Return");
		
		JButton mem_furview = new JButton("View Rental Status");
		mem_furview.addActionListener(this);
		mem_furview.setActionCommand("mem_furview");
		
		JButton mem_memview = new JButton("View Your Information");
		mem_memview.addActionListener(this);
		mem_memview.setActionCommand("mem_memview");
		
		//first panel
		JPanel panel_first = new JPanel();
		panel_first.add(label);
		panel_first.add(Clerk);
		panel_first.add(Member);
		
		//clerk's first panel
		JPanel panel_clerk = new JPanel();
		panel_clerk.add(new JLabel("Please enter your password."));
		panel_clerk.add(pass);
		JButton cl_OK = new JButton("OK");
		cl_OK.addActionListener(this);
		cl_OK.setActionCommand("cl_OK");
		panel_clerk.add(cl_OK);
		JButton cl_back = new JButton("Back");
		cl_back.addActionListener(this);
		cl_back.setActionCommand("cl_back");
		panel_clerk.add(cl_back);
        
        //member's first panel
        JPanel panel_member = new JPanel();
        panel_member.add(new JLabel("Please enter your ID."));
        panel_member.add(id);
        JButton mem_OK = new JButton("OK");
		mem_OK.addActionListener(this);
		mem_OK.setActionCommand("mem_OK");
		panel_member.add(mem_OK);
		JButton mem_back = new JButton("Back");
        mem_back.addActionListener(this);
        mem_back.setActionCommand("mem_back");
        panel_member.add(mem_back);
        
        //clerk panel
        JPanel clerk = new JPanel();
        clerk.add(Add_fur);
        clerk.add(Add_mem);
        clerk.add(Remove_fur);
        clerk.add(Remove_mem);
        clerk.add(Modify_fur);
        clerk.add(Show_fur);
        clerk.add(Show_mem);
        JButton cl_cl_back = new JButton("Back");
		cl_cl_back.addActionListener(this);
		cl_cl_back.setActionCommand("cl_cl_back");
		clerk.add(cl_cl_back);
        
		//member panel
        JPanel member = new JPanel();
        member.add(Rent);
        member.add(Return);
        member.add(mem_furview);
        member.add(mem_memview);
        JButton mem_mem_back = new JButton("Back");
        mem_mem_back.addActionListener(this);
        mem_mem_back.setActionCommand("mem_mem_back");
        member.add(mem_mem_back);
        
        JPanel panel_Add_fur = new JPanel();
        panel_Add_fur.add(new JLabel("Please enter furniture name"));
        panel_Add_fur.add(fur_name);
        panel_Add_fur.add(new JLabel("Please enter the number of pieces of furniture"));
        panel_Add_fur.add(fur_num);
        panel_Add_fur.add(new JLabel("Please enter furniture's cost"));
        panel_Add_fur.add(fur_cost);
        JButton cl_add_OK = new JButton("OK");
		cl_add_OK.addActionListener(this);
		cl_add_OK.setActionCommand("cl_add_OK");
		panel_Add_fur.add(cl_add_OK);
		JButton cl_add_back = new JButton("Back");
		cl_add_back.addActionListener(this);
		cl_add_back.setActionCommand("cl_add_back");
		panel_Add_fur.add(cl_add_back);
        
        JPanel panel_Add_mem = new JPanel();
        panel_Add_mem.add(new JLabel("Please enter member name"));
        panel_Add_mem.add(mem_name);
        JButton cl_add_mem_OK = new JButton("OK");
		cl_add_mem_OK.addActionListener(this);
		cl_add_mem_OK.setActionCommand("cl_add_mem_OK");
		panel_Add_mem.add(cl_add_mem_OK);
		JButton cl_add_mem_back = new JButton("Back");
		cl_add_mem_back.addActionListener(this);
		cl_add_mem_back.setActionCommand("cl_add_mem_back");
		panel_Add_mem.add(cl_add_mem_back);
        
        JPanel panel_Remove_fur = new JPanel();
        panel_Remove_fur.add(new JLabel("Please enter furniture name"));
        panel_Remove_fur.add(fur_name1);
        JButton cl_remove_OK = new JButton("OK");
		cl_remove_OK.addActionListener(this);
		cl_remove_OK.setActionCommand("cl_remove_OK");
		panel_Remove_fur.add(cl_remove_OK);
		JButton cl_remove_back = new JButton("Back");
		cl_remove_back.addActionListener(this);
		cl_remove_back.setActionCommand("cl_remove_back");
		panel_Remove_fur.add(cl_remove_back);
        
        JPanel panel_Remove_mem = new JPanel();
        panel_Remove_mem.add(new JLabel("Please enter member ID"));
        panel_Remove_mem.add(id1);
        JButton cl_remove_mem_OK = new JButton("OK");
		cl_remove_mem_OK.addActionListener(this);
		cl_remove_mem_OK.setActionCommand("cl_remove_mem_OK");
		panel_Remove_mem.add(cl_remove_mem_OK);
		JButton cl_remove_mem_back = new JButton("Back");
		cl_remove_mem_back.addActionListener(this);
		cl_remove_mem_back.setActionCommand("cl_remove_mem_back");
		panel_Remove_mem.add(cl_remove_mem_back);
        
        JPanel panel_Modify_fur = new JPanel();
        panel_Modify_fur.add(new JLabel("Please enter furniture name"));
        panel_Modify_fur.add(fur_name2);
        panel_Modify_fur.add(new JLabel("Please enter the number of pieces of furniture after the change"));
        panel_Modify_fur.add(all_num);
        JButton cl_modify_OK = new JButton("OK");
		cl_modify_OK.addActionListener(this);
		cl_modify_OK.setActionCommand("cl_modify_OK");
		panel_Modify_fur.add(cl_modify_OK);
		JButton cl_modify_back = new JButton("Back");
		cl_modify_back.addActionListener(this);
		cl_modify_back.setActionCommand("cl_modify_back");
		panel_Modify_fur.add(cl_modify_back);
        
        JPanel panel_show_fur = new JPanel();
        panel_show_fur.add(new JLabel("Please enter furniture name"));
        panel_show_fur.add(fur_name3);
        JButton cl_show_OK = new JButton("OK");
		cl_show_OK.addActionListener(this);
		cl_show_OK.setActionCommand("cl_show_OK");
		panel_show_fur.add(cl_show_OK);
		JButton cl_show_back = new JButton("Back");
		cl_show_back.addActionListener(this);
		cl_show_back.setActionCommand("cl_show_back");
		panel_show_fur.add(cl_show_back);
        
        JPanel panel_show_mem = new JPanel();
        panel_show_mem.add(new JLabel("Please enter member's ID"));
        panel_show_mem.add(id2);
        JButton cl_show_mem_OK = new JButton("OK");
		cl_show_mem_OK.addActionListener(this);
		cl_show_mem_OK.setActionCommand("cl_show_mem_OK");
		panel_show_mem.add(cl_show_mem_OK);
		JButton cl_show_mem_back = new JButton("Back");
		cl_show_mem_back.addActionListener(this);
		cl_show_mem_back.setActionCommand("cl_show_mem_back");
		panel_show_mem.add(cl_show_mem_back);
        
        JPanel panel_Rent = new JPanel();
        panel_Rent.add(new JLabel("Please enter the name of the furniture you wish to rent"));
        panel_Rent.add(fur_name4);
        panel_Rent.add(new JLabel("Please enter the number of pieces of furniture"));
        panel_Rent.add(fur_num1);
        JButton mem_rent_OK = new JButton("OK");
		mem_rent_OK.addActionListener(this);
		mem_rent_OK.setActionCommand("mem_rent_OK");
		panel_Rent.add(mem_rent_OK);
		JButton mem_rent_back = new JButton("Back");
		mem_rent_back.addActionListener(this);
		mem_rent_back.setActionCommand("mem_rent_back");
		panel_Rent.add(mem_rent_back);
        
        JPanel panel_Return = new JPanel();
        panel_Return.add(new JLabel("Please enter the name of the furniture you wish to return"));
        panel_Return.add(fur_name5);
        panel_Return.add(new JLabel("Please enter the number of pieces of furniture"));
        panel_Return.add(fur_num2);
        JButton mem_return_OK = new JButton("OK");
		mem_return_OK.addActionListener(this);
		mem_return_OK.setActionCommand("mem_return_OK");
		panel_Return.add(mem_return_OK);
		JButton mem_return_back = new JButton("Back");
		mem_return_back.addActionListener(this);
		mem_return_back.setActionCommand("mem_return_back");
		panel_Return.add(mem_return_back);
        
        JPanel panel_mem_furview = new JPanel();
        JButton mem_furview_back = new JButton("Back");
		mem_furview_back.addActionListener(this);
		mem_furview_back.setActionCommand("mem_furview_back");
		panel_mem_furview.add(mem_furview_back);
        
        JPanel panel_mem_memview = new JPanel();
		JButton mem_memview_back = new JButton("Back");
		mem_memview_back.addActionListener(this);
		mem_memview_back.setActionCommand("mem_memview_back");
		panel_mem_memview.add(mem_memview_back);
        
        //cardPanel
        cardPanel = new JPanel();
        layout = new CardLayout();
        cardPanel.setLayout(layout);
        
        cardPanel.add(panel_first, "panel_first");
        cardPanel.add(panel_clerk, "panel_clerk");
        cardPanel.add(panel_member, "panel_member");
        cardPanel.add(clerk, "clerk");
        cardPanel.add(member, "member");
        cardPanel.add(panel_Add_fur, "panel_Add_fur");
        cardPanel.add(panel_Add_mem, "panel_Add_mem");
        cardPanel.add(panel_Remove_fur, "panel_Remove_fur");
        cardPanel.add(panel_Remove_mem, "panel_Remove_mem");
        cardPanel.add(panel_Modify_fur, "panel_Modify_fur");
        cardPanel.add(panel_show_fur, "panel_show_fur");
        cardPanel.add(panel_show_mem, "panel_show_mem");
        cardPanel.add(panel_Rent, "panel_Rent");
        cardPanel.add(panel_Return, "panel_Return");
        cardPanel.add(panel_mem_furview, "panel_mem_furview");
        cardPanel.add(panel_mem_memview, "panel_mem_memview");
        
        return cardPanel;
	}
	
	public void actionPerformed(ActionEvent e){
	    String cmd = e.getActionCommand();
	    
	    if(cmd.equals("Clerk")){
	    	layout.show(cardPanel, "panel_clerk");
	    }else if(cmd.equals("Member")){
	    	layout.show(cardPanel, "panel_member");
	    }else if(cmd.equals("cl_OK")) {
	    	char[] password = pass.getPassword();
	    	String passwordstr = new String(password);
	    	if(passwordstr.equals(pass_answer)) {
	    		layout.show(cardPanel, "clerk");
	    	}
	    }else if(cmd.equals("mem_OK")) {
	    	identification = Integer.parseInt(id.getText());
	    	if(identification == 0 || (identification < ID && identification >= 0)) {
	    		layout.show(cardPanel, "member");
	    	}
	    }else if(cmd.equals("cl_back") || cmd.equals("mem_back") || cmd.equals("cl_cl_back") || cmd.equals("mem_mem_back")) {
	    	layout.show(cardPanel, "panel_first");
	    }else if(cmd.equals("Add_fur")) {
	    	layout.show(cardPanel, "panel_Add_fur");
	    }else if(cmd.equals("cl_add_OK")) {
		    cl_furAdd(fur_name.getText(), Integer.parseInt(fur_num.getText()), Integer.parseInt(fur_cost.getText()));
	    }else if(cmd.equals("cl_add_back")) {
	    	layout.show(cardPanel, "clerk");
	    }else if(cmd.equals("Add_mem")) {
	    	layout.show(cardPanel, "panel_Add_mem");
	    }else if(cmd.equals("cl_add_mem_OK")) {
	    	JFrame frame = new JFrame("Rental System");
	    	Component contents = cl_memAdd(mem_name.getText());
	    	frame.getContentPane().add(contents, BorderLayout.CENTER);
	    	
	    	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    	frame.pack();
	    	frame.setVisible(true);
	    }else if(cmd.equals("cl_add_mem_back")) {
	    	layout.show(cardPanel, "clerk");
	    }else if(cmd.equals("Remove_fur")) {
	    	layout.show(cardPanel, "panel_Remove_fur");
	    }else if(cmd.equals("cl_remove_OK")) {
	    	cl_furDelete(fur_name1.getText());
	    }else if(cmd.equals("cl_remove_back")) {
	    	layout.show(cardPanel, "clerk");
	   	}else if(cmd.equals("Remove_mem")) {
	    	layout.show(cardPanel, "panel_Remove_mem");
	   	}else if(cmd.equals("cl_remove_mem_OK")) {
	    	cl_memDelete(Integer.parseInt(id1.getText()));
	   	}else if(cmd.equals("cl_remove_mem_back")) {
	    	layout.show(cardPanel, "clerk");
	    }else if(cmd.equals("Modify_fur")) {
	    	layout.show(cardPanel, "panel_Modify_fur");
	    }else if(cmd.equals("cl_modify_OK")) {
	    	cl_furModify(fur_name2.getText(), Integer.parseInt(all_num.getText()));
	    }else if(cmd.equals("cl_modify_back")) {
	    	layout.show(cardPanel, "clerk");
	    }else if(cmd.equals("Show_fur")) {
	    	layout.show(cardPanel, "panel_show_fur");
	    }else if(cmd.equals("cl_show_OK")) {
	    	JFrame frame = new JFrame("Rental System");
	    	Component contents = cl_furView(fur_name3.getText());
	    	frame.getContentPane().add(contents, BorderLayout.CENTER);
	    	
	    	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    	frame.pack();
	    	frame.setVisible(true);
	    }else if(cmd.equals("cl_show_back")) {
	    	layout.show(cardPanel, "clerk");
	    }else if(cmd.equals("Show_mem")) {
	    	layout.show(cardPanel, "panel_show_mem");
	    }else if(cmd.equals("cl_show_mem_OK")) {
	    	JFrame frame = new JFrame("Rental System");
	    	Component contents = cl_memView(Integer.parseInt(id2.getText()));
	    	frame.getContentPane().add(contents, BorderLayout.CENTER);
	    	
	    	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    	frame.pack();
	    	frame.setVisible(true);
	    }else if(cmd.equals("cl_show_mem_back")) {
	    	layout.show(cardPanel, "clerk");
	    }else if(cmd.equals("Rent")) {
	    	layout.show(cardPanel, "panel_Rent");
	    }else if(cmd.equals("mem_rent_OK")) {
	    	JFrame frame = new JFrame("Rental System");
	    	Component contents = mem_rent(Integer.parseInt(id.getText()), fur_name4.getText(), Integer.parseInt(fur_num1.getText()));
	    	frame.getContentPane().add(contents, BorderLayout.CENTER);
	    	
	    	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    	frame.pack();
	    	frame.setVisible(true);
	    }else if(cmd.equals("mem_rent_back")) {
	    	layout.show(cardPanel, "member");
	    }else if(cmd.equals("Return")) {
	    	layout.show(cardPanel, "panel_Return");
	    }else if(cmd.equals("mem_return_OK")) {
	    	JFrame frame = new JFrame("Rental System");
	    	Component contents = mem_return(Integer.parseInt(id.getText()), fur_name5.getText(), Integer.parseInt(fur_num2.getText()));
	    	frame.getContentPane().add(contents, BorderLayout.CENTER);
	    	
	    	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    	frame.pack();
	    	frame.setVisible(true);
	    }else if(cmd.equals("mem_return_back")) {
	    	layout.show(cardPanel, "member");
	    }else if(cmd.equals("mem_furview")) {
	    	layout.show(cardPanel, "panel_mem_furview");
	    	JFrame frame = new JFrame("Rental System");
	    	Component contents = mem_furView();
	    	frame.getContentPane().add(contents, BorderLayout.CENTER);
	    	
	    	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    	frame.pack();
	    	frame.setVisible(true);
	    }else if(cmd.equals("mem_furview_back")) {
	    	layout.show(cardPanel, "member");
	    }else if(cmd.equals("mem_memview")) {
	    	layout.show(cardPanel, "panel_mem_memview");
	    	JFrame frame = new JFrame("Rental System");
	    	Component contents = mem_memView(Integer.parseInt(id.getText()));;
	    	frame.getContentPane().add(contents, BorderLayout.CENTER);
	    	
	    	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    	frame.pack();
	    	frame.setVisible(true);
	    }else if(cmd.equals("mem_memview_back")) {
	    	layout.show(cardPanel, "member");
	    }
	}
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("RentalSystem");
		RentalSystem app = new RentalSystem();
		Component contents = app.createComponents();
		frame.getContentPane().add(contents, BorderLayout.CENTER);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.pack();
		frame.setVisible(true);
	}
	
	public static String upperCaseFirst(String val) {
		char[] arr = val.toCharArray();
	    arr[0] = Character.toUpperCase(arr[0]);
	    return new String(arr);
	}
	
	public void cl_furAdd(String name, int n, int cost) {
		Furniture f = new Furniture();
		f.furname = name;
		f.allnum = n;
		f.num = 0;
		f.cost = cost;
		arr_fur.add(f);
	}
	
	public void cl_furDelete(String name) {
		int index = 0;
		int flag = 0;
		for(Furniture s: arr_fur) {
			if(s.furname.equals(name)) {
				index = arr_fur.indexOf(s);
				flag = 1;
			}
		}
		if(flag == 1) arr_fur.remove(index);
	}
	
	public JPanel cl_furView(String name) {
		JPanel pane = new JPanel();
		int flag = 0;
		for(Furniture s: arr_fur) {
			if(s.furname.equals(name)) {
				pane.add(new JLabel(s.furname));
				pane.add(new JLabel("Cost of this furniture: " + s.cost));
				pane.add(new JLabel("Number of possessions: " + s.allnum));
				pane.add(new JLabel("Number of lending: " + s.num));
				flag = 1;
			}
			if(s.num > 0) {
				for(Member m: arr_mem) {
					for(FOM f: m.furniture) {
						if(f.furname.equals(name)) {
							pane.add(new JLabel(m.name + ": "));
							pane.add(new JLabel(String.valueOf(f.num)));
						}
					}
				}
			}
		}
		if(flag == 0) {
			pane.add(new JLabel("The furniture you searched for does not exist."));
		}
		return pane;
	}
	
	public void cl_furModify(String name, int allnum) {
		for(Furniture s: arr_fur) {
			if(s.furname.equals(name)) {
				s.allnum = allnum;
			}
		}
	}
	
	public JPanel cl_memAdd(String name) {
		JPanel pane = new JPanel();
		Member m = new Member();
		m.name = name;
		m.ID = ID;
		arr_mem.add(m);
		pane.add(new JLabel(m.name + "'s ID is " + m.ID));
		ID++;
		return pane;
	}
	
	public void cl_memDelete(int id) {
		int index = 0;
		int flag = 0;
		for(Member m: arr_mem) {
			if(m.ID == id) {
				index = arr_mem.indexOf(m);
				flag = 1;
			}
		}
		if(flag == 1) arr_mem.remove(index);
	}
	
	public JPanel cl_memView(int id) {
		JPanel pane = new JPanel();
		int flag = 0;
		for(Member m: arr_mem) {
			if(m.ID == id) {
				pane.add(new JLabel(m.name));
				pane.add(new JLabel(String.valueOf(m.ID)));
				for(FOM f: m.furniture) {
					pane.add(new JLabel(f.furname + ": "));
					pane.add(new JLabel(String.valueOf(f.num)));
				}
				flag = 1;
			}
		}
		if(flag == 0) {
			pane.add(new JLabel("The member you searched for does not exist."));
		}
		return pane;
	}
	
	public JPanel mem_rent(int id, String name, int n) {
		JPanel pane = new JPanel();
		int flag1 = 0;
		for(Furniture s: arr_fur) {
			if(s.furname.equals(name)) {
				flag1 = 1;
				if(s.allnum < n) {
					pane.add(new JLabel("You can rent " + name + " up to " + s.allnum + "."));
					return pane;
				}
				s.allnum -= n;
				s.num += n;
			}
		}
		if(flag1 == 0) {
			pane.add(new JLabel(upperCaseFirst(name) + " doesn't exist."));
			return pane;
		}
		
		for(Member m: arr_mem) {
			if(m.ID == id) {
				int flag2 = 0;
				for(FOM x: m.furniture) {
					if(x.furname.equals(name)) {
						x.num += n;
						flag2 = 1;
						break;
					}
				}
				if(flag2 == 0) {
					FOM fom = new FOM();
					fom.furname = name;
					fom.num = n;
					m.furniture.add(fom);
				}
			}
		}
		pane.add(new JLabel("You have rented " + n + " " + name + "s."));
		return pane;
	}
	
	public JPanel mem_return(int id, String name, int n) {
		JPanel pane = new JPanel();
		for(Member m: arr_mem) {
			if(m.ID == id) {
				int flag = 0;
				for(FOM x: m.furniture) {
					if(x.furname.equals(name)) {
						flag = 1;
						if(n > x.num) {
							pane.add(new JLabel("You don't have " + n + " " + name + "s."));
							return pane;
						}
					}
				}
				if(flag == 0) {
					pane.add(new JLabel("You have not rented " + name + "s."));
					return pane;
				}
			}
		}
		
		for(Furniture s: arr_fur) {
			if(s.furname.equals(name)) {
				s.allnum += n;
				s.num -= n;
			}
		}
		
		for(Member m: arr_mem) {
			int flag = 0;
			if(m.ID == id) {
				int index = 0;
				for(FOM x: m.furniture) {
					if(x.furname.equals(name)) {
						x.num -= n;
						if(x.num == 0) {
							flag = 1;
							index = m.furniture.indexOf(x);
						}
					}
				}
				if(flag == 1) m.furniture.remove(index);
			}
		}
		pane.add(new JLabel("You have returned " + n + " " + name + "s."));
		return pane;
	}
	
	public JPanel mem_furView() {
		JPanel pane = new JPanel();
		int flag = 0;
		for(Furniture s: arr_fur) {
			pane.add(new JLabel(upperCaseFirst(s.furname)));
			pane.add(new JLabel("Cost of this furniture: " + s.cost));
			pane.add(new JLabel("Number of possessions: " + s.allnum));
			flag = 1;
		}
		if(flag == 0) {
			pane.add(new JLabel("There is no furniture available for rent."));
		}
		return pane;
	}
	
	public JPanel mem_memView(int id) {
		JPanel pane = new JPanel();
		int flag = 0;
		for(Member m: arr_mem) {
			if(m.ID == id) {
				pane.add(new JLabel(m.name));
				pane.add(new JLabel(String.valueOf(m.ID)));
				for(FOM f: m.furniture) {
					pane.add(new JLabel(upperCaseFirst(f.furname) + ": "));
					pane.add(new JLabel(String.valueOf(f.num)));
				}
				flag = 1;
			}
		}
		if(flag == 0) {
			pane.add(new JLabel("The entered ID does not exist."));
		}
		return pane;
	}
}