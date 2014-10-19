package com.assignment.clothes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.event.AncestorListener;


public class mainframe extends JFrame implements ActionListener {
	
	public ArrayList<String> tnamelst,tsnamelst,swnamelst,shnamelst,jnamelst;
	Random rand;
	Clothes types;
	JButton Selecto;
	Container pane;
	JComboBox tnamebx,jnamebx,shnamebx,swnamebx,tsnamebx;
	JMenuItem helpitem, closeitem, totalitem;
	JPopupMenu pop;
	JLabel picLabel, picLabel2, picLabel3, picLabel4, picLabel5;
	JPanel trousers, t_shirt, sweater, shoes, jacket, clothes;
	JCheckBox ttb, tsb, shtb, swtb, jtb;
	BufferedImage myPicture,myPicture2,myPicture3,myPicture4,myPicture5;
	JTextField tval,t_sval,shval,swval,jval, total;
	int totalamount;


	public mainframe(String MyTitle) throws Exception{
	        super(MyTitle);

	        setSize(900,400);
	        setLocation(100,100);
	        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	        setContentPane(createpane());
	        setVisible(true);

	    }
	  
	   
	   public Container createpane() throws Exception{
		   
		   
		   	types = new Clothes();
		   
		   	//Main Panel
	        pane = new JPanel();
	        pane.setLayout(new BorderLayout());
	        
	        JPanel gender = new JPanel();
	        gender.setSize(100,0);
	        
	        String[] genderlist = {"Male","Female"};
	        JComboBox genderbox = new JComboBox(genderlist);
	        JLabel selgen = new JLabel("Select Gender:");
	        gender.add(selgen);
	        gender.add(genderbox);
	        gender.setBackground(Color.CYAN);
	        pane.add(gender, BorderLayout.NORTH);

	        //Clothes panel
	        clothes = new JPanel();
	        clothes.setLayout(new GridLayout());
	        
	        pane.add(clothes);
	        
			// get the string that db returns
	        myPicture = ImageIO.read(new File(types.Tpath.toString()));
	        picLabel = new JLabel(new ImageIcon(myPicture));
	        
	        myPicture2 = ImageIO.read(new File(types.T_Spath.toString()));
	        picLabel2 = new JLabel(new ImageIcon(myPicture2));
	        
	        myPicture3 = ImageIO.read(new File(types.Jpath.toString()));
	        picLabel3 = new JLabel(new ImageIcon(myPicture3));
	        
	        myPicture4 = ImageIO.read(new File(types.SHpath.toString()));
	        picLabel4 = new JLabel(new ImageIcon(myPicture4));
	        
	        myPicture5 = ImageIO.read(new File(types.SWpath.toString()));
	        picLabel5 = new JLabel(new ImageIcon(myPicture5));
	        
	        trousers = new JPanel();
	        trousers.setBorder(BorderFactory.createLineBorder(Color.black));
	        trousers.setBackground(Color.white);
	        trousers.setLayout(new BorderLayout());
	        trousers.add(picLabel);
	        tval = new JTextField();
	        tval.setEditable(false);
	        tval.setBorder(null);
	        tval.setText(String.valueOf((int)types.tprice));
	        JLabel price = new JLabel("Price:");
	        JPanel southpanel = new JPanel();
	        JPanel nrthpanel = new JPanel();
	        ttb = new JCheckBox();
	        ttb.addActionListener(this);
	        JLabel ckl = new JLabel("Keep:");
	        
	        tnamelst = new ArrayList<String>();
			
			for(int i = 0 ; i< types.tname.size(); i++){
				tnamelst.add(types.tname.get(i));
			}
			tnamebx = new JComboBox( tnamelst.toArray());
			tnamebx.addActionListener(this);
	        nrthpanel.add(tnamebx);
	        southpanel.add(ckl);
	        southpanel.add(ttb);
	        southpanel.add(price);
	        southpanel.add(tval);
	        trousers.add(nrthpanel,BorderLayout.NORTH);
	        trousers.add(southpanel, BorderLayout.SOUTH);
	        clothes.add(trousers);
	        clothes.revalidate();
	        
	        
	        t_shirt = new JPanel();
	        t_shirt.setBorder(BorderFactory.createLineBorder(Color.black));
	        t_shirt.setBackground(Color.white);
	        t_shirt.setLayout(new BorderLayout());
	        t_shirt.add(picLabel2);
	        t_sval = new JTextField();
	        t_sval.setEditable(false);
	        t_sval.setBorder(null);
	        t_sval.setText(String.valueOf((int)types.t_sprice));
	        JLabel price1 = new JLabel("Price:");
	        JPanel southpanel1 = new JPanel();
	        JPanel nrthpanel1 = new JPanel();
	        tsb = new JCheckBox();
	        tsb.addActionListener(this);
	        JLabel ckl1 = new JLabel("Keep:");
	        tsnamelst = new ArrayList<String>();			
			for(int i = 0 ; i< types.tsname.size(); i++){
				tsnamelst.add(types.tsname.get(i));
			}
			tsnamebx = new JComboBox( tsnamelst.toArray());
			tsnamebx.addActionListener(this);
	        nrthpanel1.add(tsnamebx);
	        southpanel1.add(ckl1);
	        southpanel1.add(tsb);
	        southpanel1.add(price1);
	        southpanel1.add(t_sval);
	        t_shirt.add(nrthpanel1,BorderLayout.NORTH);
	        t_shirt.add(southpanel1, BorderLayout.SOUTH);
	        clothes.add(t_shirt);
	        
	        jacket = new JPanel();
	        jacket.setBorder(BorderFactory.createLineBorder(Color.black));
	        jacket.setBackground(Color.white);
	       // jacket.setSize(100, 60);
	        jacket.setLayout(new BorderLayout());
	        jacket.add(picLabel3);
	        jval = new JTextField();
	        jval.setText(String.valueOf((int)types.jprice));
	        jval.setEditable(false);
	        jval.setBorder(null);
	        JLabel price2 = new JLabel("Price:");
	        JPanel southpanel2 = new JPanel();
	        JPanel nrthpanel2 = new JPanel();
	        jtb = new JCheckBox();
	        jtb.addActionListener(this);
	        JLabel ckl2 = new JLabel("Keep:");
	        jnamelst = new ArrayList<String>();
			
			for(int i = 0 ; i< types.jname.size(); i++){
				jnamelst.add(types.jname.get(i));
			}
			
			jnamebx = new JComboBox( jnamelst.toArray());
			jnamebx.addActionListener(this);
	        nrthpanel2.add(jnamebx);
	        southpanel2.add(ckl2);
	        southpanel2.add(jtb);
	        southpanel2.add(price2);
	        southpanel2.add(jval);
	        jacket.add(nrthpanel2, BorderLayout.NORTH);
	        jacket.add(southpanel2, BorderLayout.SOUTH);
	        clothes.add(jacket);
	        
	        
	        shoes = new JPanel();
	        shoes.setBorder(BorderFactory.createLineBorder(Color.black));
	        shoes.setBackground(Color.white);
	        //shoes.setSize(100, 60);
	        shoes.setLayout(new BorderLayout());
	        shoes.add(picLabel4);
	        shval = new JTextField();
	        shval.setText(String.valueOf((int)types.shprice));
	        shval.setEditable(false);
	        shval.setBorder(null);
	        JLabel price3 = new JLabel("Price:");
	        JPanel southpanel3 = new JPanel();
	        JPanel nrthpanel3 = new JPanel();
	        shtb = new JCheckBox();
	        shtb.addActionListener(this);
	        JLabel ckl3 = new JLabel("Keep:");
	        shnamelst = new ArrayList<String>();
			
			for(int i = 0 ; i< types.shname.size(); i++){
				shnamelst.add(types.shname.get(i));
			}
			
			shnamebx = new JComboBox( shnamelst.toArray());
			shnamebx.addActionListener(this);
	        nrthpanel3.add(shnamebx);
	        southpanel3.add(ckl3);
	        southpanel3.add(shtb);
	        southpanel3.add(price3);
	        southpanel3.add(shval);
	        shoes.add(nrthpanel3, BorderLayout.NORTH);
	        shoes.add(southpanel3, BorderLayout.SOUTH);
	        clothes.add(shoes);
	        
	        sweater = new JPanel();
	        sweater.setBorder(BorderFactory.createLineBorder(Color.black));
	        sweater.setBackground(Color.white);
	       // sweater.setSize(100, 60);
	        sweater.setLayout(new BorderLayout());
	        sweater.add(picLabel5);
	        swval = new JTextField();
	        swval.setText(String.valueOf((int)types.swprice));
	        JLabel price4 = new JLabel("Price:");
	        swval.setEditable(false);
	        swval.setBorder(null);
	        JPanel southpanel4 = new JPanel();
	        JPanel nrthpanel4 = new JPanel();
	        swtb = new JCheckBox();
	        swtb.addActionListener(this);
	        JLabel ckl4 = new JLabel("Keep:");
	        swnamelst = new ArrayList<String>();
			
			for(int i = 0 ; i< types.swname.size(); i++){
				swnamelst.add(types.swname.get(i));
			}
			
			swnamebx = new JComboBox( swnamelst.toArray());
			swnamebx.addActionListener(this);
	        nrthpanel4.add(swnamebx);
	        southpanel4.add(ckl4);
	        southpanel4.add(swtb);
	        southpanel4.add(price4);
	        southpanel4.add(swval);
	        sweater.add(nrthpanel4, BorderLayout.NORTH);
	        sweater.add(southpanel4, BorderLayout.SOUTH);
	        clothes.add(sweater);
	        
	       
	        totalamount = (int)(types.tprice + types.swprice + types.shprice + types.t_sprice + types.jprice);
	        
	        JPanel info = new JPanel();
	        JPanel mvri = new JPanel();
	        mvri.setLayout(new GridLayout());
	        Selecto = new JButton("Select Outfit");
	        Selecto.addActionListener(this);
	        total = new JTextField(10);
	        JLabel totalprice = new JLabel("Total Price:");
	        total.setEditable(false);
	        total.setBorder(null);
	        total.setText(String.valueOf(totalamount));
	        info.add(Selecto);
	        info.add(totalprice);
	        info.add(total);
	        
	        info.setBackground(Color.CYAN);
	        pane.add(info, BorderLayout.SOUTH);
	        
	        pop = new JPopupMenu();
	        helpitem = new JMenuItem("Help");
	        helpitem.addActionListener(this); 
	        totalitem = new JMenuItem("Total Price: €"+ String.valueOf(totalamount));
	        closeitem = new JMenuItem("Close");
	        closeitem.addActionListener(this); 
	        pop.add(helpitem);
	        pop.add(closeitem);
	        pop.add(totalitem);
	        ((JComponent) pane).setComponentPopupMenu(pop);
	        return pane;
	    }
	   
