package persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import entities.*;

public class FileProcess {
	private Scanner sc = null;
	private Rover rov = null;
	private Plateau plt = null;
	private String linhaComando = null;

	public FileProcess(String nameFile) throws FileNotFoundException {
		String linha = null;
		String []linhaSplit = null;

		sc = new Scanner(new File(nameFile));
		int xPl, yPl;

		if (sc == null)
			throw new IllegalArgumentException("Nome de arquivo inválido.");

		if (sc.hasNextLine()) {
			linha = sc.nextLine();

			linhaSplit = linha.split(" ");
			xPl = Integer.parseInt(linhaSplit[0]);
			yPl = Integer.parseInt(linhaSplit[1]);
		}
		else
			throw new IllegalArgumentException("Arquivo inválido:coordendas Plateau!");

		plt = new Plateau(xPl, yPl);
	}

	public void nextRover()  {
		Rover res = new Rover();
		String linha = null;
		String []linhaSplit = null;
		int xRo, yRo;
		Direcao rDi;

		if (sc.hasNextLine()) {
			linha = sc.nextLine();
			linhaSplit = linha.split(" ");
			xRo = Integer.parseInt(linhaSplit[0]);
			yRo = Integer.parseInt(linhaSplit[1]);

			switch (linhaSplit[2]) {
			case "N": rDi = Direcao.NORTH; break;
			case "S": rDi = Direcao.SOUTH; break;
			case "E": rDi = Direcao.EAST; break;
			case "W": rDi = Direcao.WEST; break;
			default:throw new IllegalArgumentException("Arquivo inválido: direcao!");
			}

			res = new Rover(plt, new Coordenadas(xRo, yRo, rDi));
		}
		else
			res = null;

		rov = res;

		if (sc.hasNextLine()) {
			linha = sc.nextLine();

			for(int i = 0; i < linha.length(); i++)
				if (linha.charAt(i) != 'L' && linha.charAt(i) != 'R' &&
					linha.charAt(i) != 'M')
					throw new IllegalArgumentException("Arquivo inválido: comando inválido!");
			linhaComando = linha;
		}
		else
			linhaComando = null;

	}

	public Rover getRov() {
		return rov;
	}

	public Plateau getPlt() {
		return plt;
	}

	public String getLinhaComando() {
		return linhaComando;
	}
}
