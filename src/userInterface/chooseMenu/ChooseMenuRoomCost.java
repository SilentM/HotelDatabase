package userInterface.chooseMenu;

import controller.HotelController;
import userInterface.WelcomeScreen;
import userInterface.delete.DeleteRoomCost;
import userInterface.insert.InsertRoomCost;
import userInterface.selectionQuery.SelectionQuery;
import userInterface.showAll.ShowAllRoomCosts;
import userInterface.updatePrompt.UpdatePromptRoomCost;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseMenuRoomCost extends JPanel {
    private JLabel titleLabel;
    private JButton insertButton;
    private JButton deleteButton;
    private JButton updateButton;
    private JButton showButton;
    private JButton backButton;
    private JButton projectionButton;
    private JButton aggregationButton;

    public ChooseMenuRoomCost(HotelController controller, JFrame frame) {
        //construct components
        titleLabel = new JLabel ("What do you want to do with RoomCost?");
        insertButton = new JButton ("Insert");
        deleteButton = new JButton ("Delete");
        updateButton = new JButton ("Update");
        showButton = new JButton ("Show");
        backButton = new JButton ("Back to Welcome Screen");
        projectionButton = new JButton ("Selection");
        aggregationButton = new JButton ("Aggregation");

        //set components properties
        insertButton.setToolTipText ("Inserts new tuple into SQL table");
        deleteButton.setToolTipText ("Removes tuple from SQL table");
        updateButton.setToolTipText ("Updates a tuple in SQL table");
        showButton.setToolTipText ("Shows all tuples in the SQL table");

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
        add (projectionButton);
        add (aggregationButton);

        //set component bounds (only needed by Absolute Positioning)
        titleLabel.setBounds (255, 65, 300, 30);
        insertButton.setBounds (305, 110, 103, 25);
        deleteButton.setBounds (305, 150, 103, 25);
        updateButton.setBounds (305, 190, 103, 25);
        showButton.setBounds (305, 230, 103, 25);
        backButton.setBounds (485, 345, 180, 25);
        projectionButton.setBounds (305, 270, 103, 25);
        aggregationButton.setBounds (305, 310, 103, 25);

        // on clicking the insertButton
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add (new InsertRoomCost(controller, frame));
                frame.revalidate();
                frame.repaint();
            }
        });

        // on clicking the updateButton
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add (new UpdatePromptRoomCost(controller, frame));
                frame.revalidate();
                frame.repaint();
            }
        });

        // on clicking the deleteButton
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add (new DeleteRoomCost(controller, frame));
                frame.revalidate();
                frame.repaint();
            }
        });

        // on clicking the showButton
        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add (new ShowAllRoomCosts(controller, frame));
                frame.revalidate();
                frame.repaint();
            }
        });

        // on clicking the projectionButton
        projectionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add (new SelectionQuery(controller, frame));
                frame.revalidate();
                frame.repaint();
            }
        });

//        // on clicking the aggregationButton
//        aggregationButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                frame.getContentPane().removeAll();
//                frame.getContentPane().add (new AggregationQuery(controller, frame));
//                frame.pack();
//                frame.setVisible (true);
//            }
//        });

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
