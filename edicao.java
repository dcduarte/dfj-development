/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dfj;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

import javax.swing.JPasswordField;

public class edicao {
    //Variaveis gerais


    static Scanner teclado = new Scanner(System.in);
    static String sepChar = ";";  //Caracter de separação dos campos nos ficheiros de dados

    //variaveis Utilizadores
    static String user = "";


    static String FILENAME[] = new String[]{"Livros.dab", "Revistas.dab", "Utilizadores.dab", "Alugueres.dab"};

    static String[][] livros = new String[0][4];
    static String[][] revistas = new String[0][3];
    static String[][] utilizadores = new String[0][2];
    static String[][] alugueres = new String[0][2];
    static String Ficheiro_livros = "Livros.dab";
    static String Ficheiro_revistas = "Revistas.dab";
    static String Ficheiro_utilizadores = "Utilizadores.dab";
    static String Ficheiro_alugueres = "Alugueres.dab";
    static File ficheiro;


    public static void main(String[] args) {
        utilizadores = lerFicheiroUtilizadores();
        livros = lerFicheiroLivros();
        revistas =lerFicheiroRevistas();
        alugueres= lerFicheiroAlugueres();

        for (int i = 0; i < FILENAME.length; i++) {
            ficheiro = new File(FILENAME[i]);

            if (!ficheiro.exists()) {
                criarFicheiros(FILENAME[i]);
            }

        }

        login();
        MenuPrincipal();
        
    }
    public static void login(){
    String Username;
    String Password;

    Password = "0000";
    Username = "dfj";

    Scanner input1 = new Scanner(System.in);
    System.out.println("Utilizador : ");
    String username = input1.next();

    Scanner input2 = new Scanner(System.in);
    System.out.println("Password : ");
    String password = input2.next();

    if (username.equals(Username) && password.equals(Password)) {

        System.out.println("Acesso Concedido! Bem Vindo!");
    }

    else if (username.equals(Username)) {
        System.out.println(" Password Invalida!");
    } else if (password.equals(Password)) {
        System.out.println("Utilizador Invalido!");
    } else {
        System.out.println("Utilizador Invalido & Password Invalida!");
    }

}
 

    
    
    public static void criarFicheiros(String nome) {

        for (int i = 0; i < FILENAME.length; i++) {
            File ficheiro = new File(FILENAME[i]);
            if (!ficheiro.exists()) {
                System.out.print(" A criar Ficheiros ... Aguarde");
                try {
                    if (ficheiro.createNewFile()) {
                        System.out.println("Ficheiro criado com sucesso!");
                    } else {
                        System.out.println("outo ao tentar criar o ficheiro!");
                    }
                } catch (IOException e) {
                    System.out.println("outo na aplicação!");
                    e.printStackTrace();
                }

            }
        }
    }

