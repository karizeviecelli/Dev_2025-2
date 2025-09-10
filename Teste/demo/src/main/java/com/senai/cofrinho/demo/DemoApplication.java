package com.senai.cofrinho.demo;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	
        Cofrinho cofrinho = new Cofrinho();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1 - Adicionar Moeda");
            System.out.println("2 - Remover Moeda");
            System.out.println("3 - Listar Moedas");
            System.out.println("4 - Calcular Total em Reais");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            if (opcao == 1) {
                System.out.println("Escolha a moeda:");
                System.out.println("1 - Real");
                System.out.println("2 - Dólar");
                System.out.println("3 - Euro");
                int tipoMoeda = scanner.nextInt();
                
                System.out.print("Digite o valor: ");
                double valor = scanner.nextDouble();
                
                Moeda moeda = null;
                switch (tipoMoeda) {
                    case 1:
                        moeda = new Real(valor);
                        break;
                    case 2:
                        moeda = new Dolar(valor);
                        break;
                    case 3:
                        moeda = new Euro(valor);
                        break;
                    default:
                        System.out.println("Tipo de moeda inválido.");
                        continue;
                }
                
                cofrinho.adicionar(moeda);
                System.out.println("Moeda adicionada com sucesso.");

            } else if (opcao == 2) {
                System.out.print("Digite o índice da moeda a remover: ");
                int indice = scanner.nextInt();
                if (indice >= 0 && indice < cofrinho.listaMoedas.size()) {
                    cofrinho.remover(cofrinho.listaMoedas.get(indice));
                    System.out.println("Moeda removida com sucesso.");
                } else {
                    System.out.println("Índice inválido.");
                }

            } else if (opcao == 3) {
                cofrinho.listarMoedas();

            } else if (opcao == 4) {
                double total = cofrinho.calcularTotalEmReais();
                System.out.println("Total em reais: " + total);

            } else if (opcao == 5) {
                System.out.println("Saindo...");
                break;
            } else {
                System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    
	}

}
