package com.streamlineideas.ecommerce.exception;

import com.streamlineideas.ecommerce.dto.ErrorDTO;
import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Resolves application exceptions into GraphQL errors with structured extensions.
 */
@Component
public class GraphQlExceptionResolver extends DataFetcherExceptionResolverAdapter {

    @Override
    protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
        if (ex instanceof InvalidPriceRangeException) {
            ErrorDTO error = ((InvalidPriceRangeException) ex).getError();
            return GraphqlErrorBuilder.newError(env)
                    .message(error != null ? error.getMessage() : "Invalid price range")
                    .extensions(Map.of("code", error != null ? error.getCode() : "INVALID_PRICE_RANGE", "message", error != null ? error.getMessage() : "minPrice must be less than or equal to maxPrice"))
                    .build();
        }
        return null;
    }
}
