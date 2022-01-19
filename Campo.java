public class Campo {//controle e validação dos campos
    private char Simbolo;
    public Campo(){
        this.Simbolo = ' ';
    }
    public char getSimbolo(){
        return this.Simbolo;
    }
    public void setSimbolo( char Simbolo ){
        if (this.Simbolo == ' '){
            this.Simbolo = Simbolo;
        }
        else{
            System.out.println("SimboloCampo ja usado");
        }
    }
}
