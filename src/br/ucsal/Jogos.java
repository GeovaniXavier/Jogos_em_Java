package br.ucsal;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;


public class Jogos {

	public static void main(String[] args) {		// METODO MAIN
		bemVindo();
		cadastroUsuario("", 0);




	}
	//M�TODO DE BOAS VINDAS
	public static void bemVindo() {					// METODO DE IMPRESS�O DE BOAS VINDAS
		imprimir("Seja bem vindo ao LPA Games 1.0"
				+ "\nAntes de irmos para o menu, Fa�a o login"
				+ "\n==========================================\n");
	}

	//M�TODO QUE CADASTRA OS USU�RIOS:
	public static void cadastroUsuario(String user, int op) {		
		Scanner imput = new Scanner(System.in);
		String[] usuario = new String[2];
		usuario[0] = user;
		if(usuario[0].equals("")) {								// VERIFICA SE JA TEM ALGUM USUARIO CADASTRADO
			imprimir("Insira o nome do usuario 1: \n");
			usuario[0] = imput.next().toUpperCase();
			validaUsuario(0);
			imprimir ("Usuario1: " + usuario[0] + " - Validado com sucesso" + "\n");
			imprimir("\n ==========================="
					+ "\n Seja bem vindo: " + usuario[0]);
			usuario[1] = "";
			menu(usuario, op);
		} else {												// CASO JA TENHA UM USUARIO CADASTRADO PEDIR� O SEGUNDO USU�RIO
			imprimir("Insira o nome do usuario 2\n");
			usuario[1] = imput.next().toUpperCase();
			validaUsuario(111);
			imprimir ("Usuario2: " + usuario[1] + " - Validado com sucesso" + "\n");
			imprimir("\n ==========================="
					+ "\n Sejam bem vindos: " + usuario[0] + " e " + usuario[1]);
			menu(usuario, op);
		}
	}

	//M�TODO QUE IMPRIME O MENU:
	public static void menu (String[] usuario, int op) {
		String user1 = usuario[0];
		String user2 = usuario[1];
		Scanner imput = new Scanner(System.in);
		int menu = op;
		if(menu == 0) {
			imprimir("\n ==========================="
					+ "\n Escolha qual jogo deseja jogar:"
					+ "\n [1] Jogo da forca"
					+ "\n [2] Batalha naval"
					+ "\n [3] Campo minado"
					+ "\n [4] Sair\n");
			menu = imput.nextInt();
		}

		switch(menu) {													// VERIFICA QUAL OP��O ESCOLHIDA NO MENU
		case 1:
			if(user2.equals("")) {
				imprimir("Este jogo requer 2 usu�rios\n");
				cadastroUsuario(usuario[0], menu);
			} else {

				imprimir("\n ==========================="
						+ "\nIniciando Jogo da forca...\n\n");
				inicioForca(user1, user2);
			}
			break;
		case 2:
			if(user2.equals("")) {
				imprimir("Este jogo requer 2 usu�rios\n");
				cadastroUsuario(usuario[0], menu);
			} else {

				imprimir("\n ==========================="
						+ "\nIniciando Batalha naval...");
				inicioBatalhaNaval(user1, user2);
			}
			break;
		case 3:
			imprimir("\nIniciando Campo minado\n\n");
			campoMinado(user1, user2);
			break;
		case 4:
			imprimir("Jogo encerrado!");
			System.exit(0);
			break;
		default:
			imprimir("Voc� digitou uma op��o inv�lida, Tente novamente: \n");
			menu(usuario, 0);

			break;
		}
	}

	// M�TODO PARA VALIDA��O DA SENHA DO USUARIO:
	public static void validaUsuario (int pass) {
		Scanner imput = new Scanner(System.in);
		int[] senha = new int[2];
		senha[0] = pass;


		if(senha[0] != 111) {										// PERGUNTA A SENHA DO USU�RIO ( M�TODO SIMBOLICO )
			imprimir("Insira a senha do Usuario 1"
					+ "                     'A senha para o usuario 1 �: 111' \n");
			senha[0] = imput.nextInt();
			while(senha[0] != 111) {
				imprimir("Voc� digitou a senha errada, Tente novamente: \n");
				senha[0] = imput.nextInt();
			}
		} else { imprimir("Insira a senha do Usuario 2 "
				+ "                     'A senha para o usuario 2 �: 222' \n");
		senha[1] = imput.nextInt();
		while(senha[1] != 222) {
			imprimir("Voc� digitou a senha errada, Tente novamente: \n");
			senha[1] = imput.nextInt();


		}
		}

	}

	//INICIO JOGO DA FORCA




	public static int resultForca = 0; 
	public static void inicioForca(String user1, String user2) {      		// FAZ AS CHAMADAS DO JOGO DA FORCA, RECEBENDO OS USUARIOS CADASTRADOS
		int scorep1 = 0, scorep2 = 0;
		int forcaGame = 0;

		imprimir("Bem vindo ao jogo da forca. "
				+ "\nVoc� ter� 6 tentativas para adivinhar a palavra dita pelo seu oponente\n"
				+ "\nquem obtiver menos erros ganha! \n");
		for (int i = 0; i < 1; i++) {


			if(forcaGame == 0) { 						//VERIFICA SE � A PRIMEIRA OU SEGUNDA PARTIDA

				forca(user1, user2);
				scorep2 = resultForca;
				forcaGame = 1;
			}
			if(forcaGame == 1) {

				forca(user2, user1);
				scorep1 = resultForca;
			}
		}
		if(scorep1 < scorep2) { 					//IMPRIME O RESULTADO DA PARTIDA
			imprimir(user1 + " ganhou de " + user2 + " com  " + scorep1 + " erros, contra " + scorep2 + " do jogador " + user2 );
		} else if (scorep1 > scorep2) {
			imprimir(user2 + " ganhou de " + user1 + " com  " + scorep2 + " erros, contra " + scorep1 + " do jogador " + user1 );
		} else if (scorep1 == scorep2) {
			imprimir("O jogo empatou");
		}

		imprimir("\n\nO Que deseja fazer agora?\n");			// VERIFICA SE O USUARIO GOSTARIA DE ENCERRAR O JOGO OU VOLTAR AO MENU
		imprimir("[1] - Voltar ao Menu \n");
		imprimir("[2] - Sair\n");

		int fimjogoforca;
		Scanner imput = new Scanner(System.in);
		fimjogoforca = imput.nextInt();
		String[] usuariosfim = new String[2];
		usuariosfim[0] = user1;
		usuariosfim[1] = user2;
		switch (fimjogoforca) {
		case 1:
			menu(usuariosfim, 0);
			break;
		case 2:
			imprimir("\n Obrigado por jogar\n\n Jogo encerrado!");
			System.exit(0);
			break;

		default:
			imprimir("\n Voc� escolheu uma op��o inv�lida, indo para o Menu!");
			menu(usuariosfim, 0);
			break;
		}


	}

