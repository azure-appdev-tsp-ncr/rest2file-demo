package com.rest2file.function.output;

import java.util.*;
import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;

/**
 * Azure Functions with Service Bus Queue Trigger.
 */
public class Function {
    /**
     * This function listens at queue "inbound2file" in the specified Service Bus Namespace. 
     * Function Key is not needed when running locally, it is used to invoke function deployed to Azure.
     * More details: https://aka.ms/functions_authorization_keys
     */
    @FunctionName("sbprocessor")
    public void serviceBusProcess(
     @ServiceBusQueueTrigger(name = "msgRest2FileInput",
                             queueName = "inbound2file",
                             connection = "Endpoint=sb://ghtsp-demo01.servicebus.windows.net/;SharedAccessKeyName=RootManageSharedAccessKey;SharedAccessKey=9wTygq0UwoHVbcN8tvNVbrvTVuZ02xK2jcRN5U2eWKg=") String message,
     final ExecutionContext context
    ) {
     context.getLogger().info(message);
    }
}
