package br.com.supermercado.model;

public enum EnumUnidadeMedida {

   KG("QUILOGRAMAS"),
   UN("UNIDADE");

   private String descricao;

   EnumUnidadeMedida(String descricao){
      this.descricao = descricao;
   }

   public String getDescricao() {
      return descricao;
   }

}
