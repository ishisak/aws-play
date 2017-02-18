import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="Pets")
public class PetsItem {
    private String storeId;
    private String lastUpdDate;
    
    @DynamoDBHashKey(attributeName="store_id")
    public String getStoreId() { return storeId;}
    public void setStoreId(String storeId) { this.storeId = storeId;}
    
    @DynamoDBAttribute(attributeName="lastUpdDate")  
    public String getLastUpdDate() { return lastUpdDate; }
    public void setLastUpdDate(String lastUpdDate) { this.lastUpdDate = lastUpdDate; }
}
