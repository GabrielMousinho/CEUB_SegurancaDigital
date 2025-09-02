package aulasd0902;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class DES {
	private static String encriptar(String texto, String chave) throws Exception{
		String criptograma = "";
		
		Cipher objCifra = Cipher.getInstance("TripleDES"); // Mudar TripleDES para DES
		SecretKey objChave = new SecretKeySpec(chave.getBytes("UTF-8"), "TripleDES"); // Mudar TripleDES para DES
		objCifra.init(Cipher.ENCRYPT_MODE, objChave);
		byte[] temp = objCifra.doFinal(texto.getBytes("UTF-8"));
		criptograma = Base64.getEncoder().encodeToString(temp);
		
		return criptograma;
	}
	
	private static String decriptar(String criptograma, String chave) throws Exception{
		
		Cipher objCifra = Cipher.getInstance("TripleDES"); // Mudar TripleDES para DES
		SecretKey objChave = new SecretKeySpec(chave.getBytes("UTF-8"), "TripleDES"); // Mudar TripleDES para DES
		objCifra.init(Cipher.DECRYPT_MODE, objChave);
		byte[] temp = objCifra.doFinal(Base64.getDecoder().decode(criptograma));
		
		return new String(temp, "UTF-8");
	}
	
	public static void main (String[] args) {
		BufferedReader leitor = new BufferedReader (new InputStreamReader(System.in));
		String texto = "";
		String chave = "";
		String criptograma = "";
		
		
		
		try {
			System.out.print("Digite o texto: ");
			texto = leitor.readLine();
			
			System.out.print("Digite o chave: ");
			chave = leitor.readLine();
			
			criptograma = encriptar(texto, chave);
			System.out.print(criptograma);
			System.out.println("");
			System.out.print(decriptar(criptograma, chave));
			
		} catch (Exception erro) {
			System.out.print(erro);
		}
	}

}
