package br.com.supermercado.model;

public enum EnumTipoPagamento {

   DINHEIRO("DINHEIRO"),
   CARTAO("CARTÃO");

   private String descricao;

   EnumTipoPagamento(String descricao){
      this.descricao = descricao;
   }

   public String getDescricao() {
      return descricao;
   }

}
