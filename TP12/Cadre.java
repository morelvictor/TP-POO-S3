
import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.Random;
import java.util.Set;
import java.util.HashSet;

public class Cadre extends JFrame {

	public static int random(int min, int max) {
		return (int) Math.floor(Math.random() * (max - min + 1) + min);
	}

	class Carre extends JPanel implements MouseInputListener {
		boolean moving = false;
		Cadre container;

		public Carre(Color color, Cadre container) {
			super();
			this.container = container;
			setBounds(random(0, container.getWidth()), random(0, container.getHeight()), 50, 50);
			setBackground(color);
			addMouseListener(this);
			addMouseMotionListener(this);
		}

		public void mouseExited(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
			setBackground(Color.blue);
		}

		public void mouseReleased(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
		}

		public void mouseClicked(MouseEvent e) {
			moving = !moving;
			setBackground(Color.green);
			System.out.println("Changement d'état, moving = " + moving);
		}

		public void mouseMoved(MouseEvent e) {
			if (moving)
				this.setLocation(getX() + (e.getX() - getWidth() / 2), getY() + (e.getY() - getHeight() / 2));
		}

		public void mouseDragged(MouseEvent e) {
		}
	}

	class Model {
		LinkedList<Color> colors;

		public Model() {
			colors = new LinkedList<>();
			for (int i = 0; i < 10; i++) {
				Random rand = new Random();
				float r = rand.nextFloat();
				float g = rand.nextFloat();
				float b = rand.nextFloat();

				colors.add(new Color(r, g, b));
			}
		}
	}

	JPanel container;

	public Cadre() {
		super();
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		container = new JPanel(null);
		Model model = new Model();
		for (Color c : model.colors) {
			container.add(new Carre(c, this));
		}
		this.setContentPane(container);
		finJeu();
	}

	public boolean gagne() {
		Set<Color> colors = new HashSet<>();
		for (Component c : container.getComponents()) {
			if (c instanceof JPanel)
				colors.add(c.getBackground());
		}
		return colors.size() <= 1;

	}

	public void messageGagne() {
		JLabel msg = new JLabel("Bravo tu as gagné");
		container.removeAll();
		container.add(msg);
		container.repaint();

		msg.repaint();
	}

	public void finJeu() {
		MouseInputListener listener = new MouseInputListener() {
			public void mouseEntered(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent e) {
				if (gagne())
					dispose();
			}

			public void mouseReleased(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mouseMoved(MouseEvent e) {
				if (gagne())
					messageGagne();
			}

			public void mouseDragged(MouseEvent e) {
			}

		};
		addMouseListener(listener);
		addMouseMotionListener(listener);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(
				new Runnable() {
					public void run() {
						Cadre c = new Cadre();
						c.setVisible(true);
					}
				});
	}
}
