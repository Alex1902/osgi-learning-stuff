package de.kraft.osgi.helloworldlogger;

public class HelloWorldLogger implements HelloWorldLoggerService
{
    public void debug( final String msg )
    {
        System.out.println( msg );
    }
}
