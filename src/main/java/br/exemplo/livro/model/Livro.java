package br.exemplo.livro.model;

import java.io.Serializable;

public class Livro implements Serializable {
     private String capa;
     private String folhaDeRosto;
     private String corpo;
     private String conclusao;
     private String referencias;
     public String getCapa() {
          return capa;
     }
     public void setCapa(String capa) {
          this.capa = capa;
     }
     public String getFolhaDeRosto() {
          return folhaDeRosto;
     }
     public void setFolhaDeRosto(String folhaDeRosto) {
          this.folhaDeRosto = folhaDeRosto;
     }
     public String getCorpo() {
          return corpo;
     }
     public void setCorpo(String corpo) {
          this.corpo = corpo;
     }
     public String getConclusao() {
          return conclusao;
     }
     public void setConclusao(String conclusao) {
          this.conclusao = conclusao;
     }
     public String getReferencias() {
          return referencias;
     }
     public void setReferencias(String referencias) {
          this.referencias = referencias;
     }
     
     
}
