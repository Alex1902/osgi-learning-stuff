package de.kraft.osgi.helloworldprovider;

import de.kraft.osgi.helloworldlogger.HelloWorldLoggerService;

public class HelloWorldProvider implements HelloWorldService
{
    private final HelloWorldLoggerService logger;

    public HelloWorldProvider( HelloWorldLoggerService logger )
    {
        this.logger = logger;
    }

    public void helloWorld()
    {
        logger.debug( "=== Hello World! ===" );
    }
}
