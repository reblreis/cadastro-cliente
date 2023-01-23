package factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	//método para criar e retorar conexão com o banco de dados.
	//static = não cria algo novo, não modifica outros objetos, não cria outro objeto.
	//static = ideal para conexão, porque sempre será a mesma conexão.
	//static diferente da instância = nome da classe. nome do método.
	
	public static Connection createConnection() throws Exception {
		
		//parâmetros para conexão com o banco de dados
		
		String driver = "org.postgresql.Driver";
		String server = "jdbc:postgresql://localhost:5432/bd_projeto05";
		String user = "postgres";
		String password = "coti";
		
		//Carregando o driver JDBC para conexão com o PostGresSQL
		
		Class.forName(driver);
		
		//fazendo a conexão com o banco de dados, utilizando
		//o caminho do banco, usuário e senha de administrador

		
		return DriverManager.getConnection(server, user, password) ;
	
	}
}