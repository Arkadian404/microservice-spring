package org.zafu.apigateway.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.zafu.apigateway.dto.ApiResponse;
import org.zafu.apigateway.dto.request.IntrospectRequest;
import org.zafu.apigateway.dto.response.IntrospectResponse;
import org.zafu.apigateway.repo.CoreClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CoreService {
    CoreClient coreClient;

    public Mono<ApiResponse<IntrospectResponse>> introspect(String token){
        return coreClient.introspect(IntrospectRequest.builder().token(token).build());
    }

}
