/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.citrusframework.yaks.maven.extension.configuration;

import java.util.Optional;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.appender.ConsoleAppender;
import org.apache.logging.log4j.core.config.LoggerConfig;
import org.apache.logging.log4j.core.config.builder.api.AppenderComponentBuilder;
import org.apache.logging.log4j.core.config.builder.api.ConfigurationBuilder;
import org.apache.logging.log4j.core.config.builder.api.ConfigurationBuilderFactory;
import org.apache.logging.log4j.core.config.builder.impl.BuiltConfiguration;
import org.apache.maven.lifecycle.LifecycleExecutionException;
import org.codehaus.plexus.logging.Logger;

/**
 * @author Christoph Deppisch
 */
@FunctionalInterface
public interface LoggingConfigurationLoader {

    /**
     * Load logging configuration from configuration sources.
     *
     * @param builder
     * @param logger
     * @return root logger level if any is set
     */
    Optional<Level> load(ConfigurationBuilder<BuiltConfiguration> builder, Logger logger) throws LifecycleExecutionException;

    /**
     * Configure logger on given logger context with logger name and level.
     * @param loggerName
     * @param level
     * @param builder
     * @param logger
     * @return root logger level if any is set
     */
    default Optional<Level> configureLogger(String loggerName, String level, ConfigurationBuilder<BuiltConfiguration> builder, Logger logger) {
        Level root = null;
        if (LoggerConfig.ROOT.equals(loggerName)) {
            root = Level.getLevel(level.toUpperCase());
        } else {
            builder.add(builder.newLogger(loggerName, Level.getLevel(level.toUpperCase()))
                               .add(builder.newAppenderRef("STDOUT"))
                               .addAttribute("additivity", false));
            logger.info(String.format("Set logging level %s on logger '%s'", level.toUpperCase(), loggerName));
        }

        return Optional.ofNullable(root);
    }

    static ConfigurationBuilder<BuiltConfiguration> newConfigurationBuilder() {
        final ConfigurationBuilder<BuiltConfiguration> builder = ConfigurationBuilderFactory.newConfigurationBuilder();

        AppenderComponentBuilder appenderBuilder = builder.newAppender("STDOUT", "Console").addAttribute("target",
                ConsoleAppender.Target.SYSTEM_OUT);
        appenderBuilder.add(builder.newLayout("PatternLayout")
                .addAttribute("pattern", "%d{yyyy-MM-dd HH:mm:ss.SSS}|%-5level|%t|%c{1} - %msg%n"));
        builder.add( appenderBuilder );

        return builder;
    }
}
