package messageserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ShaftMaster
 */
public class ServerForm extends javax.swing.JFrame {

    /**
     * Creates new form ServerForm
     */
    public ServerForm() {
        super("Server"); //Label form
        initComponents(); //Initialise
        setLocationRelativeTo(null); //Center form
    }

    //Stores lines in message log
    static ArrayList log = new ArrayList();

    //Socket variables
    static ServerSocket ss;
    static Socket s;
    static DataInputStream din;
    static DataOutputStream dout;

    //Login status
    static boolean loggedIn = false;
    //Status of admin checkbox for adding users
    static boolean adminBoxChecked = false;

    //Housekeeping
    static String logAdmin = "logged in as Admin.";
    static String logUser = "logged in successfully.";
    static String logFail = "Incorrect username or password.";
    static String logoutMessage = "User logged out.";
    static String allUsers = "ADMIN- DISPLAYING ALL USERS: ";
    static String lineDivider = "----------------------------";

    //Create default users
    User user1 = new User("John", "pass1", false);
    User user2 = new User("Jane", "pass2", false);
    User user3 = new User("Joe", "pass3", false);
    User user4 = new User("Jill", "pass4", true); //Admin account

    //Clears login fields
    private void clearAddUserTextBoxes() {
        newUsernameTextField.setText("");
        newPasswordField.setText("");
    }

    //Refresh list
    private static void refreshList() {
        try {
            logList.setModel(new javax.swing.AbstractListModel<String>() {
                String[] a = (String[]) log.toArray(new String[log.size()]);

                public int getSize() {
                    return a.length;
                }

                public String getElementAt(int i) {
                    return a[i];
                }
            });
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Could not refresh list.",
                    "Display Failed",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    //Check if string is null or empty
    public static Boolean isNullOrEmpty(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        messageTextField = new javax.swing.JTextField();
        sendButton = new javax.swing.JButton();
        messageLogScrollPane = new javax.swing.JScrollPane();
        logList = new javax.swing.JList<>();
        newUsernameTextField = new javax.swing.JTextField();
        addUserButton = new javax.swing.JButton();
        usernameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        newPasswordField = new javax.swing.JPasswordField();
        adminCheckBox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        sendButton.setText("Send Message");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        logList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = {  };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        messageLogScrollPane.setViewportView(logList);

        addUserButton.setText("Add User");
        addUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserButtonActionPerformed(evt);
            }
        });

        usernameLabel.setText("Username");

        passwordLabel.setText("Password");

        newPasswordField.setPreferredSize(new java.awt.Dimension(15, 24));

