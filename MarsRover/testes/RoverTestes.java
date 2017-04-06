package testes;

import static org.junit.Assert.*;
import entities.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RoverTestes {

	Rover rov;
	@Before
	public void setUp() throws Exception {
		rov = new Rover(new Plateau(5,5),
						new Coordenadas(1, 3, Direcao.NORTH));
	}

	@Test(expected=IllegalArgumentException.class)
	public void roverConstrExcp1Teste() {
		Rover rov = new Rover(null, new Coordenadas(1, 3, Direcao.NORTH));

	}

	@Test(expected=IllegalArgumentException.class)
	public void roverConstrExcp2Teste() {
		Rover rov = new Rover(new Plateau(5,5), null);

	}

	@Test(expected=IllegalArgumentException.class)
	public void roverConstrExcp3Teste() {
		Rover rov = new Rover(new Plateau(5,5),
				              new Coordenadas(6, 1, Direcao.NORTH));
	}

	@Test(expected=IllegalArgumentException.class)
	public void roverConstrExcp4Teste() {
		Rover rov = new Rover(new Plateau(5,5),
				              new Coordenadas(1, 6, Direcao.NORTH));
	}

	@Test(expected=IllegalArgumentException.class)
	public void roverConstrExcp5Teste() {
		Rover rov = new Rover(new Plateau(5,5),
				              new Coordenadas(1, 3, null));
	}

	@Test
	public void moveRoverTeste() {
		rov.moveRover('L');
		assertEquals(Direcao.WEST,rov.getCoord().getFacing());

		rov.moveRover('R');
		assertEquals(Direcao.NORTH,rov.getCoord().getFacing());

		rov.moveRover('M');
		assertEquals(4,rov.getCoord().getyCoord());


	}
}
