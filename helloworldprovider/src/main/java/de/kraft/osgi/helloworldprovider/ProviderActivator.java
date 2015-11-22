package de.kraft.osgi.helloworldprovider;

import de.kraft.osgi.helloworldlogger.HelloWorldLoggerService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class ProviderActivator implements BundleActivator
{
    HelloWorldLoggerService LOG;

    public void start( BundleContext bundleContext )
    {
        LOG = getLogger( bundleContext );
        log( "HelloWorldProvider is being started..." );
//        log( "Registering HelloWorldService..." );
        bundleContext.registerService( de.kraft.osgi.helloworldprovider.HelloWorldService.class.getName(),
                new de.kraft.osgi.helloworldprovider.HelloWorldProvider(), null );
    }

    public void stop( BundleContext bundleContext )
    {
        log( "HelloWorldProvider is being stopped..." );
    }

    private HelloWorldLoggerService getLogger( BundleContext bundleContext )
    {
        ServiceReference ref = bundleContext.getServiceReference( HelloWorldLoggerService.class.getName() );
        return ( HelloWorldLoggerService ) bundleContext.getService( ref );
    }

    private void log( String log )
    {
        LOG.debug( log );
        System.out.println( log );
    }
}
