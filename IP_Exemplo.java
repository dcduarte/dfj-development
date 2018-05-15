//import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author b-car
 *
 */
public class IP_Projecto_Final {

	/**
	 * @param args
	 */
	//Variaveis gerais
	
	static Scanner teclado = new Scanner(System.in);
	static String sepChar=";";  //Caractr de separação dos campos nos ficheiros de dados
		
	//variaveis Utilizadores
	static String user="";

	// Array para caracteres proibidos
	static String[] arrCharProibidos = new String[] {"\\","_",","};
	
	// inteiro para minimo de linhas do array
	static int ArrLinSize = 200;
	
	
	//Cabeçallhos das listagens
	static String[] arrAutomotoraHeader = new String[] { "COD AUT", "TIPO", "POTENCIA","FABRICANTE", "OBS" };
	static String[] arrCarruagemHeader = new String[] { "COD CARR", "TIPO", "N LUGARES","FABRICANTE", "OBS" };
	static String[] arrComposicaoHeader = new String[] { "COD COMP","NOME", "COD AUTOMOTORA", "DATACRIACAO","STATUS","COD LINHA","DATA STATUS" };
	static String[] arrCarruagensComposicaoHeader = new String[] {"COD CARRUAGEM" , "COD COMP"};
	static String[] arrLinhaHeader = new String[] { "COD LINHA", "NOME", "INICIO","FIM", "Obs" };
	static String[] arrEstacaoHeader = new String[] { "COD ESTACAO", "NOME", "LOCAL","LAT/LNG", "Obs" };
	static String[] arrLinhaEstacaoHeader = new String[] { "COD_ESTACAO","COD LINHA" };
	static String[] arrEstaleiroHeader = new String[] { "COD_AUTOMOTORA", "AVARIA" , "OBS"};
	
	// Variaveis para Matrizes das tabelas de dados
	static String[][] arrAutomotora = new String[ArrLinSize][arrAutomotoraHeader.length];  // Campos--> SN_AUTOMOTORA(str), TIPO (Str)(D/E/Outro), POTENCIA(str), Fabricante(str), OBS (str)
	static String[][] arrCarruagem = new String[ArrLinSize][arrCarruagemHeader.length];  //  Campos--> SN_CARRUAGEM(str), TIPO (Str)(1ª/2ª/3ª), Lugares(int), Fabricante (str), OBS (str)
	static String[][] arrComposicao = new String[ArrLinSize][arrComposicaoHeader.length];  // Campos --> COD_COMPOSICAO (str), SN_AUTOMOTORA, SN_CARRUAGEM, NOMECOMPOSICAO (str), DATACRIACAO (date), STATUS(revisão, rep. avaria, paragem​ ​de​ ​fds), COD_LINHA (str), DATA_SATUS(data) 
	static String[][] arrCarruagensComposicao = new String[ArrLinSize][arrCarruagensComposicaoHeader.length];  // Campos --> COD_COMPOSICAO (Str), COD_CARRUAGEM (Str);
	static String[][] arrLinha = new String[ArrLinSize][arrLinhaHeader.length];    // Campos --> COD_LINHA (Str), NOME (Str), INICIO (str), FIM (str), OBS (str)
	static String[][] arrEstacao = new String[ArrLinSize][arrEstacaoHeader.length]; // Campos --> COD_ESTACAO (double ou Str), NOME (str), LOCAL (Str), LATLNG (str), OBS (str)
	static String[][] arrLinhaEstacao = new String[ArrLinSize][arrLinhaEstacaoHeader.length]; // Campos --> COD_LINHA (Str), COD_ESTACAO (Str)
	static String[][] arrEstaleiro = new String[ArrLinSize][arrEstaleiroHeader.length];  // Campos -> COD_AUTOMORA;
	
	
	//Declaração dis ficheiros public para consumo em todo o prgrama
	static File fileAutomotora = new File("automotora.txt");
	static File fileCarruagem = new File("carruagem.txt");
	static File fileComposicao = new File("composicao.txt");
	static File fileCarruagensComposicao = new File("carruagenscomposicao.txt");
	static File fileLinha = new File("linha.txt");
	static File fileEstacao = new File ("estacao.txt");
	static File fileLinhaEstacao = new File ("linhaestacao.txt");
	static File fileEstaleiro = new File ("estaleiro.txt");
	
