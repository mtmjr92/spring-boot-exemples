package br.com.postgres.listener.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.postgresql.PGConnection;
import org.postgresql.PGNotification;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

@RequiredArgsConstructor
@Log4j2
@Service
public class DatabaseListenerService {

    private final JdbcTemplate jdbcTemplate;

    @PostConstruct
    private void setUpListener() {
        new Thread(() -> {
            try (Connection connection = Objects.requireNonNull(jdbcTemplate.getDataSource()).getConnection()) {
                PGConnection pgConnection = connection.unwrap(PGConnection.class);

                try (Statement stmt = connection.createStatement()) {
                    stmt.execute("LISTEN random_number_change");
                }

                while (true) {
                    PGNotification[] notifications = pgConnection.getNotifications();

                    if (Objects.nonNull(notifications)) {
                        for (PGNotification notification : notifications) {
                            log.info("Received notification: " + notification.getParameter());
                        }
                    }

                    Thread.sleep(5000);
                }
            } catch (InterruptedException | SQLException e) {
                log.error(e.getMessage());
                Thread.currentThread().interrupt();
            }
        }).start();
    }

}
