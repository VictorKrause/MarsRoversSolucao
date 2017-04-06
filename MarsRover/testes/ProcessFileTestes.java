package testes;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import persistence.*;
import entities.*;

public class ProcessFileTestes {

	@Test(expected=FileNotFoundException.class)
	public void RoverConstrExcepTeste() throws FileNotFoundException {
		FileProcess fp = null;

		fp = new FileProcess("xxxxxxxxxx.txt");
	}
	@Test
	public void RoverConstr2RoversTeste() {
		FileProcess fp = null;
		try {
			fp = new FileProcess("MarsTestFile1.txt");
		}
		catch (FileNotFoundException fex) {
			fex.printStackTrace();
		}
		assertEquals(5, fp.getPlt().getTopLimitX());
		assertEquals(5, fp.getPlt().getTopLimitY());

		fp.nextRover();
		assertEquals(1, fp.getRov().getCoord().getxCoord());
		assertEquals(2, fp.getRov().getCoord().getyCoord());
		assertEquals(Direcao.NORTH, fp.getRov().getCoord().getFacing());
		assertEquals("LMLMLMLMM", fp.getLinhaComando());

		fp.nextRover();
		assertEquals(3, fp.getRov().getCoord().getxCoord());
		assertEquals(3, fp.getRov().getCoord().getyCoord());
		assertEquals(Direcao.EAST, fp.getRov().getCoord().getFacing());
		assertEquals("MMRMMRMRRM", fp.getLinhaComando());
	}

}
