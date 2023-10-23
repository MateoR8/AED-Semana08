package semana_08;

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

	//  Operaciones privadas
	private void ampliarArreglo() {
		int[] aux = n;
		n = new int[indice + 10];
		for (int i=0; i<indice; i++)
			n[i] = aux[i];
	}
	public void adicionar(int numero) {
		if (indice == n.length)
			ampliarArreglo();
		n[indice] = numero;
		indice ++;
	}
	
	public void intercambiar(int i, int j) {
		int aux = n[i];
		n[i] = n[j];
		n[j] = aux;
	}
	
	private int buscar(int numero) {
		for (int i = 0; i < indice; i++)
			if (n[i] == numero)
				return i;
		return -1;
	}

	public void adicionarYreubicar(int numero) {
		int num = buscar(numero);
        if (num == -1) {
            adicionar(numero);
        }
		
        int[] aux = new int[indice];
        int auxIndex = 0;

        for (int i = 0; i < indice; i++) {
            if (n[i] % 2 == 0) {
                aux[auxIndex] = n[i];
                auxIndex++;
            }
        }

        for (int i = 0; i < indice; i++) {
            if (n[i] % 2 != 0) {
                aux[auxIndex] = n[i];
                auxIndex++;
            }
        }
        n = aux;
	}
}