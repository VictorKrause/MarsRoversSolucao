package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entities.Coordenadas;
import entities.Direcao;
import entities.Plateau;

public class PlateauTestes {

	private Plateau plt;

	@Before
	public void setUp() throws Exception {
		plt = new Plateau(5, 5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void PlateauConstrExcp1Test() {
		Plateau p = new Plateau(5, -1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void PlateauConstrExcp2Test() {
		Plateau p = new Plateau(-1, 5);
	}

	@Test
	public void PlateauMoveTestTest() {
		Coordenadas atual = new Coordenadas(1, 3, Direcao.NORTH), nova = null;

		nova = plt.move('L', atual);
		assertEquals(1, nova.getxCoord());
		assertEquals(3, nova.getyCoord());
		assertEquals(Direcao.WEST, nova.getFacing());

		nova = plt.move('R', atual);
		assertEquals(1, nova.getxCoord());
		assertEquals(3, nova.getyCoord());
		assertEquals(Direcao.EAST, nova.getFacing());

		nova = plt.move('M', atual);
		assertEquals(1, nova.getxCoord());
		assertEquals(4, nova.getyCoord());
		assertEquals(Direcao.NORTH, nova.getFacing());

		nova = plt.move('X', atual);
		assertEquals(null, nova);
	}



}
