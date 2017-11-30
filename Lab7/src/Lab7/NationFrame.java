package Lab7;

import javax.swing.JFrame;

public class NationFrame extends JFrame{
	 private NationPanel panel;
        public NationFrame(){
        	this.setSize(350, 90);
        	panel = new NationPanel();
        	this.add(panel);
        	this.setTitle("Nation");
        	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	this.setVisible(true);
        }
        
        public static void main(String[]args){
        	NationFrame f = new NationFrame();
        }
}
