package djf;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class DFJdevelopment{
	//Variaveis gerais
	
    
    
		static Scanner teclado = new Scanner(System.in);
		static String sepChar=";";  //Caracter de separação dos campos nos ficheiros de dados
			
		//variaveis Utilizadores
		static String user="";

		
		
		
		
		
	  
	        
	        static String FILENAME[]=new String[]{"Livros.dab","Revistas.dab","Utilizadores.dab","Alugueres.dab"};
	        
	        static String [][] livros= new String [0][3];
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
	        livros=lerFicheiroLivros();
	            
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

				utilizadores = new String[numLinhas][3];

				for(int i=0; sc1.hasNextLine(); i++)
				{
					String line = sc1.nextLine();
					utilizadores[i][0] = String.valueOf((line.split(";")[0]));
					utilizadores[i][1] = String.valueOf((line.split(";")[1]));
					utilizadores[i][2] = String.valueOf((line.split(";")[2]));

				}
				sc1.close();
			} catch (FileNotFoundException e) {
				System.out.println("Ocorreu um erro durante a leitura do ficheiro! [DEBUG: "+e.getMessage()+"]");
			}

			return utilizadores;
		}
            public static String [][] lerFicheiroLivros(){ 

			try{
				File ficheiro = new File(Ficheiro_livros);

				if (!ficheiro.exists()) {
					ficheiro.createNewFile(); 
				}
			}catch(IOException e) {
				System.out.println("Ocorreu um erro durante a criação do ficheiro! [DEBUG: "+e.getMessage()+"]");
				System.out.println("Tente de novo!");
				lerFicheiroUtilizadores();
			}
			try {
				File file = new File(Ficheiro_livros);
				Scanner sc1 = new Scanner(file);

				int numLinhas = 0;
				while(sc1.hasNextLine()) {
					numLinhas++;
					sc1.nextLine();
				}
				sc1.close();

				sc1 = new Scanner(file);

				livros = new String[numLinhas][3];

				for(int i=0; sc1.hasNextLine(); i++)
				{
					String line = sc1.nextLine();
					livros[i][0] = String.valueOf((line.split(";")[0]));
					livros[i][1] = String.valueOf((line.split(";")[1]));
					livros[i][2] = String.valueOf((line.split(";")[2]));
                    livros[i][3] = String.valueOf((line.split(";")[3]));

				}
				sc1.close();
			} catch (FileNotFoundException e) {
				System.out.println("Ocorreu um erro durante a leitura do ficheiro! [DEBUG: "+e.getMessage()+"]");
			}

			return livros;
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

					
					String temporarioArray[][] = new String[utilizadores.length+1][3];

				
					for(int i=0; i<utilizadores.length;i++) 
					{
						temporarioArray[i][0]=utilizadores[i][0];
						temporarioArray[i][1]=utilizadores[i][1];
						temporarioArray[i][2]=utilizadores[i][2];
						
	                                        
	                                        
					}

					System.out.println("Insira o nome do utilizador no formato (Apelido, Nome Próprio)");
					temporarioArray[temporarioArray.length-1][0]= teclado.next();
					
	                                System.out.println("Insira o número de Aluno");
					 temporarioArray[temporarioArray.length-1][1]= teclado.next();
					 System.out.println("Insira o contacto de Aluno");
					 temporarioArray[temporarioArray.length-1][2]= teclado.next();
	                            
	                                
					
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
	        System.err.println("3 - Alterar contacto aluno");
	        
	        
	        
	        escolha = teclado.nextInt();
	        switch(escolha)
	        {
	            case 1: AlterarNome();
	                
	            case 2: AlterarNum();
	            
	            case 3: AlterarCont();
	                    break;
	        }
	        
	        
	        
	    }
	    
	    public static void AlterarCont() {
	    	String utilizadorinicial;
			String alteracaoutilizador;
			
			
				System.out.println("Insira o numero do utilizador para alterar o contacto de aluno");
				System.out.println("Nome     | Nº de aluno | Contacto");
				for (int i = 0; i<utilizadores.length; i++){
					if(utilizadores[i][0].compareToIgnoreCase("0")!=0)
						System.out.println(utilizadores[i][0]+ "  | " + utilizadores[i][1]+ "  | " + utilizadores[i][2]);
				}	
				utilizadorinicial=teclado.next();
				for(int h=0;h<utilizadores.length;h++){
					if(utilizadorinicial.equals(utilizadores[h][1])){
						
						System.out.println("Insira o novo contacto de aluno");
						alteracaoutilizador=teclado.next();
						
							
								utilizadores[h][2]=alteracaoutilizador;

							
						}
					}
					GuardaArrayParaFicheiro(Ficheiro_utilizadores,utilizadores);
					Menu1();
				}
		
	    	
	    	
	    	
	    
	    
	    public static void AlterarNum() { 

			String utilizadorinicial;
			String alteracaoutilizador;
			
			
				System.out.println("Insira o nome do utilizador para alterar o numero de aluno");
				System.out.println("Nome     | Nº de aluno | Contacto");
				for (int i = 0; i<utilizadores.length; i++){
					if(utilizadores[i][0].compareToIgnoreCase("0")!=0)
						System.out.println(utilizadores[i][0]+ "  | " + utilizadores[i][1]+ "  | " + utilizadores[i][2]);
				}	
				utilizadorinicial=teclado.next();
				for(int h=0;h<utilizadores.length;h++){
					if(utilizadorinicial.equals(utilizadores[h][0])){
						
						System.out.println("Insira o novo numero de aluno");
						alteracaoutilizador=teclado.next();
						
							utilizadores[h][1]=alteracaoutilizador;

						
						}
					}
					GuardaArrayParaFicheiro(Ficheiro_utilizadores,utilizadores);
					Menu1();
				}
		

		
	    
	        public static void AlterarNome() { 

			String utilizadorinicial;
			String alteracaoutilizador;
			
				System.out.println("Insira o numero de aluno para alterar o nome");
				System.out.println("Nome     | Nº de aluno | Contacto");
				for (int i = 0; i<utilizadores.length; i++){
					if(utilizadores[i][0].compareToIgnoreCase("0")!=0)
						System.out.println(utilizadores[i][0]+ "  | " + utilizadores[i][1]+ "  | " + utilizadores[i][2]);
				}	
				utilizadorinicial=teclado.next();
				for(int h=0;h<utilizadores.length;h++){
					if(utilizadorinicial.equals(utilizadores[h][1])){
						
						System.out.println("Insira o novo nome de aluno");
						alteracaoutilizador=teclado.next();
						utilizadores[h][0]=alteracaoutilizador;
					}
					}
					GuardaArrayParaFicheiro(Ficheiro_utilizadores,utilizadores);
					Menu1();
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
					System.out.println(utilizadores[i][0]+ "  | " + utilizadores[i][1]+ "  | " + utilizadores[i][2]);
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
			temporarioArray[y][2]=utilizadores[x][2];
			
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

				System.out.println(utilizadores[i][0]+ "  : " + utilizadores[i][1]+ "  : " + utilizadores[i][2]);

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
	    public static void CriarLivro() // alterar
	    {
	        int numero=0;
				do{

					
					String temporarioArray[][] = new String[livros.length+1][4];

				
					for(int i=0; i<livros.length;i++) 
					{
						temporarioArray[i][0]=livros[i][0];
						temporarioArray[i][1]=livros[i][1];
                                                temporarioArray[i][2]=livros[i][2];
                                                temporarioArray[i][3]=livros[i][3];
	                                        
	                                        
					}

					System.out.println("Titulo");
					temporarioArray[temporarioArray.length-1][0]= teclado.next();
					
	                                System.out.println("Autor");
					temporarioArray[temporarioArray.length-1][1]= teclado.next();
                                        
                                        System.out.println("Editora");
					temporarioArray[temporarioArray.length-1][2]= teclado.next();
                                        
                                        System.out.println("Código");
					temporarioArray[temporarioArray.length-1][3]= teclado.next();
	                                
					
					livros=temporarioArray;
					


					do{
						System.out.println("Prima 1 para inserir uma novo livro ou 0 para voltar.");
						numero=teclado.nextInt();
						
						if(numero!=0 &&numero!=1){
							System.out.println("Apenas pode inserir 0 ou 1");
							numero=2;
						}

					}while(numero==2);
					

				}while(numero!=0);
				 GuardaArrayParaFicheiro(Ficheiro_livros,livros);
				 Menu2();
			}
	    
	        public static void subMenu22()
	                {
	                  int escolha;
	                  System.err.println("------------------------------------------------------------------------------------");
	                  System.err.println("------------------------------   Alterar Livro  -----------------------------------");
	                  System.out.println("1 - Alterar Titulo");
	                  System.out.println("2 - Alterar Autor");
	                  System.out.println("3 - Alterar Editora");
	                  System.out.println("4 - Alterar Código");
	                  escolha=teclado.nextInt();
	                  switch(escolha)
	                  {
	                      case 1:
	                    	  alterarTitulo();
	                      case 2:
	                    	  alterarAutor();
                          case 3:
                              alterarEditora();
                          case 4:
                        	  alterarCodigo();
	                  }
	                    
	                    
	                }
	    
                public static void alterarTitulo()
                {
                	String livroinicial;
        			String alteracaolivro;
        			
        				System.out.println("Insira o Código do livro para alterar o Título");
        				System.out.println("Título     | Autor | Editora | Código");
        				for (int i = 0; i<livros.length; i++){
        					if(livros[i][0].compareToIgnoreCase("0")!=0)
        						System.out.println(livros[i][0]+ "  | " + livros[i][1]+ "  | " + livros[i][2]+ "  | " + livros[i][3]);
        				}	
        				livroinicial=teclado.next();
        				for(int h=0;h<livros.length;h++){
        					if(livroinicial.equals(livros[h][3])){
        						
        						System.out.println("Insira o novo Título do livro");
        						alteracaolivro=teclado.next();
        						livros[h][0]=alteracaolivro;
        					}
        					}
        					GuardaArrayParaFicheiro(Ficheiro_livros,livros);
        					Menu2();
                    
                }
                
                public static void alterarAutor() {
                String livroinicial;
    			String alteracaolivro;
    			
    				System.out.println("Insira o Código do livro para alterar o Autor");
    				System.out.println("Título     | Autor | Editora | Código");
    				for (int i = 0; i<livros.length; i++){
    					if(livros[i][0].compareToIgnoreCase("0")!=0)
    						System.out.println(livros[i][0]+ "  | " + livros[i][1]+ "  | " + livros[i][2]+ "  | " + livros[i][3]);
    				}	
    				livroinicial=teclado.next();
    				for(int h=0;h<livros.length;h++){
    					if(livroinicial.equals(livros[h][3])){
    						
    						System.out.println("Insira o novo Autor do livro");
    						alteracaolivro=teclado.next();
    						livros[h][1]=alteracaolivro;
    					}
    					}
    					GuardaArrayParaFicheiro(Ficheiro_livros,livros);
    					Menu2();
                
                    
                }
                public static void alterarEditora()
                {
                	String livroinicial;
         			String alteracaolivro;
         			
         				System.out.println("Insira o Código do livro para alterar a Editora");
         				System.out.println("Título     | Autor | Editora | Código");
         				for (int i = 0; i<livros.length; i++){
         					if(livros[i][0].compareToIgnoreCase("0")!=0)
         						System.out.println(livros[i][0]+ "  | " + livros[i][1]+ "  | " + livros[i][2]+ "  | " + livros[i][3]);
         				}	
         				livroinicial=teclado.next();
         				for(int h=0;h<livros.length;h++){
         					if(livroinicial.equals(livros[h][3])){
         						
         						System.out.println("Insira a nova Editora do livro");
         						alteracaolivro=teclado.next();
         						livros[h][2]=alteracaolivro;
         					}
         					}
         					GuardaArrayParaFicheiro(Ficheiro_livros,livros);
         					Menu2();
                }
                public static void alterarCodigo()
                {
                	String livroinicial;
         			String alteracaolivro;
         			
         				System.out.println("Insira o Título do livro para alterar o Código");
         				System.out.println("Título     | Autor | Editora | Código");
         				for (int i = 0; i<livros.length; i++){
         					if(livros[i][0].compareToIgnoreCase("0")!=0)
         						System.out.println(livros[i][0]+ "  | " + livros[i][1]+ "  | " + livros[i][2]+ "  | " + livros[i][3]);
         				}	
         				livroinicial=teclado.next();
         				for(int h=0;h<livros.length;h++){
         					if(livroinicial.equals(livros[h][0])){
         						
         						System.out.println("Insira o novo Código do livro");
         						alteracaolivro=teclado.next();
         						livros[h][3]=alteracaolivro;
         					}
         					}
         					GuardaArrayParaFicheiro(Ficheiro_livros,livros);
         					Menu2();
                }
	        public static void subMenu23()
	        {
	          System.err.println("------------------------------------------------------------------------------------");
	          System.err.println("------------------------------   Remover Livro  -----------------------------------");  
                  RemoverLivro();
                }
	        
	       public static void RemoverLivro()
               {
                 String livropararemover;
                 String temporarioArray[][]= new String[livros.length-1][4];


			System.out.println("Livros ");
			for (int i=0;i<livros.length;i++) {
				if(livros[i][0].compareToIgnoreCase("0")!=0) {
					System.out.println(livros[i][0]+ "  | " + livros[i][1]+ "  | " + livros[i][2]+ " | "  + livros[i][3] );
				}
			}
			System.out.println("Insira o nome do livro que pretende remover?" );
			livropararemover=teclado.next();
			int y=0;
			for(int x=0;x<livros.length;x++) {
				if(livros[x][0].equalsIgnoreCase(livropararemover)){
					continue;
				}
			temporarioArray[y][0]=livros[x][0];
			temporarioArray[y][1]=livros[x][1];
			temporarioArray[y][2]=livros[x][2];
			temporarioArray[y][3]=livros[x][3];
			y++;
			}
			livros=temporarioArray;
			
			GuardaArrayParaFicheiro(Ficheiro_livros,livros);
			
			subMenu13(); 
	            
	              
               }
	        public static void subMenu24()
	        {
	            System.err.println("------------------------------------------------------------------------------------");
	            System.err.println("------------------------------   Consultar Livro  -----------------------------------");
                    listarLivro();
                }
                public static void listarLivro()
                {
                  int tamlivros = livros.length;


			for(int i=0; i<tamlivros; i++){

				System.out.println(livros[i][0]+ "  : " + livros[i][1]+ "  : " + livros[i][2]+ "  :  " + livros[i][3]);

			}
			Menu2(); 
	        
	          
                }
	        
	        public static void subMenu25()
	        {
	          int escolha;
	          System.err.println("------------------------------------------------------------------------------------");
	          System.err.println("-------------------------------------- SAIR  -------------------------------------------");  
	           
	         System.out.println("1 - Voltar ao Menu principal");
	         System.out.println("2 - Menu Livros ");
	            escolha=teclado.nextInt();
	        switch (escolha)
	        {
	            case 1: MenuPrincipal();
	                    break;
	            case 2: Menu2();
	                    break;
	            
	            
	            
	        }
	        }
	                
	       public static void Menu3()
	       {
	            int escolha;
	        System.err.println("------------------------------------------------------------------------------------");
	        System.err.println("----------------------------------   Menu Revistas ---------------------------------");
	        System.err.println(" 1 - Inserir Revista");
	        System.err.println(" 2 - Alterar Revista");
	        System.err.println(" 3 - Remover Revista");
	        System.err.println(" 4 - Consultar Revista");
	        System.err.println(" 5 - Menu Anterior");
	        escolha = teclado.nextInt();
	        switch(escolha)
	        {
	            case 1: {
				subMenu31();
				break;
			}
			case 2: {
				subMenu32();
				break;
			}
			case 3: {
				subMenu33();
			}
			case 4: {
				subMenu34();
			}
			case 5: {
				subMenu35();
			}
	        }
	       }
	       
	    public static void subMenu31()
	    {
	        
	       System.err.println("------------------------------------------------------------------------------------");
	       System.err.println("-----------------------------   Inserir Revista  -----------------------------------");
	       criarRevista();
	        
	        
	        
	    }
	    
	    public static void criarRevista() // alterar arrays
	    {
	         int numero=0;
				do{

					
					String temporarioArray[][] = new String[revistas.length+1][2];

				
					for(int i=0; i<revistas.length;i++) 
					{
						temporarioArray[i][0]=revistas[i][0];
						temporarioArray[i][1]=revistas[i][1];
	                                        
	                                        
					}

					System.out.println("Insira o nome do utilizador no formato (Apelido, Nome Próprio)");
					temporarioArray[temporarioArray.length-1][0]= teclado.next();
					
	                                System.out.println("Insira o número de Aluno");
					 temporarioArray[temporarioArray.length-1][1]= teclado.next();
	                            
	                                
					
					revistas=temporarioArray;
					


					do{
						System.out.println("Prima 1 para inserir uma novo utilizador ou 0 para voltar.");
						numero=teclado.nextInt();
						
						if(numero!=0 &&numero!=1){
							System.out.println("Apenas pode inserir 0 ou 1");
							numero=2;
						}

					}while(numero==2);
					

				}while(numero!=0);
				 GuardaArrayParaFicheiro(Ficheiro_revistas,revistas);
				 Menu3();
			
	    
	    }
	    
	    
	    
	    public static void subMenu32()
	    {
	       System.err.println("------------------------------------------------------------------------------------");
	       System.err.println("-----------------------------   Alterar Revista  -----------------------------------"); 
	    }
	    
	    
	    public static void subMenu33()
	    {
	        System.err.println("------------------------------------------------------------------------------------");
	        System.err.println("------------------------------   Remover Revista  -----------------------------------"); 
	    }
	    
	    public static void subMenu34()
	    {
	        System.err.println("------------------------------------------------------------------------------------");
	       System.err.println("----------------------------   Consultar Revista  -----------------------------------"); 
	    }
	    
	    public static void subMenu35()
	    {
	       int escolha;
	        System.err.println("------------------------------------------------------------------------------------");
	        System.out.println("--------------------------------- SAIR ---------------------------------------------");  
	        System.out.println("1 - Voltar ao Menu principal");
	        System.out.println("2 - Menu Revistas ");
	        escolha=teclado.nextInt();
	        switch (escolha)
	        {
	            case 1: MenuPrincipal();
	                    break;
	            case 2: Menu3();
	                    break;
	            
	            
	            
	        }
	    
	    
	    
	    
	    
	    }
	     public static void Menu4()
	     {
	        int escolha;
	        System.err.println("------------------------------------------------------------------------------------");
	        System.err.println("----------------------------------   Menu Alugueres ---------------------------------");
	        System.err.println(" 1 - Inserir Aluguer");
	        System.err.println(" 2 - Alterar Aluguer");
	        System.err.println(" 3 - Remover Aluguer");
	        System.err.println(" 4 - Consultar Aluguer");
	        System.err.println(" 5 - Menu Anterior");
	        escolha = teclado.nextInt();
	        switch(escolha)
	        {
	            case 1: {
				subMenu41();
				break;
			}
			case 2: {
				subMenu42();
				break;
			}
			case 3: {
				subMenu43();
			}
			case 4: {
				subMenu44();
			}
			case 5: {
				subMenu45();
			}
	        } 
	     }
	   public static void subMenu41()
	   {
	     System.err.println("------------------------------------------------------------------------------------");
	     System.err.println("-----------------------------   Inserir Aluguer  -----------------------------------"); 
	       
	       
	   }
	   public static void subMenu42()
	   {
	    System.err.println("------------------------------------------------------------------------------------");
	    System.err.println("------------------------------  Alterar Aluguer  -----------------------------------");    
	   }
	    
	   public static void subMenu43()
	   {
	       System.err.println("------------------------------------------------------------------------------------");
	       System.err.println("------------------------------  Remover Aluguer  -----------------------------------");     
	   }
	   
	   public static void subMenu44()
	   {
	        System.err.println("------------------------------------------------------------------------------------");
	        System.err.println("----------------------------  Consultar Aluguer  -----------------------------------");    
	   }
	   
	   public static void subMenu45()
	   {
	       int escolha;
	        System.err.println("------------------------------------------------------------------------------------");
	        System.out.println("--------------------------------- SAIR ---------------------------------------------");  
	        System.out.println("1 - Voltar ao Menu principal");
	        System.out.println("2 - Menu Alugueres ");
	        escolha=teclado.nextInt();
	        switch (escolha)
	        {
	            case 1: MenuPrincipal();
	                    break;
	            case 2: Menu4();
	                    break;
	            
	            
	            
	        }
	    
	    
	   } 
	   public static void Menu5() {
		   
		   
		   
		   
		   
		   
	   }
	   
	   public static void Menu6() {
			int escolha;
			System.err.println("------------------------------------------------------------------------------------");
			System.err.println("--------------------------        Menu Sair      -----------------------------------");
			System.out.println("Deseja sair do programa? ");
			System.out.println(" 1-Sim \n2-Não");

			escolha = teclado.nextInt();
			switch(escolha) {
			case 1:
				System.exit(0);
				break;
			case 2:
				MenuPrincipal();
				break;

			}			
		}

}