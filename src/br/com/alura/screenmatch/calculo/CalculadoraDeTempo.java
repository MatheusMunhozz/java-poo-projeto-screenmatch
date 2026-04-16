package br.com.alura.screenmatch.calculo;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

public class CalculadoraDeTempo {

     private int tempoTotal;

     public int getTempoTotal(){
          return this.tempoTotal;
     }

//     public void inclui(Filme f){
//          this.tempoTotal += f.getDuracaoEmMinutos();
//     }
//
//     public void inclui(Serie s){
//          this.tempoTotal += s.getDuracaoEmMinutos();
//     }

     public void inclui(Titulo titulo){
          this.tempoTotal += titulo.getDuracaoEmMinutos();
     }

}
