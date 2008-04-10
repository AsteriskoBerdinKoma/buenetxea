package buenetxea.kudeatzaileak;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	
	 Cliente getCliente (int nan) throws IOException, SQLException
	{
		 	 int dni;
			 String nombre;
			 String apellido1;
			 String apellido2;
			 String fecha;
			 int telefono;
			 String medio;
			 String asesor; 
			 String query = " SELECT * FROM Cliente WHERE dni = ?";
				PreparedStatement ps = this.connection.prepareStatement(query);
				ps.setInt(1, nan);
				ResultSet rs = this.statement.executeQuery(query);
				if (rs.next())
				{
					dni=rs.getInt("dni");
					nombre= rs.getString("nombre");
					apellido1= rs.getString("apellido1");
					apellido2= rs.getString("apellido2");
					fecha= rs.getString("fecha");
					telefono=rs.getInt("telefono");
					medio=rs.getString("medio");
					asesor=rs.getString("asesor");
					return new Cliente (dni,nombre,apellido1,apellido2,fecha,telefono,medio,asesor);
				}
				else
					return null;
	}
	
	
	
}