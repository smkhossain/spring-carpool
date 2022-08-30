package util.exceptions;

import java.net.URI;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

public class CustomerNotFoundException extends AbstractThrowableProblem {

    private static final URI TYPE = URI.create("https://example.org/not-found");

    public CustomerNotFoundException(Long customerId) {
        super(TYPE, "Not found", Status.NOT_FOUND, String.format("Customer '%s' not found", customerId));
    }

}