	// array com os nomes dos ficheiros para serem criado com um ciclo void criarFicheiros
	static String FILENAME[]=new String[]{"automotora.txt","carruagem.txt","composicao.txt","carruagenscomposicao.txt","linha.txt", "estacao.txt", "linhaestacao.txt", "estaleiro.txt"};
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		criarFicheiros();
		//LE OS FICHEIROS
		lerFicheirosMatrizes();
	//	backupFicheiros();
		menuPrincipal();

	}
	

	public static void limparEcra() {  
		for(int i = 0; i < 80*300; i++)
		    System.out.println("");
	   } 
	

	static void menuHeader() {
		//limparEcra();
		//msg("");
		msg("--------------METRO COIMBRA SA - GESTÃO GAMA---------------");
		if (user=="") {user ="Default" ;}
			
		msg("user:" + user + "    Data/hora: " + LocalDateTime.now());
		msg("Autores: Bruno Cardoso Nº 11105 / Rodrigo Cunha Nº 11019");
		msg("-------------------------------------------------------------");
		msg("");
	}
	
	static void menuPrincipal() {

		menuHeader();
		int opcaoMenu=20;
	
		System.out.printf("-------------------------------------------------\n" + 
						"| MENU PRINCIPAL                        \t|\n" + 
						"-------------------------------------------------\n" + 
						"| 1 - Listar Empresa                  	  \t|\n" + 
						"| 2 - Gerir Automotora/Carruagens     	     \t|\n" + 
						"| 3 - Gerir Estaleiro                  	   \t|\n" + 
						"| 4 - Gerir Composição do Metro       	   \t|\n" + 
						"| 5 - Gerir Estação / Linha           	    \t|\n" + 
						"| 6 - Gerir Movimento                	   \t|\n" + 
						"| 7 - Obter Estatistica               	   \t|\n" + 
						"| 8 - Gerir Utilizadores              	    \t|\n" + 
						"| 9 - BACKUP DADOS                    	     \t|\n" + 
						"| 0 - SAIR                                     \t|\n"+
						"-------------------------------------------------\n");
		System.out.print("Indique Opção: ");
		
		try {
			String AUX = teclado.next();
			opcaoMenu = Integer.parseInt(AUX);
			
			switch (opcaoMenu){
			case 1 : menuListarEmpresa(); //lISTAR EMPRESA();
				break;
			case 2  : menuGerirAutomotora(); // GERIR AUTOMOTORAS/CARRUAGENS();
				break;
			case 3  : menuGerirEstaleiro(); // GERIR ESTALEIROS();
				break;
			case 4  : menuGerirComposicoes(); //R COMPOSIÇÃO METRO();
				break;
			case 5  : menuGerirEstacaoLinha(); // GERIR ESTAÇÃO/LINHA();
				break;
			case 6  : menuGerirMovimentos(); // GERIR MOVIMENTO();
				break;
			case 7  : menuEstatistica(); // OBTER ESTATISTICA();
				break;
			case 8  : menuUtilizadores(); // GERIR UTILIZADORES();
				break;
			case 9:  menuBackup(""); menuPrincipal(); // FAZ BACKUP();
				break;
			case 0:  menuSair(""); // TERMINA PROGRAMA();
				break;
				default : 	msg("Formato não reconhecido ");
				menuPrincipal();
			}
								
		} catch (NumberFormatException e2) {
			
			msg("Formato não reconhecido " + e2.getLocalizedMessage());
			menuPrincipal();
		} catch (Exception ex) {
			teclado.close();
			msg("Erro não especificado " + ex.getLocalizedMessage());
			menuPrincipal();
		}
	}

	
	static void menuListarEmpresa() {

		menuHeader();
		int opcaoMenu=20;
	
		System.out.printf("-------------------------------------------------\n" + 
						"| MENU 1 -> LISTAR EMPRESA                     \t|\n" + 
						"-------------------------------------------------\n" + 
						"| 1 - Listar todos as composições do metro     \t|\n" + 
						"| 2 - Listar todos as automotoras/carruagens  \t|\n" + 
						"| 3 - Listar automotoras/carruagens livres    \t|\n" + 
						"| 4 - Listar automotoras/carruagens ocupadas  \t|\n" + 
						"| 5 - Pesquisar automotora/carruagem          \t|\n" + 
						"| 0 - VOLTAR MENU ANTERIOR                   \t|\n" + 
						"-------------------------------------------------\n");
		System.out.print("Indique Opção: ");
		
		try {
			String AUX = teclado.next();
			opcaoMenu = Integer.parseInt(AUX);
			
			switch (opcaoMenu){
			case 1 : listaComposicao(); menuListarEmpresa();//Imprime a lista de todas as composições do metro existentes​ ​e​ ​informação​ ​associada​ ​(automotora,​ ​carruagens,​ ​etc.);
				break;
			case 2  : listaAutomotoraCarruagem(); menuListarEmpresa();  // Imprime a lista de todas as automotoras/carruagens​ ​existentes;
				break;
			case 3  : listaAutomotoraCarruagemLivres();menuListarEmpresa(); //  Imprime todas as automotoras/carruagens no estaleiro​ ​que​ ​não​ ​fazem​ ​parte​ ​de​ ​nenhuma​ ​composição​ ​do​ ​metro;
				break;
			case 4  : listaAutomotoraCarruagemOcupadas();menuListarEmpresa(); // Imprime todas as automotoras/carruagens associadas​ ​a​ ​uma​ ​composição​ ​do​ ​metro;
				break;
			case 5  : pesquisaAutomotoraCarruagem(); menuListarEmpresa(); // Pesquisa um automotora ou carruagem pelo seu código e	devolve​ ​o​ ​seu​ ​estado​ ​atual;
				break;
			case 0  : menuPrincipal(); // Volta Menu Principal();
				break;
				default : 	msg("Formato não reconhecido ");
				menuListarEmpresa();
			}
								
		} catch (NumberFormatException e2) {
			
			msg("Formato não reconhecido 1 " + e2.getLocalizedMessage());
			menuListarEmpresa();
		} catch (Exception ex) {
			teclado.close();
			msg("Erro não especificado " + ex.getLocalizedMessage());
			menuListarEmpresa();
		}
	}
	
	
	static void menuGerirAutomotora() {

		menuHeader();
		int opcaoMenu=20;
	
		System.out.printf("-------------------------------------------------\n" + 
						"| MENU 2 -> GERIR AUTOMOTORA/CARRUAGEM        \t|\n" + 
						"-------------------------------------------------\n" + 
						"| 1 - Criar automotora/carruagem              \t|\n" + 
						"| 2 - Alterar​​ ​​automotora/carruagem           \t|\n" + 
						"| 3 - Remover automotora/carruagem           \t|\n" + 
						"| 4 - Listar automotoras/carruagens          \t|\n" + 
						"| 5 - ------------                         \t|\n" + 
						"| 0 - VOLTAR MENU ANTERIOR                   \t|\n" + 
						"-------------------------------------------------\n");
		System.out.print("Indique Opção: ");
		
		try {
			String AUX = teclado.next();
			opcaoMenu = Integer.parseInt(AUX);
			
			switch (opcaoMenu){
			case 1 : adicionarAutomotoraCarruagem(); menuGerirAutomotora(); // Permite criar uma automotora/carruagem. Por defeito todas as automotoras/carruagens​ ​novas​ ​deverão​ ​ser​ ​inseridas​ ​no​ ​estaleiro
				break;
			case 2  : editaAutomotoraCarruagem();menuGerirAutomotora(); // Permite​ ​alterar​ ​uma​ ​automotora/carruagem​ ​existente;
				break;
			case 3  : eliminarAutomotoraCarruagem(); menuGerirAutomotora(); // Permite remover uma automotora/carruagem existente.Deverá garantir que a 
		        break;               //	automotora/carruagem não está associada a nenhuma composição do metro;
		        
			case 4  : listaAutomotoraCarruagem(); menuGerirAutomotora(); //  Imprime a lista total de automotoras/carruagens existentes e​ ​informação​ ​associada;;
				break;
			case 5  : msg("Menu para futura utilização"); pausa(); menuGerirAutomotora();//  a atribuir no futuro-----
				break;
			case 0  : menuPrincipal(); // Menu Principal
				break;
				default : 	msg("Formato não reconhecido ");
				menuGerirAutomotora();
			}
								
		} catch (NumberFormatException e2) {
			
			msg("Formato não reconhecido 1 " + e2.getLocalizedMessage());
			menuGerirAutomotora();
		} catch (Exception ex) {
			teclado.close();
			msg("Erro não especificado " + ex.getLocalizedMessage());
			menuGerirAutomotora();
		}
	}
	
		
	static void menuGerirEstaleiro() {

		menuHeader();
		int opcaoMenu=20;
	
		System.out.printf("-------------------------------------------------\n" + 
						"| MENU 3 -> GERIR ESTALEIRO                 \t|\n" + 
						"-------------------------------------------------\n" + 
						"| 1 - Inserir automotora/carruagem no estaleiro\t|\n" + 
						"| 2 - Remover automotora/carruagem             \t|\n" + 
						"| 3 - Listar automotora/carruagem              \t|\n" + 
						"| 4 - --------------------------------         \t|\n" + 
						"| 5 - --------------------------------         \t|\n" + 
						"| 0 - VOLTAR MENU ANTERIOR                   \t|\n" + 
						"-------------------------------------------------\n");
		System.out.print("Indique Opção: ");
		
		try {
			String AUX = teclado.next();
			opcaoMenu = Integer.parseInt(AUX);
			
			switch (opcaoMenu){
			case 1 : adicionarAutomotoraCarruagemEstaleiro(); menuGerirEstaleiro(); // Permite transferir uma automotora/carruagem para​ ​o​ ​estaleiro​ ​da​ ​empresa.;
				break;
			case 2  : eliminarAutomotoraCarruagemEstaleiro(); menuGerirEstaleiro(); //  Permite remover uma automotora/carruagem do estaleiro;
				break;
			case 3  : listaAutomotoraCarruagemEstaleiro(arrEstaleiro); menuGerirEstaleiro(); //  Imprime a lista de automotoras/carruagens existentes em	estaleiro​ ​e​ ​informação​ ​associada;
				break;
			case 4  :  msg("Menu para futura utilização"); pausa(); menuGerirEstaleiro();; // ------ future menu;
				break;
			case 5  :  msg("Menu para futura utilização"); pausa(); menuGerirEstaleiro();; // ------- future menu;
				break;
			case 0  : menuPrincipal(); // Ir menu Principal;
				break;
				default : 	msg("Formato não reconhecido ");
				menuGerirEstaleiro();
			}
								
		} catch (NumberFormatException e2) {
			msg("Formato não reconhecido 1 " + e2.getLocalizedMessage());
			menuGerirEstaleiro();
		} catch (Exception ex) {
			teclado.close();
			msg("Erro não especificado " + ex.getLocalizedMessage());
			menuGerirEstaleiro();
		}
	}
	
	
	static void menuGerirComposicoes() {

		menuHeader();
		int opcaoMenu=20;
	
		System.out.printf("-----------------------------------------------------------------\n" + 
						"| MENU 4 -> GERIR COMPOSIÇÕES METRO                         \t|\n" + 
						"----------------------------------------------------------------\n" + 
						"| 1 - Criar composição do metro                              \t|\n" + 
						"| 2 - Associar automotora/carruagem a uma composição do metro  \t|\n" + 
						"| 3 - Alterar​​ ​​composição​​ ​​do​​ ​​metro​​     			   \t|\n" + 
						"| 4 - Alterar assoc. de uma automotora/carruagem a Composicao \t|\n" + 
						"| 5 - Remover composição do metro  			       \t|\n" + 
						"| 6 - Remover assoc. de uma automotora/carruagem a Composicao \t|\n" + 
						"| 7 - Listar Composições do Metro                      \t|\n" +
						"| 0 - VOLTAR MENU ANTERIOR        			      \t|\n" + 
						"-----------------------------------------------------------------\n");
		System.out.print("Indique Opção: ");
		
		try {
			String AUX = teclado.next();
			opcaoMenu = Integer.parseInt(AUX);
			
			switch (opcaoMenu){
			case 1 : adicionarComposicao(); menuGerirComposicoes();  // Cria uma composição do metro através de um código	único​ ​e​ ​de​ ​um​ ​estado​ ​inicial;
				break;
			case 2  : associarAutomotoraCarruagemComposicao(); menuGerirComposicoes(); //  Associar uma	automotora/carruagem​ ​a​ ​uma​ ​composição​ ​do​ ​metro​ ​existente;
				break;
			case 3  : editarComposicao(arrComposicao); menuGerirComposicoes(); // ​Permite​ ​alterar​ ​uma​ ​composição​ ​do​ ​metro​ ​existente;
				break;
			case 4  : editarAssAutomotoraCarruagemComposicao(); menuGerirComposicoes(); //  Permite alterar a associação de uma automotora/carruagem​ ​a​ ​uma​ ​composição​ ​do​ ​metro​ ​existente;;
				break;
			case 5  : eliminarComposicao(arrComposicao); menuGerirComposicoes(); // Permite remover uma composição do metro existente	Antes de remover uma composição
			                       //do metro deverá remover todas as automotoras/carruagens​ ​associadas​;
				break;
			case 6  : eliminarAssAutomotoraCarruagemComposicao();menuGerirComposicoes(); // Permite remover a associação de uma automotora/carruagem​ ​a​ ​uma​ ​composição​ ​do​ ​metro​ ​existente;;
			break;
			case 7  : listaComposicao(); menuGerirComposicoes(); // Permite remover a associação de uma automotora/carruagem​ ​a​ ​uma​ ​composição​ ​do​ ​metro​ ​existente;;
			break;
			case 0  : menuPrincipal(); // Menu Principal();
				break;
				default : 	msg("Formato não reconhecido ");
				menuGerirComposicoes();
			}
								
		} catch (NumberFormatException e2) {
			
			msg("Formato não reconhecido 1 " + e2.getLocalizedMessage());
			menuGerirComposicoes();
		} catch (Exception ex) {
			teclado.close();
			msg("Erro não especificado " + ex.getLocalizedMessage());
			menuGerirComposicoes();
		}
	}
	
	
	static void menuGerirEstacaoLinha() {

		menuHeader();
		int opcaoMenu=20;
	
		System.out.printf("-----------------------------------------------------------------\n" + 
						"| MENU 5 -> GERIR ESTAÇÃO/LINHA                          \t|\n" + 
						"-----------------------------------------------------------------\n" + 
						"| 1 - Criar​​ ​​estação                                	      \t|\n" + 
						"| 2 - Alterar​​ ​​estação                              	    \t|\n" + 
						"| 3 - Remover​​ ​​estação​​     			          \t|\n" + 
						"| 4 - Criar​​ ​​linha	     			       	\t|\n" + 
						"| 5 - Alterar​​ ​​linha 			   		\t|\n" + 
						"| 6 - Remover​​ ​​linha	      				 \t|\n" + 
						"| 7 - Associar​​ ​​estação​​ ​​a​​ ​​uma​​ ​​linha 			\t|\n" + 
						"| 8 - Alterar​​ ​​estação​​ ​​de​​ ​​uma​​ ​​linha 			 \t|\n" + 
						"| 9 - Remover​​ ​​estação​​ ​​de​​ ​​uma​​ ​​linha	    		  \t|\n" +
						"| 10 - Listar​​ ​​estações	  	    			 \t|\n" + 
						"| 11 - Listar linhas	        		    	     \t|\n" + 
						//"| 12 - ----------	     				  \t|\n" + 
						//"| 13 - ----------	      				 \t|\n" + 
						"| 0 - VOLTAR MENU ANTERIOR         		  	      \t|\n" + 
						"-----------------------------------------------------------------\n");
		System.out.print("Indique Opção: ");
		
		try {
			String AUX = teclado.next();
			opcaoMenu = Integer.parseInt(AUX);
			
			switch (opcaoMenu){
			case 1 : adicionarEstacao(); menuGerirEstacaoLinha(); //Permite​ ​criar​ ​uma​ ​estação​ ​através​ ​de​ ​um​ ​código​ ​único,​ ​nome​ ​e​ ​localização;
				break;
			case 2  : editarEstacao(arrEstacao); menuGerirEstacaoLinha(); //  ​Permite​ ​alterar​ ​uma​ ​estação​ ​existente;
				break;
			case 3  : eliminarEstacao(arrEstacao); menuGerirEstacaoLinha(); //  ​Permite​ ​remover​ ​uma​ ​estação​ ​existente;
				break;
			case 4  : adicionarLinha(); menuGerirEstacaoLinha(); // ​Permite​ ​criar​ ​uma​ ​linha​ ​através​ ​do​ ​código​ ​único​ ​e​ ​nome;
				break;
			case 5  : editarLinha(arrLinha); menuGerirEstacaoLinha(); // Permite​ ​alterar​ ​uma​ ​linha​ ​existente;
				break;
			case 6  : eliminarLinha(arrLinha); menuGerirEstacaoLinha(); // Permite​ ​remover​ ​uma​ ​linha​ ​existente;
				break;
			case 7  : adicionarLinhaEstacao(); menuGerirEstacaoLinha(); // Permite​ ​associar​ ​uma​ ​estação​ ​a​ ​uma​ ​linha​ ​existente;
				break;
			case 8  : AUX="2"; // ​Permite​ ​alterar​ ​uma​ ​estação​ ​de​ ​uma​ ​linha​ ​para​ ​outra;
				break;
			case 9  : AUX="2"; // Permite​ ​remover​ ​uma​ ​estação​ ​de​ ​uma​ ​linha();
				break;
			case 10  : listaEstacao(); menuGerirEstacaoLinha(); // ​Permite​ ​listar​ ​todas​ ​as​ ​estações​ ​existentes();
				break;
			case 11  : listaLinha(); menuGerirEstacaoLinha(); // Permite listar todas as linhas existentes e respetiva informação
			                       //(número e nome	das​ ​estações);
				break;
			case 0  : menuPrincipal(); // Menu Principal();
				break;
				default : 	msg("Formato não reconhecido ");
				menuGerirEstacaoLinha();
			}
								
		} catch (NumberFormatException e2) {
			
			msg("Formato não reconhecido 1 " + e2.getLocalizedMessage());
			menuGerirEstacaoLinha();
		} catch (Exception ex) {
			teclado.close();
			msg("Erro não especificado " + ex.getLocalizedMessage());
			menuGerirEstacaoLinha();
		}
	}
	
	
	static void menuGerirMovimentos() {

		menuHeader();
		int opcaoMenu=20;
	
		System.out.printf("---------------------------------------------------------\n" + 
						"| MENU 6 - GERIR MOVIMENTOS                          \t|\n" + 
						"---------------------------------------------------------\n" + 
						"| 1 - Colocar composição do metro em circulação       \t|\n" + 
						"| 2 - Remover composição do metro de circulação	   \t|\n" + 
						"| 3 - Listar​​ ​​movimentos​​     	        	     \t|\n" + 
						"| 4 - ----------------				 \t|\n" + 
						"| 5 - ----------------                 		     \t|\n" + 
						"| 6 - ----------------                 		     \t|\n" + 
						"| 0 - VOLTAR MENU ANTERIOR          		     \t|\n" + 
						"--------------------------------------------------------\n");
		System.out.print("Indique Opção: ");
		
		try {
			String AUX = teclado.next();
			opcaoMenu = Integer.parseInt(AUX);
			
			switch (opcaoMenu){
			case 1 : colocarComposicaoCirculacao(arrComposicao);menuGerirMovimentos(); // Permite inserir uma composição do metro existente​ ​em​ ​circulação​ ​numa​ ​determinada​ ​linha;
				break;
			case 2  : removerComposicaoCirculacao(arrComposicao);menuGerirMovimentos(); //  Permite remover uma composição do metro	de​ ​circulação;;
				break;
			case 3  : msg("Nao desenvolvido"); pausa(); menuGerirMovimentos(); //  ​Imprime​ ​a​ ​lista​ ​de​ ​movimentos​ ​existentes​ ​e​ ​informação​ ​associada;;
				break;
			case 4  :  msg("Menu para futura utilização"); pausa(); menuGerirMovimentos(); // ----------Future Menu();
				break;
			case 5  :  msg("Menu para futura utilização"); pausa(); menuGerirMovimentos(); // ----------Future Menu();
				break;
			case 6  :  msg("Menu para futura utilização"); pausa(); menuGerirMovimentos(); // ----------Future Menu();
			break;
			case 0  : menuPrincipal(); // Menu Principal();
				break;
				default : 	msg("Formato não reconhecido ");
				menuGerirMovimentos();
			}
								
		} catch (NumberFormatException e2) {
			
			msg("Formato não reconhecido 1 " + e2.getLocalizedMessage());
			menuGerirMovimentos();
		} catch (Exception ex) {
			teclado.close();
			msg("Erro não especificado " + ex.getLocalizedMessage());
			menuGerirMovimentos();
		}
	}
	
	
	static void menuEstatistica() {

		menuHeader();
		int opcaoMenu=20;
	
		System.out.printf("-----------------------------------------------------------------\n" + 
						"| MENU 7 -> ESTATISTICA	                                \t|\n" + 
						"-----------------------------------------------------------------\n" + 
						"| 1 - Listar total de automotoras/carruagens	            \t|\n" + 
						"| 2 - Listar total de automotoras/carruagens em circulação\t|\n" + 
						"| 3 - Listar total de automotoras/carruagens paradas​​      \t|\n" + 
						"| 4 - Listar composições estacionados com justificação	   \t|\n" + 
						"| 5 - Listar total de lugares disponíveis 	         \t|\n" + 
						"| 6 - Outras ​​			                 	   \t|\n" + 
						//"| 7 - -------			                 	   \t|\n" +
						//"| 8 - -------​​			                 	   \t|\n" +
						"| 0 - VOLTAR MENU ANTERIOR          	        	       \t|\n" + 
						"-----------------------------------------------------------------\n");
		System.out.print("Indique Opção: ");
		
		try {
			String AUX = teclado.next();
			opcaoMenu = Integer.parseInt(AUX);
			
			switch (opcaoMenu){
			case 1 : listaAutomotoraCarruagem();menuEstatistica(); //Permite imprimir a contabilização do nº total de​ ​aut./carru.​ ​da​ ​empresa;;
				break;
			case 2  : listaAutomotoraCarruagemOcupadasCirculacao();menuEstatistica(); //imp. a contabilização do nº​ ​total​ ​de​ ​aut./carru.​atualmente​ ​em​ ​circulação;;
				break;
			case 3  : listaAutomotoraCarruagemOcupadasParadas(); menuEstatistica(); //imp. a conta. do	nº​ ​total​ ​de​ ​aut./car.​ ​paradas​ ​no​ ​estaleiro;;
				break;
			case 4  : listaAutomotoraCarruagemOcupadasFDS(); menuEstatistica(); //imp. a conta. aut./carr.s estacionados com a devida situação:
			                       //revisão, reparação de avaria, etc;
				break;
			case 5  : listaCarruagemOcupadasLugares(); menuEstatistica(); // Imp. a contab. número total de lugares​ ​de​ ​cada​ ​composição​ ​de​ ​um​ ​metro;;
				break;
			case 6  : msg("Menu para futura utilização"); pausa(); menuEstatistica();  // ----- Outras a definir;
			break;
			case 0  : menuPrincipal(); // Menu Principal();
				break;
				default : 	msg("Formato não reconhecido ");
				menuGerirMovimentos();
			}
								
		} catch (NumberFormatException e2) {
			
			msg("Formato não reconhecido 1 " + e2.getLocalizedMessage());
			menuEstatistica();
		} catch (Exception ex) {
			teclado.close();
			msg("Erro não especificado " + ex.getLocalizedMessage());
			menuEstatistica();
		}
	}
	
	
	static void menuUtilizadores() {

		menuHeader();
		int opcaoMenu=20;
	
		System.out.printf("-------------------------------------------------\n" + 
						"| MENU 8 -> UTILIZADORES	        \t|\n" + 
						"-------------------------------------------------\n" + 
						"| 1 - Listar Utilizadores	         \t|\n" + 
						"| 2 - Adicionar Utilizador         	  \t|\n" + 
						"| 3 - Apagar Utilizador            	  \t|\n" + 
						"| 4 - Registos Utilizador		      \t|\n" + 
						"| 7 - Mudar Password(Current User)       \t|\n" +
						"| 8 - -------​​			              \t|\n" +
						"| 0 - VOLTAR MENU ANTERIOR              \t|\n" + 
						"--------------------------------------------------\n");
		System.out.print("Indique Opção: ");
		
		try {
			String AUX = teclado.next();
			opcaoMenu = Integer.parseInt(AUX);
			
			switch (opcaoMenu){
			case 1 :  msg("Menu para futura utilização"); pausa(); menuUtilizadores(); //Listagem Utilizadores();
				break;
			case 2  :  msg("Menu para futura utilização"); pausa(); menuUtilizadores(); // Adiciona utilizador();
				break;
			case 3  :  msg("Menu para futura utilização"); pausa(); menuUtilizadores(); // Apaga Utulizador();
				break;
			case 4  :  msg("Menu para futura utilização"); pausa(); menuUtilizadores(); // Registos efectuados pelo Uilizador();
				break;
			case 5  :  msg("Menu para futura utilização"); pausa(); menuUtilizadores(); // Muda a Password do Utilizador em uso();
				break;
			case 6  :  msg("Menu para futura utilização"); pausa(); menuUtilizadores(); // -----Future Menu();
			break;
			case 0  : menuPrincipal(); // Menu Principal();
				break;
				default : 	msg("Formato não reconhecido ");
				menuUtilizadores();
			}
								
		} catch (NumberFormatException e2) {
			
			msg("Formato não reconhecido 1 " + e2.getLocalizedMessage());
			menuUtilizadores();
		} catch (Exception ex) {
			teclado.close();
			msg("Erro não especificado " + ex.getLocalizedMessage());
			menuUtilizadores();
		}
	}
	
	
	static void menuSair(String errorMsg) {
		menuHeader();  //coloca o cabeçalho da empresa
		msg(errorMsg);
		System.out.print("Confirma Sair? [S/N]: ");
		String Aux= teclado.next();
		
		if (Aux.toLowerCase().equals("n")){ // respondeu não volta ao menu inicial
			menuPrincipal();
		}else if (Aux.toLowerCase().equals("s")) {
			msg("Systema terminado, Temos pena");
			System.exit(0);
		}  else { 
			menuSair("Resposta incorrecta");
		}
		
		
	}
	
	static void menuBackup(String errorMsg) {
		
		String str1;
		boolean sair=false;

		do {

			System.out.print("Confirma Fazer Backup Bases Dados? [S/N]: ");
			str1 = teclado.next();

			if (str1.toLowerCase().equals("s")) { // utilizador confirmou inserção do registo
				backupFicheiros();
				menuPrincipal();
			} else if (str1.toLowerCase().equals("n")) {
				menuPrincipal();
			} else {
				msg("Resposta não reconhecida");
			}
			
			if (str1.toLowerCase().equals("s")) sair=true;
			if(str1.toLowerCase().equals("n")) sair=true;
			
		} while (sair==false);

		
		
		
		
		
		
	}
	
	
	
	// -------------------------------------------- FIM MENUS / INICIO Criar FICHEIROS----------------------------------------
	
	// (tudo ao molho ja que não dá pra usar outras classes)
	//arrAutomotora, arrCarruagem, arrComposicao, arrMovimentos, arrLinha, arrEstacao, arrLinhaEstacao
	
	
	public static void criarFicheiros() {
			
		for (int i=0; i<FILENAME.length; i++) {
			File ficheiro = new File(FILENAME[i]);
			if (!ficheiro.exists()) {
				msg(" A criar Ficheiros ... Aguarde");
				try {			
					if (ficheiro.createNewFile()) {
						System.out.println("Ficheiro criado com sucesso!");
					} else {
						System.out.println("Erro ao tentar criar o ficheiro!");
					}
				} catch(IOException e) {
					System.out.println("Erro na aplicação!");
					e.printStackTrace();
				}
			
		}
	}
	}	
	
	
	public static void limpaficheiro3 (File ficheiro) {
				
			try {
				String linha="";
				BufferedReader br = new BufferedReader(new FileReader(ficheiro));
				BufferedWriter bf = new BufferedWriter(new FileWriter(ficheiro.getAbsoluteFile(),true));  //este true é para abrir com autorização de escrita
				while ((linha = br.readLine())!=null) {
					linha="";
					bf.write(linha);
					}
				
				br.close();
				bf.close();
				
			} catch (IOException e) {
				System.out.println("Erro na aplica��o!");
				e.printStackTrace();
			}
	}
	
	
	
	public static void limpaFicheiro(File ficheiro) {
		if (ficheiro.exists()) {
			msg(" A Escrever Dados Nos Ficheiros ... Aguarde");
			File ficheiro1 =new File (ficheiro.toString());
			try {			
				if (ficheiro1.createNewFile()) {
					System.out.println("Ficheiro criado com sucesso!");
				} else {
					System.out.println("Erro ao tentar criar o ficheiro!");
				}
			} catch(IOException e) {
				System.out.println("Erro na aplicação!");
				e.printStackTrace();
			}
	}
	}
	
	
	public static void lerFicheirosMatrizes(){
		
		// Carrega todos os dados dos ficheiros para as matrizes
		lerFicheiroToMatriz(fileAutomotora, arrAutomotora,arrAutomotora.length,arrAutomotora[0].length);
		lerFicheiroToMatriz(fileCarruagem, arrCarruagem,arrCarruagem.length,arrCarruagem[0].length);
		lerFicheiroToMatriz(fileComposicao, arrComposicao,arrComposicao.length,arrComposicao[0].length);
		lerFicheiroToMatriz(fileCarruagensComposicao, arrCarruagensComposicao,arrCarruagensComposicao.length,arrCarruagensComposicao[0].length);
		lerFicheiroToMatriz(fileLinha, arrLinha,arrLinha.length,arrLinha[0].length);
		lerFicheiroToMatriz(fileEstacao, arrEstacao,arrEstacao.length,arrEstacao[0].length);
		lerFicheiroToMatriz(fileLinhaEstacao, arrLinhaEstacao,arrLinhaEstacao.length,arrLinhaEstacao[0].length);
		lerFicheiroToMatriz(fileEstaleiro, arrEstaleiro,arrEstaleiro.length,arrEstaleiro[0].length);
	}
	
	
	
	//  ================================ INICIO COMANDOS DUPLO SENTIDO AUTOMORA / CARRUAGEM =========================
	
	
	public static void adicionarAutomotoraCarruagem() {
		String str1;
		boolean sair=false;

		do {

			System.out.print("Indique [A] Adicionar Automotora  [C] Adicionar Carruagem");
			str1 = teclado.next();

			if (str1.toLowerCase().equals("a")) { // utilizador confirmou inserção do registo
				adicionarAutomotora();
			} else if (str1.toLowerCase().equals("c")) {
				adicionarCarruagem();
			} else {
				msg("Resposta não reconhecida");
			}
			
			if (str1.toLowerCase().equals("a")) sair=true;
			if(str1.toLowerCase().equals("c")) sair=true;
			
		} while (sair==false);
		
		
	}
	
	
	
	
	public static void editaAutomotoraCarruagem() {
		String str1;
		boolean sair=false;

		do {

			System.out.print("Indique [A] Editar Automotora  [C] Editar Carruagem : ");
			str1 = teclado.next();

			if (str1.toLowerCase().equals("a")) { // utilizador confirmou inserção do registo
				editarAutomotora(arrAutomotora);
			} else if (str1.toLowerCase().equals("c")) {
				editarCarruagem(arrCarruagem);
			} else {
				msg("Resposta não reconhecida");
			}
			
			if (str1.toLowerCase().equals("a")) sair=true;
			if(str1.toLowerCase().equals("c")) sair=true;
			
		} while (sair==false);
		
		
	}
	
	
	public static void eliminarAutomotoraCarruagem() {
		String str1;
		boolean sair=false;

		do {

			System.out.print("Indique [A] Eliminar Automotora  [C] Eliminar Carruagem : ");
			str1 = teclado.next();

			if (str1.toLowerCase().equals("a")) { // utilizador confirmou inserção do registo
				eliminarAutomotora(arrAutomotora);
			} else if (str1.toLowerCase().equals("c")) {
				eliminarCarruagem(arrCarruagem);
			} else {
				msg("Resposta não reconhecida");
			}
			
			if (str1.toLowerCase().equals("a")) sair=true;
			if(str1.toLowerCase().equals("c")) sair=true;
			
		} while (sair==false);
		
		
	}
	
	
	
	
	public static void associarAutomotoraCarruagemComposicao() {  // Fica a faltar o metodo associar automotora porque é na tabela composição
		String str1;
		boolean sair=false;

		do {

			System.out.print("Indique [A] Associar Automotora  [C] Associar Carruagem :  ");
			str1 = teclado.next();

			if (str1.toLowerCase().equals("a")) { // utilizador confirmou inserção do registo
				editarAutomotoraComposicao(arrComposicao);
				
			} else if (str1.toLowerCase().equals("c")) {
				adicionarCarruagensComposicao();
			} else {
				msg("Resposta não reconhecida");
			}
			
			if (str1.toLowerCase().equals("a")) sair=true;
			if(str1.toLowerCase().equals("c")) sair=true;
			
		} while (sair==false);
		
		
	}
	
	
	
	
	public static void editarAssAutomotoraCarruagemComposicao() {  // Fica a faltar o metodo associar automotora porque é na tabela composição
		String str1;
		boolean sair=false;

		do {

			System.out.print("Indique [A] Editar Associar Automotora  [C] Editar Associar Carruagem :  ");
			str1 = teclado.next();

			if (str1.toLowerCase().equals("a")) { // utilizador confirmou inserção do registo
				editarAutomotoraComposicao(arrComposicao);
				
			} else if (str1.toLowerCase().equals("c")) {
				editarCarruagensComposicao(arrCarruagensComposicao);
			} else {
				msg("Resposta não reconhecida");
			}
			
			if (str1.toLowerCase().equals("a")) sair=true;
			if(str1.toLowerCase().equals("c")) sair=true;
			
		} while (sair==false);
		
		
	}
	
	
	public static void eliminarAssAutomotoraCarruagemComposicao() {  // Fica a faltar o metodo associar automotora porque é na tabela composição
		String str1;
		boolean sair=false;

		do {

			System.out.print("Indique [A] Editar Associar Automotora  [C] Editar Associar Carruagem :  ");
			str1 = teclado.next();

			if (str1.toLowerCase().equals("a")) { // utilizador confirmou inserção do registo
				eliminarAutomotoraComposicao(arrComposicao);
				
			} else if (str1.toLowerCase().equals("c")) {
				eliminarCarruagensComposicao(arrCarruagensComposicao);
			} else {
				msg("Resposta não reconhecida");
			}
			
			if (str1.toLowerCase().equals("a")) sair=true;
			if(str1.toLowerCase().equals("c")) sair=true;
			
		} while (sair==false);
		
		
	}
	
	
	
	public static void adicionarAutomotoraCarruagemEstaleiro() {
		String str1;
		boolean sair=false;

		do {

			System.out.print("Indique [A] Adicionar Automotora Estaleiro \n       [C] Adicionar Carruagem Estaleiro : ");
			str1 = teclado.next();

			if (str1.toLowerCase().equals("a")) { // utilizador confirmou inserção do registo
				adicionarAutomotoraEstaleiro();
			} else if (str1.toLowerCase().equals("c")) {
				adicionarCarruagemEstaleiro();
			} else {
				msg("Resposta não reconhecida");
			}
			
			if (str1.toLowerCase().equals("a")) sair=true;
			if(str1.toLowerCase().equals("c")) sair=true;
			
		} while (sair==false);
		
		
	}
	
	public static void eliminarAutomotoraCarruagemEstaleiro() {
		String str1;
		boolean sair=false;

		do {

			System.out.print("Indique [A] Remover Automotora Estaleiro \n       [C] Remover Carruagem Estaleiro : ");
			str1 = teclado.next();

			if (str1.toLowerCase().equals("a")) { // utilizador confirmou inserção do registo
				eliminarAutomotoraEstaleiro(arrEstaleiro);
			} else if (str1.toLowerCase().equals("c")) {
				eliminarCarruagemEstaleiro(arrEstaleiro);
			} else {
				msg("Resposta não reconhecida");
			}
			
			if (str1.toLowerCase().equals("a")) sair=true;
			if(str1.toLowerCase().equals("c")) sair=true;
			
		} while (sair==false);
		
		
	}
	
	
	//==================================================INICIO COMANDOS ADICIONAR EDITAR==============================
	
	

	public static void adicionarAutomotora() {
		lerFicheirosMatrizes(); // para ter acerteza que os dados das arrays sao fidedignos
		// menuHeader();
		msg("---- ADICIONAR AUTOMOTORA ----");
		// arrAutomotora ... Campos--> SN_AUTOMOTORA(double ou str), TIPO
		// (Str)(D/E/Outro), POTENCIA(str), FABRICANTE(str), OBS (str)
			
		String arrCampos[] = new String[] { "Numero de Série", "Tipo - [D] Diesel,[E] Eletrica,[O] Outro", "Potencia","Fabricante", "Obs" };
		String str, strCompleta = "";

		for (int i = 0; i < arrCampos.length; i++) {
			str="";
			System.out.print("Insira " + arrCampos[i] + " : ");
			str = teclado.nextLine();
			// Validação do campo Numero de série
			str = str.trim();
			
			
			if (i == 0) {
				str=str.replace(" ", "");  // retira espaços no codigo
				if (str.equals("")) {
					msg("Valor Inválido");
					i--;
				} else if (str.contains(sepChar)) {
					msg("Valor digitado inclui caracter inválido: " + sepChar);
					i--;
				} else if (verificaID(arrAutomotora,str,0) == true) { //já existe na BD
					msg("Automotora já registada");
					i--;
				} else {
					str = str.trim();
					str=str.replace(" ", "");
					strCompleta += str + sepChar;
				}
			}

			// Validação campo tipo de automotora
			if (i == 1) {
				if (str.toLowerCase().equals("d")) {
					strCompleta += "DIESEL" + sepChar;
				} else if (str.toLowerCase().equals("e")) {
					strCompleta += "ELETRICA" + sepChar;
				} else if (str.toLowerCase().equals("o")) {
					strCompleta += "OUTRA" + sepChar;
				} else {
					msg("Valor Incorrecto");
					i--;
				}
				}

			// Restantes Campos
			if (i > 1) {
				str = str.replace(sepChar, "");
				str = str.trim();
				strCompleta += str + sepChar;
			}

		} // fim do for

		confirmaInserirRegisto(strCompleta,fileAutomotora,arrAutomotora);	// Confirmar a inserção do registo.
	}
	
	
	
	public static void editarAutomotora(String [][] Matriz) {
		lerFicheirosMatrizes();
		// menuHeader();
		msg("---- EDITAR AUTOMOTORA ----");
		
		
		String arrCampos[] = new String[] { "Numero de Série", "Tipo - [D] Diesel,[E] Eletrica,[O] Outro", "Potencia","Fabricante", "Obs" };
		String str= "";
		int Linha=-2; // valor diferente do -1 predefinido no metodo returnID o
		
		
		// verificar se a automotora a editar existe e retorna a linha a editar
				boolean sair=true;
		do {
			System.out.println("Insira Cod. de Automotora a editar:");
			str = teclado.nextLine();
			
			if (returnID(Matriz,str,0) != -1) {		
				Linha=returnID(Matriz,str,0);
				msg("Está a editar o Registo " + Matriz[Linha][0]);
				sair=true;
				
			}else {
					msg("Registo Não Encontrado");
					sair=false;
			}			
		}while(sair==false);
		
		
		
			str=""; // reset da variavel str para novas funções
		for (int i = 1; i < arrCampos.length; i++) {  // Aqui começa no ID 1 para o utilizador não puder alterar cod. por causa das tabelas filhos
			str="";
			msg("Insira " + arrCampos[i] + " : ");
			str = teclado.nextLine();
			str = str.trim();
			
			// Validação do campo Numero de série na edição permaece inalterado		
			//if (i == 0) {
					//str = Matriz[Linha][i];
			//}
		
			// Validação campo tipo de automotora
			if (i == 1) {
				if (str.toLowerCase().equals("d")) {
					Matriz[Linha][i] = "DIESEL";
				} else if (str.toLowerCase().equals("e")) {
					Matriz[Linha][i] = "ELETRICA";
				} else if (str.toLowerCase().equals("o")) {
					Matriz[Linha][i] = "OUTRA";
				} else {
					msg("Valor Incorrecto");
					i--;
				}
				}

			// Restantes Campos
			if (i > 1) {
				str = str.replace(sepChar, "");
				str = str.trim();
				Matriz[Linha][i] = str;
			}

		} // fim do for
		
		//escreveMatrizFicheiro(String Matriz[][], File ficheiro)
		escreveMatrizFicheiro(Matriz,fileAutomotora);	// Confirmar a inserção do registo.
	}
	
	public static void eliminarAutomotora(String[][] Matriz) {
		lerFicheirosMatrizes();
		// menuHeader();
		msg("---- ELIMINAR AUTOMOTORA ----");

		String arrCampos[] = new String[] { "Numero de Série", "Tipo - [D] Diesel,[E] Eletrica,[O] Outro", "Potencia","Fabricante", "Obs" };
		String str = "";
		int Linha = -2; // valor diferente do -1 predefinido no metodo returnID o

		// verificar se a automotora a editar existe e retorna a linha a editar
		boolean sair = true;
		do {
			System.out.println("Insira Cod. de Automotora a eliminar:");
			str = teclado.nextLine();

			if (returnID(Matriz, str, 0) != -1) {
				Linha = returnID(Matriz, str, 0);
			
				listaRegistoPorID(arrAutomotoraHeader, Matriz ,str);
					msg("Confirma a eliminar o Registo? [S/N] ");
					String aux= teclado.nextLine();
					if (aux.toLowerCase().equals("s")) { sair=true; }
					else {return;}

			} else {
				msg("Registo Não Encontrado");
				sair = false;
			}
		} while (sair == false);
		
		for (int i = 0; i < arrCampos.length; i++) { // Aqui começa no ID 1 para o utilizador não puder alterar cod. por
														// causa das tabelas filhos
			// Passa a vazio todos os campos
			Matriz[Linha][i] = "";
		}

		escreveMatrizFicheiro(Matriz, fileAutomotora); // Confirmar a inserção do registo.
		//Eliminar registos filhos 
				msg("A eliminar associações da Automotora a Composições");
				try {		
				EliminarByID(arrComposicao, fileComposicao, str,0);
				}catch (Exception e){
					msg("Erro " + e.getMessage());
				}
	}
	
	
	
	


	public static void adicionarCarruagem() {
		lerFicheirosMatrizes();
		// menuHeader();
		msg("---- ADICIONAR CARRUAGEM ----");
	//  Campos--> SN_CARRUAGEM(str), TIPO (Str)(1ª/2ª/3ª), Lugares(int), FABRICANTE (str), OBS (str)
		
		String arrCampos[] = new String[] { "Número de Série", "Tipo - [1] 1ªClasse, [2] 2ªClasse, [3] Bar [O] Outro", "Nº de Lugares","Fabricante", "Obs" };
		String str, strCompleta = "";

		for (int i = 0; i < arrCampos.length; i++) {
			str="";
			msg("Insira " + arrCampos[i] + " : ");
			str = teclado.nextLine();
			str = str.trim();
			
			// Validação do campo Numero de série
			if (i == 0) {
				str=str.replace(" ", "");  // Não permitir espaços no numero de serie COD
				if (str.equals("")) {
					msg("Valor nulo Inválido");
					i--;
				} else if (str.contains(sepChar)) {
					msg("Valor digitado inclui caracter inválido: " + sepChar);
					i--;
				} else if (verificaID(arrCarruagem,str,0) == true) { // verifica se este código de carruagem já está criado.
					msg("Automotora já registada");
					i--;
				} else {
					str = str.trim();
					strCompleta += str + sepChar;
				}
			}

			// Validação campo tipo de carruagem
			
			if (i == 1) {
				if (str.toLowerCase().equals("1")) {
					strCompleta += "1ª Classe" + sepChar;
				} else if (str.toLowerCase().equals("2")) {
					strCompleta += "2ª Classe" + sepChar;
				} else if (str.toLowerCase().equals("3")) {
					strCompleta += "Carr. Bar" + sepChar;
				} else if (str.toLowerCase().equals("o")) {
					strCompleta += "OUTRA" + sepChar;
				} else {
					msg("Valor Incorrecto");
					i--;
				}
			}

			// Validação campo lugares da carruagem
			if (i == 2) {
				try {
					int a = Integer.parseInt(str);
						if (a >= 0) {
					strCompleta += a + sepChar;
				} else {
					msg("Tem que inserir um valor inteiro superior 0");
					i--;
				}
				}catch (NumberFormatException e) {
						msg("Valor Incorrecto");
					i--;	
				}
			}

			// Restantes Campos
			if (i > 2) {
				str = str.replace(sepChar, "");
				str = str.trim();
				strCompleta += str + sepChar;
			}

		} // fim do for

		confirmaInserirRegisto(strCompleta,fileCarruagem,arrCarruagem);// Confirmar a inserção do registo.
	
	}
	
	
	public static void editarCarruagem(String [][] Matriz) {
		lerFicheirosMatrizes();
		// menuHeader();
		msg("---- EDITAR CARRUAGEM ----");
		
		
	//  Campos--> SN_CARRUAGEM(str), TIPO (Str)(1ª/2ª/3ª), Lugares(int), FABRICANTE (str), OBS (str)
			String arrCampos[] = new String[] { "Número de Série", "Tipo - [1] 1ªClasse, [2] 2ªClasse, [3] Bar [O] Outro", "Nº de Lugares","Fabricante", "Obs" };
			String str;
		int Linha=-2; // valor diferente do -1 predefinido no metodo returnID o
		
		
		// verificar se a automotora a editar existe e retorna a linha a editar
				boolean sair=true;
		do {
			System.out.println("Insira Cod. de Carruagem a editar:");
			str = teclado.nextLine();
			
			if (returnID(Matriz,str,0) != -1) {		
				Linha=returnID(Matriz,str,0);
				listaRegistoPorID(arrCarruagemHeader, Matriz ,str);
				msg("Está a editar o Registo " + str);
				sair=true;
				
			}else {
					msg("Registo Não Encontrado");
					sair=false;
			}			
		}while(sair==false);
		
		
		
			str=""; // reset da variavel str para novas funções
		for (int i = 1; i < arrCampos.length; i++) {  // Aqui começa no ID 1 para o utilizador não puder alterar cod. por causa das tabelas filhos
			str="";
			msg("Insira " + arrCampos[i] + " : ");
			str = teclado.nextLine();
			str = str.trim();
			
			// Validação do campo Numero de série na edição permanece inalterado		
			//if (i == 0) {
					//str = Matriz[Linha][i];
			//}
		
	// Validação campo tipo de carruagem
			
			if (i == 1) {
				if (str.toLowerCase().equals("1")) {
					Matriz[Linha][i] = "1ª Classe";
				} else if (str.toLowerCase().equals("2")) {
					Matriz[Linha][i] = "2ª Classe";
				} else if (str.toLowerCase().equals("3")) {
					Matriz[Linha][i] = "Carruagem Bar";
				} else if (str.toLowerCase().equals("o")) {
					Matriz[Linha][i] = "OUTRA";
				} else {
					msg("Valor Incorrecto");
					i--;
				}
			}

			// Validação campo lugares da carruagem
			if (i == 2) {
				try {
					int a = Integer.parseInt(str);
						if (a >= 0) {
							Matriz[Linha][i] = "" + a;
				} else {
					msg("Tem que inserir um valor inteiro superior 0");
					i--;
				}
				}catch (NumberFormatException e) {
						msg("Valor Incorrecto");
					i--;	
				}
			}

			// Restantes Campos
			if (i > 2) {
				str = str.replace(sepChar, "");
				str = str.trim();
				Matriz[Linha][i]= str; 
			}

		} // fim do for
		
		//escreveMatrizFicheiro(String Matriz[][], File ficheiro)
		escreveMatrizFicheiro(Matriz,fileCarruagem);	// Confirmar a inserção do registo.
		
	}
	
	
	public static void eliminarCarruagem(String[][] Matriz) {
		lerFicheirosMatrizes();
		// menuHeader();
		msg("---- ELIMINAR AUTOMOTORA ----");

		String arrCampos[] = new String[] { "Número de Série", "Tipo - [1] 1ªClasse, [2] 2ªClasse, [3] Bar [O] Outro", "Nº de Lugares","Fabricante", "Obs" };
		String str = "";
		int Linha = -2; // valor diferente do -1 predefinido no metodo returnID 0

		// verificar se a automotora a editar existe e retorna a linha a editar
		boolean sair = true;
		do {
			System.out.println("Insira Cod. de Automotora a eliminar:");
			str = teclado.nextLine();

			if (returnID(Matriz, str, 0) != -1) {
				Linha = returnID(Matriz, str, 0);

				listaRegistoPorID(arrCarruagemHeader, Matriz, str);
				msg("Confirma a eliminar o Registo? [S/N] ");
				String aux = teclado.nextLine();
				if (aux.toLowerCase().equals("s")) {
					sair = true;
				} else {
					return;
				}

			} else {
				msg("Registo Não Encontrado");
				sair = false;
			}
		} while (sair == false);

		for (int i = 0; i < arrCampos.length; i++) { // Aqui começa no ID 1 para o utilizador não puder alterar cod. por
			// causa das tabelas filhos
			// Passa a vazio todos os campos
			Matriz[Linha][i] = "";
		}

		escreveMatrizFicheiro(Matriz, fileCarruagem); // Confirmar a eliminacao do registo.
		
		//Eliminar registos filhos 
		msg("A eliminar associações da Carruagem a Composições");
		try {		
			msg(str);
		EliminarByID(arrCarruagensComposicao, fileCarruagensComposicao, str,0);
		}catch (Exception e){
			msg("Erro " + e.getMessage());
		}
	}
	
	
	public static void adicionarAutomotoraEstaleiro() {
		lerFicheirosMatrizes(); // para ter acerteza que os dados das arrays sao fidedignos
		// menuHeader();
		msg("---- ADICIONAR AUTOMOTORA AO ESTALEIRO ----");
			
		String arrCampos[] = new String[] { "COD. AUTOMOTORA","Estado [F]Funcional [A]Avariada [O]Outra","OBS"};
		String str, strCompleta = "";

		for (int i = 0; i < arrCampos.length; i++) {
			str="";
			System.out.print("Insira " + arrCampos[i] + " : ");
			str = teclado.nextLine();
			// Validação do campo Numero de série
			str = str.trim();
			
			
			if (i == 0) {
				str=str.replace(" ", "");  // retira espaços no codigo
				if (str.equals("")) {
					msg("Valor Inválido");
					i--;
				} else if (str.contains(sepChar)) {
					msg("Valor digitado inclui caracter inválido: " + sepChar);
					i--;
				} else if (verificaID(arrAutomotora,str,0) == false) { //já existe na BD
					msg("Automotora não registada");
					i--;
				} else if (verificaID(arrComposicao,str,1) == true) { //já existe na BD
					msg("Automotora Associada a uma Composição, Remova Associação Primeiro");
					i--;
				} else if (verificaID(arrEstaleiro,"AUT#"+str,0) == true) { //já existe na BD
					msg("Automotora já inserida no Estaleiro");
					i--;
				} else {
					str = "AUT#" + str.trim();   // Variavel Tipo, se for AUT# é Automotora se for CARR é carruagem
					str=str.replace(" ", "");
					strCompleta += str + sepChar;
				}
			}

			// Validação campo tipo de automotora
			if (i == 1) {
				if (str.toLowerCase().equals("f")) {
					strCompleta += "FUNCIONAL" + sepChar;
				} else if (str.toLowerCase().equals("a")) {
					strCompleta += "AVARIA" + sepChar;
				} else if (str.toLowerCase().equals("o")) {
					strCompleta += "OUTRA" + sepChar;
				} else {
					msg("Valor Incorrecto");
					i--;
				}
				}

			// Restantes Campos
			if (i > 1) {
				str = str.replace(sepChar, "");
				str = str.trim();
				strCompleta += str + sepChar;
			}

		} // fim do for

		confirmaInserirRegisto(strCompleta,fileEstaleiro,arrEstaleiro);	// Confirmar a inserção do registo.
	}
	
	public static void eliminarAutomotoraEstaleiro(String Matriz[][]) {
		lerFicheirosMatrizes();
		// menuHeader();
		msg("---- ELIMINAR AUTOMOTORA ESTALEIRO ----");

		String arrCampos[] = new String[] { "COD. AUTOMOTORA","Estado [F]Funcional [A]Avariada [O]Outra","OBS"};
		String str = "";
		int Linha = -2; // valor diferente do -1 predefinido no metodo returnID o

		// verificar se a automotora a editar existe e retorna a linha a editar
		boolean sair = true;
		do {
			System.out.println("Insira Cod. de Automotora a eliminar (Apenas codigo sem prefixo):");
			str = teclado.nextLine();

			if (returnID(Matriz, "AUT#"+str, 0) != -1) {
				Linha = returnID(Matriz, "AUT#"+str, 0);
			
				listaRegistoPorID(arrEstaleiroHeader, Matriz ,"AUT#"+str);
					msg("Confirma a eliminar o Registo? [S/N] ");
					String aux= teclado.nextLine();
					if (aux.toLowerCase().equals("s")) { sair=true; }
					else {return;}

			} else {
				msg("Registo Não Encontrado");
				sair = false;
			}
		} while (sair == false);
		
		for (int i = 0; i < arrCampos.length; i++) { // Aqui começa no ID 1 para o utilizador não puder alterar cod. por
														// causa das tabelas filhos
			// Passa a vazio todos os campos
			Matriz[Linha][i] = "";
		}

		escreveMatrizFicheiro(Matriz, fileEstaleiro); // Confirmar a inserção do registo.
		//Eliminar registos filhos 
				
	}
	
	
	
	public static void adicionarCarruagemEstaleiro() {
		lerFicheirosMatrizes(); // para ter acerteza que os dados das arrays sao fidedignos
		// menuHeader();
		msg("---- ADICIONAR CARRUAGEM AO ESTALEIRO ----");
			
		String arrCampos[] = new String[] { "COD. CARRUAGEM","Estado [F]Funcional [A]Avariada [O]Outra","OBS"};
		String str, strCompleta = "";

		for (int i = 0; i < arrCampos.length; i++) {
			str="";
			System.out.print("Insira " + arrCampos[i] + " : ");
			str = teclado.nextLine();
			// Validação do campo Numero de série
			str = str.trim();
			
			if (i == 0) {
				str=str.replace(" ", "");  // retira espaços no codigo
				if (str.equals("")) {
					msg("Valor Inválido");
					i--;
				} else if (str.contains(sepChar)) {
					msg("Valor digitado inclui caracter inválido: " + sepChar);
					i--;
				} else if (verificaID(arrCarruagem,str,0) == false) { //já existe na BD
					msg("Carruagem não registada");
					i--;
				} else if (verificaID(arrCarruagensComposicao,str,0) == true) { //já existe na BD
					msg("Carruagem Associada a uma Composição, Remova Associação Primeiro");
					i--;
				} else if (verificaID(arrEstaleiro,"CARR#"+str,0) == true) { //já existe na BD
					msg("Carruagem já inserida no Estaleiro");
					i--;
				} else {
					str = "CARR#" + str.trim();   // Variavel Tipo, se for AUT é Automotora se for CARR é carruagem
					str=str.replace(" ", "");
					strCompleta += str + sepChar;
				}
			}

			// Validação campo tipo de automotora
			if (i == 1) {
				if (str.toLowerCase().equals("f")) {
					strCompleta += "FUNCIONAL" + sepChar;
				} else if (str.toLowerCase().equals("a")) {
					strCompleta += "AVARIA" + sepChar;
				} else if (str.toLowerCase().equals("o")) {
					strCompleta += "OUTRA" + sepChar;
				} else {
					msg("Valor Incorrecto");
					i--;
				}
				}

			// Restantes Campos
			if (i > 1) {
				str = str.replace(sepChar, "");
				str = str.trim();
				strCompleta += str + sepChar;
			}

		} // fim do for

		confirmaInserirRegisto(strCompleta,fileEstaleiro,arrEstaleiro);	// Confirmar a inserção do registo.
	}
	
	public static void eliminarCarruagemEstaleiro(String Matriz[][]) {
		lerFicheirosMatrizes();
		// menuHeader();
		msg("---- ELIMINAR CARRUAGEM ESTALEIRO ----");

		String arrCampos[] = new String[]  { "COD. CARRUAGEM","Estado [F]Funcional [A]Avariada [O]Outra","OBS"};
		String str = "";
		int Linha = -2; // valor diferente do -1 predefinido no metodo returnID o

		boolean sair = true;
		do {
			System.out.println("Insira Cod. de Carruagem a eliminar (Apenas codigo sem prefixo):");
			str = teclado.nextLine();

			if (returnID(Matriz, "CARR#"+str, 0) != -1) {
				Linha = returnID(Matriz, "CARR#"+str, 0);
			
				listaRegistoPorID(arrEstaleiroHeader, Matriz ,"CARR#"+str);
					msg("Confirma a eliminar o Registo? [S/N] ");
					String aux= teclado.nextLine();
					if (aux.toLowerCase().equals("s")) { sair=true; }
					else {return;}

			} else {
				msg("Registo Não Encontrado");
				sair = false;
			}
		} while (sair == false);
		
		for (int i = 0; i < arrCampos.length; i++) { // Aqui começa no ID 1 para o utilizador não puder alterar cod. por
														// causa das tabelas filhos
			// Passa a vazio todos os campos
			Matriz[Linha][i] = "";
		}

		escreveMatrizFicheiro(Matriz, fileEstaleiro); // Confirmar a inserção do registo.
		//Eliminar registos filhos 
				
	}
		
	
	public static void adicionarLinha() {
		lerFicheirosMatrizes();
		// menuHeader();
		msg("-------- ADICIONAR LINHA --------");
	//  { "COD_LINHA", "NOME", "INICIO","FIM", "Obs" };
		
		String arrCampos[] = new String[] { "Codigo Linha", "Nome Linha", "Inicio","Fim", "Obs" };
		String str, strCompleta = "";

		for (int i = 0; i < arrCampos.length; i++) {
			str="";
			msg("Insira " + arrCampos[i] + " : ");
			str = teclado.nextLine();
			
			// Validação do campo Cod Linha
			if (i == 0) {
				str=str.replace(" ", "");
				if (str.equals("")) {
					msg("Valor nulo Inválido");
					i--;
				} else if (str.contains(sepChar)) {
					msg("Valor digitado inclui caracter inválido: " + sepChar);
					i--;
				} else if (verificaID(arrLinha,str,0) == true) { // verifica se este código de linha já está criado.
					msg("Cod Linha já registada");
					i--;
				} else {
					str = str.trim();
					strCompleta += str + sepChar;
				}
			}

			// Validação campo Nome de Linha
			
			if (i == 1) {
				if (str.equals("")) {
					msg("Valor nulo Inválido");
					i--;
				} else if (str.contains(sepChar)) {
					msg("Valor digitado inclui caracter inválido: " + sepChar);
					i--;
				} else if (verificaID(arrLinha,str,1) == true) { // verifica se este código de linha já está criado.
					msg("Linha já registada");
					i--;
				} else {
					str = str.trim();
					strCompleta += str + sepChar;
				}
			}

			// Restantes Campos
			if (i > 1) {
				str = str.replace(sepChar, "");
				str = str.trim();
				strCompleta += str + sepChar;
			}
		} // fim do for

	
		confirmaInserirRegisto(strCompleta,fileLinha,arrLinha); // Confirmar a inserção do registo.
		
	}
	
	public static void editarLinha(String Matriz[][]) {
		lerFicheirosMatrizes();
		// menuHeader();
		msg("-------- EDITAR LINHA --------");
	//  { "COD_LINHA", "NOME", "INICIO","FIM", "Obs" };
		
		String arrCampos[] = new String[] { "Codigo Linha", "Nome Linha", "Inicio","Fim", "Obs" };
		String str = "";
	int Linha=-2; // valor diferente do -1 predefinido no metodo returnID o
		
		
		// verificar se a linha a editar existe e retorna a linha a editar
				boolean sair=true;
		do {
			System.out.println("Insira Cod. de Linha a editar:");
			str = teclado.nextLine();
			
			if (returnID(Matriz,str,0) != -1) {		
				Linha=returnID(Matriz,str,0);
				listaRegistoPorID(arrLinhaHeader, Matriz ,str);
				msg("Está a editar o Registo " + str);
				sair=true;
				
			}else {
					msg("Registo Não Encontrado");
					sair=false;
			}			
		}while(sair==false);
		
		
		
		for (int i = 1; i < arrCampos.length; i++) {
			str="";
			msg("Insira " + arrCampos[i] + " : ");
			str = teclado.nextLine();
			
			// Validação do campo Cod Linha - não deixa editar ID senão dava muito trabalho
			// Validação campo Nome de Linha
			
			if (i == 1) {
				if (str.equals("")) {
					msg("Valor nulo Inválido");
					i--;
				} else if (str.contains(sepChar)) {
					msg("Valor digitado inclui caracter inválido: " + sepChar);
					i--;
				} else if (verificaID(arrLinha,str,1) == true) { // verifica se este código de linha já está criado.
					msg("Linha já registada");
					i--;
				} else {
					Matriz[Linha][i] = str.trim();
					
				}
			}

			// Restantes Campos
			if (i > 1) {
				str = str.replace(sepChar, "");
				str = str.trim();
				Matriz[Linha][i]= str;
			}

		} // fim do for

		//escreveMatrizFicheiro(String Matriz[][], File ficheiro)
				escreveMatrizFicheiro(Matriz,fileLinha);	// Confirmar a inserção do registo.
		
		
	}
	 
	
	public static void eliminarLinha(String Matriz[][]) {
	lerFicheirosMatrizes();
	// menuHeader();
	msg("-------- ELIMINAR LINHA --------");
//  { "COD_LINHA", "NOME", "INICIO","FIM", "Obs" };
	
	String arrCampos[] = new String[] { "Codigo Linha", "Nome Linha", "Inicio","Fim", "Obs" };
	String str = "";
	int Linha=-2; // valor diferente do -1 predefinido no metodo returnID o
	
	
	// verificar se a linha a editar existe e retorna a linha a editar
			boolean sair=true;
	do {
		System.out.println("Insira Cod. de Linha a editar:");
		str = teclado.nextLine();
		
		if (returnID(Matriz,str,0) != -1) {		
			Linha=returnID(Matriz,str,0);
			listaRegistoPorID(arrLinhaHeader, Matriz ,str);
			msg("Está a eliminar o Registo " + str);
			sair=true;
			
		}else {
				msg("Registo Não Encontrado");
				sair=false;
		}			
	}while(sair==false);
	
	
		for (int i = 0; i < arrCampos.length; i++) { // Aqui começa no ID 1 para o utilizador não puder alterar cod. por
		// causa das tabelas filhos
			// Passa a vazio todos os campos
			Matriz[Linha][i] = "";
		}
	
		escreveMatrizFicheiro(Matriz,fileEstacao);
		EliminarByID(arrLinhaEstacao, fileLinhaEstacao, str,1); // 1 é o index da coluna Cod_Linha
	
	
}
	
	
	public static void adicionarEstacao() {
		lerFicheirosMatrizes();
		// menuHeader();
		msg("-------- ADICIONAR ESTACAO --------");
	
		// Campos "COD ESTACAO", "NOME", "LOCAL","LAT/LNG", "Obs" };
		
		String arrCampos[] = new String[] { "Codigo Estação", "Nome Estação","Local","Lat/Lng", "Obs" };
		String str, strCompleta = "";

		for (int i = 0; i < arrCampos.length; i++) {
			str="";
			msg("Insira " + arrCampos[i] + " : ");
			str = teclado.nextLine();
			
			// Validação do campo Cod estacao
			if (i == 0) {
				if (str.equals("")) {
					msg("Valor nulo Inválido");
					i = -1;
				} else if (str.contains(sepChar)) {
					msg("Valor digitado inclui caracter inválido: " + sepChar);
					i = -1;
				} else if (verificaID(arrEstacao,str,0) == true) { // verifica se este código de estacao já está criado.
					msg("Codigo de Estação já registada");
					i = -1;
				} else {
					str = str.trim();
					strCompleta += str + sepChar;
				}
			}

			// Validação campo Nome de Linha
			
			if (i == 1) {
				if (str.equals("")) {
					msg("Valor nulo Inválido");
					i = 0;
				} else if (str.contains(sepChar)) {
					msg("Valor digitado inclui caracter inválido: " + sepChar);
					i = 0;
				} else if (verificaID(arrEstacao,str,1) == true) { // verifica se este código de carruagem já está criado.
					msg("Nome de Estação já registada");
					i = 0;
				} else {
					str = str.trim();
					strCompleta += str + sepChar;
				}
			}

			// Restantes Campos
			if (i > 1) {
				str = str.replace(sepChar, "");
				str = str.trim();
				strCompleta += str + sepChar;
			}

		} // fim do for

		
		confirmaInserirRegisto(strCompleta,fileEstacao,arrEstacao);//Confirmar a inserção do registo.
	
	}
	
	
	public static void editarEstacao(String Matriz[][]) {
		lerFicheirosMatrizes();
		// menuHeader();
		msg("-------- EDITAR ESTACAO --------");
	
		// Campos "COD ESTACAO", "NOME", "LOCAL","LAT/LNG", "Obs" };
		
		String arrCampos[] = new String[] { "Codigo Estação", "Nome Estação","Local","Lat/Lng", "Obs" };
		String str = "";

		int Linha = -2; // valor diferente do -1 predefinido no metodo returnID o

		// verificar se a estacao a editar existe e retorna a linha a editar
		boolean sair = true;
		do {
			System.out.println("Insira Cod. de Estação a editar:");
			str = teclado.nextLine();

			if (returnID(Matriz, str, 0) != -1) {
				Linha = returnID(Matriz, str, 0);
				listaRegistoPorID(arrEstacaoHeader, Matriz, str);
				msg("Está a editar o Registo " + str);
				sair = true;

			} else {
				msg("Registo Não Encontrado");
				sair = false;
			}
		} while (sair == false);
		
		
		for (int i = 1; i < arrCampos.length; i++) {
			str="";
			msg("Insira " + arrCampos[i] + " : ");
			str = teclado.nextLine();
			
			// Validação do campo Cod estacao nãopode ser alterado
			// Validação campo Nome de Estacao
			
			if (i == 1) {
				if (str.equals("")) {
					msg("Valor nulo Inválido");
					i = 0;
				} else if (str.contains(sepChar)) {
					msg("Valor digitado inclui caracter inválido: " + sepChar);
					i = 0;
				} else if (verificaID(arrEstacao,str,1) == true) { // verifica se este código de carruagem já está criado.
					msg("Nome de Estação já registada");
					i = 0;
				} else {
					str = str.trim();
					Matriz[Linha][i] = str;
				}
			}

			// Restantes Campos
			if (i > 1) {
				str = str.replace(sepChar, "");
				str = str.trim();
				Matriz[Linha][i]= str;
						}
		} // fim do for
		escreveMatrizFicheiro(Matriz,fileEstacao);
	}
	
	
	public static void eliminarEstacao(String Matriz[][]) {
		lerFicheirosMatrizes();
		// menuHeader();
		msg("-------- ELIMINAR ESTACAO --------");
	
		// Campos "COD ESTACAO", "NOME", "LOCAL","LAT/LNG", "Obs" };
		
		String arrCampos[] = new String[] { "Codigo Estação", "Nome Estação","Local","Lat/Lng", "Obs" };
		String str = "";

		int Linha = -2; // valor diferente do -1 predefinido no metodo returnID o

		// verificar se a estacao a editar existe e retorna a linha a editar
		boolean sair = true;
		do {
			System.out.println("Insira Cod. de Estação a editar:");
			str = teclado.nextLine();

			if (returnID(Matriz, str, 0) != -1) {
				Linha = returnID(Matriz, str, 0);
				listaRegistoPorID(arrEstacaoHeader, Matriz, str);
				msg("Está a Eliminar o Registo " + str);
				sair = true;

			} else {
				msg("Registo Não Encontrado");
				sair = false;
			}
		} while (sair == false);
		
		
		for (int i = 0; i < arrCampos.length; i++) { // Aqui começa no ID 1 para o utilizador não puder alterar cod. por
			// causa das tabelas filhos
	// Passa a vazio todos os campos
	Matriz[Linha][i] = "";
	}
		
		escreveMatrizFicheiro(Matriz,fileEstacao);
		EliminarByID(arrLinhaEstacao, fileLinhaEstacao, str,0); // 1 é o index da coluna Cod_Estacao
	}
	
	
	
	public static void adicionarComposicao() {
		lerFicheirosMatrizes();
		// menuHeader();
		msg("---- ADICIONAR COMPOSICAO ----");
	//  Campos--> { "COD COMP", "COD AUTOMOTORA","NOME", "DATACRIACAO","STATUS","COD LINHA","DATA STATUS" };
		
		String arrCampos[] = new String[] {"Cod. Composição", "Nome Composição", "Cod Automotora", "DATACRIACAO","Status da Composição","COD LINHA","DATA STATUS"};
		String str, strCompleta = "";

		for (int i = 0; i < arrCampos.length; i++) {
			str="";
			
			
			// Validação do campo Numero de série
			if (i == 0) {
				msg("Insira " + arrCampos[i] + " : ");
				str = teclado.nextLine();
				str = str.trim();
				
				str=str.replace(" ", "");  // Não permitir espaços no numero de serie COD
				if (str.equals("")) {
					msg("Valor nulo Inválido");
					i--;
				} else if (str.contains(sepChar)) {
					msg("Valor digitado inclui caracter inválido: " + sepChar);
					i--;
				} else if (verificaID(arrComposicao,str,0) == true) { // verifica se este código de carruagem já está criado.
					msg(arrCampos[i] + " já registado");
					i--;
				} else {
					str = str.trim();
					strCompleta += str + sepChar;
				}
			}


			// Validação do campo Nome Composição
						if (i == 1) {
							msg("Insira " + arrCampos[i] + " : ");
							str = teclado.nextLine();
							str = str.trim();
							
							str=str.replace(" ", "");  // Não permitir espaços no numero de serie COD
							if (str.equals("")) {
								msg("Valor nulo Inválido");
								i--;
							} else if (str.contains(sepChar)) {
								msg("Valor digitado inclui caracter inválido: " + sepChar);
								i--;
							} else if (verificaID(arrComposicao,str,1) == true) { // verifica se este código de carruagem já está criado.
								msg(arrCampos[i] + " já registado");
								i--;
							} else {
								str = str.trim();
								strCompleta += str + sepChar;
							}
						}

			
						// Validação do campo COD_ AUTOMOTORA Não e registado nesta fase insere valor vazio
						if (i == 2) {
							str="";
									strCompleta += str + sepChar;
							}

						// Validação do campo DataCriação						
						if (i == 3) {
							str=LocalDateTime.now().toString();
									strCompleta += str + sepChar;
							}
						
						
						
						
			// Validação campo tipo de status
			if (i == 4) {
				msg("Insira " + arrCampos[i] + " : ");
				msg("  [S]Sem Status \n  [C]  Em circulação \n  [R] Em Reparação \n  [F] Paragem Fim de Semana \n [O]  Outro  ");
				str = teclado.nextLine();
				str = str.trim();
				
				if (str.toLowerCase().equals("s")) {
					strCompleta += "SEM STATUS" + sepChar;
				} else if (str.toLowerCase().equals("c")) {
					strCompleta += "CIRCULACAO" + sepChar;
				} else if (str.toLowerCase().equals("r")) {
					strCompleta += "REPARAÇÃO" + sepChar;
				} else if (str.toLowerCase().equals("f")) {
					strCompleta += "PARAGEM FDS" + sepChar;
				} else if (str.toLowerCase().equals("o")) {
					strCompleta += "OUTRA" + sepChar;
				} else {
					msg("Valor Incorrecto");
					i--;
				}
			}
			
			// Validacao campo COD_Linha
			if (i == 5) {
				msg("Insira " + arrCampos[i] + " : ");
				str = teclado.nextLine();
				str = str.trim();
				
				str=str.replace(" ", "");  // Não permitir espaços no numero de serie COD
				if (str.equals("")) {
					msg("Valor nulo Inválido");
					i--;
				} else if (str.contains(sepChar)) {
					msg("Valor digitado inclui caracter inválido: " + sepChar);
					i--;
				} else if (verificaID(arrLinha,str,0) == false) { // verifica se este código de carruagem já está criado.
					msg(arrCampos[i] + " não registado");
					i--;
				} else {
					str = str.trim();
					strCompleta += str + sepChar;
				}
			}
			
			
			// Validação do campo Data Status						
			if (i == 6) {
				str=LocalDateTime.now().toString();
						strCompleta += str + sepChar;
				}
			

			// Restantes Campos Podem existir outro campos estupidos no futuro
			if (i > 6) {
				str = str.replace(sepChar, "");
				str = str.trim();
				strCompleta += str + sepChar;
			}

		} // fim do for

		confirmaInserirRegisto(strCompleta,fileComposicao,arrComposicao);// Confirmar a inserção do registo.
	
	}
	
	
	public static void editarComposicao(String Matriz[][]) {
		lerFicheirosMatrizes();
		// menuHeader();
		msg("---- EDITAR COMPOSICAO ----");
	//  Campos--> { "COD COMP", "COD AUTOMOTORA","NOME", "DATACRIACAO","STATUS","COD LINHA","DATA STATUS" };
		
		String arrCampos[] = new String[] {"Cod. Composição", "Nome Composição", "Cod Automotora", "DATACRIACAO","Status da Composição","COD LINHA","DATA STATUS"};
		String str= "";

		int Linha = -2; // valor diferente do -1 predefinido no metodo returnID o

		// verificar se a estacao a editar existe e retorna a linha a editar
		boolean sair = true;
		do {
			System.out.println("Insira Cod. de Composição a editar:");
			str = teclado.nextLine();

			if (returnID(Matriz, str, 0) != -1) {
				Linha = returnID(Matriz, str, 0);
				listaRegistoPorID(arrComposicaoHeader, Matriz, str);
				msg("Está a editar o Registo " + str);
				sair = true;

			} else {
				msg("Registo Não Encontrado");
				sair = false;
			}
		} while (sair == false);
		
		for (int i = 1; i < arrCampos.length; i++) {
			str="";
			
			// Validação do campo Numero de série - não deixa alterar cod compsição
	
			// Validação do campo Nome Composição
						if (i == 1) {
							msg("Insira " + arrCampos[i] + " : ");
							str = teclado.nextLine();
							str = str.trim();
							
							str=str.replace(" ", "");  // Não permitir espaços no numero de serie COD
							if (str.equals("")) {
								msg("Valor nulo Inválido");
								i--;
							} else if (str.contains(sepChar)) {
								msg("Valor digitado inclui caracter inválido: " + sepChar);
								i--;
							} else if (verificaID(arrComposicao,str,1) == true) { // verifica se este código de carruagem já está criado.
								msg(arrCampos[i] + " já registado");
								i--;
							} else {
								str = str.trim();
								Matriz[Linha][i]= str;
							}
						}

			
						// Validação do campo COD_ AUTOMOTORA Não e registado nesta fase insere valor vazio
						if (i == 2) {
							str="";
							//não altera a associacao à automotora
							}

						// Validação do campo DataCriação						
						if (i == 3) {
							str=LocalDateTime.now().toString();
							Matriz[Linha][i] = str;
							}
						
						
						
						
			// Validação campo tipo de status
			if (i == 4) {
				msg("Insira " + arrCampos[i] + " : ");
				msg("  [S] Sem Status \n  [C] Em circulação \n  [R] Em Reparação \n  [F] Paragem Fim de Semana \n [O] Outro  ");
				str = teclado.nextLine();
				str = str.trim();
				
				if (str.toLowerCase().equals("s")) {
					Matriz[Linha][i] = "SEM STATUS";
				} else if (str.toLowerCase().equals("c")) {
					Matriz[Linha][i]= "CIRCULACAO";
				} else if (str.toLowerCase().equals("r")) {
					Matriz[Linha][i] = "REPARAÇÃO";
				} else if (str.toLowerCase().equals("f")) {
					Matriz[Linha][i] = "PARAGEM FDS";
				} else if (str.toLowerCase().equals("o")) {
					Matriz[Linha][i] = "OUTRA";
				} else {
					msg("Valor Incorrecto");
					i--;
				}
			}
			
			// Validacao campo COD_Linha
			if (i == 5) {
				msg("Insira " + arrCampos[i] + " : ");
				str = teclado.nextLine();
				str = str.trim();
				
				str=str.replace(" ", "");  // Não permitir espaços no numero de serie COD
				if (str.equals("")) {
					msg("Valor nulo Inválido");
					i--;
				} else if (str.contains(sepChar)) {
					msg("Valor digitado inclui caracter inválido: " + sepChar);
					i--;
				} else if (verificaID(arrLinha,str,0) == false) { // verifica se este código de carruagem já está criado.
					msg(arrCampos[i] + " não registado");
					i--;
				} else {
					str = str.trim();
					Matriz[Linha][i]= str;
				}
			}
			
			
			// Validação do campo Data Status						
			if (i == 6) {
				str=LocalDateTime.now().toString();
				Matriz[Linha][i]= str;
				}
			

			// Restantes Campos Podem existir outro campos estupidos no futuro
			if (i > 6) {
				str = str.replace(sepChar, "");
				str = str.trim();
				Matriz[Linha][i] = str;
			}

		} // fim do for

		escreveMatrizFicheiro(Matriz,fileComposicao);
	
	}
	
	
	public static void colocarComposicaoCirculacao(String Matriz[][]) {
		lerFicheirosMatrizes();
		// menuHeader();
		msg("---- COLOCAR COMPOSICAO EM CIRCULACAO ----");
	//  Campos--> { "COD COMP", "COD AUTOMOTORA","NOME", "DATACRIACAO","STATUS","COD LINHA","DATA STATUS" };
		String str= "";

		int Linha = -2; // valor diferente do -1 predefinido no metodo returnID o

		// verificar se a estacao a editar existe e retorna a linha a editar
		boolean sair = true;
		do {
			System.out.println("Insira Cod. de Composição a editar:");
			str = teclado.nextLine();

			if (returnID(Matriz, str, 0) != -1) {
				Linha = returnID(Matriz, str, 0);
				listaRegistoPorID(arrComposicaoHeader, Matriz, str);
				msg("Está a editar o Registo " + str);
				sair = true;

			} else {
				msg("Registo Não Encontrado");
				sair = false;
			}
		} while (sair == false);
		

			// Validação campo tipo de status
				Matriz[Linha][4]= "CIRCULACAO";
				escreveMatrizFicheiro(Matriz,fileComposicao);
	
	}
	
	
	public static void removerComposicaoCirculacao(String Matriz[][]) {
		lerFicheirosMatrizes();
		// menuHeader();
		msg("---- REMOVER COMPOSICAO EM CIRCULACAO ----");
	//  Campos--> { "COD COMP", "COD AUTOMOTORA","NOME", "DATACRIACAO","STATUS","COD LINHA","DATA STATUS" };
		
		String str= "";

		int Linha = -2; // valor diferente do -1 predefinido no metodo returnID o

		// verificar se a estacao a editar existe e retorna a linha a editar
		boolean sair = true;
		do {
			System.out.println("Insira Cod. de Composição a editar:");
			str = teclado.nextLine();

			if (returnID(Matriz, str, 0) != -1) {
				Linha = returnID(Matriz, str, 0);
				listaRegistoPorID(arrComposicaoHeader, Matriz, str);
				msg("Está a editar o Registo " + str);
				sair = true;

			} else {
				msg("Registo Não Encontrado");
				sair = false;
			}
		} while (sair == false);
		

			// Validação campo tipo de status
				Matriz[Linha][4]= "SEM STATUS";
				escreveMatrizFicheiro(Matriz,fileComposicao);
	}
	
	
	

	public static void eliminarComposicao(String[][] Matriz) {
		lerFicheirosMatrizes();
		// menuHeader();
		msg("---- ELIMINAR COMPOSICAO ----");

		String arrCampos[] = new String[] { "Número de Série", "Tipo - [1] 1ªClasse, [2] 2ªClasse, [3] Bar [O] Outro", "Nº de Lugares","Fabricante", "Obs" };
		String str = "";
		int Linha = -2; // valor diferente do -1 predefinido no metodo returnID 0

		// verificar se a automotora a editar existe e retorna a linha a editar
		boolean sair = true;
		do {
			System.out.println("Insira Cod. de Composição a eliminar:");
			str = teclado.nextLine();

			if (returnID(Matriz, str, 0) != -1) {
				Linha = returnID(Matriz, str, 0);

				listaRegistoPorID(arrComposicaoHeader, Matriz, str);
				msg("Confirma a eliminar o Registo? [S/N] ");
				String aux = teclado.nextLine();
				if (aux.toLowerCase().equals("s")) {
					sair = true;
				} else {
					return;
				}

			} else {
				msg("Registo Não Encontrado");
				sair = false;
			}
		} while (sair == false);

		for (int i = 0; i < arrCampos.length; i++) { // Aqui começa no ID 1 para o utilizador não puder alterar cod. por
			// causa das tabelas filhos
			// Passa a vazio todos os campos
			Matriz[Linha][i] = "";
		}

		escreveMatrizFicheiro(Matriz, fileComposicao); // Confirmar a eliminacao do registo.
		
		//Eliminar registos filhos 
		msg("A eliminar associações da Composicoes a Automotoras e Carruagens");
		try {		
			msg(str);
		EliminarByID(arrCarruagensComposicao, fileCarruagensComposicao, str,1); // 1 é o index da coluna Cod_composição
		}catch (Exception e){
			msg("Erro " + e.getMessage());
		}
	}
	
		
	public static void editarAutomotoraComposicao(String Matriz[][]) {
		lerFicheirosMatrizes();
		// menuHeader();
		msg("---- ASSOCIAR AUTOMOTORA A COMPOSICAO ----");
	//  Campos--> { "COD COMP", "COD AUTOMOTORA","NOME", "DATACRIACAO","STATUS","COD LINHA","DATA STATUS" };
		
		String arrCampos[] = new String[] {"Cod. Composição", "Nome Composição", "Cod Automotora", "DATACRIACAO","Status da Composição","COD LINHA","DATA STATUS"};
		String str= "";

		int Linha = -2; // valor diferente do -1 predefinido no metodo returnID o

		// verificar se a estacao a editar existe e retorna a linha a editar
		boolean sair = true;
		do {
			System.out.println("Insira Cod. de Composição a Associar:");
			str = teclado.nextLine();

			if (returnID(Matriz, str, 0) != -1) {
				Linha = returnID(Matriz, str, 0);
				listaRegistoPorID(arrComposicaoHeader, Matriz, str);
				msg("Está a editar o Registo " + str);
				sair = true;

			} else {
				msg("Registo Não Encontrado");
				sair = false;
			}
		} while (sair == false);
		
		for (int i = 1; i < arrCampos.length; i++) {
			str="";
			
			// Validação do campo Numero de série - não deixa alterar cod compsição
	
			// Validação do campo Nome Composição
			
			
						// Validação do campo COD_ AUTOMOTORA Não e registado nesta fase insere valor vazio
						if (i == 2) {
							msg("Insira Automotora a Associar : ");
							str = teclado.nextLine();
							str = str.trim();
							
							str=str.replace(" ", "");  // Não permitir espaços no numero de serie COD
							if (str.equals("")) {
								msg("Valor nulo Inválido");
								i--;
							} else if (str.contains(sepChar)) {
								msg("Valor digitado inclui caracter inválido: " + sepChar);
								i--;
							} else if (verificaID(arrAutomotora,str,0) == false) { // verifica se este código de automotora existe.
								msg(arrCampos[i] + " não registado");
								i--;
							} else if (verificaID(arrComposicao,str,2) == true) { // verifica se este código de automotora existe.
								msg(arrCampos[i] + " já Associada a uma Composição");
								i--;
							} else {
								str = str.trim();
								Matriz[Linha][i]= str;
							}
							//não altera a associacao à automotora
							}

					

		} // fim do for
		escreveMatrizFicheiro(Matriz,fileComposicao);
	}
	
	
	public static void eliminarAutomotoraComposicao(String Matriz[][]) {
		lerFicheirosMatrizes();
		// menuHeader();
		msg("---- ELIMINAR AUTOMOTORA A COMPOSICAO ----");
	//  Campos--> { "COD COMP", "COD AUTOMOTORA","NOME", "DATACRIACAO","STATUS","COD LINHA","DATA STATUS" };
		
		String arrCampos[] = new String[] {"Cod. Composição", "Nome Composição", "Cod Automotora", "DATACRIACAO","Status da Composição","COD LINHA","DATA STATUS"};
		String str= "";

		int Linha = -2; // valor diferente do -1 predefinido no metodo returnID o

		// verificar se a estacao a editar existe e retorna a linha a editar
		boolean sair = true;
		do {
			System.out.println("Insira Cod. de Composição a Remover Associação:");
			str = teclado.nextLine();

			if (returnID(Matriz, str, 0) != -1) {
				Linha = returnID(Matriz, str, 0);
				listaRegistoPorID(arrComposicaoHeader, Matriz, str);
				msg("Está a editar o Registo " + str);
				sair = true;

			} else {
				msg("Registo Não Encontrado");
				sair = false;
			}
		} while (sair == false);
		
		for (int i = 1; i < arrCampos.length; i++) {
			str="";
			
			// Validação do campo Numero de série - não deixa alterar cod compsição
	
			// Validação do campo Nome Composição
						
						// Validação do campo COD_ AUTOMOTORA Não e registado nesta fase insere valor vazio
						if (i == 2) {
							Matriz[Linha][i]= "";
							msg("Associação Removida : ");
								
							//não altera a associacao à automotora
							}

		} // fim do for

		escreveMatrizFicheiro(Matriz,fileComposicao);
	
	}
	
	
	public static void adicionarCarruagensComposicao() {
		lerFicheirosMatrizes();
				
		msg("---- ASSOCIAR CARRUAGEM A UMA COMPOSICAO ----");
	     //  Campos--> { "COD ESTACAO", "COD LINHA" };
		
		String arrCampos[] = new String[] {"Cod. Carruagem","Cod. Composição"};
		String str, strCompleta = "";

		for (int i = 0; i < arrCampos.length; i++) {
			str="";
				msg("Insira " + arrCampos[i] + " : ");
				str = teclado.nextLine();
				str = str.trim();
			
			// Validação do campo COD Carruagem
			if (i == 0) {
			
				
				str=str.replace(" ", "");  // Não permitir espaços no numero de serie COD
				if (str.equals("")) {
					msg("Valor nulo Inválido");
					i--;
				} else if (str.contains(sepChar)) {
					msg("Valor digitado inclui caracter inválido: " + sepChar);
					i--;
				} else if (verificaID(arrCarruagem,str,0) == false) { // verifica se este código de carruagem já está criado.
					msg(arrCampos[i] + " não registado");
					i--;
				} else if (verificaID(arrCarruagensComposicao,str,0) == true) { // verifica se este código de carruagem já está criado nesta composição.
					msg(arrCampos[i] + " já associada a uma Composição, escolha outra Carruagem");
					i--;
				} else {
					str = str.trim();
					strCompleta += str + sepChar;
				}
			}
			
			// Validação do campo COD Composição
			if (i == 1) {

				str = str.replace(" ", ""); // Não permitir espaços no numero de serie COD
				if (str.equals("")) {
					msg("Valor nulo Inválido");
					i--;
				} else if (str.contains(sepChar)) {
					msg("Valor digitado inclui caracter inválido: " + sepChar);
					i--;
				} else if (verificaID(arrComposicao, str, 0) == false) { // verifica se este código de composição já está criado											// criado.
					msg(arrCampos[i] + " não registado");
					i--;
				} else {
					str = str.trim();
					strCompleta += str + sepChar;
				}
			}
			

			// Restantes Campos Podem existir outro campos estupidos no futuro
			if (i > 1) {
				str = str.replace(sepChar, "");
				str = str.trim();
				strCompleta += str + sepChar;
			}

		} // fim do for

		confirmaInserirRegisto(strCompleta,fileCarruagensComposicao,arrCarruagensComposicao);// Confirmar a inserção do registo.
	
	}
	
	
	
	public static void editarCarruagensComposicao(String Matriz[][]) {
		lerFicheirosMatrizes();
				
		msg("---- EDITAR ASSOCIAÇÃO CARRUAGEM A UMA COMPOSICAO ----");
	     //  Campos--> { "COD ESTACAO", "COD LINHA" };
		
		String arrCampos[] = new String[] {"Cod. Carruagem","Cod. Composição"};
		String str="";

		int Linha = -2; // valor diferente do -1 predefinido no metodo returnID o

		// verificar se a estacao a editar existe e retorna a linha a editar
		boolean sair = true;
		do {
			System.out.println("Insira Cod. de Carruagem Associada a editar:");
			str = teclado.nextLine();

			if (returnID(Matriz, str, 0) != -1) {
				Linha = returnID(Matriz, str, 0);
				listaRegistoPorID(arrCarruagensComposicaoHeader, Matriz, str);
				msg("Está a editar o Registo " + str);
				sair = true;

			} else {
				msg("Registo Não Encontrado");
				sair = false;
			}
		} while (sair == false);
		
		
		
		for (int i = 0; i < arrCampos.length; i++) {
			str="";
				msg("Insira " + arrCampos[i] + " : ");
				str = teclado.nextLine();
				str = str.trim();
			
			// Validação do campo COD Carruagem
			if (i == 0) {
			
				
				str=str.replace(" ", "");  // Não permitir espaços no numero de serie COD
				if (str.equals("")) {
					msg("Valor nulo Inválido");
					i--;
				} else if (str.contains(sepChar)) {
					msg("Valor digitado inclui caracter inválido: " + sepChar);
					i--;
				} else if (verificaID(arrCarruagem,str,0) == false) { // verifica se este código de carruagem já está criado.
					msg(arrCampos[i] + " não registado");
					i--;
				} else if (verificaID(arrCarruagensComposicao,str,0) == true) { // verifica se este código de carruagem já está criado nesta composição.
					msg(arrCampos[i] + " já associada a uma Composição, escolha outra Carruagem");
					i--;
				} else {
					str = str.trim();
					Matriz[Linha][i]= str;
				}
			}
			
			// Validação do campo COD Composição
			if (i == 1) {

				str = str.replace(" ", ""); // Não permitir espaços no numero de serie COD
				if (str.equals("")) {
					msg("Valor nulo Inválido");
					i--;
				} else if (str.contains(sepChar)) {
					msg("Valor digitado inclui caracter inválido: " + sepChar);
					i--;
				} else if (verificaID(arrComposicao, str, 0) == false) { // verifica se este código de composição já está criado											// criado.
					msg(arrCampos[i] + " não registado");
					i--;
				} else {
					str = str.trim();
					Matriz[Linha][i] = str;
				}
			}
			

			// Restantes Campos Podem existir outro campos estupidos no futuro
			if (i > 1) {
				str = str.replace(sepChar, "");
				str = str.trim();
				Matriz[Linha][i] = str;
			}

		} // fim do for

		escreveMatrizFicheiro(Matriz,fileComposicao);
	}
	
	
	
	public static void eliminarCarruagensComposicao(String Matriz[][]) {
		lerFicheirosMatrizes();
				
		msg("---- ELIMINAR ASSOCIAÇÃO CARRUAGEM A UMA COMPOSICAO ----");
	     //  Campos--> { "COD ESTACAO", "COD LINHA" };
		
		String str="";


		// verificar se a estacao a editar existe e retorna a linha a editar
		boolean sair = true;
		do {
			System.out.println("Insira Cod. de Carruagem Associada a Eliminar:");
			str = teclado.nextLine();

			if (verificaID(Matriz, str, 0) ==true) {
				listaRegistoPorID(arrCarruagensComposicaoHeader, Matriz, str);
				msg("Está a remover o Registo " + str);
				sair = true;

			} else {
				msg("Registo Não Encontrado");
				sair = false;
			}
		} while (sair == false);
		
		EliminarByID(Matriz,fileCarruagensComposicao,str,0);
		
	}
	
	
	
	public static void adicionarLinhaEstacao() {
		lerFicheirosMatrizes();
		// menuHeader();
		msg("---- ASSOCIAR ESTAÇÃO A UMA LINHA ----");
	     //  Campos--> { "COD ESTACAO", "COD LINHA" };
		
		String arrCampos[] = new String[] {"Cod. Estacao", "Cod. Linha"};
		String str, strCompleta = "";

		for (int i = 0; i < arrCampos.length; i++) {
			str="";
				msg("Insira " + arrCampos[i] + " : ");
				str = teclado.nextLine();
				str = str.trim();
			
			// Validação do campo COD Estacao
			if (i == 0) {
			
				
				str=str.replace(" ", "");  // Não permitir espaços no numero de serie COD
				if (str.equals("")) {
					msg("Valor nulo Inválido");
					i--;
				} else if (str.contains(sepChar)) {
					msg("Valor digitado inclui caracter inválido: " + sepChar);
					i--;
				} else if (verificaID(arrEstacao,str,0) == false) { // verifica se este código de carruagem já está criado.
					msg(arrCampos[i] + " não registado");
					i--;
				} else if (verificaID(arrLinhaEstacao,str,0) == true) { // verifica se este código de carruagem já está criado.
					msg(arrCampos[i] + " já associada a uma Linha, escolha outra Estação");
					i--;
				} else {
					str = str.trim();
					strCompleta += str + sepChar;
				}
			}
			
			// Validação do campo COD Estacao
			if (i == 1) {

				str = str.replace(" ", ""); // Não permitir espaços no numero de serie COD
				if (str.equals("")) {
					msg("Valor nulo Inválido");
					i--;
				} else if (str.contains(sepChar)) {
					msg("Valor digitado inclui caracter inválido: " + sepChar);
					i--;
				} else if (verificaID(arrLinha, str, 0) == false) { // verifica se este código de carruagem já está
																	// criado.
					msg(arrCampos[i] + " não registado");
					i--;
				} else {
					str = str.trim();
					strCompleta += str + sepChar;
				}
			}
			

			// Restantes Campos Podem existir outro campos estupidos no futuro
			if (i > 1) {
				str = str.replace(sepChar, "");
				str = str.trim();
				strCompleta += str + sepChar;
			}

		} // fim do for

		confirmaInserirRegisto(strCompleta,fileLinhaEstacao,arrLinhaEstacao);// Confirmar a inserção do registo.
	
	}
	
	
	//==============================  MÉTODOS AUXILIARES Á PESQUISA E EDIÇÃO E ADIÇÃO DE REGISTOS  ====================================
	
	public static void confirmaInserirRegisto(String strCompleta, File Ficheiro, String Matriz[][]) {

		String str = "";
		boolean sair;
		// Confirmar a inserção do registo.
		do {
			msg("");
			strCompleta = strCompleta.substring(0, strCompleta.length() - 1); // tira o ultimo ;
			msg(strCompleta);
			msg("Confirma Inserir Registo? [S]Sim [N]Não");
			str = teclado.next();

			if (str.toLowerCase().equals("s")) { // utilizador confirmou inserção do registo
				try {
					adicionarRegistoFicheiro(Ficheiro, strCompleta);
					lerFicheiroToMatriz(Ficheiro, Matriz, Matriz.length, Matriz[0].length);
				} catch (Exception e) {
					msg("Erro " + e.getMessage());
				}
			} else if (str.toLowerCase().equals("n")) {
				msg("Registo não inserido");
			} else {
				msg("Resposta não reconhecida");
			}

			sair = false;
			if (str.toLowerCase().equals("s"))
				sair = true;
			if (str.toLowerCase().equals("n"))
				sair = true;

		} while (sair == false);

		lerFicheirosMatrizes();
		pausa();

	}

	public static void confirmaEditarRegisto(String strCompleta, File Ficheiro, String Matriz[][], String ID) {

		String str = "";
		boolean sair;
		// Confirmar a inserção do registo.
		do {
			msg("");
			strCompleta = strCompleta.substring(0, strCompleta.length() - 1); // tira o ultimo ;
			msg(strCompleta);
			msg("Confirma Editar Registo? [S]Sim [N]Não");
			str = teclado.next();

			if (str.toLowerCase().equals("s")) { // utilizador confirmou inserção do registo
				try {
					editaRegistoFicheiro(Ficheiro, strCompleta, ID);
					lerFicheiroToMatriz(Ficheiro, Matriz, Matriz.length, Matriz[0].length);
				} catch (Exception e) {
					msg("Erro " + e.getMessage());
				}
			} else if (str.toLowerCase().equals("n")) {
				msg("Registo não inserido");
			} else {
				msg("Resposta não reconhecida");
			}

			sair = false;
			if (str.toLowerCase().equals("s"))
				sair = true;
			if (str.toLowerCase().equals("n"))
				sair = true;

		} while (sair == false);

		pausa();
	}

	public static boolean verificaID(String Matriz[][], String strPesquisa, int indiceMatriz) {

		try {
			if (Matriz[0][0] != (null)) {

				for (int i = 0; i < Matriz.length; i++) {
					if (Matriz[i][indiceMatriz] != null) {
						if (Matriz[i][indiceMatriz].toLowerCase().equals(strPesquisa.toLowerCase())) {
							return true; // valor já existe no array
						}
					} else {
						return false;
					} // já esta nos valores nulos retorna false
				}
			}
			return false;
		} catch (Exception e) {
			msg("ERRO AO VERIFICAR ID " + e.getCause());
			return true; // Não pode ser verificado devido a erro indica que já existe para não existirem
							// duplicação de registos
		}

	}

	public static int returnID(String Matriz[][], String strPesquisa, int indiceMatriz) {

		try {
			if (Matriz[0][0] != (null)) {

				for (int l = 0; l < Matriz.length; l++) {
					if (Matriz[l][indiceMatriz] != null) {
						if (Matriz[l][indiceMatriz].toLowerCase().equals(strPesquisa.toLowerCase())) {
							return l; // valor já existe no array
						}
					} else {
						return -1;
					} // já esta nos valores nulos retorna false
				}
			}
			return -1;
		} catch (Exception e) {
			msg("ERRO AO VERIFICAR ID " + e.getCause());
			return -1; // Não pode ser verificado devido a erro indica que já existe para não existirem
						// duplicação de registos
		}

	}

	public static void listaRegistoPorID(String Header[], String Matriz[][], String ID) {

		ID = ID.toLowerCase();
		int imprimeHeader = 0;

		try {
			if (Matriz[0][0] != (null)) {
				for (int l = 0; l < Matriz.length; l++) {
					if (Matriz[l][0] != null) {
						if (Matriz[l][0].toLowerCase().equals(ID)) {
							imprimeHeader++;
							listarRegistoPesquisado(Header, Matriz, l, imprimeHeader); // valor encontrado Imprime
																						// registo no ecrÃ
						}
					} else {
						break;
					} // já esta nos valores nulos sai do for, nada a pesquisar
				}
			}

			msg("");
			msg("Total de Registos Encontrados: " + imprimeHeader);

		} catch (Exception e) {
			msg("ERRO PESQUISA " + e.getMessage());

		}

	}

	public static void EliminarByID(String[][] Matriz, File ficheiro, String ID, int Indice) {
		if (Matriz[0][0] != (null)) { // quer dizer que a matriz não está nula
			for (int l = 0; l < Matriz.length; l++) {
				if (Matriz[l][0] != null) {
					if (Matriz[l][Indice].toLowerCase().equals(ID)) { // procura valor do ID ou COD para branquear todo
																		// o registo
						for (int c = 0; c < Matriz[0].length; c++) {
							Matriz[l][c] = ""; // cod. por
						}
					}
				}
			}
		}
		escreveMatrizFicheiro(Matriz, ficheiro); // Confirmar a inserção do registo.

	}
	
	//===========================================PESQUISAS NAS MATRIZES=========================================
	
	static void pesquisaAutomotoraCarruagem() {
		msg("Digite Valor a Pesquisar");
		String strPesquisar = teclado.next();

		msg("-------------------------PESQUISA DE AUTOMOTORAS---------------------------");
		pesquisaMatriz(arrAutomotoraHeader, arrAutomotora, strPesquisar); //pesquisar automotoras
		
		msg("-------------------------PESQUISA DE CARRUAGENS----------------------------");
		pesquisaMatriz(arrCarruagemHeader,arrCarruagem, strPesquisar);  //Pesquisar carruagens

	}
	
	
	public static void pesquisaMatriz(String Header[], String Matriz[][],String strPesquisa) {
		
		strPesquisa= strPesquisa.toLowerCase();
		int imprimeHeader=0;
		
		try {
			if (Matriz[0][0]!=(null)) {
	  		for (int l = 0; l < Matriz.length; l++) {
     			if (Matriz[l][0]!=null) {
     				for (int c = 0; c < Matriz[0].length; c++) {	
     				if (Matriz[l][c].toLowerCase().startsWith(strPesquisa)) {
    					 imprimeHeader++;   					
     					listarRegistoPesquisado(Header,Matriz, l, imprimeHeader); // valor encontrado Imprime registo no ecrÃ
     				break; // sai do for se a string já tiver sido encontrada uma vez
     				}
     				}
     			}else {break;}	 // já esta nos valores nulos sai do for, nada a pesquisar
			}
			}
			
			msg ("");
			msg ("Total de Registos Encontrados: " + imprimeHeader);
			
		} catch (Exception e) {
			msg("ERRO PESQUISA " + e.getMessage());
		}
    pausa();

		
	}

	
