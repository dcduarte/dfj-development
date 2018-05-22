public class revistas {
    public static void Menu3()
    {
        int escolha;
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("----------------------------------   Menu Revistas ---------------------------------");
        System.out.println(" 1 - Inserir Revista");
        System.out.println(" 2 - Alterar Revista");
        System.out.println(" 3 - Remover Revista");
        System.out.println(" 4 - Consultar Revista");
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
                subMenu35();
            }
        }
    }

    public static void subMenu31()
    {

        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("-----------------------------   Inserir Revista  -----------------------------------");
        criarRevista();



    }

    public static void criarRevista() // alterar arrays
    {
        int numero=0;
        do{


            String temporarioArray[][] = new String[revistas.length+1][3];


            for(int i=0; i<revistas.length;i++)
            {
                temporarioArray[i][0]=revistas[i][0];
                temporarioArray[i][1]=revistas[i][1];
                temporarioArray[i][2]=revistas[i][2];



            }

            System.out.println("Insira o titulo da revista");
            temporarioArray[temporarioArray.length-1][0]= teclado.next();

            System.out.println("Insira a data da revista no formato dd/mm/aaaa");
            temporarioArray[temporarioArray.length-1][1]= teclado.next();

            System.out.println("Insira o código da revista");
            temporarioArray[temporarioArray.length-1][2]= teclado.next();



            revistas=temporarioArray;



            do{
                System.out.println("Prima 1 para inserir uma nova revista ou 0 para voltar.");
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
        int escolha;
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("-----------------------------   Alterar Revista  -----------------------------------");
        System.out.println("1 - Alterar o titulo da revista ");
        System.out.println("2 - Alterar data da revista");
        System.out.println("3 - Alterar código da revista");



        escolha = teclado.nextInt();
        switch(escolha)
        {
            case 1: Alterartitulorev();

            case 2: Alterardatarev();

            case 3: Alterarcodigorev();
                break;
        }
    }
    public static void Alterartitulorev(){
        String tituloinicial;
        String alteracaotitulo;


        System.out.println("Insira o codigo da revista para alterar o titulo");
        System.out.println("Titulo     | Data | Código");
        for (int i = 0; i<revistas.length; i++){
            if(revistas[i][0].compareToIgnoreCase("0")!=0)
                System.out.println(revistas[i][0]+ "  | " + revistas[i][1]+ "  | " + revistas[i][2]);
        }
        tituloinicial=teclado.next();
        for(int h=0;h<revistas.length;h++){
            if(tituloinicial.equals(revistas[h][2])){

                System.out.println("Insira o novo titulo");
                alteracaotitulo=teclado.next();
                revistas[h][0]=alteracaotitulo;
            }
        }
        GuardaArrayParaFicheiro(Ficheiro_revistas, revistas);
        Menu3();
    }
    public static void Alterardatarev(){

        String datainicial;
        String alteracaodata;


        System.out.println("Insira o código da revista para alterar a data da revista");
        System.out.println("Titulo     | Data | Código");
        for (int i = 0; i<revistas.length; i++){
            if(revistas[i][0].compareToIgnoreCase("0")!=0)
                System.out.println(revistas[i][0]+ "  | " + revistas[i][1]+ "  | " + revistas[i][2]);
        }
        datainicial=teclado.next();
        for(int h=0;h<revistas.length;h++){
            if(datainicial.equals(revistas[h][2])){

                System.out.println("Insira a nova data");
                alteracaodata=teclado.next();

                revistas[h][1]=alteracaodata;


            }
        }
        GuardaArrayParaFicheiro(Ficheiro_utilizadores,utilizadores);
        Menu3();
    }
    public static void Alterarcodigorev(){
        String codigoinicial;
        String alteracaocodigo;


        System.out.println("Insira o nome da revista para alterar o código");
        System.out.println("Titulo     | Data | Código");
        for (int i = 0; i<revistas.length; i++){
            if(revistas[i][0].compareToIgnoreCase("0")!=0)
                System.out.println(revistas[i][0]+ "  | " + revistas[i][1]+ "  | " + revistas[i][2]);
        }
        codigoinicial=teclado.next();
        for(int h=0;h<revistas.length;h++){
            if(codigoinicial.equals(revistas[h][0])){

                System.out.println("Insira o novo código de aluno");
                alteracaocodigo=teclado.next();


                revistas[h][2]=alteracaocodigo;


            }
        }
        GuardaArrayParaFicheiro(Ficheiro_utilizadores,utilizadores);
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

    public static void subMenu34()
    {
        int escolha;
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("----------------------------   Consultar Revista  -----------------------------------");
        System.out.println("1 - Consultar Revistas no Sistema");
        System.out.println("2 - Voltar Menu Anterior");
        escolha=teclado.nextInt();
        switch(escolha)
        {
            case 1: listarRevistas();
                break;
            case 2: Menu3();
                break;

        }
    }
    public static void removeRevistas() {
        String revistapararemover;
        String temporarioArray[][]= new String[revistas.length-1][3];


        System.out.println("Titulo | Data | Código ");
        for (int i=0;i<revistas.length;i++) {
            if(revistas[i][0].compareToIgnoreCase("0")!=0) {
                System.out.println(revistas[i][0]+ "  | " + revistas[i][1]+ "  | " + revistas[i][2]);
            }
        }
        System.out.println("Insira o código da revista que pretende remover?" );
        revistapararemover=teclado.next();
        int y=0;
        for(int x=0;x<revistas.length;x++) {
            if(revistas[x][2].equalsIgnoreCase(revistapararemover)){
                continue;
            }
            temporarioArray[y][0]=revistas[x][0];
            temporarioArray[y][1]=revistas[x][1];
            temporarioArray[y][2]=revistas[x][2];

            y++;
        }
        revistas=temporarioArray;

        GuardaArrayParaFicheiro(Ficheiro_revistas,revistas);

        subMenu33();

    }
    public static void listarRevistas()
    {
        int tamRevistas = revistas.length;


        for(int i=0; i<tamRevistas; i++){

            System.out.println(revistas[i][0]+ "  : " + revistas[i][1]+ "  : " + revistas[i][2]);

        }
        subMenu34();
    }
    public static void subMenu35()
    {
        int escolha;
        System.out.println("------------------------------------------------------------------------------------");
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
