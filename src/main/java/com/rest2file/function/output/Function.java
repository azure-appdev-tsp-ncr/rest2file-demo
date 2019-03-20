package com.rest2file.function.output;

import java.util.*;

import javax.activity.InvalidActivityException;
import javax.management.relation.InvalidRoleValueException;

import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;
// Include the following imports to use blob APIs.
import com.microsoft.azure.storage.*;
import com.microsoft.azure.storage.file.*;

/**
 * Azure Functions with Service Bus Queue Trigger.
 */
public class Function {
    // Retrieve the credentials and initialize SharedKeyCredentials
    public static final String accountName = System.getenv("AZURE_STORAGE_ACCOUNT");
    public static final String accountKey = System.getenv("AZURE_STORAGE_ACCESS_KEY");
    public static final String storageConnectionString = "DefaultEndpointsProtocol=http;" + "AccountName=" + accountName
            + ";" + "AccountKey=" + accountKey;

    /**
     * This function listens at queue "inbound2file" in the specified Service Bus
     * Namespace. Function Key is not needed when running locally, it is used to
     * invoke function deployed to Azure. More details:
     * https://aka.ms/functions_authorization_keys
     */
    @FunctionName("sbprocessor")
    public void serviceBusProcess(
            @ServiceBusQueueTrigger(name = "msgRest2FileInput", queueName = "inbound2file", connection = "nteDemoSBConnection") String message,
            final ExecutionContext context) {
        context.getLogger().info(message);
        // Use the CloudStorageAccount object to connect to your storage account
        try {
            CloudStorageAccount storageAccount = CloudStorageAccount.parse(storageConnectionString);
            // Create the Azure Files client.
            CloudFileClient fileClient = storageAccount.createCloudFileClient();
            // Get a reference to the file share
            CloudFileShare share = fileClient.getShareReference("rest2file-input");
            // Get a reference to the root directory for the share.
            CloudFileDirectory rootDir = share.getRootDirectoryReference();
            // Get a reference to the directory you want to delete
            CloudFileDirectory containerDir = rootDir.getDirectoryReference("contact-demo");
            // Create File from SB Message
            CloudFile rest2file = containerDir.getFileReference("message.json");
            rest2file.uploadFromByteArray(message.getBytes(),0,message.length());
        } catch ( Exception e)  {
        // Handle the exception
        }
        
    }
}
