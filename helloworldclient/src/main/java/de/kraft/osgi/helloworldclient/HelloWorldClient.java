package de.kraft.osgi.helloworldclient;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

public class HelloWorldClient
{
//    static Logger LOG = LoggerFactory.getLogger( HelloWorldClient.class );

    public static void main( String[] args )
    {
        try
        {
            // Initialize Apache Felix Framework
            java.util.Map<String, String> configMap = new java.util.HashMap<String, String>();
            configMap.put( "FRAMEWORK_STORAGE_CLEAN", "onFirstInit" );

            org.apache.felix.framework.Felix framework = new org.apache.felix.framework.Felix( configMap );
            framework.init();
//            LOG.debug( "Felix framework initialized." );

            // Install bundles
            BundleContext context = framework.getBundleContext();
            Bundle provider = context.installBundle( "file:C:\\path\\to\\bundle\\helloworldprovider-1.0-SNAPSHOT.jar" );
            Bundle consumer = context.installBundle( "file:C:\\path\\to\\bundl\\helloworldconsumer-1.0-SNAPSHOT.jar" );

            // Start and stop framework and bundles
            framework.start();
            provider.start();
            consumer.start();
            framework.stop();
        } catch( Exception exception )
        {
            System.err.println( "Error while executing program: " + exception );
//            LOG.error( "Error while executing program: " + exception );
            exception.printStackTrace();
            System.exit( 0 );
        }
    }
}
