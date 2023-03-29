package tfip.paf.day28.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class AppConfig {

    // @Value("${mongo.url}")
    // private String mongoUrl;

    // @Bean
    // public MongoTemplate createTemplate() {
    //     //mongoUrl = "mongodb://yehjintham:hzwzffx2@ac-bdwljq9-shard-00-00.uv2zpaq.mongodb.net:27017,ac-bdwljq9-shard-00-01.uv2zpaq.mongodb.net:27017,ac-bdwljq9-shard-00-02.uv2zpaq.mongodb.net:27017/?ssl=true&replicaSet=atlas-srygrq-shard-0&authSource=admin&retryWrites=true&w=majority";
    //     MongoClient client = MongoClients.create(mongoUrl);
    //     return new MongoTemplate(client, "shows");
    // }

}
