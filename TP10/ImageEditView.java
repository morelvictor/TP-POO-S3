
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ImageEditView extends JFrame {
	class ImagePane extends JPanel {
		Selection selection = new Selection();

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(model.getImage(), 0, 0, this);
			((Graphics2D) g).draw(selection.getRectangle());
		}

		ImagePane() {
			super();
			setPreferredSize(new Dimension(model.image.getWidth(), model.image.getHeight()));
			addMouseListener(selection);
			addMouseMotionListener(selection);
		}

		class Selection extends MouseAdapter implements MouseMotionListener {
			int x1, y1, x2, y2;

			Rectangle getRectangle() {
				return new Rectangle(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
			}

			public void mousePressed(MouseEvent event) {
				this.x1 = event.getX();
				this.y1 = event.getY();
				ImageEditView.this.cutButton.setEnabled(false);
				ImageEditView.this.imagePane.repaint();
			}

			public void mouseDragged(MouseEvent event) {
				this.x2 = event.getX();
				this.y2 = event.getY();
				ImageEditView.this.cutButton.setEnabled(true);
				ImageEditView.this.imagePane.repaint();
			}

			public void mouseMoved(MouseEvent event) {
			}
		}
	}

	JButton cutButton, undoButton, redoButton;
	ImagePane imagePane;
	ImageEditModel model;

	public ImageEditView(ImageEditModel m) {
		model = m;
		this.setTitle("EdiTux");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JMenuBar jmb = new JMenuBar();

		cutButton = new JButton("cut");
		undoButton = new JButton("undo");
		redoButton = new JButton("redo");

		cutButton.addActionListener((ActionEvent e) -> {
			model.saveCut(imagePane.selection.getRectangle());
			imagePane.repaint();
			cutButton.setEnabled(false);
		});

		undoButton.addActionListener((ActionEvent e) -> {
			if (model.undoManager.canUndo()) {
				model.undoManager.undo();
				imagePane.repaint();
			}
		});

		redoButton.addActionListener((ActionEvent e) -> {
			if (model.undoManager.canRedo()) {
				model.undoManager.redo();
				imagePane.repaint();
			}
		});

		cutButton.setEnabled(false);
		undoButton.setEnabled(true);
		redoButton.setEnabled(true);

		jmb.add(cutButton);
		jmb.add(undoButton);
		jmb.add(redoButton);

		this.setJMenuBar(jmb);

		imagePane = new ImagePane();
		this.setContentPane(imagePane);
	}

}
