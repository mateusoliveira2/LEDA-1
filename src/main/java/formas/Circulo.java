package formas;

public class Circulo implements Forma{
	private static final double PI = 3.14;
	private double raio;
	
	public Circulo(double raio) {
		this.raio = raio;
	}

	@Override
	public double calculaArea() {
		return raio * raio * PI;
	}
	
}