public static void pesquisaMatrizByID(String Header[], String Matriz[][],String strPesquisa, int Indice) {
		
		strPesquisa= strPesquisa.toLowerCase();
		int imprimeHeader=0;
		
		try {
			if (Matriz[0][0]!=(null)) {
	  		for (int l = 0; l < Matriz.length; l++) {
     			if (Matriz[l][0]!=null) {
     				for (int c = 0; c < Matriz[0].length; c++) {	
     				if (Matriz[l][Indice].toLowerCase().equals(strPesquisa)) {
    					 imprimeHeader++;   					
     					listarRegistoPesquisado(Header,Matriz, l, imprimeHeader); // valor encontrado Imprime registo no ecrÃ
     					break; // sai do for se a string já tiver sido encontrada uma vez
     				}
     				}
     			}else {break;}	 // já esta nos valores nulos sai do for, nada a pesquisar
			}
			}
			
			msg ("");
			msg ("Total de Registos Encontrados: " + imprimeHeader);
			
		} catch (Exception e) {
			msg("ERRO PESQUISA " + e.getMessage());
			
		}
    pausa();

		
	}
	
	
	public static void listarRegistoPesquisado (String Header[], String Matriz[][], int l, int imprimeHeader) {  //l para passar o id dalina selecionada

		try {
			if (imprimeHeader==1) {     // só imprime header na primeiravez que encontra registo
			System.out.println();
				for (int i=0; i<Header.length;i++) {
					System.out.printf("|%s    \t",Header[i]);     // desenha o cabeçalho da grelha
				}
				System.out.println();
				for (int i=0; i<Header.length;i++) {
					System.out.printf("|%s    \t","----------");   // desenha a linha separadora do cabeçalho 
				}
			}
				System.out.println();
			
					for (int c = 0; c < Matriz[l].length; c++) {
					if (Matriz[l][0] != null) {
						System.out.printf("|%s    \t", Matriz[l][c]);     // imprime a linha encontrada
					}
				}
							
		} catch (Exception e) {
			msg("ERRO--> " + e.getMessage());

		}
	}
	
	
	

