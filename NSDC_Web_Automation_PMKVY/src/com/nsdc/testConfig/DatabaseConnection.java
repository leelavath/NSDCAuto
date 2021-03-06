package com.nsdc.testConfig;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;

public class DatabaseConnection
{
    protected DatabaseConnection dbConnection;
    
    public static void deleteUserFromDB(String collectionName, String fieldName, String fieldValue)
    {
        try
        {      	
        	/*MongoCredential credential = MongoCredential.createCredential("SDMSTestUser", "ekaushalnsdc", "Sd04Ms#10^Te5#sT".toCharArray());
        	@SuppressWarnings({ "deprecation", "resource" })
			MongoClient mongo = new MongoClient(new ServerAddress("13.126.28.180", 27017), Arrays.asList(credential));*/
        	
        	@SuppressWarnings("deprecation")
			Mongo mongo = new Mongo("13.126.28.180", 27017);
        	
            @SuppressWarnings("deprecation")
            DB db = mongo.getDB("ekaushalnsdc");
            
            DBCollection collection = db.getCollection(collectionName);
            BasicDBObject query = new BasicDBObject();
            query.append(fieldName, fieldValue);
            collection.remove(query);
        }
        
        catch(Exception e)
        {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
    
    public static void deleteTrainingPartner(String fieldValue)
    {
        DatabaseConnection.deleteUserFromDB("users", "email", fieldValue);
        DatabaseConnection.deleteUserFromDB("trainingpartner", "email", fieldValue);
    }
    
    public static void deleteTrainer(String fieldValue)
    {
        DatabaseConnection.deleteUserFromDB("users", "email", fieldValue);
        DatabaseConnection.deleteUserFromDB("trainer", "email", fieldValue);
    }
    
    public static void deleteAssessor(String fieldValue)
    {
        DatabaseConnection.deleteUserFromDB("users", "email", fieldValue);
        DatabaseConnection.deleteUserFromDB("assessor", "email", fieldValue);
    }
    
    public static void deleteTrainingCentre(String fieldValue)
    {
        DatabaseConnection.deleteUserFromDB("users", "email", fieldValue);
        DatabaseConnection.deleteUserFromDB("trainingcentre", "spoc.email", fieldValue);
    }
    
    public static void deleteUsersCreatedByIA(String fieldValue)
    {
        DatabaseConnection.deleteUserFromDB("users", "email", fieldValue);
        DatabaseConnection.deleteUserFromDB("centreinspector", "email", fieldValue);
        DatabaseConnection.deleteUserFromDB("desktopassessor", "email", fieldValue);
        DatabaseConnection.deleteUserFromDB("qualitycontrol", "email", fieldValue);
    }
}

