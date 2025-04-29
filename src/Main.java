/*
 * CLASSE PRINCIPAL
 * 
 * SÓ DEVEM ADICIONAR CÓDIGO NAS ZONAS IDENTIFICADAS COM COMENTÁRIOS
 * E ACONSELHA-SE A SEGUIREM OS ALGORITMOS ESPECIFICADOS
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

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
		Random rnd = new Random();
		ArrayList<Carta> lista = new ArrayList<>(Arrays.asList(bar));
		for (int t = 0; t < 30; t++){            // 30 vezes
			int maxPacote = lista.size()/2;      // nunca mais de metade
			int tamPacote = rnd.nextInt(maxPacote) + 1;
			int inicio    = rnd.nextInt(lista.size() - tamPacote + 1);
			ArrayList<Carta> pacote = new ArrayList<>(lista.subList(inicio,inicio+tamPacote));
			for (int i = 0; i < tamPacote; i++) lista.remove(inicio); // retira
			int destino = rnd.nextInt(lista.size() + 1);              // insere
			lista.addAll(destino, pacote);
		}
		for (int i = 0; i < bar.length; i++) bar[i] = lista.get(i);   // copia p/ array
	}
	//-----------------------------------------------------------------------------	
	public static Carta[] retirar_8_9_10(Carta bar[]){
		  ArrayList<Carta> tmp = new ArrayList<>();
    for (Carta c : bar){
        int f = c.getFace();                 // 8 / 9 / 10 ficam de fora
        if (f != 8 && f != 9 && f != 10) tmp.add(c.clone());
    }
    Carta[] novo = new Carta[tmp.size()];
    for (int i = 0; i < tmp.size(); i++) novo[i] = tmp.get(i);
    return novo;                             // devolve baralho com 40 cartas

		//return null;
	}
	//-----------------------------------------------------------------------------	
	public static void darCartas(Carta bar[],Carta j1[],Carta j2[],Carta j3[],Carta j4[]){
			int[] idx = {0,0,0,0};                    // posição livre em cada mão
			for (int i = 0; i < bar.length; i++){
				switch (i % 4){
					case 0 -> j1[idx[0]++] = bar[i];
					case 1 -> j2[idx[1]++] = bar[i];
					case 2 -> j3[idx[2]++] = bar[i];
					case 3 -> j4[idx[3]++] = bar[i];
				}
			}
		}

	//-----------------------------------------------------------------------------	
	public static void ordenar_jog1(Carta j1[]){
		for (int i = j1.length-1; i > 0; i--)
        for (int k = 0; k < i; k++)
            if (j1[k].compareTo(j1[k+1]) > 0){
                Carta tmp = j1[k]; j1[k] = j1[k+1]; j1[k+1] = tmp;
            }
	}
	//-----------------------------------------------------------------------------	
	public static void ordenar_jog2(Carta j2[]){
		for (int i = 1; i < j2.length; i++){
			Carta chave = j2[i];
			int j = i-1;
			while (j >= 0 && j2[j].compareTo(chave) > 0){
				j2[j+1] = j2[j];
				j--;
			}
			j2[j+1] = chave;
		}
	}
	//-----------------------------------------------------------------------------	
	public static void ordenar_jog3(Carta j3[]){
		for (int i = 0; i < j3.length-1; i++){
			int min = i;
			for (int j = i+1; j < j3.length; j++)
				if (j3[j].compareTo(j3[min]) < 0) min = j;
			Carta tmp = j3[i]; j3[i] = j3[min]; j3[min] = tmp;
		}
	}
	
	//-----------------------------------------------------------------------------	
	public static void ordenar_jog4(Carta j4[]){
		int n = j4.length;
		int[] low  = new int[n], high = new int[n];   // pilha de intervalos
		int top = -1;
		low[++top] = 0; high[top] = n-1;
	
		while (top >= 0){
			int l = low[top], h = high[top--];
			if (l >= h) continue;
	
			// partição (pivô = extremo direito)
			Carta pivot = j4[h];
			int i = l;
			for (int j = l; j < h; j++){
				if (j4[j].compareTo(pivot) <= 0){
					Carta t = j4[i]; j4[i] = j4[j]; j4[j] = t;
					i++;
				}
			}
			Carta t = j4[i]; j4[i] = j4[h]; j4[h] = t; // coloca pivô
	
			// empilha sub-arrays
			low[++top] = l;   high[top] = i-1;
			low[++top] = i+1; high[top] = h;
		}	
	}
	//-----------------------------------------------------------------------------	
}
