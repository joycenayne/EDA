package testesComp;

import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class TesteUtil {		
	public static ArrayList<Empresa> getDadosIniciais(String path) throws IOException{
		Empresa p = null;
		ArrayList<Empresa> entrada = new ArrayList<>();
		Scanner scan = new Scanner(new FileReader(path)).useDelimiter(", |\r\n");
		try{
			while(scan.hasNext()){
				p = new Empresa(scan.next().substring(5), scan.next().substring(5), scan.next().substring(13), scan.next().substring(13), scan.next().substring(5), scan.next().substring(6), scan.next().substring(4), scan.next().substring(4), scan.next().substring(7), scan.next().substring(7), scan.next().substring(7), scan.next().substring(7), scan.next().substring(9), scan.next().substring(8));
				entrada.add(p);
			}			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(p.toString());
			System.out.println("1");
		}
		scan.close();
		return entrada;
	}
	
}

