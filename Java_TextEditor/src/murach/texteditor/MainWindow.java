package murach.texteditor;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MainWindow extends JFrame {
    private File file;
    private String fileContents = "";
        
    public MainWindow() {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException |
                 IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.out.println(e);
        }        
        setTitle("Text Editor");
        setSize(800, 600);
        setLocationByPlatform(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // TODO: Add the button pannel to the JFrame.
        setVisible(true);
    }
    
    private JPanel buildButtonPanel() {
        JPanel panel = new JPanel();
        
        // TODO: Implement the rest of this method.
        
        return panel;
    }
    
    private void doOpenButton() {
        JFileChooser openDialog = new JFileChooser();
        int choice = openDialog.showOpenDialog(this);
        
        if (choice == JFileChooser.APPROVE_OPTION) {
            file = openDialog.getSelectedFile();
            fileContents = "";
            try {
                fileContents = new String(
                    Files.readAllBytes(Paths.get(file.toURI())));
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this,
                        "The file could not be read.", "File read error",
                        JOptionPane.ERROR_MESSAGE);
            }            
            // TODO: display file contents in JTextArea control instead of on console
            System.out.println(fileContents);
        }
    }
    
    private void doSaveButton() {
        if (file != null) {
            // TODO: get file contents from JTextArea control instead of on console
            try {
                Files.write(Paths.get(file.toURI()), fileContents.getBytes());
                System.out.println("The file was saved!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this,
                        "The file could not be written.", "File write error",
                        JOptionPane.ERROR_MESSAGE);
            }
            // TODO: display file contents in JTextArea control instead of on console
            System.out.println(fileContents);
        }
    }
}