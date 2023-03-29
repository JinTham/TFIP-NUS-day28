package tfip.paf.day28.Repositories;

import java.util.LinkedList;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.stereotype.Repository;

import tfip.paf.day28.Models.Airbnb;

@Repository
public class AirbnbRepository {

    public static final String C_AIRBNB = "airbnb";
    
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Airbnb> getAirbnbByDesc (String text, String country) {
        // TextCriteria textCriteria= TextCriteria.forDefaultLanguage().matchingAny(text);
        // TextQuery query = TextQuery.queryText(textCriteria)
        //     .sortByScore()
        //     .includeScore("score");
        // List<Document> results = mongoTemplate.find(query, Document.class,C_AIRBNB);
        // return results.stream()
        //     .map(doc -> doc.toJson())
        //     .map(Airbnb::toAirbnb)
        //     .toList();

        // stages
        String[] terms = text.split(" ");
        MatchOperation searchByDescription = Aggregation.match(TextCriteria.forDefaultLanguage().matchingAny(terms));
        MatchOperation filterCountry = Aggregation.match(Criteria.where("address.country").is(country));
        ProjectionOperation propertyName = Aggregation.project("name","listing_url","summary","description","address").andExclude("_id");
        SortOperation orderByName = Aggregation.sort(Sort.by(Direction.ASC,"name"));
        // pipeline
        Aggregation pipeline = Aggregation.newAggregation(searchByDescription,filterCountry,propertyName,orderByName);
        // query
        AggregationResults<Document> results = mongoTemplate.aggregate(pipeline,"airbnb",Document.class);

        List<Airbnb> airbnbList = new LinkedList<>();
        for (Document doc : results) {
            airbnbList.add(Airbnb.toAirbnb(doc.toJson()));
        }
        return airbnbList;
    }

    public List<String> getCountries() {
        return mongoTemplate.findDistinct(
            new Query(), "address.country","airbnb",String.class);
    }

}