    public static String[][] lerFicheiroUtilizadores() {

        try {
            File ficheiro = new File(Ficheiro_utilizadores);

            if (!ficheiro.exists()) {
                ficheiro.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um outo durante a criação do ficheiro! [DEBUG: " + e.getMessage() + "]");
            System.out.println("Tente de novo!");
            lerFicheiroUtilizadores();
        }
        try {
            File file = new File(Ficheiro_utilizadores);
            Scanner sc1 = new Scanner(file);

            int numLinhas = 0;
            while (sc1.hasNextLine()) {
                numLinhas++;
                sc1.nextLine();
            }
            sc1.close();

            sc1 = new Scanner(file);

            utilizadores = new String[numLinhas][3];

            for (int i = 0; sc1.hasNextLine(); i++) {
                String line = sc1.nextLine();
                utilizadores[i][0] = String.valueOf((line.split(";")[0]));
                utilizadores[i][1] = String.valueOf((line.split(";")[1]));
                utilizadores[i][2] = String.valueOf((line.split(";")[2]));

            }
            sc1.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ocorreu um outo durante a leitura do ficheiro! [DEBUG: " + e.getMessage() + "]");
        }

        return utilizadores;
    }

    public static String[][] lerFicheiroLivros() {

        try {
            File ficheiro = new File(Ficheiro_livros);

            if (!ficheiro.exists()) {
                ficheiro.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um outo durante a criação do ficheiro! [DEBUG: " + e.getMessage() + "]");
            System.out.println("Tente de novo!");
            lerFicheiroUtilizadores();
        }
        try {
            File file = new File(Ficheiro_livros);
            Scanner sc1 = new Scanner(file);

            int numLinhas = 0;
            while (sc1.hasNextLine()) {
                numLinhas++;
                sc1.nextLine();
            }
            sc1.close();

            sc1 = new Scanner(file);

            livros = new String[numLinhas][5];

            for (int i = 0; sc1.hasNextLine(); i++) {
                String line = sc1.nextLine();
                livros[i][0] = String.valueOf((line.split(";")[0]));
                livros[i][1] = String.valueOf((line.split(";")[1]));
                livros[i][2] = String.valueOf((line.split(";")[2]));
                livros[i][3] = String.valueOf((line.split(";")[3]));
                livros[i][4] = String.valueOf((line.split(";")[4]));
                

            }
            sc1.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ocorreu um outo durante a leitura do ficheiro! [DEBUG: " + e.getMessage() + "]");
        }

        return livros;
    }

    public static String[][] lerFicheiroRevistas() {

        try {
            File ficheiro = new File(Ficheiro_revistas);

            if (!ficheiro.exists()) {
                ficheiro.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um outo durante a criação do ficheiro! [DEBUG: " + e.getMessage() + "]");
            System.out.println("Tente de novo!");
            lerFicheiroUtilizadores();
        }
        try {
            File file = new File(Ficheiro_revistas);
            Scanner sc1 = new Scanner(file);

            int numLinhas = 0;
            while (sc1.hasNextLine()) {
                numLinhas++;
                sc1.nextLine();
            }
            sc1.close();

            sc1 = new Scanner(file);

            revistas = new String[numLinhas][4];

            for (int i = 0; sc1.hasNextLine(); i++) {
                String line = sc1.nextLine();
                revistas[i][0] = String.valueOf((line.split(";")[0]));
                revistas[i][1] = String.valueOf((line.split(";")[1]));
                revistas[i][2] = String.valueOf((line.split(";")[2]));
                revistas[i][3] = String.valueOf((line.split(";")[3]));
                

            }
            sc1.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ocorreu um outo durante a leitura do ficheiro! [DEBUG: " + e.getMessage() + "]");
        }

        return revistas;
    }
   public static String[][] lerFicheiroAlugueres() {

        try {
            File ficheiro = new File(Ficheiro_alugueres);

            if (!ficheiro.exists()) {
                ficheiro.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um outo durante a criação do ficheiro! [DEBUG: " + e.getMessage() + "]");
            System.out.println("Tente de novo!");
            lerFicheiroUtilizadores();
        }
        try {
            File file = new File(Ficheiro_alugueres);
            Scanner sc1 = new Scanner(file);

            int numLinhas = 0;
            while (sc1.hasNextLine()) {
                numLinhas++;
                sc1.nextLine();
            }
            sc1.close();

            sc1 = new Scanner(file);

            alugueres = new String[numLinhas][3];

            for (int i = 0; sc1.hasNextLine(); i++) {
                String line = sc1.nextLine();
                alugueres[i][0] = String.valueOf((line.split(";")[0]));
                alugueres[i][1] = String.valueOf((line.split(";")[1]));
                alugueres[i][2] = String.valueOf((line.split(";")[2]));

            }
            sc1.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ocorreu um outo durante a leitura do ficheiro! [DEBUG: " + e.getMessage() + "]");
        }

        return alugueres;
    }
    public static void GuardaArrayParaFicheiro(String ficheiro, String[][] narray)//Vai Guardar o Array No ficheiro
    {
        try {
            BufferedWriter bf = new BufferedWriter(new FileWriter(ficheiro));

            for (int i = 0; i < narray.length; i++) {
                for (int y = 0; y < narray[0].length; y++) {
                    bf.write(narray[i][y] + ";");
                }
                bf.newLine();
            }
            bf.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ficheiro desconhecido...");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("outo na aplicação!");
            e.printStackTrace();
        }
    }




    public static void MenuPrincipal() {
        int escolha;
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("\t\t\t\t ** DFJ DEVELOPEMENT ** \n \n");

        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("\t\t\t\t ** BEM VINDO ** ");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("1 - Menu Utilizador ");
        System.out.println("2 - Menu Livros/Revistas ");
        System.out.println("3 - Menu Alugueres ");
        System.out.println("4 - Menu Estatistica");
        System.out.println("5 - Sair");
        System.out.println("------------------------------------------------------------------------------------");
        escolha = teclado.nextInt();
			
       
        switch (escolha) {
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
        }
        

    }


    public static void Menu1() {
    	int escolha=5;
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("--------------------------     Menu Utilizadores -----------------------------------");
        System.out.println(" 1 - Criar Utilizador");
        System.out.println(" 2 - Alterar Registo de Utilizador");
        System.out.println(" 3 - Remover Utilizador");
        System.out.println(" 4 - Consultar Utilizadores");
        System.out.println(" 5 - Menu Anterior");
        try {
			String AUX = teclado.next();
			escolha = Integer.parseInt(AUX);
        switch (escolha) {
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
                MenuPrincipal();
            }
        }
        
    }catch (NumberFormatException e2) {
		
		System.out.print("Formato não reconhecido " + e2.getLocalizedMessage());
		MenuPrincipal();
	} catch (Exception ex) {
		teclado.close();
		System.out.print("Erro não especificado " + ex.getLocalizedMessage());
		MenuPrincipal();
	}



    }

    public static void subMenu11() {

        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("-------------------------   Criar Utilizadores  -----------------------------------");
        CriarUtilizador();


    }

    private static void CriarUtilizador() {
        int numero = 0;
        do {


            String temporarioArray[][] = new String[utilizadores.length + 1][3];


            for (int i = 0; i < utilizadores.length; i++) {
                temporarioArray[i][0] = utilizadores[i][0];
                temporarioArray[i][1] = utilizadores[i][1];
                temporarioArray[i][2] = utilizadores[i][2];
                


            }

            System.out.print("Insira o Nome do Utilizador:");
            temporarioArray[temporarioArray.length - 1][0] = teclado.next();

            System.out.print("Insira o Número de Aluno:");
            temporarioArray[temporarioArray.length - 1][1] = teclado.next();
            System.out.print("Insira o Contacto de Aluno:");
            temporarioArray[temporarioArray.length - 1][2] = teclado.next();


            utilizadores = temporarioArray;


            do {
                System.out.println("Prima 1 para inserir um novo utilizador ou 0 para voltar.");
                numero = teclado.nextInt();

                if (numero != 0 && numero != 1) {
                    System.out.println("Apenas pode inserir 0 ou 1");
                    numero = 2;
                }

            } while (numero == 2);


        } while (numero != 0);
        GuardaArrayParaFicheiro(Ficheiro_utilizadores, utilizadores);
        Menu1();
    }


    public static void subMenu12() {
        int escolha;
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("----------------------------- Alterar Registo --------------------------------------");
        System.out.println("1 - Alterar Nome de Utilizador");
        System.out.println("2 - Alterar Nº de Aluno");
        System.out.println("3 - Alterar Contacto Aluno");

        escolha = teclado.nextInt();
        switch (escolha) {
            case 1:
                AlterarNome();

            case 2:
                AlterarNum();

            case 3:
                AlterarCont();
                break;
        }
        
    }

    public static void AlterarCont() {
        String utilizadorinicial;
        String alteracaoutilizador;


        
        System.out.println("Nome     | Nº de aluno | Contacto");
        for (int i = 0; i < utilizadores.length; i++) {
            if (utilizadores[i][0].compareToIgnoreCase("0") != 0)
                System.out.println(utilizadores[i][0] + "  | " + utilizadores[i][1] + "  | " + utilizadores[i][2]);
        }
        System.out.print("Insira o Número do Utilizador para alterar o Contacto do Aluno:");
        utilizadorinicial = teclado.next();
        for (int h = 0; h < utilizadores.length; h++) {
            if (utilizadorinicial.equals(utilizadores[h][1])) {

                System.out.print("Insira o Novo Contacto do Aluno:");
                alteracaoutilizador = teclado.next();


                utilizadores[h][2] = alteracaoutilizador;


            }
        }
        GuardaArrayParaFicheiro(Ficheiro_utilizadores, utilizadores);
        Menu1();
    }


    public static void AlterarNum() {

        String utilizadorinicial;
        String alteracaoutilizador;


        
        System.out.println("Nome     | Nº de aluno | Contacto");
        for (int i = 0; i < utilizadores.length; i++) {
            if (utilizadores[i][0].compareToIgnoreCase("0") != 0)
                System.out.println(utilizadores[i][0] + "  | " + utilizadores[i][1] + "  | " + utilizadores[i][2]);
        }
        System.out.print("Insira o Nome do Utilizador para alterar o Número do Aluno:");
        utilizadorinicial = teclado.next();
        for (int h = 0; h < utilizadores.length; h++) {
            if (utilizadorinicial.equals(utilizadores[h][0])) {

                System.out.print("Insira o Novo Número do Aluno:");
                alteracaoutilizador = teclado.next();

                utilizadores[h][1] = alteracaoutilizador;


            }
        }
        GuardaArrayParaFicheiro(Ficheiro_utilizadores, utilizadores);
        Menu1();
    }


    public static void AlterarNome() {

        String utilizadorinicial;
        String alteracaoutilizador;

        
        System.out.println("Nome     | Nº de aluno | Contacto");
        for (int i = 0; i < utilizadores.length; i++) {
            if (utilizadores[i][0].compareToIgnoreCase("0") != 0)
                System.out.println(utilizadores[i][0] + "  | " + utilizadores[i][1] + "  | " + utilizadores[i][2]);
        }
        System.out.print("Insira o Número de Aluno para alterar o Nome:");
        utilizadorinicial = teclado.next();
        for (int h = 0; h < utilizadores.length; h++) {
            if (utilizadorinicial.equals(utilizadores[h][1])) {

                System.out.print("Insira o Novo Nome do Aluno:");
                alteracaoutilizador = teclado.next();
                utilizadores[h][0] = alteracaoutilizador;
            }
        }
        GuardaArrayParaFicheiro(Ficheiro_utilizadores, utilizadores);
        Menu1();
    }


    public static void subMenu13() {
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("-------------------------- Remover Utilizador --------------------------------------");
       
        removeUtilizador();

       


    }

    public static void removeUtilizador() {
        String utilizadorpararemover;
        String temporarioArray[][] = new String[utilizadores.length - 1][3];


        System.out.println("Nome | Nº de aluno ");
        for (int i = 0; i < utilizadores.length; i++) {
            if (utilizadores[i][0].compareToIgnoreCase("0") != 0) {
                System.out.println(utilizadores[i][0] + "  | " + utilizadores[i][1] + "  | " + utilizadores[i][2]);
            }
        }
        System.out.print("Insira o Nome do Utilizador que pretende Remover:");
        utilizadorpararemover = teclado.next();
        int y = 0;
        for (int x = 0; x < utilizadores.length; x++) {
            if (utilizadores[x][0].equalsIgnoreCase(utilizadorpararemover)) {
                continue;
            }
            temporarioArray[y][0] = utilizadores[x][0];
            temporarioArray[y][1] = utilizadores[x][1];
            temporarioArray[y][2] = utilizadores[x][2];

            y++;
        }
        utilizadores = temporarioArray;

        GuardaArrayParaFicheiro(Ficheiro_utilizadores, utilizadores);

        Menu1();


    }


    public static void subMenu14() {
   
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("--------------------------- Consultar Utilizadores ---------------------------------");

                listarUtilizadores();
          

	}


   

    public static void listarUtilizadores() {
        int tamUtilizadores = utilizadores.length;


        for (int i = 0; i < tamUtilizadores; i++) {

            System.out.println(utilizadores[i][0] + "  : " + utilizadores[i][1] + "  : " + utilizadores[i][2]);

        }
        Menu1();


    }

   

    public static void Menu2() {
        int escolha;
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("---------------------------- Menu Livros/Revistas ----------------------------------");
        System.out.println(" 1 - Inserir Livro/Revista");
        System.out.println(" 2 - Alterar Livro/Revista");
        System.out.println(" 3 - Remover Livro/Revista");
        System.out.println(" 4 - Consultar Livros/Revista");
        System.out.println(" 5 - Menu Anterior");
        escolha = teclado.nextInt();
        switch (escolha) {
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
                MenuPrincipal();
            }
        }
    
    }

    public static void subMenu21() {

    	String str1;
		boolean sair=false;

		do {

			System.out.print("Indique [l] Adicionar Livro  [r] Adicionar Revista");
			str1 = teclado.next();

			if (str1.toLowerCase().equals("l")) { 
				CriarLivro();
			} else if (str1.toLowerCase().equals("r")) {
				CriarRevista();
			} else {
				System.out.print("Resposta não reconhecida");
			}
			
			if (str1.toLowerCase().equals("l")) sair=true;
			if(str1.toLowerCase().equals("r")) sair=true;
			
		} while (sair==false);
		
		


    }
    public static boolean isInteger( String input ) { 
        try { 
            Integer.parseInt( input );
            return true; 
        }
        catch( Exception e ) { 
            return false; 
        }
    } 

    public static void CriarLivro() 
    {
        int numero = 0;
        boolean erro;
        do {


            String temporarioArray[][] = new String[livros.length + 1][5];


            for (int i = 0; i < livros.length; i++) {
                temporarioArray[i][0] = livros[i][0];
                temporarioArray[i][1] = livros[i][1];
                temporarioArray[i][2] = livros[i][2];
                temporarioArray[i][3] = livros[i][3];
                temporarioArray[i][4] = livros[i][4];
            }
          
            System.out.print("Insira o Título:");
            temporarioArray[temporarioArray.length - 1][0] = teclado.next();

            System.out.print("Insira o Autor:");
            temporarioArray[temporarioArray.length - 1][1] = teclado.next();

            System.out.print("Insira a Editora:");
            temporarioArray[temporarioArray.length - 1][2] = teclado.next();
            do {
            	erro=false;
            System.out.print("Insira o Código:");
            temporarioArray[temporarioArray.length - 1][3] = teclado.next();
            if(isInteger(temporarioArray[temporarioArray.length - 1][3]))
            		{
            	 System.out.println("");
            		}
            else
            {
            	System.out.println("Apenas aceita Números!");
            	erro=true;
            }
            }while(erro==true);
            
            temporarioArray[temporarioArray.length - 1][4] = "Disponível";

            livros = temporarioArray;


            do {
                System.out.println("Prima 1 para inserir uma novo livro ou 0 para voltar.");
                numero = teclado.nextInt();

                if (numero != 0 && numero != 1) {
                    System.out.println("Apenas pode inserir 0 ou 1");
                    numero = 2;
                }

            } while (numero == 2);


        } while (numero != 0);
        GuardaArrayParaFicheiro(Ficheiro_livros, livros);
        Menu2();
    }
    public static void subMenu22() {
    	String str1;
		boolean sair=false;

		do {

			System.out.print("Indique [l] Alterar Livro  [r] Alterar Revista");
			str1 = teclado.next();

			if (str1.toLowerCase().equals("l")) { 
				AlterarLivro();
			} else if (str1.toLowerCase().equals("r")) {
				AlterarRevista();
			} else {
				System.out.print("Resposta não reconhecida");
			}
			
			if (str1.toLowerCase().equals("l")) sair=true;
			if(str1.toLowerCase().equals("r")) sair=true;
			
		} while (sair==false);
    	
    	
    }
    public static void AlterarLivro() {
        int escolha;
        
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("------------------------------   Alterar Livro  -----------------------------------");
        System.out.println("1 - Alterar Titulo");
        System.out.println("2 - Alterar Autor");
        System.out.println("3 - Alterar Editora");
        System.out.println("4 - Alterar Código");
        escolha = teclado.nextInt();
        switch (escolha) {
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

    public static void alterarTitulo() {
        String livroinicial;
        String alteracaolivro;

        
        System.out.println("Título     | Autor | Editora | Código");
        for (int i = 0; i < livros.length; i++) {
            if (livros[i][0].compareToIgnoreCase("0") != 0)
                System.out.println(livros[i][0] + "  | " + livros[i][1] + "  | " + livros[i][2] + "  | " + livros[i][3]);
        }
        System.out.print("Insira o Código do livro para alterar o Título:");
        livroinicial = teclado.next();
        for (int h = 0; h < livros.length; h++) {
            if (livroinicial.equals(livros[h][3])) {

                System.out.print("Insira o novo Título do livro:");
                alteracaolivro = teclado.next();
                livros[h][0] = alteracaolivro;
            }
        }
        GuardaArrayParaFicheiro(Ficheiro_livros, livros);
        Menu2();

    }

    public static void alterarAutor() {
        String livroinicial;
        String alteracaolivro;

        
        System.out.println("Título     | Autor | Editora | Código");
        for (int i = 0; i < livros.length; i++) {
            if (livros[i][0].compareToIgnoreCase("0") != 0)
                System.out.println(livros[i][0] + "  | " + livros[i][1] + "  | " + livros[i][2] + "  | " + livros[i][3]);
        }
        System.out.print("Insira o Código do Livro para alterar o Autor:");
        livroinicial = teclado.next();
        for (int h = 0; h < livros.length; h++) {
            if (livroinicial.equals(livros[h][3])) {

                System.out.println("Insira o novo Autor do Livro");
                alteracaolivro = teclado.next();
                livros[h][1] = alteracaolivro;
            }
        }
        GuardaArrayParaFicheiro(Ficheiro_livros, livros);
        Menu2();


    }

    public static void alterarEditora() {
        String livroinicial;
        String alteracaolivro;

        
        System.out.println("Título     | Autor | Editora | Código ");
        for (int i = 0; i < livros.length; i++) {
            if (livros[i][0].compareToIgnoreCase("0") != 0)
                System.out.println(livros[i][0] + "  | " + livros[i][1] + "  | " + livros[i][2] + "  | " + livros[i][3]);
        }
        System.out.print("Insira o Código do Livro para alterar a Editora:");
        livroinicial = teclado.next();
        for (int h = 0; h < livros.length; h++) {
            if (livroinicial.equals(livros[h][3])) {

                System.out.print("Insira a nova Editora do Livro:");
                alteracaolivro = teclado.next();
                livros[h][2] = alteracaolivro;
            }
        }
        GuardaArrayParaFicheiro(Ficheiro_livros, livros);
        Menu2();
    }

    public static void alterarCodigo() {
        String livroinicial;
        String alteracaolivro;

       
        System.out.println("Título     | Autor | Editora | Código");
        for (int i = 0; i < livros.length; i++) {
            if (livros[i][0].compareToIgnoreCase("0") != 0)
                System.out.println(livros[i][0] + "  | " + livros[i][1] + "  | " + livros[i][2] + "  | " + livros[i][3]);
            System.out.print("Insira o Título do Livro para alterar o Código:");
            livroinicial = teclado.next();
        for (int h = 0; h < livros.length; h++) {
            if (livroinicial.equals(livros[h][0])) {

                System.out.print("Insira o novo Código do Livro:");
                alteracaolivro = teclado.next();
                livros[h][3] = alteracaolivro;
            }
        }
        GuardaArrayParaFicheiro(Ficheiro_livros, livros);
        Menu2();
    }
    }
    public static void subMenu23() {
    	String str1;
		boolean sair=false;

		do {

			System.out.print("Indique [l] Eliminar Livro  [r] Eliminar Revista : ");
			str1 = teclado.next();

			if (str1.toLowerCase().equals("l")) {
				RemoverLivro();
			} else if (str1.toLowerCase().equals("r")) {
				RemoverRevista();
			} else {
				System.out.print("Resposta não reconhecida");
			}
			
			if (str1.toLowerCase().equals("l")) sair=true;
			if(str1.toLowerCase().equals("r")) sair=true;
			
		} while (sair==false);
    }

    public static void RemoverLivro() {
        String livropararemover;
        String temporarioArray[][] = new String[livros.length - 1][4];


        System.out.println(" Livros ");
        for (int i = 0; i < livros.length; i++) {
            if (livros[i][0].compareToIgnoreCase("0") != 0) {
                System.out.println(livros[i][0] + "  | " + livros[i][1] + "  | " + livros[i][2] + "  | " + livros[i][3]+ " | " +livros[i][4]);
            }
        }
        System.out.print("Insira o Nome do Livro que pretende Remover:");
        livropararemover = teclado.next();
        int y = 0;
        for (int x = 0; x < livros.length; x++) {
            if (livros[x][0].equalsIgnoreCase(livropararemover)) {
                continue;
            }
            temporarioArray[y][0] = livros[x][0];
            temporarioArray[y][1] = livros[x][1];
            temporarioArray[y][2] = livros[x][2];
            temporarioArray[y][3] = livros[x][3];
            temporarioArray[y][4] = livros[x][4];
            y++;
        }
        livros = temporarioArray;

        GuardaArrayParaFicheiro(Ficheiro_livros, livros);

        Menu2();


    }
    public static void subMenu24() {
    	String str1;
		boolean sair=false;

		do {

			System.out.print("Indique [l] Consultar Livro  [r] Consultar Revista");
			str1 = teclado.next();

			if (str1.toLowerCase().equals("l")) { // utilizador confirmou inserção do registo
				ConsultarLivro();
			} else if (str1.toLowerCase().equals("r")) {
				ConsultarRevista();
			} else {
				System.out.print("Resposta não reconhecida");
			}
			
			if (str1.toLowerCase().equals("l")) sair=true;
			if(str1.toLowerCase().equals("r")) sair=true;
			
		} while (sair==false);
		
    	
    	
    }
    public static void ConsultarLivro() {
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("------------------------------   Consultar Livro  -----------------------------------");
        listarLivro();
    }

    public static void listarLivro() {
        int tamlivros = livros.length;


        for (int i = 0; i < tamlivros; i++) {

            System.out.println(livros[i][0] + "  | " + livros[i][1] + "  | " + livros[i][2] + "  | " + livros[i][3]+ "  | " + livros[i][4]);

        }
        Menu2();


    }


   

    

    public static void CriarRevista() 
    {	boolean erro;
        int numero = 0;
        do {


            String temporarioArray[][] = new String[revistas.length + 1][4];


            for (int i = 0; i < revistas.length; i++) {
                temporarioArray[i][0] = revistas[i][0];
                temporarioArray[i][1] = revistas[i][1];
                temporarioArray[i][2] = revistas[i][2];
                temporarioArray[i][3] = revistas[i][3];
               


            }

            System.out.print("Insira o Título:");
            temporarioArray[temporarioArray.length - 1][0] = teclado.next();

            System.out.print("Insira a Data no Formato (DD/MM/AAAA):");
            temporarioArray[temporarioArray.length - 1][1] = teclado.next();

            do {
            	erro=false;
            	System.out.print("Insira o Código:");
                temporarioArray[temporarioArray.length - 1][2] = teclado.next();
            if(isInteger(temporarioArray[temporarioArray.length - 1][2]))
            		{
            	 System.out.println("");
            		}
            else
            {
            	System.out.println("Apenas aceita Números!");
            	erro=true;
            }
            }while(erro==true);
            
            temporarioArray[temporarioArray.length - 1][3] ="Disponível";
            

            revistas = temporarioArray;


            do {
                System.out.println("Prima 1 para inserir uma nova revista ou 0 para voltar.");
                numero = teclado.nextInt();

                if (numero != 0 && numero != 1) {
                    System.out.println("Apenas pode inserir 0 ou 1");
                    numero = 2;
                }

            } while (numero == 2);


        } while (numero != 0);
        GuardaArrayParaFicheiro(Ficheiro_revistas, revistas);
        Menu2();


    }


    public static void AlterarRevista() {
        int escolha;
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("-----------------------------   Alterar Revista  -----------------------------------");
        System.out.println("1 - Alterar o Título da Revista");
        System.out.println("2 - Alterar a Data da Revista");
        System.out.println("3 - Alterar o Código da Revista");


        escolha = teclado.nextInt();
        switch (escolha) {
            case 1:
                Alterartitulorev();

            case 2:
                Alterardatarev();

            case 3:
                Alterarcodigorev();
                break;
        }
    }

    public static void Alterartitulorev() {
        String tituloinicial;
        String alteracaotitulo;


        
        System.out.println("Titulo     | Data | Código");
        for (int i = 0; i < revistas.length; i++) {
            if (revistas[i][0].compareToIgnoreCase("0") != 0){
                System.out.println(revistas[i][0] + "  | " + revistas[i][1] + "  | " + revistas[i][2]);
            }
        }
        System.out.print("Insira o Código da Revista para alterar o Título:");
        tituloinicial = teclado.next();
        for (int h = 0; h < revistas.length; h++) {
            if (tituloinicial.equals(revistas[h][2])) {

                System.out.print("Insira o Novo Título:");
                alteracaotitulo = teclado.next();
                revistas[h][0] = alteracaotitulo;
            }
        }
        GuardaArrayParaFicheiro(Ficheiro_revistas, revistas);
        Menu2();
    }

    public static void Alterardatarev() {

        String datainicial;
        String alteracaodata;


        
        System.out.println("Titulo     | Data | Código");
        for (int i = 0; i < revistas.length; i++) {
            if (revistas[i][0].compareToIgnoreCase("0") != 0)
                System.out.println(revistas[i][0] + "  | " + revistas[i][1] + "  | " + revistas[i][2]);
        }
        System.out.print("Insira o Código da Revista para alterar a Data da Revista:");
        datainicial = teclado.next();
        for (int h = 0; h < revistas.length; h++) {
            if (datainicial.equals(revistas[h][2])) {

                System.out.print("Insira a Nova Data no Formato (DD/MM/AAAA):");
                alteracaodata = teclado.next();

                revistas[h][1] = alteracaodata;


            }
        }
        GuardaArrayParaFicheiro(Ficheiro_utilizadores, utilizadores);
        Menu2();
    }

    public static void Alterarcodigorev() {
        String codigoinicial;
        String alteracaocodigo;


        
        System.out.println("Titulo     | Data | Código");
        for (int i = 0; i < revistas.length; i++) {
            if (revistas[i][0].compareToIgnoreCase("0") != 0)
                System.out.println(revistas[i][0] + "  | " + revistas[i][1] + "  | " + revistas[i][2]);
        }
        System.out.print("Insira o Nome da Revista para alterar o Código:");
        codigoinicial = teclado.next();
        for (int h = 0; h < revistas.length; h++) {
            if (codigoinicial.equals(revistas[h][0])) {

                System.out.print("Insira o novo Código:");
                alteracaocodigo = teclado.next();


                revistas[h][2] = alteracaocodigo;


            }
        }
        GuardaArrayParaFicheiro(Ficheiro_utilizadores, utilizadores);
        Menu2();
    }

  

    public static void ConsultarRevista() {
  
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("----------------------------   Consultar Revista  -----------------------------------");

                listarRevistas();


        }

    public static void RemoverRevista() {
        String revistapararemover;
        String temporarioArray[][] = new String[revistas.length - 1][4];


        System.out.println("Titulo     | Data | Código | Disponibilidade ");
        for (int i = 0; i < revistas.length; i++) {
            if (revistas[i][0].compareToIgnoreCase("0") != 0) {
                System.out.println(revistas[i][0] + "  | " + revistas[i][1] + "  | " + revistas[i][2]+ "  |  "+ revistas[i][3]);
            }
        }
        System.out.print("Insira o Código da Revista que pretende Remover:");
        revistapararemover = teclado.next();
        int y = 0;
        for (int x = 0; x < revistas.length; x++) {
            if (revistas[x][2].equalsIgnoreCase(revistapararemover)) {
                continue;
            }
            temporarioArray[y][0] = revistas[x][0];
            temporarioArray[y][1] = revistas[x][1];
            temporarioArray[y][2] = revistas[x][2];
            temporarioArray[y][3] = revistas[x][3];
            

            y++;
        }
        revistas = temporarioArray;

        GuardaArrayParaFicheiro(Ficheiro_revistas, revistas);

        Menu2();

    }

    public static void listarRevistas() {
        int tamRevistas = revistas.length;


        for (int i = 0; i < tamRevistas; i++) {

            System.out.println(revistas[i][0] + "  | " + revistas[i][1] + "  | " + revistas[i][2]+ "  | " + revistas[i][3]);

        }
        Menu2();
    }



    public static void Menu3()
    {
        int escolha;
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("----------------------------------   Menu Alugueres ---------------------------------");
        System.out.println(" 1 - Inserir Aluguer");
        System.out.println(" 2 - Alterar Aluguer");
        System.out.println(" 3 - Remover Aluguer");
        System.out.println(" 4 - Consultar Aluguer");
        System.out.println(" 5 - Menu Anterior");
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
                MenuPrincipal();
            }
        }

    }
    public static void subMenu31()
    {String str1;
	boolean sair=false;

	do {

		System.out.print("Indique [l] Eliminar Livro  [r] Eliminar Revista : ");
		str1 = teclado.next();

		if (str1.toLowerCase().equals("l")) {
			AluguerLivros();
		} else if (str1.toLowerCase().equals("r")) {
			AluguerRevistas();
		} else {
			System.out.print("Resposta não reconhecida");
		}
		
		if (str1.toLowerCase().equals("l")) sair=true;
		if(str1.toLowerCase().equals("r")) sair=true;
		
	} while (sair==false);
        

    }
    public static void AluguerLivros(){
    String livro;
    String Utilizador;
    String datafim;
    String temporarioArray[][] = new String[alugueres.length + 1][2];
    boolean erro=false;
    for (int i = 0; i < revistas.length; i++) {
        temporarioArray[i][0] = alugueres[i][0];
        temporarioArray[i][1] = alugueres[i][1];
        temporarioArray[i][2] = alugueres[i][2];
  
       


    }

   
    
    int tamLivros = livros.length;
        for (int i = 0; i < tamLivros; i++) {
            System.out.println("LIVROS \n");
            System.out.println("Titulo -> " +livros[i][0] + " | Autor-> " + livros[i][1] + "  | Editora-> " + livros[i][2] + " | Código-> " + livros[i][3]);

        }
    do {    
    	if(erro==true)
    		System.out.println("Código do Livro não existe");
    	
    	erro=true;
     System.out.println("Insira o Código do Livro que pertende Alugar");
     livro = teclado.next();
     for (int i = 0; i < tamLivros; i++) {
         if(livro.equals(livros[i][3]))
         {
        	 temporarioArray[0][0]=livro;
        	 temporarioArray=alugueres;
        	 erro=false;
        	 
         }

     }
    }while(erro==true);
     
     
    int tutilizadores = utilizadores.length;
      for (int j = 0; j < tutilizadores; j++) {
            System.out.println("UTILIZADORES \n");
            System.out.println("Nome -> " +utilizadores[j][0] + " | Nº de Aluno-> " + utilizadores[j][1]);  
    
      }
      
      do {    
      	if(erro==true)
      		System.out.println("Numero de Utilizador não existe");
      	
      	erro=true;
       System.out.println("Insira o Numero de Utilizador");
       Utilizador= teclado.next();
       for (int i = 0; i < tutilizadores; i++) {
           if(Utilizador.equals(utilizadores[i][1]))
           {
          	
          	temporarioArray[0][1]=Utilizador;
          	temporarioArray=alugueres;
          	 erro=false;
          	 
           }

       }
      }while(erro==true);
     
      
      System.out.println("Insira a data de termino do aluguer");
      datafim=teclado.next();
     String mudar="Requesitado";
      for(int a=0; a<livros.length;a++) {
    	  if(livros[a][3]==livro) {
    		  livros[a][4]=mudar;    	  }
    	  
    	  
      }
     
      
      
      
      GuardaArrayParaFicheiro(Ficheiro_livros, livros);     
      GuardaArrayParaFicheiro(Ficheiro_alugueres, alugueres);
      Menu3();
      }
   
    public static void AluguerRevistas(){
        
    }
    
    public static void subMenu32()
    {
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("------------------------------  Alterar Aluguer  -----------------------------------");
    }

    public static void subMenu33()
    {
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("------------------------------  Remover Aluguer  -----------------------------------");
    }

    public static void subMenu34()
    {
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("----------------------------  Consultar Aluguer  -----------------------------------");
        listarAlugueres();
    }
    public static void listarAlugueres(){
        int tamAlug = alugueres.length;


        for (int i = 0; i < tamAlug; i++) {

            System.out.println(alugueres[i][0] + "  | " + alugueres[i][1] + "  | " + alugueres[i][2]);

        }
        Menu3();
    }
    
  

    
    public static void Menu4() {






    }

    public static void Menu5() {
        int escolha;
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("--------------------------        Menu Sair      -----------------------------------");
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