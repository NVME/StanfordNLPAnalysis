/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sentimentanalysis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luya
 */
public class Sentimentanalysis {

    private static final String DB_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String DB_CONNECTION = "jdbc:sqlserver://127.0.0.1:1433;databaseName=OLAPPrepLive";
    private static final String DB_USER = "Analytics";
    private static final String DB_PASSWORD = "@n@1yt1csProd";

    public static void main(String[] args) {
        // TODO code application logic here


        Message m = new Message();
        m.setContent("This was an awesome video!");
        NLP.init();
        NLP.findSentiment(m);
        List<Message> messages = GetMessages();
        List<SentimentDto> results = new ArrayList<SentimentDto>();
        NLP.init();
        for (Message msg : messages) {
            results.addAll(NLP.findSentiment(msg));
        }
        for (SentimentDto s : results) {
            //InsertSentimentResult(s);
        }
        System.out.println(" job finished");
    }

    public static void InsertSentimentResult(SentimentDto s) {

        PreparedStatement preparedStatement = null;

        String insertTableSQL = "insert into [dbo].[tblBlogCommentSentimentNLP] "
                + "(BlogCommentId,Sentence,Score,Sentiment,VeryNegative,Negative,Neutral,Positive,VeryPositive) VALUES"
                + "(?,?,?,?,?,?,?,?,?)";
        try {

            Connection connection = getDBConnection();
            preparedStatement = connection.prepareStatement(insertTableSQL);

            preparedStatement.setInt(1, s.getMessageId());
            preparedStatement.setString(2, s.getSentence());
            preparedStatement.setDouble(3, s.getScore());
            preparedStatement.setString(4, s.getSentiment());
            preparedStatement.setDouble(5, s.getVeryNegative());
            preparedStatement.setDouble(6, s.getNegative());
            preparedStatement.setDouble(7, s.getNeutral());
            preparedStatement.setDouble(8, s.getPositive());
            preparedStatement.setDouble(9, s.getVeryPositive());

            // execute insert SQL stetement
            preparedStatement.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Message> GetMessages() {

        List<Message> messages = new ArrayList<Message>();

        try {


            Connection connection = getDBConnection();
            Statement statement = connection.createStatement();
            String query = "select * from [dbo].[tblBlogComments]";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Message msg = new Message();
                msg.MessageId = rs.getInt("BlogCommentId");
                msg.Content = rs.getString("CommentText");
                messages.add(msg);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return messages;
    }

    private static Connection getDBConnection() {

        Connection dbConnection = null;

        try {

            Class.forName(DB_DRIVER);

        } catch (ClassNotFoundException e) {

            System.out.println(e.getMessage());

        }

        try {

            dbConnection = DriverManager.getConnection(
                    DB_CONNECTION, DB_USER, DB_PASSWORD);
            return dbConnection;

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return dbConnection;

    }
}
