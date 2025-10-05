package com.example.msvcclients.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.loadbalancer.core.RoundRobinLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.SimpleObjectProvider;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.DefaultServiceInstance;
import java.util.List;
import java.util.Arrays;

@Configuration
@LoadBalancerClient(name = "msvc-users", configuration = FeignConfig.class)
public class FeignConfig {
    @Bean
    public ServiceInstanceListSupplier serviceInstanceListSupplier() {
        return new ServiceInstanceListSupplier() {
            @Override
            public String getServiceId() {
                return "msvc-users";
            }
            @Override
            public reactor.core.publisher.Flux<List<ServiceInstance>> get() {
                List<ServiceInstance> instances = Arrays.asList(
                    new DefaultServiceInstance("msvc-users1", "msvc-users", "localhost", 8001, false),
                    new DefaultServiceInstance("msvc-users2", "msvc-users", "localhost", 8002, false)
                );
                return reactor.core.publisher.Flux.just(instances);
            }
        };
    }
    @Bean
    public RoundRobinLoadBalancer roundRobinLoadBalancer(ServiceInstanceListSupplier supplier) {
        return new RoundRobinLoadBalancer(new SimpleObjectProvider<>(supplier), "msvc-users");
    }
}