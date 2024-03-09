package com.crm.qa.listeners;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.ArrayList;
import java.util.List;

public class MongoDBListener implements ITestListener {

    MongoCollection<Document> webCollection;
    MongoClient mongoClient;
    @Override
    public void onTestStart(ITestResult result) {
        mongoClient = MongoClients.create("mongodb://127.0.0.1:27017");
        MongoDatabase database = mongoClient.getDatabase("automation");
        webCollection = database.getCollection("testResults");
    }
    @Override
    public void onTestSuccess(ITestResult result)
    {
        String methodName = result.getMethod().getMethodName();
        String className = result.getMethod().getClass().getName();

        Document d1 = new Document();
        d1.append("methodName",methodName);
        d1.append("className",className);
        d1.append("status","PASS");

        List<Document> docsList = new ArrayList<>();
        docsList.add(d1);

        webCollection.insertMany(docsList);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        String className = result.getMethod().getClass().getName();

        Document d1 = new Document();
        d1.append("methodName",methodName);
        d1.append("className",className);
        d1.append("status","FAIL ");

        List<Document> docsList = new ArrayList<>();
        docsList.add(d1);

        webCollection.insertMany(docsList);
    }

    @Override
    public void onFinish(ITestContext context) {
        mongoClient.close();
    }
}