public static void escreveMatrizFicheiro(String Matriz[][], File ficheiro) {
		
		
		try {
			
			String linha ="";
			BufferedWriter bf = new BufferedWriter(new FileWriter(ficheiro.getAbsoluteFile(),true));  //este true é para abrir com autorização de escrita
	  			limpaFicheiro(ficheiro);  // apaga o ficheiro original e cria outro com o mesmo nome
	  			
	  			
			if (Matriz[0][0]!=(null)) {   // quer dizer que a matriz não está 
				for (int l = 0; l < Matriz.length; l++) {
					if (Matriz[l][0] != null) { // já esta nos valores nulos da matriz
						if (Matriz[l][0] != "") { // Se o cod está apagado o objectivo é eliminar a linha do ficheiro não escreve no ficheiro
							for (int c = 0; c < Matriz[0].length; c++) {
								linha += Matriz[l][c] + sepChar;
							}
							linha = linha.substring(0, linha.length() - 1); // remove o ultimo ;
							bf.write(linha);
							bf.newLine();
							linha = "";
						}
					} else {
						break;
					} // já esta nos valores nulos sai do for, nada a pesquisar
				}
	   				   //escrever numa nova linha
	  			
			}
			bf.close();     // fechar o ficheiro senão fica bloqueado para escrita.	
			msg("Tarefa efectuada com sucesso");
			lerFicheirosMatrizes();
			} catch (IOException e) {
	  				System.out.println("Erro na aplicação! " + e.getLocalizedMessage());
	  				e.printStackTrace();
	  				  
		    } catch (Exception ex) {
			msg("ERRO ESCREVER MATRIZ NO FICHEIRO " + ex.getMessage());
			
		}

		
	}

		
	//=======================================LISTAGEM DAS MATRIZES===================================================
	
	
	static void listaAutomotoraCarruagem() {		
            listaAutomotora();
	    	listaCarruagem ();
			
		pausa();
		
	}
	
	static void listaAutomotoraCarruagemLivres() {		
        listaAutomotoraLivres();
    	listaCarruagemLivres ();
		
	pausa();
	
}
	
	static void listaAutomotoraCarruagemOcupadas() {		
        listaAutomotoraOcupadas();
    	listaCarruagemOcupadas ();
		
	pausa();
	
}
	
	static void listaAutomotoraCarruagemOcupadasCirculacao() {		
        listaAutomotoraOcupadasCirculacao();
    	listaCarruagemOcupadasCirculacao ();
		
	pausa();
	
}
	
	static void listaAutomotoraCarruagemOcupadasParadas() {		
        listaAutomotoraOcupadasParadas();
    	listaCarruagemOcupadasParadas ();
		
	pausa();
	
}
	
	static void listaAutomotoraCarruagemOcupadasFDS() {		
        listaAutomotoraOcupadasFDS();
    	listaCarruagemOcupadasFDS ();
		
	pausa();
	
}
	
	
	
	
	public static void listaAutomotoraLivres() {
		
		
		lerFicheiroToMatriz(fileAutomotora, arrAutomotora,arrAutomotora.length,arrAutomotora[0].length);
		msg("");
		msg("-----------------------LISTA DE AUTOMOTORAS LIVRES-----------------------");
		listarMatrizAutomotorasLivres(arrAutomotoraHeader,arrAutomotora,arrAutomotora.length,arrAutomotora[0].length);
		msg("-------------------------------------------------__----------------------");
	}
	
    public static void listaCarruagemLivres() {
		
		lerFicheiroToMatriz(fileCarruagem, arrCarruagem,arrCarruagem.length,arrCarruagem[0].length);
		msg("");
		msg("-------------------------LISTA DE CARRUAGENS LIVRES---------------------------");
		listarMatrizCarruagensLivres(arrCarruagemHeader,arrCarruagem,arrCarruagem.length,arrCarruagem[0].length);
		msg("------------------------------------------------------------------------------");
		
	}
    
    public static void listaAutomotoraOcupadas() {
		
		
		lerFicheiroToMatriz(fileAutomotora, arrAutomotora,arrAutomotora.length,arrAutomotora[0].length);
		msg("");
		msg("-----------------------LISTA DE AUTOMOTORAS OCUPADAS-----------------------");
		listarMatrizAutomotorasOcupadas(arrAutomotoraHeader,arrAutomotora,arrAutomotora.length,arrAutomotora[0].length);
		msg("---------------------------------------------------------------------------");
	}
	
 public static void listaCarruagemOcupadas() {
		
		lerFicheiroToMatriz(fileCarruagem, arrCarruagem,arrCarruagem.length,arrCarruagem[0].length);
		msg("");
		msg("-------------------------LISTA DE CARRUAGENS OCUPADAS---------------------------");
		listarMatrizCarruagensOcupadas(arrCarruagemHeader,arrCarruagem,arrCarruagem.length,arrCarruagem[0].length);
		msg("--------------------------------------------------------------------------------");
		
	}
 
 
 public static void listaAutomotoraOcupadasCirculacao() {
		lerFicheiroToMatriz(fileAutomotora, arrAutomotora,arrAutomotora.length,arrAutomotora[0].length);
		msg("");
		msg("-----------------------LISTA DE AUTOMOTORAS CIRCULACAO-----------------------");
		listarMatrizAutomotorasOcupadasCirculacao(arrAutomotoraHeader,arrAutomotora,arrAutomotora.length,arrAutomotora[0].length);
		msg("-----------------------------------------------------------------------------");
	}
	
