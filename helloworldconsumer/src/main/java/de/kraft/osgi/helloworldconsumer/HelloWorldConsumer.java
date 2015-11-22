package de.kraft.osgi.helloworldconsumer;

import de.kraft.osgi.helloworldprovider.HelloWorldService;
import org.osgi.framework.ServiceReference;

public class HelloWorldConsumer implements org.osgi.framework.BundleActivator
{
//    Logger LOG = LoggerFactory.getLogger( HelloWorldConsumer.class );

    public void start( org.osgi.framework.BundleContext bundleContext ) throws Exception
    {
        System.out.println( "HelloWorldConsumer bundle is being started..." );
//        LOG.debug( "HelloWorldConsumer bundle is being started..." );
//        LOG.debug( "Getting reference of HelloWorld Service..." );
        ServiceReference reference = bundleContext.getServiceReference( HelloWorldService.class.getName() );
        HelloWorldService helloWorldService = ( ( HelloWorldService ) bundleContext.getService( reference ) );
        helloWorldService.helloWorld();
    }

    public void stop( org.osgi.framework.BundleContext bundleContext ) throws Exception
    {
//        LOG.debug( "HelloWorldConsumer is being stopped..." );
    }
}
