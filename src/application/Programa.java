package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entities.Empresa;

public class Programa {

	public static void main(String[] args) {
		int opcao = 1, entradas = 1;
		Scanner sc = new Scanner(System.in);
		String cnpjRegex = "^([0-9]{2}\\.?[0-9]{3}\\.?[0-9]{3}\\/?[0-9]{4}-?[0-9]{2}|[0-9]{3}\\.?[0-9]{3}\\.?[0-9]{3}-?[0-9]{2})$";
		Pattern pattern = Pattern.compile(cnpjRegex);
		System.out.print("Bem vindo! ");

		List<Empresa> listaEmpresas = new ArrayList<>(); // cria uma lista para armazenar as empresas

		while (opcao == 1) {
			Empresa empresa = new Empresa();
			// CADASTRO

			System.out.println("Cadastre a sua empresa...");
			System.out.println("Digite o nome da empresa: ");
			empresa.nome = sc.next();
			System.out.println("Agora digite o CNPJ: ");
			empresa.cnpj = sc.next();

			// verifica se o cnpj possui 14 caracteres comparando com um regex
			Matcher matcher = pattern.matcher(empresa.cnpj);
			if (matcher.find()) {
				System.out.println("CNPJ válido!");
			} else {
				System.out.println("CNPJ inválido!");
			}

			System.out.println("Digite a renda bruta mensal da sua empresa: ");
		    boolean rendaValida = false;
		    do {
		        try {
		            empresa.renda_bruta_mensal = sc.nextDouble();
		            rendaValida = true; // Renda válida se não houver exceção
		        } catch (InputMismatchException e) {
		            System.out.println("Erro: Tipo de entrada inválido para renda bruta mensal. Digite um número.");
		            System.out.println("Digite a renda bruta mensal da sua empresa: ");
		            sc.nextLine(); // Limpa o buffer do Scanner
		        }
		    } while (!rendaValida); // Continua o loop enquanto a renda não for válida

			// adiciona o objeto criado em uma lista
			listaEmpresas.add(empresa);

			System.out.println("Deseja cadastrar outra empresa? Sim - 1,  Não - 0 ...");
			opcao = sc.nextInt();

			// verifica se o valor de opcao e 1 ou 0
			while (opcao != 1 && opcao != 0) {
				System.out.println("Por favor digite um valor válido ...");
				System.out.println("Deseja cadastrar outra empresa? Sim - 1,  Não - 0 ...");
				opcao = sc.nextInt();
			}

			if (opcao == 0) {
				System.out.println("Deseja visualizar a(s) entrada(s)? Sim - 1,  Não - 0 ...");
				entradas = sc.nextInt();
				while (entradas != 1 && entradas != 0) {
					System.out.println("Por favor digite um valor válido ...");
					System.out.println("Deseja cadastrar outra empresa? Sim - 1,  Não - 0 ...");
					entradas = sc.nextInt();
				}
				// mostra as entradas da lista de empresas
				if (entradas == 1) {
					for (Empresa e : listaEmpresas) {
						System.out.println(e);
					}
				}
			}

		}

		System.out.println("Volte sempre!!!");
		sc.close();
	}

}
