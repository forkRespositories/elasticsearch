/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the Elastic License;
 * you may not use this file except in compliance with the Elastic License.
 */
package org.elasticsearch.xpack.qa.sql.security;

import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.xpack.qa.sql.jdbc.FetchSizeTestCase;

import java.util.Properties;

public class JdbcFetchSizeIT extends FetchSizeTestCase {
    @Override
    protected Settings restClientSettings() {
        return RestSqlIT.securitySettings();
    }

    @Override
    protected String getProtocol() {
        return RestSqlIT.SSL_ENABLED ? "https" : "http";
    }

    @Override
    protected Properties connectionProperties() {
        Properties properties = super.connectionProperties();
        properties.putAll(JdbcSecurityIT.adminProperties());
        return properties;
    }
}
