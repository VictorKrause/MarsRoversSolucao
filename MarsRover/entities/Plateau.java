package entities;

public class Plateau {
	private int topLimitX;
	private int topLimitY;

	public Plateau(int limX, int limY){
		if (limX >= 0)
			topLimitX = limX;
		else
			throw new IllegalArgumentException("X máximo inválido:" + limX);

		if (limY >= 0)
			topLimitY = limY;
		else
			throw new IllegalArgumentException("Y máximo inválido:" + limY);
	}

	public int getTopLimitX() {
		return topLimitX;
	}

	public int getTopLimitY() {
		return topLimitY;
	}

	public Coordenadas move(char mov, Coordenadas atual) {
		Coordenadas nova = (Coordenadas) atual.clone();

		mov = Character.toUpperCase(mov);

		switch(mov){
		case 'L': nova.turnLeft(); break;
		case 'R': nova.turnRight(); break;
		case 'M': nova.moveFront(getTopLimitX(), getTopLimitY()); break;
		default: nova = null;
		}

		return nova;
	}
}
