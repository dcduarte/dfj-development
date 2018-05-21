package dfjdevelopment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;



public class DFJdevelopment {
    //Variaveis gerais
	
    
    
	static Scanner teclado = new Scanner(System.in);
	static String sepChar=";";  //Caracter de separação dos campos nos ficheiros de dados
		
	//variaveis Utilizadores
	static String user="";

	
	
	
	
	
  
        
        static String FILENAME[]=new String[]{"Livros.dab","Revistas.dab","Utilizadores.dab","Alugueres.dab"};
        
        static String [][] livros= new String [0][4];
        static String [][] revistas= new String [0][4];
        static String [][] utilizadores= new String [0][2];
        static String [][] alugueres= new String [0][3];
        static String Ficheiro_livros = "Livros.dab";
        static String Ficheiro_revistas = "Revistas.dab";
        static String Ficheiro_utilizadores = "Utilizadores.dab";
        static String Ficheiro_alugueres = "Alugueres.dab";
        static File ficheiro;
        
        
        
        
        public static void main(String[] args) {
        utilizadores=lerFicheiroUtilizadores();
            
            for (int i=0; i<FILENAME.length;i++) {
			ficheiro = new File(FILENAME[i]);
			
			if (!ficheiro.exists()) {
				criarFicheiros(FILENAME[i]);
			}
		
		}
		
		
	
		MenuPrincipal();
    }
    
