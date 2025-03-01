package classes;

import java.util.GregorianCalendar;
import java.util.List;

public class Venda {
    private Cliente cliente;
    private List<Produto> itensVendidos;
    private GregorianCalendar dataVenda;
    private String metodoPagamento;
    private Double subTotal;
    private Double valorDesconto;
    private Double valorImpostos;
    private Double valorFinal;

    public Venda(Cliente cliente, List<Produto> itensVendidos, GregorianCalendar dataVenda, String metodoPagamento) {
        this.cliente = cliente;
        this.itensVendidos = itensVendidos;
        this.dataVenda = dataVenda;
        this.metodoPagamento = metodoPagamento;
        this.subTotal = this.calculaSubtotal(itensVendidos);
        this.valorDesconto = 0.0;
        this.valorImpostos = 0.0;
        this.valorFinal = this.calculaValorFinal();
    }

    private Double calculaSubtotal(List<Produto> itensVendidos) {
        Double subTotal = itensVendidos.stream()
                .map(Produto::getValor)
                .reduce(0.0, Double::sum);
        return subTotal;
    }

    private Double calculaValorDesconto(Cliente cliente, List<Produto> itensVendidos, String metodoPagamento) {
        Double descontoCartaoEmpresa = this.descontoCartaoEmpresa(metodoPagamento);
        return 0.0;
    }

    private Double descontoCartaoEmpresa(String metodoPagamento) {
        return 0.0;
    }

    private Double calculaValorImpostos(Cliente cliente, List<Produto> itensVendidos) {
        return 0.0;
    }

    private Double calculaValorFinal() {
        return ((this.subTotal + this.valorImpostos) - this.valorDesconto);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Produto> getItensVendidos() {
        return itensVendidos;
    }

    public void setItensVendidos(List<Produto> itensVendidos) {
        this.itensVendidos = itensVendidos;
    }

    public GregorianCalendar getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(GregorianCalendar dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(Double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public Double getValorImpostos() {
        return valorImpostos;
    }

    public void setValorImpostos(Double valorImpostos) {
        this.valorImpostos = valorImpostos;
    }

    public Double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(Double valorFinal) {
        this.valorFinal = valorFinal;
    }
}
