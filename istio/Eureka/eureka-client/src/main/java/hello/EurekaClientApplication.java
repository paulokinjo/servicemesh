package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

//@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClientApplication {

  public static void main(String[] args) {
    SpringApplication.run(EurekaClientApplication.class, args);
  }
}

@RestController
class ApplicationRestController {
  final  RestTemplate restTemplate;

  public ApplicationRestController(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  //@Autowired
  //private DiscoveryClient discoveryClient;

  @RequestMapping("/greeting/{user}")
  public String greeting(@PathVariable String user) {
//    try {
//      Thread.sleep(10000);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }

    return "Hello! " + user;
  }



  public String greet(String username) {
    URI uri = URI.create("http://A-BOOTIFUL-CLIENT/greeting/" + username);
    return this.restTemplate.getForObject(uri, String.class);
  }
/*
  @RequestMapping("/service-instances/{applicationName}")
  public List<ServiceInstance> serviceInstancesByApplicationName(
      @PathVariable String applicationName) {
    return this.discoveryClient.getInstances(applicationName);
  }*/

  @Bean
  @LoadBalanced
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }
}