	public static void forca(String player1, String player2) { //METODO DE EXECU��O DO JOGO
		Scanner imput = new Scanner(System.in);
		imprimir("\nAgora � a vez de " + player1 + " digitar uma palavra para " + player2 + " adivinhar");
		imprimir("\nDigite a palavra: ");
		String palavra = imput.next().toUpperCase();   							//L� A PRIMEIRA PALAVRA


		imprimir("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

		forcaEnforcado(0, palavra);												//IMPRIME A FORCA VAZIA
		resultForca = 0;
		imprimir("\n");
		String[] palavraTemp = new String[palavra.length()];
		String[] palavraTemp2 = palavra.split("");								//SEPARA A PALAVRA EM UMA LETRA POR ESPA�O NO ARRAY
		for (int i = 0; i < palavra.length(); i++) {
			imprimir("-");
			palavraTemp[i] = "-";

		}

		imprimir("\n");

		int sair = 0;
		for (int i = 0; sair < 6; i++) {							//REPETI��O QUE PEDE E CHECA A LETRA PARA O USUARIO
			imprimir("\n" + player2 + " Digite uma letra: \n");
			String letra = imput.next().toUpperCase();



			for (int j = 0; j < palavra.length(); j++) {

				if(letra.charAt(0) == palavra.charAt(j)) {
					imprimir(letra);
					palavraTemp[j] = letra;
				} else {
					if(palavraTemp[j] != "-") {
						imprimir(palavraTemp[j]);
					} else {
						imprimir("-");



					}
				}
				if(Arrays.equals(palavraTemp, palavraTemp2)) {
					sair = 6;

				}
			}
			for (int j = 0, a = 0, b = 0; j < palavra.length(); j++) {  			// CONTABILIZA OS PONTOS E MOSTRA O RESULTADO
				if(letra.charAt(0) != palavra.charAt(j)) {
					a++;
				} else {
					b++;
				}
				if(a == palavra.length()) {
					resultForca++;
					sair++;
					forcaEnforcado(resultForca, palavra);
				} else if (j == palavra.length()-1 && b>0 ) {
					imprimir("\nParabens, voc� acertou a letra\n");
					if(Arrays.equals(palavraTemp, palavraTemp2)) {
						imprimir("\nParabens, voc� acertou a palavra completa\n");

					}
				}
			}
		}
	}



	public static void forcaEnforcado(int contador, String palavra) { //M�TODO QUE IMPRIME A FORCA
		if (contador == 0) {
			System.out.println("");
			System.out.println("   ____________");
			System.out.println("   |           |");
			System.out.println("   |           ");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   | ");
			System.out.println("___|___");
		}
		if (contador == 1) {
			System.out.println("\nVoc� errou, Tente novamente");
			System.out.println("   ____________");
			System.out.println("   |           |");
			System.out.println("   |           O");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   | ");
			System.out.println("___|___");
		}
		if (contador == 2) {
			System.out.println("\nVoc� errou, Tente novamente");
			System.out.println("   ____________");
			System.out.println("   |           |");
			System.out.println("   |           O");
			System.out.println("   |           |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   | ");
			System.out.println("___|___");
		}
		if (contador == 3) {
			System.out.println("\nVoc� errou, Tente novamente");
			System.out.println("   ____________");
			System.out.println("   |           |");
			System.out.println("   |           O");
			System.out.println("   |          /|");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   | ");
			System.out.println("___|___");
		}
		if (contador == 4) {
			System.out.println("\nVoc� errou, Tente novamente");
			System.out.println("   ____________");
			System.out.println("   |           |");
			System.out.println("   |           O");
			System.out.println("   |          /|\\");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   | ");
			System.out.println("___|___");
		}
		if (contador == 5) {
			System.out.println("\nVoc� errou, Tente novamente");
			System.out.println("   ____________");
			System.out.println("   |           |");
			System.out.println("   |           O");
			System.out.println("   |          /|\\");
			System.out.println("   |          /   ");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   | ");
			System.out.println("___|___");
		}
		if (contador == 6) {
			System.out.println("\nVoc� errou pela ultima vez");
			System.out.println("   ____________");
			System.out.println("   |           |");
			System.out.println("   |           O");
			System.out.println("   |          /|\\");
			System.out.println("   |          / \\");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   | ");
			System.out.println("___|___");
			System.out.println("Fim de jogo, a palavra era " + palavra);
		}

	} // FIM DO JOGO DA FORCA


	// INICIO DO JOGO BATALHA NAVAL

	public static int linhas = 11;
	public static int colunas = 11;
	public static String[][] tabJogo1 = new String[linhas][colunas];
	public static String[][] tabJogo2 = new String[linhas][colunas];
	public static String[][] tabJogoOculto1 = new String[linhas][colunas];
	public static String[][] tabJogoOculto2 = new String[linhas][colunas];

	public static void inicioBatalhaNaval(String user1, String user2) {                                                 // Pedindo o nome dos 2 usu�rios que foi pegado l� no menu.

		tutorial();                                                                                                     // Vai mostrar a introdu��o + um simples tutorial do jogo (objetivo, como ganhar, etc.);
		criarTabuleiro1();                                                                                              // Mostra o tabuleiro, al�m de prepar�-lo para quando o m�todo 'imprimirTabuleiro' for chamado;     
		intrucoesPosicionamento();                                                                                      // Vai mostrar as instru��es de posicionamento dos navios no tabuleiro;
		posicaoNaviosJog1(user1);                                                                                       // Inicia a coloca��o de pe�as do jogador n� 1;
		intrucoesPosicionamento();                                                                                      // Vai mostrar as instru��es de posicionamento dos navios no tabuleiro, dessa vez para o pr�ximo jogador;
		criarTabuleiro2();                                                                                              // Mostra o tabuleiro, al�m de prepar�-lo para quando o m�todo 'imprimirTabuleiro2' for chamado;
		posicaoNaviosJog2(user2);                                                                                       // Inicia a coloca��o de pe�as do jogador n� 1;
		System.out.println("\n\nO jogo foi preparado e seus tabuleiros foram escondidos.");                             // Essas impress�es s�o um migu�, pois � necess�rio criar/inicializar o criarTabuleiroOculto1 e 2 para depois;
		System.out.println("Abaixo est� os tabuleiros escondidos de voc�s.");

		System.out.println("\n\nTabuleiro do JOGADOR 1# " + user1);                            
		criarTabuleiroOculto1();                                                               

		System.out.println("\n\nTabuleiro do JOGADOR 2# " + user2);
		criarTabuleiroOculto2();

		System.out.println("\n\nIniciaremos agora a partida. Boa sorte a ambos!");
		System.out.println("\n\n________________________________________________________________");
		System.out.println("\n");
		contadorPontos(user1, user2);                                                                                       // Agora que os criarTabuleiroOculto j� foram inicializados, podemos come�ar a tentar afundar os navios;


		imprimir("\n\nO Que deseja fazer agora?\n");
		imprimir("[1] - Voltar ao Menu \n");
		imprimir("[2] - Sair\n");

		int fimjogoforca;
		Scanner imput = new Scanner(System.in);
		fimjogoforca = imput.nextInt();
		String[] usuariosfim = new String[2];
		usuariosfim[0] = user1;
		usuariosfim[1] = user2;
		switch (fimjogoforca) {
		case 1:
			menu(usuariosfim, 0);
			break;
		case 2:
			imprimir("\n Obrigado por jogar\n\n Jogo encerrado!");
			System.exit(0);
			break;

		default:
			imprimir("\n Voc� escolheu uma op��o inv�lida, indo para o Menu!");
			menu(usuariosfim, 0);
			break;
		}
	}

	public static void tutorial() {                                                                                         // Introdu��o;
		System.out.println("\n\n[ B A T A L H A  N A V A L ]");
		System.out.println("");
		System.out.println(">> Bem-vindos ao jogo 'Batalha Naval', Almirante!");
		System.out.println(">> Nesse jogo, o seu objetivo � descobrir onde est�o os navios inimigos e afund�-los.");
		System.out.println(">> Os navios (ambos seus e do inimigo) se encontraram num tabuleiro 10 x 10.");
		System.out.println(">> Quem conseguir afundar TODOS os 4 navios primeiro ser� o vencedor.");
		System.out.println(">> Voc� ser� guiado a distribuir o seus navios em alguns instantes.");
		System.out.println(">> Boa sorte!");
		System.out.println("__________________________________________________________");

	}

	public static void intrucoesPosicionamento() {                                                                          // Instru��o de posicionamento;

		System.out.println("\nN�s iremos agora come�ar a fase de posicionamento dos navios.");
		System.out.println("\nLeia com ATEN��O as regras abaixo:");
		System.out.println("- Existem 4 navios a serem distribuidos pelo tabuleiro.");
		System.out.println("- Os navios devem estar conectados e em linha reta (horizontal ou vertical);");
		System.out.println("- Todos os segmentos do navio devem estar dentro do tabuleiro.");
		System.out.println("- Para determinar a posi��o, ser� pedido primeiramente a COLUNA e depois a LINHA.");
		System.out.println("\nOs navios e seus comprimentos s�o:");
		System.out.println( "  * Porta avi�es --------- 5 segmentos;\r\n" +
				"  * Navios-tanque -------- 4 segmentos;\r\n" +
				"  * Contratorpedeiros ---- 3 segmentos;\r\n" +
				"  * Submarinos ----------- 2 segmentos;");

		System.out.println("\n[AVISO] Uma vez posicionado, o navio N�O PODE ser removido do tabuleiro. Escolha com cuidado a posi��o.");
	}

	public static void posicaoNaviosJog1(String user1) {                                                                    // Etapas que ser�o feitas durante o posicionamento;
		// Pediu denovo o nome do usu�rio l� do m�todo 'inicioBatalhaNaval';
		System.out.println("\n >>> JOGADOR 1# : " + user1 +" <<<");                                                         // Usando o nome do usu�rio n� 1;
		posicaoSubJog1();
		posicaoCTJog1();
		posicaoNTJog1();
		posicaoPAJog1();

	}

	public static void posicaoSubJog1() {                                                                                   // Colocando o SUBMARINO no tabuleiro;
		String vertOuHoriz = "", dirOuEsq = "", cimaOuBaixo = "";                                                           // Strings que ir�o armazenar a dire��o que o navio ser� posto ap�s a pe�a inicial;
		int x, y;                                                                                                           // Coordenadas a serem usadas para posicionar no tabuleiro;
		Scanner userInput = new Scanner(System.in);                                            

		System.out.println("\nO primeiro navio ser� o SUBMARINO.");

		do {                                                                                                                // Repeti��o que faz a pessoa obrigatoriamente colocar um n�mero entre 0 e 9;
			System.out.print("\nPor favor, escolha onde o primeiro segmento do 'SUBMARINO' dever� ficar [COLUNA]: ");
			x = userInput.nextInt();                                                                                        // Armazena input do usu�rio em 'x';

			if (x < 0 || x >= 10) {                                                                                         // Se o n�mero for menor de 0 ou maior/igual a 10, aparece essa mensagem;
				System.out.println("\n[ERRO] N�mero fora dos par�metros pedidos, tente novamente.");
			}
		} while (x < 0 || x >= 10);

		do {                                                                                                                // Mesma coisa que acima, s� que com o 'y';
			System.out.print("\nPor favor, escolha onde o primeiro segmento do 'SUBMARINO' dever� ficar [LINHA]: ");
			y = userInput.nextInt();                                                                                       

			if (y < 0 || y >= 10) {
				System.out.println("\n[ERRO] N�mero fora dos par�metros pedidos, tente novamente.");
			}
		} while (y < 0 || y >= 10);



		tabJogo1[x][y] = "O";                                                                                               // Com tudo OK, a String na posi��o [x][y] vira um 'O' (s�mbolo escolhido quando a posi��o est� ocupada por um navio);

		do {                                                                                                                // Vai fazer esse 'loop' at� ter escolhido uma das duas op��es;
			System.out.print("\nDeseja colocar esse navio na vertical (V) ou horizontal (H)? ");
			vertOuHoriz = userInput.next().toUpperCase().substring(0, 1);
		} while (!vertOuHoriz.equals("V") && !vertOuHoriz.equals("H"));

		switch (vertOuHoriz) {                                                                                              // 'Switch/case' para, dependendo da op��o do usu�rio, fazer uma coisa ou outra; (poderia ter sido um if/else tamb�m)
		case "H":                                                                                                           // Nesse caso, � para ver se o usu�rio quer colocar o navio na vertical ("V") ou horizontal ("H");

			do {                                                                                                            // Vai fazer esse 'loop' at� ter escolhido uma das duas op��es;
				System.out.print("\nDeseja colocar na direita (D) ou esquerda (E) da coordenada escolhida? ");
				dirOuEsq = userInput.next().toUpperCase().substring(0, 1);
			} while (!dirOuEsq.equals("D") && !dirOuEsq.equals("E"));

			switch (dirOuEsq) {
			case "D":                                                                                                       // Se for escolhido para a direita ("D"), adicionar� um 'O' na pr�xima coordenada a direita do ponto inicial escolhido mais acima;
				tabJogo1[x][(y + 1)] = "O";
				break;

			case "E":                                                                                                       // Se for escolhido para a esquerda ("E"), adicionar� um 'O' na pr�xima coordenada a direita do ponto inicial escolhido mais acima;
				tabJogo1[x][(y - 1)] = "O";
				break;

			default:                                                                                                        // N�o tem 'default' porque voc� necess�riamente deve escolher ou entre "D" ou "E" devido o loop mais acima;
				break;
			}
			break;                                                                                                          // Acaba o 'switch/case' da String 'dirOutEsq';

		case "V":

			do {
				System.out.print("\nDeseja colocar para cima (C) ou para baixo (B) da coordenada escolhida? ");                 // Se escolheu a op��o vertical ("V"), aparecer� essa outra bifurca��o;
				cimaOuBaixo = userInput.next().toUpperCase().substring(0, 1);
			} while (!cimaOuBaixo.equals("C") && !cimaOuBaixo.equals("B"));

			switch (cimaOuBaixo) {                                                                                          // Basicamente uma repeti��o do que foi falado acima, s� que dessa vez � para cima ("C") ou para baixo ("B");
			case "C":  
				tabJogo1[(x - 1)][y] = "O";
				break;

			case "B":
				tabJogo1[(x + 1)][y] = "O";
				break;

			default:               
				break;
			}  
			break;                                                                                                          // Acaba o 'switch/case' da String 'cimaOuBaixo;

		default:                                                                                                            // Acaba o 'switch/case' da String 'vertOuHoriz';
			break;
		}      

		imprimirTabuleiro1();                                                                                               // Imprime o tabuleiro para a pessoa ver o navio colocado na posi��o do tabuleiro e planejar as pr�ximas;

	}

	public static void posicaoCTJog1() {                                                                                    // Colocando o CONTRATORPEDEIRO no tabuleiro;
		String vertOuHoriz = "", dirOuEsq = "", cimaOuBaixo = "";
		int x, y;
		Scanner userInput = new Scanner(System.in);
		// Basicamente a mesma coisa, s� vai mudar tr�s coisa mais embaixo (indicado nos pr�ximos coment�rios);
		System.out.println("\n O segundo navio ser� o CONTRATORPEDEIRO.");

		do {
			do {       
				System.out.print("Por favor, escolha onde o primeiro segmento do 'CONTRATORPEDEIRO' dever� ficar [COLUNA]: ");
				x = userInput.nextInt();
				System.out.print("Por favor, escolha onde o primeiro segmento do 'CONTRATORPEDEIRO' dever� ficar [LINHA]: ");
				y = userInput.nextInt();

				if (x > (tabJogo1.length - 2) || y > (tabJogo1.length - 2)) {
					System.out.println("\nPosi��o fora do tabuleiro. Tente novamente.");
					System.out.println("");
				}

			} while(x > (tabJogo1.length - 2) || y > (tabJogo1.length - 2));

			if (tabJogo1[x][y] == "O") {                                                                                    // Se a coordenada j� possuir um "O", vai pedir para fazer denovo devido ao loop 'do/while';
				System.out.println("\nPosi��o j� possui uma pe�a. Tente novamente.");                                       // E vai mostrar essa mensagem;
				System.out.println("");
			}
		} while(tabJogo1[x][y] == "O");

		tabJogo1[x][y] = "O";

		do {
			System.out.print("\nDeseja colocar esse navio na vertical (V) ou horizontal (H)? ");
			vertOuHoriz = userInput.next().toUpperCase().substring(0, 1);
		} while (!vertOuHoriz.equals("V") && !vertOuHoriz.equals("H"));

		switch (vertOuHoriz) {
		case "H":
			do {                                                                                                        // Esse 'do/while' loop vai fazer com que...                   
				do {
					System.out.print("\nDeseja colocar na direita (D) ou esquerda (E) da coordenada escolhida? ");
					dirOuEsq = userInput.next().toUpperCase().substring(0, 1); 
				} while (!dirOuEsq.equals("D") && !dirOuEsq.equals("E"));  

				switch (dirOuEsq) {
				case "D":
					if (tabJogo1[x][(y + 1)] == "~" && tabJogo1[x][(y + 2)] == "~") {                                   // ... caso, quando for complementar com os outros segmentos do navio, encontrar uma "O"...
						tabJogo1[x][(y + 1)] = "O";                                                                     // ... vai pedir para o usu�rio tentar novamente, para um lado diferente;
						tabJogo1[x][(y + 2)] = "O";
					} else {
						System.out.println("\n[ERRO] Existe um navio em uma das coordenadas a serem preenchidas. Tente novamente.");        // Mostra essas mensagens tamb�m;
					}
					break;

				case "E":
					if (tabJogo1[x][(y - 1)] == "~" && tabJogo1[x][(y - 2)] == "~") {                                   // A mesma coisa aqui, isso vai se repetir at� acabar os navios, sempre adicionando coordenadas novas, j� que os navios aumentam de comprimento (2, 3, 4 e 5);
						tabJogo1[x][(y - 1)] = "O";
						tabJogo1[x][(y - 2)] = "O";
					} else {
						System.out.println("\n[ERRO] Existe um navio em uma das coordenadas a serem preenchidas. Tente novamente.");
					}
					break;                 
				}

			} while ((tabJogo1[x][(y - 1)] == "~" && tabJogo1[x][(y - 2)] == "~") || (tabJogo1[x][(y + 1)] == "~" && tabJogo1[x][(y + 2)] == "~"));

			break;

		case "V":                                                                                                       // Repeti��o do que j� foi explicado mais acima no m�todo do SUBMARINO;
			do {                   
				do {
					System.out.print("\nDeseja colocar para cima (C) ou para baixo (B) da coordenada escolhida? ");
					cimaOuBaixo = userInput.next().toUpperCase().substring(0, 1);
				} while(!cimaOuBaixo.equals("C") && !cimaOuBaixo.equals("B"));

				switch (cimaOuBaixo) {
				case "C":
					if (tabJogo1[(x - 1)][y] == "~" && tabJogo1[(x - 2)][y] == "~") {
						tabJogo1[(x - 1)][y] = "O";
						tabJogo1[(x - 2)][y] = "O";
					} else {
						System.out.println("\n[ERRO] Existe um navio em uma das coordenadas a serem preenchidas. Tente novamente.");
					}
					break;

				case "B":
					if (tabJogo1[(x + 1)][y] == "~" && tabJogo1[(x + 2)][y] == "~") {
						tabJogo1[(x + 1)][y] = "O";
						tabJogo1[(x + 2)][y] = "O";
					} else {
						System.out.println("\n[ERRO] Existe um navio em uma das coordenadas a serem preenchidas. Tente novamente.");
					}
					break;
				}
				break;

			} while ((tabJogo1[(x - 1)][y] == "~" && tabJogo1[(x - 2)][y] == "~") || (tabJogo1[(x + 1)][y] == "~" && tabJogo1[(x + 2)][y] == "~"));

			break;
		}

		imprimirTabuleiro1();                                                                                               // Imprime o mapa com os dois navios colocados nas coordenadas corretas;
	}

	public static void posicaoNTJog1() {                                                                                    // Colocando o NAVIO-TANQUE no tabuleiro;
		String vertOuHoriz = "", dirOuEsq = "", cimaOuBaixo = "";
		int x, y;
		Scanner userInput = new Scanner(System.in);
		// Leia a explica��o do CONTRATORPEDEIRO para entender a l�gica abaixo;
		System.out.println("\n O segundo navio ser� o 'NAVIO-TANQUE'.");

		do {
			do {       
				System.out.print("Por favor, escolha onde o primeiro segmento do 'NAVIO-TANQUE' dever� ficar [COLUNA]: ");
				x = userInput.nextInt();
				System.out.print("Por favor, escolha onde o primeiro segmento do 'NAVIO-TANQUE' dever� ficar [LINHA]: ");
				y = userInput.nextInt();

				if (x > (tabJogo1.length - 2) || y > (tabJogo1.length - 2)) {
					System.out.println("\nPosi��o fora do tabuleiro. Tente novamente.");
					System.out.println("");
				}

			} while(x > (tabJogo1.length - 2) || y > (tabJogo1.length - 2));

			if (tabJogo1[x][y] == "O") {
				System.out.println("\nPosi��o j� possui uma pe�a. Tente novamente.");
				System.out.println("");
			}
		} while(tabJogo1[x][y] == "O");

		tabJogo1[x][y] = "O";

		do {
			System.out.print("\nDeseja colocar esse navio na vertical (V) ou horizontal (H)? ");
			vertOuHoriz = userInput.next().toUpperCase().substring(0, 1);
		} while (!vertOuHoriz.equals("V") && !vertOuHoriz.equals("H"));

		switch (vertOuHoriz) {
		case "H":              
			do {                   
				do {
					System.out.print("\nDeseja colocar na direita (D) ou esquerda (E) da coordenada escolhida? ");
					dirOuEsq = userInput.next().toUpperCase().substring(0, 1); 
				} while (!dirOuEsq.equals("D") && !dirOuEsq.equals("E"));  

				switch (dirOuEsq) {
				case "D":
					if (tabJogo1[x][(y + 1)] == "~" && tabJogo1[x][(y + 2)] == "~" && tabJogo1[x][(y + 3)] == "~") {
						tabJogo1[x][(y + 1)] = "O";
						tabJogo1[x][(y + 2)] = "O";
						tabJogo1[x][(y + 3)] = "O";
					} else {
						System.out.println("\n[ERRO] Existe um navio em uma das coordenadas a serem preenchidas. Tente novamente.");
					}
					break;

				case "E":
					if (tabJogo1[x][(y - 1)] == "~" && tabJogo1[x][(y - 2)] == "~" && tabJogo1[x][(y - 3)] == "~") {
						tabJogo1[x][(y - 1)] = "O";
						tabJogo1[x][(y - 2)] = "O";
						tabJogo1[x][(y - 3)] = "O";
					} else {
						System.out.println("\n[ERRO] Existe um navio em uma das coordenadas a serem preenchidas. Tente novamente.");
					}
					break;                 
				}

			} while ((tabJogo1[x][(y - 1)] == "~" && tabJogo1[x][(y - 2)] == "~" && tabJogo1[x][(y - 3)] == "~") || (tabJogo1[x][(y + 1)] == "~" && tabJogo1[x][(y + 2)] == "~" && tabJogo1[x][(y + 3)] == "~"));

			break;

		case "V":
			do {                   
				do {
					System.out.print("\nDeseja colocar para cima (C) ou para baixo (B) da coordenada escolhida? ");
					cimaOuBaixo = userInput.next().toUpperCase().substring(0, 1);
				} while(!cimaOuBaixo.equals("C") && !cimaOuBaixo.equals("B"));

				switch (cimaOuBaixo) {
				case "C":
					if (tabJogo1[(x - 1)][y] == "~" && tabJogo1[(x - 2)][y] == "~"  && tabJogo1[(x - 3)][y] == "~") {
						tabJogo1[(x - 1)][y] = "O";
						tabJogo1[(x - 2)][y] = "O";
						tabJogo1[(x - 3)][y] = "O";
					} else {
						System.out.println("\n[ERRO] Existe um navio em uma das coordenadas a serem preenchidas. Tente novamente.");
					}
					break;

				case "B":
					if (tabJogo1[(x + 1)][y] == "~" && tabJogo1[(x + 2)][y] == "~" && tabJogo1[(x + 3)][y] == "~") {
						tabJogo1[(x + 1)][y] = "O";
						tabJogo1[(x + 2)][y] = "O";
						tabJogo1[(x + 3)][y] = "O";
					} else {
						System.out.println("\n[ERRO] Existe um navio em uma das coordenadas a serem preenchidas. Tente novamente.");
					}
					break;
				}
				break;

			} while ((tabJogo1[(x - 1)][y] == "~" && tabJogo1[(x - 2)][y] == "~" && tabJogo1[(x - 3)][y] == "~") || (tabJogo1[(x + 1)][y] == "~" && tabJogo1[(x + 2)][y] == "~" && tabJogo1[(x + 3)][y] == "~"));

			break;
		}

		imprimirTabuleiro1();                                                                                               // Imprime o mapa com os dois navios colocados nas coordenadas corretas;
	}

	public static void posicaoPAJog1() {
		String vertOuHoriz = "", dirOuEsq = "", cimaOuBaixo = "";
		int x, y;
		Scanner userInput = new Scanner(System.in);

		System.out.println("\n O quarto e �ltimo navio ser� o 'PORTA-AVI�ES'.");

		do {
			do {       
				System.out.print("Por favor, escolha onde o primeiro segmento do 'PORTA-AVI�ES' dever� ficar [COLUNA]: ");
				x = userInput.nextInt();
				System.out.print("Por favor, escolha onde o primeiro segmento do 'PORTA-AVI�ES' dever� ficar [LINHA]: ");
				y = userInput.nextInt();

				if (x > (tabJogo1.length - 2) || y > (tabJogo1.length - 2)) {
					System.out.println("\nPosi��o fora do tabuleiro. Tente novamente.");
					System.out.println("");
				}

			} while(x > (tabJogo1.length - 2) || y > (tabJogo1.length - 2));

			if (tabJogo1[x][y] == "O") {
				System.out.println("\nPosi��o j� possui uma pe�a. Tente novamente.");
				System.out.println("");
			}
		} while(tabJogo1[x][y] == "O");

		tabJogo1[x][y] = "O";

		do {
			System.out.print("\nDeseja colocar esse navio na vertical (V) ou horizontal (H)? ");
			vertOuHoriz = userInput.next().toUpperCase().substring(0, 1);
		} while (!vertOuHoriz.equals("V") && !vertOuHoriz.equals("H"));

		switch (vertOuHoriz) {
		case "H":              
			do {                   
				do {
					System.out.print("\nDeseja colocar na direita (D) ou esquerda (E) da coordenada escolhida? ");
					dirOuEsq = userInput.next().toUpperCase().substring(0, 1); 
				} while (!dirOuEsq.equals("D") && !dirOuEsq.equals("E"));  

				switch (dirOuEsq) {
				case "D":
					if (tabJogo1[x][(y + 1)] == "~" && tabJogo1[x][(y + 2)] == "~" && tabJogo1[x][(y + 3)] == "~"  && tabJogo1[x][(y + 4)] == "~") {
						tabJogo1[x][(y + 1)] = "O";
						tabJogo1[x][(y + 2)] = "O";
						tabJogo1[x][(y + 3)] = "O";
						tabJogo1[x][(y + 4)] = "O";
					} else {
						System.out.println("\n[ERRO] Existe um navio em uma das coordenadas a serem preenchidas. Tente novamente.");
					}
					break;

				case "E":
					if (tabJogo1[x][(y - 1)] == "~" && tabJogo1[x][(y - 2)] == "~" && tabJogo1[x][(y - 3)] == "~" && tabJogo1[x][(y - 4)] == "~") {
						tabJogo1[x][(y - 1)] = "O";
						tabJogo1[x][(y - 2)] = "O";
						tabJogo1[x][(y - 3)] = "O";
						tabJogo1[x][(y - 4)] = "O";
					} else {
						System.out.println("\n[ERRO] Existe um navio em uma das coordenadas a serem preenchidas. Tente novamente.");
					}
					break;                 
				}

			} while ((tabJogo1[x][(y - 1)] == "~" && tabJogo1[x][(y - 2)] == "~" && tabJogo1[x][(y - 3)] == "~" && tabJogo1[x][(y - 4)] == "~") ||
					(tabJogo1[x][(y + 1)] == "~" && tabJogo1[x][(y + 2)] == "~" && tabJogo1[x][(y + 3)] == "~" && tabJogo1[x][(y + 4)] == "~"));

			break;

		case "V":
			do {                   
				do {
					System.out.print("\nDeseja colocar para cima (C) ou para baixo (B) da coordenada escolhida? ");
					cimaOuBaixo = userInput.next().toUpperCase().substring(0, 1);
				} while(!cimaOuBaixo.equals("C") && !cimaOuBaixo.equals("B"));

				switch (cimaOuBaixo) {
				case "C":
					if (tabJogo1[(x - 1)][y] == "~" && tabJogo1[(x - 2)][y] == "~" && tabJogo1[(x - 3)][y] == "~" && tabJogo1[(x - 4)][y] == "~") {
						tabJogo1[(x - 1)][y] = "O";
						tabJogo1[(x - 2)][y] = "O";
						tabJogo1[(x - 3)][y] = "O";
						tabJogo1[(x - 4)][y] = "O";
					} else {
						System.out.println("\n[ERRO] Existe um navio em uma das coordenadas a serem preenchidas. Tente novamente.");
					}
					break;

				case "B":
					if (tabJogo1[(x + 1)][y] == "~" && tabJogo1[(x + 2)][y] == "~" && tabJogo1[(x + 3)][y] == "~"  && tabJogo1[(x + 4)][y] == "~") {
						tabJogo1[(x + 1)][y] = "O";
						tabJogo1[(x + 2)][y] = "O";
						tabJogo1[(x + 3)][y] = "O";
						tabJogo1[(x + 4)][y] = "O";
					} else {
						System.out.println("\n[ERRO] Existe um navio em uma das coordenadas a serem preenchidas. Tente novamente.");
					}
					break;
				}
				break;

			} while ((tabJogo1[(x - 1)][y] == "~" && tabJogo1[(x - 2)][y] == "~" && tabJogo1[(x - 3)][y] == "~" && tabJogo1[(x - 4)][y] == "~") ||
					(tabJogo1[(x + 1)][y] == "~" && tabJogo1[(x + 2)][y] == "~" && tabJogo1[(x + 3)][y] == "~" && tabJogo1[(x + 4)][y] == "~"));

			break;
		}

		imprimirTabuleiro1();                                                                                               // Imprime o mapa com os dois navios colocados nas coordenadas corretas;
	}

	public static void criarTabuleiro1() {                                                                                  // M�todo para criar o tabuleiro do jogador �1;
		System.out.println("");                                                                                             // Esse m�todo literalmente s� serve para criar o tabuleiro do jogador n� 1...;
		System.out.println("-------------------------------------------------------------------");                          // ... corretamente, aplicando um s�mbolo qualquer (nesse caso o til (~), pois se assemelha a uma onda);
		System.out.println("| [0] | [1] | [2] | [3] | [4] | [5] | [6] | [7] | [8] | [9] | ### |");                          // Ele OBRIGATORIAMENTE precisa ser usado l� no m�todo 'iniciarBatalhaNaval' NAQUELA ORDEM, pois sem ele o...
		System.out.println("-------------------------------------------------------------------");                          // ... o pr�ximo m�todo n�o ser� impresso corretamente;
		for (int x = 0; x < tabJogo1.length; x++) {
			for (int y = 0; y < tabJogo1[x].length; y++) {
				if(y < 10) {
					tabJogo1[x][y] = "~";                                                                                   // Esse s�mbolo pode ser mudado para o que quiser, contando que s� ocupe 1 espa�o;
					System.out.print("|  " + tabJogo1[x][y] + "  ");
				} else {
					if (x < 10) {
						System.out.print("| ["+ x + "] |");
					} else {
						System.out.print("| ["+ x + "]|");
					}
				}

			}
			System.out.println("");
			System.out.println("-------------------------------------------------------------------");
		}

		System.out.println("\nLEGENDA:");
		System.out.println("| ~ | = Quadrado intocado.");
		System.out.println("| O | = Quadrado com navio (do jogador).");
		System.out.println("| @ | = Quadrado com navio atingido.");
		System.out.println("__________________________________________________________");

	}

	public static void imprimirTabuleiro1() {                                                                               // Agora sim. Nesse m�todo � onde ser� impresso qualquer modifica��o das coordenadas;
		System.out.println("");
		System.out.println("-------------------------------------------------------------------");
		System.out.println("| [0] | [1] | [2] | [3] | [4] | [5] | [6] | [7] | [8] | [9] | ### |");
		System.out.println("-------------------------------------------------------------------");
		for (int x = 0; x < tabJogo1.length; x++) {
			for (int y = 0; y < tabJogo1[x].length; y++) {
				if(y < 10) {                                                                                                // Perceba que ele n�o tem mais a linha para mudar o s�mbolo;
					System.out.print("|  " + tabJogo1[x][y] + "  ");
				} else {
					if (x < 10) {
						System.out.print("| ["+ x + "] |");
					} else {
						System.out.print("| ["+ x + "]|");
					}
				}

			}
			System.out.println("");
			System.out.println("-------------------------------------------------------------------");
		}

		System.out.println("\nLEGENDA:");
		System.out.println("| ~ | = Quadrado intocado.");
		System.out.println("| O | = Quadrado com navio (do jogador).");
		System.out.println("| @ | = Quadrado com navio atingido.");
		System.out.println("__________________________________________________________");

	}

	public static void posicaoNaviosJog2(String user2) {                                                                    // Mesma coisa do jogador n� 1, mas para o jogador n� 2;
		// Leia o do jogador n�1 para entender a l�gica;
		System.out.println("\n >>> JOGADOR 2# : " + user2 +" <<<");    
		posicaoSubJog2();
		posicaoCTJog2();
		posicaoNTJog2();
		posicaoPAJog2();

	}

	public static void posicaoSubJog2() {                                                                                   // Mesma coisa do jogador n� 1, mas para o jogador n� 2;
		String vertOuHoriz = "", dirOuEsq = "", cimaOuBaixo = "";                                                           // Leia o do jogador n�1 para entender a l�gica;
		int x, y;
		Scanner userInput = new Scanner(System.in);

		System.out.println("\nO primeiro navio ser� o SUBMARINO.");

		do {           
			System.out.print("Por favor, escolha onde o primeiro segmento do 'SUBMARINO' dever� ficar [COLUNA]: ");
			x = userInput.nextInt();
			System.out.print("Por favor, escolha onde o primeiro segmento do 'SUBMARINO' dever� ficar [LINHA]: ");
			y = userInput.nextInt();

			if (x > (tabJogo2.length - 2) || y > (tabJogo2.length - 2)) {
				System.out.println("\nPosi��o fora do tabuleiro. Tente novamente.");
				System.out.println("");
			}

		} while(x > (tabJogo2.length - 2) || y > (tabJogo2.length - 2));

		tabJogo2[x][y] = "O";

		do {
			System.out.print("\nDeseja colocar esse navio na vertical (V) ou horizontal (H)? ");
			vertOuHoriz = userInput.next().toUpperCase().substring(0, 1);
		} while (!vertOuHoriz.equals("V") && !vertOuHoriz.equals("H"));

		switch (vertOuHoriz) {
		case "H":

			do {
				System.out.print("\nDeseja colocar na direita (D) ou esquerda (E) da coordenada escolhida? ");
				dirOuEsq = userInput.next().toUpperCase().substring(0, 1);
			} while (!dirOuEsq.equals("D") && !dirOuEsq.equals("E"));

			switch (dirOuEsq) {
			case "D":  
				tabJogo2[x][(y + 1)] = "O";
				break;

			case "E":
				tabJogo2[x][(y - 1)] = "O";
				break;

			default:
				System.out.println("Letra digitada n�o corresponde a uma op��o.");
				break;
			}
			break;

		case "V":

			do {
				System.out.print("\nDeseja colocar para cima (C) ou para baixo (B) da coordenada escolhida? ");
				cimaOuBaixo = userInput.next().toUpperCase().substring(0, 1);
			} while (!cimaOuBaixo.equals("C") && !cimaOuBaixo.equals("B"));

			switch (cimaOuBaixo) {
			case "C":  
				tabJogo2[(x - 1)][y] = "O";
				break;

			case "B":
				tabJogo2[(x + 1)][y] = "O";
				break;

			default:               
				break;
			}
			break;

		default:           
			break;
		}      

		imprimirTabuleiro2();

	}

	public static void posicaoCTJog2() {
		String vertOuHoriz = "", dirOuEsq = "", cimaOuBaixo = "";
		int x, y;
		Scanner userInput = new Scanner(System.in);

		System.out.println("\n O segundo navio ser� o CONTRATORPEDEIRO.");

		do {
			do {       
				System.out.print("Por favor, escolha onde o primeiro segmento do 'CONTRATORPEDEIRO' dever� ficar [COLUNA]: ");
				x = userInput.nextInt();
				System.out.print("Por favor, escolha onde o primeiro segmento do 'CONTRATORPEDEIRO' dever� ficar [LINHA]: ");
				y = userInput.nextInt();

				if (x > (tabJogo2.length - 2) || y > (tabJogo2.length - 2)) {
					System.out.println("\nPosi��o fora do tabuleiro. Tente novamente.");
					System.out.println("");
				}

			} while(x > (tabJogo2.length - 2) || y > (tabJogo2.length - 2));

			if (tabJogo2[x][y] == "O") {
				System.out.println("\nPosi��o j� possui uma pe�a. Tente novamente.");
				System.out.println("");
			}
		} while(tabJogo2[x][y] == "O");

		tabJogo2[x][y] = "O";

		do {
			System.out.print("\nDeseja colocar esse navio na vertical (V) ou horizontal (H)? ");
			vertOuHoriz = userInput.next().toUpperCase().substring(0, 1);
		} while (!vertOuHoriz.equals("V") && !vertOuHoriz.equals("H"));

		switch (vertOuHoriz) {
		case "H":              
			do {                   
				do {
					System.out.print("\nDeseja colocar na direita (D) ou esquerda (E) da coordenada escolhida? ");
					dirOuEsq = userInput.next().toUpperCase().substring(0, 1); 
				} while (!dirOuEsq.equals("D") && !dirOuEsq.equals("E"));  

				switch (dirOuEsq) {
				case "D":
					if (tabJogo2[x][(y + 1)] == "~" && tabJogo2[x][(y + 2)] == "~") {
						tabJogo2[x][(y + 1)] = "O";
						tabJogo2[x][(y + 2)] = "O";
					} else {
						System.out.println("\n[ERRO] Existe um navio em uma das coordenadas a serem preenchidas. Tente novamente.");
					}
					break;

				case "E":
					if (tabJogo2[x][(y - 1)] == "~" && tabJogo2[x][(y - 2)] == "~") {
						tabJogo2[x][(y - 1)] = "O";
						tabJogo2[x][(y - 2)] = "O";
					} else {
						System.out.println("\n[ERRO] Existe um navio em uma das coordenadas a serem preenchidas. Tente novamente.");
					}
					break;                 
				}

			} while ((tabJogo2[x][(y - 1)] == "~" && tabJogo2[x][(y - 2)] == "~") || (tabJogo2[x][(y + 1)] == "~" && tabJogo2[x][(y + 2)] == "~"));

			break;

		case "V":
			do {                   
				do {
					System.out.print("\nDeseja colocar para cima (C) ou para baixo (B) da coordenada escolhida? ");
					cimaOuBaixo = userInput.next().toUpperCase().substring(0, 1);
				} while(!cimaOuBaixo.equals("C") && !cimaOuBaixo.equals("B"));

				switch (cimaOuBaixo) {
				case "C":
					if (tabJogo2[(x - 1)][y] == "~" && tabJogo2[(x - 2)][y] == "~") {
						tabJogo2[(x - 1)][y] = "O";
						tabJogo2[(x - 2)][y] = "O";
					} else {
						System.out.println("\n[ERRO] Existe um navio em uma das coordenadas a serem preenchidas. Tente novamente.");
					}
					break;

				case "B":
					if (tabJogo2[(x + 1)][y] == "~" && tabJogo2[(x + 2)][y] == "~") {
						tabJogo2[(x + 1)][y] = "O";
						tabJogo2[(x + 2)][y] = "O";
					} else {
						System.out.println("\n[ERRO] Existe um navio em uma das coordenadas a serem preenchidas. Tente novamente.");
					}
					break;
				}
				break;

			} while ((tabJogo2[(x - 1)][y] == "~" && tabJogo2[(x - 2)][y] == "~") || (tabJogo2[(x + 1)][y] == "~" && tabJogo2[(x + 2)][y] == "~"));

			break;
		}

		imprimirTabuleiro2();
	}

	public static void posicaoNTJog2() {
		String vertOuHoriz = "", dirOuEsq = "", cimaOuBaixo = "";
		int x, y;
		Scanner userInput = new Scanner(System.in);

		System.out.println("\n O segundo navio ser� o 'NAVIO-TANQUE'.");

		do {
			do {       
				System.out.print("Por favor, escolha onde o primeiro segmento do 'NAVIO-TANQUE' dever� ficar [COLUNA]: ");
				x = userInput.nextInt();
				System.out.print("Por favor, escolha onde o primeiro segmento do 'NAVIO-TANQUE' dever� ficar [LINHA]: ");
				y = userInput.nextInt();

				if (x > (tabJogo2.length - 2) || y > (tabJogo2.length - 2)) {
					System.out.println("\nPosi��o fora do tabuleiro. Tente novamente.");
					System.out.println("");
				}

			} while(x > (tabJogo2.length - 2) || y > (tabJogo2.length - 2));

			if (tabJogo2[x][y] == "S" || tabJogo2[x][y] == "C") {
				System.out.println("\nPosi��o j� possui uma pe�a. Tente novamente.");
				System.out.println("");
			}
		} while(tabJogo2[x][y] == "O");

		tabJogo2[x][y] = "O";

		do {
			System.out.print("\nDeseja colocar esse navio na vertical (V) ou horizontal (H)? ");
			vertOuHoriz = userInput.next().toUpperCase().substring(0, 1);
		} while (!vertOuHoriz.equals("V") && !vertOuHoriz.equals("H"));

		switch (vertOuHoriz) {
		case "H":              
			do {                   
				do {
					System.out.print("\nDeseja colocar na direita (D) ou esquerda (E) da coordenada escolhida? ");
					dirOuEsq = userInput.next().toUpperCase().substring(0, 1); 
				} while (!dirOuEsq.equals("D") && !dirOuEsq.equals("E"));  

				switch (dirOuEsq) {
				case "D":
					if (tabJogo2[x][(y + 1)] == "~" && tabJogo2[x][(y + 2)] == "~" && tabJogo2[x][(y + 3)] == "~") {
						tabJogo2[x][(y + 1)] = "O";
						tabJogo2[x][(y + 2)] = "O";
						tabJogo2[x][(y + 3)] = "O";
					} else {
						System.out.println("\n[ERRO] Existe um navio em uma das coordenadas a serem preenchidas. Tente novamente.");
					}
					break;

				case "E":
					if (tabJogo2[x][(y - 1)] == "~" && tabJogo2[x][(y - 2)] == "~" && tabJogo2[x][(y - 3)] == "~") {
						tabJogo2[x][(y - 1)] = "O";
						tabJogo2[x][(y - 2)] = "O";
						tabJogo2[x][(y - 3)] = "O";
					} else {
						System.out.println("\n[ERRO] Existe um navio em uma das coordenadas a serem preenchidas. Tente novamente.");
					}
					break;                 
				}

			} while ((tabJogo2[x][(y - 1)] == "~" && tabJogo2[x][(y - 2)] == "~" && tabJogo2[x][(y - 3)] == "~") || (tabJogo2[x][(y + 1)] == "~" && tabJogo2[x][(y + 2)] == "~" && tabJogo2[x][(y + 3)] == "~"));

			break;

		case "V":
			do {                   
				do {
					System.out.print("\nDeseja colocar para cima (C) ou para baixo (B) da coordenada escolhida? ");
					cimaOuBaixo = userInput.next().toUpperCase().substring(0, 1);
				} while(!cimaOuBaixo.equals("C") && !cimaOuBaixo.equals("B"));

				switch (cimaOuBaixo) {
				case "C":
					if (tabJogo2[(x - 1)][y] == "~" && tabJogo2[(x - 2)][y] == "~"  && tabJogo2[(x - 3)][y] == "~") {
						tabJogo2[(x - 1)][y] = "O";
						tabJogo2[(x - 2)][y] = "O";
						tabJogo2[(x - 3)][y] = "O";
					} else {
						System.out.println("\n[ERRO] Existe um navio em uma das coordenadas a serem preenchidas. Tente novamente.");
					}
					break;

				case "B":
					if (tabJogo2[(x + 1)][y] == "~" && tabJogo2[(x + 2)][y] == "~" && tabJogo2[(x + 3)][y] == "~") {
						tabJogo2[(x + 1)][y] = "O";
						tabJogo2[(x + 2)][y] = "O";
						tabJogo2[(x + 3)][y] = "O";
					} else {
						System.out.println("\n[ERRO] Existe um navio em uma das coordenadas a serem preenchidas. Tente novamente.");
					}
					break;
				}
				break;

			} while ((tabJogo2[(x - 1)][y] == "~" && tabJogo2[(x - 2)][y] == "~" && tabJogo2[(x - 3)][y] == "~") || (tabJogo2[(x + 1)][y] == "~" && tabJogo2[(x + 2)][y] == "~" && tabJogo2[(x + 3)][y] == "~"));

			break;
		}

		imprimirTabuleiro2();
	}

	public static void posicaoPAJog2() {
		String vertOuHoriz = "", dirOuEsq = "", cimaOuBaixo = "";
		int x, y;
		Scanner userInput = new Scanner(System.in);

		System.out.println("\n O quarto e �ltimo navio ser� o 'PORTA-AVI�ES.");

		do {
			do {       
				System.out.print("Por favor, escolha onde o primeiro segmento do 'PORTA-AVI�ES' dever� ficar [COLUNA]: ");
				x = userInput.nextInt();
				System.out.print("Por favor, escolha onde o primeiro segmento do 'PORTA-AVI�ES' dever� ficar [LINHA]: ");
				y = userInput.nextInt();

				if (x > (tabJogo2.length - 2) || y > (tabJogo2.length - 2)) {
					System.out.println("\nPosi��o fora do tabuleiro. Tente novamente.");
					System.out.println("");
				}

			} while(x > (tabJogo2.length - 2) || y > (tabJogo2.length - 2));

			if (tabJogo2[x][y] == "S" || tabJogo2[x][y] == "C" || tabJogo2[x][y] == "T") {
				System.out.println("\nPosi��o j� possui uma pe�a. Tente novamente.");
				System.out.println("");
			}
		} while(tabJogo2[x][y] == "O");

		tabJogo2[x][y] = "O";

		do {
			System.out.print("\nDeseja colocar esse navio na vertical (V) ou horizontal (H)? ");
			vertOuHoriz = userInput.next().toUpperCase().substring(0, 1);
		} while (!vertOuHoriz.equals("V") && !vertOuHoriz.equals("H"));

		switch (vertOuHoriz) {
		case "H":              
			do {                   
				do {
					System.out.print("\nDeseja colocar na direita (D) ou esquerda (E) da coordenada escolhida? ");
					dirOuEsq = userInput.next().toUpperCase().substring(0, 1); 
				} while (!dirOuEsq.equals("D") && !dirOuEsq.equals("E"));  

				switch (dirOuEsq) {
				case "D":
					if (tabJogo2[x][(y + 1)] == "~" && tabJogo2[x][(y + 2)] == "~" && tabJogo2[x][(y + 3)] == "~"  && tabJogo2[x][(y + 4)] == "~") {
						tabJogo2[x][(y + 1)] = "O";
						tabJogo2[x][(y + 2)] = "O";
						tabJogo2[x][(y + 3)] = "O";
						tabJogo2[x][(y + 4)] = "O";
					} else {
						System.out.println("\n[ERRO] Existe um navio em uma das coordenadas a serem preenchidas. Tente novamente.");
					}
					break;

				case "E":
					if (tabJogo2[x][(y - 1)] == "~" && tabJogo2[x][(y - 2)] == "~" && tabJogo2[x][(y - 3)] == "~" && tabJogo2[x][(y - 4)] == "~") {
						tabJogo2[x][(y - 1)] = "O";
						tabJogo2[x][(y - 2)] = "O";
						tabJogo2[x][(y - 3)] = "O";
						tabJogo2[x][(y - 4)] = "O";
					} else {
						System.out.println("\n[ERRO] Existe um navio em uma das coordenadas a serem preenchidas. Tente novamente.");
					}
					break;                 
				}

			} while ((tabJogo2[x][(y - 1)] == "~" && tabJogo2[x][(y - 2)] == "~" && tabJogo2[x][(y - 3)] == "~" && tabJogo2[x][(y - 4)] == "~") ||
					(tabJogo2[x][(y + 1)] == "~" && tabJogo2[x][(y + 2)] == "~" && tabJogo2[x][(y + 3)] == "~" && tabJogo2[x][(y + 4)] == "~"));

			break;

		case "V":
			do {                   
				do {
					System.out.print("\nDeseja colocar para cima (C) ou para baixo (B) da coordenada escolhida? ");
					cimaOuBaixo = userInput.next().toUpperCase().substring(0, 1);
				} while(!cimaOuBaixo.equals("C") && !cimaOuBaixo.equals("B"));

				switch (cimaOuBaixo) {
				case "C":
					if (tabJogo2[(x - 1)][y] == "~" && tabJogo2[(x - 2)][y] == "~" && tabJogo2[(x - 3)][y] == "~" && tabJogo2[(x - 4)][y] == "~") {
						tabJogo2[(x - 1)][y] = "O";
						tabJogo2[(x - 2)][y] = "O";
						tabJogo2[(x - 3)][y] = "O";
						tabJogo2[(x - 4)][y] = "O";
					} else {
						System.out.println("\n[ERRO] Existe um navio em uma das coordenadas a serem preenchidas. Tente novamente.");
					}
					break;

				case "B":
					if (tabJogo2[(x + 1)][y] == "~" && tabJogo2[(x + 2)][y] == "~" && tabJogo2[(x + 3)][y] == "~"  && tabJogo2[(x + 4)][y] == "~") {
						tabJogo2[(x + 1)][y] = "O";
						tabJogo2[(x + 2)][y] = "O";
						tabJogo2[(x + 3)][y] = "O";
						tabJogo2[(x + 4)][y] = "O";
					} else {
						System.out.println("\n[ERRO] Existe um navio em uma das coordenadas a serem preenchidas. Tente novamente.");
					}
					break;
				}
				break;

			} while ((tabJogo2[(x - 1)][y] == "~" && tabJogo2[(x - 2)][y] == "~" && tabJogo2[(x - 3)][y] == "~" && tabJogo2[(x - 4)][y] == "~") ||
					(tabJogo2[(x + 1)][y] == "~" && tabJogo2[(x + 2)][y] == "~" && tabJogo2[(x + 3)][y] == "~" && tabJogo2[(x + 4)][y] == "~"));

			break;
		}

		imprimirTabuleiro2();
	}

	public static void criarTabuleiro2() {                                                                                  // Mesma coisa do jogador n� 1, mas para o jogador n� 2;
		System.out.println("");                                                                                             // Leia o do jogador n�1 para entender a l�gica;
		System.out.println("-------------------------------------------------------------------");                          // O n�mero de m�todos 'criarTabuleiroN' e imprimirTabuleiroN' depende da quantidade de jogadores (no caso, 2 jogadores);
		System.out.println("| [0] | [1] | [2] | [3] | [4] | [5] | [6] | [7] | [8] | [9] | ### |");
		System.out.println("-------------------------------------------------------------------");
		for (int x = 0; x < tabJogo2.length; x++) {
			for (int y = 0; y < tabJogo2[x].length; y++) {
				if(y < 10) {   
					tabJogo2[x][y] = "~";
					System.out.print("|  " + tabJogo2[x][y] + "  ");
				} else {
					if (x < 10) {
						System.out.print("| ["+ x + "] |");
					} else {
						System.out.print("| ["+ x + "]|");
					}
				}

			}
			System.out.println("");
			System.out.println("-------------------------------------------------------------------");
		}

		System.out.println("\nLEGENDA:");
		System.out.println("| ~ | = Quadrado intocado.");
		System.out.println("| N | = Quadrado sem nada.");
		System.out.println("| O | = Quadrado com navio (do jogador).");
		System.out.println("| @ | = Quadrado com navio atingido.");
		System.out.println("__________________________________________________________");

	}

	public static void imprimirTabuleiro2() {                                                                               // Mesma coisa do jogador n� 1, mas para o jogador n� 2;
		System.out.println("");                                                                                             // Leia o do jogador n�1 para entender a l�gica;
		System.out.println("-------------------------------------------------------------------");
		System.out.println("| [0] | [1] | [2] | [3] | [4] | [5] | [6] | [7] | [8] | [9] | ### |");
		System.out.println("-------------------------------------------------------------------");
		for (int x = 0; x < tabJogo2.length; x++) {
			for (int y = 0; y < tabJogo2[x].length; y++) {
				if(y < 10) {           
					System.out.print("|  " + tabJogo2[x][y] + "  ");
				} else {
					if (x < 10) {
						System.out.print("| ["+ x + "] |");
					} else {
						System.out.print("| ["+ x + "]|");
					}
				}

			}
			System.out.println("");
			System.out.println("-------------------------------------------------------------------");
		}

		System.out.println("\nLEGENDA:");
		System.out.println("| ~ | = Quadrado intocado.");
		System.out.println("| N | = Quadrado sem nada.");
		System.out.println("| O | = Quadrado com navio (do jogador).");
		System.out.println("| @ | = Quadrado com navio atingido.");
		System.out.println("__________________________________________________________");

	}

	public static void criarTabuleiroOculto2() {                                                                            // Esse m�todo ser� criado o tabuleiro que, na parte do jogo mesmo (atirando nas posi��es para afundar os navios)...
		System.out.println("");                                                                                             // ... ser� usado para mostrar se o tiro atingiu alguma coisa ou n�o;
		System.out.println("-------------------------------------------------------------------");                          // Mesma l�gica do tabuleiro normal;
		System.out.println("| [0] | [1] | [2] | [3] | [4] | [5] | [6] | [7] | [8] | [9] | ### |");
		System.out.println("-------------------------------------------------------------------");
		for (int x = 0; x < tabJogoOculto2.length; x++) {
			for (int y = 0; y < tabJogoOculto2[x].length; y++) {
				if(y < 10) {
					tabJogoOculto2[x][y] = "~";
					System.out.print("|  " + tabJogoOculto2[x][y] + "  ");
				} else {
					if (x < 10) {
						System.out.print("| ["+ x + "] |");
					} else {
						System.out.print("| ["+ x + "]|");
					}
				}
			}
			System.out.println("");
			System.out.println("-------------------------------------------------------------------");
		}

		System.out.println("\nLEGENDA:");
		System.out.println("| ~ | = Quadrado intocado.");
		System.out.println("| O | = Quadrado com navio (do jogador).");
		System.out.println("| @ | = Quadrado com navio atingido.");
		System.out.println("__________________________________________________________");

	}

	public static void imprimirTabuleiroOculto2() {                                                                         // Impress�o do tabuleiro acima. Novamente, mesma l�gica do tabuleiro normal;
		System.out.println("");
		System.out.println("-------------------------------------------------------------------");
		System.out.println("| [0] | [1] | [2] | [3] | [4] | [5] | [6] | [7] | [8] | [9] | ### |");
		System.out.println("-------------------------------------------------------------------");
		for (int x = 0; x < tabJogoOculto2.length; x++) {
			for (int y = 0; y < tabJogoOculto2[x].length; y++) {
				if(y < 10) {                   
					System.out.print("|  " + tabJogoOculto2[x][y] + "  ");
				} else {
					if (x < 10) {
						System.out.print("| ["+ x + "] |");
					} else {
						System.out.print("| ["+ x + "]|");
					}
				}

			}
			System.out.println("");
			System.out.println("-------------------------------------------------------------------");
		}

		System.out.println("\nLEGENDA:");
		System.out.println("| ~ | = Quadrado intocado.");
		System.out.println("| O | = Quadrado com navio (do jogador).");
		System.out.println("| @ | = Quadrado com navio atingido.");
		System.out.println("__________________________________________________________");

	}

	public static void criarTabuleiroOculto1() {                                                                            // Cria��o do tabuleiro oculto do jogador n�2. Mesma l�gica;
		System.out.println("");
		System.out.println("-------------------------------------------------------------------");
		System.out.println("| [0] | [1] | [2] | [3] | [4] | [5] | [6] | [7] | [8] | [9] | ### |");
		System.out.println("-------------------------------------------------------------------");
		for (int x = 0; x < tabJogoOculto1.length; x++) {
			for (int y = 0; y < tabJogoOculto1[x].length; y++) {
				if(y < 10) {
					tabJogoOculto1[x][y] = "~";
					System.out.print("|  " + tabJogoOculto1[x][y] + "  ");
				} else {
					if (x < 10) {
						System.out.print("| ["+ x + "] |");
					} else {
						System.out.print("| ["+ x + "]|");
					}
				}
			}
			System.out.println("");
			System.out.println("-------------------------------------------------------------------");
		}

		System.out.println("\nLEGENDA:");
		System.out.println("| ~ | = Quadrado intocado.");
		System.out.println("| O | = Quadrado com navio (do jogador).");
		System.out.println("| @ | = Quadrado com navio atingido.");
		System.out.println("__________________________________________________________");

	}

	public static void imprimirTabuleiroOculto1() {                                                                         // Impress�o do tabuleiro oculto do jogador n�2. Mesma l�gica
		System.out.println("");
		System.out.println("-------------------------------------------------------------------");
		System.out.println("| [0] | [1] | [2] | [3] | [4] | [5] | [6] | [7] | [8] | [9] | ### |");
		System.out.println("-------------------------------------------------------------------");
		for (int x = 0; x < tabJogoOculto1.length; x++) {
			for (int y = 0; y < tabJogoOculto1[x].length; y++) {
				if(y < 10) {                   
					System.out.print("|  " + tabJogoOculto1[x][y] + "  ");
				} else {
					if (x < 10) {
						System.out.print("| ["+ x + "] |");
					} else {
						System.out.print("| ["+ x + "]|");
					}
				}

			}
			System.out.println("");
			System.out.println("-------------------------------------------------------------------");
		}

		System.out.println("\nLEGENDA:");
		System.out.println("| ~ | = Quadrado intocado.");
		System.out.println("| O | = Quadrado com navio (do jogador).");
		System.out.println("| @ | = Quadrado com navio atingido.");
		System.out.println("__________________________________________________________");

	}

	public static void contadorPontos(String user1, String user2) {                                                         // Aqui � m�todo onde ir�o ocorrer as batalhas;
		int contadorPontosMaximosP1 = 0, contadorPontosMaximosP2 = 0;                                                       // 'Int' para guardar os de pontos de ambos os jogadores;
		Scanner userInput = new Scanner(System.in);

		for (int contadorTurnos = 1; (contadorPontosMaximosP1 < 14) || (contadorPontosMaximosP2 < 14); ) {                  // 'For' loop para continuar o jogo at� que os pontos m�ximo serem conseguidos;
			while (contadorPontosMaximosP1 < 14 && contadorPontosMaximosP2 < 14) {
				if (contadorTurnos % 2 != 0) {                                                                              // Quando o contador (criado no 'for') for �mpar, � a vez do jogador n�1. Quando for par, � o jogador n�2.
					int x, y;

					System.out.println("\n >>> JOGADOR 1# : " + user1 +" <<<");                
					System.out.println("\nTurno: " + contadorTurnos);                                                       // Mostra o turno atual;

					do {                                                                                                    // Loop 'do/while' feito para o jogador escolher um n�mero entre 0 e 9;
						System.out.print("\nPor favor, escolha uma COLUNA (n�mero entre 0 e 9) para atacar: ");       
						x = userInput.nextInt();

						if (x < 0 && x >= 10) {
							System.out.println("\n[ERRO] N�mero fora dos par�metros pedidos, tente novamente.");
						}
					} while (x < 0 && x >= 10);

					do {
						System.out.print("Por favor, escolha uma LINHA (n�mero entre 0 e 9) para atacar: ");
						y = userInput.nextInt();

						if (y < 0 && y >= 10) {
							System.out.println("\n[ERRO] N�mero fora dos par�metros pedidos, tente novamente.");
						}
					} while (y < 0 && y >= 10);


					if (tabJogo2[x][y].equals("O")) {                                                                       // Se, na posi��o escolhida, tiver um "O" (no mapa normal)...
						System.out.println("\nVoc� acertou a parte de um navio!");
						tabJogoOculto2[x][y] = "@";                                                                         // ... vai ser adicionado um "@" nos tabuleiros ocultos;
						contadorPontosMaximosP1++;
						System.out.println("Segmentos acertados: " + contadorPontosMaximosP1 + " de 14.");                  // Mostra a pontua��o atual do jogador;
						imprimirTabuleiroOculto2();                                                                         // Imprime o tabuleiro j� com a posi��o acertada;

					} else if (!tabJogo2[x][y].equals("O")) {                                                               // Se, na posi��o escolhida, n�o ter nada...
						System.out.println("\nVoc� errou!");                                                               // ... mostra essa mensagem;
						imprimirTabuleiroOculto2();
					}
					contadorTurnos++;                                                                                       // Se errou ou acertou (n�o importa) vai ser adicionado +1 no turno, mudando de quem � a vez;

					if (contadorPontosMaximosP1 == 14) {                                                                    // Se o jogador n� 1 chegou em 14 pontos (pois cada navio, somado, tem 14 segmentos), ele ganha;
						System.out.println("\nJogador 1 venceu!");
						System.out.println("__________________________________________________________");
					}  

				} else if (contadorTurnos % 2 == 0) {                                                                       // Mesma coisa do jogador n� 1, mas agora pro jogador n� 2;
					int x, y;

					System.out.println("\n >>> JOGADOR 2# : " + user2 +" <<<");                
					System.out.println("\nTurno: " + contadorTurnos);

					do {
						System.out.print("\nPor favor, escolha uma COLUNA (n�mero entre 0 e 9) para atacar: ");       
						x = userInput.nextInt();

						if (x < 0 && x >= 10) {
							System.out.println("\n[ERRO] N�mero fora dos par�metros pedidos, tente novamente.");
						}
					} while (x < 0 && x >= 10);

					do {
						System.out.print("Por favor, escolha uma LINHA (n�mero entre 0 e 9) para atacar: ");
						y = userInput.nextInt();

						if (y < 0 && y >= 10) {
							System.out.println("\n[ERRO] N�mero fora dos par�metros pedidos, tente novamente.");
						}
					} while (y < 0 && y >= 10);


					if (tabJogo1[x][y].equals("O")) {
						System.out.println("\nVoc� acertou a parte de um navio!");
						tabJogoOculto1[x][y] = "@";
						contadorPontosMaximosP2++;
						System.out.println("Segmentos acertados: " + contadorPontosMaximosP2 + " de 14.");
						imprimirTabuleiroOculto1();

					} else if (!tabJogo1[x][y].equals("O")) {
						System.out.println("\nVoc� errou!");
						imprimirTabuleiroOculto1();
					}
					contadorTurnos++;                  

					if (contadorPontosMaximosP2 == 14) {
						System.out.println("\nJogador 2 venceu!");
						System.out.println("__________________________________________________________");
					}
				}
			}

			userInput.close();
		}
	}                                                                                                                       // FIM DO JOGO 'BATALHA NAVAL;


	// INICIO DO CAMPO MINADO

	public static int colunasCM = 11;
	public static int linhasCM = 11;
	public static String[][] tabCampoMinado = new String[linhasCM][colunasCM];
	public static String[][] tabOcultoCampoMinado = new String[linhasCM][colunasCM];


	public static void campoMinado(String user1, String user2) {

		jogo();

		imprimir("\n\nO Que deseja fazer agora?\n");
		imprimir("[1] - Voltar ao Menu \n");
		imprimir("[2] - Sair\n");

		int fimjogoforca;
		Scanner imput = new Scanner(System.in);
		fimjogoforca = imput.nextInt();
		String[] usuariosfim = new String[2];
		usuariosfim[0] = user1;
		usuariosfim[1] = user2;
		switch (fimjogoforca) {
		case 1:

			menu(usuariosfim, 0);
			break;
		case 2:
			imprimir("\n Obrigado por jogar\n\n Jogo encerrado!");
			System.exit(0);
			break;

		default:
			imprimir("\n Voc� escolheu uma op��o inv�lida, indo para o Menu!");
			menu(usuariosfim, 0);
			break;
		}

	}

	public static void jogo() {

		introducaoCM();                                             // Mostra a introdu��o, falando sobre as regras e tals;
		tabuleiroCM();                                              // Imprime o tabuleiro, pois na regra menciona o tamanho e queria ter uma representa��o visual disso;
		aguardeTextoCM();                                           // Texto 'filler'.
		bombasPosicao();                                            // Ativa as posi��es das bombas no tabuleiro;
		imprimirTabuleiroCM();
		System.out.println("\nTabuleiro pronto!");
		tabuleiroOcultoCM();                                        // Oculta o tabuleiro;
		tentativasCM();                                             // Come�am as tentativas para ganhar o jogo;
		System.out.println("Fim de jogo.");
	}  

	public static void introducaoCM() {                             // Mostra a introdu��o, falando sobre as regras e tals;
		System.out.println("\n________________________________________________________________");
		System.out.println("\n[ C A M P O   M I N A D O ]");
		System.out.println("\nBem vindo ao jogo 'Campo-Minado'!");
		System.out.println("As regras desse jogo s�o bem simples:");
		System.out.println("- Voc� jogar� num tabuleiro igual o mostrado abaixo (10 x 10);");
		System.out.println("- Voc� deve acertar todos os 90 quadrados vazios sem atingir nenhuma das 10 minas;");
		System.out.println("- Se voc� chegar em 90 pontos, voc� ganha o jogo.");
		System.out.println("\nBoa sorte!");
		System.out.println("________________________________________________________________");
	}

	public static void aguardeTextoCM() {                           // Texto 'filler'.
		System.out.println("________________________________________________________________");
		System.out.println("\nTabuleiro sendo preparado.");
		System.out.println("\nAguarde.");
		System.out.println("\nAguarde..");
		System.out.println("\nAguarde...");
		System.out.println("________________________________________________________________");
	}

	public static void tabuleiroCM() {                                                                              // Tabuleiro do jogo
		System.out.println("");                                                                                     // Esse m�todo literalmente s� serve para criar o tabuleiro...;
		for (int x = 0; x < tabCampoMinado.length; x++) {                                                           // ... corretamente, aplicando um s�mbolo qualquer (nesse caso um "L", de 'livre de mina');
			if (x == 0) {                                                                                           // Ele OBRIGATORIAMENTE precisa ser usado l� no m�todo 'jogo()' NAQUELA ORDEM, pois sem ele o...
				System.out.println("-------------------------------------------------------------------");          // ... o pr�ximo m�todo n�o ser� impresso corretamente;
				System.out.println("| ### | [1] | [2] | [3] | [4] | [5] | [6] | [7] | [8] | [9] | [10] |");
				System.out.println("-------------------------------------------------------------------");
			}
			for (int y = 0; y < tabCampoMinado[x].length; y++) {
				if (y == 0) {
					if (x < 9) {
						System.out.print("| [" + (x) + "] ");
					} else if (x >= 9) {
						System.out.print("|[" + (x) + "] ");
					}
				} else {
					tabCampoMinado[x][y] = "L";                                                                     // Esse s�mbolo pode ser mudado para o que quiser, contando que s� ocupe 1 espa�o;
					System.out.print("|  " + tabCampoMinado[x][y] + "  ");
					if (y == 10) {
						System.out.print("|");
					}
				}

			}
			System.out.println("");
			System.out.println("-------------------------------------------------------------------");
		}

	}

	public static void bombasPosicao() {
		Random rand = new Random();
		/*tabCampoMinado[1][2] = "B";
	        tabCampoMinado[1][3] = "B";
	        tabCampoMinado[7][4] = "B";
	        tabCampoMinado[1][5] = "B";
	        tabCampoMinado[1][6] = "B";
	        tabCampoMinado[1][7] = "B";
	        tabCampoMinado[1][8] = "B";
	        tabCampoMinado[1][9] = "B";
	        tabCampoMinado[2][5] = "B";
	        tabCampoMinado[5][2] = "B"; */
		int d = 0;
		for (int i = 0, j = 0; j < 10; i++ ) {
			int a = rand.nextInt(10)+1;
			int b = rand.nextInt(10)+1;
			String c = tabCampoMinado[a][b];

			if (c!="B") {
				tabCampoMinado[a][b] = "B";
				j++;
				d = j;
			} 
		}
		System.out.println(d);

	}  

	public static void imprimirTabuleiroCM() {                                                                      // "Habilite" esse m�todo no 'jogo()', ap�s o 'bombasPosicao()' para ver onde as minas est�o;
		System.out.println("");
		for (int x = 0; x < (tabCampoMinado.length ); x++) {
			if (x == 0) {
				System.out.println("-------------------------------------------------------------------");
				System.out.println("| ### | [1] | [2] | [3] | [4] | [5] | [6] | [7] | [8] | [9] | [10] |");
				System.out.println("-------------------------------------------------------------------");
			}
			for (int y = 0; y < tabCampoMinado[x].length; y++) {
				if (y == 0) {
					if (x < 9) {
						System.out.print("| [" + (x+1) + "] ");
					} else if (x >= 9) {
						System.out.print("|[" + (x+1) + "] ");
					}
				} else {
					System.out.print("|  " + tabCampoMinado[x][y] + "  ");
					if (y == 10) {
						System.out.print("|");
					}
				}

			}
			System.out.println("");
			System.out.println("-------------------------------------------------------------------");
		}

	}

	public static void tentativasCM() {                                                                             // Come�am as tentativas para ganhar o jogo;                                                                                                                  
		Scanner userInput = new Scanner (System.in);

		for (int contadorPontosMaximos = 0; contadorPontosMaximos < 100; ) {                                                        // Loop 'for' para continuar o jogo at� vencer.
			int x, y;                                                                                                               // O valor do loop no meio do ';  ;' n�o importa muito...
			// ... contanto que seja maior que a condi��o de vit�ria;
			do {
				System.out.print("\nPor favor, escolha uma COLUNA (n�mero entre 1 e 10): ");                                       // Loop 'do/while' para que, se o n�mero n�o estiver entre 1 e 10
				x = userInput.nextInt();                                                                                            // ... o loop come�a denovo;

				if (x < 1 || x > 10) {
					System.out.println("\n[ERRO] N�mero fora dos par�metros pedidos, tente novamente.");
				}
			} while (x < 1 || x > 10);

			do {                                                                                                                    // Mesma coisa aqui, s� que com o 'y';
				System.out.print("Por favor, escolha uma LINHA (n�mero entre 1 e 10): ");
				y = userInput.nextInt();

				if (y < 1 || y > 10) {
					System.out.println("\n[ERRO] N�mero fora dos par�metros pedidos, tente novamente.");
				}
			} while (y < 1 || y > 10);

			if (y == 1 && x == 10) {                                                                                                // Come�am as condi��es ( VEJAM ESSAS IMAGENS NO LINK: https://imgur.com/a/zaIMGih )
				if (tabCampoMinado[(x - 1)][y].equals("B")) {                                                                       // CONDI��O 1;
					System.out.println("Tem uma mina perto dessa posi��o.");                                                      // Quando 'y == 1' e 'x == 10', n�o posso vasculhar o...
				} else if (tabCampoMinado[x][(y + 1)].equals("B")) {                                                                // '[y - 1]' e '[x + 1]', pois est�o fora do Array;
					System.out.println("Tem uma mina perto dessa posi��o.");
				}
			} else if (x == 1 && y == 10) {                                                                                         // CONDI��O 2;
				if (tabCampoMinado[(x + 1)][y].equals("B")) {                                                                       // Quando 'x == 1' e 'u == 10', n�o posso vasculhar o...
					System.out.println("\nTem uma mina perto dessa posi��o.");                                                        // '[x - 1]' e '[y + 1]', pois est�o fora do Array;
				} else if (tabCampoMinado[x][(y - 1)].equals("B")) {
					System.out.println("\nTem uma mina perto dessa posi��o.");                                                        // >>> LEMBRANDO QUE AS POSI��ES [n][0] E [0][n] EST�O SENDO USADAS PARA MARCAR OS N�MEROS DE APOIO DO TABULEIRO;
				}
			} else if (x == 10 && y == 10) {                                                                                        // CONDI��O 3;
				if (tabCampoMinado[(x - 1)][y].equals("B")) {                                                                       // Quando 'x == 10' e 'y == 10, n�o posso vasculhar o...
					System.out.println("\nTem uma mina perto dessa posi��o.");                                                        // '[x + 1]' e '[y + 1]', pois est�o fora do Array;
				} else if (tabCampoMinado[x][(y - 1)].equals("B")) {
					System.out.println("\nTem uma mina perto dessa posi��o.");
				}
			} else if (x == 1 && y == 1) {                                                                                          // CONDI��O 4;
				if (tabCampoMinado[(x + 1)][y].equals("B")) {                                                                       // Quando 'x == 1' e 'y == 1, n�o posso vasculhar o...
					System.out.println("\nTem uma mina perto dessa posi��o.");                                                        // '[x - 1]' e '[y - 1]', pois est�o fora do Array;
				} else if (tabCampoMinado[x][(y + 1)].equals("B")) {
					System.out.println("\nTem uma mina perto dessa posi��o.");
				}
			} else if (x != 10 && y == 1) {                                                                                         // CONDI��O 5;
				if (tabCampoMinado[(x + 1)][y].equals("B")) {                                                                       // Quando 'x != 10' e 'y == 1, n�o posso vasculhar o...
					System.out.println("\nTem uma mina perto dessa posi��o.");                                                        // '[y - 1]', pois est� fora do Array;
				} else if (tabCampoMinado[(x - 1)][y].equals("B")) {
					System.out.println("\nTem uma mina perto dessa posi��o.");
				} else if (tabCampoMinado[x][(y + 1)].equals("B")) {
					System.out.println("\nTem uma mina perto dessa posi��o.");
				}
			} else if (x == 10 && y != 1) {                                                                                         // CONDI��O 6;
				if (tabCampoMinado[(x - 1)][y].equals("B")) {                                                                       // Quando 'x == 10' e 'y != 1, n�o posso vasculhar o...
					System.out.println("\nTem uma mina perto dessa posi��o.");                                                        // '[x + 1]', pois est� fora do Array;
				} else if (tabCampoMinado[x][(y + 1)].equals("B")) {
					System.out.println("\nTem uma mina perto dessa posi��o.");
				} else if (tabCampoMinado[x][(y - 1)].equals("B")) {
					System.out.println("\nTem uma mina perto dessa posi��o.");
				}
			} else if (x != 1 && y == 10) {                                                                                         // CONDI��O 7;
				if (tabCampoMinado[(x + 1)][y].equals("B")) {                                                                       // Quando 'x != 1' e 'y == 10, n�o posso vasculhar o...
					System.out.println("\nTem uma mina perto dessa posi��o.");                                                        // '[y + 1]', pois est� fora do Array;
				} else if (tabCampoMinado[(x - 1)][y].equals("B")) {
					System.out.println("\nTem uma mina perto dessa posi��o.");
				} else if (tabCampoMinado[x][(y - 1)].equals("B")) {
					System.out.println("\nTem uma mina perto dessa posi��o.");
				}
			} else if (x == 1 && y != 10) {                                                                                         // CONDI��O 8;
				if (tabCampoMinado[(x + 1)][y].equals("B")) {                                                                       // Quando 'x == 1' e 'y != 10, n�o posso vasculhar o...
					System.out.println("\nTem uma mina perto dessa posi��o.");                                                        // '[x - 1]', pois est� fora do Array;
				} else if (tabCampoMinado[x][(y + 1)].equals("B")) {
					System.out.println("\nTem uma mina perto dessa posi��o.");
				} else if (tabCampoMinado[x][(y - 1)].equals("B")) {
					System.out.println("\nTem uma mina perto dessa posi��o.");
				}              
			} else {
				if (tabCampoMinado[(x + 1)][y].equals("B")) {                                                                       // CONDI��O PADR�O;
					System.out.println("\nTem uma mina perto dessa posi��o.");                                                        // Condi��o de pesquisa para todas as coodernadas...
				} else if (tabCampoMinado[(x - 1)][y].equals("B")) {                                                                // Que n�o est�o acima (do [2][2] at� [9][9]);
					System.out.println("\nTem uma mina perto dessa posi��o.");
				} else if (tabCampoMinado[x][(y + 1)].equals("B")) {
					System.out.println("\nTem uma mina perto dessa posi��o.");
				} else if (tabCampoMinado[x][(y - 1)].equals("B")) {
					System.out.println("\nTem uma mina perto dessa posi��o.");
				}
			}

			if (tabCampoMinado[x][y].equals("L")) {                                                                                 // Se, a posi��o no tabuleiro normal possui um "L" (de livre de mina)...
				if (tabOcultoCampoMinado[x][y] != ("@")) {                                                                          // Ele vai ver se aquela posi��o J� N�O FOI MUDADA no tabuleiro oculto e...
					contadorPontosMaximos++;                                                                                        // Vai adicionar um ponto no 'contadorPontosMaximos'.
				}
				tabOcultoCampoMinado[x][y] = "@";                                                                                   // Al�m disso, vai colocar um "@" na coordenada escolhida no tabuleiro oculto;
				System.out.println("\nEspa�os livres descobertos: " + contadorPontosMaximos + " de 90.");                          // Guia para ajudar a ver quantos pontos j� foram feitos;
				imprimirTabuleiroOcultoCM();                                                                                        // Impress�o do mapa, j� atualizado com a jogada que foi feita.

			} else if (tabCampoMinado[x][y].equals("B")) {                                                                          // Se o jogador achar uma mina ("B")...
				System.out.println("\nQue pena! Voc� acertou uma mina!");     
				System.out.println("\n");
				return;                                                                                                             // ... volta para o m�todo 'jogo()';
			}

			if (contadorPontosMaximos == 90) {                                                                                      // Se chegar a 90 pontos, o jogador vence;
				System.out.println("\nParab�ns! Voc� venceu!");
				System.out.println("__________________________________________________________");
			}
		}
	}

	public static void tabuleiroOcultoCM() {                                                                        // Tabuleiro oculto do jogo;
		System.out.println("");                                                                                     // Esse m�todo literalmente s� serve para criar o tabuleiro...;
		// ... corretamente, aplicando um s�mbolo qualquer para a mina (nesse caso, "B");
		for (int x = 0; x < tabOcultoCampoMinado.length; x++) {                                                     // Ele OBRIGATORIAMENTE precisa ser usado l� no m�todo 'jogo()' NAQUELA ORDEM, pois sem ele o...
			if (x == 0) {                                                                                           // ... o pr�ximo m�todo n�o ser� impresso corretamente;
				System.out.println("-------------------------------------------------------------------");
				System.out.println("| ### | [1] | [2] | [3] | [4] | [5] | [6] | [7] | [8] | [9] | [10] |");         // A linha 0 (x == 0) vai ser exclusiva para imprimir os n�mero de apoio horizontais;
				System.out.println("-------------------------------------------------------------------");          // Um m�todo diferente foi tentado abaixo. Ambos d�o o mesmo resultado;
				x++;
			}
			for (int y = 0; y < tabOcultoCampoMinado[x].length; y++) {
				if (y == 0) {
					if (x < 10) {
						System.out.print("|  " + (x) + "  ");
					} else if (x >= 10) {
						System.out.print("| " + (x) + "  ");
					}
				} else {
					tabOcultoCampoMinado[x][y] = " ";                                                               // Simbolo aleat�rio para indicar a posi��o sem mina (no caso, um " ");
					System.out.print("|  " + tabOcultoCampoMinado[x][y] + "  ");
					if (y == 10) {
						System.out.print("|");
					}
				}

			}
			System.out.println("");
			System.out.println("-------------------------------------------------------------------");
		}

	}

	public static void imprimirTabuleiroOcultoCM() {                                                                // Tabuleiro que vai ser mostrado quando o jogador come�ar a tentar;
		System.out.println("");
		System.out.println("-------------------------------------------------------------------");
		System.out.println("| ### | [1] | [2] | [3] | [4] | [5] | [6] | [7] | [8] | [9] | [10] |");
		System.out.println("-------------------------------------------------------------------");
		for (int x = 1; x < tabOcultoCampoMinado.length; x++) {                                                     // Veja que o 'x' come�ou com 1, e n�o com zero;
			for (int y = 0; y < tabOcultoCampoMinado[x].length; y++) {                                              // Isso se deve para que a posi��o [1][1] no tabuleiro n�o seja a posi��o [0][1] no Array Bidimensional;
				if (y == 0) {
					if (x < 10) {
						System.out.print("|  " + (x) + "  ");
					} else if (x >= 10) {
						System.out.print("| " + (x) + "  ");
					}
				} else {
					System.out.print("|  " + tabOcultoCampoMinado[x][y] + "  ");
					if (y == 10) {
						System.out.print("|");
					}
				}

			}
			System.out.println("");
			System.out.println("-------------------------------------------------------------------");
		}

	}
	// FIM DO CAMPO MINADO




	// M�TODOS DE IMPRESS�O:
	public static void imprimir (String temp) {
		System.out.print(temp);
	}

	public static void imprimir (int valor) {
		System.out.print(valor + " ");
	}

}