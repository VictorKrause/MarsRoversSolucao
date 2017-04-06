package entities;

public class Rover {
	private Coordenadas coord;
	private Plateau plateau;

	public Rover() {
		coord = null;
		plateau = null;
	}

	public Rover(Plateau pl, Coordenadas c) {
		deployRover(pl, c);
	}

	void deployRover(Plateau pl, Coordenadas c) {
		if (pl != null)
			plateau = pl;
		else
			throw new IllegalArgumentException("Plateau inválido:" + pl);

		if (c == null)
			throw new IllegalArgumentException("Coordenadas inválidas:" + c);
		else {

			if ( c.getxCoord() < 0 || c.getxCoord() > pl.getTopLimitX())
				throw new IllegalArgumentException("Coordenada x inválida:" + c.getxCoord());

			if ( c.getyCoord() < 0 || c.getyCoord() > pl.getTopLimitY())
				throw new IllegalArgumentException("Coordenada y inválida:" + c.getyCoord());

			if (c.getFacing() == null)
				throw new IllegalArgumentException("Direção inválida:" + c.getFacing());

			coord = c;
		}
	}

	public void moveRover(char mov) throws IllegalMoveException {
		Coordenadas c = null;

		if (plateau != null && coord != null) {
			c = plateau.move(mov, coord);
			if (c != null)
				coord = c;
			else
				throw new IllegalMoveException("Plateau não reconheceu o movimento: " + mov);
		}
		else
			throw new IllegalMoveException("Rover não está em um plateau.");

	}
	public Coordenadas getCoord() {
		return coord;
	}

	public Plateau getPlateau() {
		return plateau;
	}
}
