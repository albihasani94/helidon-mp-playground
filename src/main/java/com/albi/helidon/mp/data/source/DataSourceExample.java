package com.albi.helidon.mp.data.source;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Path("tables")
@ApplicationScoped
public class DataSourceExample {

    @Inject
    @Named("test")
    private DataSource testDataSource;

    @GET
    @Produces("text/plain")
    public String getTableNames() throws SQLException {
        StringBuilder sb = new StringBuilder();
        try (Connection connection = this.testDataSource.getConnection();
             PreparedStatement ps =
                     connection.prepareStatement(" SELECT TABLE_NAME"
                             + " FROM INFORMATION_SCHEMA.TABLES "
                             + "ORDER BY TABLE_NAME ASC");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                sb.append(rs.getString(1)).append("\n");
            }
        }
        return sb.toString();
    }

}
