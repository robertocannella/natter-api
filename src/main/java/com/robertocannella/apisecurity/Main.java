package com.robertocannella.apisecurity;

import java.nio.file.*;


import org.dalesbred.Database;
import org.dalesbred.result.EmptyResultException;
import org.h2.jdbcx.JdbcConnectionPool;
import org.json.*;


public class Main {

    public static void main(String... args) throws Exception {
        JdbcConnectionPool dataSource = JdbcConnectionPool.create(
                "jdbc:h2:mem:natter", "natter", "password"
        );
        Database db = Database.forDataSource(dataSource);
        createTables(db);

    }

    private static void createTables(Database db)  throws  Exception{
        Path path = Paths.get(Main.class.getResource("/schema.sql").toURI());
        db.update(Files.readString(path));
    }
}