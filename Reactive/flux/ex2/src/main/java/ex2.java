import utils.AsyncTester;

/**
 * This example shows how to apply Project Reactor features
 * asynchronously to perform various Flux operations, including
 * create(), interval(), map(), filter(), doOnNext(), take(),
 * subscribe(), then(), range(), subscribeOn(), publishOn(), and
 * various thread pools.
 */
public class ex2 {
    /**
     * Main entry point into the test program.
     */
    public static void main (String[] argv) {
        // Test a stream of random BigIntegers to determine which
        // values are prime using an asynchronous time-driven Flux
        // stream.
        AsyncTester.register(FluxEx::testIsPrimeTimed);

        // Test a stream of random BigIntegers to determine which
        // values are prime using an asynchronous Flux stream.
        AsyncTester.register(FluxEx::testIsPrimeAsync);

        @SuppressWarnings("ConstantConditions")
        long testCount = AsyncTester
            // Run all the tests.
            .runTests()

            // Block until all the tests are done to allow future
            // computations to complete running asynchronously.
            .block();

        // Print the results.
        System.out.println("Completed " + testCount + " tests");
    }
}
