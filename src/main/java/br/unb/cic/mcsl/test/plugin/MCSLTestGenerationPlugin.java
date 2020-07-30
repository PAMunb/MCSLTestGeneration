package br.unb.cic.mcsl.test.plugin;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * TestCase generator for MetaCrySL
 *
 * @goal gentest
 * 
 * @phase process-sources
 */
public class MCSLTestGenerationPlugin extends AbstractMojo
{
    /**
     * Location of the file.
     * @parameter property="${project.build.directory}"
     * @required
     */
    private File inputDirectory;

    public void execute()  throws MojoExecutionException
    {
        File f = inputDirectory;

        if ( f.exists() && f.isDirectory())
        {
            for(File aFile: f.listFiles()) {
                System.out.println(aFile.getAbsoluteFile());
            }
        }
        else {
            throw new RuntimeException("Invalid path : " + f.getAbsolutePath());
        }
    }
}
