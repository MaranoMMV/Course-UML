package com.cursomc.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.cursomc.domain.entity.Categoria;
import com.cursomc.domain.entity.Cidade;
import com.cursomc.domain.entity.Cliente;
import com.cursomc.domain.entity.Endereco;
import com.cursomc.domain.entity.Estado;
import com.cursomc.domain.entity.ItemPedido;
import com.cursomc.domain.entity.Pagamento;
import com.cursomc.domain.entity.PagamentoComBoleto;
import com.cursomc.domain.entity.PagamentoComCartao;
import com.cursomc.domain.entity.Pedido;
import com.cursomc.domain.entity.Produto;
import com.cursomc.domain.entity.enuns.EstadoPagamento;
import com.cursomc.domain.entity.enuns.TipoCliente;
import com.cursomc.repository.CategoriaRepository;
import com.cursomc.repository.CidadeRepository;
import com.cursomc.repository.ClienteRepository;
import com.cursomc.repository.EnderecoRepository;
import com.cursomc.repository.EstadoRepository;
import com.cursomc.repository.ItemPedidoRepository;
import com.cursomc.repository.PagamentoRepository;
import com.cursomc.repository.PedidoRepository;
import com.cursomc.repository.ProdutoRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    @Autowired
    private ProdutoRepository produtoRepository;
    
    @Autowired
    private EstadoRepository estadoRepository;
    
    @Autowired
    private CidadeRepository cidadeRepository;
    
    @Autowired 
    private ClienteRepository clienteRepository;
    
    @Autowired
    private EnderecoRepository enderecoRepository;
    
    @Autowired
    private PedidoRepository pedidoRepository;
    
    @Autowired
    private PagamentoRepository pagamentoRepository;
    
    @Autowired ItemPedidoRepository itemPedidoRepository;
    
    @Override
    public void run(String... args) throws Exception {
//        // Deleta todas as categorias e produtos existentes
//        this.categoriaRepository.deleteAll();
//        this.produtoRepository.deleteAll();
//        
        // Cria categorias
        Categoria cat1 = new Categoria(null, "Informatica");
        Categoria cat2 = new Categoria(null, "Escritorio");
        // Salva as categorias
        this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
        
        // Cria produtos
        Produto p1 = new Produto(null, "Computador", 2000.00);
        Produto p2 = new Produto(null, "Impressora" , 800.00 );
        Produto p3 = new Produto(null, "Mouse", 80.00 );
        
        // Associa produtos às categorias
        p1.getCategorias().add(cat1);
        p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
        p3.getCategorias().add(cat1);
        
        // Salva os produtos
        this.produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
        
        // Atualiza as categorias com os produtos
        cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProdutos().add(p2);
        
        // Salva as categorias novamente para atualizar as associações
        this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
        
        
        Estado est1 = new Estado(null, "Minas gerais");
        Estado est2 = new Estado(null, "São Paulo");
        
        Cidade c1 = new Cidade(null, "Uberlandia", est1);
        Cidade c2 = new Cidade(null, "São Paulo", est2);
        Cidade c3 = new Cidade(null, "Campinas", est2);
        
        est1.getCidades().addAll(Arrays.asList(c1));
        est2.getCidades().addAll(Arrays.asList(c2,c3));
        
        this.estadoRepository.saveAll(Arrays.asList(est1, est2));
        this.cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
        
        
        Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "3678912377", TipoCliente.PESSOAFISICA);
        cli1.getTelefones().addAll(Arrays.asList("263176312", "123687123"));
        
        Endereco e1 = new Endereco(null, "Rua flores", "300", "apto 303", "Jardim", "7123651235", cli1, c1);
        Endereco e2 = new Endereco(null, "Av Matos", "105", "Sala 800", "Centro", "12931983", cli1, c2);
        
        cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
        
        this.clienteRepository.saveAll(Arrays.asList(cli1));
        this.enderecoRepository.saveAll(Arrays.asList(e1,e2));
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
        Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);
        
        Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
        ped1.setPagamento(pagto1);
        
        Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
        ped2.setPagamento(pagto2);
        
        cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
        
        pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
       
        pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
        
        ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
        ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
        ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);
        
        ped1.getItens().addAll(Arrays.asList(ip1, ip2));
        ped2.getItens().addAll(Arrays.asList(ip3));
        
        p1.getItens().addAll(Arrays.asList(ip1));
        p2.getItens().addAll(Arrays.asList(ip3));
        p3.getItens().addAll(Arrays.asList(ip2));
        
        this.itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
        
    
    }
}
