import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class proyecto_2 {
	private int numMatrices;
	private ArrayList<matriz> listaMatrices = new ArrayList<matriz>();

	public void cargaDatos(String dirArchivo) {
		File doc = new File(dirArchivo);
		try {
			BufferedReader archivo = new BufferedReader(new FileReader(doc));
			String line;
			line = archivo.readLine();
			this.numMatrices = Integer.parseInt(line);
			while(numMatrices > 0) {
				line = archivo.readLine();
				String[] stringInfo = line.split(" ");
				int n = Integer.parseInt(stringInfo[0]);
				int m = Integer.parseInt(stringInfo[1]);
				int k = Integer.parseInt(stringInfo[2]);
				int[][] matrizBase = new int[n][m];
				
				for(int i = 0; i< n;i++) {
				   line = archivo.readLine();
				   String[] stringMatriz = line.split(" ");
				   for(int j = 0; j<m;j++) {
					   matrizBase[i][j] = Integer.parseInt(stringMatriz[j]);
				   }
				   
				}
				
				matriz matrizActual = new matriz(n,m,k,matrizBase);
				this.listaMatrices.add(matrizActual);
				numMatrices--;
			}
			
			archivo.close();

		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
	public void Solucion() {
		for(matriz matrizActual: listaMatrices) {
			matrizActual.subMatrizMIN();
			Grafo grafo = null;
			try {
				grafo = matrizActual.crearGrafo();
				int[] resultado = grafo.bfsDependencias();
				for(int i: resultado) {
					int[] tamano = matrizActual.tamano(i);
					System.out.println((i+1)+ " " +
									tamano[0] + " "+
									tamano[1] + " "+
									tamano[2] + " "+
									tamano[3] );
				}
			} catch (Exception e) {
				System.out.println("NO SE PUEDE");
			}
		}
	}
	

}
