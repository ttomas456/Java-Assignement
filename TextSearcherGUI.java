/*
Java Assignment
Name: Tomas Mac Sweeney
Date: 2/4/23
i included a search tool that lets you search through groups of text files.
i put the search tool into a GUI Graphic user interface
it will give back the strongest matches ranking mechanism so the strongest match is returned first
 */

package JavaAssignment;

// this is the import method
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// main class
public class TextSearcherGUI {

    private static JTextArea resultsTextArea = new JTextArea(20, 40);

    // main method
    public static void main(String[] args) {
        // created the GUI
        // this is the title
        JFrame frame = new JFrame("My Search Engine");

        // this is for the border
        JPanel panel = new JPanel(new BorderLayout());
        // this is for searching the words
        JLabel searchLabel = new JLabel("Search words:");

        // this is for the width
        JTextField searchField = new JTextField(15);
        // this is used for to search through the files
        JLabel filesLabel = new JLabel("Files to search:");

        // this is for the width
        JTextField filesField = new JTextField(25);

        // this is the search button
        JButton searchButton = new JButton("Search");

        // this will wait till the button is pressed
        searchButton.addActionListener(new ActionListener() {
            // action is performed when button is pressed
            public void actionPerformed(ActionEvent e)
            {

                String searchTerm = searchField.getText();
                String[] files = filesField.getText().split(",");
                TextSearcher.searchFiles(searchTerm, files);
            }
        });

        // this is the grid layout
        JPanel searchTool = new JPanel(new GridLayout(0,2));

        // search label
        searchTool.add(searchLabel);
        // search field
        searchTool.add(searchField);
        searchTool.add(filesLabel);
        searchTool.add(filesField);
        // search button
        searchTool.add(searchButton);

        resultsTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultsTextArea);

        // this is for the north border
        panel.add(searchTool, BorderLayout.NORTH);
        // this is for the center border
        panel.add(scrollPane, BorderLayout.CENTER);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    // this is used for the other file text search
    // to get the results
    public static void showResults(String s) {
        resultsTextArea.setText(s);
    }
}


