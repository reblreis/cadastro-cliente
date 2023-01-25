package controllers;

import java.util.List;
import java.util.Scanner;

import entities.Cliente;
import repositories.ClienteRepository;

public class ClienteController {

	// método para executar o fluxo de cadastro de um cliente no banco de dados

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

			System.out.println("\nCLIENTE CADASTRADO COM SUCESSO!");

		} catch (Exception e) {
			System.out.println("\nFALHA AO CADASTRAR O CLIENTE");
			e.printStackTrace();
		}
	}

	// método para executar o fluxo de atualização de um cliente no banco de dados
	public void atualizarCliente() {
		try {
			System.out.print("ATUALIZAÇÃO DE CLIENTES: \n");

			Scanner scanner = new Scanner(System.in);

			System.out.println("INFORME O ID DO CLIENTE.......: ");
			Integer idCliente = Integer.parseInt(scanner.nextLine());

			// consultando o cliente no banco de dados através do id..
			ClienteRepository clienteRepository = new ClienteRepository();
			Cliente cliente = clienteRepository.findById(idCliente);

			// verificando se o cliente foi encontrado no banco de dados
			if (cliente != null) {

				System.out.print("ALTERE O NOME......: ");
				cliente.setNome(scanner.nextLine());

				System.out.print("ALTERE O EMAIL.....: ");
				cliente.setEmail(scanner.nextLine());

				// atualizando o cliente no banco de dados
				clienteRepository.update(cliente);

				System.out.println("\nCLIENTE ATUALIZADO COM SUCESSO.");
			} else {
				System.out.println("\nCLIENTE NÃO ENCONTRADO.");
			}
		} catch (Exception e) {
			System.out.println("\nFALHA AO ATUALIZAR O CLIENTE.");
			e.printStackTrace();
		}

	}

	// método para executar o fluxo de exclusão de um cliente no banco de dados

	public void excluirCliente() {

		try {

			System.out.println("\nEXCLUSÃO DE CLIENTES:\n");

			Scanner scanner = new Scanner(System.in);

			System.out.print("INFORME O ID DO CLIENTE....: ");
			Integer idCliente = Integer.parseInt(scanner.nextLine());

			// consultando o cliente no banco de dados através do id..
			ClienteRepository clienteRepository = new ClienteRepository();
			Cliente cliente = clienteRepository.findById(idCliente);

			// verificando se o cliente foi encontrado
			if (cliente != null) {

				// excluindo o cliente
				clienteRepository.delete(cliente);

				System.out.println("\nCLIENTE EXCLUÍDO COM SUCESSO.");
			} else {
				System.out.println("\nCLIENTE NÃO ENCONTRADO.");
			}
		} catch (Exception e) {
			System.out.println("\nFALHA AO EXCLUIR O CLIENTE.");
			e.printStackTrace();
		}

	}

	// método para executar o fluxo de consulta de clientes no banco de dados

	public void consultarClientes() {

		try {

			System.out.println("\nCONSULTA DE CLIENTES:\n");

			ClienteRepository clienteRepository = new ClienteRepository();
			List<Cliente> lista = clienteRepository.findAll();

			for (Cliente cliente : lista) {

				System.out.println("ID DO CLIENTE...: " + cliente.getIdCliente());
				System.out.println("NOME............: " + cliente.getNome());
				System.out.println("EMAIL...........: " + cliente.getEmail());
				System.out.println("...");
			}

		} catch (Exception e) {
			System.out.println("\nFALHA AO CONSULTAR CLIENTES.");
			e.printStackTrace();
		}
	}
}