package br.com.alura.screenmatch.calculo;

public class FiltroRecomendacao {

    private String recomendacao;

    public void filtra (Classificavel classificavel){
        if(classificavel.getClassificaocao() >= 4){
            System.out.println("Esta entre os prefeiros do momento");
        }else if(classificavel.getClassificaocao() >= 2){
            System.out.println("Muito bem avaliado");
        }else{
            System.out.println("Adicione na sua lista para assistir depois");
        }
    }

}
