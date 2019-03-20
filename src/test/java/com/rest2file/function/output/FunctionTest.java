package com.rest2file.function.output;

import org.junit.Test;

import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.ServiceBusQueueOutput;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;


/**
 * Unit test for Function class.
 */
public class FunctionTest {
    /**
     * Unit test for SBTriggerJava method.
     */
    @Test
    public void testSBTriggerJava() throws Exception {
        // Setup
        // @SuppressWarnings("unchecked");
        // assertEquals(ret.getStatus(), HttpStatus.OK);
    }
}
