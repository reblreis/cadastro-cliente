package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Cliente;
import factories.ConnectionFactory;

public class ClienteRepository {

	// método para gravar um cliente no banco de dados
	public void create(Cliente cliente) throws Exception {

		// abrindo conexão com o banco de dados

		Connection connection = ConnectionFactory.createConnection();

		// executando um comando SQL no banco de dados para cadastrar o cliente

		PreparedStatement preparedStatement = connection
				.prepareStatement("insert into cliente(nome, email) values(?, ?)");

		// passando os parametros do comando SQL
		preparedStatement.setString(1, cliente.getNome());
		preparedStatement.setString(2, cliente.getEmail());

		// executar o comando SQL e fechar a conexão com o banco de dados

		preparedStatement.execute();
		connection.close();

	}

	// método para atualizar os dados de um cliente no banco de dados
	public void update(Cliente cliente) throws Exception {

		// abrindo conexão com o banco de dados
		Connection connection = ConnectionFactory.createConnection();

		// executando um comando SQL no banco de dados para atualizar o cliente
		PreparedStatement preparedStatement = connection
				.prepareStatement("update cliente set nome = ?, email=? where idcliente=?"); //update sem where

		// passando os parametros do comando SQL
		preparedStatement.setString(1, cliente.getNome()); //posição 1
		preparedStatement.setString(2, cliente.getEmail()); //posição 2
		preparedStatement.setInt(3, cliente.getIdCliente()); //posição 3

		// executar o comando SQL e fechar a conexão com o banco de dados
		preparedStatement.execute();
		connection.close();

	}

	// método para excluir um cliente no banco de dados
	public void delete(Cliente cliente) throws Exception {

		// abrindo conexão com o banco de dados
		Connection connection = ConnectionFactory.createConnection();

		// executando um comando SQL no banco de dados para excluir o cliente
		PreparedStatement preparedStatement = connection.prepareStatement("delete from cliente where idcliente=?"); //identificar o que será excluído

		// passando os parametros do comando SQL
		preparedStatement.setInt(1, cliente.getIdCliente());

		// executar o comando SQL e fechar a conexão com o banco de dados
		preparedStatement.execute();
		connection.close();
	}

	// método para retornar todos os clientes cadastrados no banco de dados
	public List<Cliente> findAll() throws Exception {

		// abrindo conexão com o banco de dados
		Connection connection = ConnectionFactory.createConnection(); // connection = guarda a conexão com o banco de dados

		// executando um comando SQL no banco de dados para excluir o cliente
		PreparedStatement preparedStatement = connection.prepareStatement("select * from cliente");

		// ler e armazenar os registros obtidos da consulta do banco de dados
		ResultSet resultSet = preparedStatement.executeQuery(); //consulta do banco de dados

		// declarando uma lista de clientes vazia
		List<Cliente> lista = new ArrayList<Cliente>();

		// percorrendo cada registro obtido do banco de dados
		while (resultSet.next()) { //enquanto tiver registro é para ler
			Cliente cliente = new Cliente(); //criando um objeto cliente

			cliente.setIdCliente(resultSet.getInt("idcliente"));
			cliente.setNome(resultSet.getString("nome"));
			cliente.setEmail(resultSet.getString("email"));

			lista.add(cliente); // adicionar o cliente na lista
		}

		// fechando a conexão com o banco de dados
		connection.close();

		// retornando a lista
		return lista;
	}

	// método para retornar 1 cliente cadastrados no banco de dados através do ID
	public Cliente findById(Integer idCliente) throws Exception {

		// abrindo conexão com o banco de dados
		Connection connection = ConnectionFactory.createConnection();

		// executando um comando SQL no banco de dados para excluir o cliente
		PreparedStatement preparedStatement = connection.prepareStatement("select * from cliente where idcliente=?");
		preparedStatement.setInt(1, idCliente);

		// ler e armazenar os registros obtidos no banco de dados
		ResultSet resultSet = preparedStatement.executeQuery();

		// criando um objeto Cliente vazio
		Cliente cliente = null;

		// verificando se algum cliente foi encontrado no banco de dados
		while (resultSet.next()) {

			cliente = new Cliente();

			cliente.setIdCliente(resultSet.getInt("idcliente"));
			cliente.setNome(resultSet.getString("nome"));
			cliente.setEmail(resultSet.getString("email"));

		}

		// fechando a conexão com o banco de dados
		connection.close();

		// retornando a lista
		return cliente;

	}
}