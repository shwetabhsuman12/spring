# Spring Webflux-Event looping non blocking code- Reactive programming
This is sample code which works on event looping non blocking mechanism . It is using spring webflux . Spring uses Mono and Flux as its variant of completablefuture to generate the non blocking mechanism.It contains the context of each request and delegates the request for IO and other operations.Meanwhile servlet thread is left  to process another request. Once the IO operation of the first thread is done, it will send the response back to existing connection with the requesting consumer.

For this to work  reactive programming should be done at each segment.For this to happen I am using Mono /Flux in all the segments - Controller,Service,DAO and using spring provided redis reactive jars.

This current program takes name and  message  in the post operation and returns get operation  with name and message by feeding the name

Used docker redis for testing.

This can be used to use minimum resources to handle more number of threads w.r.t Spring mvc where we have one thread per request .
