package formas;

public class Quadrado implements Forma {
	
	private double lado;

	public Quadrado(double lado) {
		this.lado = lado;
	}
	
	@Override
	public double calculaArea() {
		return lado * lado;
	}

}
