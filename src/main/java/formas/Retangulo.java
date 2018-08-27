package formas;

public class Retangulo implements Forma {
	private int lado;
	private int altura;
	
	public Retangulo(int lado, int altura) {
		this.lado = lado;
		this.altura = altura;
	}
	
	@Override
	public double calculaArea() {
		return lado * altura;
	}

}
