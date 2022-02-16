
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editor;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 *
 * @author darag
 */
public class edi extends JFrame implements ActionListener{
JTextPane textArea;
JScrollPane scrollPane;
JSpinner fontSizeSpinner;
JLabel fontlabel;
JButton color;
JComboBox font;
JMenuBar menuBar;
JMenu fileMenu;
JMenu editMenu;
JMenuItem openItem;
JMenuItem exitItem;
JMenuItem saveItem;
JMenuItem print;
JTextField searchTxt;
JTextField replaceTxt;
        JMenuItem copy;
        JMenuItem paste;
        JMenuItem find;
        JMenuItem replace;
        JMenuItem background;
        JMenu help;
        JMenuItem keyboardShortcuts ;
        JMenuItem  about;
             JLabel words = new JLabel(" words:0");  
        JLabel position = new JLabel("Position:"); 
           JLabel mouseStatus = new JLabel(" Mouse Status:"); 
           JLabel lines = new JLabel("Lines: 0"); 
           JLabel label = new JLabel("Adjustment Value:  50");
           JLabel statusBar = new JLabel("");
           JPopupMenu popupMenu ;
 
        // هنا قمنا بتعريف العناصر التي سنضعها في القائمة
        JMenuItem cu;
        JMenuItem cop;
        JMenuItem past ;
        JMenuItem selectAll;
 
        // في القائمة المنبثقة select و paste ,copy ,cut هنا قمنا بوضع العناصر
       
      edi() {
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setTitle("Text Editor");
        this.setSize(500, 500);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout());
        textArea = new JTextPane();
        



textArea.setFont(new Font("Arial",Font.PLAIN,20));
scrollPane = new JScrollPane(textArea);
scrollPane.setPreferredSize(new Dimension(450,450));
scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
fontlabel = new JLabel("Font :");
fontSizeSpinner = new JSpinner();
fontSizeSpinner.setPreferredSize(new Dimension(50,25));
fontSizeSpinner.setValue(20);
fontSizeSpinner.addChangeListener(new ChangeListener() {

             @Override
             public void stateChanged(ChangeEvent e) {
               textArea.setFont(new Font(textArea.getFont().getFamily(),Font.PLAIN,(int)fontSizeSpinner.getValue()));
             }
         });
popupMenu= new JPopupMenu();
cu = new JMenuItem("Cut");
cop = new JMenuItem("Copy");
past = new JMenuItem("Paste");
selectAll = new JMenuItem("Select All");
color = new JButton("Color");
color.addActionListener(this);
String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
font = new JComboBox(fonts);
font.addActionListener(this);
font.setSelectedItem("Arial");
menuBar = new JMenuBar();
fileMenu = new JMenu("file");
editMenu = new JMenu("edit");
openItem = new JMenuItem("Open");
saveItem = new JMenuItem("Save");
exitItem = new JMenuItem("Exit");
print = new JMenuItem("Print");
copy = new JMenuItem("Copy");
paste = new JMenuItem("Paste");
find= new JMenuItem("Find");
replace= new JMenuItem("Replace");
background = new JMenuItem("Background");
help = new JMenu("Help");
 keyboardShortcuts = new JMenuItem("Keyboard Shortcuts");
        about = new JMenuItem("About");
searchTxt = new JTextField("    ");
 replaceTxt= new JTextField("      ");
openItem.addActionListener(this);
saveItem.addActionListener(this);
exitItem.addActionListener(this);
print.addActionListener(this);
copy.addActionListener(this);
paste.addActionListener(this);
copy.addActionListener(this);
find.addActionListener(this);
replace.addActionListener(this);
background.addActionListener(this);
paste.addActionListener(this);
      keyboardShortcuts.addActionListener(this);
        about.addActionListener(this);
        cu.addActionListener(this);
        cop.addActionListener(this);
        past.addActionListener(this);
        selectAll.addActionListener(this);
this.setJMenuBar(menuBar);

menuBar.add(fileMenu);
menuBar.add(editMenu);
  menuBar.add(help);
fileMenu.add(openItem);
fileMenu.add(saveItem);
fileMenu.add(exitItem);
fileMenu.add(print);
editMenu.add(copy);
editMenu.add(paste);
editMenu.add(find);
editMenu.add(replace);
editMenu.add(background);
help.add(keyboardShortcuts);
        help.add(about);
         popupMenu.add(cu);
        popupMenu.add(cop);
        popupMenu.add(past);
        popupMenu.addSeparator(); // هنا أضفا خط فاصل
        popupMenu.add(selectAll);
 
        // و بالتالي ربطنا بها textArea هنا وضعنا القائمة المنبثقة في الـ
        textArea.add(popupMenu);   

