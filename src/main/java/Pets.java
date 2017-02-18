
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.GetItemRequest;

public class Pets {

    public static void main(String[] args) throws InterruptedException {
        String tableName = "Pets";
        /*
        final AWSCredentialsProvider hoge = new EnvironmentVariableCredentialsProvider();
        AmazonDynamoDBAsync dynamoDB = new AmazonDynamoDBAsyncClient(hoge);
        dynamoDB.setRegion(Region.getRegion(Regions.AP_NORTHEAST_1));
        Future future = dynamoDB.describeTableAsync(new DescribeTableRequest().withTableName(tableName));
        while (!future.isDone()) {
            Thread.sleep(1000);
            // Do other processing while you're waiting for the response
        }

        try {
            DescribeTableResult result = (DescribeTableResult) future.get();
            System.out.println("Table: " + result.getTable());
        } catch (ExecutionException ee) {
            // Futures always wrap errors as an ExecutionException.
            // The *real* exception is stored as the cause of the ExecutionException
            Throwable exception = ee.getCause();
            System.out.println("Error describing table: " + exception.getMessage());
        }
        
        for(int i= 0; i<10; i++) {
            System.out.println(i);
        }
        HashMap<String,AttributeValue> key_to_get =
                new HashMap<String,AttributeValue>();
        key_to_get.put("store_id", new AttributeValue("KR00000"));

        
        
        GetItemRequest request = null;
            request = new GetItemRequest()
                .withKey(key_to_get)
                .withTableName(tableName);
*/
        final AWSCredentialsProvider hoge = new EnvironmentVariableCredentialsProvider();
        final AmazonDynamoDBClient ddb = new AmazonDynamoDBClient(hoge);
        ddb.setRegion(Region.getRegion(Regions.AP_NORTHEAST_1));

        DynamoDBMapper mapper = new DynamoDBMapper(ddb);
        PetsItem petItem = new PetsItem();
        PetsItem book = mapper.load(PetsItem.class, "KR00001");
//        petItem.setStoreId("KR00001");
//        petItem.setLastUpdDate("2017/01/26 22:02:34");
//        mapper.save(petItem);
        System.out.println("Book table has no sort key. You can do GetItem, but not Query.");

        /*
        try {
            Map<String,AttributeValue> returned_item =
               ddb.getItem(request).getItem();
            if (returned_item != null) {
                Set<String> keys = returned_item.keySet();
                for (String key : keys) {
                    System.out.format("%s: %s\n",
                            key, returned_item.get(key).toString());
                    System.out.println(returned_item.get(key).getS());
                    
                }
            } else {
                System.out.format("No item found with the key %s!\n", "KR00000");
            }
        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
            System.exit(1);
        }
*/
    }
        

}
