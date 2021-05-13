package pl.rhino.code.integration.tests.dao;

import org.testcontainers.containers.PostgreSQLContainer;

public class OutCaloriesPostgresqlContainer extends PostgreSQLContainer<OutCaloriesPostgresqlContainer> {
    private static final String IMAGE_VERSION = "postgres:11.1";
    private static OutCaloriesPostgresqlContainer container;

    private OutCaloriesPostgresqlContainer() {
        super(IMAGE_VERSION);
    }

    public static OutCaloriesPostgresqlContainer getInstance() {
        if (container == null) {
            container = new OutCaloriesPostgresqlContainer();
        }
        return container;
    }

    @Override
    public void start() {
        super.start();
        System.setProperty("DB_URL", container.getJdbcUrl());
        System.setProperty("DB_USERNAME", container.getUsername());
        System.setProperty("DB_PASSWORD", container.getPassword());
    }

    @Override
    public void stop() {
        //do nothing, JVM handles shut down
    }
}
