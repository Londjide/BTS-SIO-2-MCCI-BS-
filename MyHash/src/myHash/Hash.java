package myHash;

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

	public static void text2Hash(String algo) {

		String chaine;
		Scanner src = new Scanner(System.in);
		System.out.println("Saisir le texte à hacher : ");
		chaine = src.nextLine();

		do {
			System.out.println("Tapez au moins un caractère : ");

		} while (chaine == null || chaine.length() < 1);

		src.close();

		System.out.printf("Le Texte suivant est de %d caractère : \n \n %s \n", chaine.length(), chaine);

		try {
			byte[] donneeOctet = chaine.getBytes();
			MessageDigest monHash = MessageDigest.getInstance(algo);
			monHash.update(donneeOctet);

			byte[] condenser = monHash.digest();
			System.out.printf("\n Algo de Hachage " + algo + " du texte: " + "(" + condenser.length + " octets)\n");
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

	public static String ALGO = algoDeChiffrement();

	public static void file2Hash(String Pathfile) {
		try {

			RandomAccessFile readData = new RandomAccessFile(Pathfile, "r");
			byte[] donneeOctet = new byte[(int) readData.length()];
			MessageDigest monHash = MessageDigest.getInstance(ALGO);
			monHash.update(donneeOctet);

			byte[] condenser = monHash.digest();
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

	public static void main(String[] args) {

		System.out.println("Hello World ! \n Que souhaitez vous faire ? \n");

		Scanner src = new Scanner(System.in);

		System.out.println("Choix 1 : \n  Hacher la Phrase de votre choix?\n \t Ou \n "
				+ "Choix 2 : \n Hacher un Fichier contenue depuis votre poste?");
		reponse = src.nextInt();

		System.out.println(reponse);

		if (reponse == 1) {

			text2Hash(ALGO);
		}

	}
}
