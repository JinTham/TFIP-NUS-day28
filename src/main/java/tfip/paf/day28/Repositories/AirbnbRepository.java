package tfip.paf.day28.Repositories;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.core.query.TextQuery;
import org.springframework.stereotype.Repository;

import tfip.paf.day28.Models.Airbnb;

@Repository
public class AirbnbRepository {

    public static final String C_AIRBNB = "airbnb";
    
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Airbnb> getAirbnbByDesc (String text) {
        // List<String> matches = new LinkedList<>();
        // for (String word: text.split(",")) {
        //     matches.add(word.trim());
        // }
        TextCriteria textCriteria= TextCriteria.forDefaultLanguage().matchingAny(text);
        TextQuery query = TextQuery.queryText(textCriteria)
            .sortByScore()
            .includeScore("score");
        List<Document> results = mongoTemplate.find(query, Document.class,C_AIRBNB);
        return results.stream()
            .map(doc -> doc.toJson())
            .map(Airbnb::toAirbnb)
            .toList();
    }

}
