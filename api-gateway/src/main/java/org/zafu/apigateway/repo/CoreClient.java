package org.zafu.apigateway.repo;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.PostExchange;
import org.zafu.apigateway.dto.ApiResponse;
import org.zafu.apigateway.dto.request.IntrospectRequest;
import org.zafu.apigateway.dto.response.IntrospectResponse;
import reactor.core.publisher.Mono;

@Repository
public interface CoreClient {
    @PostExchange(url = "/auth/introspect", contentType = MediaType.APPLICATION_JSON_VALUE)
    Mono<ApiResponse<IntrospectResponse>> introspect(@RequestBody IntrospectRequest request);
}
