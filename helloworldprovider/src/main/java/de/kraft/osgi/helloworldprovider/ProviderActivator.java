package de.kraft.osgi.helloworldprovider;

import de.kraft.osgi.helloworldlogger.HelloWorldLoggerService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class ProviderActivator implements BundleActivator
{
    private HelloWorldLoggerService logger;

    public void start( BundleContext bundleContext )
    {
        logger = getLogger( bundleContext );
        logger.debug( "HelloWorldProvider is being started..." );
        bundleContext.registerService( HelloWorldService.class.getName(), new HelloWorldProvider( logger ), null );
    }

    public void stop( BundleContext bundleContext )
    {
        logger.debug( "HelloWorldProvider is being stopped..." );
    }

    private HelloWorldLoggerService getLogger( BundleContext bundleContext )
    {
        ServiceReference ref = bundleContext.getServiceReference( HelloWorldLoggerService.class.getName() );
        return (HelloWorldLoggerService) bundleContext.getService( ref );
    }
}
