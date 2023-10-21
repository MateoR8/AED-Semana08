package semana_08;

import java.util.Random;

public class Arreglo {
	
	//  Atributos privados
	private int[] n;
	private int indice;
	//  Constructor
	public Arreglo() {
		n = new int[10];
		indice = 0;
	}
	//  Operaciones públicas básicas
	public int tamanio() {
		return indice;
	}
	public int obtener(int i) {
		return n[i];
	}
	public void adicionar(int numero) {
		if (indice == n.length)
			ampliarArreglo();
		n[indice] = numero;
		indice ++;
	}
	private void eliminar(int pos) {
		for (int i=pos; i<indice-1; i++)
			n[i] = n[i+1];
		indice --;
	}
	//  Operaciones públicas complementarias
	public void eliminarNumerosPares() {
		for (int i=0; i<indice; i++){
			if(n[i]%2==0){
				eliminar(i);
				i--;
			}
		}
	}
	public void eliminarNumerosImpares() {
		for (int i=0; i<indice; i++){
			if(n[i]%2!=0){
				eliminar(i);
				i--;
			}
		}
	}
	public void eliminarNumerosRepetidos() {
		for (int i=0; i<indice-1; i++){
			for (int j=i+1; j<indice; j++){
				if (n[i] == n[j]){
					eliminar(j);
				}
			}
		}
	}
	public void primerNumeroParAlFinal() {
		int pos = buscarPrimerPar();
		if (pos != -1){
			for (int i=pos; i<indice-1; i++){
					intercambiar(i, i+1);
				}
			}		
	}
	private int buscarPrimerPar() {
		for (int i=0; i<indice; i++)
			if(n[i]%2==0){
				return i;
			}	
		return -1;
	}
	private void intercambiar(int pos1, int pos2) {
		int aux = n[pos1];
		n[pos1] = n[pos2];
		n[pos2] = aux;
	}
	public void barajarNumeros() {
		Random random = new Random();
        for (int i = indice-1; i >= 0; i--) {
            int j = random.nextInt(indice);

            // Intercambia array[i] con array[j]
            int temp = n[i];
            n[i] = n[j];
            n[j] = temp;
        }
	}
	
	//  Operaciones privadas
	private void ampliarArreglo() {
		int[] aux = n;
		n = new int[indice + 10];
		for (int i=0; i<indice; i++)
			n[i] = aux[i];
	}

}