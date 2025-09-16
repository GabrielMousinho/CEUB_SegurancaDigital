package aulasd0916;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Diffie_Hellman {
	private static BigInteger p = new BigInteger("102031405123416071809152453627382938465749676859789");
	private static BigInteger g = new BigInteger("1234567890123456789012345");
	
	public static void main(String[] args) {
		BufferedReader leitor = new BufferedReader(new InputStreamReader(System.in));
		BigInteger minhaChaveSecreta = null;
		BigInteger minhaChavePublica = null;
		BigInteger chavePublicaDoDestinatario = null;
		BigInteger nossaChaveCompartilhada = null;
		
		try {
			System.out.print("Escolha a sua chave secreta: ");
			minhaChaveSecreta = new BigInteger(leitor.readLine());
			
			minhaChavePublica = g.modPow(minhaChaveSecreta, p);
			System.out.print("Minha chave pública: " + minhaChavePublica);
			
			System.out.print("\nDigite a chave pública do destinatário: ");
			chavePublicaDoDestinatario = new BigInteger(leitor.readLine());
			
			nossaChaveCompartilhada = chavePublicaDoDestinatario.modPow(minhaChaveSecreta, p);
			System.out.print("Nossa chave compartilhada: " + nossaChaveCompartilhada);
		} catch (Exception erro) {
			System.out.println(erro);
		}
	}
}
