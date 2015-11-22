package de.kraft.osgi.helloworldprovider;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.log.LogService;

public class ProviderActivator implements BundleActivator
{
    ServiceReference ref;
    LogService LOG;

    public void start( BundleContext bundleContext )
    {
//        LOG = getLogger( bundleContext );
//        log( "HelloWorldProvider is being started..." );
//        log( "Registering HelloWorldService..." );
        bundleContext.registerService( de.kraft.osgi.helloworldprovider.HelloWorldService.class.getName(),
                new de.kraft.osgi.helloworldprovider.HelloWorldProvider(), null );
    }

    public void stop( BundleContext bundleContext )
    {
        log( "HelloWorldProvider is being stopped..." );
    }

    private LogService getLogger( BundleContext bundleContext )
    {
        ref = bundleContext.getServiceReference( LogService.class.getName() );
        return ( LogService ) bundleContext.getService( ref );
    }

    private void log( String log )
    {
//        LOG.log( LOG_DEBUG, log );
        System.out.println( log );
    }
}
