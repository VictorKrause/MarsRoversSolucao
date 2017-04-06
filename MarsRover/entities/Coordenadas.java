package entities;

public class Coordenadas  implements Cloneable{
	private int xCoord, yCoord;
	private int facing;

	public Coordenadas(int x, int y, Direcao f) {
		setxCoord(x);
		setyCoord(y);
		setFacing(f);
	}

	private int fromDirecaoToDegree(Direcao f) {
		int res = 0;

		if (f == null)
			throw new IllegalArgumentException("Direção inválida: " + f);
		else
			switch (f) {
			case NORTH: res = 90;
			break;
			case SOUTH: res = 270;
			break;
			case EAST: res = 0;
			break;
			case WEST: res = 180;
			break;
			}
		return res;
	}

	private Direcao fromDegreeToDirecao(int g) {
		Direcao res = null;

		switch (g) {
		case 90: res = Direcao.NORTH;
		break;
		case 270: res = Direcao.SOUTH;
		break;
		case 0: res = Direcao.EAST;
		break;
		case 180: res = Direcao.WEST;
		break;
		default: throw new IllegalArgumentException("Grau inválido: " + g);
		}
		return res;
	}

	public int getxCoord() {
		return xCoord;
	}
	public void setxCoord(int xCoord) {
		this.xCoord = xCoord;
	}
	public int getyCoord() {
		return yCoord;
	}
	public void setyCoord(int yCoord) {
		this.yCoord = yCoord;
	}
	public Direcao getFacing() {
		return fromDegreeToDirecao(facing);
	}
	public void setFacing(Direcao f) {
		this.facing = fromDirecaoToDegree(f);
	}

	public void turnLeft() {
		facing = (facing + 90) % 360;
	}

	public void turnRight() {
		facing = (facing != 0) ? ((facing - 90) % 360) : (270);
	}

	public void moveFront(int topLimitX, int topLimitY) {
		topLimitX += 1;
		topLimitY += 1;

		switch (getFacing()) {
		case NORTH: setyCoord((getyCoord() + 1) % topLimitY);
		break;
		case SOUTH: if (getyCoord() > 0)
			setyCoord(getyCoord() - 1);
		else
			setyCoord(topLimitY-1);
		break;
		case EAST:  setxCoord((getxCoord() + 1) % topLimitX);
		break;
		case WEST: if (getxCoord() > 0)
			setxCoord(getxCoord() - 1);
		else
			setxCoord(topLimitX-1);
		break;
		}
	}

	public Object clone(){
		try{
			return super.clone();
		}catch(Exception e){
			return null;
		}
	}

	public String toString(){
		String res = "";

		res = "X = " + getxCoord() +
				" Y = " + getyCoord() +
				" Direção = " + getFacing();

		return res;
	}
}
