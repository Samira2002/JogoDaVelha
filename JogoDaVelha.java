import java.util.Scanner;
public class JogoDaVelha{

    public static void main(String[] args){
        
        Campo[][] velha =new Campo [3][3];
        boolean replay = true;
        String resp;
        String sim = "s", nao = "n";
        Scanner ler = new Scanner(System.in);


        while(replay){

            iniciarJogo(velha);
            denovo(velha);

            System.out.printf("%nQuer jogar Denovo? S - Sim   N - Não%n");
            
            resp = ler.next();

            String respo = new String(resp);

            if(respo.equals(nao)){
                break;
            }
            if(respo.equals(sim)){
                replay = true;
            }
           
            else{
                System.out.printf("%nDesculpe, não entendi o que você ditou (;-; )%n");
                break;
            }

        }
        ler.close();
        System.out.println("Obrigada por jogar (. ' u '.)");
    }

        


    public static void denovo(Campo[][] velha){
        
        Scanner ler = new Scanner(System.in);
        Boolean game = true;
        char simboloAtt = 'X';
        String win = "";
        boolean veia = false;
        

        while(game){
            DesenhaJogo(velha);

            veia = Ninguem(velha);
            if(veia){System.out.println("VELHA - todos venceram :) ");break;}

            win = VerifWin(velha);
            if(!win.equals("")){
                System.out.printf("jogador %s venceu%n", win);
                break;
            }
            try{
                if (VerifJogada(velha, jogar(ler, simboloAtt), simboloAtt)){
                    if(simboloAtt == 'X'){
                        simboloAtt = 'O';
                    }
                    else{
                        simboloAtt = 'X';
                    }
                }
            }
            catch(Exception e){
                System.out.printf("Erro");
            }
        }
        
    }
    
    public static void iniciarJogo(Campo[][] velha){
        for(int l = 0; l<3; l++){
            for(int c = 0; c<3; c++){
                velha[l][c]= new Campo();
            }  
        }
    }

    public static void DesenhaJogo(Campo[][] velha){
        
        limpa();

        System.out.printf("     0     1     2%n");
        System.out.printf(" 0   %c  |  %c  |  %c  %n", 
        velha[0][0].getSimbolo() , velha[0][1].getSimbolo() , velha[0][2].getSimbolo());
        System.out.println("     --------------");
        System.out.printf(" 1   %c  |  %c  |  %c  %n", 
        velha[1][0].getSimbolo() , velha[1][1].getSimbolo() , velha[1][2].getSimbolo());
        System.out.println("     --------------");
        System.out.printf(" 2   %c  |  %c  |  %c  %n", 
        velha[2][0].getSimbolo() , velha[2][1].getSimbolo() , velha[2][2].getSimbolo());
    }

    public static void limpa(){
        for(int i = 0 ; i < 200; i++)
        System.out.println(' ');
    }

    public static int[] jogar(Scanner scan, char s){
        int[] posicao = new int[2];
        System.out.println("");
        System.out.printf("%s %c%n","Quem joga: ", s);
        System.out.printf("Linha:");
        posicao[0] = scan.nextInt();
        System.out.printf("Coluna:");
        posicao[1] = scan.nextInt();
        return posicao;

    }

    public static boolean VerifJogada(Campo[][] velha, int posicao[], char simboloAtt){
        if(velha[posicao[0]][posicao[1]].getSimbolo()==' '){
            velha[posicao[0]][posicao[1]].setSimbolo(simboloAtt);
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean Ninguem(Campo[][] velha){
    int cont=0;
    for (int i = 0; i < 3; i++){
        for (int j = 0 ; j < 3; j++){
            if(velha[i][j].getSimbolo() != ' '){
                cont++;
            }
        }
    } 
    if (cont == 9){
        return true;
    }
    else{
        return false;
    }

}

    public static String VerifWin(Campo[][] velha){
        
        
        //chacagem diagonal
        if(velha[0][0].getSimbolo()=='X' && velha[1][1].getSimbolo()=='X' && velha[2][2].getSimbolo()=='X'){
            return "X";
        }
        if(velha[0][0].getSimbolo()=='O' && velha[1][1].getSimbolo()=='O' && velha[2][2].getSimbolo()=='O'){
           return "O";
        }
        if(velha[0][2].getSimbolo()=='X' && velha[1][1].getSimbolo()=='X' && velha[2][0].getSimbolo()=='X'){
            return "X";
        }
        if(velha[0][2].getSimbolo()=='O' && velha[1][1].getSimbolo()=='O' && velha[2][0].getSimbolo()=='O'){
           return "O";
        }
        

        //checagem vertical 
        //col 0
        if(velha[0][0].getSimbolo()=='X' && velha[1][0].getSimbolo()=='X' && velha[2][0].getSimbolo()=='X'){
            return "X";
        }
        if(velha[0][0].getSimbolo()=='O' && velha[1][0].getSimbolo()=='O' && velha[2][0].getSimbolo()=='O'){
            return "O";
        }
        //col 1
        if(velha[0][1].getSimbolo()=='X' && velha[1][1].getSimbolo()=='X' && velha[2][1].getSimbolo()=='X'){
            return "X";
        }
        if(velha[0][1].getSimbolo()=='O' && velha[1][1].getSimbolo()=='O' && velha[2][1].getSimbolo()=='O'){
            return "O";
        }
        //col 2
        if(velha[0][2].getSimbolo()=='X' && velha[1][2].getSimbolo()=='X' && velha[2][2].getSimbolo()=='X'){
            return "X";
        }
        if(velha[0][2].getSimbolo()=='O' && velha[1][2].getSimbolo()=='O' && velha[2][2].getSimbolo()=='O'){
            return "O";
        }

        //checagem horizontal
        //lin 0
        if(velha[0][0].getSimbolo()=='X' && velha[0][1].getSimbolo()=='X' && velha[0][2].getSimbolo()=='X'){
            return "X";
        }
        if(velha[0][0].getSimbolo()=='O' && velha[0][1].getSimbolo()=='O' && velha[0][2].getSimbolo()=='O'){
            return "O";
        }
        //lin 1
        if(velha[1][0].getSimbolo()=='X' && velha[1][1].getSimbolo()=='X' && velha[1][2].getSimbolo()=='X'){
            return "X";
        }
        if(velha[1][0].getSimbolo()=='O' && velha[1][1].getSimbolo()=='O' && velha[1][2].getSimbolo()=='O'){
            return "O";
        }
        //lin 2
        if(velha[2][0].getSimbolo()=='X' && velha[2][1].getSimbolo()=='X' && velha[2][2].getSimbolo()=='X'){
            return "X";
        }
        if(velha[2][0].getSimbolo()=='O' && velha[2][1].getSimbolo()=='O' && velha[2][2].getSimbolo()=='O'){
            return "O";
        }
        else{
           return "";
        }
        
    }
}