public static void listaCarruagemOcupadasCirculacao() {
		
		lerFicheiroToMatriz(fileCarruagem, arrCarruagem,arrCarruagem.length,arrCarruagem[0].length);
		msg("");
		msg("-------------------------LISTA DE CARRUAGENS EM CIRCULACAO---------------------------");
		listarMatrizCarruagensOcupadasCirculacao(arrCarruagemHeader,arrCarruagem,arrCarruagem.length,arrCarruagem[0].length);
		msg("-------------------------------------------------------------------------------------");
		
	}

public static void listaAutomotoraOcupadasParadas() {
	lerFicheiroToMatriz(fileAutomotora, arrAutomotora,arrAutomotora.length,arrAutomotora[0].length);
	msg("");
	msg("-----------------------LISTA DE AUTOMOTORAS CIRCULACAO-----------------------");
	listarMatrizAutomotorasOcupadasParadas(arrAutomotoraHeader,arrAutomotora,arrAutomotora.length,arrAutomotora[0].length);
	msg("-----------------------------------------------------------------------------");
}

public static void listaCarruagemOcupadasParadas() {
	
	lerFicheiroToMatriz(fileCarruagem, arrCarruagem,arrCarruagem.length,arrCarruagem[0].length);
	msg("");
	msg("-------------------------LISTA DE CARRUAGENS EM CIRCULACAO---------------------------");
	//listarMatrizCarruagensOcupadasParadas(arrCarruagemHeader,arrCarruagem,arrCarruagem.length,arrCarruagem[0].length);
	msg("-------------------------------------------------------------------------------------");
	
}
 

