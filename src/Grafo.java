import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.LinkedList;
import java.util.Queue;

public class Grafo {
	private HashMap<Integer, Set<Integer>> dependencias;
	private HashMap<Integer, Set<Integer>>  gobernantes;
	private int k;

	public Grafo(int k, ArrayList<int[]> listaCoordIN, ArrayList<int[]> listaCoordFIN) {
		this.k = k;
		dependencias = new HashMap<Integer, Set<Integer>>();
		gobernantes = new HashMap<Integer, Set<Integer>>();
	}

	public HashMap<Integer, Set<Integer>> getDependencias() {
		return dependencias;
	}

	public void setDependencias(HashMap<Integer, Set<Integer>> dependencias) {
		this.dependencias = dependencias;
	}

	public HashMap<Integer, Set<Integer>> getGobernantes() {
		return gobernantes;
	}

	public void setGobernantes(HashMap<Integer, Set<Integer>> gobernantes) {
		this.gobernantes = gobernantes;
	}

	public int getK() {
		return k;
	}

	public void setK(int k) {
		this.k = k;
	}

	public void verificarGrafo() {
		System.out.println("Dependencias:");
		for(Entry<Integer, Set<Integer>> entrySet:dependencias.entrySet()) {
			System.out.print((entrySet.getKey()+1)+":");
			for(Integer num: entrySet.getValue()) {
				System.out.print((num+1)+" ");
				
			}
			System.out.println("\n");
			
		}
		
		System.out.println("Gobiernos:");
		for(Entry<Integer, Set<Integer>> entrySet:gobernantes.entrySet()) {
			System.out.print((entrySet.getKey()+1)+":");
			for(Integer num: entrySet.getValue()) {
				System.out.print((num+1)+" ");
				
			}
			System.out.println("\n");
			
		}
		
	}

	public int[] bfsDependencias() {
		ArrayList<Integer> libres = new ArrayList<>();
		ArrayList<Vertice> vertices= new ArrayList<>();
		int[] result = new int[k];
		int contador = 0;
		for(int i = 0; i<k; i++) {
			if (dependencias.get(i).isEmpty()) {
				libres.add(i);
				dependencias.remove(i);
			}
			Vertice v = new Vertice(0);
			vertices.add(v);
			
		}
		
		
		for (int s: libres) {
			Queue<Integer> cola = new LinkedList<Integer>();
			vertices.get(s).setColor(1);
			cola.add(s);
			result[contador] = s;
			contador++;
			while (cola.size() > 0){
				Integer u = cola.remove();
				for (int v: gobernantes.get(u)) {
					if(vertices.get(v).getColor()==0) {
						dependencias.get(v).remove(u);
						if(dependencias.get(v).isEmpty()) {
							vertices.get(v).setColor(1);
							cola.add(v);
							result[contador] = v;
							contador++;
						}
					}
				}
				vertices.get(u).setColor(2);
				
			}
			
		}
		if (contador != k) {
			return null;
		}
		return result;
	}


	
	
	
	
	
	

}
