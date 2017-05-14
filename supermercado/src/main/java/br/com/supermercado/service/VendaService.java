package br.com.supermercado.service;

import java.math.BigDecimal;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.supermercado.model.ItemEstoque;
import br.com.supermercado.model.ItemVenda;
import br.com.supermercado.model.Venda;
import br.com.supermercado.repository.ItemEstoqueRepository;
import br.com.supermercado.repository.ItemVendaRepository;
import br.com.supermercado.repository.VendaRepository;

@Service
public class VendaService {

	@Autowired
	private VendaRepository vendaRepository;
	
	@Autowired
	private ItemVendaRepository itemVendaRepository;
	
	@Autowired
	private ItemEstoqueRepository itemEstoqueRepository;

	public Iterable<Venda> listarTodos(){
		return vendaRepository.findAll();
	}

	public void salvar(Venda venda) {
		
		if(venda.getItens().size() < 1){
			throw new IllegalArgumentException("Insira ao menos um item!");
		}
		if(venda.getValorPagoDinheiro().doubleValue() < 0){
			throw new IllegalArgumentException("Insira um valor válido!");
		}
		
		Venda v = vendaRepository.save(venda);
		
		Iterator<ItemVenda> it = venda.getItens().iterator();
		
		try{
			while(it.hasNext()){
				ItemVenda itemVenda = it.next();
				
				int quantidadeVenda = itemVenda.getQuantidade();
				
				ItemEstoque itemEstoque = itemEstoqueRepository.findByProduto(itemVenda.getProduto());
				
				int quantidadeEstoque = itemEstoque.getQuantidade().intValue();
				
				if(quantidadeVenda < quantidadeEstoque){
					throw new IllegalArgumentException("Quantidade em estoque insuficiente!");
				}else{
					itemEstoque.setQuantidade(new BigDecimal(quantidadeEstoque - quantidadeVenda));
					
					//update item estoque
					
					itemEstoqueRepository.delete(itemEstoque);
					itemEstoqueRepository.save(itemEstoque);
				}
				
				// persiste o item Venda
				itemVendaRepository.save(itemVenda);
			}
		} catch (IllegalArgumentException e){
			
			// Se houve alguma exceção, remove a venda e seus itens que foram salvoss
			
			itemVendaRepository.delete(v.getItens());
			vendaRepository.delete(v);
			
			e.getMessage();
		}
		
	}

}
