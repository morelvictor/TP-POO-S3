
import javax.swing.*;
import java.awt.*;

public class Vue extends JFrame {

	Palette p;
	JPanel panneauColore = new JPanel();
	JLabel etiqCouleur = new JLabel("Vert");
	JPanel panneauChoix = new JPanel();
	Modele c;

	JButton mem = new JButton("Memoriser");
	JButton rap = new JButton("S'en rappeler");
	JButton com = new JButton("Complementaire");

	JSlider r = new JSlider(0, 100, 0);
	JSlider v = new JSlider(0, 100, 0);
	JSlider b = new JSlider(0, 100, 0);

	public Vue(Palette p, Modele m) {
		super("Palette");
		this.p = p;
		this.c = m;
		this.setSize(800, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		panneauColore.setBackground(new Color(c.r, c.v, c.b));
		panneauColore.setLayout(new BorderLayout());
		panneauColore.add(etiqCouleur, BorderLayout.CENTER);
		etiqCouleur.setHorizontalAlignment(SwingConstants.CENTER);

		this.getContentPane().add(panneauChoix);
		this.getContentPane().add(panneauColore);
		this.getContentPane().setLayout(new GridLayout());

		r.setMajorTickSpacing(25);
		r.setMinorTickSpacing(5);
		r.setPaintTicks(true);
		r.setPaintLabels(true);
		v.setMajorTickSpacing(25);
		v.setMinorTickSpacing(5);
		v.setPaintTicks(true);
		v.setPaintLabels(true);
		b.setMajorTickSpacing(25);
		b.setMinorTickSpacing(5);
		b.setPaintTicks(true);
		b.setPaintLabels(true);

		r.addChangeListener((event) -> {
			p.c.sliderMoved();
			miseAJour();
		});

		v.addChangeListener((event) -> {
			p.c.sliderMoved();
			miseAJour();
		});

		b.addChangeListener((event) -> {
			p.c.sliderMoved();
			miseAJour();
		});

		mem.addActionListener((e) -> {
			p.c.memoriser();
		});

		rap.addActionListener((e) -> {
			p.c.serappeler();
			miseAJour();
			miseAJourSlider();
		});

		com.addActionListener((e) -> {
			p.c.complementaire();
			miseAJour();
			miseAJourSlider();
		});

		panneauChoix.add(r);
		panneauChoix.add(v);
		panneauChoix.add(b);

		panneauChoix.add(mem);
		panneauChoix.add(rap);
		panneauChoix.add(com);
	}

	public void miseAJour() {
		panneauColore.setBackground(new Color(c.r, c.v, c.b));
	}

	public void miseAJourSlider() {
		r.setValue((int) (c.r / 2.5));
		v.setValue((int) (c.v / 2.5));
		b.setValue((int) (c.b / 2.5));
	}

}
