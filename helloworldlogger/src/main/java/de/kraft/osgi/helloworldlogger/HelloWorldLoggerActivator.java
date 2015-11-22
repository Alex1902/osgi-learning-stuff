package de.kraft.osgi.helloworldlogger;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class HelloWorldLoggerActivator implements BundleActivator
{
    public void start( final BundleContext bundleContext ) throws Exception
    {
        System.out.println( "Starting Logger..." );
        bundleContext.registerService( HelloWorldLoggerService.class.getName(), new HelloWorldLogger(), null );
    }

    public void stop( final BundleContext bundleContext ) throws Exception
    {
        System.out.println( "Stopping Logger..." );
    }
}
