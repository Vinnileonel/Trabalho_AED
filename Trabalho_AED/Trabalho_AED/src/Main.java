/*
 * CLASSE PRINCIPAL
 * 
 * SÓ DEVEM ADICIONAR CÓDIGO NAS ZONAS IDENTIFICADAS COM COMENTÁRIOS
 * E ACONSELHA-SE A SEGUIREM OS ALGORITMOS ESPECIFICADOS
 */
public class Main {
	//-----------------------------------------------------------------------------	
	public static void main(String[] args) {	
		Carta baralho[]=criarBaralho();
		Carta j1[]=new Carta[10]; //mão de cada jogador
		Carta j2[]=new Carta[10];
		Carta j3[]=new Carta[10];
		Carta j4[]=new Carta[10];		
		
		System.out.println("--# BARALHO CRIADO #--\n");
		imprimirCartas(baralho);	
		
		baralho=retirar_8_9_10(baralho);
		System.out.println("\n\n--# BARALHO SEM 8, 9 E 10 #--\n");
		imprimirCartas(baralho);
		
		embaralhar(baralho);		
		System.out.println("\n\n--# BARALHO EMBARALHADO #--\n");
		imprimirCartas(baralho);		
		
		darCartas(baralho,j1,j2,j3,j4);
		System.out.println("\n\n--# BARALHO DISTRIBUIDO PELOS JOGADORES #--\n");		
		System.out.println("\n\n --# MÃO DO JOGADOR: 1 #--\n");
		imprimirCartas(j1);
		System.out.println("\n\n --# MÃO DO JOGADOR: 2 #--\n");
		imprimirCartas(j2);
		System.out.println("\n\n --# MÃO DO JOGADOR: 3 #--\n");
		imprimirCartas(j3);
		System.out.println("\n\n --# MÃO DO JOGADOR: 4 #--\n");
		imprimirCartas(j4);
		
		ordenar_jog1(j1);
		ordenar_jog2(j2);
		ordenar_jog3(j3);
		ordenar_jog4(j4);
		System.out.println("\n\nMÃO ORDENADA DO JOGADOR: 1 #--\n");
		imprimirCartas(j1);
		System.out.println("\n\nMÃO ORDENADA DO JOGADOR: 2 #--\n");
		imprimirCartas(j2);
		System.out.println("\n\nMÃO ORDENADA DO JOGADOR: 3 #--\n");
		imprimirCartas(j3);
		System.out.println("\n\nMÃO ORDENADA DO JOGADOR: 4 #--\n");
		imprimirCartas(j4);
	}
	//-----------------------------------------------------------------------------	
	public static Carta[] criarBaralho(){
		Carta bar[]=new Carta[52];
		int i=0;
		for(int n=Carta.COPAS;n<=Carta.PAUS;n++)
			for(int f=Carta.AZ;f<=Carta.REI;f++){
				bar[i]=new Carta(f,n);
				i++;
			}
		return bar;
	}
	//-----------------------------------------------------------------------------		
	public static void imprimirCartas(Carta car[]){
		for(int i=0;i<car.length;i++)System.out.println(car[i]);
	}
	//-----------------------------------------------------------------------------	
	public static void embaralhar(Carta bar[]){
		/*
		 *  IMPLEMENTAR ESTE ALGORITMO DE PREFERÊNCIA QUE REFLITA 
		 *  A FORMA COMO BARALHAMOS NA PRÁTICA
		 */
		 
		//SUGESTÃO 1
		//repete 30x
			//retira um monte menor que metade do baralho e
			//insere-o num ponto aleatorio no monte que sobrou
		
		//SUGESTÃO 2
		//repete 30x
			//divide o baralho em dois montes iguais esq/dir
				//retira um numero aleatorio de cartas (entre 2 e 5) 
				//de cada monte e coloca no baralho
				//até este ter as 40 cartas novamente
		
		//SUGESTÃO 3
		//repete 30x
			//retira um monte menor que metade do baralho e
				//retira um numero aleatorio de cartas (entre 2 e 5) e
				//insere num ponto aleatorio no monte que sobrou
				//até não ter cartas neste monte
	}
	//-----------------------------------------------------------------------------	
	public static Carta[] retirar_8_9_10(Carta bar[]){
		/*
		 *	CRIAR UM VECTOR DE CARTAS NOVO
		 *	COM EXCLUSÃO DOS 8, 9 E 10
		 *	ADICIONAR A ESTE VECTOR TODAS AS CARTAS DO BARALHO 		 
		 *	DEVOLVER O VECTOR NOVO
		 */

		return null;
	}
	//-----------------------------------------------------------------------------	
	public static void darCartas(Carta bar[],Carta j1[],Carta j2[],Carta j3[],Carta j4[]){
		/*
		 * ENQUANTO NÃO CHEGAR AO FIM DO BARALHO
		 *   DAR UMA CARTA A CADA JOGADOR
		 */
	}
	//-----------------------------------------------------------------------------	
	public static void ordenar_jog1(Carta j1[]){
		/*
		 * IMPLEMENTAR EM CADA UM DESTES MÉTODOS UM ALGORITMO DE ORDENAÇÃO
		 * DIFERENTE
		 *
		 * PARA COMPARAR DUAS CARTAS USAR A FUNÇÃO compareTo() 
		 *
		 */
	}
	//-----------------------------------------------------------------------------	
	public static void ordenar_jog2(Carta j2[]){
		/*
		 * A IMPLEMENTAR
		 */
	}
	//-----------------------------------------------------------------------------	
	public static void ordenar_jog3(Carta j3[]){
		/*
		 * A IMPLEMENTAR
		 */
	}
	//-----------------------------------------------------------------------------	
	public static void ordenar_jog4(Carta j4[]){
		/*
		 * A IMPLEMENTAR
		 */	
	}
	//-----------------------------------------------------------------------------	
}
