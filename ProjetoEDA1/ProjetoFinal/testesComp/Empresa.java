package testesComp;

public class Empresa {	
	private String Nome;
	private String Cnpj;
	private String InsEst;
	private String Data;
	private String Site;
	private String Email;
	private String Cep;
	private String Rua;
	private String Numero;
	private String Bairro;
	private String Cidade;
	private String Estado;
	private String Telefone;
	private String Celular;
	
	public Empresa(String nome, String cnpj, String insEst, String data, String site, String email, String cep,
			String rua, String numero, String bairro, String cidade, String estado, String telefone, String celular) {
		Nome = nome;
		Cnpj = cnpj;
		InsEst = insEst;
		Data = data;
		Site = site;
		Email = email;
		Cep = cep;
		Rua = rua;
		Numero = numero;
		Bairro = bairro;
		Cidade = cidade;
		Estado = estado;
		Telefone = telefone;
		Celular = celular;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getCnpj() {
		return Cnpj;
	}

	public void setCnpj(String cnpj) {
		Cnpj = cnpj;
	}

	public String getInsEst() {
		return InsEst;
	}

	public void setInsEst(String insEst) {
		InsEst = insEst;
	}

	public String getData() {
		return Data;
	}

	public void setData(String data) {
		Data = data;
	}

	public String getSite() {
		return Site;
	}

	public void setSite(String site) {
		Site = site;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getCep() {
		return Cep;
	}

	public void setCep(String cep) {
		Cep = cep;
	}

	public String getRua() {
		return Rua;
	}

	public void setRua(String rua) {
		Rua = rua;
	}

	public String getNumero() {
		return Numero;
	}

	public void setNumero(String numero) {
		Numero = numero;
	}

	public String getBairro() {
		return Bairro;
	}

	public void setBairro(String bairro) {
		Bairro = bairro;
	}

	public String getCidade() {
		return Cidade;
	}

	public void setCidade(String cidade) {
		Cidade = cidade;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public String getTelefone() {
		return Telefone;
	}

	public void setTelefone(String telefone) {
		Telefone = telefone;
	}

	public String getCelular() {
		return Celular;
	}

	public void setCelular(String celular) {
		Celular = celular;
	}
	
	@Override
	public String toString() {
		return "Empresa [Nome=" + Nome + ", Cnpj=" + Cnpj + ", InsEst=" + InsEst + ", Data=" + Data + ", Site=" + Site
				+ ", Email=" + Email + ", Cep=" + Cep + ", Rua=" + Rua + ", Numero=" + Numero + ", Bairro=" + Bairro
				+ ", Cidade=" + Cidade + ", Estado=" + Estado + ", Telefone=" + Telefone + ", Celular=" + Celular + "]";
	}
	
}
