package dfj;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;

import java.io.FileWriter;
import java.io.IOException;

import java.util.Scanner;


public class trabalhofinal {
    //Variaveis gerais


    static Scanner teclado = new Scanner(System.in);
    static String sepChar = ";";  //Caracter de separação dos campos nos ficheiros de dados

    //variaveis Utilizadores
    static String user = "";


    static String FILENAME[] = new String[]{"Livros.dab", "Revistas.dab", "Utilizadores.dab", "Aluguereslivros.dab","Alugueresrevistas.dab"};

    static String[][] livros = new String[0][5];
    static String[][] revistas = new String[0][4];
    static String[][] utilizadores = new String[0][2];
    static String[][] aluguereslivros = new String[0][1];
    static String[][] alugueresrevistas = new String[0][1];
    static String Ficheiro_livros = "Livros.dab";
    static String Ficheiro_revistas = "Revistas.dab";
    static String Ficheiro_utilizadores = "Utilizadores.dab";
    static String Ficheiro_aluguereslivros = "Aluguereslivros.dab";
    static String Ficheiro_alugueresrevistas = "Alugueresrevistas.dab";
    static File ficheiro;


    public static void main(String[] args) {
        utilizadores = lerFicheiroUtilizadores();
        livros = lerFicheiroLivros();
        revistas =lerFicheiroRevistas();
        aluguereslivros= lerFicheiroAlugueres();
        alugueresrevistas=lerFicheiroAlugueresRevistas();

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
    System.out.print("Utilizador:");
    String username = input1.next();

    Scanner input2 = new Scanner(System.in);
    System.out.print("Password:");
    String password = input2.next();

    if (username.equals(Username) && password.equals(Password)) {

        System.out.println("Acesso Consedido");
    }

    else if (username.equals(Username)) {
        System.out.println(" Password Inválida");
    } else if (password.equals(Password)) {
        System.out.println("Utilizador Inválido");
    } else {
        System.out.println("Utilizador e Password Inválidos");
    }

}
 

    
    
