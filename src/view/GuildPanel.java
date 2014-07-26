package view;


import static common.LoadData.HMScene;
import static common.LoadData.HMScript;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


import model.dao.listener.GuildListener;
import model.dto.scene.Scene;
import model.dto.script.Script;

import javax.swing.JLayeredPane;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class GuildPanel extends JPanel {
    public JButton Return;
    public JLayeredPane main;
    public JTextArea script;
    public JLabel name;
    
    public int SceneFlag;
    public int scriptFlag;
    public Script src;
    private JPanel panel;
    public JPanel panel_1;
    
    public GuildPanel() {
    SceneFlag = 1;
    scriptFlag = 1;
    setLayout(null);
    
    
    
    
    panel = new JPanel();
//    panel.setOpaque(false);
    panel.setBounds(0, 0, 800, 550);
    add(panel);
    panel.setLayout(null);
    panel_1 = new MyPanel();
	panel_1.paintComponents(null);
	panel_1.setSize(800, 600);
	panel_1.setBounds(0, 0, 800, 6000);
	add(panel_1);
//    panel.add(panel_1);
    panel_1.setOpaque(true);
    panel.setOpaque(false);
    
    
    
    main = new JLayeredPane();
    main.setBounds(0, 0, 800, 500);
    panel.add(main);
	main.setLayout(null);
	name = new JLabel("이름");
	name.setForeground(Color.WHITE);
	name.setHorizontalAlignment(SwingConstants.CENTER);
	name.setOpaque(true);
	name.setBounds(30, 310, 130, 30);
	main.add(name);
	name.setBackground(Color.DARK_GRAY);
	script = new JTextArea("대사창");
	script.setForeground(Color.WHITE);
	script.setBorder(new LineBorder(new Color(0, 0, 0), 4));
	script.setBounds(30, 340, 740, 150);
	main.add(script);
	script.setEditable(false);
	script.setFont(new Font("Monospaced", Font.BOLD, 17));
	script.setWrapStyleWord(true);
	script.setLineWrap(true);
	script.setBackground(Color.DARK_GRAY);
	
	
	
	
//    script.setForeground(fg);
	Return = new JButton("처음으로 돌아가기");
	Return.setBounds(300, 500, 200, 50);
	panel.add(Return);
	Return.setActionCommand("return");
	
	
	
	JPanel panel_1 = new MyPanel();
	panel_1.paintComponents(null);
	panel_1.setSize(800, 350);
	panel_1.setBounds(100, 50, 600, 240);
	add(panel_1);
	setScene();
	setVisible(true);
	GuildListener EL = new GuildListener();
	
	ClickGuildListner CGL= new ClickGuildListner();
	Return.addActionListener(EL);
	script.addMouseListener(CGL);
    }
    public void setScript(){
    	
    	name.setText(src.name);
    	script.setText(src.script);
		
    	scriptFlag++;
    }
    public void setScene(){
    	Scene scene = HMScene.get("Scene"+SceneFlag);
    	HashMap s = HMScene.get("Scene"+SceneFlag).script;
    	String[] temp = new String[s.size()];//씬의 스크립트수만큼 배열 생성
    	
    		src = scene.script.get(scene.start);
    	}
    
    class ClickGuildListner implements MouseListener{

    	@Override
    	public void mouseClicked(java.awt.event.MouseEvent e) {
    		JTextArea temp = (JTextArea)e.getSource();
    		if(e.getClickCount() >= 1){
    			setScript();
    		}
    	}

    	@Override
    	public void mouseEntered(java.awt.event.MouseEvent e) {
    		// TODO Auto-generated method stub
    		
    	}

    	@Override
    	public void mouseExited(java.awt.event.MouseEvent e) {
    		// TODO Auto-generated method stub
    		
    	}

    	@Override
    	public void mousePressed(java.awt.event.MouseEvent e) {
    		// TODO Auto-generated method stub
    		
    	}

    	@Override
    	public void mouseReleased(java.awt.event.MouseEvent e) {
    		// TODO Auto-generated method stub
    		
    	}
    	
    }
    class MyPanel extends JPanel{
		public void paintComponent(Graphics g)
		{
			BufferedImage img = null;
			try {
				img = ImageIO.read(new File("guild.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			g.drawImage(img, 0, 0, img.getWidth() ,img.getHeight(), this);
		}
	}
}

