
//import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.*;
import javax.swing.undo.*;

class ImageEditModel {

	class Coupe {
		Rectangle z;
		int[][] pixels;

		public Coupe(int x, int y, int width, int height, BufferedImage image) {
			z = new Rectangle(x, y, width, height);
			pixels = new int[height][width];
			for (int xi = 0; xi < image.getWidth(); xi++) {
				for (int yi = 0; yi < image.getHeight(); yi++) {
					pixels[yi][xi] = image.getRGB(xi, yi);
				}
			}
		}

		public void doit() {
			ImageEditModel.this.clearZone(z);
		}

		public void undo() {
			ImageEditModel.this.fillZone(z, pixels);
		}
	}

	class CutEdit extends AbstractUndoableEdit {
		Coupe c;

		public CutEdit(Coupe cp) {
			c = cp;
		}

		public void undo() {
			super.undo();
			c.undo();
		}

		public void redo() {
			super.redo();
			c.doit();
		}
	}

	BufferedImage image;
	UndoManager undoManager = new UndoManager();

	ImageEditModel(String path) {
		try {
			image = ImageIO.read(new File(path));
		} catch (IOException e) {
			System.out.println("Problème lors de la lecture du fichier" + path);
		}
	}

	BufferedImage getImage() {
		return image;
	}

	public void fillZone(Rectangle z, int[][] pixels) {
		for (int x = 0; x < z.width; x++) {
			for (int y = 0; y < z.height; y++) {
				image.setRGB(x + (int) z.getX(), y + (int) z.getY(), pixels[y][x]);
			}
		}
	}

	public void clearZone(Rectangle z) {
		for (int x = z.x; x < z.x + z.width; x++) {
			for (int y = z.y; y < z.y + z.height; y++) {
				try {
					image.setRGB(x, y, Color.white.getRGB());
				} catch (Exception e) {
					System.out.println(z);
				}
			}
		}
	}

	public void saveCut(Rectangle z) {
		BufferedImage cut = image.getSubimage((int) z.getX(), (int) z.getY(), (int) z.getWidth(), (int) z.getHeight());
		Coupe c = new Coupe((int) z.getX(), (int) z.getY(), (int) z.getWidth(), (int) z.getHeight(), cut);
		c.doit();
		undoManager.addEdit(new CutEdit(c));
	}
}
