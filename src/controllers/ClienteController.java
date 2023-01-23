package controllers;

import java.util.Scanner;

import entities.Cliente;
import repositories.ClienteRepository;

public class ClienteController {
	
	//método para executar o fluxo de cadastro de um cliente no banco de dados
	
	public void cadastrarCliente() {
	
		try {
			
			System.out.println("\nCADASTRO DE CLIENTES:\n");
			
			Cliente cliente = new Cliente();
			Scanner scanner = new Scanner(System.in);
			
			System.out.print("NOME DO CLIENTE....: ");
			cliente.setNome(scanner.nextLine());
			
			System.out.print("EMAIL DO CLIENTE...: ");
			cliente.setEmail(scanner.nextLine());
			
			ClienteRepository clienteRepository = new ClienteRepository();
			clienteRepository.create(cliente);
			
			System.out.println("\nLIENTE CADASTRADO COM SUCESSO!");
						
		}
		catch(Exception e) {
			System.out.println("\nFALHA AO CADASTRAR O CLIENTE");
			e.printStackTrace();
		}
	}
}