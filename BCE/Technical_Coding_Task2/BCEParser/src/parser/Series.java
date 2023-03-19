package parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
//import java.sql.*;
import java.util.Scanner;
import java.util.Set;


public class Series {

    public static void parseTxtDataInto2Tables() throws SQLException {
        StringBuilder sqlDataEpisode = new StringBuilder("INSERT INTO public.\"EPISODE\" (\"EP_ID\", \"SERIES_YEAR\", \"SERIES_NAME\", \"EPISODE_NAME\", \"EPISODE_AIR_DATE_YEAR\", \"SEASON_EPISODE_NUMBER\", \"SUSPENDED_FLAG\") VALUES ");
        try (BufferedReader br = new BufferedReader(new FileReader("src/testfirsttwi.txt"))) {
            String line;
            int global_line_counter = 0;
            int ep_id = 0;
            int id = 0;
            while ((line = br.readLine()) != null) {
                global_line_counter++;
                if (global_line_counter > 5) { // skip descriptor
                    String year = line.substring(0, 4);
                    int epiSeasonYear = 0;
                    if (!year.contains("?")) {
                        epiSeasonYear = Integer.valueOf(year);
                    }
                    //System.out.print(epiSeasonYear+" ");
                    String seriesName = line.substring(6, line.length());
                    int secondQuoteOccurance = seriesName.indexOf("\"");
                    String seriesEpisodeName = seriesName.substring(0,secondQuoteOccurance);
                    //System.out.print(seriesEpisodeName+" ");
                    int thirdDataStartIndex = 6+seriesEpisodeName.length()+2;
                    String thirdData = line.substring(thirdDataStartIndex, line.length());
                    int secondBrkOccurance = 0;
                    String aPhraseToParseByFigBrk = thirdData.substring(1,thirdData.length());
                    if (thirdData.charAt(0) == '{') { // episode table case
                        secondBrkOccurance = aPhraseToParseByFigBrk.indexOf("}");
                        aPhraseToParseByFigBrk = thirdData.substring(1,secondBrkOccurance);
                        String[] dataStr = aPhraseToParseByFigBrk.split("\\(");
                        String episodeName = dataStr[0].trim();
                        String episodeSeriesYear = dataStr[1].substring(0,4);
                        int episodeSeriesYearint = 0;
                        if (!episodeSeriesYear.contains("?")) {
                            episodeSeriesYearint = Integer.valueOf(episodeSeriesYear);
                        }
                        String episodeSeriesNumber = dataStr[2].trim();
                        //System.out.print(episodeName+ " "+episodeSeriesYear+" "+episodeSeriesNumber);
                        boolean flagSuspendedEpisode = thirdData.substring(secondBrkOccurance+3,thirdData.length()).toUpperCase().contains("SUSPENDED");
                        //System.out.println(flagSuspendedEpisode);
                        Database database = new Database();
                        ep_id++;
                        //database.createEpisodeItem(database, ep_id, epiSeasonYear, seriesEpisodeName, episodeName, episodeSeriesYearint, episodeSeriesNumber, flagSuspendedEpisode);
                        sqlDataEpisode.append ("(" + ep_id + 
                                "," + epiSeasonYear + "" +  
                                ",'" + seriesEpisodeName + "'" +
                                ",'" + episodeName + "'" +
                                "," + episodeSeriesYearint + "" +
                                "," + flagSuspendedEpisode + "" +
                                ")") ;
                    }
                    else { // series case
                        secondBrkOccurance = aPhraseToParseByFigBrk.indexOf("]");
                        String flagExpectedSeriesStr = thirdData.substring(1,secondBrkOccurance+2);
                        boolean flagExpectedSeries =  flagExpectedSeriesStr.toUpperCase().contains("SUSPENDED");
                        //System.out.print(flagExpectedSeries+" ");
                        String periodYearStrAsAreWithBrkts = thirdData.substring(secondBrkOccurance+3,thirdData.length());
                        //System.out.println(periodYearStrAsAreWithBrkts);
                        //Database database = new Database();
                        id++;
                        //database.createSeriesItem(database,id,epiSeasonYear,seriesEpisodeName,flagExpectedSeries,periodYearStrAsAreWithBrkts);
                    }
                }
            }
            
        }
        catch (IOException e) {
            System.out.println(e);
        }
        Database database = new Database();
        Connection c = database.connect();
        Statement stmt = c.createStatement();
        stmt = c.createStatement();
        stmt.executeUpdate(sqlDataEpisode.toString());
        stmt.close();
        c.commit();
        c.close();
    }
    
    public static void main(String[] args) throws SQLException {
        parseTxtDataInto2Tables();
        System.out.println("Parsing accomplished");
    }

}
