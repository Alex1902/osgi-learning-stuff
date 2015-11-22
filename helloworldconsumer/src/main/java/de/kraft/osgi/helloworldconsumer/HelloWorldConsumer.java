package de.kraft.osgi.helloworldconsumer;

import de.kraft.osgi.helloworldlogger.HelloWorldLoggerService;
import de.kraft.osgi.helloworldprovider.HelloWorldService;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class HelloWorldConsumer implements org.osgi.framework.BundleActivator
{
    private HelloWorldLoggerService logger;

    public void start( org.osgi.framework.BundleContext bundleContext ) throws Exception
    {
        logger = getLogger( bundleContext );
        logger.debug( "HelloWorldConsumer bundle is being started..." );
        logger.debug( "Getting reference of HelloWorld Service..." );
        ServiceReference reference = bundleContext.getServiceReference( HelloWorldService.class.getName() );
        HelloWorldService helloWorldService = ((HelloWorldService) bundleContext.getService( reference ));
        helloWorldService.helloWorld();
    }

    public void stop( org.osgi.framework.BundleContext bundleContext ) throws Exception
    {
        logger.debug( "HelloWorldConsumer is being stopped..." );
    }

    private HelloWorldLoggerService getLogger( BundleContext bundleContext )
    {
        ServiceReference ref = bundleContext.getServiceReference( HelloWorldLoggerService.class.getName() );
        return (HelloWorldLoggerService) bundleContext.getService( ref );
    }
}