    public static void criarFicheiros(String nome) {

        for (int i = 0; i < FILENAME.length; i++) {
            File ficheiro = new File(FILENAME[i]);
            if (!ficheiro.exists()) {
                msg(" A criar Ficheiros ... Aguarde");
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
            File ficheiro = new File(Ficheiro_aluguereslivros);

            if (!ficheiro.exists()) {
                ficheiro.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um outo durante a criação do ficheiro! [DEBUG: " + e.getMessage() + "]");
            System.out.println("Tente de novo!");
            lerFicheiroUtilizadores();
        }
        try {
            File file = new File(Ficheiro_aluguereslivros);
            Scanner sc1 = new Scanner(file);

            int numLinhas = 0;
            while (sc1.hasNextLine()) {
                numLinhas++;
                sc1.nextLine();
            }
            sc1.close();

            sc1 = new Scanner(file);

            aluguereslivros = new String[numLinhas][2];

            for (int i = 0; sc1.hasNextLine(); i++) {
                String line = sc1.nextLine();
                aluguereslivros[i][0] = String.valueOf((line.split(";")[0]));
                aluguereslivros[i][1] = String.valueOf((line.split(";")[1]));
                

            }
            sc1.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ocorreu um outo durante a leitura do ficheiro! [DEBUG: " + e.getMessage() + "]");
        }

        return aluguereslivros;
    }
   public static String[][] lerFicheiroAlugueresRevistas() {

       try {
           File ficheiro = new File(Ficheiro_alugueresrevistas);

           if (!ficheiro.exists()) {
               ficheiro.createNewFile();
           }
       } catch (IOException e) {
           System.out.println("Ocorreu um outo durante a criação do ficheiro! [DEBUG: " + e.getMessage() + "]");
           System.out.println("Tente de novo!");
           lerFicheiroUtilizadores();
       }
       try {
           File file = new File(Ficheiro_alugueresrevistas);
           Scanner sc1 = new Scanner(file);

           int numLinhas = 0;
           while (sc1.hasNextLine()) {
               numLinhas++;
               sc1.nextLine();
           }
           sc1.close();

           sc1 = new Scanner(file);

           alugueresrevistas = new String[numLinhas][2];

           for (int i = 0; sc1.hasNextLine(); i++) {
               String line = sc1.nextLine();
               alugueresrevistas[i][0] = String.valueOf((line.split(";")[0]));
               alugueresrevistas[i][1] = String.valueOf((line.split(";")[1]));

           }
           sc1.close();
       } catch (FileNotFoundException e) {
           System.out.println("Ocorreu um outo durante a leitura do ficheiro! [DEBUG: " + e.getMessage() + "]");
       }

       return alugueresrevistas;
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
    public static boolean isInteger( String input ) { 
        try { 
            Integer.parseInt( input );
            return true; 
        }
        catch( Exception e ) { 
            return false; 
        }
    } 

    static void msg(String msg) {
        System.out.println(msg);
    }


    public static void MenuPrincipal() {
        int escolha;
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("\t\t\t\t ** DFJ DEVELOPEMENT ** \n \n");

        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("\t\t\t\t ** BEM VINDO ** ");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("1 - Menu Utilizador ");
        System.out.println("2 - Menu Livros ");
        System.out.println("3 - Menu Revistas ");
        System.out.println("4 - Menu Alugueres ");
        System.out.println("5 - Menu Estatistica");
        System.out.println("6 - Sair");
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
            case 6: {
                Menu6();
                break;
            }
        }

    }


    public static void Menu1() {
        int escolha;
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("--------------------------     Menu Utilizadores -----------------------------------");
        System.out.println(" 1 - Criar Utilizador");
        System.out.println(" 2 - Alterar Registo de Utilizador");
        System.out.println(" 3 - Remover Utilizador");
        System.out.println(" 4 - Consultar Utilizadores");
        System.out.println(" 5 - Menu Anterior");
        escolha = teclado.nextInt();
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


    }

    public static void subMenu11() {

        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("-------------------------   Criar Utilizadores  -----------------------------------");
        CriarUtilizador();


    }

    private static void CriarUtilizador() {
    	int numero = 0;
    	boolean erro;
        do {


            String temporarioArray[][] = new String[utilizadores.length + 1][3];


            for (int i = 0; i < utilizadores.length; i++) {
                temporarioArray[i][0] = utilizadores[i][0];
                temporarioArray[i][1] = utilizadores[i][1];
                temporarioArray[i][2] = utilizadores[i][2];
                


            }

            System.out.print("Insira o Nome do Utilizador:");
            temporarioArray[temporarioArray.length - 1][0] = teclado.next();
            do {
             	erro=false;
            System.out.print("Insira o Número de Aluno:");
            temporarioArray[temporarioArray.length - 1][1] = teclado.next();
            if(isInteger(temporarioArray[temporarioArray.length - 1][1]))
     		{
     	 System.out.print("");
     		}
     else
     {
     	System.out.println("Apenas aceita Números!");
     	erro=true;
     }
     }while(erro==true);
            
            do {
             	erro=false;
            System.out.print("Insira o Contacto de Aluno:");
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


        System.out.println("Nome     | Nº de aluno | Contacto");
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

        System.out.println("Nome     | Nº de aluno | Contacto");
        for (int i = 0; i < tamUtilizadores; i++) {
        	 
            System.out.println(utilizadores[i][0] + "  : " + utilizadores[i][1] + "  : " + utilizadores[i][2]);

        }
        Menu1();


    }

  

    public static void Menu2() {
        int escolha;
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("----------------------------------   Menu Livros -----------------------------------");
        System.out.println(" 1 - Inserir Livro");
        System.out.println(" 2 - Alterar Livro");
        System.out.println(" 3 - Remover Livro");
        System.out.println(" 4 - Consultar Livros");
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
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("------------------------------   Inserir Livro  -----------------------------------");
        CriarLivro();


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
            if (livros[i][0].compareToIgnoreCase("0") != 0) {
                System.out.println(livros[i][0] + "  | " + livros[i][1] + "  | " + livros[i][2] + "  | " + livros[i][3]);
            }
        }
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
    public static void subMenu23() {
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("------------------------------   Remover Livro  -----------------------------------");
        RemoverLivro();
    }

    public static void RemoverLivro() {
    	String livropararemover;
        String temporarioArray[][] = new String[livros.length - 1][5];


        System.out.println(" Titulo  | Autor | Editora | Código | Disponibilidade ");
        for (int i = 0; i < livros.length; i++) {
            if (livros[i][0].compareToIgnoreCase("0") != 0) {
                System.out.println(livros[i][0] + "  | " + livros[i][1] + "  | " + livros[i][2] + "  | " + livros[i][3]+ " | " +livros[i][4]);
            }
        }
        System.out.print("Insira o Código do Livro que pretende Remover:");
        livropararemover = teclado.next();
        int y = 0;
        for (int x = 0; x < livros.length; x++) {
            if (livros[x][3].equalsIgnoreCase(livropararemover)) {
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
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("------------------------------   Consultar Livro  -----------------------------------");
        listarLivro();
    }

    public static void listarLivro() {
        int tamlivros = livros.length;

        System.out.println(" Titulo  | Autor | Editora | Código | Disponibilidade ");
        for (int i = 0; i < tamlivros; i++) {

            System.out.println(livros[i][0] + "  | " + livros[i][1] + "  | " + livros[i][2] + "  | " + livros[i][3]+ " | " +livros[i][4]);

        }
        Menu2();


    }

   
    public static void Menu3() {
        int escolha;
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("----------------------------------   Menu Revistas ---------------------------------");
        System.out.println(" 1 - Inserir Revista");
        System.out.println(" 2 - Alterar Revista");
        System.out.println(" 3 - Remover Revista");
        System.out.println(" 4 - Consultar Revista");
        System.out.println(" 5 - Menu Anterior");
        escolha = teclado.nextInt();
        switch (escolha) {
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

    public static void subMenu31() {

        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("-----------------------------   Inserir Revista  -----------------------------------");
        criarRevista();


    }

    public static void criarRevista() 
    {
    	boolean erro;
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
        Menu3();
    }


    public static void subMenu32() {
        int escolha;
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("-----------------------------   Alterar Revista  -----------------------------------");
        System.out.println("1 - Alterar o titulo da revista ");
        System.out.println("2 - Alterar data da revista");
        System.out.println("3 - Alterar código da revista");


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
        Menu3();
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
        Menu3();
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
        Menu3();
    }

    public static void subMenu33() {
  
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("------------------------------   Remover Revista  -----------------------------------");
        System.out.println("1 - Remover Revistas");
        System.out.println("2 - Voltar Menu Anterior");
       
                removeRevistas();


    }

    public static void subMenu34() {
       
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("----------------------------   Consultar Revista  -----------------------------------");
       
      
                listarRevistas();
       
    }

    public static void removeRevistas() {
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

        Menu3();

    }

    public static void listarRevistas() {
        int tamRevistas = revistas.length;

        System.out.println("Titulo     | Data | Código | Disponibilidade");
        for (int i = 0; i < tamRevistas; i++) {
        	
            System.out.println(revistas[i][0] + "  | " + revistas[i][1] + "  | " + revistas[i][2]+ "  |  "+ revistas[i][3]);

        }
        Menu3();
    }

    public static void Menu4()
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
                MenuPrincipal();
            }
        }
    }
    public static void subMenu41()
    {
        int escolha;
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("-----------------------------   Inserir Aluguer  -----------------------------------");
        System.out.println(" 1 - Aluguer de Livros");
        System.out.println(" 2 - Aluguer de Revistas");
        escolha =teclado.nextInt();
        switch(escolha)
        {
            case 1:
                aluguerLivros();
                
            case 2:
                aluguerRevistas();

        }

    }
    public static void aluguerLivros()
    {
    	   int numero = 0;
    	   
    	    
    	    
    	    do {
    	    	String temporarioArray[][] = new String[aluguereslivros.length + 1][2];
    	    	for (int i = 0; i < aluguereslivros.length; i++) {
    	            temporarioArray[i][0] = aluguereslivros[i][0];
    	            temporarioArray[i][1] = aluguereslivros[i][1]; }
    	    	
    	    boolean erro=false;
    	  
    	        for (int i = 0; i < livros.length; i++) {
    	        	if(livros[i][0].compareToIgnoreCase("0") != 0){
    	        	System.out.println("LIVRO:");
    	            System.out.println("Titulo -> " +livros[i][0] + " | Autor-> " + livros[i][1] + "  | Editora-> " + livros[i][2] + " | Código-> " + livros[i][3]);
    	        	}
    	        }
    	    do {    
    	    	if(erro==true)
    	    		System.out.println("Código do Livro não existe");
    	    	
    	    	erro=true;
    	     System.out.print("Insira o Código do Livro que pertende Alugar:");
    	     temporarioArray[temporarioArray.length - 1][0] = teclado.next();
    	     
    	     for (int i = 0; i < livros.length; i++) {
    	         if(temporarioArray[temporarioArray.length - 1][0].equals(livros[i][3]))
    	         {
    	        	 System.out.println("Código Aceite");
    	        	 erro=false;
    	        	 
    	         }

    	     }
    	    }while(erro==true);
    	      
    	      System.out.print("Insira a Data de Termino no Formato (DD/MM/AAAA):");
    	      temporarioArray[temporarioArray.length - 1][1] = teclado.next();
    	   
    	      String mudar="Requesitado";
    	      for(int a=0; a<livros.length;a++) {
    		 for(int b=0;b<temporarioArray.length;b++){
    	    	  if(livros[a][3].compareTo(temporarioArray[b][0])==0) {
    	    		  livros[a][4]=mudar;    
    	    		  }
    	    	  
    	    	  }
    	      }
    	      aluguereslivros = temporarioArray;
    	      do {
    	          System.out.println("Prima 1 para inserir um novo aluguer ou 0 para voltar.");
    	          numero = teclado.nextInt();

    	          if (numero != 0 && numero != 1) {
    	              System.out.println("Apenas pode inserir 0 ou 1");
    	              numero = 2;
    	          }

    	      } while (numero == 2);
    	} while (numero != 0);
    	     
    	      
    	      
    	    	GuardaArrayParaFicheiro(Ficheiro_aluguereslivros, aluguereslivros);
    	    	GuardaArrayParaFicheiro(Ficheiro_livros, livros);
    	         
    	     
    	      Menu4();
    }
    public static void aluguerRevistas()
    {
    	  int numero = 0;
    	  
  	    
  	    
  	    do {
  	    	String temporarioArray[][] = new String[aluguereslivros.length + 1][2];
  	    	
  	    	for (int i = 0; i < alugueresrevistas.length; i++) {
  	            temporarioArray[i][0] = alugueresrevistas[i][0];
  	            temporarioArray[i][1] = alugueresrevistas[i][1]; }
  	    	
  	    boolean erro=false;
  	  
  	        for (int i = 0; i < revistas.length; i++) {
  	        	if(revistas[i][0].compareToIgnoreCase("0") != 0){
  	        	System.out.println("REVISTA:");
  	            System.out.println("Titulo -> " +revistas[i][0] + " | Data-> " + revistas[i][1] + "  | Código-> " + revistas[i][2]);
  	        	}
  	        }
  	    do {    
  	    	if(erro==true)
  	    		System.out.println("Código da revista não existe");
  	    	
  	    	erro=true;
  	     System.out.print("Insira o Código da Revista que pertende Alugar:");
  	     temporarioArray[temporarioArray.length - 1][0] = teclado.next();
  	     
  	     for (int i = 0; i < revistas.length; i++) {
  	         if(temporarioArray[temporarioArray.length - 1][0].equals(revistas[i][2]))
  	         {
  	        	 System.out.println("Código Aceite");
  	        	 erro=false;
  	        	 
  	         }

  	     }
  	    }while(erro==true);
  	      
  	      System.out.print("Insira a Data de Termino no Formato (DD/MM/AAAA):");
  	      temporarioArray[temporarioArray.length - 1][1] = teclado.next();
  	      
  	    String mudar="Requesitada";
	      for(int a=0; a<revistas.length;a++) {
		for(int b=0;b<temporarioArray.length;b++){
		if(temporarioArray[b][0] != null){
	    	  if(revistas[a][2].compareTo(temporarioArray[b][0])==0) {
	    		  revistas[a][3]=mudar;    
	    		  }
	    	  
	    	  }
	      }
	      }
  	    alugueresrevistas = temporarioArray;
  	      do {
  	          System.out.println("Prima 1 para inserir um novo aluguer ou 0 para voltar.");
  	          numero = teclado.nextInt();

  	          if (numero != 0 && numero != 1) {
  	              System.out.println("Apenas pode inserir 0 ou 1");
  	              numero = 2;
  	          }

  	      } while (numero == 2);
  	} while (numero != 0);
  	     
  	    
  	      
  	    	GuardaArrayParaFicheiro(Ficheiro_alugueresrevistas, alugueresrevistas);
  	    	GuardaArrayParaFicheiro(Ficheiro_revistas, revistas);
  	         
  	     
  	      Menu4();
    	
    	
        
    }
    
    public static void subMenu42()
    {int escolha;
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("------------------------------  Alterar Aluguer  -----------------------------------");
        System.out.println(" 1 -  Livro");
        System.out.println(" 2 - Revista");
        escolha = teclado.nextInt();
        switch(escolha)
        {
            case 1: {
            	AltAlugueresLivro();
                break;
            }
            case 2: {
            	AltAlugueresRevista();
                break;
            }
        }
    
    
    }

    public static void AltAlugueresLivro() {
    	String codigo;
        String alteracaodata;
        System.out.println("Código Livro| Data");
        for (int i = 0; i <aluguereslivros.length; i++) {
            if (aluguereslivros[i][0].compareToIgnoreCase("0") != 0){
                System.out.println(aluguereslivros[i][0] + "  | " + aluguereslivros[i][1]);
            }
        }
        System.out.print("Insira o Código do Livro para alterar a Data:");
        codigo = teclado.next();
        for (int h = 0; h < aluguereslivros.length; h++) {
            if (codigo.equals(aluguereslivros[h][0])) {

                System.out.print("Insira a nova Data de Termino:");
                alteracaodata = teclado.next();
                aluguereslivros[h][1] = alteracaodata;
            }
        }
        GuardaArrayParaFicheiro(Ficheiro_aluguereslivros,aluguereslivros);
        Menu4();
    	
    	
		
	}
    public static void AltAlugueresRevista() {
    	
    	String codigo;
        String alteracaodata;
        System.out.println("Código Revista  | Data");
        for (int i = 0; i <alugueresrevistas.length; i++) {
            if (alugueresrevistas[i][0].compareToIgnoreCase("0") != 0){
                System.out.println(alugueresrevistas[i][0] + "  | " + alugueresrevistas[i][1]);
            }
        }
        System.out.print("Insira o Código da Revista para alterar a Data:");
        codigo = teclado.next();
        for (int h = 0; h < alugueresrevistas.length; h++) {
            if (codigo.equals(alugueresrevistas[h][0])) {

                System.out.print("Insira a nova Data de Termino:");
                alteracaodata = teclado.next();
                alugueresrevistas[h][1] = alteracaodata;
            }
        }
        GuardaArrayParaFicheiro(Ficheiro_alugueresrevistas,alugueresrevistas);
        Menu4();
    	
		
	}
	public static void subMenu43()
    {
    	int escolha;
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("------------------------------  Remover Aluguer  -----------------------------------");
        System.out.println(" 1 -  Livro");
        System.out.println(" 2 - Revista");
        escolha = teclado.nextInt();
        switch(escolha)
        {
            case 1: {
            	ReAlugueresLivro();
                break;
            }
            case 2: {
            	ReAlugueresRevista();
                break;
            }
        }
    }

    public static void ReAlugueresLivro() {
    	String aluguerpararemover;
        String temporarioArray[][] = new String[aluguereslivros.length - 1][2];


        System.out.println("Codigo Livro| Data de Fim de Aluguer");
        for (int i = 0; i < aluguereslivros.length; i++) {
            if (aluguereslivros[i][0].compareToIgnoreCase("0") != 0) {
                System.out.println(aluguereslivros[i][0] + "  | " + aluguereslivros[i][1]);
            }
        }
        System.out.print("Insira o Código da Revista que pretende Remover:");
        aluguerpararemover = teclado.next();
        int y = 0;
        for (int x = 0; x < aluguereslivros.length; x++) {
            if (aluguereslivros[x][0].equalsIgnoreCase(aluguerpararemover)) {
                continue;
            }
            temporarioArray[y][0] = aluguereslivros[x][0];
            temporarioArray[y][1] = aluguereslivros[x][1];
           
            

            y++;
        }
        aluguereslivros = temporarioArray;

        GuardaArrayParaFicheiro(Ficheiro_aluguereslivros, aluguereslivros);

        Menu4();
    	
    	
    	
		
	}
	public static void ReAlugueresRevista() {
		String aluguerpararemover;
        String temporarioArray[][] = new String[alugueresrevistas.length - 1][2];


        System.out.println("Codigo Revista| Data de Fim de Aluguer");
        for (int i = 0; i < alugueresrevistas.length; i++) {
            if (alugueresrevistas[i][0].compareToIgnoreCase("0") != 0) {
                System.out.println(alugueresrevistas[i][0] + "  | " + alugueresrevistas[i][1]);
            }
        }
        System.out.print("Insira o Código da Revista que pretende Remover:");
        aluguerpararemover = teclado.next();
        int y = 0;
        for (int x = 0; x < alugueresrevistas.length; x++) {
            if (alugueresrevistas[x][0].equalsIgnoreCase(aluguerpararemover)) {
                continue;
            }
            temporarioArray[y][0] = alugueresrevistas[x][0];
            temporarioArray[y][1] = alugueresrevistas[x][1];
           
            

            y++;
        }
        alugueresrevistas = temporarioArray;

        GuardaArrayParaFicheiro(Ficheiro_alugueresrevistas, alugueresrevistas);

        Menu4();
		
		
	}
	public static void subMenu44()
    {
    	int escolha;
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("----------------------------  Consultar Aluguer  -----------------------------------");
        System.out.println(" 1 -  Livro");
        System.out.println(" 2 - Revista");
        
        
        escolha = teclado.nextInt();
        switch(escolha)
        {
            case 1: {
            	listarAlugueresLivro();
                break;
            }
            case 2: {
            	listarAlugueresRevista();
                break;
            }
        }
       
    }
    public static void listarAlugueresLivro(){
        int tamAlug = aluguereslivros.length;

        System.out.println("Código Livro | Data de Termino");
        for (int i = 0; i < tamAlug; i++) {
        	
            System.out.println(aluguereslivros[i][0] + "  | " + aluguereslivros[i][1] );

        }
        Menu4();
    }
    
    public static void listarAlugueresRevista(){
        int tamAlug = alugueresrevistas.length;

        System.out.println("Código Revista | Data de Termino");
        for (int i = 0; i < tamAlug; i++) {
        	
            System.out.println(alugueresrevistas[i][0] + "  | " + alugueresrevistas[i][1] );

        }
        Menu4();
    }
    
    public static void Menu5() {
    	int escolha;
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("----------------------------------   Menu Estatística ---------------------------------");
        System.out.println(" 1 - Disponibilidade Livro/Revista");
        System.out.println(" 2 - Contato do Utilizador");
        System.out.println(" 3 - Datas de Aluguer");
        System.out.println(" 4 - Menu Anterior");
        escolha = teclado.nextInt();
        switch(escolha)
        {
            case 1: {
                subMenu51();
                break;
            }
            case 2: {
                subMenu52();
                break;
            }
            case 3: {
                subMenu53();
            }
            case 4: {
            	MenuPrincipal();
            }
            }
        
    }
        
        public static void subMenu51() {
        	int escolha;
        
        	System.out.println("------------------------------------------------------------------------------------");
            System.out.println("---------------------------------- Disponibilidade ---------------------------------");
            System.out.println(" 1 -  Livro");
            System.out.println(" 2 - Revista");
            
            
            escolha = teclado.nextInt();
            switch(escolha)
            {
                case 1: {
                	DisLivro();
                    break;
                }
                case 2: {
                	DisRevista();
                    break;
                }
            }
               
        }
        
            public static void DisLivro() {
            	int tamlivros = livros.length;

            	System.out.println("Disponibilidade");
                for (int i = 0; i < tamlivros; i++) {
                	
                    System.out.println(livros[i][0]+"|"+livros[i][4]);

                }
                Menu5();
            }
            
            public static void DisRevista(){
            	int tamrevistas = revistas.length;

            	System.out.println("Disponibilidade");
                for (int i = 0; i < tamrevistas; i++) {
                	
                    System.out.println(revistas[i][0]+"|"+revistas[i][3]);

                }
                Menu5();
            }
        
        
        public static void subMenu52() {
        	int tamUtilizadores = utilizadores.length;

        		System.out.println("  Contacto");
            for (int i = 0; i < tamUtilizadores; i++) {
            	
                System.out.println(utilizadores[i][1]+"|"+utilizadores[i][2]);

            }
            Menu5();
        }
        
        public static void subMenu53() {
        	int escolha;
            
        	System.out.println("------------------------------------------------------------------------------------");
            System.out.println("--------------------------------------  Data  --------------------------------------");
            System.out.println(" 1 -  Livro");
            System.out.println(" 2 - Revista");
            
            
            escolha = teclado.nextInt();
            switch(escolha)
            {
                case 1: {
                	Dalivro();
                    break;
                }
                case 2: {
                	DaRevista();
                    break;
                }
            }
        
        
        
        }
        
        
        
        public static void Dalivro(){
    		int tamdatali = aluguereslivros.length;

    		System.out.println("    Data");
            for (int i = 0; i < tamdatali; i++) {
            	
                System.out.println(aluguereslivros[i][0]+"|"+aluguereslivros[i][1]);

            }
    		
    	Menu5();	
    	}
        public static void DaRevista(){
    		
    		int tamdatare = alugueresrevistas.length;

    		System.out.println("     Data");
            for (int i = 0; i < tamdatare; i++) {
            	
                System.out.println(alugueresrevistas[i][0]+"|"+alugueresrevistas[i][1]);
                }
    		
    	Menu5();	
    	}

    public static void Menu6() {
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