	   @SuppressWarnings("deprecation")
	@Override
	   public void actionPerformed(ActionEvent e) {
		   if(e.getSource() == helpitem){
			   JOptionPane.showMessageDialog(this,"This application lets you choose from different close.\n"
			   		+ "'Select Outfit' randomize's the colthes on screen.\n'Keep:' "
			   		+ "Lets you save the current clothes displayed.\nYou can select "
			   		+ "from male and female gender.","HELP!!!!!!"
			   		, JOptionPane.INFORMATION_MESSAGE);
		   }
		   if(e.getSource() == closeitem){
			   dispose();  
		   }
		  
		   
		   //random button action
		   if(e.getSource() == Selecto){
			   
			   rand = new Random();
			   if(ttb.isSelected() == false){
			   types.t = rand.nextInt(types.TpathA.size());
			   }
			   if(tsb.isSelected() == false){
			   types.t_s = rand.nextInt(types.T_SpathA.size());
			   }
			   if(jtb.isSelected() == false){
			   types.j = rand.nextInt(types.JpathA.size());
			   }
			   if(swtb.isSelected() == false){
			   types.sw = rand.nextInt(types.SWpathA.size());
			   }
			   if(shtb.isSelected() == false){
			   types.sh = rand.nextInt(types.SHpathA.size());
			   }
			   
			   types.T_Spath = types.T_SpathA.get(types.t_s);
			   types.Tpath = types.TpathA.get(types.t);
			   types.SWpath = types.SWpathA.get(types.sw);
			   types.SHpath = types.SHpathA.get(types.sh);
			   types.Jpath = types.JpathA.get(types.j);
			   
			   types.tprice = types.TpriceA.get(types.t);
			   types.jprice = types.JpriceA.get(types.j);
			   types.shprice = types.SHpriceA.get(types.sh);
			   types.swprice = types.SWpriceA.get(types.sw);
			   types.t_sprice = types.T_SpriceA.get(types.t_s);
			   totalamount = (int)(types.tprice + types.swprice + types.shprice + types.t_sprice + types.jprice);
			   
			   tval.setText(String.valueOf((int)types.tprice));
			   jval.setText(String.valueOf((int)types.jprice));
			   shval.setText(String.valueOf((int)types.shprice));
			   swval.setText(String.valueOf((int)types.swprice));
			   t_sval.setText(String.valueOf((int)types.t_sprice));
			   total.setText(String.valueOf(totalamount));
			   pop.remove(totalitem);
			   totalitem = new JMenuItem("Total Price: €"+ String.valueOf(totalamount));
			   pop.add(totalitem);
			   
			   tval.revalidate();
			   jval.revalidate();
			   shval.revalidate();
			   swval.revalidate();
			   t_sval.revalidate();
			   total.revalidate();
			   totalitem.revalidate();
			   pop.revalidate();
			  

				try {
					myPicture = ImageIO.read(new File(types.Tpath.toString()));
					myPicture2 = ImageIO.read(new File(types.T_Spath.toString()));
					myPicture3 = ImageIO.read(new File(types.Jpath.toString()));
					myPicture4 = ImageIO.read(new File(types.SHpath.toString()));
					myPicture5 = ImageIO.read(new File(types.SWpath.toString()));
				} catch (IOException e1) {				
					e1.printStackTrace();
				}
				
				trousers.remove(picLabel);
				t_shirt.remove(picLabel2);
				jacket.remove(picLabel3);
				shoes.remove(picLabel4);
				sweater.remove(picLabel5);
				
				picLabel = new JLabel(new ImageIcon(myPicture));
				picLabel2 = new JLabel(new ImageIcon(myPicture2));
				picLabel3 = new JLabel(new ImageIcon(myPicture3));
				picLabel4 = new JLabel(new ImageIcon(myPicture4));
				picLabel5 = new JLabel(new ImageIcon(myPicture5));
				
				trousers.add(picLabel);
				t_shirt.add(picLabel2);
				jacket.add(picLabel3);
				shoes.add(picLabel4);
				sweater.add(picLabel5);
				
				trousers.revalidate();
				t_shirt.revalidate();
				jacket.revalidate();
				shoes.revalidate();
				sweater.revalidate();
		   }
		   
		   //gets fired if a trousers is selected from the trousers combo box.
		   if(ttb.isSelected() == false){
			   if(e.getSource() == tnamebx  ){
				   types.t = tnamebx.getSelectedIndex();
				   types.Tpath = types.TpathA.get(types.t);
					try {
						myPicture = ImageIO.read(new File(types.Tpath.toString()));
					} catch (IOException e1) {				
						e1.printStackTrace();
					}
					
				   types.tprice = types.TpriceA.get(types.t);
				   types.jprice = types.JpriceA.get(types.j);
			   	   types.shprice = types.SHpriceA.get(types.sh);
				   types.swprice = types.SWpriceA.get(types.sw);
				   types.t_sprice = types.T_SpriceA.get(types.t_s);
				   totalamount = (int)(types.tprice + types.swprice + types.shprice + types.t_sprice + types.jprice);
				   tval.setText(String.valueOf((int)types.tprice));
				   jval.setText(String.valueOf((int)types.jprice));
				   shval.setText(String.valueOf((int)types.shprice));
				   swval.setText(String.valueOf((int)types.swprice));
				   t_sval.setText(String.valueOf((int)types.t_sprice));
				   total.setText(String.valueOf(totalamount));
				   pop.remove(totalitem);
				   totalitem = new JMenuItem("Total Price: €"+ String.valueOf(totalamount));
				   pop.add(totalitem);
				   
				   tval.revalidate();
				   jval.revalidate();
				   shval.revalidate();
				   swval.revalidate();
				   t_sval.revalidate();
				   total.revalidate();
				   totalitem.revalidate();
				   pop.revalidate();
					  
					   
					trousers.remove(picLabel);
					picLabel = new JLabel(new ImageIcon(myPicture));
					trousers.add(picLabel);
					trousers.revalidate();			   
			   }
		   }
		   
		 //gets fired if a t-shirt is selected from the t-shirt combo box.
		   if(tsb.isSelected() == false){
			   if(e.getSource() == tsnamebx){
				   types.t_s = tsnamebx.getSelectedIndex();
				   types.T_Spath = types.T_SpathA.get(types.t_s);
	
					try {
						myPicture2 = ImageIO.read(new File(types.T_Spath.toString()));
					} catch (IOException e1) {				
						e1.printStackTrace();
					}
				   types.tprice = types.TpriceA.get(types.t);
				   types.jprice = types.JpriceA.get(types.j);
			   	   types.shprice = types.SHpriceA.get(types.sh);
				   types.swprice = types.SWpriceA.get(types.sw);
				   types.t_sprice = types.T_SpriceA.get(types.t_s);
				   totalamount = (int)(types.tprice + types.swprice + types.shprice + types.t_sprice + types.jprice);
				   tval.setText(String.valueOf((int)types.tprice));
				   jval.setText(String.valueOf((int)types.jprice));
				   shval.setText(String.valueOf((int)types.shprice));
				   swval.setText(String.valueOf((int)types.swprice));
				   t_sval.setText(String.valueOf((int)types.t_sprice));
				   total.setText(String.valueOf(totalamount));
				   pop.remove(totalitem);
				   totalitem = new JMenuItem("Total Price: €"+ String.valueOf(totalamount));
				   pop.add(totalitem);
				   
				   tval.revalidate();
				   jval.revalidate();
				   shval.revalidate();
				   swval.revalidate();
				   t_sval.revalidate();
				   total.revalidate();
				   totalitem.revalidate();
				   pop.revalidate();
					   
					t_shirt.remove(picLabel2);
					picLabel2 = new JLabel(new ImageIcon(myPicture2));
					t_shirt.add(picLabel2);
					t_shirt.revalidate(); 
			   }
		   }
		 //gets fired if shoes are selected from the shoes combo box.
		   if(shtb.isSelected() == false){
			   if(e.getSource() == shnamebx){
				   types.sh = shnamebx.getSelectedIndex();
				   types.SHpath = types.SHpathA.get(types.sh);
	
					try {
						myPicture4 = ImageIO.read(new File(types.SHpath.toString()));
					} catch (IOException e1) {				
						e1.printStackTrace();
					}
					
				   types.tprice = types.TpriceA.get(types.t);
				   types.jprice = types.JpriceA.get(types.j);
			   	   types.shprice = types.SHpriceA.get(types.sh);
				   types.swprice = types.SWpriceA.get(types.sw);
				   types.t_sprice = types.T_SpriceA.get(types.t_s);
				   totalamount = (int)(types.tprice + types.swprice + types.shprice + types.t_sprice + types.jprice);
				   tval.setText(String.valueOf((int)types.tprice));
				   jval.setText(String.valueOf((int)types.jprice));
				   shval.setText(String.valueOf((int)types.shprice));
				   swval.setText(String.valueOf((int)types.swprice));
				   t_sval.setText(String.valueOf((int)types.t_sprice));
				   total.setText(String.valueOf(totalamount));
				   pop.remove(totalitem);
				   totalitem = new JMenuItem("Total Price: €"+ String.valueOf(totalamount));
				   pop.add(totalitem);
				   
				   tval.revalidate();
				   jval.revalidate();
				   shval.revalidate();
				   swval.revalidate();
				   t_sval.revalidate();
				   total.revalidate();
				   totalitem.revalidate();
				   pop.revalidate();
					   
					shoes.remove(picLabel4);
					picLabel4 = new JLabel(new ImageIcon(myPicture4));
					shoes.add(picLabel4);
					shoes.revalidate();
			   }
		   }
		 //gets fired if a jacket is selected from the jacket combo box.
		   if(jtb.isSelected() == false){
			   if(e.getSource() == jnamebx){
				   
				   types.j = jnamebx.getSelectedIndex();
				   types.Jpath = types.JpathA.get(types.j);
	
					try {
						myPicture3 = ImageIO.read(new File(types.Jpath.toString()));
					} catch (IOException e1) {				
						e1.printStackTrace();
					}
					
				   types.tprice = types.TpriceA.get(types.t);
				   types.jprice = types.JpriceA.get(types.j);
			   	   types.shprice = types.SHpriceA.get(types.sh);
				   types.swprice = types.SWpriceA.get(types.sw);
				   types.t_sprice = types.T_SpriceA.get(types.t_s);
				   totalamount = (int)(types.tprice + types.swprice + types.shprice + types.t_sprice + types.jprice);
				   tval.setText(String.valueOf((int)types.tprice));
				   jval.setText(String.valueOf((int)types.jprice));
				   shval.setText(String.valueOf((int)types.shprice));
				   swval.setText(String.valueOf((int)types.swprice));
				   t_sval.setText(String.valueOf((int)types.t_sprice));
				   total.setText(String.valueOf(totalamount));
				   pop.remove(totalitem);
				   totalitem = new JMenuItem("Total Price: €"+ String.valueOf(totalamount));
				   pop.add(totalitem);
				   
				   tval.revalidate();
				   jval.revalidate();
				   shval.revalidate();
				   swval.revalidate();
				   t_sval.revalidate();
				   total.revalidate();
				   totalitem.revalidate();
				   pop.revalidate(); 
					   
					jacket.remove(picLabel3);
					picLabel3 = new JLabel(new ImageIcon(myPicture3));
					jacket.add(picLabel3);
					jacket.revalidate(); 
			   }
		   }
		   
		 //gets fired if a sweater is selected from the sweater combo box.
		   if(swtb.isSelected() == false){
			   if(e.getSource() == swnamebx){
				   types.sw = swnamebx.getSelectedIndex();
				   types.SWpath = types.SWpathA.get(types.sw);
	
					try {
						myPicture5 = ImageIO.read(new File(types.SWpath.toString()));
					} catch (IOException e1) {				
						e1.printStackTrace();
					}
					
				   types.tprice = types.TpriceA.get(types.t);
				   types.jprice = types.JpriceA.get(types.j);
			   	   types.shprice = types.SHpriceA.get(types.sh);
				   types.swprice = types.SWpriceA.get(types.sw);
				   types.t_sprice = types.T_SpriceA.get(types.t_s);
				   totalamount = (int)(types.tprice + types.swprice + types.shprice + types.t_sprice + types.jprice);
				   tval.setText(String.valueOf((int)types.tprice));
				   jval.setText(String.valueOf((int)types.jprice));
				   shval.setText(String.valueOf((int)types.shprice));
				   swval.setText(String.valueOf((int)types.swprice));
				   t_sval.setText(String.valueOf((int)types.t_sprice));
				   total.setText(String.valueOf(totalamount));
				   pop.remove(totalitem);
				   totalitem = new JMenuItem("Total Price: €"+ String.valueOf(totalamount));
				   pop.add(totalitem);
				   
				   tval.revalidate();
				   jval.revalidate();
				   shval.revalidate();
				   swval.revalidate();
				   t_sval.revalidate();
				   total.revalidate();
				   totalitem.revalidate();
				   pop.revalidate();
				   
					sweater.remove(picLabel5);
					picLabel5 = new JLabel(new ImageIcon(myPicture5));
					sweater.add(picLabel5);
					sweater.revalidate();
			   }
		   }
		   
	   }
	   
}


