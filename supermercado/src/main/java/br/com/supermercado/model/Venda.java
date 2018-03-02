package br.com.supermercado.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Venda {

    @Id
    @GeneratedValue(generator="venda_seq", strategy=GenerationType.SEQUENCE)
    @SequenceGenerator(name="venda_seq", sequenceName="venda_seq", allocationSize=1,initialValue=1)
    private Long id;

    @ManyToOne(optional=false)
    private Caixa caixa;

    @ManyToOne(optional=false)
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataVenda = new Date();

    @Enumerated(EnumType.STRING)
    private EnumTipoPagamento tipoPagamento;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="venda_id")
    private List<ItemVenda> itens = new ArrayList<>();

    @Transient
    private BigDecimal valorPagoDinheiro = BigDecimal.ZERO;

    public BigDecimal valorTotalVenda(){
        BigDecimal totalVenda = BigDecimal.ZERO;
        for (ItemVenda itemVenda : itens) {
            totalVenda = totalVenda.add(itemVenda.getValor());
        }
        return totalVenda;
    }

    public BigDecimal valorTroco(){
        return EnumTipoPagamento.DINHEIRO.equals(this.tipoPagamento) ? 
                valorPagoDinheiro.subtract(this.valorTotalVenda()) : BigDecimal.ZERO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public EnumTipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(EnumTipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
    }

    public BigDecimal getValorPagoDinheiro() {
        return valorPagoDinheiro;
    }

    public void setValorPagoDinheiro(BigDecimal valorPagoDinheiro) {
        this.valorPagoDinheiro = valorPagoDinheiro;
    }

}
