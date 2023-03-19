package parser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

private final String url = "jdbc:postgresql://2.57.174.47:5544/candidate_2";
private final String user = "candidate_2";
private final String password = "i13sb41t9ry29q7bfpf90kfv66ie6bq8";

public Connection connect() {
    Connection conn = null;
    try {
        conn = DriverManager.getConnection(url, user, password);
        //System.out.println("Connected to the PostgreSQL server successfully.");
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }

    return conn;
}

public void createSeriesItem(Database db, int iD, int seriesYear, String seriesName, boolean suspendedFLAG, String seriesDateRange) {
    try {
        PreparedStatement st = db.connect().prepareStatement("INSERT INTO public.\"SERIES\" (\"ID\", \"SERIES_YEAR\", \"SERIES_NAME\", \"SUSPENDED_FLAG\", \"SERIES_DATE_RANGE\") VALUES (?, ?, ?, ?, ?)");
        st.setInt(1, iD);
        st.setInt(2, seriesYear);
        st.setString(3, seriesName);
        st.setBoolean(4, suspendedFLAG);
        st.setString(5, seriesDateRange);
        st.executeUpdate();
        st.close();
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}

public void createEpisodeItem(Database db, int ep_ID, int seriesYear, String seriesName, String episodeName,int episodeAirDateYear, String seasonEpisodeNumber, boolean suspendedFLAG) {
    try {
        PreparedStatement st = db.connect().prepareStatement("INSERT INTO public.\"EPISODE\" (\"EP_ID\", \"SERIES_YEAR\", \"SERIES_NAME\", \"EPISODE_NAME\", \"EPISODE_AIR_DATE_YEAR\", \"SEASON_EPISODE_NUMBER\", \"SUSPENDED_FLAG\") VALUES (?, ?, ?, ?, ?, ?, ?)");
        st.setInt(1, ep_ID);
        st.setInt(2, seriesYear);
        st.setString(3, seriesName);
        st.setString(4, episodeName);
        st.setInt(5, episodeAirDateYear);
        st.setString(6, seasonEpisodeNumber);
        st.setBoolean(7, suspendedFLAG);
        st.executeUpdate();
        st.close();
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}

    public static void main(String[] args) {
        Database database = new Database();
        database.createSeriesItem(database,4,1981,"TEST",true,"TESTRANGE");
        //database.createEpisodeItem(database, 2, 3222, "EPIFTESTFFF", "EPFFIFTESTFFF", 3333, "21.2.3", false);
        
        //Task task = new Task("'Test2'", "'Test2 description'", "1998-01-07");
        //database.createItem(2, task.getTitle(), task.getDescription(), task.getDateFormat());
        //database.
    }

}