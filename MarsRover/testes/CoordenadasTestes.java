package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entities.Coordenadas;
import entities.Direcao;

public class CoordenadasTestes {

	private Coordenadas coord;
	@Before
	public void setUp() throws Exception {
		coord = new Coordenadas(1, 3, Direcao.NORTH);
	}

	@Test
	public void CoordenadasConstrutorTest() {
		assertEquals(1, coord.getxCoord());
		assertEquals(3, coord.getyCoord());
		assertEquals(Direcao.NORTH, coord.getFacing());
	}

	@Test
	public void GetFacingTest() {
		coord = new Coordenadas(1,3, Direcao.EAST);
		assertEquals(Direcao.EAST, coord.getFacing());
		coord = new Coordenadas(1,3, Direcao.WEST);
		assertEquals(Direcao.WEST, coord.getFacing());
		coord = new Coordenadas(1,3, Direcao.SOUTH);
		assertEquals(Direcao.SOUTH, coord.getFacing());
	}

	@Test
	public void SetFacingTest() {
		coord.setFacing(Direcao.SOUTH);
		assertEquals(Direcao.SOUTH, coord.getFacing());

		coord.setFacing(Direcao.EAST);
		assertEquals(Direcao.EAST, coord.getFacing());

		coord.setFacing(Direcao.WEST);
		assertEquals(Direcao.WEST, coord.getFacing());

		coord.setFacing(Direcao.NORTH);
		assertEquals(Direcao.NORTH, coord.getFacing());
	}


	@Test
	public void turnLeftTest() {
		coord.turnLeft();
		assertEquals(Direcao.WEST, coord.getFacing());

		coord.turnLeft();
		assertEquals(Direcao.SOUTH, coord.getFacing());

		coord.turnLeft();
		assertEquals(Direcao.EAST, coord.getFacing());

		coord.turnLeft();
		assertEquals(Direcao.NORTH, coord.getFacing());
	}


	@Test
	public void turnRightTest() {
		coord.turnRight();
		assertEquals(Direcao.EAST, coord.getFacing());

		coord.turnRight();
		assertEquals(Direcao.SOUTH, coord.getFacing());

		coord.turnRight();
		assertEquals(Direcao.WEST, coord.getFacing());

		coord.turnRight();
		assertEquals(Direcao.NORTH, coord.getFacing());
	}


	@Test
	public void moveFrontTest() {
		coord.moveFront(5, 5);
		assertEquals(1, coord.getxCoord());
		assertEquals(4, coord.getyCoord());

		coord.moveFront(5, 5);
		assertEquals(1, coord.getxCoord());
		assertEquals(5, coord.getyCoord());

		coord.moveFront(5, 5);
		assertEquals(1, coord.getxCoord());
		assertEquals(0, coord.getyCoord());

		coord.moveFront(5, 5);
		coord.turnRight();

		coord.moveFront(5, 5);
		assertEquals(2, coord.getxCoord());
		assertEquals(1, coord.getyCoord());

		coord.moveFront(5, 5);
		assertEquals(3, coord.getxCoord());
		assertEquals(1, coord.getyCoord());

		coord.moveFront(5, 5);
		assertEquals(4, coord.getxCoord());
		assertEquals(1, coord.getyCoord());

		coord.moveFront(5, 5);
		assertEquals(5, coord.getxCoord());
		assertEquals(1, coord.getyCoord());

		coord.moveFront(5, 5);
		assertEquals(0, coord.getxCoord());
		assertEquals(1, coord.getyCoord());

		coord.moveFront(5, 5);
		coord.turnRight();

		coord.moveFront(5, 5);
		assertEquals(1, coord.getxCoord());
		assertEquals(0, coord.getyCoord());

		coord.moveFront(5, 5);
		assertEquals(1, coord.getxCoord());
		assertEquals(5, coord.getyCoord());

		coord.turnRight();

		coord.moveFront(5, 5);
		assertEquals(0, coord.getxCoord());
		assertEquals(5, coord.getyCoord());

		coord.moveFront(5, 5);
		assertEquals(5, coord.getxCoord());
		assertEquals(5, coord.getyCoord());

	}
}
