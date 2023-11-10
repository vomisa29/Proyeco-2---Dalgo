 
public class Grafo {
	private int[][] grafo;
	private int k;

	public Grafo(int k) {
		int[][] grafo = new int[k][k];
		for(int i = 0;i<k;i++) {
			for(int j = 0;j<k;j++) {
				grafo[i][j] = -1;
			}
		}
		this.grafo = grafo;
		this.k = k;
	}
	
	public void verificarGrafo() {
		for(int i = 0;i<k;i++) {
			for(int j = 0;j<k;j++) {
				System.out.print(grafo[i][j] + "	");
			}System.out.println("\n");
		}System.out.println("\n");
	}

	public int[][] getGrafo() {
		return grafo;
	}

	public void setGrafo(int[][] grafo) {
		this.grafo = grafo;
	}
	
	
	

}
