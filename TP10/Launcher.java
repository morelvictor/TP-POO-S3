
import java.awt.*;

class Launcher {
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			ImageEditModel model = new ImageEditModel("blason.png");
			ImageEditView view = new ImageEditView(model);
			view.pack();
			view.setVisible(true);
		});
	}
}
