package entities;

public class Cliente {
	
	//PRINCIPAL OBJETO
	
	
		private Integer IdCliente;
		private String nome;
		private String email;

		// primeiro construtor

		public Cliente() {
			// TODO Auto-generated constructor stub
		}

		// segundo construtor

		public Cliente(Integer idCliente, String nome, String email) {
			super();
			IdCliente = idCliente;
			this.nome = nome;
			this.email = email;
		}
		
		// métodos para encapsulamento

		public Integer getIdCliente() {
			return IdCliente;
		}

		public void setIdCliente(Integer idCliente) {
			IdCliente = idCliente;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

}