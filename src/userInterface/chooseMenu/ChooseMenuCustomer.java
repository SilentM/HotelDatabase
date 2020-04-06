package userInterface.chooseMenu;

import controller.HotelController;
import userInterface.WelcomeScreen;
import userInterface.delete.DeleteCustomer;
import userInterface.insert.InsertCustomer;
import userInterface.showAll.ShowAllCustomers;
import userInterface.updatePrompt.UpdatePromptCustomer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseMenuCustomer extends JPanel {
    private JLabel titleLabel;
    private JButton insertButton;
    private JButton deleteButton;
    private JButton updateButton;
    private JButton showButton;
    private JButton backButton;

    public ChooseMenuCustomer(HotelController controller, JFrame frame) {
        //construct components
        titleLabel = new JLabel ("What do you want to do with CUSTOMER?");
        insertButton = new JButton ("Insert Customer");
        deleteButton = new JButton ("Delete Customer");
        updateButton = new JButton ("Update Customer");
        showButton = new JButton ("Show Customers");
        backButton = new JButton ("Back to Welcome Screen");

        //set components properties
        insertButton.setToolTipText ("Inserts customer into SQL table");
        deleteButton.setToolTipText ("Removes customer from SQL table");
        updateButton.setToolTipText ("Updates customer in the SQL table");
        showButton.setToolTipText ("Shows all customers in the SQL table");

        //adjust size and set layout
        setPreferredSize (new Dimension (736, 523));
        setLayout (null);

        //add components
        add (titleLabel);
        add (insertButton);
        add (deleteButton);
        add (updateButton);
        add (showButton);
        add (backButton);

        //set component bounds (only needed by Absolute Positioning)
        titleLabel.setBounds (215, 65, 300, 30);
        insertButton.setBounds (305, 110, 170, 25);
        deleteButton.setBounds (305, 150, 170, 25);
        updateButton.setBounds (305, 190, 170, 25);
        showButton.setBounds (305, 230, 170, 25);
        backButton.setBounds (485, 345, 180, 25);

        // on clicking the insertButton
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add (new InsertCustomer(controller, frame));
                frame.revalidate();
                frame.repaint();
            }
        });

        // on clicking the updateButton
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add (new UpdatePromptCustomer(controller, frame));
                frame.revalidate();
                frame.repaint();
            }
        });

        // on clicking the deleteButton
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add (new DeleteCustomer(controller, frame));
                frame.revalidate();
                frame.repaint();
            }
        });

        // on clicking the showButton
        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add (new ShowAllCustomers(controller, frame));
                frame.revalidate();
                frame.repaint();
            }
        });

        // on clicking the back button
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add (new WelcomeScreen(controller, frame));
                frame.revalidate();
                frame.repaint();
            }
        });
    }

//    public static void main (String[] args) {
//
//        frame.getContentPane().removeAll();
//        frame.getContentPane().add (new ca.ubc.cs304.ui.chooseMenu.ChooseMenuRoom());
//        frame.pack();
//        frame.setVisible (true);
//    }
}
