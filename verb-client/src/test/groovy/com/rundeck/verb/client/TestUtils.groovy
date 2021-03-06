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
package com.rundeck.verb.client


class TestUtils {

    static void buildGradle(File baseDir) {
        Process p = new ProcessBuilder("gradle","build").directory(baseDir).start()
        p.waitFor()
    }

    static void copyToTestBinaryArtifactsResourceLocation(String fileSource) {
        File source = new File(fileSource)
        File destDir = new File(System.getProperty("user.dir")+"/src/test/resources/binary-artifacts")
        File destFile = new File(destDir,source.name)

        source.withInputStream {
            destFile << it
        }
    }
}
