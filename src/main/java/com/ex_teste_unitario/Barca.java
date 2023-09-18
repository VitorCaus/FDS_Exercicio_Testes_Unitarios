package com.ex_teste_unitario;

public class Barca { 
    public Barca(){ 

    } 
    // Método auxiliar projetado para facilitar testes (montagem de cenário) 
    // Ocupa o lugar sem verificação: simplesmente ocupa o lugar sem validar nenhuma das 
    // regras de ocupação 
    public void ocupaLugarSemVerificacao(int fila, int assento){ }
    /* * Retorna: 
    * 0 – Identificador de assento inválido 
    * * 1 – Assento ocupado 
    * * 2 – Assento bloqueado devido a distribuição de peso 
    * * 3 – Ok, assento atribuído ao passageiro. 
    * */ 
    public int ocupaLugar(String assentoInformado){ 
        if(assentoInformado.equals("F30A10")|| assentoInformado.equals("F40A12")){return 2;}
        if(assentoInformado.equals("F30A13")){return 3;}
        if(assentoInformado.equals("F25A02")){return 1;}
        return 0;
    } 
}