package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ctlr.Util;
import entities.*;

public class ProcessCommandLineTestes {

	@Test
	public void processCommandTeste() {
		Rover rov = new Rover(new Plateau(5,5), new Coordenadas(0,0,Direcao.NORTH));

		Util.processCommand(rov, "MMMMMRMMMMMRMMMMMRMMMMRRRLM");
		assertEquals(2,rov.getCoord().getxCoord());
		assertEquals(0,rov.getCoord().getyCoord());
		assertEquals(Direcao.EAST,rov.getCoord().getFacing());
	}

}
