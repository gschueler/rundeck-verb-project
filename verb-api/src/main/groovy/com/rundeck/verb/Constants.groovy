/*
 * Copyright 2018 Rundeck, Inc. (http://rundeck.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.rundeck.verb


class Constants {
    static final String RUNDECK_VERB_SCHEMA_ROOT        = "http://verb.rundeck.com/schemas/"
    static final String ARTIFACT_SCHEMA_FILE_NAME       = "artifact.schema"
    static final String ARTIFACT_META_FILE_NAME         = "rundeck-verb-artifact.yaml"
    static final String ARTIFACT_META_SCHEMA_VERSION    = "1.0"
    static final String VERB_CLIENT_CONFIG_FILE         = System.getProperty("user.home")+"/.rundeck/rundeck-verb.properties"
}