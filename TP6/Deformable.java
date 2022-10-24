interface Deformable{
	// A mon avis on peut implémenter l'interface pour toutes les classes, mais c'est utile seulement dans Rectangle, Ellipse et Triangle
	Figure deformation(double coeffH, double coeffV);
}
