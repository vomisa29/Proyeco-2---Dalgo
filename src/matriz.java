import java.util.ArrayList;

public class matriz {
	private int m;
	private int n;
	private int k;
	private int[][] matriz;
	private ArrayList<int[]> listaCoordIN = new ArrayList<int[]>();
	private ArrayList<int[]> listaCoordFIN = new ArrayList<int[]>();
	
	public matriz(int n, int m, int k, int[][] matriz) {
		this.n = n;
		this.m = m;
		
		this.k = k;
		this.matriz = matriz;
		for(int i = 0; i<this.k;i++) {
			int[] base_1 = new int[2];
			base_1[0] = -1;
			base_1[1] = -1;
			int[] base_2 = new int[2];
			base_2[0] = -1;
			base_2[1] = -1;
			this.listaCoordIN.add(i,base_1);
			this.listaCoordFIN.add(i,base_2);
		}
	}
	
	public void subMatrizMIN() {
		for(int i = 0;i<this.n;i++) {
			
			for(int j = 0;j<this.m;j++) {
				int llaveActual = this.matriz[i][j];
				int indiceLista = llaveActual-1;
				if(this.listaCoordIN.get(indiceLista)[0] == -1) {
					this.listaCoordIN.get(indiceLista)[0] = n;
					this.listaCoordIN.get(indiceLista)[1] = m;
					this.listaCoordFIN.get(indiceLista)[0] = 0;
					this.listaCoordFIN.get(indiceLista)[1] = 0;
					
				}
				if(listaCoordIN.get(indiceLista)[0] > i) {
					listaCoordIN.get(indiceLista)[0] = i;
					
					
				}
				if (listaCoordFIN.get(indiceLista)[0] < i){
					listaCoordFIN.get(indiceLista)[0] = i;
				}
				
				if(listaCoordIN.get(indiceLista)[1] > j) {
					listaCoordIN.get(indiceLista)[1] = j;
					
				}
				if (listaCoordFIN.get(indiceLista)[1] < j){
					listaCoordFIN.get(indiceLista)[1] = j;
				}		
			}
		}
	}
	
	public Grafo crearGrafo() {
		Grafo grafoActual = new Grafo(this.k); 
	    
	    for(int llaveActual = 0; llaveActual < this.k; llaveActual++) {
	    	
	    	int i_final = listaCoordFIN.get(llaveActual)[0];
	    	int j_final = listaCoordFIN.get(llaveActual)[1];
	    	
	    	for(int i_inicial = listaCoordIN.get(llaveActual)[0];i_inicial <= i_final;i_inicial++) {
	    		for(int j_inicial = listaCoordIN.get(llaveActual)[1];j_inicial <= j_final;j_inicial++) {
	    			grafoActual.getGrafo()[llaveActual][this.matriz[i_inicial][j_inicial]-1] = 1;
	    		}
	    	}
	    }
	    return grafoActual;
	}
	

}
