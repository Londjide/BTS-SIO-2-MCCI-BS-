package myHash;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;

public class ChoixDuFichier {
	static File fichier;

	public static void ChoixFichier() throws IOException {

		JFileChooser dialogue = new JFileChooser(new File("C:\\Users\\El Nadje\\Downloads\\Documents"));
		PrintWriter sortie;

		if (dialogue.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			fichier = dialogue.getSelectedFile();
			sortie = new PrintWriter(new FileWriter(fichier.getPath(), true));
			sortie.println();
			sortie.close();
		}
	}

	public static void main(String[] args) {

		try {
			ChoixFichier();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String pathFile() {
		return fichier.getPath();
	}

//	public byte[] getBytes() throws IOException {
//		// TODO Auto-generated method stub
//		byte[] byteFile = Files.readAllBytes(Paths.get("fichier"));
//
//		return byteFile;

//		return null;
//	}

	public static File getFile() {
		// TODO Auto-generated method stub
		return fichier;
	}
}
