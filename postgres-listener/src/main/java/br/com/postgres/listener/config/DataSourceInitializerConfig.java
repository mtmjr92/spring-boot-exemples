package br.com.postgres.listener.config;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class DataSourceInitializerConfig {

    private final DataSource dataSource;

    @PostConstruct
    public void initializeDatabase() throws IOException, SQLException {
        Resource[] resources = new PathMatchingResourcePatternResolver()
                .getResources("classpath:db/*.sql");

        for (Resource resource : resources) {
            log.info("Executing script: " + resource.getFilename());

            ScriptUtils.executeSqlScript(dataSource.getConnection(), new EncodedResource(resource, "UTF-8"),
                    false, false, ScriptUtils.DEFAULT_COMMENT_PREFIX, ";;",
                    ScriptUtils.DEFAULT_BLOCK_COMMENT_START_DELIMITER, ScriptUtils.DEFAULT_BLOCK_COMMENT_END_DELIMITER);

        }

    }

}
