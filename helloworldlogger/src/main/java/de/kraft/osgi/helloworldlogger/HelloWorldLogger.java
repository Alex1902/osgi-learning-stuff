package de.kraft.osgi.helloworldlogger;

public class HelloWorldLogger implements HelloWorldLoggerService
{
//    private static final Logger LOG = org.slf4j.LoggerFactory.getLogger( HelloWorldLogger.class );

    public void debug( final String msg )
    {
        System.out.println( msg );
//        LOG.debug( msg );
    }
}
