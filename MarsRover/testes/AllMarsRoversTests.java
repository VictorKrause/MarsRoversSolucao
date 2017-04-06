package testes;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CoordenadasTestes.class, PlateauTestes.class, RoverTestes.class,
				ProcessFileTestes.class, ProcessCommandLineTestes.class})
public class AllMarsRoversTests {

}