        adminCheckBox.setText("Admin");
        adminCheckBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                adminCheckBoxItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(messageLogScrollPane)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(usernameLabel))
                            .addComponent(newUsernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(newPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(passwordLabel)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addUserButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                                .addComponent(adminCheckBox)
                                .addGap(32, 32, 32))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(messageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sendButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(messageLogScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(messageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sendButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(newUsernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(addUserButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameLabel)
                    .addComponent(passwordLabel)
                    .addComponent(adminCheckBox))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        try {
            //Send message text
            dout.writeUTF(messageTextField.getText().trim());
            //Clear text field
            messageTextField.setText("");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Could not send.",
                    "Login Failed",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_sendButtonActionPerformed

    private void addUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUserButtonActionPerformed
        //Check for null or empty values
        if (isNullOrEmpty(newUsernameTextField.getText()) == false
                && isNullOrEmpty(newPasswordField.getText()) == false) {
            //If admin checkbox is checked
            if (adminBoxChecked == true) {
                //Create user with admin status
                User user = new User(newUsernameTextField.getText(),
                        newPasswordField.getText(), true);
                //Display confirmation that user has been added
            log.add("Admin \"" + newUsernameTextField.getText() + "\" added.");
            } else {
                //Create regular user
                User user = new User(newUsernameTextField.getText(),
                        newPasswordField.getText(), false);
                //Display confirmation that user has been added
            log.add("User \"" + newUsernameTextField.getText() + "\" added.");
            }
            //Clear user-related text boxes
            clearAddUserTextBoxes();
            refreshList();
        } else {
            JOptionPane.showMessageDialog(null, "One or more fields empty.",
                    "Error",
                    JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_addUserButtonActionPerformed

    //Checkbox toggles admin status
    private void adminCheckBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_adminCheckBoxItemStateChanged
        if (evt.getSource() == adminCheckBox) {
            if (evt.getStateChange() == 1) { //If box checked
                adminBoxChecked = true;
            } else {
                adminBoxChecked = false;
            }
        }
    }//GEN-LAST:event_adminCheckBoxItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ServerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServerForm().setVisible(true);
            }
        });

        //Instantiate user class
        User user = new User();

        try {
            ss = new ServerSocket(1201);
            s = ss.accept();

            din = new DataInputStream(s.getInputStream());
            dout = new DataOutputStream(s.getOutputStream());

            while (true) {
                //Recieved message to string
                String msgin = din.readUTF();

                //If message is login attempt
                if (msgin.contains("::")) {

                    //Receive client logout request
                    if (msgin.equalsIgnoreCase("logout::") && loggedIn == true) {
                        //Reset login status
                        loggedIn = false;
                        //Display confirmation message on server side
                        log.add(logoutMessage);
                        //Send confirmation message to client side
                        dout.writeUTF(logoutMessage);
                        refreshList();
                        continue; //Restart while-loop
                    }

                    //Old method now redundant. Logout button disabled on client side.
                    if (loggedIn == true) {
                        dout.writeUTF("Please sign out first.");
                        continue;
                    }

                    //Split message into username and password
                    String[] userPass = msgin.split("::");
                    String usernameInput = userPass[0];
                    String passwordInput = String.valueOf(userPass[1].hashCode()); //Hash pasword

                    //Display output
                    log.add("*Client login attempt*");
                    log.add("Username: " + usernameInput);
                    log.add("Password: " + passwordInput);

                    //Check for user with matching username
                    User loginAttempt = user.searchUsers(User.getUsers(), usernameInput);

                    //If user exists
                    if (loginAttempt != null) {
                        //Check username and password (case sensitive)
                        if (((usernameInput.equals(loginAttempt.getUsername()))
                                && (passwordInput.equals(loginAttempt.getPassword())))) {

                            //Set login status
                            loggedIn = true;

                            //Check admin status
                            if ((loginAttempt.getAdmin() == true)) {
                                //Avoid repeating long concatenated string
                                String confirm = (loginAttempt.getUsername()
                                        + " " + logAdmin);
                                //Send confirmations to client
                                dout.writeUTF(confirm);
                                dout.writeUTF(lineDivider);

                                //Display output on server side
                                log.add(confirm);
                                log.add(lineDivider);

                                //Display users to client if logged in as admin
                                dout.writeUTF(allUsers); //Heading for user list

                                //Send user list to client
                                for (User user1 : User.getUsers()) {
                                    dout.writeUTF(user1.getUsername());
                                    dout.writeUTF(user1.getPassword());
                                }
                                dout.writeUTF(lineDivider); //Formatting
                                refreshList();
                            } else {
                                //Avoid repeating long concatenated string
                                String confirm = (loginAttempt.getUsername()
                                        + " " + logUser);
                                //Send confirmations to client
                                dout.writeUTF(confirm);
                                dout.writeUTF(lineDivider);

                                //Display output on server side
                                log.add(confirm);
                                log.add(lineDivider);

                                refreshList();
                            }
                        }
                    } else { //If login details incorrect
                        //Display output on server side
                        log.add(logFail);
                        log.add(lineDivider);

                        //Send confirmations to client
                        dout.writeUTF(logFail);
                        dout.writeUTF(lineDivider);

                        refreshList();
                    }
                } else { //If regular chat message
                    log.add(msgin); //Display message on server side
                    refreshList();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No clients connected.",
                    "No clients",
                    JOptionPane.ERROR_MESSAGE);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addUserButton;
    private javax.swing.JCheckBox adminCheckBox;
    private static javax.swing.JList<String> logList;
    private javax.swing.JScrollPane messageLogScrollPane;
    private javax.swing.JTextField messageTextField;
    private javax.swing.JPasswordField newPasswordField;
    private javax.swing.JTextField newUsernameTextField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JButton sendButton;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
