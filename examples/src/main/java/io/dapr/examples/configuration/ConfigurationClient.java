package io.dapr.examples.configuration;

import io.dapr.client.DaprClient;
import io.dapr.client.DaprClientBuilder;
import io.dapr.client.domain.ConfigurationItem;
import io.dapr.client.domain.State;
import io.dapr.client.domain.TransactionalStateOperation;
import io.dapr.examples.state.StateClient;
import io.dapr.exceptions.DaprException;
import io.grpc.Status;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Client for Actor runtime.
 * 1. Build and install jars:
 * mvn clean install
 * 2. cd to [repo-root]/examples
 * 3. Run the client:
 * dapr run --components-path ./components/actors --app-id democonfigurationclient --app-port 3000 \
 *   -- java -jar target/dapr-java-sdk-examples-exec.jar io.dapr.examples.actors.DemoActorService -p 3000
 */
public class ConfigurationClient {

    public static void main(String[] args) throws Exception{
        try (DaprClient client = new DaprClientBuilder().build()) {
            System.out.println("Waiting for Dapr sidecar ...");
            client.waitForSidecar(10000).block();
            System.out.println("Dapr sidecar is ready.");

            String message = args.length == 0 ? " " : args[0];

            StateClient.MyClass myClass = new StateClient.MyClass();
            myClass.message = message;
            StateClient.MyClass secondState = new StateClient.MyClass();
            secondState.message = "test message";

            Mono<List<ConfigurationItem>> config = client.getConfiguration("example-config", new ArrayList<String>(Collections.singleton("mykey")), null);
            System.out.println("get config  from redis with key example-config" + config.toString());
        }
    }
}
