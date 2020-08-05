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

package org.citrusframework.yaks.camelk.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Integration {

	public static final String CRD_GROUP = "camel.apache.org";
	public static final String CRD_VERSION = "v1";
	public static final String CRD_INTEGRATION_NAME = "integrations.camel.apache.org";

	private String apiVersion = CRD_GROUP + "/" + CRD_VERSION;
	private String kind = "Integration";

	private IntegrationMetadata metadata;
	private IntegrationSpec spec;

	public String getApiVersion() {
		return apiVersion;
	}

	public String getKind() {
		return kind;
	}

	public IntegrationMetadata getMetadata() {
		return metadata;
	}

	public IntegrationSpec getSpec() {
		return spec;
	}

	public static class IntegrationMetadata {
		private String name;

		public String getName() {
			return name;
		}
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private static class IntegrationSpec {
		List<Source> sources;
		List<String> dependencies;
		Map<String, TraitConfig> traits;

		public List<Source> getSources() {
			return sources;
		}

		public List<String> getDependencies() {
			return dependencies;
		}

		public Map<String, TraitConfig> getTraits() {
			return traits;
		}
	}

	public static class TraitConfig {
		Map<String,String> configuration;

		public TraitConfig(String key, String value) {
			this.configuration = new HashMap<>();
			add(key, value);
		}

		public Map<String, String> getConfiguration() {
			return configuration;
		}

		public String add(String key, String value) {
			return configuration.put(key, value);
		}
	}

	public static class Source {
		String content;
		String name;

		public Source(String name, String content) {
			this.content = content;
			this.name = name;
		}

		public String getContent() {
			return content;
		}

		public String getName() {
			return name;
		}
	}

	public static class Builder {
		private Map<String, TraitConfig> traits;
		private List<String> dependencies;
		private String source;
		private String name;

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder source(String source) {
			this.source = source;
			return this;
		}

		public Builder dependencies(List<String> dependencies) {
			this.dependencies = Collections.unmodifiableList(dependencies);
			return this;
		}

		public Builder traits(Map<String, TraitConfig> traits) {
			this.traits = Collections.unmodifiableMap(traits);
			return this;
		}

		public Integration build() {
			Integration i = new Integration();
			i.metadata = new IntegrationMetadata();
			i.metadata.name = name.substring(0, name.indexOf("."));
			i.spec = new IntegrationSpec();
			i.spec.sources = Collections.singletonList(new Source(name, source));
			i.spec.dependencies = dependencies;
			i.spec.traits = traits;
			return i;
		}
	}
}
