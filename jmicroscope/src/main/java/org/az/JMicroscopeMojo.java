package org.az;

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

import org.apache.maven.model.Dependency;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Goal which touches a timestamp file.
 *
 * @goal touch
 * 
 * @phase process-sources
 */
@Mojo(name = "jmicroscope", defaultPhase = LifecyclePhase.PACKAGE)
public class JMicroscopeMojo    extends AbstractMojo {

    @Parameter(defaultValue = "${project}", required = true, readonly = true)
    private MavenProject project;

    @Parameter(property = "scope")
    String scope;


    /**
     * Location of the file.
     * @parameter expression="${project.build.directory}"
     * @required
     */
    //@Parameter(property = "${project.build.directory}")
    //private File outputDirectory;

    public void execute()   throws MojoExecutionException   {


        getLog().info("Java microscope: ");

        System.out.println("-------------------------------------------");
        System.out.println(project);
        System.out.println(scope);
        System.out.println(project.getBuild().getOutputDirectory());
        System.out.println("-------------------------------------------");

        List<Dependency> dependencies = project.getDependencies();
        long numDependencies = dependencies.stream().count();
        getLog().info("Number of dependencies: " + numDependencies);

        /*try {
            File f = outputDirectory;

            if ( !f.exists() )
            {
                f.mkdirs();
            }

            File touch = new File( f, "touch.txt" );

            FileWriter w = null;
            try
            {
                w = new FileWriter( touch );

                w.write( "touch.txt" );
            }
            catch ( IOException e )
            {
                throw new MojoExecutionException( "Error creating file " + touch, e );
            }
            finally
            {
                if ( w != null )
                {
                    try
                    {
                        w.close();
                    }
                    catch ( IOException e )
                    {
                        // ignore
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/


    }
}
