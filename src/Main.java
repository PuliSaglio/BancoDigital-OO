import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Banco banco1 = new Banco();		
		
		List<Conta> listaContas = new ArrayList<>();
		Cliente ignacio = new Cliente();
		ignacio.setNome("Ignacio");
		
		Cliente cecilia = new Cliente();
		cecilia.setNome("Cecilia");	
		
		Conta ccIgnacio = new ContaCorrente(ignacio);
		Conta poupancaIgnacio = new ContaPoupanca(ignacio);
		
		Conta poupancaCeci = new ContaPoupanca(cecilia);

		listaContas.add(ccIgnacio);
		listaContas.add(poupancaCeci);
		listaContas.add(poupancaIgnacio);
		banco1.setContas(listaContas);
		
		System.out.println("NOME DOS CLIENTES DO BANCO");
		//lambda expression + stream API para printar os clientes do banco1
		banco1.getContas().forEach(conta -> System.out.println("Cliente: " + conta.cliente.getNome()));
		
		ccIgnacio.depositar(150);
		ccIgnacio.transferir(100, poupancaCeci);
		poupancaIgnacio.depositar(50.5);
		
		ccIgnacio.imprimirExtrato();
		poupancaIgnacio.imprimirExtrato();
		poupancaCeci.imprimirExtrato();
	}

}
