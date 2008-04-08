package buenetxea.kudeatzaileak;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import buenetxea.db.Connector;
import buenetxea.objektuak.Cliente;
public class ClienteKud {

	private final Connection connection;
	private final Statement statement;
	
	public ClienteKud(Connector conector) {
		
		this.connection=conector.getConnection();
		this.statement=conector.getStatement();
	}
	
	 Cliente getCliente (int dni) throws IOException
	{
		return null;
	}
	
	
	
}