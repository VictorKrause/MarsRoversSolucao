package ctlr;

import java.io.FileNotFoundException;
import java.util.Scanner;

import entities.*;
import persistence.FileProcess;

public class MarsRover {

	public static void main(String[] args) {
		Scanner keyB = new Scanner(System.in);
		String fileName;
		FileProcess fProc = null;

		System.out.println("Mars Rover - Deploying Rovers");
		System.out.println("");

		System.out.println("Digite o nome do arquivo: ");
		fileName = keyB.nextLine();
		try {
			fProc = new FileProcess(fileName);
		}
		catch (FileNotFoundException fex) {
			System.out.println("Arquivo " + fileName + " não encontrado");
			System.exit(1);
		}

		System.out.println("\n");
		System.out.println("Plateau:\t" + fProc.getPlt().getTopLimitX() + " " +
										 fProc.getPlt().getTopLimitX());

		fProc.nextRover();
		while(fProc.getRov() != null){
			System.out.println("\nRover:\t\t" + fProc.getRov().getCoord().getxCoord() + " " +
											 fProc.getRov().getCoord().getyCoord() + " " +
											 fProc.getRov().getCoord().getFacing() + " ");
			System.out.println("Comando:\t" + fProc.getLinhaComando());
			Util.processCommand(fProc.getRov(), fProc.getLinhaComando());
			System.out.println("Output:\t\t" + fProc.getRov().getCoord().getxCoord() + " " +
					 						 fProc.getRov().getCoord().getyCoord() + " " +
					 						 fProc.getRov().getCoord().getFacing() + " ");
			fProc.nextRover();
		}
	}

}
