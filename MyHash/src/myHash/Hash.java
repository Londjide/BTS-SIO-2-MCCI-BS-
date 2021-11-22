package myHash;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Scanner;

public class Hash

{

	static int reponse;

	final static String algoDeChiffrement() {
		String algo;
		do {
			System.out.println(
					"Veillez saisir votre type d'alogrithme de chiffement pour commencer entre Blowfish, AES, RSA, SHA-512... ");

			Scanner ecrir = new Scanner(System.in);
			algo = ecrir.nextLine();
		} while (algo == "");
		return algo;
	}

	public static String ALGO = algoDeChiffrement();

	public static void text2Hash(String ALGO) {

		String chaine;
		Scanner src = new Scanner(System.in);
		System.out.println("Saisir le texte à hacher : ");
		chaine = src.nextLine();

//		do {
//			System.out.println("Tapez au moins un caractère : ");
//
//		} while (chaine == null || chaine.length() < 1);

		src.close();

		System.out.printf("Le Texte suivant est de %d caractère : \n \n %s \n", chaine.length(), chaine);

		try {
			byte[] donneeOctet = chaine.getBytes();
			System.out.println(donneeOctet);
			MessageDigest monHash = MessageDigest.getInstance(ALGO);
			monHash.update(donneeOctet);
			byte[] condenser = monHash.digest();
			System.out.println(condenser);
			System.out.printf("\n Algo de Hachage " + ALGO + " du texte: " + "(" + condenser.length + " octets)\n");
			System.out.println("****** Affichage du condensé ****** \n");

			for (int i = 0; i < condenser.length; i++) {
				System.out.printf(condenser[i] + " ");
			}

			System.out.println("\n\n En décimale: " + new BigInteger(condenser));
			System.out.println("\n En Hexadécimale: " + new BigInteger(condenser).toString(16));

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void printText() {
		ChoixDuFichier xFile = new ChoixDuFichier();
		try {
			ChoixDuFichier.ChoixFichier();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try (BufferedReader LectureFile = new BufferedReader(new FileReader(ChoixDuFichier.pathFile()))) {
			String line;
			while ((line = LectureFile.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public static void file2Hash(String pathfile) {
		try {
//			ChoixDuFichier xFile = new ChoixDuFichier();
//			xFile.ChoixFichier();
//			String cheminFile = ChoixDuFichier.pathFile();
			printText();

			RandomAccessFile readData = new RandomAccessFile(ChoixDuFichier.pathFile(), "r");
//			System.out.println("myFile: " + readData.toString());

			byte[] donneeOctet = new byte[(int) readData.length()];
			MessageDigest monHash = MessageDigest.getInstance(ALGO);
			monHash.update(donneeOctet);

			byte[] condenser = monHash.digest();

			System.out.printf("Le Texte suivant est de %d caractère : \n \n %s \n", readData.length(),
					readData.toString());
			System.out.printf("\n Algo de Hachage " + ALGO + " du texte: " + "(" + condenser.length + " octets)\n");
			System.out.println("****** Affichage du condensé ****** \n");

			for (int i = 0; i < condenser.length; i++) {
				System.out.printf(condenser[i] + " ");
			}

			System.out.println("\n\n En décimale: " + new BigInteger(condenser));
			System.out.println("\n En Hexadécimale: " + new BigInteger(condenser).toString(16));

		} catch (Exception e) {
			System.out.println(e);

		}
	}

//	EssaieChoixFichier ChoixFichier = new EssaieChoixFichier();

	public static void main(String[] args) throws Exception {

//		System.out.println("Hello World ! \n Que souhaitez vous faire ? \n");
//
//		Scanner src = new Scanner(System.in);
//
//		System.out.println("Choix 1 : \n  Hacher la Phrase de votre choix?\n \t Ou \n "
//				+ "Choix 2 : \n Hacher un Fichier contenue depuis votre poste?");
//		reponse = src.nextInt();
//
//		System.out.println(reponse);
//
//		if (reponse == 1) {
//			text2Hash(ALGO);
//		} else if (reponse == 2) {
//			file2Hash(ALGO);
//		}

		ApiRSA generateKeyPair = new ApiRSA();
		ApiRSA.generateKeyPair();
		System.out.println(generateKeyPair);
//		ApiRSA.sign(ALGO, SHA256);
	}

}
