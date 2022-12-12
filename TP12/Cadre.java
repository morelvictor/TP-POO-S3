
import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;

public class Cadre extends JFrame{

	class Carre extends JPanel implements MouseInputListener{
		boolean moving = false;
		public Carre(){


			super();
			setBounds(100, 200, 50, 50);
			setBackground(Color.blue);
			addMouseListener(this);
			addMouseMotionListener(this);
		}

		public void mouseExited(MouseEvent e){}
		public void mouseEntered(MouseEvent e){}
		public void mouseReleased(MouseEvent e){}
		public void mousePressed(MouseEvent e){}
		public void mouseClicked(MouseEvent e){
			moving = !moving;
			System.out.println("Changement d'état, moving = " + moving);
		}
		public void mouseMoved(MouseEvent e){
			if(moving)
				this.setLocation(getX() + (e.getX() - getWidth()/2), getY() + (e.getY() - getHeight() / 2));
		}
		public void mouseDragged(MouseEvent e){}
	}
	
	JPanel container;

	public Cadre(){
		super();
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		container = new JPanel( null );
		Carre carre = new Carre();
		container.add(carre);
		this.add(container);
	}

	public static void main(String[] args){
		SwingUtilities.invokeLater(
			new Runnable(){
				public void run(){
					Cadre c = new Cadre();
					c.setVisible(true);
				}
			}
		);
	}
}
