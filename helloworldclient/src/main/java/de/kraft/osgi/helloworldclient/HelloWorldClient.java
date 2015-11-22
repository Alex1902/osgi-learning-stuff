package de.kraft.osgi.helloworldclient;

import org.apache.felix.framework.Felix;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

import java.util.Map;

public class HelloWorldClient
{
    public static void main( String[] args )
    {
        try
        {
            // Initialize Apache Felix Framework
            Map<String, String> configMap = new java.util.HashMap<String, String>();
            configMap.put( "org.osgi.framework.storage.clean", "onFirstInit" );

            Felix framework = new Felix( configMap );
            framework.init();

            // Install bundles
            BundleContext context = framework.getBundleContext();
            Bundle logger = context.installBundle( "file:C:\\work\\Projects\\Java\\osgi-learning-stuff\\helloworldlogger\\target\\helloworldlogger-1.0-SNAPSHOT.jar" );
            Bundle provider = context.installBundle( "file:C:\\work\\Projects\\Java\\osgi-learning-stuff\\helloworldprovider\\target\\helloworldprovider-1.0-SNAPSHOT.jar" );
            Bundle consumer = context.installBundle( "file:C:\\work\\Projects\\Java\\osgi-learning-stuff\\helloworldconsumer\\target\\helloworldconsumer-1.0-SNAPSHOT.jar" );

            // Start and stop framework and bundles
            framework.start();

            logger.start();
            provider.start();
            consumer.start();

            framework.stop();
        } catch( Exception exception )
        {
            System.err.println( "Error while executing program: " + exception );
            exception.printStackTrace();
            System.exit( 0 );
        }
    }
}