    public static void criarFicheiros( String nome) {
			
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
    public static String [][] lerFicheiroUtilizadores(){ 

		try{
			File ficheiro = new File(Ficheiro_utilizadores);

			if (!ficheiro.exists()) {
				ficheiro.createNewFile(); 
			}
		}catch(IOException e) {
			System.out.println("Ocorreu um erro durante a criação do ficheiro! [DEBUG: "+e.getMessage()+"]");
			System.out.println("Tente de novo!");
			lerFicheiroUtilizadores();
		}
		try {
			File file = new File(Ficheiro_utilizadores);
			Scanner sc1 = new Scanner(file);

			int numLinhas = 0;
			while(sc1.hasNextLine()) {
				numLinhas++;
				sc1.nextLine();
			}
			sc1.close();

			sc1 = new Scanner(file);
			utilizadores = new String[numLinhas][2];

			utilizadores = new String[numLinhas][2];

			for(int i=0; sc1.hasNextLine(); i++)
			{
				String line = sc1.nextLine();
				utilizadores[i][0] = String.valueOf((line.split(";")[0]));
				utilizadores[i][1] = String.valueOf((line.split(";")[1]));

			}
			sc1.close();
		} catch (FileNotFoundException e) {
			System.out.println("Ocorreu um erro durante a leitura do ficheiro! [DEBUG: "+e.getMessage()+"]");
		}

		return utilizadores;
	}
    public static void GuardaArrayParaFicheiro(String ficheiro, String[][] narray)//Vai Guardar o Array No ficheiro
	{
		try {
			BufferedWriter bf = new BufferedWriter(new FileWriter(ficheiro));
			
			for(int i=0; i<narray.length; i++)
			{
				for(int y=0; y<narray[0].length; y++)
				{
					bf.write(narray[i][y]+";");
				}
				bf.newLine();
			}
			bf.close();
		} catch(FileNotFoundException e) {
			System.out.println("Ficheiro desconhecido...");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Erro na aplicação!");
			e.printStackTrace();
		}
	}
    static void msg(String msg) {System.out.println(msg);}
    
    
    public static void MenuPrincipal()
{
int escolha;
                System.err.println("------------------------------------------------------------------------------------");
		System.err.println("\t\t\t\t ** DFJ DEVELOPEMENT ** \n \n");
		
		System.err.println("------------------------------------------------------------------------------------");
		System.err.println("\t\t\t\t ** BEM VINDO ** ");
		System.err.println("------------------------------------------------------------------------------------");
		System.err.println("1 - Menu Utilizador ");
		System.err.println("2 - Menu Livros ");
		System.err.println("3 - Menu Revistas ");
		System.err.println("4 - Menu Alugueres ");
		System.err.println("5 - Menu Estatistica");
                System.err.println("6 - Sair");
		System.err.println("------------------------------------------------------------------------------------");
		escolha = teclado.nextInt();
                switch(escolha){
                case 1: {
			Menu1();
			break;
		}
		case 2: {
                        
			Menu2();
			break;
		}

		case 3: {
			Menu3();
			break;
		}

		case 4: {
			Menu4();
			break;
		}

		case 5: {
			Menu5();
			break;
		}
		case 6: {
			Menu6();
			break;
		}
                }

}
    
    public static void Menu1()
    {
        int escolha;
        System.err.println("------------------------------------------------------------------------------------");
        System.err.println("--------------------------     Menu Utilizadores -----------------------------------");
        System.err.println(" 1 - Criar Utilizador");
        System.err.println(" 2 - Alterar Registo de Utilizador");
        System.err.println(" 3 - Remover Utilizador");
        System.err.println(" 4 - Consultar Utilizadores");
        System.err.println(" 5 - Menu Anterior");
        escolha = teclado.nextInt();
        switch(escolha)
        {
            case 1: {
			subMenu11();
			break;
		}
		case 2: {
			subMenu12();
			break;
		}
		case 3: {
			subMenu13();
		}
		case 4: {
			subMenu14();
		}
		case 5: {
			subMenu15();
		}
        }
        
        
        
    }
    
    public static void subMenu11()
    {
      
      System.err.println("------------------------------------------------------------------------------------");
      System.err.println("-------------------------   Criar Utilizadores  -----------------------------------");
      CriarUtilizador();
      
        
        
        
        
    }
    
    private static void CriarUtilizador() { 
			int numero=0;
			do{

				
				String temporarioArray[][] = new String[utilizadores.length+1][2];

			
				for(int i=0; i<utilizadores.length;i++) 
				{
					temporarioArray[i][0]=utilizadores[i][0];
					temporarioArray[i][1]=utilizadores[i][1];
                                        
                                        
				}

				System.out.println("Insira o nome do utilizador no formato (Apelido, Nome Próprio)");
				temporarioArray[temporarioArray.length-1][0]= teclado.next();
				
                                System.out.println("Insira o número de Aluno");
				 temporarioArray[temporarioArray.length-1][1]= teclado.next();
                            
                                
				
				utilizadores=temporarioArray;
				


				do{
					System.out.println("Prima 1 para inserir uma novo utilizador ou 0 para voltar.");
					numero=teclado.nextInt();
					
					if(numero!=0 &&numero!=1){
						System.out.println("Apenas pode inserir 0 ou 1");
						numero=2;
					}

				}while(numero==2);
				

			}while(numero!=0);
			 GuardaArrayParaFicheiro(Ficheiro_utilizadores,utilizadores);
			 Menu1();
		}
    
    
    public static void subMenu12()
    {
        int escolha;
        System.err.println("------------------------------------------------------------------------------------");
        System.err.println("----------------------------- Alterar Registo --------------------------------------");
        System.err.println("1 - Alterar nome de utilizador");
        System.err.println("2 - Alterar nº de aluno");
        
        
        escolha = teclado.nextInt();
        switch(escolha)
        {
            case 1: AlterarNome();
                
            case 2: AlterarNum();
                    break;
        }
        
        
        
    }
    public static void AlterarNum() { 

		String utilizadorinicial;
		String alteracaoutilizador;
		boolean certo=false;
		do{
			System.out.println("Insira o nome do utilizador que quer trocar o numero de aluno");
			System.out.println("Nome     | Nº de aluno");
			for (int i = 0; i<utilizadores.length; i++){
				if(utilizadores[i][0].compareToIgnoreCase("0")!=0)
					System.out.println(utilizadores[i][0]+ "  | " + utilizadores[i][1]);
			}	
			utilizadorinicial=teclado.next();
			for(int h=0;h<utilizadores.length;h++){
				if(utilizadorinicial.equals(utilizadores[h][0])){
					certo=true;
					System.out.println("Insira o novo numero de aluno");
					alteracaoutilizador=teclado.next();
					for(int j=0;j<utilizadores.length;j++){
						if(utilizadores[j][0].equalsIgnoreCase(utilizadorinicial)){
							utilizadores[j][1]=alteracaoutilizador;

						}
					}
				}else{
					certo=false;
				}
				GuardaArrayParaFicheiro(Ficheiro_utilizadores,utilizadores);
				Menu1();
			}
		}while(certo==false);

	}
    
        public static void AlterarNome() { 

		String utilizadorinicial;
		String alteracaoutilizador;
		boolean certo=false;
		do{
			System.out.println("Insira o numero de aluno que quer trocar o nome");
			System.out.println("Nome     | Nº de aluno");
			for (int i = 0; i<utilizadores.length; i++){
				if(utilizadores[i][0].compareToIgnoreCase("0")!=0)
					System.out.println(utilizadores[i][0]+ "  | " + utilizadores[i][1]);
			}	
			utilizadorinicial=teclado.next();
			for(int h=0;h<utilizadores.length;h++){
				if(utilizadorinicial.equals(utilizadores[0][h])){
					certo=true;
					System.out.println("Insira o novo numero de aluno");
					alteracaoutilizador=teclado.next();
					for(int j=0;j<utilizadores.length;j++){
						if(utilizadores[0][j].equalsIgnoreCase(utilizadorinicial)){
							utilizadores[1][j]=alteracaoutilizador;

						}
					}
				}else{
					certo=false;
				}
				GuardaArrayParaFicheiro(Ficheiro_utilizadores,utilizadores);
				Menu1();
			}
		}while(certo==false);

	}
    
        
        public static void subMenu13()
        {
        int escolha;
        System.err.println("------------------------------------------------------------------------------------");
        System.err.println("-------------------------- Remover Utilizador --------------------------------------");
        System.out.println("1 - Remover Utilizadores");
        System.out.println("2 - Voltar Menu Anterior");
        escolha=teclado.nextInt();
        switch(escolha)
        {
            case 1: removeUtilizador();
                    break;
            case 2: Menu1();
            
            
        }
        
            
            
        }
        
        public static void removeUtilizador()
        {
        String utilizadorpararemover;
        String temporarioArray[][]= new String[utilizadores.length-1][2];


		System.err.println("Nome | Nº de aluno ");
		for (int i=0;i<utilizadores.length;i++) {
			if(utilizadores[i][0].compareToIgnoreCase("0")!=0) {
			System.out.println(utilizadores[i][0]+"|"+utilizadores[i][1]);
			}
		}
		System.err.println("Insira o nome do utilizador que pretende remover?" );
		utilizadorpararemover=teclado.next();
		int y=0;
		for(int x=0;x<utilizadores.length;x++) {
			if(utilizadores[x][0].equalsIgnoreCase(utilizadorpararemover)){
				continue;
			}
		temporarioArray[y][0]=utilizadores[x][0];
		temporarioArray[y][1]=utilizadores[x][1];
		y++;
		}
		utilizadores=temporarioArray;
		
		GuardaArrayParaFicheiro(Ficheiro_utilizadores,utilizadores);
		
		subMenu13(); 
            
            
            
           
        }
        
        
    public static void subMenu14()
    {
       int escolha;
        System.err.println("------------------------------------------------------------------------------------");
        System.out.println("--------------------------- Consultar Utilizadores ---------------------------------");
        System.out.println("1 - Consultar Utilizadores no Sistema");
        System.out.println("2 - Voltar Menu Anterior");
        escolha=teclado.nextInt();
        switch(escolha)
        {
            case 1: listarUtilizadores();
                    break;
            case 2: Menu1();
                    break;
            
        }  
        
        
        
    }   
    
    public static void listarUtilizadores()
    {
       int tamUtilizadores = utilizadores.length;


		for(int i=0; i<tamUtilizadores; i++){

			System.out.println(utilizadores[i][0] +" : "+utilizadores[i][1]);

		}
		subMenu14(); 
        
        
        
    }
       
    public static void subMenu15()
    {
      int escolha;
        System.err.println("------------------------------------------------------------------------------------");
        System.out.println("--------------------------------- SAIR ---------------------------------------------");  
        System.out.println("1 - Voltar ao Menu principal");
        System.out.println("2 - Menu Utilizadores ");
        escolha=teclado.nextInt();
        switch (escolha)
        {
            case 1: MenuPrincipal();
                    break;
            case 2: Menu1();
                    break;
            
            
            
        }
    }
   
   public static void Menu2()
    {
        int escolha;
        System.err.println("------------------------------------------------------------------------------------");
        System.err.println("----------------------------------   Menu Livros -----------------------------------");
        System.err.println(" 1 - Inserir Livro");
        System.err.println(" 2 - Alterar Livro");
        System.err.println(" 3 - Remover Livro");
        System.err.println(" 4 - Consultar Livros");
        System.err.println(" 5 - Menu Anterior");
        escolha = teclado.nextInt();
        switch(escolha)
        {
            case 1: {
			subMenu21();
			break;
		}
		case 2: {
			subMenu22();
			break;
		}
		case 3: {
			subMenu23();
		}
		case 4: {
			subMenu24();
		}
		case 5: {
			subMenu25();
		}
        }
        
        
        
    }  

    public static void subMenu21()
    {
      System.err.println("------------------------------------------------------------------------------------");
      System.err.println("------------------------------   Inserir Livro  -----------------------------------");
      CriarLivro(); 
        
        
        
        
    }
    public static void CriarLivro()
    {
        int numero=0;
			do{

				
				String temporarioArray[][] = new String[livros.length+1][2];

			
				for(int i=0; i<livros.length;i++) 
				{
					temporarioArray[i][0]=livros[i][0];
					temporarioArray[i][1]=livros[i][1];
                                        
                                        
				}

				System.out.println("Insira o nome do utilizador no formato (Apelido, Nome Próprio)");
				temporarioArray[temporarioArray.length-1][0]= teclado.next();
				
                                System.out.println("Insira o número de Aluno");
				 temporarioArray[temporarioArray.length-1][1]= teclado.next();
                            
                                
				
				utilizadores=temporarioArray;
				


				do{
					System.out.println("Prima 1 para inserir uma novo utilizador ou 0 para voltar.");
					numero=teclado.nextInt();
					
					if(numero!=0 &&numero!=1){
						System.out.println("Apenas pode inserir 0 ou 1");
						numero=2;
					}

				}while(numero==2);
				

			}while(numero!=0);
			 GuardaArrayParaFicheiro(Ficheiro_utilizadores,utilizadores);
			 Menu1();
		}
    
    }
    
    }


 