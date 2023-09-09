package data;

import entities.Conta;

public class ContaData {
    private Conta conta = new Conta();

    private Long numero = System.nanoTime();


    public Conta contaFixa (){
        conta.setNome("Conta fixa");
        return conta;
    }

    public Conta contaReutilizavel(){
        String texto = numero.toString();
        conta.setNome("Conta " + texto);
        return  conta;
    }

    public Conta contaAtualizada(){
        String texto = numero.toString();
        conta.setNome("Conta " + texto + "atualizada");
        return  conta;
    }




}