public static void listaAutomotoraOcupadasFDS() {
	lerFicheiroToMatriz(fileAutomotora, arrAutomotora,arrAutomotora.length,arrAutomotora[0].length);
	msg("");
	msg("-----------------------LISTA DE AUTOMOTORAS CIRCULACAO-----------------------");
	listarMatrizAutomotorasOcupadasFDS(arrAutomotoraHeader,arrAutomotora,arrAutomotora.length,arrAutomotora[0].length);
	msg("-----------------------------------------------------------------------------");
}

public static void listaCarruagemOcupadasFDS() {
	
	lerFicheiroToMatriz(fileCarruagem, arrCarruagem,arrCarruagem.length,arrCarruagem[0].length);
	msg("");
	msg("-------------------------LISTA DE CARRUAGENS EM CIRCULACAO---------------------------");
	//listarMatrizCarruagensOcupadasFDS(arrCarruagemHeader,arrCarruagem,arrCarruagem.length,arrCarruagem[0].length);
	msg("-------------------------------------------------------------------------------------");
	
}
 

public static void listaCarruagemOcupadasLugares() {
	
	lerFicheiroToMatriz(fileCarruagem, arrCarruagem,arrCarruagem.length,arrCarruagem[0].length);
	msg("");
	msg("-------------------------TOTAL DE LUGARES EM COMPOSIÇÕES----------------------------");
	listarMatrizCarruagensOcupadasLugares(arrCarruagemHeader,arrCarruagem,arrCarruagem.length,arrCarruagem[0].length);
	msg("------------------------------------------------------------------------------------");
	
	pausa();
	
	
}
 	
	public static void listaAutomotora() {
		
	
		lerFicheiroToMatriz(fileAutomotora, arrAutomotora,arrAutomotora.length,arrAutomotora[0].length);
		msg("");
		msg("-----------------------LISTA DE AUTOMOTORAS----------------------------");
		listarMatriz(arrAutomotoraHeader,arrAutomotora,arrAutomotora.length,arrAutomotora[0].length);
		msg("-----------------------------------------------------------------------");
	}
	
	
    public static void listaCarruagem() {
		
		lerFicheiroToMatriz(fileCarruagem, arrCarruagem,arrCarruagem.length,arrCarruagem[0].length);
		msg("");
		msg("-------------------------LISTA DE CARRUAGENS---------------------------");
		listarMatriz(arrCarruagemHeader,arrCarruagem,arrCarruagem.length,arrCarruagem[0].length);
		msg("-----------------------------------------------------------------------");
		
	}
	
    public static void listaAutomotoraCarruagemEstaleiro(String Matriz[][]) {
		
		lerFicheiroToMatriz(fileEstaleiro, arrEstaleiro,arrEstaleiro.length,arrEstaleiro[0].length);
		msg("");
		msg("-----------------------LISTA DE AUTOMOTORAS----------------------------");
		listarMatriz(arrEstaleiroHeader,arrEstaleiro,arrEstaleiro.length,arrEstaleiro[0].length);
		msg("-----------------------------------------------------------------------");
	}	
    
    
