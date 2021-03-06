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
package com.rundeck.verb.client.validators

import com.rundeck.verb.Constants
import com.rundeck.verb.ResponseBatch
import com.rundeck.verb.ResponseCodes
import com.rundeck.verb.ResponseMessage
import com.rundeck.verb.client.yaml.YamlValidator
import com.rundeck.verb.validator.ArtifactMetaValidator


class YamlArtifactMetaValidator implements ArtifactMetaValidator {
    private YamlValidator validator = new YamlValidator(Constants.RUNDECK_VERB_SCHEMA_ROOT)
    private String schemaResourcePath = "schemas/artifact/"+Constants.ARTIFACT_META_SCHEMA_VERSION+"/"+Constants.ARTIFACT_SCHEMA_FILE_NAME
    private Reader reader = new InputStreamReader(getClass().getClassLoader().getResourceAsStream(schemaResourcePath))

    @Override
    ResponseBatch validate(final InputStream artifactMetaStream) {
        ResponseBatch responseBatch = new ResponseBatch()
        def result = validator.validate(artifactMetaStream,reader)
        if(result.success) {
            responseBatch.messages.add(new ResponseMessage(code: ResponseCodes.SUCCESS))
            return responseBatch
        }
        result.iterator().each {
            responseBatch.messages.add(new ResponseMessage(code: ResponseCodes.META_VALIDATION_FAILURE, message: it.logLevel.name()+ ":"+ it.message))
        }
        responseBatch
    }
}
