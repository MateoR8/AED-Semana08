package semana_08;

public class Arreglo {

	// Atributos privados
	private int[] n;
	private int indice;

	// Constructor
	public Arreglo() {
		n = new int[10];
		indice = 0;
	}

	// Operaciones públicas básicas
	public int tamanio() {
		return indice;
	}

	public int obtener(int i) {
		return n[i];
	}

	// Operaciones privadas
	private void ampliarArreglo() {
		int[] aux = n;
		n = new int[indice + 10];
		for (int i = 0; i < indice; i++)
			n[i] = aux[i];
	}

	public void adicionar(int numero) {
		if (indice == n.length)
			ampliarArreglo();
		n[indice] = numero;
		indice++;
	}

	private void intercambiar(int num1, int num2) {
		int aux = n[num1];
		n[num1] = n[num2];
		n[num2] = aux;
	}

	private int buscar(int numero) {
		for (int i = 0; i < indice; i++)
			if (n[i] == numero)
				return i;
		return -1;
	}

	public void menoraMayor() {
		for (int i = 0; i < indice; i++) {
			for (int j = 0; j < indice; j++) {
				if (n[i] < n[j]) {
					intercambiar(i, j);
				}
			}
		}
	}

	public void adicionarDistintoYordenar(int numero) {
		int num = buscar(numero);
		if(num == -1) {
			adicionar(numero);
		}
		menoraMayor();
	}
}