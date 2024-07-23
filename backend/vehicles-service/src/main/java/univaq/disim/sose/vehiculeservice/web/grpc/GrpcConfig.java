package univaq.disim.sose.vehiculeservice.web.grpc;

import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for setting up gRPC auto-configurations.
 * This class imports various gRPC auto-configuration classes to
 * ensure that the necessary gRPC functionalities are properly configured.
 */
@Configuration
@ImportAutoConfiguration({
        // Client-side configurations
        net.devh.boot.grpc.client.autoconfigure.GrpcClientAutoConfiguration.class, // Basic gRPC client configuration
        net.devh.boot.grpc.client.autoconfigure.GrpcClientMetricAutoConfiguration.class, // Client metrics for monitoring
        net.devh.boot.grpc.client.autoconfigure.GrpcClientHealthAutoConfiguration.class, // Client health checks
        net.devh.boot.grpc.client.autoconfigure.GrpcClientSecurityAutoConfiguration.class, // Client security configuration
        net.devh.boot.grpc.client.autoconfigure.GrpcClientTraceAutoConfiguration.class, // Client tracing for distributed tracing
        net.devh.boot.grpc.client.autoconfigure.GrpcDiscoveryClientAutoConfiguration.class, // Client service discovery

        // Common configurations
        net.devh.boot.grpc.common.autoconfigure.GrpcCommonCodecAutoConfiguration.class, // Codec configurations for serialization
        net.devh.boot.grpc.common.autoconfigure.GrpcCommonTraceAutoConfiguration.class, // Common tracing configuration

        // Server-side configurations
        net.devh.boot.grpc.server.autoconfigure.GrpcAdviceAutoConfiguration.class, // Advice for exception handling
        net.devh.boot.grpc.server.autoconfigure.GrpcHealthServiceAutoConfiguration.class, // Health service for server health checks
        net.devh.boot.grpc.server.autoconfigure.GrpcMetadataConsulConfiguration.class, // Metadata configuration for Consul
        net.devh.boot.grpc.server.autoconfigure.GrpcMetadataEurekaConfiguration.class, // Metadata configuration for Eureka
        net.devh.boot.grpc.server.autoconfigure.GrpcMetadataNacosConfiguration.class, // Metadata configuration for Nacos
        net.devh.boot.grpc.server.autoconfigure.GrpcMetadataZookeeperConfiguration.class, // Metadata configuration for Zookeeper
        net.devh.boot.grpc.server.autoconfigure.GrpcReflectionServiceAutoConfiguration.class, // Reflection service for gRPC server
        net.devh.boot.grpc.server.autoconfigure.GrpcServerAutoConfiguration.class, // Basic gRPC server configuration
        net.devh.boot.grpc.server.autoconfigure.GrpcServerFactoryAutoConfiguration.class, // Factory configuration for gRPC server
        net.devh.boot.grpc.server.autoconfigure.GrpcServerMetricAutoConfiguration.class, // Server metrics for monitoring
        net.devh.boot.grpc.server.autoconfigure.GrpcServerSecurityAutoConfiguration.class, // Server security configuration
        net.devh.boot.grpc.server.autoconfigure.GrpcServerTraceAutoConfiguration.class // Server tracing for distributed tracing
})
class GrpcConfig {}