           this.add(words);                                      
        this.add(lines);
        this.add(position);
        this.add(mouseStatus);
        this.add(statusBar);
this.add(color);
this.add(fontlabel);
this.add(fontSizeSpinner);
this.add(font);
this.add(scrollPane);
this.add(searchTxt);
this.add(replaceTxt);
this.setVisible(true);

fileMenu.setMnemonic('F');
editMenu.setMnemonic('E');
exitItem.setMnemonic('X');
about.setMnemonic('A'); 
keyboardShortcuts.setMnemonic('K'); 
help.setMnemonic('H'); 
 textArea.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
             }
 
            @Override
            public void keyPressed(KeyEvent e) {
               
            }
 
            @Override
            public void keyReleased(KeyEvent e) { 
             words.setText("chars: " + textArea.getText().length());         // chars كنص للكائن JTextArea هنا وضعنا عدد أحرف الكائن
                //lines.setText("Lines: " + textArea.getLineCount()); 
            }
        });
 textArea.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                position.setText(" Mouse Position: ("+e.getX()+", "+e.getY() +")");
                 if( SwingUtilities.isRightMouseButton(e) )
                    popupMenu.show(textArea, e.getX(), e.getY());
            }
 
            @Override
            public void mousePressed(MouseEvent e) {
                mouseStatus.setText(" Mouse Status: Mouse Pressed");
            }
 
            @Override
            public void mouseReleased(MouseEvent e) {
                mouseStatus.setText(" Mouse Status: Mouse Released");
            }
 
            @Override
            public void mouseEntered(MouseEvent e) {
                mouseStatus.setText(" Mouse Status: Mouse Entered");
            }
 
            @Override
            public void mouseExited(MouseEvent e) {
                mouseStatus.setText(" Mouse Status: Mouse Exited");
            }

            
        });
 this.addWindowListener(new WindowListener() {
 
            @Override
            public void windowOpened(WindowEvent e) {
                JOptionPane.showMessageDialog(null, "Event: Window Opened");
            }
 
            @Override
            public void windowClosing(WindowEvent e) {
                JOptionPane.showMessageDialog(null, "Event: Window Closing");
            }
 
            @Override
            public void windowClosed(WindowEvent e) {
                JOptionPane.showMessageDialog(null, "Event: Window Closed");
 
            }
 
            @Override
            public void windowIconified(WindowEvent e) {
                JOptionPane.showMessageDialog(null, "Event: Window Iconified");
            }
 
            @Override
            public void windowDeiconified(WindowEvent e) {
                JOptionPane.showMessageDialog(null, "Event: Window Deiconified");
            }
 
            @Override
            public void windowActivated(WindowEvent e) {
 
            }
 
            @Override
            public void windowDeactivated(WindowEvent e) {
 
            }

            
 
        });

    }
      
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==cu){
                            textArea.cut();

        }
        if(e.getSource()==cop){
                            textArea.copy();

        }
        if(e.getSource()==past){
                            textArea.paste();

        }
        if(e.getSource()==selectAll){
                          textArea.selectAll();
  
        }
       if(e.getSource()==color){
           JColorChooser colorChooser = new JColorChooser();
           Color col = colorChooser.showDialog(null,"Choose a color",Color.BLACK);
           textArea.setForeground(col);
       }
        if(e.getSource()==font){
             textArea.setFont(new Font((String)font.getSelectedItem(),Font.PLAIN,textArea.getFont().getSize()));
        }
        if(e.getSource()==openItem){
            JFileChooser fileChooser = new JFileChooser();
             int returnedValue = fileChooser.showOpenDialog(this);
         FileNameExtensionFilter filter = new FileNameExtensionFilter("text or java files", "txt", "java","doc","docx","rtf" );
        fileChooser.setFileFilter(filter);
                // Open ففي حال قام المستخدم بإختيار ملف ثم نقر على
                if(returnedValue == JFileChooser.APPROVE_OPTION)
                {
                    // سيتم حفظ مساره
                    File selectedFile = fileChooser.getSelectedFile();
                    String filepath = selectedFile.getPath();
 
                    try {
                        // ثم قراءة محتواه سطراً سطراً
                        BufferedReader br = new BufferedReader(new FileReader(filepath));
                        String line = "";
                        String text = "";
 
                        while( (line=br.readLine()) != null )
                            text += line + "\n";
 
                        // ثم إغلاق الإتصال مع الملف textArea في الأخير سيتم وضعه كنص في الـ
                        textArea.setText(text);
                        br.close();
                    }
                    catch(IOException ioe) {
                        // Option Pane في حال حدث خطأ سيتم عرضه في
                        JOptionPane.showMessageDialog(null, ioe.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
             }
                     }
         if(e.getSource()==saveItem){
             JFileChooser fileChooser = new JFileChooser();
              FileNameExtensionFilter filter = new FileNameExtensionFilter("text or java files", "txt", "java","doc","docx","rtf" );
        fileChooser.setFileFilter(filter);
             fileChooser.setCurrentDirectory(new File("."));
             int response = fileChooser.showSaveDialog(null);
             if(response == JFileChooser.APPROVE_OPTION){
                 File file;
                 PrintWriter fileOut = null;
                 file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                 try{
                     fileOut = new PrintWriter(file);
                     fileOut.println(textArea.getText());
                 }
                 catch(FileNotFoundException e1){
                     e1.printStackTrace();
                 }
                 finally{
                     fileOut.close();
                 }
                 
             }
                     }
          if(e.getSource()==print){
               try {
         textArea.print();
     } catch (PrinterException ex) {
         Logger.getLogger(edi.class.getName()).log(Level.SEVERE, null, ex);
     }
                     }
           if(e.getSource()==exitItem){
               System.exit(0);
                     }
            if(e.getSource()==copy){
               textArea.selectAll();
            textArea.copy();
            textArea.setCaretPosition(textArea.getText().length());
                     }
            if(e.getSource()==paste){
               textArea.paste();
                     }
              if(e.getSource()==find){
              int count = countOccurrences();
            if (count == 0)
                statusBar.setText("Not Found");
            else
                statusBar.setText("Found " + count + " Times");
                     }
              if(e.getSource()==replace){
                  String afterReplace = replaceOccurrences();
                        statusBar.setText(afterReplace);

                     }
              
             if(e.getSource()==background){
           JColorChooser colorChooser = new JColorChooser();
           Color col = colorChooser.showDialog(null,"Choose a color",Color.BLACK);
           textArea.setBackground(col);
       }
               else if (e.getSource() == about)
        {
            String str = "<html>"
                        + "<big>Text Editor</big><br><br>"
                        + "<p>Prepared by <b>ebn darrge</b><br><br>"
                        + "If you have any comments, ideas.. just let know<br><br>"
                        + "email:   Ertyopoken@hotmail..com<br>"
                        + "<u>Note</u><br>"
                        + "<p><i>© ref bro code- harmush java- JavaHow to program book</i></p>"
                        + "<html>";
 
            JOptionPane.showMessageDialog(getContentPane(), str, "About", JOptionPane.PLAIN_MESSAGE);

    }
                     else if (e.getSource() == keyboardShortcuts)
        {
            String str = "<html>"
                        + "<ul>"
                        + "<li>Press ALt+ F File Menu</li>"
                        + "<li>Press ALt+ A About Menu</li>"
                        + "<li>Press ALt+ E edit Menu.</li>"
                        + "<li>Press ALt+ x to exit Menu.</li>"
                      + "<li>Press ALt+ K keyboardShortcuts.</li>"
                        + "<li>Press ALt+ H to help Menu.</li>"
                      + "<li>Press ALt+ A to About Menu.</li>"
                      
                        + "</ul>"
                        + "<html>";
 
            JOptionPane.showMessageDialog(getContentPane(), str, "Keyboard Shortcuts", JOptionPane.PLAIN_MESSAGE);
        }

             }
             
         int countOccurrences ()
    {
        String fullText = textArea.getText();
        String word = searchTxt.getText();

        int c = 0;
        do
        {
            int in = fullText.indexOf(word);
            if (in == -1)
                return c;
            c++;
            fullText = fullText.substring(in+1);
        }
        while (fullText.equals("") == false);
        return c;
    }

    String replaceOccurrences ()
    {
        String fullText = textArea.getText();
        String word = searchTxt.getText();
        String newWord = replaceTxt.getText();

        do
        {
            int in = fullText.indexOf(word);
            if (in == -1)
                return fullText;
            
            fullText = fullText.substring(0,in) + newWord + fullText.substring(in+word.length());
        }
        while (fullText.equals("") == false);
        return fullText;
    }
        
    int[] listtOccurrencesIndex ()
    {
        String fullText = textArea.getText();
        String word = searchTxt.getText();
        int [] result = new int [fullText.length()]; 
        
        int c = 0;
        do
        {
            int in = fullText.indexOf(word);
            if (in == -1)
                break;
            
            result[c++] = in;
            fullText = fullText.substring(in+1);
        }
        while (fullText.equals("") == false);
        
        int [] netResult = new int [c];
        for(int j =0 ; j<c ; j++)
            netResult[j] = result[j];
        return netResult;
    }
    
}
  

