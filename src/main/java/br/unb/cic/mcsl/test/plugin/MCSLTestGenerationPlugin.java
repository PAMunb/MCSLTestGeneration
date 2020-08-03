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
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.TemplateNotFoundException;
import freemarker.template.Version;

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
    private List<TestObject> rules;

    public void execute()  throws MojoExecutionException
    {
        File f = inputDirectory;

        if ( f.exists() && f.isDirectory())
        {
        	Map<String, Object> input = new HashMap<String, Object>();
        	rules = new ArrayList<TestObject>();
            
            Configuration cfg = new Configuration();
            cfg.setClassForTemplateLoading(MCSLTestGenerationPlugin.class, "/templates");
            // Configuration
            cfg.setIncompatibleImprovements(new Version(2, 3, 20));
            cfg.setDefaultEncoding("UTF-8");
            cfg.setLocale(Locale.US);
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            
            
            for(File aFile: f.listFiles()) {
            	rules.add(new TestObject(aFile.getName(), aFile.getAbsolutePath()));
            }
            input.put("rules", rules);
            
            // Load template
            try {
            	Template template = cfg.getTemplate("testTemplate.ftl");
            	// Generate output to console
            	Writer consoleWriter = new OutputStreamWriter(System.out);
            	template.process(input, consoleWriter);
            	Writer fileWriter = new FileWriter(new File("MetaCrySLParsingTest.xtend"));
            } catch (Exception e) {
            	e.printStackTrace();
            }
        }
        else {
            throw new RuntimeException("Invalid path : " + f.getAbsolutePath());
        }
    }

    public List<TestObject> getRules() {
        return rules;
    }
}
