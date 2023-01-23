package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import entities.Cliente;
import factories.ConnectionFactory;

public class ClienteRepository {

	// método para gravar um cliente no banco de dados
	public void create(Cliente cliente) throws Exception {
		
		//abrindo conexão com o banco de dados
		
		Connection connection = ConnectionFactory.createConnection();
	
		//executando um comando SQL no banco de dados para cadastrar o cliente
		
		PreparedStatement preparedStatement = connection.prepareStatement("insert into cliente(nome, email) values(?, ?)");

		//passando os parametros do comando SQL
		preparedStatement.setString(1, cliente.getNome());
		preparedStatement.setString(2, cliente.getEmail());
		
		//executar o comando SQL e fechar a conexão com o banco de dados
		
		preparedStatement.execute();
		connection.close();
		
	}

	// método para atualizar os dados de um cliente no banco de dados
	public void update(Cliente cliente) throws Exception {
		// TODO
	}

	// método para excluir um cliente no banco de dados 
	public void delete(Cliente cliente) throws Exception {
		// TODO
	}
	
	// método para retornar todos os clientes cadastrados no banco de dados
	public List<Cliente> findAll() throws Exception {
		// TODO
		return null;
	}

}