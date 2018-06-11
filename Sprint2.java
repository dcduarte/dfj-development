/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sprint2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;
import javafx.scene.control.PasswordField;
import javax.swing.JPasswordField;

public class Sprint2 {
    //Variaveis gerais


    static Scanner teclado = new Scanner(System.in);
    static String sepChar = ";";  //Caracter de separação dos campos nos ficheiros de dados

    //variaveis Utilizadores
    static String user = "";


    static String FILENAME[] = new String[]{"Livros.dab", "Revistas.dab", "Utilizadores.dab", "Alugueres.dab"};

    static String[][] livros = new String[0][5];
    static String[][] revistas = new String[0][4];
    static String[][] utilizadores = new String[0][2];
    static String[][] alugueres = new String[0][3];
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
    System.out.println("Enter Username : ");
    String username = input1.next();

    Scanner input2 = new Scanner(System.in);
    System.out.println("Enter Password : ");
    String password = input2.next();

    if (username.equals(Username) && password.equals(Password)) {

        System.out.println("Access Granted! Welcome!");
    }

    else if (username.equals(Username)) {
        System.out.println("Invalid Password!");
    } else if (password.equals(Password)) {
        System.out.println("Invalid Username!");
    } else {
        System.out.println("Invalid Username & Password!");
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

            revistas = new String[numLinhas][3];

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
                subMenu15();
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
        do {


            String temporarioArray[][] = new String[utilizadores.length + 1][3];


            for (int i = 0; i < utilizadores.length; i++) {
                temporarioArray[i][0] = utilizadores[i][0];
                temporarioArray[i][1] = utilizadores[i][1];
                temporarioArray[i][2] = utilizadores[i][2];
                


            }

            System.out.println("Insira o nome do utilizador");
            temporarioArray[temporarioArray.length - 1][0] = teclado.next();

            System.out.println("Insira o número de Aluno");
            temporarioArray[temporarioArray.length - 1][1] = teclado.next();
            System.out.println("Insira o contacto de Aluno");
            temporarioArray[temporarioArray.length - 1][2] = teclado.next();


            utilizadores = temporarioArray;


            do {
                System.out.println("Prima 1 para inserir uma novo utilizador ou 0 para voltar.");
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
        System.out.println("1 - Alterar nome de utilizador");
        System.out.println("2 - Alterar nº de aluno");
        System.out.println("3 - Alterar contacto aluno");


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


        System.out.println("Insira o numero do utilizador para alterar o contacto de aluno");
        System.out.println("Nome     | Nº de aluno | Contacto");
        for (int i = 0; i < utilizadores.length; i++) {
            if (utilizadores[i][0].compareToIgnoreCase("0") != 0)
                System.out.println(utilizadores[i][0] + "  | " + utilizadores[i][1] + "  | " + utilizadores[i][2]);
        }
        utilizadorinicial = teclado.next();
        for (int h = 0; h < utilizadores.length; h++) {
            if (utilizadorinicial.equals(utilizadores[h][1])) {

                System.out.println("Insira o novo contacto de aluno");
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


        System.out.println("Insira o nome do utilizador para alterar o numero de aluno");
        System.out.println("Nome     | Nº de aluno | Contacto");
        for (int i = 0; i < utilizadores.length; i++) {
            if (utilizadores[i][0].compareToIgnoreCase("0") != 0)
                System.out.println(utilizadores[i][0] + "  | " + utilizadores[i][1] + "  | " + utilizadores[i][2]);
        }
        utilizadorinicial = teclado.next();
        for (int h = 0; h < utilizadores.length; h++) {
            if (utilizadorinicial.equals(utilizadores[h][0])) {

                System.out.println("Insira o novo numero de aluno");
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

        System.out.println("Insira o numero de aluno para alterar o nome");
        System.out.println("Nome     | Nº de aluno | Contacto");
        for (int i = 0; i < utilizadores.length; i++) {
            if (utilizadores[i][0].compareToIgnoreCase("0") != 0)
                System.out.println(utilizadores[i][0] + "  | " + utilizadores[i][1] + "  | " + utilizadores[i][2]);
        }
        utilizadorinicial = teclado.next();
        for (int h = 0; h < utilizadores.length; h++) {
            if (utilizadorinicial.equals(utilizadores[h][1])) {

                System.out.println("Insira o novo nome de aluno");
                alteracaoutilizador = teclado.next();
                utilizadores[h][0] = alteracaoutilizador;
            }
        }
        GuardaArrayParaFicheiro(Ficheiro_utilizadores, utilizadores);
        Menu1();
    }


    public static void subMenu13() {
        int escolha;
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("-------------------------- Remover Utilizador --------------------------------------");
        System.out.println("1 - Remover Utilizadores");
        System.out.println("2 - Voltar Menu Anterior");
        escolha = teclado.nextInt();
        switch (escolha) {
            case 1:
                removeUtilizador();
                break;
            case 2:
                Menu1();


        }


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
        System.out.println("Insira o nome do utilizador que pretende remover?");
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

        subMenu13();


    }


    public static void subMenu14() {
        int escolha;
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("--------------------------- Consultar Utilizadores ---------------------------------");
        System.out.println("1 - Consultar Utilizadores no Sistema");
        System.out.println("2 - Voltar Menu Anterior");
        escolha = teclado.nextInt();
        switch (escolha) {
            case 1:
                listarUtilizadores();
                break;
            case 2:
                Menu1();
                break;

        }


    }

    public static void listarUtilizadores() {
        int tamUtilizadores = utilizadores.length;


        for (int i = 0; i < tamUtilizadores; i++) {

            System.out.println(utilizadores[i][0] + "  : " + utilizadores[i][1] + "  : " + utilizadores[i][2]);

        }
        subMenu14();


    }

    public static void subMenu15() {
        int escolha;
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("--------------------------------- SAIR ---------------------------------------------");
        System.out.println("1 - Voltar ao Menu principal");
        System.out.println("2 - Menu Utilizadores ");
        escolha = teclado.nextInt();
        switch (escolha) {
            case 1:
                MenuPrincipal();
                break;
            case 2:
                Menu1();
                break;


        }
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
                subMenu25();
            }
        }


    }

    public static void subMenu21() {
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("------------------------------   Inserir Livro  -----------------------------------");
        CriarLivro();


    }

    public static void CriarLivro() // alterar
    {
        int numero = 0;
        do {


            String temporarioArray[][] = new String[livros.length + 1][5];


            for (int i = 0; i < livros.length; i++) {
                temporarioArray[i][0] = livros[i][0];
                temporarioArray[i][1] = livros[i][1];
                temporarioArray[i][2] = livros[i][2];
                temporarioArray[i][3] = livros[i][3];
                temporarioArray[i][4] = livros[i][4];
                
               


            }
          
            System.out.println("Titulo");
            temporarioArray[temporarioArray.length - 1][0] = teclado.next();

            System.out.println("Autor");
            temporarioArray[temporarioArray.length - 1][1] = teclado.next();

            System.out.println("Editora");
            temporarioArray[temporarioArray.length - 1][2] = teclado.next();

            System.out.println("Código");
            temporarioArray[temporarioArray.length - 1][3] = teclado.next();
            
            System.out.println("Disponibilidade (Ativo|Inativo");
            temporarioArray[temporarioArray.length - 1][4] = teclado.next();


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

        System.out.println("Insira o Código do livro para alterar o Título");
        System.out.println("Título     | Autor | Editora | Código  | Disponibilidade");
        for (int i = 0; i < livros.length; i++) {
            if (livros[i][0].compareToIgnoreCase("0") != 0)
                System.out.println(livros[i][0] + "  | " + livros[i][1] + "  | " + livros[i][2] + "  | " + livros[i][3]+ " | " +livros[i][4]);
        }
        livroinicial = teclado.next();
        for (int h = 0; h < livros.length; h++) {
            if (livroinicial.equals(livros[h][3])) {

                System.out.println("Insira o novo Título do livro");
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

        System.out.println("Insira o Código do livro para alterar o Autor");
        System.out.println("Título     | Autor | Editora | Código | Disponibilidade");
        for (int i = 0; i < livros.length; i++) {
            if (livros[i][0].compareToIgnoreCase("0") != 0)
                System.out.println(livros[i][0] + "  | " + livros[i][1] + "  | " + livros[i][2] + "  | " + livros[i][3]+ " | " +livros[i][4]);
        }
        livroinicial = teclado.next();
        for (int h = 0; h < livros.length; h++) {
            if (livroinicial.equals(livros[h][3])) {

                System.out.println("Insira o novo Autor do livro");
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

        System.out.println("Insira o Código do livro para alterar a Editora");
        System.out.println("Título     | Autor | Editora | Código");
        for (int i = 0; i < livros.length; i++) {
            if (livros[i][0].compareToIgnoreCase("0") != 0)
                System.out.println(livros[i][0] + "  | " + livros[i][1] + "  | " + livros[i][2] + "  | " + livros[i][3]+ " | " +livros[i][4]);
        }
        livroinicial = teclado.next();
        for (int h = 0; h < livros.length; h++) {
            if (livroinicial.equals(livros[h][3])) {

                System.out.println("Insira a nova Editora do livro");
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

        System.out.println("Insira o Título do livro para alterar o Código");
        System.out.println("Título     | Autor | Editora | Código");
        for (int i = 0; i < livros.length; i++) {
            if (livros[i][0].compareToIgnoreCase("0") != 0)
                System.out.println(livros[i][0] + "  | " + livros[i][1] + "  | " + livros[i][2] + "  | " + livros[i][3]+ " | " +livros[i][4]);
        livroinicial = teclado.next();
        for (int h = 0; h < livros.length; h++) {
            if (livroinicial.equals(livros[h][0])) {

                System.out.println("Insira o novo Código do livro");
                alteracaolivro = teclado.next();
                livros[h][3] = alteracaolivro;
            }
        }
        GuardaArrayParaFicheiro(Ficheiro_livros, livros);
        Menu2();
    }
    }
    public static void subMenu23() {
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("------------------------------   Remover Livro  -----------------------------------");
        RemoverLivro();
    }

    public static void RemoverLivro() {
        String livropararemover;
        String temporarioArray[][] = new String[livros.length - 1][4];


        System.out.println("Livros ");
        for (int i = 0; i < livros.length; i++) {
            if (livros[i][0].compareToIgnoreCase("0") != 0) {
                System.out.println(livros[i][0] + "  | " + livros[i][1] + "  | " + livros[i][2] + "  | " + livros[i][3]+ " | " +livros[i][4]);
            }
        }
        System.out.println("Insira o nome do livro que pretende remover?");
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
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("------------------------------   Consultar Livro  -----------------------------------");
        listarLivro();
    }

    public static void listarLivro() {
        int tamlivros = livros.length;


        for (int i = 0; i < tamlivros; i++) {

            System.out.println(livros[i][0] + "  | " + livros[i][1] + "  | " + livros[i][2] + "  | " + livros[i][3]+ " | " +livros[i][4]);

        }
        Menu2();


    }

    public static void subMenu25() {
        int escolha;
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------- SAIR  -------------------------------------------");

        System.out.println("1 - Voltar ao Menu principal");
        System.out.println("2 - Menu Livros ");
        escolha = teclado.nextInt();
        switch (escolha) {
            case 1:
                MenuPrincipal();
                break;
            case 2:
                Menu2();
                break;


        }
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
                subMenu35();
            }
        }
    }

    public static void subMenu31() {

        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("-----------------------------   Inserir Revista  -----------------------------------");
        criarRevista();


    }

    public static void criarRevista() // alterar arrays
    {
        int numero = 0;
        do {


            String temporarioArray[][] = new String[revistas.length + 1][4];


            for (int i = 0; i < revistas.length; i++) {
                temporarioArray[i][0] = revistas[i][0];
                temporarioArray[i][1] = revistas[i][1];
                temporarioArray[i][2] = revistas[i][2];
                temporarioArray[i][3] = revistas[i][3];


            }

            System.out.println("Insira o titulo da revista");
            temporarioArray[temporarioArray.length - 1][0] = teclado.next();

            System.out.println("Insira a data da revista no formato dd/mm/aaaa");
            temporarioArray[temporarioArray.length - 1][1] = teclado.next();

            System.out.println("Insira o código da revista");
            temporarioArray[temporarioArray.length - 1][2] = teclado.next();
            
            System.out.println("Insira disponibilidade (Ativo|Inativo)");
            temporarioArray[temporarioArray.length - 1][3] = teclado.next();

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


        System.out.println("Insira o codigo da revista para alterar o titulo");
        System.out.println("Titulo     | Data | Código");
        for (int i = 0; i < revistas.length; i++) {
            if (revistas[i][0].compareToIgnoreCase("0") != 0){
                System.out.println(revistas[i][0] + "  | " + revistas[i][1] + "  | " + revistas[i][2]+ "  |  "+ revistas[i][3]);
            }
        }
        tituloinicial = teclado.next();
        for (int h = 0; h < revistas.length; h++) {
            if (tituloinicial.equals(revistas[h][2])) {

                System.out.println("Insira o novo titulo");
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


        System.out.println("Insira o código da revista para alterar a data da revista");
        System.out.println("Titulo     | Data | Código | Disponibilidade");
        for (int i = 0; i < revistas.length; i++) {
            if (revistas[i][0].compareToIgnoreCase("0") != 0)
                System.out.println(revistas[i][0] + "  | " + revistas[i][1] + "  | " + revistas[i][2]+ "  |  "+ revistas[i][3]);
        }
        datainicial = teclado.next();
        for (int h = 0; h < revistas.length; h++) {
            if (datainicial.equals(revistas[h][2])) {

                System.out.println("Insira a nova data");
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


        System.out.println("Insira o nome da revista para alterar o código");
        System.out.println("Titulo     | Data | Código");
        for (int i = 0; i < revistas.length; i++) {
            if (revistas[i][0].compareToIgnoreCase("0") != 0)
                System.out.println(revistas[i][0] + "  | " + revistas[i][1] + "  | " + revistas[i][2]+ "  |  "+ revistas[i][3]);
        }
        codigoinicial = teclado.next();
        for (int h = 0; h < revistas.length; h++) {
            if (codigoinicial.equals(revistas[h][0])) {

                System.out.println("Insira o novo código de aluno");
                alteracaocodigo = teclado.next();


                revistas[h][2] = alteracaocodigo;


            }
        }
        GuardaArrayParaFicheiro(Ficheiro_utilizadores, utilizadores);
        Menu3();
    }

    public static void subMenu33() {
        int escolha;
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("------------------------------   Remover Revista  -----------------------------------");
        System.out.println("1 - Remover Revistas");
        System.out.println("2 - Voltar Menu Anterior");
        escolha = teclado.nextInt();
        switch (escolha) {
            case 1:
                removeRevistas();
                break;
            case 2:
                Menu3();
        }
    }

    public static void subMenu34() {
        int escolha;
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("----------------------------   Consultar Revista  -----------------------------------");
        System.out.println("1 - Consultar Revistas no Sistema");
        System.out.println("2 - Voltar Menu Anterior");
        escolha = teclado.nextInt();
        switch (escolha) {
            case 1:
                listarRevistas();
                break;
            case 2:
                Menu3();
                break;

        }
    }

    public static void removeRevistas() {
        String revistapararemover;
        String temporarioArray[][] = new String[revistas.length - 1][4];


        System.out.println("Titulo | Data | Código ");
        for (int i = 0; i < revistas.length; i++) {
            if (revistas[i][0].compareToIgnoreCase("0") != 0) {
                System.out.println(revistas[i][0] + "  | " + revistas[i][1] + "  | " + revistas[i][2]+ "  |  "+ revistas[i][3]);
            }
        }
        System.out.println("Insira o código da revista que pretende remover?");
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

        subMenu33();

    }

    public static void listarRevistas() {
        int tamRevistas = revistas.length;


        for (int i = 0; i < tamRevistas; i++) {

            System.out.println(revistas[i][0] + "  | " + revistas[i][1] + "  | " + revistas[i][2]+ "  |  "+ revistas[i][3]);

        }
        subMenu34();
    }

    public static void subMenu35() {
        int escolha;
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("--------------------------------- SAIR ---------------------------------------------");
        System.out.println("1 - Voltar ao Menu principal");
        System.out.println("2 - Menu Revistas ");
        escolha = teclado.nextInt();
        switch (escolha) {
            case 1:
                MenuPrincipal();
                break;
            case 2:
                Menu3();
                break;


        }
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
                subMenu45();
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
        System.out.println(" 3 - Menu Anterior");
        escolha =teclado.nextInt();
        switch(escolha)
        {
            case 1:
                aluguerLivros();
                
            case 2:
                aluguerRevistas();
                
            case 3:
                Menu4();
               
        }

    }
    public static void aluguerLivros()
    {
    String livro;
    String Utilizador;
    String temporarioArray[][] = new String[livros.length +1][3];
    String temporarioArray2[][] = new String[utilizadores.length+1][3];
    int tamLivros = livros.length;
        for (int i = 0; i < tamLivros; i++) {
            System.out.println("LIVROS \n");
            System.out.println("Titulo -> " +livros[i][0] + " | Autor-> " + livros[i][1] + "  | Editora-> " + livros[i][2] + " | Código-> " + livros[i][3]);

        }
     System.out.println("Insira o nome do livro que pertende alugar");
     livro = teclado.next();
     for (int h = 0; h < livros.length; h++) {
            if (livro.equals(livros[h][0])) {
                temporarioArray[0][0]=livro;
                alugueres=temporarioArray; 
                temporarioArray2=alugueres;
               
            }

     
    }
    int tamUtilizadores = utilizadores.length;
      for (int j = 0; j < tamUtilizadores; j++) {
            System.out.println("UTILIZADORES \n");
            System.out.println("Nome -> " +utilizadores[j][0] + " | Nº de Aluno-> " + livros[j][1]);  
        
      }
     System.out.println("Insira o nome do aluno");
     Utilizador=teclado.next();
     for (int w = 0; w < utilizadores.length; w++) {
            if (Utilizador.equals(utilizadores[w][0])) {
                temporarioArray2=alugueres;
                temporarioArray2[0][1]=Utilizador;
                
               
            }
            
      GuardaArrayParaFicheiro(Ficheiro_alugueres, alugueres);
      
    }
    
     
     
    }
    public static void aluguerRevistas()
    {
        
    }
    
    public static void subMenu42()
    {
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("------------------------------  Alterar Aluguer  -----------------------------------");
    }

    public static void subMenu43()
    {
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("------------------------------  Remover Aluguer  -----------------------------------");
    }

    public static void subMenu44()
    {
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("----------------------------  Consultar Aluguer  -----------------------------------");
        listarAlugueres();
    }
    public static void listarAlugueres(){
        int tamAlug = alugueres.length;


        for (int i = 0; i < tamAlug; i++) {

            System.out.println(alugueres[i][0] + "  | " + alugueres[i][1] + "  | " + alugueres[i][2]+ "  |  "+ alugueres[i][3]);

        }
        Menu4();
    }
    
    public static void subMenu45()
    {
        int escolha;
        System.out.println("------------------------------------------------------------------------------------");
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