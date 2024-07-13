package Final_project_mvc;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;


public class Login_controll {
	private Login_view view;
    private Login_model model;

    public Login_controll(Login_view view, Login_model model) {
        this.view = view;
        this.model = model;
        
        this.view.addLoginListener(new Login_class());
        this.view.addRegisterListener(new Register_class());
        this.view.closepanllistner(new closepanel());
        this.view.loginbuttonlistner(new loginbuttonlistner());
        this.view.crejlabellistner(new crejlabellistner());
        this.view.backbuttonlistner(new backbuttonlistner());
        this.view.crebuttonlistner(new crebuttonlistner());
    }
    

    class Login_class implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String user_name = view.login_Username();
            String password_ = view.login_password();
            if(user_name.isEmpty()|| password_.isEmpty()||
            		user_name.equals("USER NAME") || 
            		password_.equals("PASSWORD")) {
                JOptionPane.showMessageDialog(null, "Please fill in all fields.");
            }
            else {
            	boolean isAuthenticated = model.login(user_name, password_);
                if (isAuthenticated) {
                	Home homeWindow = new Home(user_name); 
                    homeWindow.searchnotifi();
                    view.dispose();             
                }
                else {
                    JOptionPane.showMessageDialog(view, "Error: User not found!", "Error", JOptionPane.ERROR_MESSAGE);
                }
			}
            
        }
    }

    class Register_class implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String getusername = view.create_username();
            String getpassword = view.create_password();
            String getemail = view.create_email();
            String getpetType = view.create_petType();
            String getpetName = view.create_petname();
            
            if (getusername.isEmpty() || 
                    getpassword.isEmpty() || 
                    getemail.isEmpty() || 
                    getpetType.isEmpty() || 
                    getusername.equals("USER NAME") || 
                    getpassword.equals("PASSWORD") || 
                    getemail.equals("EMAIL") ||
                    getpetName.equals("PET NAME")) {
                        
                    JOptionPane.showMessageDialog(null, "Please fill in all fields.");
            } else {
            	
            
            boolean isRegistered = model.register(getusername, getpassword, getemail, getpetType, getpetName);
            if (isRegistered) {
                JOptionPane.showMessageDialog(view, "Registration successful.");
                
                try {
        	        Thread.sleep(1000); 
        	    } catch (InterruptedException e2) {
        	        e2.printStackTrace(); 
        	    }
                Home homeWindow = new Home(getusername); 
                homeWindow.searchnotifi();
                view.dispose();
            }else {
                JOptionPane.showMessageDialog(view, "user name alreay register", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    }
    class closepanel implements MouseListener {
        public void mouseClicked(MouseEvent e) { 
        	view.dispose();
        }
        public void mousePressed(MouseEvent e) {
        	
        }
        public void mouseReleased(MouseEvent e) {
        	
        }
        public void mouseEntered(MouseEvent e) {
        	
        }
        public void mouseExited(MouseEvent e) {
        	
        }
    }
    
    class loginbuttonlistner implements MouseListener{
    	public void mouseClicked(MouseEvent e) {
    		
    	}
        public void mousePressed(MouseEvent e) {
        	
        }
        public void mouseReleased(MouseEvent e) {
        	
        }
        public void mouseEntered(MouseEvent e) {
        	view.login_button.setBackground(new Color(142, 196, 210));
        }
        public void mouseExited(MouseEvent e) {
        	view.login_button.setBackground(new Color(142, 196, 210));
        	view.login_button.setForeground(Color.darkGray);    
        	
        }
    }
    class crejlabellistner implements MouseListener{
       public void mouseClicked(MouseEvent e) {
         view.login_2.setVisible(false);
         view.login_3.setVisible(true);		
    	}
        public void mousePressed(MouseEvent e) {
        	
        }
        public void mouseReleased(MouseEvent e) {
        	
        }
        public void mouseEntered(MouseEvent e) {

        }
        public void mouseExited(MouseEvent e) {
               	
        }
    }
    class backbuttonlistner implements MouseListener{
    	 public void mouseClicked(MouseEvent e) {
              view.login_3.setVisible(false);
              view.login_2.setVisible(true);
        	}
            public void mousePressed(MouseEvent e) {
            	
            }
            public void mouseReleased(MouseEvent e) {
            	
            }
            public void mouseEntered(MouseEvent e) {

            }
            public void mouseExited(MouseEvent e) {
                   	
            }
    }
    class crebuttonlistner implements MouseListener{
	         public void mouseClicked(MouseEvent e) {
	    		
	    	}
	        public void mousePressed(MouseEvent e) {
	        	
	        }
	        public void mouseReleased(MouseEvent e) {
	        	
	        }
	        public void mouseEntered(MouseEvent e) {
	                    view.creButton.setBackground(new Color(142, 196, 210));
	        }
	        public void mouseExited(MouseEvent e) {
	                  view.creButton.setBackground(new Color(142, 196, 210));
	                  view.creButton.setForeground(Color.darkGray);     	
	        }
    }
  
}
