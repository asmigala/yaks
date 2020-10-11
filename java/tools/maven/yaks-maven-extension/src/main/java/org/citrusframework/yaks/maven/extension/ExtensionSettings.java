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

package org.citrusframework.yaks.maven.extension;

/**
 * @author Christoph Deppisch
 */
public final class ExtensionSettings {

    public static final String FEATURE_FILE_EXTENSION = ".feature";

    public static final String TESTS_PATH_KEY = "yaks.tests.path";
    public static final String TESTS_PATH_ENV = "YAKS_TESTS_PATH";

    public static final String SETTINGS_FILE_DEFAULT = "classpath:yaks.properties";
    public static final String SETTINGS_FILE_KEY = "yaks.settings.file";
    public static final String SETTINGS_FILE_ENV = "YAKS_SETTINGS_FILE";

    public static final String DEPENDENCIES_SETTING_KEY = "yaks.dependencies";
    public static final String DEPENDENCIES_SETTING_ENV = "YAKS_DEPENDENCIES";

    public static final String REPOSITORIES_SETTING_KEY = "yaks.repositories";
    public static final String REPOSITORIES_SETTING_ENV = "YAKS_REPOSITORIES";

    public static final String LOGGERS_SETTING_KEY = "yaks.loggers";
    public static final String LOGGERS_SETTING_ENV = "YAKS_LOGGERS";
    public static final String LOGGING_LEVEL_PREFIX = "logging.level.";

    /**
     * Prevent instantiation of utility class.
     */
    private ExtensionSettings() {
        // utility class
    }

    /**
     * Gets the external tests path mount. Usually added to the runtime image via volume mount using config map.
     * @return
     */
    public static String getMountedTestsPath() {
        return System.getProperty(ExtensionSettings.TESTS_PATH_KEY, System.getenv(ExtensionSettings.TESTS_PATH_ENV) != null ?
                System.getenv(ExtensionSettings.TESTS_PATH_ENV) : "");
    }

    /**
     * Checks for mounted tests path setting.
     * @return
     */
    public static boolean hasMountedTests() {
        return getMountedTestsPath().length() > 0;
    }

    /**
     * Gets the settings file path from configured in this environment.
     * @return
     */
    public static String getSettingsFilePath() {
        return System.getProperty(ExtensionSettings.SETTINGS_FILE_KEY, System.getenv(ExtensionSettings.SETTINGS_FILE_ENV) != null ?
                System.getenv(ExtensionSettings.SETTINGS_FILE_ENV) : ExtensionSettings.SETTINGS_FILE_DEFAULT);
    }
}