public static void listaLinha() {
		
		lerFicheiroToMatriz(fileLinha, arrLinha,arrLinha.length,arrLinha[0].length);
		msg("");
		msg("-------------------------LISTA DE LINHAS---------------------------");
		listarMatriz(arrLinhaHeader,arrLinha,arrLinha.length,arrLinha[0].length);
		msg("-----------------------------------------------------------------------");
		pausa();
	}

public static void listaEstacao() {
	
	
	lerFicheiroToMatriz(fileEstacao, arrEstacao,arrEstacao.length,arrEstacao[0].length);
	msg("");
	msg("-------------------------LISTA DE ESTAÇÕES---------------------------");
	listarMatriz(arrEstacaoHeader,arrEstacao,arrEstacao.length,arrEstacao[0].length);
	msg("-----------------------------------------------------------------------");
	pausa();
	
}

public static void listaComposicao() {
	
	
	lerFicheiroToMatriz(fileComposicao, arrComposicao,arrComposicao.length,arrComposicao[0].length);
	msg("");
	msg("-------------------------LISTA DE COMPOSIÇÕES---------------------------");
	listarMatriz(arrComposicaoHeader,arrComposicao,arrComposicao.length,arrComposicao[0].length);
	msg("-----------------------------------------------------------------------");
	pausa();
	
}


    
static void pausa() {
	
	for(int i = 0; i < 2; i++) {
		if (i==0) msg(" Prima enter para continuar: "); //nesta não percebi pq só funcionou assim
		teclado.nextLine();
	}
}

    
	
	public static void lerFicheiroToMatriz(File ficheiro, String Matriz[][], int tamL, int tamC) {
		String linha;
			int l=0;
		
			try {	
				BufferedReader br = new BufferedReader(new FileReader(ficheiro));
			while ((linha = br.readLine())!=null) {
				//System.out.println("linha " + linha);
				//Matriz[l]= linha.split(sepChar);
				Matriz[l]=linha.split(sepChar, tamC); // obriga a inicializar todos os buracos da linha do array evita os erros NULL 
				l++;
			}
			br.close(); // fecha o Buffer Reader depois de nao haver linhas
		} catch (IOException e) {
			System.out.println("Erro na aplicação!");
			e.printStackTrace();
		}
		
		
		
	}
	
	public static void listarMatriz (String Header[], String Matriz[][], int tamL, int tamC) {

		try {
			if (Matriz[0][0]==(null) || Matriz[0][0].equals("")) {
				msg("SEM REGISTOS A APRESENTAR");
				tamL = 0;
			}else {
				for (int i=0; i<Header.length;i++) {
					System.out.printf("|%s    \t",Header[i]);
				}
				System.out.println();
				for (int i=0; i<Header.length;i++) {
					System.out.printf("|%s    \t","----------");
				}
			}
			
			for (int l = 0; l < tamL; l++) {
				System.out.println(); //mudar de linha
				for (int c = 0; c < tamC; c++) {
					if (Matriz[l][0] != null) {
						System.out.printf("|%s    \t", Matriz[l][c]);
					
					}else {tamL=0;}  //Termina o ciclo for das linhas caso o S/N seja vazio
				}
				
			}
		} catch (Exception e) {
			msg("ERRO--> " + e.getMessage());

		}
	}
	
	
		
	public static void listarMatrizbyID (String Header[], String Matriz[][], int tamL, int tamC, String ID) {

		try {
			if (Matriz[0][0]==(null) || Matriz[0][0].equals("")) {
				msg("SEM REGISTOS A APRESENTAR");
				tamL = 0;
			}else {
				for (int i=0; i<Header.length;i++) {
					System.out.printf("|%s    \t",Header[i]);
				}
				System.out.println();
				for (int i=0; i<Header.length;i++) {
					System.out.printf("|%s    \t","----------");
				}
			}
			
			for (int l = 0; l < tamL; l++) {
				System.out.println(); //mudar de linha
				for (int c = 0; c < tamC; c++) {
					if (Matriz[l][0] != null) {
						if (Matriz[l][0].toLowerCase().equals(ID)) {
						System.out.printf("|%s    \t", Matriz[l][c]);
					}
					}else {tamL=0;}  //Termina o ciclo for das linhas caso o S/N seja vazio
				}
				
			}
		} catch (Exception e) {
			msg("ERRO--> " + e.getMessage());

		}
	}
	
	
	public static void listarMatrizAutomotorasLivres (String Header[], String Matriz[][], int tamL, int tamC) {

		try {
			if (Matriz[0][0]==(null) || Matriz[0][0].equals("")) {
				msg("SEM REGISTOS A APRESENTAR");
				tamL = 0;
			}else {
				for (int i=0; i<Header.length;i++) {
					System.out.printf("|%s    \t",Header[i]);
				}
				System.out.println();
				for (int i=0; i<Header.length;i++) {
					System.out.printf("|%s    \t","----------");
				}
			}
			
			for (int l = 0; l < tamL; l++) {
				System.out.println(); //mudar de linha
				for (int c = 0; c < tamC; c++) {
					if (Matriz[l][0] != null) {	
						if (verificaID(arrComposicao,Matriz[l][0],2) == false) { // Lista se não está na BD
							System.out.printf("|%s    \t", Matriz[l][c]);
						}					
					}else {tamL=0;}  //Termina o ciclo for das linhas caso o S/N seja vazio
				}
				
			}
		} catch (Exception e) {
			msg("ERRO--> " + e.getMessage());

		}
	}
	
	public static void listarMatrizAutomotorasOcupadas (String Header[], String Matriz[][], int tamL, int tamC) {

		try {
			if (Matriz[0][0]==(null) || Matriz[0][0].equals("")) {
				msg("SEM REGISTOS A APRESENTAR");
				tamL = 0;
			}else {
				for (int i=0; i<Header.length;i++) {
					System.out.printf("|%s    \t",Header[i]);
				}
				System.out.println();
				for (int i=0; i<Header.length;i++) {
					System.out.printf("|%s    \t","----------");
				}
			}
			
			for (int l = 0; l < tamL; l++) {
				System.out.println(); //mudar de linha
				for (int c = 0; c < tamC; c++) {
					if (Matriz[l][0] != null) {	
						if (verificaID(arrComposicao,Matriz[l][0],2) == true) { // Lista se não está na BD
							System.out.printf("|%s    \t", Matriz[l][c]);
						}					
					}else {tamL=0;}  //Termina o ciclo for das linhas caso o S/N seja vazio
				}
				
			}
		} catch (Exception e) {
			msg("ERRO--> " + e.getMessage());

		}
	}
	
	public static void listarMatrizAutomotorasOcupadasCirculacao (String Header[], String Matriz[][], int tamL, int tamC) {

		try {
			if (Matriz[0][0]==(null) || Matriz[0][0].equals("")) {
				msg("SEM REGISTOS A APRESENTAR");
				tamL = 0;
			}else {
				for (int i=0; i<Header.length;i++) {
					System.out.printf("|%s    \t",Header[i]);
				}
				System.out.println();
				for (int i=0; i<Header.length;i++) {
					System.out.printf("|%s    \t","----------");
				}
			}
			
			for (int l = 0; l < tamL; l++) {
				System.out.println(); //mudar de linha
				for (int c = 0; c < tamC; c++) {
					if (Matriz[l][0] != null) {	
						if ((verificaID(arrComposicao,Matriz[l][0],2) == true) && (verificaID(arrComposicao,"circulacao",4) == true)) { // Está na tabela composicoes e a composicão está em circulação
							System.out.printf("|%s    \t", Matriz[l][c]);
						}					
					}else {tamL=0;}  //Termina o ciclo for das linhas caso o S/N seja vazio
				}
				
			}
		} catch (Exception e) {
			msg("ERRO--> " + e.getMessage());

		}
	}
	
	public static void listarMatrizAutomotorasOcupadasParadas (String Header[], String Matriz[][], int tamL, int tamC) {

		try {
			if (Matriz[0][0]==(null) || Matriz[0][0].equals("")) {
				msg("SEM REGISTOS A APRESENTAR");
				tamL = 0;
			}else {
				for (int i=0; i<Header.length;i++) {
					System.out.printf("|%s    \t",Header[i]);
				}
				System.out.println();
				for (int i=0; i<Header.length;i++) {
					System.out.printf("|%s    \t","----------");
				}
			}
			
			for (int l = 0; l < tamL; l++) {
				System.out.println(); //mudar de linha
				for (int c = 0; c < tamC; c++) {
					if (Matriz[l][0] != null) {	
						if ((verificaID(arrComposicao,Matriz[l][0],2) == true) && (verificaID(arrComposicao,"circulacao",4) == false)) { // Está na tabela composicoes e a composicão está em circulação
							System.out.printf("|%s    \t", Matriz[l][c]);
						}					
					}else {tamL=0;}  //Termina o ciclo for das linhas caso o S/N seja vazio
				}
				
			}
		} catch (Exception e) {
			msg("ERRO--> " + e.getMessage());

		}
	}
	
	public static void listarMatrizAutomotorasOcupadasFDS (String Header[], String Matriz[][], int tamL, int tamC) {

		try {
			if (Matriz[0][0]==(null) || Matriz[0][0].equals("")) {
				msg("SEM REGISTOS A APRESENTAR");
				tamL = 0;
			}else {
				for (int i=0; i<Header.length;i++) {
					System.out.printf("|%s    \t",Header[i]);
				}
				System.out.println();
				for (int i=0; i<Header.length;i++) {
					System.out.printf("|%s    \t","----------");
				}
			}
			
			for (int l = 0; l < tamL; l++) {
				System.out.println(); //mudar de linha
				for (int c = 0; c < tamC; c++) {
					if (Matriz[l][0] != null) {	
						if ((verificaID(arrComposicao,Matriz[l][0],2) == true) && (verificaID(arrComposicao,"paragem fds",4) == true)) { // Está na tabela composicoes e a composicão está em circulação
							System.out.printf("|%s    \t", Matriz[l][c]);
						}					
					}else {tamL=0;}  //Termina o ciclo for das linhas caso o S/N seja vazio
				}
				
			}
		} catch (Exception e) {
			msg("ERRO--> " + e.getMessage());

		}
	}
	
	
	
	public static void listarMatrizCarruagensLivres (String Header[], String Matriz[][], int tamL, int tamC) {

		try {
			if (Matriz[0][0]==(null) || Matriz[0][0].equals("")) {
				msg("SEM REGISTOS A APRESENTAR");
				tamL = 0;
			}else {
				for (int i=0; i<Header.length;i++) {
					System.out.printf("|%s    \t",Header[i]);
				}
				System.out.println();
				for (int i=0; i<Header.length;i++) {
					System.out.printf("|%s    \t","----------");
				}
			}
			
			for (int l = 0; l < tamL; l++) {
				System.out.println(); //mudar de linha
				for (int c = 0; c < tamC; c++) {
					if (Matriz[l][0] != null) {	
						if (verificaID(arrCarruagensComposicao,Matriz[l][0],0) == false) { // Lista se não está na BD
							System.out.printf("|%s    \t", Matriz[l][c]);
						}					
					}else {tamL=0;}  //Termina o ciclo for das linhas caso o S/N seja vazio
				}
				
			}
		} catch (Exception e) {
			msg("ERRO--> " + e.getMessage());

		}
	}
	
	public static void listarMatrizCarruagensOcupadas (String Header[], String Matriz[][], int tamL, int tamC) {

		try {
			if (Matriz[0][0]==(null) || Matriz[0][0].equals("")) {
				msg("SEM REGISTOS A APRESENTAR");
				tamL = 0;
			}else {
				for (int i=0; i<Header.length;i++) {
					System.out.printf("|%s    \t",Header[i]);
				}
				System.out.println();
				for (int i=0; i<Header.length;i++) {
					System.out.printf("|%s    \t","----------");
				}
			}
			
			for (int l = 0; l < tamL; l++) {
				System.out.println(); //mudar de linha
				for (int c = 0; c < tamC; c++) {
					if (Matriz[l][0] != null) {	
						if (verificaID(arrCarruagensComposicao,Matriz[l][0],0) == true) { // Lista se não está na BD
							System.out.printf("|%s    \t", Matriz[l][c]);
						}					
					}else {tamL=0;}  //Termina o ciclo for das linhas caso o S/N seja vazio
				}
				
			}
		} catch (Exception e) {
			msg("ERRO--> " + e.getMessage());

		}
	}
	
	
	
	public static void listarMatrizCarruagensOcupadasCirculacao (String Header[], String Matriz[][], int tamL, int tamC) {

		try {
			if (Matriz[0][0]==(null) || Matriz[0][0].equals("")) {
				msg("SEM REGISTOS A APRESENTAR");
				tamL = 0;
			}else {
				for (int i=0; i<Header.length;i++) {
					System.out.printf("|%s    \t",Header[i]);
				}
				System.out.println();
				for (int i=0; i<Header.length;i++) {
					System.out.printf("|%s    \t","----------");
				}
			}
			
			for (int l = 0; l < tamL; l++) {
				System.out.println(); //mudar de linha
				for (int c = 0; c < tamC; c++) {
					if (Matriz[l][0] != null) {	
						if ((verificaID(arrCarruagensComposicao,Matriz[l][0],0) == true) && ((verificaID(arrCarruagensComposicao,Matriz[l][0],0) == true ))) { // Lista se não está na BD
							System.out.printf("|%s    \t", Matriz[l][c]);
						}					
					}else {tamL=0;}  //Termina o ciclo for das linhas caso o S/N seja vazio
				}
				
			}
		} catch (Exception e) {
			msg("ERRO--> " + e.getMessage());

		}
	}
	
	
	public static void listarMatrizCarruagensOcupadasLugares (String Header[], String Matriz[][], int tamL, int tamC) {
		int Lugares=0;

		try {			
			for (int l = 0; l < tamL; l++) {
				for (int c = 0; c < tamC; c++) {
					if (Matriz[l][0] != null) {	
						if (verificaID(arrCarruagensComposicao,Matriz[l][0],0) == true) { // Lista se não está na BD
							Lugares+=Integer.parseInt(Matriz[l][2]);
						}					
					}else {tamL=0;}  //Termina o ciclo for das linhas caso o S/N seja vazio
				}
				
			}
			msg("Total de Lugares --> " + Lugares);
		} catch (Exception e) {
			msg("ERRO--> " + e.getMessage());
		}
	
	}
	
	
	public static void listarMatrizCarruagensOcupadasParadas (String Header[], String Matriz[][], int tamL, int tamC) {

		try {
			if (Matriz[0][0]==(null) || Matriz[0][0].equals("")) {
				msg("SEM REGISTOS A APRESENTAR");
				tamL = 0;
			}else {
				for (int i=0; i<Header.length;i++) {
					System.out.printf("|%s    \t",Header[i]);
				}
				System.out.println();
				for (int i=0; i<Header.length;i++) {
					System.out.printf("|%s    \t","----------");
				}
			}
			
			for (int l = 0; l < tamL; l++) {
				System.out.println(); //mudar de linha
				for (int c = 0; c < tamC; c++) {
					if (Matriz[l][0] != null) {	
						if ((verificaID(arrCarruagensComposicao,Matriz[l][0],0) == true) && ((verificaID(arrCarruagensComposicao,Matriz[l][0],0) == true ))) { // Lista se não está na BD
							System.out.printf("|%s    \t", Matriz[l][c]);
						}					
					}else {tamL=0;}  //Termina o ciclo for das linhas caso o S/N seja vazio
				}
				
			}
		} catch (Exception e) {
			msg("ERRO--> " + e.getMessage());

		}
	}
	
	public static void listarMatrizCarruagensOcupadasFDS (String Header[], String Matriz[][], int tamL, int tamC) {

		try {
			if (Matriz[0][0]==(null) || Matriz[0][0].equals("")) {
				msg("SEM REGISTOS A APRESENTAR");
				tamL = 0;
			}else {
				for (int i=0; i<Header.length;i++) {
					System.out.printf("|%s    \t",Header[i]);
				}
				System.out.println();
				for (int i=0; i<Header.length;i++) {
					System.out.printf("|%s    \t","----------");
				}
			}
			
			for (int l = 0; l < tamL; l++) {
				System.out.println(); //mudar de linha
				for (int c = 0; c < tamC; c++) {
					if (Matriz[l][0] != null) {	
						if ((verificaID(arrCarruagensComposicao,Matriz[l][0],0) == true) && ((verificaID(arrCarruagensComposicao,Matriz[l][0],0) == true ))) { // Lista se não está na BD
							System.out.printf("|%s    \t", Matriz[l][c]);
						}					
					}else {tamL=0;}  //Termina o ciclo for das linhas caso o S/N seja vazio
				}
				
			}
		} catch (Exception e) {
			msg("ERRO--> " + e.getMessage());

		}
	}
	
	
	public static void adicionarRegistoFicheiro(File ficheiro, String registo) {
		try {
			BufferedWriter bf = new BufferedWriter(new FileWriter(ficheiro.getAbsoluteFile(),true));  //este true é para abrir com autorização de escrita
			bf.write(registo);
			bf.newLine();   //escrever numa nova linha
			bf.close();     // fechar o ficheiro senão fica bloqueado para escrita.
			msg("Registo Inserido com sucesso");
		} catch (IOException e) {
			System.out.println("Erro ao escrever registo em!" + ficheiro);
			e.printStackTrace();
		}
	}
	
	
	public static void editaRegistoFicheiro(File ficheiro, String registo, String ID)
	{		
		try {
			
			ID=ID.toLowerCase()+sepChar;  // o ID da linha mais o caracter ; separador
			String linha;
			
			BufferedReader br = new BufferedReader(new FileReader(ficheiro));
			BufferedWriter bf = new BufferedWriter(new FileWriter(ficheiro.getAbsoluteFile(),true));  //este true é para abrir com autorização de escrita
			
			while ((linha = br.readLine())!=null) {
				
				 String repl = linha.replaceAll(ID+"*",registo);
			        bf.write(repl);
			        bf.newLine();
				bf.close();
		
			}
			br.close();
		} catch (IOException e) {
			System.out.println("Erro na aplicação!");
			e.printStackTrace();
		}
	}
	
	
	
	
		
		public static void backupFicheiros() {
			
			for (int i=0; i<FILENAME.length; i++) {
				File ficheiro = new File(FILENAME[i]);
				if (ficheiro.exists()) {  // se existe faz backup
					try {
						String linha;
						File ficheiroBack =  new File("Bak" + ficheiro.toString());
						ficheiroBack.createNewFile();
						msg(" A efectuar backup... Ficheiro " + ficheiro.toString() );
						
						BufferedReader br = new BufferedReader(new FileReader(ficheiro));
						BufferedWriter bf = new BufferedWriter(new FileWriter(ficheiroBack.getAbsoluteFile(),true));  //este true é para abrir com autorização de escrita
						
						while ((linha = br.readLine())!=null) {
							    bf.write(linha);
						        bf.newLine();					
						}
						br.close();
						bf.close();
					} catch (IOException e) {
						System.out.println("Erro na aplicação!");
						e.printStackTrace();
					}
					
				
			}else {msg("Ficheiro Não existe");}
		}
			
			
		}	
	
	
	// ---------------------------------TRALHA ---------------------------------------------
	
		static void msg(String msg) {System.out.println(msg);}
	
	// -------------------------------------------------------------------------------------

}
