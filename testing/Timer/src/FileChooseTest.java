import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.*;
import javax.swing.border.Border;

public class FileChooseTest extends JFrame {
	
	private JFileChooser fileChooser;
	private File file;
	
	private JTextArea textArea;
	
	private JPanel mainPanel;
	private JButton openButton, saveButton, saveAsButton;
	
	private JLabel pathLabel;
	
	private JComboBox box;

	public FileChooseTest() {
		setUpFrame();
		
		initComponents();
		
		setUpGUI();
		
		this.setSize(600,500);
	}
	
	public void setUpFrame() {
		this.setTitle("JFileChooser Test - By: Anthony Narlock");
		this.setSize(600, 499);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void initComponents() {
		mainPanel = new JPanel();
		fileChooser = new JFileChooser();
		
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		textArea = new JTextArea(10,30);
		textArea.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(20,20,20,20)));
		
		
		openButton = new JButton("Open File");
		saveButton = new JButton("Save Opened File");
		saveAsButton = new JButton("Save File As");
		
		//box = new JComboBox();
		
		//box.add(openButton);
		//box.add(saveButton);
		//box.add(saveAsButton);
		
		pathLabel = new JLabel();
		pathLabel.setText("Path: ");
		
		
		openButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(selectFile() == 1) {
					try {
						BufferedReader br = new BufferedReader(new FileReader(file));
						
						String line;
						while ((line = (br.readLine())) != null) {
							if(!line.equals(""))
								textArea.setText(line);
						}
						br.close();
						
						
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} else {
					//do nothing
				}
			}
		});
		
		saveAsButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				runSaveAs();
			}
			
		});
		
		saveButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				runSave();
				
			}
			
		});
		
		
		textArea.setText("This is a test");
	}
	
	protected void runSave() {
		File fnew = new File(file.getAbsolutePath());
		
		String source = textArea.getText();
		
		try {
			FileWriter f2 = new FileWriter(fnew, false);
			f2.write(source);
			f2.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	protected void runSaveAs() {
		final JFileChooser SaveAs = new JFileChooser();
		SaveAs.setApproveButtonText("Save");
		int actionDialog = SaveAs.showOpenDialog(this);
		if(actionDialog != JFileChooser.APPROVE_OPTION) {
			return;
		}
		
		File fileName = new File(SaveAs.getSelectedFile() + ".txt");
		BufferedWriter outFile = null;
		try {
			outFile = new BufferedWriter(new FileWriter(fileName));
			textArea.write(outFile);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (outFile != null) {
				try {
					outFile.close();
				} catch (IOException ex2) {
					
				}
			}
		}
		
	}

	public void setUpGUI() {
		this.add(textArea, BorderLayout.CENTER);
		this.add(pathLabel, BorderLayout.SOUTH);
		
		mainPanel.setLayout(new GridLayout(1,3));
		mainPanel.add(openButton);
		mainPanel.add(saveButton);
		mainPanel.add(saveAsButton);

		//mainPanel.add(box);
		
		this.add(mainPanel,BorderLayout.NORTH);
		
		
		
	}
	
	public int selectFile() {
		if(fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			this.file = fileChooser.getSelectedFile();
			pathLabel.setText("Path: " + file.getAbsolutePath());
			return 1;
		} else {
			pathLabel.setText("Path: No File Opened");
			return 0;
		}
	}
	
	public static void main(String[] args) {
		FileChooseTest fct = new FileChooseTest();
	}
}
