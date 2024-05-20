package entities;

public class Empresa {
	public String nome;
	public String cnpj;
	public double renda_bruta_mensal;
	
	
	@Override
	public String toString() {
		return String.format("Empresa=%s, CNPJ=%s, Renda Bruta=R$%,.2f", nome, cnpj, renda_bruta_mensal);
	}
	
	
}
